package net.chintai.backend.sysadmin.dataoutput.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.common.util.CsvException;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.common.util.UploadUtil;
import net.chintai.backend.sysadmin.dataoutput.action.view.ShopSkipSettingView;
import net.chintai.backend.sysadmin.dataoutput.service.ShopSkipSettingService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShopSkipSettingUploadInServiceBean;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_bukken.action.ShopUploadAction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;
import org.springframework.context.ApplicationContext;

/**
 * 店舗別除外設定アップロードAction
 * @author watanabe
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */

public class ShopSkipSettingUploadAction extends BaseActionSupport{
	/** ログインスタンス */
	private static Log log = LogFactory.getLog(ShopUploadAction.class);


	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
	 */
	@Override
	protected void doExecute(BusinessContext context) throws Exception {

		// 画面のデータ取得
		ShopSkipSettingUploadInServiceBean inServiceBean = new ShopSkipSettingUploadInServiceBean();
		DynaActionForm form = (DynaActionForm) context.getForm();
		BeanUtilsWrapper.copyProperties(inServiceBean, form);
		FormFile formFile = (FormFile) form.get("uploadFile");
		String acceptFlg = (String) form.get("acceptFlg");

		ShopSkipSettingView view = new ShopSkipSettingView();
		BeanUtilsWrapper.copyProperties(view, form);

		// Injection
		ApplicationContext ac = getWebApplicationContext();

		OperationLoggingService loggingService = (OperationLoggingService) ac.getBean("operationLoggingService");
		String userId = context.getSessionBean().getUserId();

		int fileSize = formFile.getFileSize();
		int fileMaxSize = Integer.parseInt(ApplicationResources.getProperty("dataoutput.fileMaxSize"));

		// CSVファイルチェック
		// 対象の連携先のデータ全件削除を承諾済みの場合は飛ばす
		List<String[]> uplist = new ArrayList<String[]>();
		if (!acceptFlg.equals("1")) {
			if (fileSize == 0) {
				loggingService.write("19006", userId, SessionStatus.FAILURE, "", this.getClass().getName());
				context.setError("WARN.M.DATAOUTPUT.0012", ApplicationResources.getProperty("dataoutput.CSV"), ApplicationResources
						.getProperty("dataoutput.CSV"));
				context.setForward("failure", view);
				return;
			}

			if (fileSize > fileMaxSize) {
				loggingService.write("19006", userId, SessionStatus.FAILURE, "", this.getClass().getName());
				context.setError("ERROR.M.DATAOUTPUT.0004", ApplicationResources.getProperty("dataoutput.uploadFileSize"));
				context.setForward("failure", view);
				return;
			}

			if (!ApplicationResources.getProperty("dataoutput.uploadFileExtensions")
					.equals(formFile.getFileName().replaceAll("^.*?([^\\.]+$)", "$1").toUpperCase())){
				loggingService.write("19006", userId, SessionStatus.FAILURE, "", this.getClass().getName());
				context.setError("WARN.M.DATAOUTPUT.0013", ApplicationResources.getProperty("dataoutput.upload"),
						ApplicationResources.getProperty("dataoutput.uploadFileExtensions"), ApplicationResources
						.getProperty("dataoutput.file"));
				context.setForward("failure", view);
				return;
			}

			try {
				InputStream in = formFile.getInputStream();
				CsvStatusBean csvStatusBean = new CsvStatusBean();
				csvStatusBean.setFileName(formFile.getFileName());
				csvStatusBean.setIgnoreStartLine(true);
				uplist = UploadUtil.uploadCsv(in, csvStatusBean);
			} catch (CsvException ce) {
				loggingService.write("19006", userId, SessionStatus.FAILURE, "", this.getClass().getName());
				String errorId = "ERROR.MSG.0004";
				log.error(errorId, ce);
				context.setError(errorId);
				context.setForward("failure", view);
				return;
			} catch (IOException e) {
				loggingService.write("19006", userId, SessionStatus.FAILURE, "", this.getClass().getName());
				String errorId = "ERROR.MSG.0004";
				log.error(errorId, e);
				context.setError(errorId);
				context.setForward("failure", view);
				return;
			}

			if (uplist.size() == 0) {
				context.getRequest().setAttribute("acceptFlg", "0");;
				context.setForward("success", view);
				return;
			}
		}

		//サービス取得
		inServiceBean.setUploadList(uplist);
		inServiceBean.setUserId(userId);
		inServiceBean.setPgName(this.getClass().getName());

		ShopSkipSettingService shopSkipSettingService =
				(ShopSkipSettingService) ac.getBean("shopSkipSettingService");

		try {
			shopSkipSettingService.commitShopSkipSetting(inServiceBean);

			// 成功:操作ログ記録
			loggingService.write("19006", userId, SessionStatus.SUCCESS, "", this.getClass().getName());
			context.setMessage("INFO.M.DATAOUTPUT.0002", ApplicationResources.getProperty("dataoutput.maintenance"));
			context.setForward("success");

		} catch (ApplicationException e) {
			loggingService.write("19006", userId, SessionStatus.FAILURE, "", this.getClass().getName());
			log.error(e.getErrorId(), e);
			context.setError(e.getErrorId(), e.getPlaceHolders());
			context.setForward("failure", view);
		}

	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
	 */
	@Override
	protected boolean isAuthorized(String userId) {
		ApplicationContext ac = getWebApplicationContext();
		AuthService auth = (AuthService) ac.getBean("authService");
		return auth.authenticate(userId, AuthorityId.DATA_OUTPUT);
	}


}

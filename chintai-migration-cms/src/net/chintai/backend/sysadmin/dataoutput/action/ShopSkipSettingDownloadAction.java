package net.chintai.backend.sysadmin.dataoutput.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.CsvException;
import net.chintai.backend.sysadmin.common.util.CsvExportUtil;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.dataoutput.action.view.ShopSkipSettingView;
import net.chintai.backend.sysadmin.dataoutput.service.ShopSkipSettingService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShopSkipSettingDownloadInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShopSkipSettingDownloadOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 店舗別除外設定ダウンロードAction
 * @author watanabe
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSkipSettingDownloadAction extends BaseActionSupport {


	/** ログインスタンス */
	private static Log log = LogFactory.getLog(ShopSkipSettingDownloadAction.class);

	/*
	 * (非 Javadoc)
	 *
	 * @see
	 * net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai
	 * .backend.sysadmin.common.BusinessContext)
	 */
	@Override
	protected void doExecute(BusinessContext context) throws Exception {

		// 画面データの取得
		DynaValidatorForm form = (DynaValidatorForm) context.getForm();
		ShopSkipSettingDownloadInServiceBean inServiceBean =
				new ShopSkipSettingDownloadInServiceBean();
		BeanUtils.copyProperties(inServiceBean, form);

		// 取得した検索条件とページング状態をViewHelperにセットする。
		ShopSkipSettingView view = new ShopSkipSettingView();
		BeanUtils.copyProperties(view, form);

		// Injection
		ApplicationContext ac = getWebApplicationContext();

		// Service呼び出し
		ShopSkipSettingService service =
				(ShopSkipSettingService) ac.getBean("shopSkipSettingService");

		ShopSkipSettingDownloadOutServiceBean outList = new ShopSkipSettingDownloadOutServiceBean();
		outList = service.selectShopSkipSetting(inServiceBean);

		// csvデータ取得
		if (outList.getDownloadList().size() > 0) {

			// csv出力に必要な情報をstatusBeanに設定
			CsvStatusBean csvStatusBean = new CsvStatusBean();
			csvStatusBean.setFileName(this.getCsvFileName(inServiceBean.getDcoType()));
			csvStatusBean.setResponse(context.getResponse());

			try {
				// ダウンロード処理
				CsvExportUtil.export(csvStatusBean, outList.getDownloadList());
			} catch (CsvException e) {
				String errorId = "ERROR.M.DATAOUTPUT.0005";
				log.error(errorId, e);
				context.setError(errorId);
				context.setForward("failure", view);
			}

		} else {
			context.setError("WARN.M.DATAOUTPUT.0014");
			context.setForward("failure", view);
		}

	}

	/*
	 * (非 Javadoc)
	 *
	 * @see
	 * net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java
	 * .lang.String)
	 */
	@Override
	protected boolean isAuthorized(String userId) {
		ApplicationContext ac = getWebApplicationContext();
		AuthService auth = (AuthService) ac.getBean("authService");
		return auth.authenticate(userId, AuthorityId.DATA_OUTPUT);
	}

	/**
	 * CSVファイル名を取得
	 * @param dcoType 
	 * @return CSVファイル名
	 */
	private String getCsvFileName(String dcoType) {
		String date = DateUtil.getToday();
		String fileName  = SystemProperties.getProperty("DataRenkeiSkipShop.Filename");
		String[] dcoEnNames = SystemProperties.getProperty("SHOP_DCO_TYPE_EN_NAME").split(",");
		String ck1 = "\\{0\\}";
		String ck2 = "\\{1\\}";
		fileName = fileName.replaceAll(ck1, dcoEnNames[Integer.parseInt(dcoType) - 1]);
		fileName = fileName.replaceAll(ck2, date);

		return fileName;
	}
}

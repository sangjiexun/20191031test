/*
 * $Id: ContractAmountMaintenanceUploadAction.java 4653 2013-10-09 08:11:42Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.CsvException;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopBukkenUploadService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopBukkenUploadInServiceBean;
import net.chintai.batch.support.ppc.PpcException;


/**
 * CSVアップロードアクション
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopUploadAction extends BaseActionSupport {

    /** ログインスタンス */
    private static Log log = LogFactory.getLog(ShopUploadAction.class);


    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {
/*
    	if (!isTokenValid(context.getRequest())) {
            context.setForward("success");
            return;
        }
        resetToken(context.getRequest());
*/
        DynaActionForm form = (DynaActionForm) context.getForm();
        FormFile formFile = (FormFile) form.get("uploadFile");

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        OperationLoggingService loggingService = (OperationLoggingService) ac.getBean("operationLoggingService");
        String operUserId = context.getSessionBean().getUserId();

        int fileSize = formFile.getFileSize();
        int fileMaxSize = Integer.parseInt(ApplicationResources.getProperty("shop_bukken.fileMaxSize"));

        // CSVファイルチェック
        if (fileSize == 0) {
            loggingService.write("01022", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("WARN.M.DEMAND.0005", ApplicationResources.getProperty("shop_bukken.CSV"), ApplicationResources
                    .getProperty("shop_bukken.CSV"));
            context.setForward("failure");
            return;
        }

        if (fileSize > fileMaxSize) {
            loggingService.write("01022", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("ERROR.M.DEMAND.0003", ApplicationResources.getProperty("shop_bukken.uploadFileSize"));
            context.setForward("failure");
            return;
        }

        if (!ShopBukkenCsvUploadUtil.validateFileSuffix(formFile.getFileName())) {
            loggingService.write("01022", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("WARN.M.DEMAND.0006", ApplicationResources.getProperty("shop_bukken.upload"),
                    ApplicationResources.getProperty("shop_bukken.uploadFileExtensions"), ApplicationResources
                            .getProperty("shop_bukken.file"));
            context.setForward("failure");
            return;
        }

        List<String[]> uplist;
        try {
            uplist = ShopBukkenCsvUploadUtil.uploadCsv(formFile);

        } catch (CsvException ce) {
            loggingService.write("01022", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            String errorId = "ERROR.MSG.0004";
            log.error(errorId, ce);
            context.setError(errorId);
            context.setForward("failure");
            return;
        } catch (IOException e) {
            loggingService.write("01022", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            String errorId = "ERROR.MSG.0004";
            log.error(errorId, e);
            context.setError(errorId);
            context.setForward("failure");
            return;
        }

        // DB登録処理
        ShopBukkenUploadInServiceBean inServiceBean = new ShopBukkenUploadInServiceBean();
        inServiceBean.setUploadList(uplist);
        inServiceBean.setOperUserId(operUserId);
        inServiceBean.setPgName(this.getClass().getName());

        ShopBukkenUploadService shopBukkenUploadService =
                (ShopBukkenUploadService) ac.getBean("ShopBukkenUploadService");

        try {
        	shopBukkenUploadService.shopBukkenUploadCommit(inServiceBean);

            // 成功:操作ログ記録
            loggingService.write("01022", operUserId, SessionStatus.SUCCESS, "", this.getClass().getName());
            context.setMessage("INFO.M.DEMAND.0002", ApplicationResources.getProperty("shop_bukken.maintenance"));
            context.setForward("success");

            // アップロード処理中におきた異常をここでcatchし、エラーメッセージを画面に出力します。
        } catch (PpcException e) {
            loggingService.write("01022", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            log.error(e);
            context.setError("INFO.M.SHOP_BUKKEN.0031");
            context.setForward("failure");

        } catch (ApplicationException e) {
            loggingService.write("01022", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            log.error(e.getErrorId(), e);
            context.setError(e.getErrorId(), e.getPlaceHolders());
            context.setForward("failure");

        }

    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }


}

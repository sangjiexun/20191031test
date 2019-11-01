/*
 * $Id: TorihikisakiWakuMaintenanceUploadAction.java 4653 2013-10-09 08:11:42Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/09/30     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

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
import net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuMaintenanceUploadService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuMaintenanceUploadInServiceBean;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;


/**
 * 物件枠数・物件リスティング枠数のCSVアップロードアクション
 * @author KAMEDA Takuma
 * @version $Revision: 4653 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuMaintenanceUploadAction extends BaseActionSupport {

    /** ログインスタンス */
    private static Log log = LogFactory.getLog(TorihikisakiWakuMaintenanceUploadAction.class);


    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        DynaActionForm form = (DynaActionForm) context.getForm();
        FormFile formFile = (FormFile) form.get("uploadFile");

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        OperationLoggingService loggingService = (OperationLoggingService) ac.getBean("operationLoggingService");
        String operUserId = context.getSessionBean().getUserId();

        int fileSize = formFile.getFileSize();
        int fileMaxSize = Integer.parseInt(ApplicationResources.getProperty("demand.fileMaxSize"));

        // CSVファイルチェック
        if (fileSize == 0) {
            loggingService.write("11011", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("WARN.M.DEMAND.0137", ApplicationResources.getProperty("demand.CSV"), ApplicationResources
                    .getProperty("demand.CSV"));
            context.setForward("failure");
            return;
        }

        if (fileSize > fileMaxSize) {
            loggingService.write("11011", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("ERROR.M.DEMAND.0146", ApplicationResources.getProperty("demand.uploadFileSize"));
            context.setForward("failure");
            return;
        }

        if (!DemandCsvUploadUtil.validateFileSuffix(formFile.getFileName())) {
            loggingService.write("11011", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("WARN.M.DEMAND.0138", ApplicationResources.getProperty("demand.upload"),
                    ApplicationResources.getProperty("demand.uploadFileExtensions"), ApplicationResources
                            .getProperty("demand.file"));
            context.setForward("failure");
            return;
        }

        List<String[]> uplist;
        try {
            uplist = DemandCsvUploadUtil.uploadCsv(formFile);

        } catch (CsvException ce) {
            loggingService.write("11011", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            String errorId = "ERROR.M.DEMAND.0145";
            log.error(errorId, ce);
            context.setError(errorId);
            context.setForward("failure");
            return;
        } catch (IOException e) {
            loggingService.write("11011", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            String errorId = "ERROR.M.DEMAND.0145";
            log.error(errorId, e);
            context.setError(errorId);
            context.setForward("failure");
            return;
        }

        // DB登録処理
        TorihikisakiWakuMaintenanceUploadInServiceBean inServiceBean = new TorihikisakiWakuMaintenanceUploadInServiceBean();
        inServiceBean.setUploadList(uplist);
        inServiceBean.setOperUserId(operUserId);
        inServiceBean.setPgName(this.getClass().getName());

        TorihikisakiWakuMaintenanceUploadService torihikisakiWakuMaintenanceUploadService =
                (TorihikisakiWakuMaintenanceUploadService) ac.getBean("TorihikisakiWakuMaintenanceUploadService");

        try {
            torihikisakiWakuMaintenanceUploadService.torihikisakiWakuMaintenanceUploadCommit(inServiceBean);

            // 成功:操作ログ記録
            loggingService.write("11011", operUserId, SessionStatus.SUCCESS, "", this.getClass().getName());
            context.setMessage("INFO.M.DEMAND.0134", ApplicationResources.getProperty("demand.maintenance"));
            context.setForward("success");

            // アップロード処理中におきた異常をここでcatchし、エラーメッセージを画面に出力します。
        } catch (ApplicationException e) {
            loggingService.write("11011", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
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

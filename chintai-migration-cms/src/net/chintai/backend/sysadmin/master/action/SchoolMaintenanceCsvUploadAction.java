package net.chintai.backend.sysadmin.master.action;

import java.io.IOException;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.CsvException;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.master.service.SchoolMaintenanceService;
import net.chintai.backend.sysadmin.master.service.bean.SchoolMaintenanceInServiceBean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;



/**
 * 大学マスタメンテナンスアクション(CSV ファイルのアップロード)
 * @author e-ishii
 * @version $Revision: 4469 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class SchoolMaintenanceCsvUploadAction extends BaseActionSupport {

    /** ログインスタンス */
    private static Log log = LogFactory.getLog(SchoolMaintenanceCsvUploadAction.class);

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        if (!isTokenValid(context.getRequest())) {
            context.setForward("success");
            return;
        }
        resetToken(context.getRequest());


        DynaActionForm form = (DynaActionForm) context.getForm();
        FormFile formFile = (FormFile) form.get("fileUp");

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        OperationLoggingService loggingService = (OperationLoggingService) ac.getBean("operationLoggingService");
        String operUserId = context.getSessionBean().getUserId();

        int fileSize = formFile.getFileSize();
        int fileMaxSize = Integer.parseInt(ApplicationResources.getProperty("master.fileMaxSize"));

        if (fileSize == 0) {
            loggingService.write("08004", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("WARN.M.MASTER.0045",
                    ApplicationResources.getProperty("master.CSV"),
                    ApplicationResources.getProperty("master.CSV"));
            context.setForward("failure");
            return;
        }

        if (fileSize > fileMaxSize) {
            loggingService.write("08004", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("ERROR.M.MASTER.0018",
                    ApplicationResources.getProperty("master.uploadFileSize"));
            context.setForward("failure");
            return;
        }

        if (!MasterCsvUploadUtil.validateFileSuffix(formFile.getFileName())) {
            loggingService.write("08004", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("WARN.M.MASTER.0046",
                    ApplicationResources.getProperty("master.upload"),
                    ApplicationResources.getProperty("master.uploadFileExtensions"),
                    ApplicationResources.getProperty("master.file"));
            context.setForward("failure");
            return;
        }

        List<String[]> uplist;
        try {
            uplist = MasterCsvUploadUtil.uploadCsv(formFile);

        } catch (CsvException ce) {
            loggingService.write("08004", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("ERROR.M.MASTER.0019");
            context.setForward("failure");
            return;

        } catch (IOException e) {
            loggingService.write("08004", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("ERROR.M.MASTER.0019");
            context.setForward("failure");
            return;
        }

        SchoolMaintenanceService service = (SchoolMaintenanceService) ac.getBean("schoolMaintenanceService");

        SchoolMaintenanceInServiceBean inServiceBean = new SchoolMaintenanceInServiceBean();
        inServiceBean.setUploadList(uplist);
        inServiceBean.setOperUserId(operUserId);
        inServiceBean.setPgName(this.getClass().getName());

        try {
            // DBに投入
            service.schoolCsvUpload(inServiceBean);

            // 成功:操作ログ記録
            loggingService.write("08004", operUserId, SessionStatus.SUCCESS, "", this.getClass().getName());
            context.setMessage("INFO.M.MASTER.0009", ApplicationResources.getProperty("master.schoolMaintenanceData"));
            context.setForward("success");

        } catch (ApplicationException e) {
            loggingService.write("08004", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            log.error(e.getErrorId(), e);
            context.setError(e.getErrorId(), e.getPlaceHolders());
            context.setForward("failure");

        } catch (DataAccessException dae) {
            loggingService.write("08004", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            log.error(dae.getMessage(), dae);
            context.setError("ERROR.M.MASTER.0020");
            context.setForward("failure");
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.MASTER);
    }

}

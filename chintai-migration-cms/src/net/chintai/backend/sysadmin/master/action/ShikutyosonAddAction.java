/*
 * $Id: ShikutyosonAddAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/12  BGT)楊恩美     新規作成
 * 2007/12/10  BGT)児島       チェック処理の書き直し
 */
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
import net.chintai.backend.sysadmin.master.service.RosenUpdateCommitService;
import net.chintai.backend.sysadmin.master.service.ShikutyosonAddService;
import net.chintai.backend.sysadmin.master.service.bean.ShikutyosonAddInServiceBean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

/**
 * 市区町村登録アクション(CSVアップロード)
 *
 * @author Yang-EunMi
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonAddAction extends BaseActionSupport {

    /** ログインスタンス */
    private static Log log = LogFactory.getLog(ShikutyosonAddAction.class);
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
            loggingService.write("08002", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("WARN.M.MASTER.0021",
                    ApplicationResources.getProperty("master.CSV"),
                    ApplicationResources.getProperty("master.CSV"));
            context.setForward("failure");
            return;
        }

        if (fileSize > fileMaxSize) {
            loggingService.write("08002", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("ERROR.M.MASTER.0013",
                    ApplicationResources.getProperty("master.uploadFileSize"));
            context.setForward("failure");
            return;
        }

        if (!MasterCsvUploadUtil.validateFileSuffix(formFile.getFileName())) {
            loggingService.write("08002", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("WARN.M.MASTER.0024",
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
            loggingService.write("08002", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("ERROR.M.MASTER.0005");
            context.setForward("failure");
            return;
        } catch (IOException e) {
            loggingService.write("08002", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("ERROR.M.MASTER.0005");
            context.setForward("failure");
            return;
        }

        ShikutyosonAddInServiceBean inServiceBean = new ShikutyosonAddInServiceBean();
        inServiceBean.setUploadList(uplist);
        inServiceBean.setOperUserId(context.getSessionBean().getUserId());
        inServiceBean.setClassName(this.getClass().getName());

        ShikutyosonAddService service = (ShikutyosonAddService) ac.getBean("shikutyosonAddService");
        RosenUpdateCommitService rosenUpdateCommitService = (RosenUpdateCommitService) ac.getBean("rosenUpdateCommitService");

        try {
            service.insertShikutyosonAdd(inServiceBean);
            rosenUpdateCommitService.crsPlusCacheClear();

            loggingService.write("08002", operUserId, SessionStatus.SUCCESS, "", this.getClass().getName());
            context.setMessage("INFO.M.MASTER.0006", ApplicationResources.getProperty("master.shikutyosonData"));
            context.setForward("success");

        } catch (ApplicationException e) {
            loggingService.write("08002", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            log.error(e.getErrorId(), e);
            context.setError(e.getErrorId());
            context.setForward("failure");

        } catch (DataAccessException dae) {
            loggingService.write("08002", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            log.error(dae.getMessage(), dae);
            context.setError("ERROR.M.MASTER.0004");
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

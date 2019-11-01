/*
 * $Id: JgdcShikutyosonAddAction.java 4535 2011-11-04 05:46:53Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2011/06/15     BGT)大原       新規作成
 *
 */
package net.chintai.backend.sysadmin.master.action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.ftp.FTPClientException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.master.service.JgdcShikutyosonAddService;
import net.chintai.backend.sysadmin.master.service.bean.JgdcShikutyosonAddInServiceBean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;
import org.springframework.context.ApplicationContext;

/**
 * 国土地理協会住所データアップロード(ZIPアップロード)
 *
 * @author OOHARA Takashi
 * @version $Revision: 4535 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class JgdcShikutyosonAddAction extends BaseActionSupport {

    /** ログインスタンス */
    private static Log log = LogFactory.getLog(ShikutyosonAddAction.class);

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        DynaActionForm form = (DynaActionForm) context.getForm();
        FormFile formFile = (FormFile) form.get("fileUp");

        ApplicationContext ac = getWebApplicationContext();

        OperationLoggingService loggingService = (OperationLoggingService) ac.getBean("operationLoggingService");
        String operUserId = context.getSessionBean().getUserId();

        int fileSize = formFile.getFileSize();
        int fileMaxSize = Integer.parseInt(ApplicationResources.getProperty("master.zipFileMaxSize"));
        String fileName = ApplicationResources.getProperty("master.jgdcAddressZipFileName");
        InputStream input = null;

        // 定義された拡張子でない場合
        if (!MasterZipUploadUtil.validateFileSuffix(formFile.getFileName())) {
            loggingService.write("08005", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("WARN.M.MASTER.0051",
                    ApplicationResources.getProperty("master.upload"),
                    ApplicationResources.getProperty("master.uploadZipFileExtensions"),
                    ApplicationResources.getProperty("master.file"));
            context.setForward("failure");
            return;
        }

        // ファイルが存在しない場合
        try {
            input = formFile.getInputStream();
        } catch (FileNotFoundException e) {
            loggingService.write("08005", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("WARN.M.MASTER.0052",
                    ApplicationResources.getProperty("master.uploadZipFileExtensions"),
                    ApplicationResources.getProperty("master.uploadZipFileExtensions"));
            context.setForward("failure");
            return;
        } catch (IOException e) {
            loggingService.write("08005", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("WARN.M.MASTER.0052",
                    ApplicationResources.getProperty("master.uploadZipFileExtensions"),
                    ApplicationResources.getProperty("master.uploadZipFileExtensions"));
            context.setForward("failure");
            return;
        }

        // ファイルサイズがゼロの場合
        if (fileSize == 0) {
            loggingService.write("08005", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("WARN.M.MASTER.0052",
                    ApplicationResources.getProperty("master.uploadZipFileExtensions"),
                    ApplicationResources.getProperty("master.uploadZipFileExtensions"));
            context.setForward("failure");
            return;
        }

        // 指定したファイルサイズより大きい場合
        if (fileSize > fileMaxSize) {
            loggingService.write("08005", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("ERROR.M.MASTER.0021",
                    ApplicationResources.getProperty("master.uploadZipFileExtensions"),
                    ApplicationResources.getProperty("master.uploadZipFileSize"));
            context.setForward("failure");
            return;
        }

        // 指定したファイル名称でない場合
        if (!fileName.equals(formFile.getFileName())) {
            loggingService.write("08005", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("WARN.M.MASTER.0053",
                    ApplicationResources.getProperty("master.jgdcAddressZipFileName"));
            context.setForward("failure");
            return;
        }

        // ファイルが壊れている場合
        if (!MasterZipUploadUtil.checkZipFile(input)) {
            loggingService.write("08005", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            context.setError("ERROR.M.MASTER.0022",
                    ApplicationResources.getProperty("master.uploadZipFileExtensions"),
                    ApplicationResources.getProperty("master.uploadZipFileExtensions"));
            context.setForward("failure");
            return;
        }

        // FTP送信Service Injection
        JgdcShikutyosonAddService jgdcShikutyosonAddService =
                (JgdcShikutyosonAddService) ac.getBean("jgdcShikutyosonAddService");

        JgdcShikutyosonAddInServiceBean serviceBean = new JgdcShikutyosonAddInServiceBean();
        serviceBean.setFileName(formFile.getFileName());
        serviceBean.setInputStream(formFile.getInputStream());

        try {
        	jgdcShikutyosonAddService.zipUploadToServer(formFile);

            // 成功:操作ログ記録
            loggingService.write("08005", operUserId, SessionStatus.SUCCESS, "", this.getClass().getName());
            context.setMessage("INFO.M.MASTER.0003", ApplicationResources.getProperty("master.jgdcAddressAddressData"));
            context.setForward("success");
        } catch (FTPClientException e) {
            loggingService.write("08005", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
            log.error(e.getMessage(), e);
            context.setError("ERROR.M.MASTER.0023");
            context.setForward("failure");
        } catch (ApplicationException e) {
            loggingService.write("08005", operUserId, SessionStatus.FAILURE, "", this.getClass().getName());
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
        return auth.authenticate(userId, AuthorityId.MASTER);
    }

}

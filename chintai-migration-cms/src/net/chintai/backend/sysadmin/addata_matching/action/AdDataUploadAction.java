/*
 * $Id: AdDataUploadAction.java 4397 2009-09-11 00:48:38Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/24     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.action;

import java.io.IOException;
import java.util.List;

import net.chintai.backend.sysadmin.addata_matching.action.view.AdDataUploadView;
import net.chintai.backend.sysadmin.addata_matching.service.AdDataUpdateCommitService;
import net.chintai.backend.sysadmin.addata_matching.service.bean.AdDataUpdateInServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.CsvException;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import org.springframework.dao.DataAccessException;



/**
 * ADデータの登録アクション(CSVアップロード)
 * @author e-ishii
 * @version $Revision: 4397 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AdDataUploadAction extends BaseActionSupport {

    /** ログインスタンス */
    private static Log log = LogFactory.getLog(AdDataUploadAction.class);
    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport
     * #doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        if (!isTokenValid(context.getRequest())) {
            context.setForward("success");
            return;
        }
        resetToken(context.getRequest());


        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        FormFile formFile = (FormFile) form.get("fileUp");

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        OperationLoggingService loggingService =
            (OperationLoggingService) ac.getBean("operationLoggingService");
        String operUserId = context.getSessionBean().getUserId();

        int fileSize = formFile.getFileSize();

        // ViewHelper
        AdDataUploadView view = new AdDataUploadView();
        view.setUploadYear((String)form.get("uploadYear"));
        view.setUploadMonth((String)form.get("uploadMonth"));

        if (fileSize == 0) {
            loggingService.write("17001", operUserId, SessionStatus.FAILURE, "対象年月" + view.getUploadYear() + view.getUploadMonth(), this.getClass().getName());
            context.setError("WARN.M.ADDATA_MATCHING.0001",
                    ApplicationResources.getProperty("addata_matchin.CSV"),
                    ApplicationResources.getProperty("addata_matchin.CSV"));
            context.setForward("failure",view);
            return;
        }

        if (!AdDataMatchingCsvUploadUtil.validateFileSuffix(formFile.getFileName())) {
            loggingService.write("17001", operUserId, SessionStatus.FAILURE, "対象年月" + view.getUploadYear() + view.getUploadMonth(), this.getClass().getName());
            context.setError("WARN.M.ADDATA_MATCHING.0002",
                    ApplicationResources.getProperty("addata_matchin.upload"),
                    ApplicationResources.getProperty("addata_matchin.uploadFileExtensions"),
                    ApplicationResources.getProperty("addata_matchin.file"));
            context.setForward("failure",view);
            return;
        }

        List<String[]> uplist;
        try {
            uplist = AdDataMatchingCsvUploadUtil.uploadCsv(formFile);

        } catch (CsvException ce) {
            loggingService.write("17001", operUserId, SessionStatus.FAILURE, "対象年月" + view.getUploadYear() + view.getUploadMonth(), this.getClass().getName());
            context.setError("ERROR.M.ADDATA_MATCHING.0002");
            context.setForward("failure",view);
            return;
        } catch (IOException e) {
            loggingService.write("17001", operUserId, SessionStatus.FAILURE, "対象年月" + view.getUploadYear() + view.getUploadMonth(), this.getClass().getName());
            context.setError("ERROR.M.ADDATA_MATCHING.0002");
            context.setForward("failure",view);
            return;
        }

        if(CollectionUtils.isEmpty(uplist)) {
            loggingService.write("17001", operUserId, SessionStatus.FAILURE, "対象年月" + view.getUploadYear() + view.getUploadMonth(), this.getClass().getName());
            context.setError("ERROR.M.ADDATA_MATCHING.0001");
            context.setForward("failure",view);
            return;
        }

        // DB登録処理
        AdDataUpdateInServiceBean inServiceBean = new AdDataUpdateInServiceBean();
        inServiceBean.setUploadYear((String)form.get("uploadYear"));
        inServiceBean.setUploadMonth((String)form.get("uploadMonth"));
        inServiceBean.setUploadList(uplist);
        inServiceBean.setOperUserId(operUserId);
        inServiceBean.setPgName(this.getClass().getName());

        AdDataUpdateCommitService adDataUpdateCommitService =
                (AdDataUpdateCommitService) ac.getBean("adDataUpdateCommitService");

        try {
            adDataUpdateCommitService.adDataUpdateCommit(inServiceBean);

            // 成功:操作ログ記録
            loggingService.write("17001", operUserId, SessionStatus.SUCCESS, "対象年月" + view.getUploadYear() + view.getUploadMonth(), this.getClass().getName());
            context.setMessage("INFO.M.ADDATA_MATCHING.0001",
                    ApplicationResources.getProperty("addata_matchin.adData"));

            context.setForward("success", view);

        } catch (ApplicationException e) {
            loggingService.write("17001", operUserId, SessionStatus.FAILURE, "対象年月" + view.getUploadYear() + view.getUploadMonth(), this.getClass().getName());
            log.error(e.getErrorId(), e);
            context.setError(e.getErrorId(), e.getPlaceHolders());
            context.setForward("failure", view);
        } catch (DataAccessException dae) {
            loggingService.write("17001", operUserId, SessionStatus.FAILURE, "対象年月" + view.getUploadYear() + view.getUploadMonth(), this.getClass().getName());
            log.error(dae.getMessage(), dae);
            context.setError("ERROR.M.ADDATA_MATCHING.0002");
            context.setForward("failure", view);
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
        return auth.authenticate(userId, AuthorityId.ADDATA_MATCHING);
    }

}

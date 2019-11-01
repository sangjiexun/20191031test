/*
 * $Id: AblOutUpdateCommitAction.java 4710 2013-11-05 07:30:07Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.dataoutput.action.view.AblOutSettingUpdateBean;
import net.chintai.backend.sysadmin.dataoutput.service.AblOutUpdateCommitService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.AblOutUpdateCommitInServiceBean;
import net.chintai.backend.sysadmin.demand.action.TorihikisakiWakuMaintenanceUploadAction;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.DynaActionForm;
import org.springframework.context.ApplicationContext;

/**
 * エイブル担当店/取扱店出力情報設定画面更新処理Action
 * @author KAMEDA Takuma
 * @version $Revision: 4710 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AblOutUpdateCommitAction extends BaseActionSupport {

    /** ログインスタンス */
    private static Log log = LogFactory.getLog(TorihikisakiWakuMaintenanceUploadAction.class);

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

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai
     * .backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面リロード対策
        if (!isTokenValid(context.getRequest())) {
            context.setForward("success");
            return;
        }
        resetToken(context.getRequest());

        DynaActionForm form = (DynaActionForm) context.getForm();

        AblOutSettingUpdateBean formBean = new AblOutSettingUpdateBean();

        BeanUtilsWrapper.copyProperties(formBean, form);

        // DB更新用inServiceBean作成
        AblOutUpdateCommitInServiceBean inServiceBean = new AblOutUpdateCommitInServiceBean();

        inServiceBean.setDcoTypeArray(formBean.getDcoTypeArray());
        inServiceBean.setBukkenOutKbnArray(formBean.getBukkenOutKbnArray());
        inServiceBean.setUserId(context.getSessionBean().getUserId());
        inServiceBean.setPgName(this.getClass().getName());
        inServiceBean.setUpdDtArray(formBean.getUpdDtArray());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        AblOutUpdateCommitService commitService =
                (AblOutUpdateCommitService) ac.getBean("ablOutUpdateCommitService");

        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        try {

            // DB更新処理
            commitService.ablOutUpdateCommit(inServiceBean);

            // 操作ログ記録
            loggingService.write("19002", context.getSessionBean().getUserId(),
                    SessionStatus.SUCCESS, "", this.getClass().getName());

            // メッセージ設定
            context.setMessage("INFO.M.DATAOUTPUT.0002",
                    ApplicationResources.getProperty("dataoutput.AblOutSetting"));

            context.setForward("success");

        } catch (ApplicationException e) {
            // 操作ログ記録
            loggingService.write("19002", context.getSessionBean().getUserId(),
                    SessionStatus.FAILURE, "", this.getClass().getName());

            log.error(e.getErrorId(), e);

            // メッセージ設定
            context.setError(e.getErrorId(), e.getPlaceHolders());

            context.setForward("failure");
        }
        // 二重更新防止トークンをセット
        saveToken(context.getRequest());

    }

}

/*
 * $Id: ProfileUpdateCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.action;

import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.profile.service.ProfileUpdateCommitSerivce;
import net.chintai.backend.sysadmin.profile.service.bean.ProfileUpdateCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * プロフィル更新完了アクション。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfileUpdateCommitAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面リロード対策
        if (!isTokenValid(context.getRequest())) {
            context.setForward("success");
            return;
        }
        resetToken(context.getRequest());

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm)context.getForm();
        ProfileUpdateCommitInServiceBean inServiceBean =
            new ProfileUpdateCommitInServiceBean();

        BeanUtils.copyProperties(inServiceBean, form);

        String className = this.getClass().getName();
        inServiceBean.setPgName(className);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ProfileUpdateCommitSerivce profileUpdateCommitService =
            (ProfileUpdateCommitSerivce)ac.getBean("ProfileUpdateCommitSerivce");

        // 操作ログ記録
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        try {

            // 更新作業を行う
            profileUpdateCommitService.profileUpdateCommit(inServiceBean);

            // 操作ログ記録成功の場合
            loggingService.write("00002", context.getSessionBean().getUserId(),
                    SessionStatus.SUCCESS, ApplicationResources.getProperty("user.userId")
                    + inServiceBean.getUserId(), this.getClass().getName());

            context.getSessionBean().setUserName(inServiceBean.getUserName());

            // メッセージ設定
            context.setMessage("INFO.M.PROFILE.0001",
                    ApplicationResources.getProperty("user.userInfo"));

        } catch(ApplicationException ae) {

            // 操作ログ記録失敗の場合
            loggingService.write("00002", context.getSessionBean().getUserId(),
                    SessionStatus.FAILURE, ApplicationResources.getProperty("user.userId")
                    + inServiceBean.getUserId(), this.getClass().getName());

            // メッセージ設定
            context.setError("ERROR.M.PROFILE.0001");
        }
        context.setForward("success");
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        return true; // 共通メニューのため権限チェック不要
    }
}
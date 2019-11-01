/*
 * $Id: ProfilePasswordChangeCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.profile.action.view.ProfilePasswordChangePageView;
import net.chintai.backend.sysadmin.profile.service.ProfilePasswordChangeCommitService;
import net.chintai.backend.sysadmin.profile.service.ProfilePasswordCheckService;
import net.chintai.backend.sysadmin.profile.service.bean.ProfilePasswordChangeCommitInServiceBean;
import net.chintai.backend.sysadmin.profile.service.bean.ProfilePasswordCheckInServiceBean;

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
public class ProfilePasswordChangeCommitAction extends BaseActionSupport {

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

        ProfilePasswordCheckInServiceBean checkInServiceBean =
            new ProfilePasswordCheckInServiceBean();
        ProfilePasswordChangeCommitInServiceBean inServiceBean =
            new ProfilePasswordChangeCommitInServiceBean();
        BeanUtils.copyProperties(checkInServiceBean, form);
        BeanUtils.copyProperties(inServiceBean, form);

        // sessionBeanからユーザID取得後、InServiceBeanに設定
        checkInServiceBean.setUserId(context.getSessionBean().getUserId());
        inServiceBean.setUserId(context.getSessionBean().getUserId());

        String className = this.getClass().getName();
        inServiceBean.setPgName(className);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        ProfilePasswordCheckService profilePasswordCheckService =
            (ProfilePasswordCheckService)ac.getBean("ProfilePasswordCheckService");

        // 現在のパスワード確認サービスを行う。
        int passwdCheck =
            profilePasswordCheckService.profilePasswordCheck(checkInServiceBean);

        if(passwdCheck != 0) {

            ProfilePasswordChangeCommitService profilePasswordChangeCommitService =
                (ProfilePasswordChangeCommitService)ac.getBean("ProfilePasswordChangeCommitService");

            // 操作ログ記録
            OperationLoggingService loggingService =
                    (OperationLoggingService) ac.getBean("operationLoggingService");

            try {

                // 更新作業を行う
                profilePasswordChangeCommitService.profilePasswordChangeCommit(inServiceBean);

                // 操作ログ記録成功の場合
                loggingService.write("00003", context.getSessionBean().getUserId(),
                        SessionStatus.SUCCESS, ApplicationResources.getProperty("user.userId")
                        + inServiceBean.getUserId(), this.getClass().getName());

                // メッセージ設定
                context.setMessage("INFO.M.PROFILE.0002",
                        ApplicationResources.getProperty("user.userPassword"));
            } catch(ApplicationException ae) {

                // 操作ログ記録失敗の場合
                loggingService.write("00003", context.getSessionBean().getUserId(),
                        SessionStatus.FAILURE, ApplicationResources.getProperty("user.userId")
                        + inServiceBean.getUserId(), this.getClass().getName());

                // メッセージ設定
                context.setError("ERROR.M.USER.0002");
            }
            context.setForward("success");
        } else {

            // 現在のパスワードが一致しない場合
            ProfilePasswordChangePageView view =
                new ProfilePasswordChangePageView();
            view.setUpdDt(inServiceBean.getUpdDt());
            // メッセージ設定
            context.setError("WARN.M.PROFILE.0006",
                    ApplicationResources.getProperty("user.userOldPassword"));
            context.setForward("fail", view);
        }
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
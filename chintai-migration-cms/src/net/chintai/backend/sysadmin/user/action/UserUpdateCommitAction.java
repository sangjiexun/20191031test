/*
 * $Id: UserUpdateCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)金東珍     新規作成
 * 2007/09/28  BGT)児島       フォーマッター適用
 */
package net.chintai.backend.sysadmin.user.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.user.service.UserUpdateCommitService;
import net.chintai.backend.sysadmin.user.service.bean.UserUpdateCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * ユーザ更新完了アクション。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserUpdateCommitAction extends BaseActionSupport {

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
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        UserUpdateCommitInServiceBean inServiceBean = new UserUpdateCommitInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // 更新者をユーザＩＤで設定
        String operUserId = context.getSessionBean().getUserId();
        inServiceBean.setOperUserId(operUserId);

        String className = this.getClass().getName();
        inServiceBean.setPgName(className);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        UserUpdateCommitService userUpdateCommitService =
                (UserUpdateCommitService) ac.getBean("UserUpdateCommitService");

        // 操作ログ記録
        OperationLoggingService loggingService = (OperationLoggingService) ac.getBean("operationLoggingService");

        try {
            // 更新作業を行う
            userUpdateCommitService.userUpdateCommit(inServiceBean);

            // 操作ログ記録成功の場合
            loggingService.write("09003", context.getSessionBean().getUserId(), SessionStatus.SUCCESS,
                    ApplicationResources.getProperty("user.userId") + inServiceBean.getUserId(), this.getClass().getName());

            if (operUserId.equals(inServiceBean.getUserId())) {
                context.getSessionBean().setUserName(inServiceBean.getUserName());
            }

            // メッセージ設定
            context.setMessage("INFO.M.USER.0002", ApplicationResources.getProperty("user.user"));
            context.setForward("success");

        } catch (ApplicationException ae) {

            // 操作ログ記録失敗の場合
            loggingService.write("09003", context.getSessionBean().getUserId(), SessionStatus.FAILURE,
                    ApplicationResources.getProperty("user.userId") + inServiceBean.getUserId(), this.getClass().getName());

            // メッセージ設定
            context.setError("ERROR.M.USER.0002");
            context.setForward("fail");
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        // 権限チェック
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.USER);
    }
}
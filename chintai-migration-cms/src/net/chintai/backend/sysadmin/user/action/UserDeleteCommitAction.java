/*
 * $Id: UserDeleteCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)金東珍     新規作成
 * 2007/09/28  BGT)児島       フォーマッター適用
 */
package net.chintai.backend.sysadmin.user.action;

import java.util.Arrays;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.user.service.UserDeleteCommitService;
import net.chintai.backend.sysadmin.user.service.bean.UserDeleteCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * ユーザ削除完了アクション。
 *
 * @author Kim Dong Jin
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserDeleteCommitAction extends BaseActionSupport {

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
        UserDeleteCommitInServiceBean inServiceBean = new UserDeleteCommitInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // ユーザID取得
        String userCheckId[] = (String[]) form.get("userCheckId");

        // 更新者をユーザＩＤで設定
        String operUserId = context.getSessionBean().getUserId();
        inServiceBean.setOperUserId(operUserId);

        String className = this.getClass().getName();
        inServiceBean.setPgName(className);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        UserDeleteCommitService userDeleteCommitService =
                (UserDeleteCommitService) ac.getBean("UserDeleteCommitService");

        // 操作ログ記録
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        // 操作ログ記録為、削除IDを設定
        String delIdList = Arrays.asList(userCheckId).toString();
        String delLog = delIdList.substring(1,delIdList.length() -1);

        try {
            // ユーザ削除処理を行う
            userDeleteCommitService.userDeleteCommit(inServiceBean);

            // 操作ログ記録成功の場合
            loggingService.write("09002", context.getSessionBean().getUserId(),
                SessionStatus.SUCCESS, ApplicationResources.getProperty("user.userId")
                + delLog, this.getClass().getName());
            // メッセージ設定
            context.setMessage("INFO.M.USER.0004", ApplicationResources.getProperty("user.user"));

        } catch (ApplicationException ae) {

            // 操作ログ記録失敗の場合
            loggingService.write("09002", context.getSessionBean().getUserId(),
            SessionStatus.FAILURE, ApplicationResources.getProperty("user.userId")
            + delLog, this.getClass().getName());

            // メッセージ設定
            context.setError("ERROR.M.USER.0005");
        }
        context.setForward("success");
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
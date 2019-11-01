/*
 * $Id: GroupAddCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/19  BGT)沈鍾沿     新規作成
 *
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
import net.chintai.backend.sysadmin.user.service.GroupAddCommitService;
import net.chintai.backend.sysadmin.user.service.bean.GroupAddCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * グループ登録後グループ一覧を表示するアクションクラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupAddCommitAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.USER);
    }

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
        GroupAddCommitInServiceBean inServiceBean = new GroupAddCommitInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // 更新者をユーザＩＤで設定
        String operUserId = context.getSessionBean().getUserId();
        inServiceBean.setOperUserId(operUserId);

        String className = this.getClass().getName();
        inServiceBean.setPgName(className);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        GroupAddCommitService groupAddCommitService =
                (GroupAddCommitService) ac.getBean("groupAddCommitService");

        // 操作ログ記録サービス
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        try {
            // 新しいグループを登録
            groupAddCommitService.insertGroup(inServiceBean);
        } catch (ApplicationException e) {
            // 更新失敗ログ
            loggingService.write("09005", inServiceBean.getOperUserId(), SessionStatus.FAILURE,
                    ApplicationResources.getProperty("user.groupName")
                    + inServiceBean.getGroupName(), this.getClass().getName());
            throw e;
        }

        // 更新成功ログ、メッセージ設定
        loggingService.write("09005", inServiceBean.getOperUserId(), SessionStatus.SUCCESS,
                ApplicationResources.getProperty("user.groupName")
                + inServiceBean.getGroupName(), this.getClass().getName());
        context.setMessage("INFO.M.USER.0005", ApplicationResources.getProperty("user.group"));

        context.setForward("success");
    }

}

/*
 * $Id: GroupUpdateCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.user.service.GroupUpdateCommitService;
import net.chintai.backend.sysadmin.user.service.bean.GroupUpdateCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * グループ設定変更後グループ一覧を表示するアクションクラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupUpdateCommitAction extends BaseActionSupport {

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
        GroupUpdateCommitInServiceBean inServiceBean = new GroupUpdateCommitInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // 更新者をユーザＩＤで設定
        String operUserId = context.getSessionBean().getUserId();
        inServiceBean.setUpdId(operUserId);

        String className = this.getClass().getName();
        inServiceBean.setPgName(className);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        GroupUpdateCommitService groupUpdateCommitService =
                (GroupUpdateCommitService) ac.getBean("groupUpdateCommitService");

        // 操作ログ記録サービス
        OperationLoggingService loggingService = (OperationLoggingService) ac.getBean("operationLoggingService");

        try {
            // グループの権限を更新
            groupUpdateCommitService.updateGroup(inServiceBean);
            loggingService.write("09006", inServiceBean.getUpdId(), SessionStatus.SUCCESS,
                    ApplicationResources.getProperty("user.groupName")
                        + inServiceBean.getGroupName(), this.getClass().getName());
            context.setMessage("INFO.M.USER.0006", ApplicationResources.getProperty("user.group"));
        } catch (ApplicationException e) {
            // 更新失敗ログ
            loggingService.write("09006", inServiceBean.getUpdId(), SessionStatus.FAILURE,
                    ApplicationResources.getProperty("user.groupName")
                        + inServiceBean.getGroupName(), this.getClass().getName());
            context.setError("ERROR.M.USER.0004", ApplicationResources.getProperty("user.group"));
        }

        context.setForward("success");
    }
}

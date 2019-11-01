/*
 * $Id: GroupDeleteCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/19  BGT)沈鍾沿     新規作成
 *
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
import net.chintai.backend.sysadmin.user.service.GroupDeleteCommitService;
import net.chintai.backend.sysadmin.user.service.bean.GroupDeleteCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * グループ削除後グループ一覧を表示するアクションクラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupDeleteCommitAction extends BaseActionSupport {

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
        GroupDeleteCommitInServiceBean inServiceBean = new GroupDeleteCommitInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);
        String operUserId = context.getSessionBean().getUserId();

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        GroupDeleteCommitService groupDeleteCommitService =
                (GroupDeleteCommitService) ac.getBean("groupDeleteCommitService");

        // 操作ログ記録サービス
        OperationLoggingService loggingService = (OperationLoggingService) ac.getBean("operationLoggingService");
        // グループ名取得
        String groupName[] = (String[]) form.get("groupName");

        // 操作ログ記録為、削除IDを設定
        String delIdList = Arrays.asList(groupName).toString();
        String delLog = delIdList.substring(1,delIdList.length() -1);

        try {
            // グループを削除
            groupDeleteCommitService.deleteGroupByGroupId(inServiceBean);
            loggingService.write("09007", operUserId, SessionStatus.SUCCESS,
                    ApplicationResources.getProperty("user.groupName")
                    + delLog, this.getClass().getName());
            context.setMessage("INFO.M.USER.0007", ApplicationResources.getProperty("user.group"));
        } catch (ApplicationException e) {
            // 更新失敗ログ
            loggingService.write("09007", operUserId, SessionStatus.FAILURE,
                    ApplicationResources.getProperty("user.groupName")
                    + delLog, this.getClass().getName());
            context.setError("ERROR.M.USER.0005", ApplicationResources.getProperty("user.group"));
        }

        context.setForward("success");
    }
}
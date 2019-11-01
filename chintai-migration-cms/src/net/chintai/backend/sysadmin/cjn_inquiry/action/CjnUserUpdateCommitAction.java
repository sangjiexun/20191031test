/*
 * $Id: CjnUserUpdateCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import java.util.HashMap;
import java.util.Map;

import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserUpdateCommitService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserUpdateCommitInServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.DynaActionForm;
import org.springframework.context.ApplicationContext;

/**
 * 問い合せユーザ更新アクション。
 *
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserUpdateCommitAction extends BaseActionSupport {

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

        // 画面データをBeanにセット
        DynaActionForm form = (DynaActionForm) context.getForm();
        CjnUserUpdateCommitInServiceBean inServiceBean = new CjnUserUpdateCommitInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // 更新Service呼び出し
        CjnUserUpdateCommitService updateService =
                (CjnUserUpdateCommitService) ac.getBean("cjnUserUpdateCommitService");

        // 操作ログ記録Service呼び出し
        OperationLoggingService logginService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        // 更新者をユーザＩＤで設定
        String operUserId = context.getSessionBean().getUserId();

        String className = this.getClass().getName();

        inServiceBean.setOperUserId(operUserId);
        inServiceBean.setPgName(className);

        try {
            // 問い合せユーザ情報更新
            updateService.cjnUserUpdateCommit(inServiceBean);

            // 操作ログ記録
            logginService.write("07005", operUserId, SessionStatus.SUCCESS, "ユーザID" + inServiceBean.getUserId(), this.getClass().getName());
            // メッセージ出力
            context.setMessage("INFO.M.CJN_INQUIRY.0006", ApplicationResources
                    .getProperty("cjn_inquiry.UserInfo"));
        } catch (ApplicationException e) {
            // ApplicationExceptionが発生した時、操作ログ失敗
            logginService.write("07005", operUserId, SessionStatus.FAILURE, "ユーザID" + inServiceBean.getUserId(), this.getClass().getName());

            // メッセージ出力
            context.setError("ERROR.M.CJN_INQUIRY.0004");
        }

        // 問い合せユーザ詳細画面パラメータ
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("cjnAccountSeq", inServiceBean.getCjnAccountSeq());
        context.setForwardParameterMap(paramMap);
        context.setForward("success");

    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.CJN_INQUIRY)
                && auth.isAdminCjnAccountType(userId);
    }

}

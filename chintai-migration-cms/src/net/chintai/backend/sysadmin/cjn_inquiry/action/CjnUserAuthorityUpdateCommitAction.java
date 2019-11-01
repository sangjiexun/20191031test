/*
 * $Id: CjnUserAuthorityUpdateCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import java.util.HashMap;
import java.util.Map;

import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserAuthorityUpdateCommitService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAuthorityUpdateCommitInServiceBean;
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
 * 閲覧可能問い合せ権限更新コミットアクション
 *
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAuthorityUpdateCommitAction extends BaseActionSupport {

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

        // 画面データ取得
        DynaActionForm form = (DynaActionForm) context.getForm();
        CjnUserAuthorityUpdateCommitInServiceBean inBean =
                new CjnUserAuthorityUpdateCommitInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 更新者をユーザＩＤで設定
        String operUserId = context.getSessionBean().getUserId();
        inBean.setOperUserId(operUserId);

        String className = this.getClass().getName();
        inBean.setPgName(className);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // 操作ログService呼び出し
        OperationLoggingService logginService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        // 更新Service呼び出し
        CjnUserAuthorityUpdateCommitService commitService =
                (CjnUserAuthorityUpdateCommitService) ac
                        .getBean("cjnUserAuthorityUpdateCommitService");

        try {
            // Serivce実行
            commitService.updateUserAuthority(inBean);

            // 操作ログ記録
            logginService.write("07006", operUserId, SessionStatus.SUCCESS, "ユーザID" + inBean.getUserId(), this.getClass().getName());

            // メッセージ出力
            context.setMessage("INFO.M.CJN_INQUIRY.0006", ApplicationResources
                    .getProperty("cjn_inquiry.Authority"));

        } catch (ApplicationException e) {
            // ApplicationExceptionが発生した時、操作ログ失敗
            logginService.write("07006", operUserId, SessionStatus.FAILURE, "ユーザID" + inBean.getUserId(), this.getClass().getName());

            // メッセージ出力
            context.setError("ERROR.M.CJN_INQUIRY.0005");
        }

        // 問い合せユーザ詳細画面パラメータ
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("cjnAccountSeq", inBean.getCjnAccountSeq());
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

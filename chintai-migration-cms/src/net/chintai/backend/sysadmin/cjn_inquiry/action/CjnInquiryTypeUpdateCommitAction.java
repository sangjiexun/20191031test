/*
 * $Id: CjnInquiryTypeUpdateCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26   BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import java.util.HashMap;
import java.util.Map;

import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeUpdateCommitService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeUpdateCommitInServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 問い合せ種別を更新するアクション。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeUpdateCommitAction extends BaseActionSupport {

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
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        CjnInquiryTypeUpdateCommitInServiceBean bean =
                new CjnInquiryTypeUpdateCommitInServiceBean();
        BeanUtils.copyProperties(bean, form);

        // 更新者ユーザIDをセット
        bean.setOperUserId(context.getSessionBean().getUserId());

        String className = this.getClass().getName();
        bean.setPgName(className);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        CjnInquiryTypeUpdateCommitService service =
                (CjnInquiryTypeUpdateCommitService) ac.getBean("cjnInquiryTypeUpdateCommitService");

        // 操作ログ記録
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        try {
            // 更新実行
            service.updateType(bean);

            // 更新した場合の操作ログ記録
            loggingService.write("07002", context.getSessionBean().getUserId(),
                    SessionStatus.SUCCESS, "問い合せ種別シーケンス" + String.valueOf(bean.getCjnInqKindSeq()), this.getClass().getName());

            // メッセージをセット
            context.setMessage("INFO.M.CJN_INQUIRY.0002", ApplicationResources
                    .getProperty("cjn_inquiry.type"));

        } catch (ApplicationException e) {

            // 更新出来なかった場合の操作ログ記録
            loggingService.write("07002", context.getSessionBean().getUserId(),
                    SessionStatus.FAILURE, "問い合せ種別シーケンス" + String.valueOf(bean.getCjnInqKindSeq()), this.getClass().getName());

            // エラーメッセージをセット
            context.setError("ERROR.M.CJN_INQUIRY.0001");

        }

        // フォワードパラメータをセット
        Map<String, String> parameterMap = new HashMap<String, String>();
        parameterMap.put("cjnInqKindSeq", ((Integer) bean.getCjnInqKindSeq()).toString());
        context.setForwardParameterMap(parameterMap);

        // 遷移先は同じ画面
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

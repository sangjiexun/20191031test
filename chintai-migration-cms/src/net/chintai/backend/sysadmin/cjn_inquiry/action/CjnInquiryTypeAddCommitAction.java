/*
 * $Id: CjnInquiryTypeAddCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/17   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeAddCommitService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeAddCommitInServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 問い合せ種別を登録するアクション。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeAddCommitAction extends BaseActionSupport {

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
        CjnInquiryTypeAddCommitInServiceBean bean = new CjnInquiryTypeAddCommitInServiceBean();
        BeanUtils.copyProperties(bean, form);

        // 更新者ユーザIDセット
        bean.setOperUserId(context.getSessionBean().getUserId());

        String className = this.getClass().getName();
        bean.setPgName(className);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        CjnInquiryTypeAddCommitService service =
                (CjnInquiryTypeAddCommitService) ac.getBean("cjnInquiryTypeAddCommitService");

        // 問い合せ種別を登録
        int seq = service.insertType(bean);

        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");
        loggingService.write("07001", context.getSessionBean().getUserId(), SessionStatus.SUCCESS,
                "問い合せ種別シーケンス" + String.valueOf(seq), this.getClass().getName());

        // メッセージをセット
        context.setMessage("INFO.M.CJN_INQUIRY.0001", ApplicationResources
                .getProperty("cjn_inquiry.type"));
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

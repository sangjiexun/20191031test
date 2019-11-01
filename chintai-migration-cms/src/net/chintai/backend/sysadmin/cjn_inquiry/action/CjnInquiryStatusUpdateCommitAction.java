/*
 * $Id: CjnInquiryStatusUpdateCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/10   BGT)楊恩美    新規作成
 * 2007/10/17   BGT)児島      リファクタリング
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryAccessControlService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryStatusUpdateCommitService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryStatusUpdateCommitInServiceBean;
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
 * 問い合せ処理状況更新アクション
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryStatusUpdateCommitAction extends BaseActionSupport {

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

        // 更新情報取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        CjnInquiryStatusUpdateCommitInServiceBean inServiceBean =
                new CjnInquiryStatusUpdateCommitInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // アクセス権限チェック
        CjnInquiryAccessControlService acl =
                (CjnInquiryAccessControlService) ac.getBean("cjnInquiryAccessControlService");
        if (!acl.isAccessibleForInqId(context.getSessionBean().getUserId(), inServiceBean
                .getCjnInqId())) {
            throw new ApplicationException("ERROR.M.APP.0003");
        }

        // 操作ログService呼び出し
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        // 更新Service呼び出し
        CjnInquiryStatusUpdateCommitService commitSerivce =
                (CjnInquiryStatusUpdateCommitService) ac
                        .getBean("cjnInquiryStatusUpdateCommitService");

        // 更新者をユーザＩＤで設定
        String operUserId = context.getSessionBean().getUserId();
        inServiceBean.setOperUserId(operUserId);
        inServiceBean.setPgName(this.getClass().getName());

        try {
            // 処理状況更新
            commitSerivce.cjnInquiryStatusUpdateCommit(inServiceBean);
            // 操作ログ記録
            loggingService.write("07004", operUserId, SessionStatus.SUCCESS, "問い合せID"
                    + inServiceBean.getCjnInqId(), this.getClass().getName());
            // メッセージ出力
            context.setMessage("INFO.M.CJN_INQUIRY.0005", ApplicationResources
                    .getProperty("cjn_inquiry.status"));

        } catch (ApplicationException e) {
            // ApplicationExceptionが発生した時、操作ログ失敗
            loggingService.write("07004", operUserId, SessionStatus.FAILURE, "問い合せID"
                    + inServiceBean.getCjnInqId(), this.getClass().getName());

            // メッセージ出力
            context.setError("ERROR.M.CJN_INQUIRY.0003");
        }

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
        return auth.authenticate(userId, AuthorityId.CJN_INQUIRY);
    }

}

/*
 * $Id: BukkenPublishStatusUpdateCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenPublishStatusUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenPublishStatusUpdateCommitInServiceBean;

/**
 * 物件掲載状態変更完了アクション。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenPublishStatusUpdateCommitAction extends BaseActionSupport {

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

        String kanriCd = context.getRequest().getParameter("kanriCd");
        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm)context.getForm();
        BukkenPublishStatusUpdateCommitInServiceBean inServiceBean =
            new BukkenPublishStatusUpdateCommitInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // 更新者をユーザＩＤで設定
        String operUserId = context.getSessionBean().getUserId();
        inServiceBean.setOperUserId(operUserId);

        // プログラムID設定
        inServiceBean.setUpdPg(this.getClass().getName());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        BukkenPublishStatusUpdateCommitService bukkenPublishStatusUpdateCommitService =
            (BukkenPublishStatusUpdateCommitService) ac.getBean("BukkenPublishStatusUpdateCommitService");

        // 操作ログ記録
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        try {
            // 更新作業を行う
            bukkenPublishStatusUpdateCommitService.bukkenPublishStatusUpdateCommit(inServiceBean);

            // 操作ログ記録成功の場合
            loggingService.write("01011", context.getSessionBean().getUserId(),
                    SessionStatus.SUCCESS, ApplicationResources.getProperty("bukken.bukkenAdminCode")
                    + kanriCd, this.getClass().getName());

            // メッセージ設定
            context.setMessage("INFO.M.SHOP_BUKKEN.0015",
                  ApplicationResources.getProperty("bukken.publishStatus"));

        } catch(ApplicationException ae) {

            // 操作ログ記録失敗の場合
            loggingService.write("01011", context.getSessionBean().getUserId(),
                    SessionStatus.FAILURE, ApplicationResources.getProperty("bukken.bukkenAdminCode")
                    + kanriCd, this.getClass().getName());

            // メッセージ設定
            context.setError("ERROR.M.SHOP_BUKKEN.0003");
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
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }
}
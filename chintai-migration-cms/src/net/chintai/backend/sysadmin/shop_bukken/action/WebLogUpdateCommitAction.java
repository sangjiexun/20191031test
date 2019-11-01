/*
 * $Id: WebLogUpdateCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_bukken.service.WebLogUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.WebLogUpdateCommitInServiceBean;

/**
 * Webログ利用可否完了アクション。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class WebLogUpdateCommitAction extends BaseActionSupport {

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
        WebLogUpdateCommitInServiceBean inServiceBean = new WebLogUpdateCommitInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // 更新者をユーザＩＤで設定
        String operUserId = context.getSessionBean().getUserId();
        inServiceBean.setOperUserId(operUserId);

        // 最終更新プログラムID設定
        inServiceBean.setUpdPg(this.getClass().getName());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        WebLogUpdateCommitService webLogUpdateCommitService =
                (WebLogUpdateCommitService) ac.getBean("WebLogUpdateCommitService");

        // 更新作業を行う
        webLogUpdateCommitService.webLogUpdateCommit(inServiceBean);

        // 操作ログ記録
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");
        loggingService.write("01008", context.getSessionBean().getUserId(), SessionStatus.SUCCESS,
                "店舗コード " + (String) form.get("shopCd"), this.getClass().getName());

        // メッセージ設定
        context.setMessage("INFO.M.SHOP_BUKKEN.0010", ApplicationResources
                .getProperty("shop.webLog"));

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
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }
}
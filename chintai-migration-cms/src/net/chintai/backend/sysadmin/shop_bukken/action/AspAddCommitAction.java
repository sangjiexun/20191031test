/*
 * $Id: AspAddCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.HashMap;
import java.util.Map;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_bukken.service.AspAddCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspAddCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 不動産ASP設定情報登録完了アクション
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspAddCommitAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        context.setForward("success");
        // 画面リロード対策
        if (!isTokenValid(context.getRequest())) {
            return;
        }
        resetToken(context.getRequest());

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        AspAddCommitInServiceBean aspAddInServiceBean = new AspAddCommitInServiceBean();
        BeanUtils.copyProperties(aspAddInServiceBean, form);

        // reauestから登録される不動産ASP設定情報を取得
        Map<String, String[]> requestMap = new HashMap<String, String[]>(context.getRequest().getParameterMap());

        aspAddInServiceBean.setRequestMap(requestMap);
        aspAddInServiceBean.setInsId(context.getSessionBean().getUserId());
        aspAddInServiceBean.setInsPg(this.getClass().getName());

        ApplicationContext ac = getWebApplicationContext();
        AspAddCommitService aspAddCommitService = (AspAddCommitService) ac.getBean("aspAddCommitService");
//        AspShopImageService aspShopImageService = (AspShopImageService) ac.getBean("aspShopImageService");
        String operUserId = context.getSessionBean().getUserId();

        // 操作ログ記録サービス
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        try {
            // 不動産ASP設定情報を登録する。
            aspAddCommitService.insertAspAddCommit(aspAddInServiceBean);

            // 更新成功ログ、メッセージ設定
            loggingService.write("01002", operUserId, SessionStatus.SUCCESS, "店舗コード "
                    + aspAddInServiceBean.getShopCd(), this.getClass().getName());

            context.setMessage("INFO.M.SHOP_BUKKEN.0004", ApplicationResources.getProperty("shop.aspInfo"));
        } catch (ApplicationException e) {
            // 登録失敗ログ
            loggingService.write("01002", operUserId, SessionStatus.FAILURE, "店舗コード "
                    + aspAddInServiceBean.getShopCd(), this.getClass().getName());
            context.setError(e.getErrorId(),e.getPlaceHolders());
        }
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

/*
 * $Id: AspUpdateCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/17  BGT)沈鍾沿     新規作成
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
import net.chintai.backend.sysadmin.shop_bukken.service.AspUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 修正された不動産ASP情報を更新完了するアクション
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspUpdateCommitAction extends BaseActionSupport {

    /** ロゴ表示フラグ */
    private static final String C_LOGO_FLG = "1";

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面リロード対策
        context.setForward("success");
       if (!isTokenValid(context.getRequest())) {
            return;
        }
        resetToken(context.getRequest());

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        AspUpdateCommitInServiceBean aspUpdateInServiceBean = new AspUpdateCommitInServiceBean();
        BeanUtils.copyProperties(aspUpdateInServiceBean, form);

        // reauestから更新される不動産ASP設定情報(エリア)を取得
        Map<String, String[]> requestMap = new HashMap<String, String[]>(context.getRequest().getParameterMap());

        aspUpdateInServiceBean.setRequestMap(requestMap);
        aspUpdateInServiceBean.setInsId(context.getSessionBean().getUserId());
        aspUpdateInServiceBean.setInsPg(this.getClass().getName());

        ApplicationContext ac = getWebApplicationContext();

        String operUserId = context.getSessionBean().getUserId();

        AspUpdateCommitService aspUpdateCommitService =
                (AspUpdateCommitService) ac.getBean("aspUpdateCommitService");

        // 操作ログ記録サービス
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");


        try {
            // 不動産ASP設定情報を更新する。
            aspUpdateCommitService.updateAspUpdateCommit(aspUpdateInServiceBean);

            // 更新成功ログ、メッセージ設定
            loggingService.write("01003", operUserId, SessionStatus.SUCCESS, "店舗コード "
                    + aspUpdateInServiceBean.getShopCd(), this.getClass().getName());

            context.setMessage("INFO.M.SHOP_BUKKEN.0005", ApplicationResources.getProperty("shop.aspInfo"));

        } catch (ApplicationException e) {
            // 登録失敗ログ
            loggingService.write("01003", operUserId, SessionStatus.FAILURE, "店舗コード "
                    + aspUpdateInServiceBean.getShopCd(), this.getClass().getName());
            context.setError(e.getErrorId(),e.getPlaceHolders());

            // 二重更新防止トークンをセット
            saveToken(context.getRequest());

            return;
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

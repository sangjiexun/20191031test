/*
 * $Id: ShopRegistrationStatusUpdateCommitAction.java 3582 2007-12-15 13:29:52Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopRegistrationStatusUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopRegistrationStautsUpdateCommitInServiceBean;
import net.chintai.batch.support.ppc.PpcException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 登録状況更新完了アクション
 *
 * @author Sim-JongYeon
 * @version $Revision: 1.10
 * $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopRegistrationStatusUpdateCommitAction extends BaseActionSupport {

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
        ShopRegistrationStautsUpdateCommitInServiceBean updateInServiceBean =
                new ShopRegistrationStautsUpdateCommitInServiceBean();
        BeanUtils.copyProperties(updateInServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ShopRegistrationStatusUpdateCommitService shopRegistrationStatusUpdateCommitService =
                (ShopRegistrationStatusUpdateCommitService) ac.getBean("shopRegistrationStatusUpdateCommitService");

        // 更新者のＩＤを設定
        String operUserId = context.getSessionBean().getUserId();
        updateInServiceBean.setOperId(operUserId);

        // 最終更新プログラムID設定
        updateInServiceBean.setUpdPg(this.getClass().getName());

        // 操作ログ記録サービス
        OperationLoggingService loggingService = (OperationLoggingService) ac.getBean("operationLoggingService");

        try {
            // 登録状況更新完了を行う
            boolean isDispPccMsg = shopRegistrationStatusUpdateCommitService.shopRegistrationStautsUpdateCommit(updateInServiceBean);
            // 更新成功ログ、メッセージ設定
            loggingService.write("01014", operUserId, SessionStatus.SUCCESS, "店舗コード " + updateInServiceBean.getShopCd(), this.getClass().getName());
            context.setMessage(isDispPccMsg ? "INFO.M.SHOP_BUKKEN.0030": "INFO.M.SHOP_BUKKEN.0002", ApplicationResources.getProperty("shop.shopKeiyaku"));
            context.setForward("success");

        } catch (PpcException e) {
            // PPC取得失敗 店舗系の登録・更新は行わない。
            loggingService.write("01014", operUserId, SessionStatus.FAILURE, "店舗コード " + updateInServiceBean.getShopCd(), this.getClass().getName());
            context.setError("INFO.M.SHOP_BUKKEN.0031");
            context.setForward("failure");
        } catch (ApplicationException e) {
            // 更新失敗ログ
            loggingService.write("01014", operUserId, SessionStatus.FAILURE, "店舗コード " + updateInServiceBean.getShopCd(), this.getClass().getName());
            context.setError("ERROR.M.SHOP_BUKKEN.0009");
            context.setForward("failure");
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

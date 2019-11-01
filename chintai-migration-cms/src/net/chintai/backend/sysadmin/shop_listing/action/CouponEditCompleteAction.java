/*
 * $Id: CouponEditCompleteAction.java 4262 2009-03-25 07:29:11Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/05     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_listing.service.CouponEditCompleteService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.CouponEditCompleteInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.JdbcUpdateAffectedIncorrectNumberOfRowsException;

/**
 * クーポン情報編集完了サービス
 *
 * @author Lee Hosup
 * @version $Revision: 4262 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CouponEditCompleteAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport
     * #doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面リロード対策
        if (!isTokenValid(context.getRequest())) {
            context.setForward("success");
            return;
        }
        resetToken(context.getRequest());

        // 画面から登録データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        CouponEditCompleteInServiceBean inBean = new CouponEditCompleteInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 登録者情報を設定(登録プログラム、登録者ID、更新プログラム、更新者ID)
        inBean.setInsPg(this.getClass().getName());
        inBean.setInsId(context.getSessionBean().getUserId());
        inBean.setUpdPg(this.getClass().getName());
        inBean.setUpdId(context.getSessionBean().getUserId());

        // injection
        ApplicationContext ac = getWebApplicationContext();
        CouponEditCompleteService service =
                (CouponEditCompleteService) ac.getBean("couponEditCompleteService");

        // 登録処理を行う
        SessionStatus editResult = SessionStatus.SUCCESS;
        try {
            service.editCouponInfo(inBean);
            context.setMessage("INFO.M.SHOP_LISTING.0007", ApplicationResources
                    .getProperty("shop_listing.couponInfo"));
        } catch (JdbcUpdateAffectedIncorrectNumberOfRowsException e) {
            editResult = SessionStatus.FAILURE;
            context.setError("ERROR.M.SHOP_LISTING.0003");
        }

        // 操作ログを登録します。
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        loggingService.write(
            SystemProperties.getProperty("OP_ID_LISTING_COUPON_INFO_EDIT"), // 操作ID
            context.getSessionBean().getUserId(),                           // 更新/登録者ID
            editResult,                                                     // 操作結果
            ApplicationResources.getProperty("shop_listing.shopCd") + inBean.getShopCd(), //操作対象
            this.getClass().getName()
        );

        context.setForward("success");
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport
     * #isAuthorized(java .lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_LISTING);
    }

}

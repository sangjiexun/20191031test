/*
 * $Id: CouponEditPageBackAction.java 4245 2009-03-23 08:35:22Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/10     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_listing.action.view.CouponEditView;
import net.chintai.backend.sysadmin.shop_listing.service.ShopBasicInfoService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopBasicInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * クーポン編集画面に戻るアクション。
 *
 * @author Lee Hosup
 * @version $Revision: 4245 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CouponEditPageBackAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#
     * doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        CouponEditView view =
                new CouponEditView(SystemProperties.getProperty("COUPON_INFO_DISPLAY_LIMIT"));
        BeanUtils.copyProperties(view, form);

        // リクエストから店舗コードを取得
        String shopCd = context.getRequest().getParameter("shopCd");

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ShopBasicInfoService service = (ShopBasicInfoService) ac.getBean("shopBasicInfoService");

        // 契約店舗詳細情報を取得
        ShopBasicInfoOutServiceBean outBean = service.searchShopBasicInfo(shopCd);

        // ViewHelper設定
        BeanUtils.copyProperties(view, outBean);

        context.setForward("success", view);

    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#
     * isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_LISTING);
    }

}

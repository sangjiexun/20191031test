/*
 * $Id: CouponEditPageAction.java 4245 2009-03-23 08:35:22Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/19     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_listing.action.view.CouponEditView;
import net.chintai.backend.sysadmin.shop_listing.service.CouponEditPageService;
import net.chintai.backend.sysadmin.shop_listing.service.ShopBasicInfoService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.CouponEditPageOutServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopBasicInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

/**
 * クーポン情報編集画面表示アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4245 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CouponEditPageAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport
     * #doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // リクエストから店舗コードを取得
        String shopCd = context.getRequest().getParameter("shopCd");

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ShopBasicInfoService basicInfoservice =
                (ShopBasicInfoService) ac.getBean("shopBasicInfoService");

        // 契約店舗基本情報を取得
        ShopBasicInfoOutServiceBean baiscInfoOutBean = basicInfoservice.searchShopBasicInfo(shopCd);

        // 既存のクーポン情報取得
        CouponEditPageService service = (CouponEditPageService) ac.getBean("couponEditPageService");
        CouponEditPageOutServiceBean outBean = service.searchCouponInfo(shopCd);

        // ViewHelper設定
        CouponEditView view =
                new CouponEditView(SystemProperties.getProperty("COUPON_INFO_DISPLAY_LIMIT"));
        BeanUtils.copyProperties(view, outBean);
        BeanUtils.copyProperties(view, baiscInfoOutBean);

        context.setForward("success", view);

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.BaseActionSupport
     * #isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_LISTING);
    }

}

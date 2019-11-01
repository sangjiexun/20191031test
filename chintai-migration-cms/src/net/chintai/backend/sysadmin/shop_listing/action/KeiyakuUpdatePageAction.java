/*
 * $Id: KeiyakuUpdatePageAction.java 4280 2009-07-06 12:03:54Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/18  BGT)李昊燮     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_listing.action.view.KeiyakuUpdateView;
import net.chintai.backend.sysadmin.shop_listing.service.KeiyakuRegisterPageService;
import net.chintai.backend.sysadmin.shop_listing.service.KeiyakuUpdatePageService;
import net.chintai.backend.sysadmin.shop_listing.service.ShopBasicInfoService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuUpdatePageOutServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopBasicInfoOutServiceBean;

/**
 * 契約情報更新画面表示アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4280 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuUpdatePageAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#
     * doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データを取得
        String pkShopListingSeq = context.getRequest().getParameter("pkShopListingSeq");
        String shopCd = context.getRequest().getParameter("shopCd");

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        KeiyakuUpdatePageService service =
                (KeiyakuUpdatePageService) ac.getBean("keiyakuUpdatePageService");

        // 店舗基本情報と既存契約情報を取得します。
        KeiyakuUpdatePageInServiceBean inBean = new KeiyakuUpdatePageInServiceBean();
        inBean.setPkShopListingSeq(pkShopListingSeq);
        inBean.setShopCd(shopCd);
        KeiyakuUpdatePageOutServiceBean outBean = service.searchKeiyakuInfo(inBean);

        // ViewHelper設定
        KeiyakuUpdateView view = new KeiyakuUpdateView();
        BeanUtils.copyProperties(view, outBean);

        // 更新時、契約種別の変化により行う処理が変わるので別の名前で保持しておく。
        view.setKeiyakuShubetsuBefore(outBean.getKeiyakuShubetsu());

        view.setKeiyakuStartYear(outBean.getKeiyakuStartYm().substring(0, 4));
        view.setKeiyakuStartMonth(outBean.getKeiyakuStartYm().substring(4));

        if (StringUtils.isNotEmpty(outBean.getKeiyakuEndYm())) {
            view.setKeiyakuEndYear(outBean.getKeiyakuEndYm().substring(0, 4));
            view.setKeiyakuEndMonth(outBean.getKeiyakuEndYm().substring(4));
        } else {
            view.setKeiyakuEndYear(null);
            view.setKeiyakuEndMonth(null);
        }

        if (StringUtils.isNotEmpty(outBean.getCouponStartYm())) {
            view.setCouponStartYear(outBean.getCouponStartYm().substring(0, 4));
            view.setCouponStartMonth(outBean.getCouponStartYm().substring(4));
        } else {
            view.setCouponStartYear(null);
            view.setCouponStartMonth(null);
        }

        if (StringUtils.isNotEmpty(outBean.getCouponEndYm())) {
            view.setCouponEndYear(outBean.getCouponEndYm().substring(0, 4));
            view.setCouponEndMonth(outBean.getCouponEndYm().substring(4));
        } else {
            view.setCouponEndYear(null);
            view.setCouponEndMonth(null);
        }

        if (StringUtils.isNotEmpty(outBean.getLinkStartYm())) {
            view.setLinkStartYear(outBean.getLinkStartYm().substring(0, 4));
            view.setLinkStartMonth(outBean.getLinkStartYm().substring(4));
        } else {
            view.setLinkStartYear(null);
            view.setLinkStartMonth(null);
        }

        if (StringUtils.isNotEmpty(outBean.getLinkEndYm())) {
            view.setLinkEndYear(outBean.getLinkEndYm().substring(0, 4));
            view.setLinkEndMonth(outBean.getLinkEndYm().substring(4));
        } else {
            view.setLinkEndYear(null);
            view.setLinkEndMonth(null);
        }

        // 店舗リスティング契約情報テーブル該当店舗の最終更新日を取得
        KeiyakuRegisterPageService registerPageService =
                (KeiyakuRegisterPageService) ac.getBean("keiyakuRegisterPageService");
        view.setShopListingKeiyakuUpdDt(registerPageService.searchUpdDt(shopCd));

        // 店舗基本情報取得
        ShopBasicInfoService basicInfoService =
                (ShopBasicInfoService) ac.getBean("shopBasicInfoService");
        ShopBasicInfoOutServiceBean basicInfoOutBean =
                basicInfoService.searchShopBasicInfo(outBean.getShopCd());
        BeanUtils.copyProperties(view, basicInfoOutBean);

        context.setForward("success", view);

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java
     * .lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_LISTING);
    }

}

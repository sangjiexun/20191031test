/*
 * $Id: KeiyakuShopInfoAction.java 4405 2009-10-14 01:39:30Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/18  BGT)李昊燮     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_listing.action.view.KeiyakuShopInfoView;
import net.chintai.backend.sysadmin.shop_listing.action.view.KeiyakuShopInfoView.KeiyakuShopInfoDetailView;
import net.chintai.backend.sysadmin.shop_listing.service.CouponEditPageService;
import net.chintai.backend.sysadmin.shop_listing.service.KeiyakuShopInfoService;
import net.chintai.backend.sysadmin.shop_listing.service.ShopBasicInfoService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.CouponEditPageOutServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuShopInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopBasicInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

/**
 * 契約店舗詳細画面アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4405 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuShopInfoAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#
     * doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // リクエストから店舗コードを取得
        String shopCd = context.getRequest().getParameter("shopCd");

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // 店舗基本情報取得
        ShopBasicInfoService basicInfoService =
                (ShopBasicInfoService) ac.getBean("shopBasicInfoService");
        ShopBasicInfoOutServiceBean basicInfoOutBean = basicInfoService.searchShopBasicInfo(shopCd);

        // 店舗契約情報取得
        KeiyakuShopInfoService detailInfoService =
                (KeiyakuShopInfoService) ac.getBean("keiyakuShopInfoService");

        List<KeiyakuShopInfoOutServiceBean> keiyakuInfoList =
                detailInfoService.searchShopInfo(shopCd);

        // クーポン情報取得
        CouponEditPageService couponInfoService =
                (CouponEditPageService) ac.getBean("couponEditPageService");
        CouponEditPageOutServiceBean couponInfoBean = couponInfoService.searchCouponInfo(shopCd);

        // ViewHelper設定
        KeiyakuShopInfoView view = new KeiyakuShopInfoView();

        // 店舗契約情報が存在しない場合、「新しい契約情報を登録する」リンク表示フラグを活性化
        if (keiyakuInfoList.size() == 0) {
            view.setYukouKihonKeiyakuFlg(ConstValues.FLG_ON);
        }

        List<KeiyakuShopInfoDetailView> detailViewList = new ArrayList<KeiyakuShopInfoDetailView>();
        int count = 0;
        for (KeiyakuShopInfoOutServiceBean keiyakuShopInfoOutServiceBean : keiyakuInfoList) {
            KeiyakuShopInfoDetailView tmpBean = view.new KeiyakuShopInfoDetailView();
            BeanUtils.copyProperties(tmpBean, keiyakuShopInfoOutServiceBean);

            // 該当店舗の最新契約情報で「新しい契約情報を登録する」リンク表示可否を判断
            if (count == 0) {
                if (ConstValues.FLG_OFF.equals(tmpBean.getLinkFlg()) &&
                        ConstValues.FLG_OFF.equals(tmpBean.getKeiyakuShubetsu())) {
                    view.setYukouKihonKeiyakuFlg(ConstValues.FLG_ON);
                } else {
                    view.setYukouKihonKeiyakuFlg(ConstValues.FLG_OFF);
                }

            }
            count++;

            detailViewList.add(tmpBean);
        }
        view.setKihonKeiyakuInfoList(detailViewList);
        BeanUtils.copyProperties(view, couponInfoBean);
        BeanUtils.copyProperties(view, basicInfoOutBean);

        // 出稿情報を取得します。
        view.setMediaInfo(detailInfoService.searchShopMediaInfo(shopCd));

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

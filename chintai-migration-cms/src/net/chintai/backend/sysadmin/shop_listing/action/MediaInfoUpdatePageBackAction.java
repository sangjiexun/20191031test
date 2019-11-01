/*
 * $Id: MediaInfoUpdatePageBackAction.java 4279 2009-07-06 12:03:03Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/14     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_listing.action.view.MediaInfoUpdateView;
import net.chintai.backend.sysadmin.shop_listing.service.MediaInfoUpdatePageService;
import net.chintai.backend.sysadmin.shop_listing.service.ShopBasicInfoService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoUpdatePageOutServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopBasicInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopListingIconBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 出稿情報編集画面に戻るアクション。
 *
 * @author Lee Hosup
 * @version $Revision: 4279 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoUpdatePageBackAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#
     * doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データを取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        // リクエストから店舗コードを取得
        String shopCd = context.getRequest().getParameter("shopCd");

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // 店舗基本情報を取得
        ShopBasicInfoService shopBasicInfoService =
                (ShopBasicInfoService) ac.getBean("shopBasicInfoService");

        ShopBasicInfoOutServiceBean basicInfoOutBean =
                shopBasicInfoService.searchShopBasicInfo(shopCd);

        // 期表示に必要なデータを取得
        MediaInfoUpdatePageService service =
                (MediaInfoUpdatePageService) ac.getBean("mediaInfoUpdatePageService");

        MediaInfoUpdatePageOutServiceBean outBean = service.searchMediaInfo(shopCd);

        // ViewHelper設定
        MediaInfoUpdateView view = new MediaInfoUpdateView();
        BeanUtils.copyProperties(view, outBean);
        BeanUtils.copyProperties(view, basicInfoOutBean);
        BeanUtils.copyProperties(view, form);

        List<ShopListingIconBean> detailList = new ArrayList<ShopListingIconBean>();
        List<String> chkAppeal = Arrays.asList(view.getChkAppeal());
        List<String> chkListing = Arrays.asList(view.getChkListing());

        // アイコン選択値を戻す
        for (ShopListingIconBean detailOutBean : outBean.getDetailList()) {

            ShopListingIconBean detailView = new ShopListingIconBean();
            BeanUtils.copyProperties(detailView, detailOutBean);
            if (chkAppeal.contains(detailView.getIconId())) {
                detailView.setAppealChkFlg(ConstValues.FLG_ON);
            } else {
                detailView.setAppealChkFlg(ConstValues.FLG_OFF);
            }

            if (chkListing.contains(detailView.getIconId())) {
                detailView.setListingChkFlg(ConstValues.FLG_ON);
            } else {
                detailView.setListingChkFlg(ConstValues.FLG_OFF);
            }

            detailList.add(detailView);
        }
        view.setDetailList(detailList);

        view.setMedaiInfoEkiList(service.searchEkiOptions(view.getSelectEkiValue()));
        view.setMedaiInfoCityList(service.searchCityOptions(view.getSelectCityValue()));

        BeanUtils.copyProperties(view, form);

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

/*
 * $Id: KeiyakuRegisterPageAction.java 4280 2009-07-06 12:03:54Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/18  BGT)李昊燮     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_listing.action.view.KeiyakuRegisterView;
import net.chintai.backend.sysadmin.shop_listing.service.KeiyakuRegisterPageService;
import net.chintai.backend.sysadmin.shop_listing.service.ShopBasicInfoService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopBasicInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

/**
 * 契約情報登録画面表示アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4280 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuRegisterPageAction extends BaseActionSupport {

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
        ShopBasicInfoService service = (ShopBasicInfoService) ac.getBean("shopBasicInfoService");

        // 契約店舗詳細情報を取得
        ShopBasicInfoOutServiceBean outBean = service.searchShopBasicInfo(shopCd);

        // ViewHelper設定
        KeiyakuRegisterView view = new KeiyakuRegisterView();
        BeanUtils.copyProperties(view, outBean);

        // 店舗リスティング契約情報テーブル該当店舗のデータが存在する場合、最終更新日を取得
        KeiyakuRegisterPageService registerPageService = (KeiyakuRegisterPageService) ac.getBean("keiyakuRegisterPageService");
        view.setUpdDt(registerPageService.searchUpdDt(shopCd));

        // ラジオボタンの初期値設定。
        view.setCouponKeiyakuFlg("0"); // クーポン契約しない。
        view.setLinkKeiyakuFlg("0"); // 外部リンク契約しない。

        context.setForward("success", view);
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#
     * isAuthorized(java .lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_LISTING);
    }

}

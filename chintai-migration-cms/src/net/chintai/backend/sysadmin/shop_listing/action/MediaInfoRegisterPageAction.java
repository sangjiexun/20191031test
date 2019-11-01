/*
 * $Id: MediaInfoRegisterPageAction.java 4306 2009-07-13 11:54:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/18     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_listing.action.view.MediaInfoRegisterView;
import net.chintai.backend.sysadmin.shop_listing.service.MediaInfoRegisterPageService;
import net.chintai.backend.sysadmin.shop_listing.service.ShopBasicInfoService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoRegisterPageOutServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopBasicInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

/**
 * 出稿情報（仮保存）登録画面表示アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4306 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoRegisterPageAction extends BaseActionSupport {

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

        // 店舗基本情報を取得
        ShopBasicInfoService shopBasicInfoService =
                (ShopBasicInfoService) ac.getBean("shopBasicInfoService");

        ShopBasicInfoOutServiceBean basicInfoOutBean =
                shopBasicInfoService.searchShopBasicInfo(shopCd);

        // 出稿情報登録ページ初期表示に必要なデータを取得
        MediaInfoRegisterPageService service =
                (MediaInfoRegisterPageService) ac.getBean("mediaInfoRegisterPageService");

        MediaInfoRegisterPageOutServiceBean outBean = service.searchDefaultInfo(shopCd);

        // ViewHelper設定
        MediaInfoRegisterView view = new MediaInfoRegisterView();
        BeanUtils.copyProperties(view, outBean);
        BeanUtils.copyProperties(view, basicInfoOutBean);

        // 店舗画像ラジオボタンの初期値を設定します。
        view.setPicFlg("1");

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

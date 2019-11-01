/*
 * $Id: MediaInfoUpdatePageAction.java 4246 2009-03-23 09:00:00Z lee-hosup $
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
import net.chintai.backend.sysadmin.shop_listing.action.view.MediaInfoUpdateView;
import net.chintai.backend.sysadmin.shop_listing.service.MediaInfoUpdatePageService;
import net.chintai.backend.sysadmin.shop_listing.service.ShopBasicInfoService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoUpdatePageOutServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopBasicInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

/**
 * 出稿情報（仮保存）更新画面表示アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoUpdatePageAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#
     * doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面からデータ取得
        String shopCd = context.getRequest().getParameter("shopCd");

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // 店舗基本情報を取得
        ShopBasicInfoService shopBasicInfoService =
                (ShopBasicInfoService) ac.getBean("shopBasicInfoService");
        ShopBasicInfoOutServiceBean basicInfoOutBean =
                shopBasicInfoService.searchShopBasicInfo(shopCd);

        // 画面初期表示値を取得
        MediaInfoUpdatePageService service =
                (MediaInfoUpdatePageService) ac.getBean("mediaInfoUpdatePageService");

        MediaInfoUpdatePageOutServiceBean outBean = service.searchMediaInfo(shopCd);

        // ViewHelper設定
        MediaInfoUpdateView view = new MediaInfoUpdateView();
        BeanUtils.copyProperties(view, outBean);
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

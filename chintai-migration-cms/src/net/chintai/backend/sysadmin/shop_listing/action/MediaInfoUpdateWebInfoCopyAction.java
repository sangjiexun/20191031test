/*
 * $Id: MediaInfoUpdateWebInfoCopyAction.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/18     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_listing.action.view.MediaInfoUpdateView;
import net.chintai.backend.sysadmin.shop_listing.service.MediaInfoWebDataCopyService;
import net.chintai.backend.sysadmin.shop_listing.service.ShopBasicInfoService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoWebDataCopyServiceOutBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopBasicInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

/**
 * 現在WEB掲載中の出稿情報を出稿情報編集画面にコピーするアクション。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoUpdateWebInfoCopyAction extends BaseActionSupport {

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

        // 本番データを取得
        MediaInfoWebDataCopyService service =
                (MediaInfoWebDataCopyService) ac.getBean("mediaInfoWebDataCopyService");
        MediaInfoWebDataCopyServiceOutBean outBean = service.searchWebMediaInfo(shopCd);

        // ViewHelper設定
        MediaInfoUpdateView view = new MediaInfoUpdateView();
        BeanUtils.copyProperties(view, outBean);
        BeanUtils.copyProperties(view, basicInfoOutBean);

        view.setUpdDt(context.getRequest().getParameter("updDt"));

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

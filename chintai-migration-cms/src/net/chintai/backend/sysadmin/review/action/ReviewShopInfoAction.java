/*
 * $Id: ReviewShopInfoAction.java 4339 2009-08-19 01:37:50Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/12  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.review.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.review.action.view.ReviewShopInfoView;
import net.chintai.backend.sysadmin.review.service.ReviewShopInfoService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopInfoInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopDetailInfoSearchService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDetailInfoSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDetailInfoSearchOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.ImageUrlFromMasterServerService;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUrlFromMasterServerInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUrlFromMasterServerOutServiceBean;

/**
 * 店舗詳細アクション
 * @author Lee Hosup
 * @version $Revision: 4339 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopInfoAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.REVIEW);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // パラメータから店舗コードを取得
        String shopCd = context.getRequest().getParameter("shopCd");
        ShopDetailInfoSearchInServiceBean infoInBean = new ShopDetailInfoSearchInServiceBean();
        infoInBean.setShopCd(shopCd);

        // Injection(管理系サービスから店舗情報を取得)
        ApplicationContext ac = getWebApplicationContext();
        ShopDetailInfoSearchService shopInfoService =
                (ShopDetailInfoSearchService) ac.getBean("shopDetailInfoSearchService");

        // 管理系店舗詳細情報検索開始
        ShopDetailInfoSearchOutServiceBean shopInfo =
                shopInfoService.shopSearchByShopCd(infoInBean);
/*
        // 画像別作業コードを取得。
        String mapPctWorkCode = ApplicationResources.getProperty("shop.mapPctWorkCode");
        String photo1WorkCode = ApplicationResources.getProperty("shop.photo1WorkCode");
        String photo2WorkCode = ApplicationResources.getProperty("shop.photo2WorkCode");
        String photo3WorkCode = ApplicationResources.getProperty("shop.photo3WorkCode");
        String photo4WorkCode = ApplicationResources.getProperty("shop.photo4WorkCode");

        // マスタ画像パスを取得用InServiceBeanを設定。
        ImageUrlFromMasterServerInServiceBean imgUrlInServiceBean =
                new ImageUrlFromMasterServerInServiceBean();
        List<String> inWorkCdList = new ArrayList<String>();

        if (ConstValues.FLG_ON.equals(shopInfo.getShopMapPctFlgOrg())) {
            inWorkCdList.add(mapPctWorkCode);
        }
        if (ConstValues.FLG_ON.equals(shopInfo.getShopPhoto1FlgOrg())) {
            inWorkCdList.add(photo1WorkCode);
        }
        if (ConstValues.FLG_ON.equals(shopInfo.getShopPhoto2FlgOrg())) {
            inWorkCdList.add(photo2WorkCode);
        }
        if (ConstValues.FLG_ON.equals(shopInfo.getShopPhoto3FlgOrg())) {
            inWorkCdList.add(photo3WorkCode);
        }
        if (ConstValues.FLG_ON.equals(shopInfo.getShopPhoto4FlgOrg())) {
            inWorkCdList.add(photo4WorkCode);
        }

        imgUrlInServiceBean.setShopCd(infoInBean.getShopCd());
        imgUrlInServiceBean.setWorkCdList(inWorkCdList);

        // マスタ画像サーバーの画像パスを取得するInjection
        ImageUrlFromMasterServerService imageUrlFromMasterServerService =
                (ImageUrlFromMasterServerService) ac.getBean("imageUrlFromMasterServerService");

        imgUrlInServiceBean.setWorkCdList(inWorkCdList);

        // マスタ画像パスを取得用OutServiceBeanを設定。
        ImageUrlFromMasterServerOutServiceBean imgUrlOutServiceBean = null;

        // マスタ画像サーバーパスを取得。
        imgUrlOutServiceBean =
                imageUrlFromMasterServerService.imageUrlFromMasterServer(imgUrlInServiceBean);
*/
        // WEB審査情報を検索
        ReviewShopInfoService reviewShopInfoService =
                (ReviewShopInfoService) ac.getBean("reviewShopInfoService");
        ReviewShopInfoInServiceBean inBean = new ReviewShopInfoInServiceBean();
        inBean.setShopCd(shopCd);

        ReviewShopInfoOutServiceBean outBean = reviewShopInfoService.selectShopInfo(inBean);

        // viewHelper設定
        ReviewShopInfoView view = new ReviewShopInfoView();
        BeanUtils.copyProperties(view, shopInfo);
        BeanUtils.copyProperties(view, outBean);
/*
        // 取得された画像パスをViewHelperに設定。
        List<String> outWorkCdList = imgUrlOutServiceBean.getWorkCdList();
        for (int i = 0; i < outWorkCdList.size(); i++) {
            String outWorkCd = outWorkCdList.get(i);
            if (mapPctWorkCode.equals(outWorkCd)) {
                view.setShopMapPctFilePath(imgUrlOutServiceBean.getImageUrlPathList().get(i));
            }
            if (photo1WorkCode.equals(outWorkCd)) {
                view.setShopPhoto1FilePath(imgUrlOutServiceBean.getImageUrlPathList().get(i));
            }
            if (photo2WorkCode.equals(outWorkCd)) {
                view.setShopPhoto2FilePath(imgUrlOutServiceBean.getImageUrlPathList().get(i));
            }
            if (photo3WorkCode.equals(outWorkCd)) {
                view.setShopPhoto3FilePath(imgUrlOutServiceBean.getImageUrlPathList().get(i));
            }
            if (photo4WorkCode.equals(outWorkCd)) {
                view.setShopPhoto4FilePath(imgUrlOutServiceBean.getImageUrlPathList().get(i));
            }
        }
*/
        // 郵便コード編集
        if (view.getZipCd() != null) {
            String zipCd = view.getZipCd().substring(0, 3) + "-" + view.getZipCd().substring(3);
            view.setZipCd(zipCd);
        }

        context.setForward("success", view);
    }
}

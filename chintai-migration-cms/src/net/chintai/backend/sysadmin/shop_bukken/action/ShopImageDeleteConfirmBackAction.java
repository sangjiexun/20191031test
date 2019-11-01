/*
 * $Id: ShopImageDeleteConfirmBackAction.java 4295 2009-07-07 12:59:59Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)沈鍾沿     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopImageDeleteView;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 店舗画像削除確認画面の店舗画像削除画面に戻るアクション
 *
 * @author Sim-JongYeon
 * @version $Revision: 4295 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopImageDeleteConfirmBackAction extends BaseActionSupport {

    /** 店舗画像フラグ : 画像ファイルの表示フラグ */
    /* 2009/06 李昊燮コメント処理
    private static final String C_IMG_FLG_1 = "1";
    */


    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        /* 2009/06 李昊燮コメント処理 (戻る処理にDBからもう一度データを取得する必要はないと思います。)
        ShopImageInfoSearchInServiceBean inServiceBean = new ShopImageInfoSearchInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ShopImageInfoSearchService shopImageInfoSearchService =
                (ShopImageInfoSearchService) ac.getBean("shopImageInfoSearchService");

        // 店舗画像情報を取得
        ShopImageInfoSearchOutServiceBean imageInfo =
                shopImageInfoSearchService.shopImageInfoSearchByShopCd(inServiceBean);

        // 画像の表示フラグを取得。
        String mapPctFlg = imageInfo.getShopMapPctFlgOrg();
        String photo1Flg = imageInfo.getShopPhoto1FlgOrg();
        String photo2Flg = imageInfo.getShopPhoto2FlgOrg();

        // 画像別作業コードを取得。
        String mapPctWorkCode = ApplicationResources.getProperty("shop.mapPctWorkCode");
        String photo1WorkCode = ApplicationResources.getProperty("shop.photo1WorkCode");
        String photo2WorkCode = ApplicationResources.getProperty("shop.photo2WorkCode");

        // マスタ画像パスを取得用InServiceBeanを設定。
        ImageUrlFromMasterServerInServiceBean imgUrlInServiceBean =
                new ImageUrlFromMasterServerInServiceBean();
        List<String> inWorkCdList = new ArrayList<String>();

        if (C_IMG_FLG_1.equals(mapPctFlg)) {
            inWorkCdList.add(mapPctWorkCode);
        }
        if (C_IMG_FLG_1.equals(photo1Flg)) {
            inWorkCdList.add(photo1WorkCode);
        }
        if (C_IMG_FLG_1.equals(photo2Flg)) {
            inWorkCdList.add(photo2WorkCode);
        }
        imgUrlInServiceBean.setShopCd(inServiceBean.getShopCd());
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

        // 店舗画像情報をViewHelperに設定
        ShopImageDeleteView view = new ShopImageDeleteView();
        BeanUtils.copyProperties(view, imageInfo);

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
        }
        */

        ShopImageDeleteView view = new ShopImageDeleteView();
        BeanUtils.copyProperties(view, form);

        context.setForward("success", view);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }

}

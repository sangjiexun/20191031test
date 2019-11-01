/*
 * $Id: ShopImageDeleteAction.java 4295 2009-07-07 12:59:59Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)沈鍾沿     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopImageDeleteView;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopImageInfoSearchService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopImageInfoSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopImageInfoSearchOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.ImageUrlFromMasterServerService;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUrlFromMasterServerInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUrlFromMasterServerOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 店舗画像削除画面を表示するアクション
 *
 * @author Sim-JongYeon
 * @version $Revision: 4295 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopImageDeleteAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
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
        String photo3Flg = imageInfo.getShopPhoto3FlgOrg();
        String photo4Flg = imageInfo.getShopPhoto4FlgOrg();

        // 表示する画像が1件も無い場合はエラーとする。
        if (StringUtils.equals(mapPctFlg, "0") &&
                StringUtils.equals(photo1Flg, "0") &&
                StringUtils.equals(photo2Flg, "0") &&
                StringUtils.equals(photo3Flg, "0") &&
                StringUtils.equals(photo4Flg, "0")) {
            context.setError("WARN.M.SHOP_BUKKEN.0065");
            context.setForward("fail");
            return;
        }

        // 画像別作業コードを取得。
        String mapPctWorkCode = ApplicationResources.getProperty("shop.mapPctWorkCode");
        String photo1WorkCode = ApplicationResources.getProperty("shop.photo1WorkCode");
        String photo2WorkCode = ApplicationResources.getProperty("shop.photo2WorkCode");
        String photo3WorkCode = ApplicationResources.getProperty("shop.photo3WorkCode");
        String photo4WorkCode = ApplicationResources.getProperty("shop.photo4WorkCode");

        // マスタ画像パスを取得用InServiceBeanを設定。
        ImageUrlFromMasterServerInServiceBean imgUrlInServiceBean = new ImageUrlFromMasterServerInServiceBean();
        List<String> inWorkCdList = new ArrayList<String>();

        if (ConstValues.FLG_ON.equals(mapPctFlg)) {
            inWorkCdList.add(mapPctWorkCode);
        }
        if (ConstValues.FLG_ON.equals(photo1Flg)) {
            inWorkCdList.add(photo1WorkCode);
        }
        if (ConstValues.FLG_ON.equals(photo2Flg)) {
            inWorkCdList.add(photo2WorkCode);
        }
        if (ConstValues.FLG_ON.equals(photo3Flg)) {
            inWorkCdList.add(photo3WorkCode);
        }
        if (ConstValues.FLG_ON.equals(photo4Flg)) {
            inWorkCdList.add(photo4WorkCode);
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
        imgUrlOutServiceBean = imageUrlFromMasterServerService.imageUrlFromMasterServer(imgUrlInServiceBean);

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
            if (photo3WorkCode.equals(outWorkCd)) {
                view.setShopPhoto3FilePath(imgUrlOutServiceBean.getImageUrlPathList().get(i));
            }
            if (photo4WorkCode.equals(outWorkCd)) {
                view.setShopPhoto4FilePath(imgUrlOutServiceBean.getImageUrlPathList().get(i));
            }
        }

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

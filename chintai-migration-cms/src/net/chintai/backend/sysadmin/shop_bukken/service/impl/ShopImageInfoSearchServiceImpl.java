/*
 * $Id: ShopImageInfoSearchServiceImpl.java 4295 2009-07-07 12:59:59Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)沈鍾沿     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopImageInfoSearchDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopImageInfoSearchParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopImageInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopImageInfoSearchService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopImageInfoSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopImageInfoSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * ShopImageInfoSearchServiceの実装クラス
 *
 * @author Sim-JongYeon
 * @version $Revision: 4295 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopImageInfoSearchServiceImpl implements ShopImageInfoSearchService {

    /** 店舗画像照会DAO */
    private ShopImageInfoSearchDao shopImageInfoSearchDao = null;

    /**
     * shopImageInfoSearchDaoを設定する
     * @param shopImageInfoSearchDao
     */
    public void setShopImageInfoSearchDao(ShopImageInfoSearchDao shopImageInfoSearchDao) {
        this.shopImageInfoSearchDao = shopImageInfoSearchDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopImageInfoSearchService#shopSearchByShopCd(net.chintai.backend.sysadmin.shop_bukken.service.ShopImageInfoSearchInServiceBean)
     */
    public ShopImageInfoSearchOutServiceBean shopImageInfoSearchByShopCd(
            ShopImageInfoSearchInServiceBean inServiceBean) throws Exception {

        // 店舗コードを取得
        ShopImageInfoSearchParamBean paramBean = new ShopImageInfoSearchParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // 店舗コードから店舗画像情報検索
        Object rsShopImageInfo =
                shopImageInfoSearchDao.selectShopImageInfoSearchByShopCd(paramBean);
        ShopImageInfo shopImageInfo = (ShopImageInfo) rsShopImageInfo;

        // 店舗情報をOutServiceBeanに設定
        ShopImageInfoSearchOutServiceBean outServiceBean = new ShopImageInfoSearchOutServiceBean();
        BeanUtils.copyProperties(outServiceBean, shopImageInfo);

        // 店舗地図、画像パス設定
        String webImgRoot = ApplicationResources.getProperty("shop.webTmpImgRoot");
        String mapPctWorkCode = ApplicationResources.getProperty("shop.mapPctWorkCode");
        String photo1WorkCode = ApplicationResources.getProperty("shop.photo1WorkCode");
        String photo2WorkCode = ApplicationResources.getProperty("shop.photo2WorkCode");
        String photo3WorkCode = ApplicationResources.getProperty("shop.photo3WorkCode");
        String photo4WorkCode = ApplicationResources.getProperty("shop.photo4WorkCode");
        String photoFileExtensions = ApplicationResources.getProperty("shop.jpgFileExtensions");

        String imgPath = null;
        String shopCd = shopImageInfo.getShopCd();

        if (ConstValues.FLG_ON.equals(shopImageInfo.getShopMapPctFlgOrg())) {
            imgPath =
                    webImgRoot + shopCd + "/" + mapPctWorkCode + "/" + shopCd + photoFileExtensions;
            outServiceBean.setShopMapPctFilePath(imgPath);
        }

        if (ConstValues.FLG_ON.equals(shopImageInfo.getShopPhoto1FlgOrg())) {
            imgPath =
                    webImgRoot + shopCd + "/" + photo1WorkCode + "/" + shopCd + photoFileExtensions;
            outServiceBean.setShopPhoto1FilePath(imgPath);
        }

        if (ConstValues.FLG_ON.equals(shopImageInfo.getShopPhoto2FlgOrg())) {
            imgPath =
                    webImgRoot + shopCd + "/" + photo2WorkCode + "/" + shopCd + photoFileExtensions;
            outServiceBean.setShopPhoto2FilePath(imgPath);
        }

        if (ConstValues.FLG_ON.equals(shopImageInfo.getShopPhoto3FlgOrg())) {
            imgPath =
                    webImgRoot + shopCd + "/" + photo3WorkCode + "/" + shopCd + photoFileExtensions;
            outServiceBean.setShopPhoto3FilePath(imgPath);
        }

        if (ConstValues.FLG_ON.equals(shopImageInfo.getShopPhoto4FlgOrg())) {
            imgPath =
                    webImgRoot + shopCd + "/" + photo4WorkCode + "/" + shopCd + photoFileExtensions;
            outServiceBean.setShopPhoto4FilePath(imgPath);
        }

        return outServiceBean;
    }
}

/*
 * $Id: ShopDetailInfoSearchServiceImpl.java 4295 2009-07-07 12:59:59Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)沈鍾沿     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopDetailInfoSearchDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopDetailInfoSearchParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopDetailInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopDetailInfoSearchService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDetailInfoSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDetailInfoSearchOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDownloadInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDownloadOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ShopDetailInfoSearchServiceの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 4295 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopDetailInfoSearchServiceImpl implements ShopDetailInfoSearchService {

    /** 店舗詳細照会DAO */
    private ShopDetailInfoSearchDao shopDetailInfoSearchDao = null;

	@Autowired
	private ShopService shopService;

    /**
     * shopDetailInfoSearchDaoを設定する
     * @param shopDetailInfoSearchDao
     */
    public void setShopDetailInfoSearchDao(ShopDetailInfoSearchDao shopDetailInfoSearchDao) {
        this.shopDetailInfoSearchDao = shopDetailInfoSearchDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopDetailInfoSearchService#shopSearchByShopCd(net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDetailInfoSearchInServiceBean)
     */
    public ShopDetailInfoSearchOutServiceBean shopSearchByShopCd(
            ShopDetailInfoSearchInServiceBean inServiceBean) throws Exception {

        // 店舗コードを取得
        ShopDetailInfoSearchParamBean paramBean = new ShopDetailInfoSearchParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 店舗コードから店舗詳細検索
        Object rsShopDetailInfo =
                shopDetailInfoSearchDao.selectShopDetailInfoSearchByShopCd(paramBean);

        ShopDetailInfo shopDetailInfo = (ShopDetailInfo) rsShopDetailInfo;

        ShopDetailInfoSearchOutServiceBean shopOutServiceBean =
                new ShopDetailInfoSearchOutServiceBean();
        try {
            BeanUtils.copyProperties(shopOutServiceBean, shopDetailInfo);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 店舗地図、画像パス設定
        String webImgRoot = ApplicationResources.getProperty("shop.webTmpImgRoot");
        String mapPctWorkCode = ApplicationResources.getProperty("shop.mapPctWorkCode");
        String photo1WorkCode = ApplicationResources.getProperty("shop.photo1WorkCode");
        String photo2WorkCode = ApplicationResources.getProperty("shop.photo2WorkCode");
        String photo3WorkCode = ApplicationResources.getProperty("shop.photo3WorkCode"); //2009.06 李昊燮追加
        String photo4WorkCode = ApplicationResources.getProperty("shop.photo4WorkCode"); //2009.06 李昊燮追加

        String gifFileExtensions = ApplicationResources.getProperty("shop.gifFileExtensions");
        String jpgFileExtensions = ApplicationResources.getProperty("shop.jpgFileExtensions");

        String shopMapPctFlgOrg = shopDetailInfo.getShopMapPctFlgOrg();
        String shopPhoto1FlgOrg = shopDetailInfo.getShopPhoto1FlgOrg();
        String shopPhoto2FlgOrg = shopDetailInfo.getShopPhoto2FlgOrg();
        String shopPhoto3FlgOrg = shopDetailInfo.getShopPhoto3FlgOrg(); //2009.06 李昊燮追加
        String shopPhoto4FlgOrg = shopDetailInfo.getShopPhoto4FlgOrg(); //2009.06 李昊燮追加

        String imgPath = null;
        String shopCd = shopDetailInfo.getShopCd();

        if (ConstValues.FLG_ON.equals(shopMapPctFlgOrg)) {
            imgPath =
                    webImgRoot + shopCd + "/" + mapPctWorkCode + "/" + shopCd + gifFileExtensions;
            shopOutServiceBean.setShopMapPctFilePath(imgPath);
        }

        if (ConstValues.FLG_ON.equals(shopPhoto1FlgOrg)) {
            imgPath =
                    webImgRoot + shopCd + "/" + photo1WorkCode + "/" + shopCd + jpgFileExtensions;
            shopOutServiceBean.setShopPhoto1FilePath(imgPath);
        }

        if (ConstValues.FLG_ON.equals(shopPhoto2FlgOrg)) {
            imgPath =
                    webImgRoot + shopCd + "/" + photo2WorkCode + "/" + shopCd + jpgFileExtensions;
            shopOutServiceBean.setShopPhoto2FilePath(imgPath);
        }

        if (ConstValues.FLG_ON.equals(shopPhoto3FlgOrg)) {
            imgPath =
                    webImgRoot + shopCd + "/" + photo3WorkCode + "/" + shopCd + jpgFileExtensions;
            shopOutServiceBean.setShopPhoto3FilePath(imgPath);
        }

        if (ConstValues.FLG_ON.equals(shopPhoto4FlgOrg)) {
            imgPath =
                    webImgRoot + shopCd + "/" + photo4WorkCode + "/" + shopCd + jpgFileExtensions;
            shopOutServiceBean.setShopPhoto4FilePath(imgPath);
        }

        shopOutServiceBean.setShopRireki(shopService.selectShopRirekiByPrimaryKey(shopDetailInfo.getPkShopRireki()));
        shopOutServiceBean.setShopRirekiEkis(shopService.selectShopRirekiEkiByPkShopRireki(shopDetailInfo.getPkShopRireki()));
        shopOutServiceBean.setvAspGroupShops(shopService.selectVAspGroupShopByGroupShopcd(shopDetailInfo.getShopCd()));
        shopOutServiceBean.setvShopKeiyakuDetails(shopService.selectVShopKeiyakuDetailCmsDispByShopcd(shopDetailInfo.getShopCd()));
        shopOutServiceBean.setBukkenCount(shopService.getBukkenCountByShopcd(shopDetailInfo.getShopCd()));
        shopOutServiceBean.setShopRirekiCharacters(shopService.selectShopRirekiCharacterByPkShopRireki(shopDetailInfo.getPkShopRireki()));
        shopOutServiceBean.setShopRirekiComments(shopService.selectShopRirekiCommentByPkShopRireki(shopDetailInfo.getPkShopRireki()));
        shopOutServiceBean.setShopRirekiImgs(shopService.selectShopRirekiImgByPkShopRireki(shopDetailInfo.getPkShopRireki()));
        shopOutServiceBean.setShopRirekiProudAreas(shopService.selectShopRirekiProudAreaByPkShopRireki(shopDetailInfo.getPkShopRireki()));
        shopOutServiceBean.setShopRirekiProudEkis(shopService.selectShopRirekiProudEkiByPkShopRireki(shopDetailInfo.getPkShopRireki()));
        shopOutServiceBean.setShopRirekiStaffs(shopService.selectShopRirekiStaffByPkShopRireki(shopDetailInfo.getPkShopRireki()));
        shopOutServiceBean.setShopRirekiCampaigns(shopService.selectShopRirekiCampaignByPkShopRireki(shopDetailInfo.getPkShopRireki()));
        shopOutServiceBean.setCtNayoseSkipShop(shopService.selectCtNayoseSkipShopByPrimaryKey(shopDetailInfo.getShopCd()));
        shopOutServiceBean.setShopReserve(shopService.selectShopReserveByShopcd(shopDetailInfo.getShopCd()));

        return shopOutServiceBean;

    }

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopDetailInfoSearchService#selectShopForDownload(net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDownloadInServiceBean)
	 */
	public List<ShopDownloadOutServiceBean> selectShopForDownload(
			ShopDownloadInServiceBean inServiceBean)
			throws ApplicationException {

		return shopDetailInfoSearchDao.selectShopForDownload(inServiceBean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopDetailInfoSearchService#selectShopReserveForDownload(net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDownloadInServiceBean)
	 */
	public List<ShopDownloadOutServiceBean> selectShopReserveForDownload(
			ShopDownloadInServiceBean inServiceBean)
			throws ApplicationException {

		return shopDetailInfoSearchDao.selectShopReserveForDownload(inServiceBean);
	}

}

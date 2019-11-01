/*
 * $Id: MediaInfoWebRegisterConfirmServiceImpl.java 4284 2009-07-06 12:25:15Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/15  BGT)李昊燮     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.service.impl;

import java.util.List;

import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.shop_listing.ShopListingUtils;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopInfoDao;
import net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoUpdatePageDao;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingCityParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingDataParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingEkiParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingIconParamBean;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopImageInfoDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingCityDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingDataDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingEkiDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingIconDomain;
import net.chintai.backend.sysadmin.shop_listing.service.MediaInfoWebRegisterConfirmService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoWebRegisterConfirmOutServiceBean;

/**
 * MediaInfoWebRegisterConfirmServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4284 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoWebRegisterConfirmServiceImpl implements MediaInfoWebRegisterConfirmService {

    /** 契約店舗詳細取得DAO */
    KeiyakuShopInfoDao keiyakuShopInfoDao;

    /** 出稿情報更新DAO */
    MediaInfoUpdatePageDao mediaInfoUpdatePageDao;

    /*
     * (非 Javadoc)
     *
     * @seenet.chintai.backend.sysadmin.shop_listing.service.
     * MediaInfoWebRegisterConfirmService#searchMediaInfo(java.lang.String)
     */
    public MediaInfoWebRegisterConfirmOutServiceBean searchMediaInfo(String shopCd) {

        // 1.出稿情報を取得
        ShopListingDataParamBean dataParamBean = new ShopListingDataParamBean();
        dataParamBean.setWebUpFlg(ConstValues.FLG_OFF);
        dataParamBean.setShopCd(shopCd);
        ShopListingDataDomain tmpData = mediaInfoUpdatePageDao.searchMediaInfoData(dataParamBean);

        // 2.出稿駅情報取得
        ShopListingEkiParamBean ekiParamBean = new ShopListingEkiParamBean();
        ekiParamBean.setWebUpFlg(ConstValues.FLG_OFF);
        ekiParamBean.setShopCd(shopCd);
        List<ShopListingEkiDomain> tmpEki = mediaInfoUpdatePageDao.searchMedaiInfoEki(ekiParamBean);

        // 3.出稿市区町村情報取得
        ShopListingCityParamBean cityParamBean = new ShopListingCityParamBean();
        cityParamBean.setWebUpFlg(ConstValues.FLG_OFF);
        cityParamBean.setShopCd(shopCd);
        List<ShopListingCityDomain> tmpCity =
                mediaInfoUpdatePageDao.searchMedaiInfoCity(cityParamBean);

        // 4.選択アイコン情報取得
        ShopListingIconParamBean iconParamBean = new ShopListingIconParamBean();
        iconParamBean.setWebUpFlg(ConstValues.FLG_OFF);
        iconParamBean.setShopCd(shopCd);
        List<ShopListingIconDomain> tmpIcon =
                mediaInfoUpdatePageDao.searchMedaiInfoIcon(iconParamBean);

        // 戻り値編集
        MediaInfoWebRegisterConfirmOutServiceBean outBean =
                new MediaInfoWebRegisterConfirmOutServiceBean();

        // 出稿対象駅
        if (tmpEki != null) {
            outBean.setEki(ShopListingUtils.ekiDomainToString(tmpEki));
        }
        // 出稿対象地区町村
        if (tmpCity != null) {
            outBean.setCity(ShopListingUtils.cityDomainToString(tmpCity));
        }

        if (tmpData != null) {
            outBean.setCatchPhrase(tmpData.getCatchPhrase());
            outBean.setAppealComment(tmpData.getAppealComment());
            outBean.setCouponComment1(tmpData.getCouponComment1());
            outBean.setCouponComment2(tmpData.getCouponComment2());
            outBean.setCouponComment3(tmpData.getCouponComment3());
            outBean.setNote(tmpData.getNote());
        }

        // 画像情報を取得
        ShopImageInfoDomain imgInfo = keiyakuShopInfoDao.getShopImgInfo(shopCd);

        // 店舗画像
        outBean.setImgUrl(ShopListingUtils.createShopImgUrl(tmpData, imgInfo));

        // アピールアイコン画像URL && リスティングアイコン画像URL
        outBean.setAppealIcon(ShopListingUtils.getAppIconInfos(tmpIcon));
        outBean.setListingIcon(ShopListingUtils.getLstIconInfos(tmpIcon));

        // 最終更新日
        outBean.setUpdDt(tmpData.getUpdDt());

        return outBean;

    }

    /**
     * 契約店舗詳細取得DAOを設定します。
     * @param keiyakuShopInfoDao 契約店舗詳細取得DAO
     */
    public void setKeiyakuShopInfoDao(KeiyakuShopInfoDao keiyakuShopInfoDao) {
        this.keiyakuShopInfoDao = keiyakuShopInfoDao;
    }

    /**
     * 出稿情報更新DAOを設定します。
     * @param mediaInfoUpdatePageDao 出稿情報更新DAO
     */
    public void setMediaInfoUpdatePageDao(MediaInfoUpdatePageDao mediaInfoUpdatePageDao) {
        this.mediaInfoUpdatePageDao = mediaInfoUpdatePageDao;
    }

}

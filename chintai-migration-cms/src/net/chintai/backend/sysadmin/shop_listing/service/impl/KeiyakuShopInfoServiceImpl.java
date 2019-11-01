/*
 * $Id: KeiyakuShopInfoServiceImpl.java 4315 2009-07-14 11:21:14Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/23     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.shop_listing.ShopListingUtils;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopInfoDao;
import net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoUpdatePageDao;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingCityParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingDataParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingEkiParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingIconParamBean;
import net.chintai.backend.sysadmin.shop_listing.domain.KihonKeiyakuInfoDomin;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopImageInfoDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingCityDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingDataDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingEkiDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingIconDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopLocationInfoDomain;
import net.chintai.backend.sysadmin.shop_listing.service.KeiyakuShopInfoService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuShopInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoForShopInfo;

/**
 * KeiyakuShopInfoServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4315 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuShopInfoServiceImpl implements KeiyakuShopInfoService {

    /** 店舗詳細取得DAO */
    private KeiyakuShopInfoDao keiyakuShopInfoDao;

    /** 出稿情報更新DAO */
    MediaInfoUpdatePageDao mediaInfoUpdatePageDao;

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.service.KeiyakuShopInfoService#
     * searchShopInfo(java.lang.String)
     */
    public List<KeiyakuShopInfoOutServiceBean> searchShopInfo(String shopCd) {

        // 基本契約情報を取得
        List<KihonKeiyakuInfoDomin> keiyakuInfoDomainList =
                keiyakuShopInfoDao.searchKeiyakuBasicInfo(shopCd);

        // domain -> outBean 詰め替え：基本契約情報
        List<KeiyakuShopInfoOutServiceBean> keiyakuInfoOutBeanList = new ArrayList<KeiyakuShopInfoOutServiceBean>();
        for (KihonKeiyakuInfoDomin domin : keiyakuInfoDomainList) {
            KeiyakuShopInfoOutServiceBean keiyakuInfoOutBean = new KeiyakuShopInfoOutServiceBean();
            BeanUtilsWrapper.copyProperties(keiyakuInfoOutBean, domin);
            keiyakuInfoOutBeanList.add(keiyakuInfoOutBean);
        }

        return keiyakuInfoOutBeanList;
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.service.KeiyakuShopInfoService#
     * searchShopMediaInfo(java.lang.String)
     */
    public MediaInfoForShopInfo searchShopMediaInfo(String shopCd) {

        // 店舗位置情報を取得
        ShopLocationInfoDomain locationDomain = keiyakuShopInfoDao.searchLocationInfo(shopCd);
        MediaInfoForShopInfo outBean = new MediaInfoForShopInfo();
        BeanUtilsWrapper.copyProperties(outBean, locationDomain);

        // 1.出稿情報を取得
        // Web掲載出稿データ取得
        ShopListingDataParamBean dataParamBean = new ShopListingDataParamBean();
        dataParamBean.setShopCd(shopCd);
        dataParamBean.setWebUpFlg(ConstValues.FLG_ON);
        ShopListingDataDomain webData = mediaInfoUpdatePageDao.searchMediaInfoData(dataParamBean);

        // 仮保存出稿データ
        dataParamBean.setWebUpFlg(ConstValues.FLG_OFF);
        ShopListingDataDomain tmpData = mediaInfoUpdatePageDao.searchMediaInfoData(dataParamBean);

        if (webData == null && tmpData == null) {
            return outBean;
        }

        // 2.出稿駅情報取得
        ShopListingEkiParamBean ekiParamBean = new ShopListingEkiParamBean();
        ekiParamBean.setShopCd(shopCd);
        ekiParamBean.setWebUpFlg(ConstValues.FLG_ON);
        List<ShopListingEkiDomain> webEki = mediaInfoUpdatePageDao.searchMedaiInfoEki(ekiParamBean);

        ekiParamBean.setWebUpFlg(ConstValues.FLG_OFF);
        List<ShopListingEkiDomain> tmpEki = mediaInfoUpdatePageDao.searchMedaiInfoEki(ekiParamBean);

        // 3.出稿市区町村情報取得
        ShopListingCityParamBean cityParamBean = new ShopListingCityParamBean();
        cityParamBean.setShopCd(shopCd);
        cityParamBean.setWebUpFlg(ConstValues.FLG_ON);
        List<ShopListingCityDomain> webCity =
                mediaInfoUpdatePageDao.searchMedaiInfoCity(cityParamBean);

        cityParamBean.setWebUpFlg(ConstValues.FLG_OFF);
        List<ShopListingCityDomain> tmpCity =
                mediaInfoUpdatePageDao.searchMedaiInfoCity(cityParamBean);

        // 4.選択アイコン情報取得
        ShopListingIconParamBean iconParamBean = new ShopListingIconParamBean();
        iconParamBean.setShopCd(shopCd);
        iconParamBean.setWebUpFlg(ConstValues.FLG_ON);
        List<ShopListingIconDomain> webIcon =
                mediaInfoUpdatePageDao.searchMedaiInfoIcon(iconParamBean);

        iconParamBean.setWebUpFlg(ConstValues.FLG_OFF);
        List<ShopListingIconDomain> tmpIcon =
                mediaInfoUpdatePageDao.searchMedaiInfoIcon(iconParamBean);

        // 出稿対象駅
        if (webEki != null) {
            outBean.setEkiWeb(ShopListingUtils.ekiDomainToString(webEki));
        }
        if (tmpEki != null) {
            outBean.setEkiTmp(ShopListingUtils.ekiDomainToString(tmpEki));
        }
        // 出稿対象地区町村
        if (webCity != null) {
            outBean.setCityWeb(ShopListingUtils.cityDomainToString(webCity));
        }
        if (tmpCity != null) {
            outBean.setCityTmp(ShopListingUtils.cityDomainToString(tmpCity));
        }

        // 出稿情報テーブルのデータ
        if (webData != null) {
            outBean.setCatchPhraseWeb(webData.getCatchPhrase());
            outBean.setAppealCommentWeb(webData.getAppealComment());
            outBean.setCouponComment1Web(webData.getCouponComment1());
            outBean.setCouponComment2Web(webData.getCouponComment2());
            outBean.setCouponComment3Web(webData.getCouponComment3());
            outBean.setNoteWeb(webData.getNote());

        }
        if (tmpData != null) {
            outBean.setCatchPhraseTmp(tmpData.getCatchPhrase());
            outBean.setAppealCommentTmp(tmpData.getAppealComment());
            outBean.setCouponComment1Tmp(tmpData.getCouponComment1());
            outBean.setCouponComment2Tmp(tmpData.getCouponComment2());
            outBean.setCouponComment3Tmp(tmpData.getCouponComment3());
            outBean.setNoteTmp(tmpData.getNote());
        }

        // 画像情報を取得
        ShopImageInfoDomain imgInfo = keiyakuShopInfoDao.getShopImgInfo(shopCd);

        // 店舗画像
        outBean.setImgUrlWeb(ShopListingUtils.createShopImgUrl(webData, imgInfo));
        outBean.setImgUrlTmp(ShopListingUtils.createShopImgUrl(tmpData, imgInfo));

        // アピールアイコン画像URL && リスティングアイコン画像URL
        outBean.setAppealIconWeb(ShopListingUtils.getAppIconInfos(webIcon));
        outBean.setAppealIconTmp(ShopListingUtils.getAppIconInfos(tmpIcon));
        outBean.setListingIconWeb(ShopListingUtils.getLstIconInfos(webIcon));
        outBean.setListingIconTmp(ShopListingUtils.getLstIconInfos(tmpIcon));

        return outBean;

    }

    /**
     * 店舗詳細取得DAOを設定します。
     * @param keiyakuShopInfoDao 店舗詳細取得DAO
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

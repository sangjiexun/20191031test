/*
 * $Id: MediaInfoUpdateCompleteServiceImpl.java 4301 2009-07-13 01:18:57Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/03     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopInfoDao;
import net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoRegisterCompleteDao;
import net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoUpdateCompleteDao;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingCityParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingDataParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingEkiParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingIconParamBean;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopImageInfoDomain;
import net.chintai.backend.sysadmin.shop_listing.service.MediaInfoUpdateCompleteService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoUpdateCompleteInServiceBean;

/**
 * MediaInfoUpdateCompleteServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4301 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoUpdateCompleteServiceImpl implements MediaInfoUpdateCompleteService {

    /** 出稿情報更新DAO */
    MediaInfoUpdateCompleteDao mediaInfoUpdateCompleteDao;

    /** 出稿情報登録DAO */
    MediaInfoRegisterCompleteDao mediaInfoRegisterCompleteDao;

    /** 店舗詳細取得DAO */
    private KeiyakuShopInfoDao keiyakuShopInfoDao;

    /*
     * (非 Javadoc)
     *
     * @seenet.chintai.backend.sysadmin.shop_listing.service.
     * MediaInfoUpdateCompleteService#
     * updateMediaInfo(net.chintai.backend.sysadmin
     * .shop_listing.service.bean.MediaInfoUpdateCompleteInServiceBean)
     */
    public void updateMediaInfo(MediaInfoUpdateCompleteInServiceBean inBean) throws ApplicationException {

        // 店舗コード
        String shopCd = inBean.getShopCd();

        // 出稿情報テーブル更新
        ShopListingDataParamBean dataParamBean = new ShopListingDataParamBean();
        BeanUtilsWrapper.copyProperties(dataParamBean, inBean);

/*        // 画像情報を取得
        ShopImageInfoDomain imgInfo = keiyakuShopInfoDao.getShopImgInfo(inBean.getShopCd());

        // 画像区分を判断
        if (inBean.getPicFlg().endsWith("1") && StringUtils.isNotEmpty(imgInfo.getShopImage())) {
            dataParamBean.setPicFlg("3");
        } else if (inBean.getPicFlg().endsWith("2")
                && StringUtils.isNotEmpty(imgInfo.getManagerImage())) {
            dataParamBean.setPicFlg("4");
        }*/

        mediaInfoUpdateCompleteDao.updateShopMediaData(dataParamBean);

        // 出稿駅テーブル削除後、更新
        mediaInfoUpdateCompleteDao.deleteShopMediaEki(shopCd);

        if (StringUtils.isNotEmpty(inBean.getSelectEkiValue())) {
            ShopListingEkiParamBean ekiParamBean = new ShopListingEkiParamBean();
            BeanUtilsWrapper.copyProperties(ekiParamBean, inBean);
            String[] ekiInfoList = inBean.getSelectEkiValue().split(",");
            for (String ekiInfo : ekiInfoList) {
                ekiParamBean.setEnsenCd(ekiInfo.substring(0, 6));
                ekiParamBean.setEkiCd(ekiInfo.substring(6));
                mediaInfoRegisterCompleteDao.registerShopListingEki(ekiParamBean);
            }
        }

        // 市区町村テーブル削除後、更新
        mediaInfoUpdateCompleteDao.deleteShopMediaCity(shopCd);

        if (StringUtils.isNotEmpty(inBean.getSelectCityValue())) {
            ShopListingCityParamBean cityParamBean = new ShopListingCityParamBean();
            BeanUtilsWrapper.copyProperties(cityParamBean, inBean);
            String[] cityCds = inBean.getSelectCityValue().split(",");
            for (String cityCd : cityCds) {
                cityParamBean.setCityCd(cityCd);
                mediaInfoRegisterCompleteDao.registerShopListingCity(cityParamBean);
            }

        }

        // 出稿アイコンテーブル削除、更新
        mediaInfoUpdateCompleteDao.deleteShopMediaIcon(shopCd);

        if (inBean.getChkAppeal() != null && inBean.getChkAppeal().length > 0) {

            List<String> listingIconIds = new ArrayList<String>();
            if (inBean.getChkListing() != null && inBean.getChkListing().length > 0) {
                listingIconIds = Arrays.asList(inBean.getChkListing());
            }

            for (String iconId : inBean.getChkAppeal()) {
                ShopListingIconParamBean iconParamBean = new ShopListingIconParamBean();
                BeanUtilsWrapper.copyProperties(iconParamBean, inBean);

                iconParamBean.setIconId(iconId);
                // リスティングフラグ設定
                if (listingIconIds.contains(iconId)) {
                    iconParamBean.setListingFlg(ConstValues.FLG_ON);
                } else {
                    iconParamBean.setListingFlg(ConstValues.FLG_OFF);
                }
                mediaInfoRegisterCompleteDao.registerShopListingIcon(iconParamBean);
            }

        }
    }

    /**
     * 出稿情報更新DAOを設定します。
     * @param mediaInfoUpdateCompleteDao 出稿情報更新DAO
     */
    public void setMediaInfoUpdateCompleteDao(MediaInfoUpdateCompleteDao mediaInfoUpdateCompleteDao) {
        this.mediaInfoUpdateCompleteDao = mediaInfoUpdateCompleteDao;
    }

    /**
     * 出稿情報登録DAOを設定します。
     * @param mediaInfoRegisterCompleteDao 出稿情報登録DAO
     */
    public void setMediaInfoRegisterCompleteDao(
            MediaInfoRegisterCompleteDao mediaInfoRegisterCompleteDao) {
        this.mediaInfoRegisterCompleteDao = mediaInfoRegisterCompleteDao;
    }

    /**
     * 店舗詳細取得DAOを設定します。
     * @param keiyakuShopInfoDao 店舗詳細取得DAO
     */
    public void setKeiyakuShopInfoDao(KeiyakuShopInfoDao keiyakuShopInfoDao) {
        this.keiyakuShopInfoDao = keiyakuShopInfoDao;
    }

}

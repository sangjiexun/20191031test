/*
 * $Id: MediaInfoRegisterCompleteServiceImpl.java 4301 2009-07-13 01:18:57Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/12     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopInfoDao;
import net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoRegisterCompleteDao;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingCityParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingDataParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingEkiParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingIconParamBean;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopImageInfoDomain;
import net.chintai.backend.sysadmin.shop_listing.service.MediaInfoRegisterCompleteService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoRegisterCompleteInServiceBean;

import org.apache.commons.lang.StringUtils;

/**
 * MediaInfoRegisterCompleteServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4301 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoRegisterCompleteServiceImpl implements MediaInfoRegisterCompleteService {

    /** 出稿情報登録DAO */
    MediaInfoRegisterCompleteDao mediaInfoRegisterCompleteDao;

    /** 店舗詳細取得DAO */
    private KeiyakuShopInfoDao keiyakuShopInfoDao;

    /*
     * (非 Javadoc)
     *
     * @seenet.chintai.backend.sysadmin.shop_listing.service.
     * MediaInfoRegisterCompleteService#
     * registerMediaInfo(net.chintai.backend.sysadmin
     * .shop_listing.service.bean.MediaRegisterCompleteInServiceBean)
     */
    public void registerMediaInfo(MediaInfoRegisterCompleteInServiceBean inBean) throws ApplicationException {

        // 戻り地
        boolean rsFlg = true;

        // １．店舗リスティング出稿情報登録
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

        String dataSeq = mediaInfoRegisterCompleteDao.registerShopListingData(dataParamBean);
        rsFlg = (StringUtils.isNotEmpty(dataSeq)) ? true : false;

        // ２．店舗リスティングアイコン情報登録
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

                String iconSeq =
                        mediaInfoRegisterCompleteDao.registerShopListingIcon(iconParamBean);
                rsFlg = (StringUtils.isNotEmpty(iconSeq)) ? true : false;
            }

        }

        // ３．店舗リスティング駅情報登録

        if (StringUtils.isNotEmpty(inBean.getSelectEkiValue())) {
            ShopListingEkiParamBean ekiParamBean = new ShopListingEkiParamBean();
            BeanUtilsWrapper.copyProperties(ekiParamBean, inBean);
            String[] ekiInfoList = inBean.getSelectEkiValue().split(",");
            for (String ekiInfo : ekiInfoList) {
                ekiParamBean.setEnsenCd(ekiInfo.substring(0, 6));
                ekiParamBean.setEkiCd(ekiInfo.substring(6));
                String ekiSeq = mediaInfoRegisterCompleteDao.registerShopListingEki(ekiParamBean);
                rsFlg = (StringUtils.isNotEmpty(ekiSeq)) ? true : false;
            }
        }

        // ４．店舗リスティング市区町村テーブル登録
        if (StringUtils.isNotEmpty(inBean.getSelectCityValue())) {
            ShopListingCityParamBean cityParamBean = new ShopListingCityParamBean();
            BeanUtilsWrapper.copyProperties(cityParamBean, inBean);
            String[] cityCds = inBean.getSelectCityValue().split(",");
            for (String cityCd : cityCds) {
                cityParamBean.setCityCd(cityCd);
                String citySeq =
                        mediaInfoRegisterCompleteDao.registerShopListingCity(cityParamBean);
                rsFlg = (StringUtils.isNotEmpty(citySeq)) ? true : false;
            }

        }

        // 仮保存中の出稿データを確認し、2件以上存在する場合エラーを投げてロールバックさせる。
        int cnt = mediaInfoRegisterCompleteDao.searchTmpMediaInfo(inBean.getShopCd());
        if (cnt > 1 || !rsFlg) {
            throw new ApplicationException("ERROR.M.SHOP_LISTING.0005");
        }
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

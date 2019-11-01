/*
 * $Id: MediaInfoWebDataCopyServiceImpl.java 4330 2009-08-04 02:22:29Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/18  BGT)李昊燮     新規作成
 * 2009/08/03  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.properties.ServerProperties;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.shop_listing.ShopListingUtils;
import net.chintai.backend.sysadmin.shop_listing.dao.EkiInfoSearchParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopInfoDao;
import net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoConfirmDao;
import net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoUpdatePageDao;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingCityParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingDataDao;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingDataParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingEkiParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingIconDao;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingIconParamBean;
import net.chintai.backend.sysadmin.shop_listing.domain.KihonKeiyakuInfoDomin;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopImageInfoDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingCityDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingDataDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingEkiDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingIconDomain;
import net.chintai.backend.sysadmin.shop_listing.service.MediaInfoWebDataCopyService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoWebDataCopyServiceOutBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.OptionTagBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopListingIconBean;

import org.apache.commons.lang.StringUtils;

/**
 * MediaInfoWebDataCopyServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4330 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoWebDataCopyServiceImpl implements MediaInfoWebDataCopyService {

    /** 駅情報を取得 */
    MediaInfoUpdatePageDao mediaInfoUpdatePageDao;

    /** アイコンマスタDAO */
    private ShopListingIconDao shopListingIconDao;

    /** 店舗詳細取得DAO */
    private KeiyakuShopInfoDao keiyakuShopInfoDao;

    /** 出稿情報確認DAO */
    private MediaInfoConfirmDao mediaInfoConfirmDao;

    /** 店舗リスティングデータDAO */
    private ShopListingDataDao shopListingDataDao;

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.service.MediaInfoWebDataCopyService
     * # searchWebMediaInfo(java.lang.String)
     */
    public MediaInfoWebDataCopyServiceOutBean searchWebMediaInfo(String shopCd) {

        // 戻り値
        MediaInfoWebDataCopyServiceOutBean outBean = new MediaInfoWebDataCopyServiceOutBean();

        // 1.出稿情報を取得
        ShopListingDataParamBean dataParamBean = new ShopListingDataParamBean();
        dataParamBean.setShopCd(shopCd);
        dataParamBean.setWebUpFlg(ConstValues.FLG_ON);
        ShopListingDataDomain dataDomain =
                mediaInfoUpdatePageDao.searchMediaInfoData(dataParamBean);
        BeanUtilsWrapper.copyProperties(outBean, dataDomain);

        // 2.駅情報を取得
        ShopListingEkiParamBean ekiParamBean = new ShopListingEkiParamBean();
        ekiParamBean.setShopCd(shopCd);
        ekiParamBean.setWebUpFlg(ConstValues.FLG_ON);
        List<ShopListingEkiDomain> ekiDomain =
                mediaInfoUpdatePageDao.searchMedaiInfoEki(ekiParamBean);

        List<OptionTagBean> medaiInfoEkiList = new ArrayList<OptionTagBean>();
        String ekiCodeValue = "";
        for (ShopListingEkiDomain shopListingEkiDomain : ekiDomain) {
            OptionTagBean tmp = new OptionTagBean();
            tmp.setKey(shopListingEkiDomain.getEnsenCd() + shopListingEkiDomain.getEkiCd());
            tmp.setValue(shopListingEkiDomain.getEnsenName() + " "
                    + shopListingEkiDomain.getEkiName());
            medaiInfoEkiList.add(tmp);
            if (StringUtils.isNotEmpty(ekiCodeValue)) {
                ekiCodeValue = ekiCodeValue + "," + tmp.getKey();
            } else {
                ekiCodeValue = tmp.getKey();
            }
        }
        outBean.setSelectEkiValue(ekiCodeValue);
        outBean.setMedaiInfoEkiList(medaiInfoEkiList);

        // 3.市区町村データを取得
        ShopListingCityParamBean cityParamBean = new ShopListingCityParamBean();
        cityParamBean.setShopCd(shopCd);
        cityParamBean.setWebUpFlg(ConstValues.FLG_ON);
        List<ShopListingCityDomain> cityDomain =
                mediaInfoUpdatePageDao.searchMedaiInfoCity(cityParamBean);

        List<OptionTagBean> medaiInfoCityList = new ArrayList<OptionTagBean>();
        String cityCodeValue = "";
        for (ShopListingCityDomain shopListingCityDomain : cityDomain) {
            OptionTagBean tmp = new OptionTagBean();
            tmp.setKey(shopListingCityDomain.getCityCd());
            tmp.setValue(shopListingCityDomain.getPrefName() + " "
                    + shopListingCityDomain.getCityName());
            medaiInfoCityList.add(tmp);

            if (StringUtils.isNotEmpty(cityCodeValue)) {
                cityCodeValue = cityCodeValue + "," + tmp.getKey();
            } else {
                cityCodeValue = tmp.getKey();
            }
        }
        outBean.setSelectCityValue(cityCodeValue);
        outBean.setMedaiInfoCityList(medaiInfoCityList);

        // 店舗画像パスを取得
        ShopImageInfoDomain imgInfo = keiyakuShopInfoDao.getShopImgInfo(shopCd);
        outBean.setShopImgLeft(ShopListingUtils.createLeftImgPath(imgInfo)); // 店舗画像1(左側)
        outBean.setShopImgRight(ShopListingUtils.createRightImgPath(imgInfo)); // 店舗画像2(右側)
        outBean.setClientSystemType(imgInfo.getClientSystemType());

        // 4.アイコン情報を取得
        ShopListingIconParamBean iconParamBean = new ShopListingIconParamBean();
        iconParamBean.setShopCd(shopCd);
        iconParamBean.setWebUpFlg(ConstValues.FLG_ON);
        List<ShopListingIconDomain> iconDomain =
                mediaInfoUpdatePageDao.searchMedaiInfoIcon(iconParamBean);

        List<String> chkAppealList = new ArrayList<String>();
        List<String> chkListingList = new ArrayList<String>();
        for (ShopListingIconDomain shopListingIconDomain : iconDomain) {
            chkAppealList.add(shopListingIconDomain.getIconId());
            if (shopListingIconDomain.getListingFlg().equals(ConstValues.FLG_ON)) {
                chkListingList.add(shopListingIconDomain.getIconId());
            }
        }

        // アピールアイコンマスタ情報を取得
        List<ShopListingIconDomain> domainList = shopListingIconDao.searchIconMasterInfo();

        List<ShopListingIconBean> detailList = new ArrayList<ShopListingIconBean>();
        for (ShopListingIconDomain domain : domainList) {
            ShopListingIconBean detail = new ShopListingIconBean();
            BeanUtilsWrapper.copyProperties(detail, domain);

            // アイコン画像Url生成
            MessageFormat formatter =
                    new MessageFormat(ServerProperties.getProperty("shopListing.appealIconImgPath"));
            detail.setIconImgPath(formatter.format(new String[] { domain.getIconId() }));

            // チェックボックスの初期値設定
            if (chkAppealList.contains(domain.getIconId())) {
                detail.setAppealChkFlg(ConstValues.FLG_ON);
            }
            if (chkListingList.contains(domain.getIconId())) {
                detail.setListingChkFlg(ConstValues.FLG_ON);
            }

            detailList.add(detail);
        }
        outBean.setDetailList(detailList);

        // 現在Web表示中の出稿データの件数を取得
        outBean.setWebDisplayCnt(shopListingDataDao.selectWebDisplayCnt(shopCd));

        // 出稿対象駅/市区町村上限数を取得
        KihonKeiyakuInfoDomin keiyakuInfoDomain = mediaInfoConfirmDao.searchMediaCntLimit(shopCd);
        outBean.setEkiCnt(keiyakuInfoDomain.getEkiCnt());
        outBean.setCityCnt(keiyakuInfoDomain.getCityCnt());

        return outBean;
    }

    public List<OptionTagBean> searchCityOptions(String selectEkiValue) {

        List<OptionTagBean> returnList = new ArrayList<OptionTagBean>();

        if (StringUtils.isNotEmpty(selectEkiValue)) {
            String[] cityCds = selectEkiValue.split(",");
            List<ShopListingCityDomain> cityDomainList =
                    mediaInfoConfirmDao.searchCityInfos(Arrays.asList(cityCds));

            for (ShopListingCityDomain domain : cityDomainList) {
                OptionTagBean tmpBean = new OptionTagBean();
                tmpBean.setKey(domain.getCityCd());
                tmpBean.setValue(domain.getPrefName() + " " + domain.getCityName());

                returnList.add(tmpBean);
            }
        }
        return returnList;
    }

    public List<OptionTagBean> searchEkiOptions(String selectEkiValue) {
        // 選択された駅コードを確認画面表示のため文字列か
        List<OptionTagBean> returnList = new ArrayList<OptionTagBean>();
        if (StringUtils.isNotEmpty(selectEkiValue)) {
            String[] params = selectEkiValue.split(",");

            for (int i = 0; i < params.length; i++) {
                EkiInfoSearchParamBean paramBean = new EkiInfoSearchParamBean();
                paramBean.setEnsenCd(params[i].substring(0, 6));
                paramBean.setEkiCd(params[i].substring(6));

                ShopListingEkiDomain ekiDomain = mediaInfoConfirmDao.searchEkiInfo(paramBean);
                OptionTagBean tmpBean = new OptionTagBean();
                tmpBean.setKey(params[i]);
                tmpBean.setValue(ekiDomain.getEnsenName() + " " + ekiDomain.getEkiName());
                returnList.add(tmpBean);
            }
        }
        return returnList;
    }

    /**
     * 駅情報を取得を設定します。
     * @param mediaInfoUpdatePageDao 駅情報を取得
     */
    public void setMediaInfoUpdatePageDao(MediaInfoUpdatePageDao mediaInfoUpdatePageDao) {
        this.mediaInfoUpdatePageDao = mediaInfoUpdatePageDao;
    }

    /**
     * アイコンマスタDAOを設定します。
     * @param shopListingIconDao アイコンマスタDAO
     */
    public void setShopListingIconDao(ShopListingIconDao shopListingIconDao) {
        this.shopListingIconDao = shopListingIconDao;
    }

    /**
     * 店舗詳細取得DAOを設定します。
     * @param keiyakuShopInfoDao 店舗詳細取得DAO
     */
    public void setKeiyakuShopInfoDao(KeiyakuShopInfoDao keiyakuShopInfoDao) {
        this.keiyakuShopInfoDao = keiyakuShopInfoDao;
    }

    /**
     * 出稿情報確認DAOを設定します。
     * @param mediaInfoConfirmDao 出稿情報確認DAO
     */
    public void setMediaInfoConfirmDao(MediaInfoConfirmDao mediaInfoConfirmDao) {
        this.mediaInfoConfirmDao = mediaInfoConfirmDao;
    }

    /**
     * 店舗リスティングデータDAOを設定します。
     * @param shopListingDataDao 店舗リスティングデータDAO
     */
    public void setShopListingDataDao(ShopListingDataDao shopListingDataDao) {
        this.shopListingDataDao = shopListingDataDao;
    }

}

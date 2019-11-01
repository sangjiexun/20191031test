/*
 * $Id: MediaInfoRegisterPageServiceImpl.java 4324 2009-08-03 04:13:24Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/03  BGT)李昊燮     新規作成
 * 2009/08/03  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.chintai.backend.sysadmin.common.properties.ServerProperties;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.shop_listing.ShopListingUtils;
import net.chintai.backend.sysadmin.shop_listing.dao.EkiInfoSearchParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopInfoDao;
import net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoConfirmDao;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingDataDao;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingIconDao;
import net.chintai.backend.sysadmin.shop_listing.domain.KihonKeiyakuInfoDomin;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopAreaInfoDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopImageInfoDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingCityDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingEkiDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingIconDomain;
import net.chintai.backend.sysadmin.shop_listing.service.MediaInfoRegisterPageService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoRegisterPageOutServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.OptionTagBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopListingIconBean;

import org.apache.commons.lang.StringUtils;

/**
 * MediaInfoRegisterPageServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4324 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoRegisterPageServiceImpl implements MediaInfoRegisterPageService {

    /** 店舗リスティングデータDAO */
    private ShopListingDataDao shopListingDataDao;

    /** アイコンマスタDAO */
    private ShopListingIconDao shopListingIconDao;

    /** 店舗詳細取得DAO */
    private KeiyakuShopInfoDao keiyakuShopInfoDao;

    /** 出稿情報確認DAO */
    private MediaInfoConfirmDao mediaInfoConfirmDao;

    /*
     * (非 Javadoc)
     *
     * @seenet.chintai.backend.sysadmin.shop_listing.service.
     * MediaInfoRegisterPageService# searchDefaultInfo(java.lang.String)
     */
    public MediaInfoRegisterPageOutServiceBean searchDefaultInfo(String shopCd) {

        // 戻り値を格納
        MediaInfoRegisterPageOutServiceBean outBean = new MediaInfoRegisterPageOutServiceBean();

        // 該当店舗の最寄駅、最寄市区町村情報を取得
        ShopAreaInfoDomain areaInfoDomain = keiyakuShopInfoDao.searchAreaInfo(shopCd);
        BeanUtilsWrapper.copyProperties(outBean, areaInfoDomain);

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

            detailList.add(detail);
        }
        outBean.setDetailList(detailList);

        // 現在Web表示中の出稿データの件数を取得
        outBean.setWebDisplayCnt(shopListingDataDao.selectWebDisplayCnt(shopCd));

        // 出稿対象駅/市区町村上限数を取得
        KihonKeiyakuInfoDomin keiyakuInfoDomain = mediaInfoConfirmDao.searchMediaCntLimit(shopCd);
        outBean.setEkiCnt(keiyakuInfoDomain.getEkiCnt());
        outBean.setCityCnt(keiyakuInfoDomain.getCityCnt());

        // 店舗画像パスを取得
        ShopImageInfoDomain imgInfo = keiyakuShopInfoDao.getShopImgInfo(shopCd);
        outBean.setShopImgLeft(ShopListingUtils.createLeftImgPath(imgInfo)); // 店舗画像1(左側)
        outBean.setShopImgRight(ShopListingUtils.createRightImgPath(imgInfo)); // 店舗画像2(右側)
        outBean.setClientSystemType(imgInfo.getClientSystemType());

        return outBean;
    }

    /*
     * (非 Javadoc)
     *
     * @seenet.chintai.backend.sysadmin.shop_listing.service.
     * MediaInfoRegisterPageService# searchCityOptions(java.lang.String)
     */
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

    /*
     * (非 Javadoc)
     *
     * @seenet.chintai.backend.sysadmin.shop_listing.service.
     * MediaInfoRegisterPageService# searchEkiOptions(java.lang.String)
     */
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
     * アイコンマスタDAOを設定します。
     * @param shopListingIconDao アイコンマスタDAO
     */
    public void setShopListingIconDao(ShopListingIconDao shopListingIconDao) {
        this.shopListingIconDao = shopListingIconDao;
    }

    /**
     * 店舗リスティングデータDAOを設定します。
     * @param shopListingDataDao 店舗リスティングデータDAO
     */
    public void setShopListingDataDao(ShopListingDataDao shopListingDataDao) {
        this.shopListingDataDao = shopListingDataDao;
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

}

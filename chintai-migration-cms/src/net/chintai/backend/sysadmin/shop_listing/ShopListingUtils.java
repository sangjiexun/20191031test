/*
 * $Id: ShopListingUtils.java 4321 2009-07-17 06:05:34Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/16  BGT)李昊燮     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.properties.ServerProperties;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopImageInfoDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingCityDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingDataDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingEkiDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingIconDomain;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopListingIconBean;

import org.apache.commons.lang.StringUtils;

/**
 * 店舗リスティング機能のUtilityクラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4321 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingUtils {

    /**
     * 店舗画像URLを生成します。
     *
     * @param domain 店舗リスティングデータDomain
     * @param imgInfo 店舗画像情報Domain
     * @return 店舗画像URL
     */
    public static String createShopImgUrl(ShopListingDataDomain domain, ShopImageInfoDomain imgInfo) {

        if (domain == null) {
            return null;
        }

        if (ConstValues.FLG_OFF.equals(domain.getPicFlg())) {
            return ConstValues.FLG_OFF;
        }

        // 戻り値
        StringBuilder sb = new StringBuilder();
        sb.append(ServerProperties.getProperty("shop.imageRefServerUrl")); // MASTER_IMG_ROOT

        if (("1").equals(domain.getPicFlg())) {
            if (ConstValues.FLG_OFF.equals(imgInfo.getShopPhoto1Flg())) {
                return null;
            }
            sb.append(ApplicationResources.getProperty("shop_listing.imgFilePathShop"));
            sb.append(ConstValues.SLASH);
            sb.append(domain.getShopCd());
            sb.append(ConstValues.SLASH);
            sb.append(ApplicationResources.getProperty("shop.photo1WorkCode"));
            sb.append(ConstValues.SLASH);
            sb.append(domain.getShopCd());
            sb.append(ApplicationResources.getProperty("shop.jpgFileExtensions"));

        } else if (("2").equals(domain.getPicFlg())) {
            if (ConstValues.FLG_OFF.equals(imgInfo.getShopPhoto2Flg())) {
                return null;
            }
            sb.append(ApplicationResources.getProperty("shop_listing.imgFilePathShop"));
            sb.append(ConstValues.SLASH);
            sb.append(domain.getShopCd());
            sb.append(ConstValues.SLASH);
            sb.append(ApplicationResources.getProperty("shop.photo2WorkCode"));
            sb.append(ConstValues.SLASH);
            sb.append(domain.getShopCd());
            sb.append(ApplicationResources.getProperty("shop.jpgFileExtensions"));

        } else {
            return ConstValues.IMG_KBN_ERR;
        }

        return sb.toString();
    }

    /**
     * 店舗画像(左側)のURLを生成します。
     * @param imgInfo 店舗画像情報DOMAMIN
     * @return 店舗画像(左側)URL
     */
    public static String createLeftImgPath(ShopImageInfoDomain imgInfo) {

        // 戻り値
        StringBuilder sb = new StringBuilder();
        sb.append(ServerProperties.getProperty("shop.imageRefServerUrl")); // MASTER_IMG_ROOT

        if (ConstValues.FLG_ON.equals(imgInfo.getShopPhoto1Flg())) {
            // [WEB_IMAGE_ROOT]/shop/店舗コード/811/店舗コード.JSP
            sb.append(ApplicationResources.getProperty("shop_listing.imgFilePathShop"));
            sb.append(ConstValues.SLASH);
            sb.append(imgInfo.getShopCd());
            sb.append(ConstValues.SLASH);
            sb.append(ApplicationResources.getProperty("shop.photo1WorkCode"));
            sb.append(ConstValues.SLASH);
            sb.append(imgInfo.getShopCd());
            sb.append(ApplicationResources.getProperty("shop.jpgFileExtensions"));
            return sb.toString();
        }

        return null;
    }

    /**
     * 店舗画像(右側)のURLを生成します。
     *
     * @param imgInfo 店舗画像情報DOMAMIN
     * @return 店舗画像(右側)URL
     */
    public static String createRightImgPath(ShopImageInfoDomain imgInfo) {
        // 戻り値
        StringBuilder sb = new StringBuilder();
        sb.append(ServerProperties.getProperty("shop.imageRefServerUrl")); // MASTER_IMG_ROOT

        if (ConstValues.FLG_ON.equals(imgInfo.getShopPhoto2Flg())) {
            // [WEB_IMAGE_ROOT]/shop/店舗コード/811/店舗コード.JSP
            sb.append(ApplicationResources.getProperty("shop_listing.imgFilePathShop"));
            sb.append(ConstValues.SLASH);
            sb.append(imgInfo.getShopCd());
            sb.append(ConstValues.SLASH);
            sb.append(ApplicationResources.getProperty("shop.photo2WorkCode"));
            sb.append(ConstValues.SLASH);
            sb.append(imgInfo.getShopCd());
            sb.append(ApplicationResources.getProperty("shop.jpgFileExtensions"));
            return sb.toString();
        }

        return null;
    }

    /**
     * 選択されたリスティングアイコン情報Domainをコピーします。<br>
     *
     * @param iconInfos リスティングアイコン情報Domainリスト
     * @return リスティングアイコン情報OutBeanリスト
     */
    public static List<ShopListingIconBean> getLstIconInfos(List<ShopListingIconDomain> iconInfos) {
        if (iconInfos == null)
            return null;

        List<ShopListingIconBean> rtList = new ArrayList<ShopListingIconBean>();
        for (ShopListingIconDomain domain : iconInfos) {
            if (ConstValues.FLG_ON.equals(domain.getListingFlg())) {
                ShopListingIconBean tmpBean = new ShopListingIconBean();
                BeanUtilsWrapper.copyProperties(tmpBean, domain);

                // アイコンIDを利用してアイコン画像URLを生成します。
                tmpBean.setIconImgPath(ShopListingUtils.createIconImgUrl(domain.getIconId()));
                rtList.add(tmpBean);
            }
        }
        return rtList;
    }

    /**
     * 選択されたアピールアイコン情報Domainをコピーします。<br>
     *
     * @param iconInfos アピールアイコン情報Domainリスト
     * @return アピールアイコン情報OutBeanリスト
     */
    public static List<ShopListingIconBean> getAppIconInfos(List<ShopListingIconDomain> iconInfos) {

        if (iconInfos == null)
            return null;

        List<ShopListingIconBean> rtList = new ArrayList<ShopListingIconBean>();
        for (ShopListingIconDomain domain : iconInfos) {
            ShopListingIconBean tmpBean = new ShopListingIconBean();
            BeanUtilsWrapper.copyProperties(tmpBean, domain);
            tmpBean.setIconImgPath(ShopListingUtils.createIconImgUrl(domain.getIconId()));
            rtList.add(tmpBean);
        }

        return rtList;
    }

    /**
     * 出稿情報確認画面の出稿対象市区町村表示用文字列を生成します。
     *
     * @param webCity 出稿対象市区町村情報リスト
     * @return 出稿対象市区町村
     */
    public static String cityDomainToString(List<ShopListingCityDomain> webCity) {

        String cityNames = "";
        for (ShopListingCityDomain domain : webCity) {
            if (StringUtils.isNotEmpty(cityNames)) {
                cityNames = cityNames + ConstValues.SLASH;
            }
            cityNames = cityNames + domain.getPrefName() + ConstValues.SPACE + domain.getCityName();
        }
        return cityNames;
    }

    /**
     * 出稿情報確認画面の出稿対象駅表示用文字列を生成します。
     *
     * @param webEki 出稿対象駅情報リスト
     * @return 出稿対象駅
     */
    public static String ekiDomainToString(List<ShopListingEkiDomain> webEki) {

        String ekiNames = "";
        for (ShopListingEkiDomain domain : webEki) {
            if (StringUtils.isNotEmpty(ekiNames)) {
                ekiNames = ekiNames + ConstValues.SLASH;
            }
            ekiNames = ekiNames + domain.getEnsenName() + ConstValues.SPACE + domain.getEkiName();
        }
        return ekiNames;
    }

    /**
     * アイコン画像URLを生成します。
     * @param iconId アイコンID
     * @return 生成されたアイコン画像URL
     */
    public static String createIconImgUrl(String iconId) {
        // アイコン画像Url生成
        MessageFormat formatter =
                new MessageFormat(ServerProperties.getProperty("shopListing.appealIconImgPath"));

        return formatter.format(new String[] { iconId });
    }
}

/*
 * $Id: MediaInfoConfirmOutServiceBean.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/12     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.bean;

import java.util.List;

/**
 * 出稿情報確認サービスビーン
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoConfirmOutServiceBean {

    /** 出稿対象駅指定 */
    private List<String> selectEkiName;

    /** 出稿対象市区町村指定 */
    private List<String> selectCityName;

    /** 選択されたアピールアイコンの情報 */
    private List<ShopListingIconBean> appealIconInfos;

    /** 選択されたリスティングアイコンの情報 */
    private List<ShopListingIconBean> listingIconInfos;

    /**
     * 出稿対象駅指定を設定します。
     * @param selectEkiName 出稿対象駅指定
     */
    public void setSelectEkiName(List<String> selectEkiName) {
        this.selectEkiName = selectEkiName;
    }

    /**
     * 出稿対象駅指定を取得します。
     * @return 出稿対象駅指定
     */
    public List<String> getSelectEkiName() {
        return selectEkiName;
    }

    /**
     * 出稿対象市区町村指定を取得します。
     * @return 出稿対象市区町村指定
     */
    public List<String> getSelectCityName() {
        return selectCityName;
    }

    /**
     * 出稿対象市区町村指定を設定します。
     * @param selectCityName 出稿対象市区町村指定
     */
    public void setSelectCityName(List<String> selectCityName) {
        this.selectCityName = selectCityName;
    }

    /**
     * 選択されたアピールアイコンの情報を取得します。
     * @return 選択されたアピールアイコンの情報
     */
    public List<ShopListingIconBean> getAppealIconInfos() {
        return appealIconInfos;
    }

    /**
     * 選択されたアピールアイコンの情報を設定します。
     * @param appealIconInfos 選択されたアピールアイコンの情報
     */
    public void setAppealIconInfos(List<ShopListingIconBean> appealIconInfos) {
        this.appealIconInfos = appealIconInfos;
    }

    /**
     * 選択されたリスティングアイコンの情報を取得します。
     * @return 選択されたリスティングアイコンの情報
     */
    public List<ShopListingIconBean> getListingIconInfos() {
        return listingIconInfos;
    }

    /**
     * 選択されたリスティングアイコンの情報を設定します。
     * @param listingIconInfos 選択されたリスティングアイコンの情報
     */
    public void setListingIconInfos(List<ShopListingIconBean> listingIconInfos) {
        this.listingIconInfos = listingIconInfos;
    }

}

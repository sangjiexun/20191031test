/*
 * $Id: ImageUrlFromMasterServerInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/31  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service.bean;

import java.util.List;

/**
 * 画像マスタサーバ上の画像URLパスを取得する時に使用するInServiceBean。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ImageUrlFromMasterServerInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** 画像別の作業コード */
    private List<String> workCdList;

    /** 登録された画像の拡張子 */
    private String photoFileExtensions;

    /**
     * 店舗コードを取得します。
     * @return shopCd 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     * @param shopCd 店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 画像別の作業コードを取得します。
     * @return workCdList 画像別の作業コード
     */
    public List<String> getWorkCdList() {
        return workCdList;
    }

    /**
     * 画像別の作業コードを設定します。
     * @param workCdList 画像別の作業コード
     */
    public void setWorkCdList(List<String> workCdList) {
        this.workCdList = workCdList;
    }

    /**
     * 登録された画像の拡張子を取得します。
     * @return photoFileExtensions 登録された画像の拡張子
     */
    public String getPhotoFileExtensions() {
        return photoFileExtensions;
    }

    /**
     * 登録された画像の拡張子を設定します。
     * @param photoFileExtensions 登録された画像の拡張子
     */
    public void setPhotoFileExtensions(String photoFileExtensions) {
        this.photoFileExtensions = photoFileExtensions;
    }

}

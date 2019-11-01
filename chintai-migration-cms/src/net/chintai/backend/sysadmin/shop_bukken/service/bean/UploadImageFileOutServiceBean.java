/*
 * $Id: UploadImageFileOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/30  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

import java.util.List;

/**
 * 画像ファイルをサップロードされた後、使用するOutServiceBean。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UploadImageFileOutServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** アップロード成功フラグ */
    private boolean uploadSuccessFlg;

    /** 画像別の作業コード */
    private List<String> workCdList;

    /** アップロードされた画像ファイルのURLパス(画面表示用) */
    private List<String> imageFileUrlPathList;

    /** アップロードされた画像ファイルの物理パス(FTP送信用) */
    private List<String> imageFileLogicalPathList;

    /**
     * アップロード成功フラグを取得します。
     * @return アップロード成功フラグ
     */
    public boolean getUploadSuccessFlg() {
        return uploadSuccessFlg;
    }

    /**
     * アップロード成功フラグを設定します。
     * @param uploadSuccessFlg アップロード成功フラグ
     */
    public void setUploadSuccessFlg(boolean uploadSuccessFlg) {
        this.uploadSuccessFlg = uploadSuccessFlg;
    }

    /**
     * 画像別の作業コードを設定します。
     * @param workCdList 画像別の作業コード
     */
    public void setWorkCdList(List<String> workCdList) {
        this.workCdList = workCdList;
    }

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
     * @return 画像別の作業コード
     */
    public List<String> getWorkCdList() {
        return workCdList;
    }

    /**
     * アップロードされた画像ファイルのURLパス(画面表示用)を設定します。
     * @param imageFileUrlPathList アップロードされた画像ファイルのURLパス(画面表示用)
     */
    public void setImageFileUrlPathList(List<String> imageFileUrlPathList) {
        this.imageFileUrlPathList = imageFileUrlPathList;
    }

    /**
     * アップロードされた画像ファイルのURLパス(画面表示用)を取得します。
     * @return アップロードされた画像ファイルのURLパス(画面表示用)
     */
    public List<String> getImageFileUrlPathList() {
        return imageFileUrlPathList;
    }

    /**
     * アップロードされた画像ファイルの物理パス(FTP送信用)を設定します。
     * @param imageFileLogicalPathList アップロードされた画像ファイルの物理パス(FTP送信用)
     */
    public void setImageFileLogicalPathList(List<String> imageFileLogicalPathList) {
        this.imageFileLogicalPathList = imageFileLogicalPathList;
    }

    /**
     * アップロードされた画像ファイルの物理パス(FTP送信用)を取得します。
     * @return アップロードされた画像ファイルの物理パス(FTP送信用)
     */
    public List<String> getImageFileLogicalPathList() {
        return imageFileLogicalPathList;
    }

}

/*
 * $Id: ImageUploadToFtpServerInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/31  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service.bean;

import java.util.Map;

/**
 * 画像ファイルをFTPサーバに伝送する時に使用するInServiceBean。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ImageUploadToFtpServerInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** FTPに送信する画像ファイルマップ */
    private Map<String, String> ftpSendFileMap;

    /** 実装させるServletマップ */
    private Map<String, String> executeServletMap;

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
     * FTPに送信する画像ファイルマップを設定します。
     * @return ftpSendFileMap FTPに送信する画像ファイルマップ
     */
    public Map<String, String> getFtpSendFileMap() {
        return ftpSendFileMap;
    }

    /**
     * FTPに送信する画像ファイルマップを取得します。
     * @param ftpSendFileMap FTPに送信する画像ファイルマップ
     */
    public void setFtpSendFileMap(Map<String, String> ftpSendFileMap) {
        this.ftpSendFileMap = ftpSendFileMap;
    }

    /**
     * 実装させるServletマップを取得します。
     * @return executeServletMap 実装させるServletマップ
     */
    public Map<String, String> getExecuteServletMap() {
        return executeServletMap;
    }

    /**
     * 実装させるServletマップを設定します。
     * @param executeServletMap 実装させるServletマップ
     */
    public void setExecuteServletMap(Map<String, String> executeServletMap) {
        this.executeServletMap = executeServletMap;
    }

}

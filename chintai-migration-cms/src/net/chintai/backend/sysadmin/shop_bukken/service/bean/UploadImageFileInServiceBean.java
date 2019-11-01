/*
 * $Id: UploadImageFileInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/30  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

import java.util.Map;

import org.apache.struts.upload.FormFile;

/**
 * 画像ファイルのアップロード用InServiceBean
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UploadImageFileInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** アップロードする画像ファイルのMap */
    private Map<String, FormFile> uploadFileMap;

    /** sessionId */
    private String sessionId;

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
     * アップロードする画像ファイルのMapを取得します。
     * @return uploadFileMap アップロードする画像ファイルのMap
     */
    public Map<String, FormFile> getUploadFileMap() {
        return uploadFileMap;
    }

    /**
     * アップロードする画像ファイルのMapを設定します。
     * @param uploadFileMap アップロードする画像ファイルのMap
     */
    public void setUploadFileMap(Map<String, FormFile> uploadFileMap) {
        this.uploadFileMap = uploadFileMap;
    }

    /**
     * sessionIdを取得します。
     * @return sessionId sessionId
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * sessionIdを設定します。
     * @param sessionId sessionId
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}

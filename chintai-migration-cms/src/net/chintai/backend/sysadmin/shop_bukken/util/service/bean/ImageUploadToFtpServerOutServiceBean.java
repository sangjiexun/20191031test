/*
 * $Id: ImageUploadToFtpServerOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/31  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service.bean;

import java.util.List;

/**
 * 画像ファイルをFTPサーバに伝送後に使用するOutServiceBean。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ImageUploadToFtpServerOutServiceBean {

    /** FTP処理結果フラグ */
    private boolean ftpSuccessFlg;

    /** 画像配信サーバの画像UrlPath */
    private List<String> imageUrlPathList;

    /** 実装させるServletリスト */
    private List<String> executeServletList;

    /**
     * FTP処理結果フラグを取得します。
     * @return ftpSuccessFlg FTP処理結果フラグ
     */
    public boolean getFtpSuccessFlg() {
        return ftpSuccessFlg;
    }

    /**
     * FTP処理結果フラグを設定します。
     * @param ftpSuccessFlg FTP処理結果フラグ
     */
    public void setFtpSuccessFlg(boolean ftpSuccessFlg) {
        this.ftpSuccessFlg = ftpSuccessFlg;
    }

    /**
     * 画像配信サーバの画像UrlPathを取得します。
     * @return imageUrlPathList 画像配信サーバの画像UrlPath
     */
    public List<String> getImageUrlPathList() {
        return imageUrlPathList;
    }

    /**
     * 画像配信サーバの画像UrlPathを設定します。
     * @param imageUrlPathList 画像配信サーバの画像UrlPath
     */
    public void setImageUrlPathList(List<String> imageUrlPathList) {
        this.imageUrlPathList = imageUrlPathList;
    }

    /**
     * 実装させるServletリストを設定します。
     * @return executeServletList 実装させるServletリスト
     */
    public List<String> getExecuteServletList() {
        return executeServletList;
    }

    /**
     * 実装させるServletリストを取得します。
     * @param executeServletList 実装させるServletリスト
     */
    public void setExecuteServletList(List<String> executeServletList) {
        this.executeServletList = executeServletList;
    }

}

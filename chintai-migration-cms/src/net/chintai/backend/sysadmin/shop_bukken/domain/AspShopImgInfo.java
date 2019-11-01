/*
 * $Id: AspShopInfo.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.domain;

import org.apache.struts.upload.FormFile;

/**
 * 不動産ASP設定情報,登録,完了で使用するDomain
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspShopImgInfo {

    /** 店舗コード */
    private String shopCd;

    /** アップロードファイル */
    private FormFile file;

    /** アップロード保存先 */
    private String imgRealPath;

    /** URLパス */
    private String imgUrlPath;

    /** ファイル名 */
    private String imgFileNm;

    /** ファイル拡張子*/
    private String imgFileType;

    /** イメージId */
    private String imgId;

    /**
     * 店舗コードを返します。
     *
     * @return shopCd
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     *
     * @param shopCd
     *            店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * アップロードファイルを返します。
     *
     * @return file
     */
    public FormFile getFile() {
        return file;
    }

    /**
     * アップロードファイルを設定します。
     *
     * @param file
     *            アップロードファイル
     */
    public void setFile(FormFile file) {
        this.file = file;
    }


    /**
     * アップロード保存先を返します。
     * @return imgRealPath
     */
    public String getImgRealPath() {
        return imgRealPath;
    }

    /**
     * アップロード保存先を設定します。
     * @param imgRealPath  アップロード保存先
     */
    public void setImgRealPath(String imgRealPath) {
        this.imgRealPath = imgRealPath;
    }

    /**
     * URLパスを返します。
     * @return imgUrlPath
     */
    public String getImgUrlPath() {
        return imgUrlPath;
    }

    /**
     * URLパスを設定します。
     * @param imgUrlPath  URLパス
     */
    public void setImgUrlPath(String imgUrlPath) {
        this.imgUrlPath = imgUrlPath;
    }

    /**
     * ファイル名を返します。
     * @return ファイル名
     */
    public String getImgFileNm() {
        return imgFileNm;
    }

    /**
     * ファイル名を設定します。
     * @param imgFileNm  ファイル名
     */
    public void setImgFileNm(String imgFileNm) {
        this.imgFileNm = imgFileNm;
    }

    /**
     * イメージIDを返します。
     * @return イメージID
     */
    public String getImgId() {
        return imgId;
    }

    /**
     * イメージIDを設定します。
     * @param imgId  イメージID
     */
    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    /**
     * imgFileTypeを返します。
     * @return imgFileType
     */
    public String getImgFileType() {
        return imgFileType;
    }

    /**
     * を設定します。
     * @param imgFileType  imgFileType
     */
    public void setImgFileType(String imgFileType) {
        this.imgFileType = imgFileType;
    }

}

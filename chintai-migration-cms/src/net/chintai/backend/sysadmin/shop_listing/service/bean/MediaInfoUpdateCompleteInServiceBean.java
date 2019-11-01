/*
 * $Id: MediaInfoUpdateCompleteInServiceBean.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/03     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.bean;

import java.util.List;

/**
 * 出稿情報登録完了InServiceBean。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoUpdateCompleteInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** Web表示中出稿情報データの件数 */
    private int webDisplayCnt;

    /** エリア(駅指定) */
    private String areaCd;

    /** 沿線タイプ */
    private String ensenTypeCd;

    /** 沿線 */
    private String ensenCd;

    /** 駅 */
    private String ekiCd;

    /** 駅選択値Multibox */
    private String[] selectEki;

    /** 駅選択値:code */
    private String selectEkiValue;

    /** 駅選択値:name */
    private List<String> selectEkiName;

    /** エリア(市区町村指定) */
    private String cityAreaCd;

    /** 都道府県 */
    private String prefCd;

    /** 市区町村 */
    private String cityCd;

    /** 市区町村Multibox */
    private String[] selectCity;

    /** 市区町村選択値:code */
    private String selectCityValue;

    /** 市区町村選択値:Name */
    private List<String> selectCityName;

    /** キャッチフレーズ */
    private String catchPhrase;

    /** アピールコメント */
    private String appealComment;

    /** アピールアイコン選択 */
    private String[] chkAppeal;

    /** リスティング選択 */
    private String[] chkListing;

    /** 店舗画像(右側) */
    private String shopImgRight;

    /** 店舗画像(左側) */
    private String shopImgLeft;

    /** clientSystemType */
    private String clientSystemType;

    /** 店舗画像区分 */
    private String picFlg;

    /** 注釈1 */
    private String couponComment1;

    /** 注釈2 */
    private String couponComment2;

    /** 注釈3 */
    private String couponComment3;

    /** 備考 */
    private String note;

    /** 登録プログラム名 */
    private String insPg;

    /** 登録者ID */
    private String insId;

    /** 最終更新日時 */
    private String updDt;

    /** 更新プログラム名 */
    private String updPg;

    /** 更新者ID */
    private String updId;

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
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
     * Web表示中出稿情報データの件数を取得します。
     * @return Web表示中出稿情報データの件数
     */
    public int getWebDisplayCnt() {
        return webDisplayCnt;
    }

    /**
     * Web表示中出稿情報データの件数を設定します。
     * @param webDisplayCnt Web表示中出稿情報データの件数
     */
    public void setWebDisplayCnt(int webDisplayCnt) {
        this.webDisplayCnt = webDisplayCnt;
    }

    /**
     * エリア(駅指定)を取得します。
     * @return エリア(駅指定)
     */
    public String getAreaCd() {
        return areaCd;
    }

    /**
     * エリア(駅指定)を設定します。
     * @param areaCd エリア(駅指定)
     */
    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    /**
     * 沿線タイプを取得します。
     * @return 沿線タイプ
     */
    public String getEnsenTypeCd() {
        return ensenTypeCd;
    }

    /**
     * 沿線タイプを設定します。
     * @param ensenTypeCd 沿線タイプ
     */
    public void setEnsenTypeCd(String ensenTypeCd) {
        this.ensenTypeCd = ensenTypeCd;
    }

    /**
     * 沿線を取得します。
     * @return 沿線
     */
    public String getEnsenCd() {
        return ensenCd;
    }

    /**
     * 沿線を設定します。
     * @param ensenCd 沿線
     */
    public void setEnsenCd(String ensenCd) {
        this.ensenCd = ensenCd;
    }

    /**
     * 駅を取得します。
     * @return 駅
     */
    public String getEkiCd() {
        return ekiCd;
    }

    /**
     * 駅を設定します。
     * @param ekiCd 駅
     */
    public void setEkiCd(String ekiCd) {
        this.ekiCd = ekiCd;
    }

    /**
     * 駅選択値Multiboxを取得します。
     * @return 駅選択値Multibox
     */
    public String[] getSelectEki() {
        return selectEki;
    }

    /**
     * 駅選択値Multiboxを設定します。
     * @param selectEki 駅選択値Multibox
     */
    public void setSelectEki(String[] selectEki) {
        this.selectEki = selectEki;
    }

    /**
     * 駅選択値:codeを取得します。
     * @return 駅選択値:code
     */
    public String getSelectEkiValue() {
        return selectEkiValue;
    }

    /**
     * 駅選択値:codeを設定します。
     * @param selectEkiValue 駅選択値:code
     */
    public void setSelectEkiValue(String selectEkiValue) {
        this.selectEkiValue = selectEkiValue;
    }

    /**
     * 駅選択値:nameを取得します。
     * @return 駅選択値:name
     */
    public List<String> getSelectEkiName() {
        return selectEkiName;
    }

    /**
     * 駅選択値:nameを設定します。
     * @param selectEkiName 駅選択値:name
     */
    public void setSelectEkiName(List<String> selectEkiName) {
        this.selectEkiName = selectEkiName;
    }

    /**
     * エリア(市区町村指定)を取得します。
     * @return エリア(市区町村指定)
     */
    public String getCityAreaCd() {
        return cityAreaCd;
    }

    /**
     * エリア(市区町村指定)を設定します。
     * @param cityAreaCd エリア(市区町村指定)
     */
    public void setCityAreaCd(String cityAreaCd) {
        this.cityAreaCd = cityAreaCd;
    }

    /**
     * 都道府県を取得します。
     * @return 都道府県
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府県を設定します。
     * @param prefCd 都道府県
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
    }

    /**
     * 市区町村を取得します。
     * @return 市区町村
     */
    public String getCityCd() {
        return cityCd;
    }

    /**
     * 市区町村を設定します。
     * @param cityCd 市区町村
     */
    public void setCityCd(String cityCd) {
        this.cityCd = cityCd;
    }

    /**
     * 市区町村Multiboxを取得します。
     * @return 市区町村Multibox
     */
    public String[] getSelectCity() {
        return selectCity;
    }

    /**
     * 市区町村Multiboxを設定します。
     * @param selectCity 市区町村Multibox
     */
    public void setSelectCity(String[] selectCity) {
        this.selectCity = selectCity;
    }

    /**
     * 市区町村選択値:codeを取得します。
     * @return 市区町村選択値:code
     */
    public String getSelectCityValue() {
        return selectCityValue;
    }

    /**
     * 市区町村選択値:codeを設定します。
     * @param selectCityValue 市区町村選択値:code
     */
    public void setSelectCityValue(String selectCityValue) {
        this.selectCityValue = selectCityValue;
    }

    /**
     * 市区町村選択値:Nameを取得します。
     * @return 市区町村選択値:Name
     */
    public List<String> getSelectCityName() {
        return selectCityName;
    }

    /**
     * 市区町村選択値:Nameを設定します。
     * @param selectCityName 市区町村選択値:Name
     */
    public void setSelectCityName(List<String> selectCityName) {
        this.selectCityName = selectCityName;
    }

    /**
     * キャッチフレーズを取得します。
     * @return キャッチフレーズ
     */
    public String getCatchPhrase() {
        return catchPhrase;
    }

    /**
     * キャッチフレーズを設定します。
     * @param catchPhrase キャッチフレーズ
     */
    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    /**
     * アピールコメントを取得します。
     * @return アピールコメント
     */
    public String getAppealComment() {
        return appealComment;
    }

    /**
     * アピールコメントを設定します。
     * @param appealComment アピールコメント
     */
    public void setAppealComment(String appealComment) {
        this.appealComment = appealComment;
    }

    /**
     * アピールアイコン選択を取得します。
     * @return アピールアイコン選択
     */
    public String[] getChkAppeal() {
        return chkAppeal;
    }

    /**
     * アピールアイコン選択を設定します。
     * @param chkAppeal アピールアイコン選択
     */
    public void setChkAppeal(String[] chkAppeal) {
        this.chkAppeal = chkAppeal;
    }

    /**
     * リスティング選択を取得します。
     * @return リスティング選択
     */
    public String[] getChkListing() {
        return chkListing;
    }

    /**
     * リスティング選択を設定します。
     * @param chkListing リスティング選択
     */
    public void setChkListing(String[] chkListing) {
        this.chkListing = chkListing;
    }

    /**
     * 店舗画像(右側)を取得します。
     * @return 店舗画像(右側)
     */
    public String getShopImgRight() {
        return shopImgRight;
    }

    /**
     * 店舗画像(右側)を設定します。
     * @param shopImgRight 店舗画像(右側)
     */
    public void setShopImgRight(String shopImgRight) {
        this.shopImgRight = shopImgRight;
    }

    /**
     * 店舗画像(左側)を取得します。
     * @return 店舗画像(左側)
     */
    public String getShopImgLeft() {
        return shopImgLeft;
    }

    /**
     * 店舗画像(左側)を設定します。
     * @param shopImgLeft 店舗画像(左側)
     */
    public void setShopImgLeft(String shopImgLeft) {
        this.shopImgLeft = shopImgLeft;
    }

    /**
     * clientSystemTypeを取得します。
     * @return clientSystemType
     */
    public String getClientSystemType() {
        return clientSystemType;
    }

    /**
     * clientSystemTypeを設定します。
     * @param clientSystemType clientSystemType
     */
    public void setClientSystemType(String clientSystemType) {
        this.clientSystemType = clientSystemType;
    }

    /**
     * 店舗画像区分を取得します。
     * @return 店舗画像区分
     */
    public String getPicFlg() {
        return picFlg;
    }

    /**
     * 店舗画像区分を設定します。
     * @param picFlg 店舗画像区分
     */
    public void setPicFlg(String picFlg) {
        this.picFlg = picFlg;
    }

    /**
     * 注釈1を取得します。
     * @return 注釈1
     */
    public String getCouponComment1() {
        return couponComment1;
    }

    /**
     * 注釈1を設定します。
     * @param couponComment1 注釈1
     */
    public void setCouponComment1(String couponComment1) {
        this.couponComment1 = couponComment1;
    }

    /**
     * 注釈2を取得します。
     * @return 注釈2
     */
    public String getCouponComment2() {
        return couponComment2;
    }

    /**
     * 注釈2を設定します。
     * @param couponComment2 注釈2
     */
    public void setCouponComment2(String couponComment2) {
        this.couponComment2 = couponComment2;
    }

    /**
     * 注釈3を取得します。
     * @return 注釈3
     */
    public String getCouponComment3() {
        return couponComment3;
    }

    /**
     * 注釈3を設定します。
     * @param couponComment3 注釈3
     */
    public void setCouponComment3(String couponComment3) {
        this.couponComment3 = couponComment3;
    }

    /**
     * 備考を取得します。
     * @return 備考
     */
    public String getNote() {
        return note;
    }

    /**
     * 備考を設定します。
     * @param note 備考
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 登録プログラム名を取得します。
     * @return 登録プログラム名
     */
    public String getInsPg() {
        return insPg;
    }

    /**
     * 登録プログラム名を設定します。
     * @param insPg 登録プログラム名
     */
    public void setInsPg(String insPg) {
        this.insPg = insPg;
    }

    /**
     * 登録者IDを取得します。
     * @return 登録者ID
     */
    public String getInsId() {
        return insId;
    }

    /**
     * 登録者IDを設定します。
     * @param insId 登録者ID
     */
    public void setInsId(String insId) {
        this.insId = insId;
    }

    /**
     * 最終更新日時を取得します。
     * @return 最終更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日時を設定します。
     * @param updDt 最終更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 更新プログラム名を取得します。
     * @return 更新プログラム名
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 更新プログラム名を設定します。
     * @param updPg 更新プログラム名
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

    /**
     * 更新者IDを取得します。
     * @return 更新者ID
     */
    public String getUpdId() {
        return updId;
    }

    /**
     * 更新者IDを設定します。
     * @param updId 更新者ID
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }

}

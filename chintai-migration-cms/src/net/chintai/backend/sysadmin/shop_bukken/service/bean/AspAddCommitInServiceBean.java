/*
 * $Id: AspAddCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

import java.util.Map;

/**
 * 不動産ASP設定情報登録完了用InServiceBean
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspAddCommitInServiceBean {

    /** 会社名 */
    private String company;

    /** 事務所名 */
    private String bumon;

    /** 店舗コード */
    private String shopCd;

    /** タイトル表示用 */
    private String title;

    /** 画面レイアウト */
    private String layout;

    /** セレクトボックスタイプ */
    private String selectBoxType;

    /** テンプレートカラー */
    private String templateColor;

    /** 検索条件付加項目 */
    private String searchItem;

    /** 会社ロゴ表示フラグ */
    private String logoFlg;

    /** 画像のファイルパス*/
    private String imgRealPath;

    /** 画像のファイル名 */
    private String imgFileNm;

    /** イメージ区分*/
    private String imgKbn;

    /** 画像のURL */
    private String imgUrlPath;

    /** 画像の拡張子 */
    private String imgFileType;

    /** 個人情報保護方針表示フラグ */
    private String policyFlg;

    /** 個人情報保護方URL */
    private String policyUrl;

    /** 状態 */
    private String aspShopStatus;

    /** 設定された都道府県、沿線タイプのソートキー */
    private Map<String, String[]> requestMap;

    /** 沿線タイプ1 */
    private String ensenType1;

    /** 沿線タイプ2 */
    private String ensenType2;

    /** 沿線タイプ3 */
    private String ensenType3;

    /** 沿線タイプ4 */
    private String ensenType4;

    /** レコード作成プログラムID add kashiyama */
    private String insPg;

    /** レコード作成者 add kashiyama */
    private String insId;

    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

    /** イメージID*/
    private String imgId;

    /**
     * 会社名を取得します。
     * @return 会社名
     */
    public String getCompany() {
        return company;
    }

    /**
     * 会社名を設定します。
     * @param company 会社名
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 事務所名を取得します。
     * @return 事務所名
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 事務所名を設定します。
     * @param bumon 事務所名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

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
     * タイトル表示用を取得します。
     * @return タイトル表示用
     */
    public String getTitle() {
        return title;
    }

    /**
     * タイトル表示用を設定します。
     * @param title タイトル表示用
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 画面レイアウトを取得します。
     * @return 画面レイアウト
     */
    public String getLayout() {
        return layout;
    }

    /**
     * 画面レイアウトを設定します。
     * @param layout 画面レイアウト
     */
    public void setLayout(String layout) {
        this.layout = layout;
    }

    /**
     * セレクトボックスタイプを取得します。
     * @return セレクトボックスタイプ
     */
    public String getSelectBoxType() {
        return selectBoxType;
    }

    /**
     * セレクトボックスタイプを設定します。
     * @param selectBoxType セレクトボックスタイプ
     */
    public void setSelectBoxType(String selectBoxType) {
        this.selectBoxType = selectBoxType;
    }

    /**
     * テンプレートカラーを取得します。
     * @return テンプレートカラー
     */
    public String getTemplateColor() {
        return templateColor;
    }

    /**
     * テンプレートカラーを設定します。
     * @param templateColor テンプレートカラー
     */
    public void setTemplateColor(String templateColor) {
        this.templateColor = templateColor;
    }

    /**
     * 検索条件付加項目を取得します。
     * @return 検索条件付加項目
     */
    public String getSearchItem() {
        return searchItem;
    }

    /**
     * 検索条件付加項目を設定します。
     * @param searchItem 検索条件付加項目
     */
    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }

    /**
     * 会社ロゴ表示フラグを取得します。
     * @return 会社ロゴ表示フラグ
     */
    public String getLogoFlg() {
        return logoFlg;
    }

    /**
     * 会社ロゴ表示フラグを設定します。
     * @param logoFlg 会社ロゴ表示フラグ
     */
    public void setLogoFlg(String logoFlg) {
        this.logoFlg = logoFlg;
    }

    /**
     * 個人情報保護方針表示フラグを取得します。
     * @return 個人情報保護方針表示フラグ
     */
    public String getPolicyFlg() {
        return policyFlg;
    }

    /**
     * 個人情報保護方針表示フラグを設定します。
     * @param policyFlg 個人情報保護方針表示フラグ
     */
    public void setPolicyFlg(String policyFlg) {
        this.policyFlg = policyFlg;
    }

    /**
     * 個人情報保護方URLを取得します。
     * @return 個人情報保護方URL
     */
    public String getPolicyUrl() {
        return policyUrl;
    }

    /**
     * 個人情報保護方URLを設定します。
     * @param policyUrl 個人情報保護方URL
     */
    public void setPolicyUrl(String policyUrl) {
        this.policyUrl = policyUrl;
    }

    /**
     * 状態を取得します。
     * @return 状態
     */
    public String getAspShopStatus() {
        return aspShopStatus;
    }

    /**
     * 状態を設定します。
     * @param aspShopStatus 状態
     */
    public void setAspShopStatus(String aspShopStatus) {
        this.aspShopStatus = aspShopStatus;
    }

    /**
     * 設定された都道府県、沿線タイプのソートキーを取得します。
     * @return 設定された都道府県、沿線タイプのソートキー
     */
    public Map<String, String[]> getRequestMap() {
        return requestMap;
    }

    /**
     * 設定された都道府県、沿線タイプのソートキーを設定します。
     * @param requestMap 設定された都道府県、沿線タイプのソートキー
     */
    public void setRequestMap(Map<String, String[]> requestMap) {
        this.requestMap = requestMap;
    }

    /**
     * 沿線タイプ1を取得します。
     * @return 沿線タイプ1
     */
    public String getEnsenType1() {
        return ensenType1;
    }

    /**
     * 沿線タイプ1を設定します。
     * @param ensenType1 沿線タイプ1
     */
    public void setEnsenType1(String ensenType1) {
        this.ensenType1 = ensenType1;
    }

    /**
     * 沿線タイプ2を取得します。
     * @return 沿線タイプ2
     */
    public String getEnsenType2() {
        return ensenType2;
    }

    /**
     * 沿線タイプ2を設定します。
     * @param ensenType2 沿線タイプ2
     */
    public void setEnsenType2(String ensenType2) {
        this.ensenType2 = ensenType2;
    }

    /**
     * 沿線タイプ3を取得します。
     * @return 沿線タイプ3
     */
    public String getEnsenType3() {
        return ensenType3;
    }

    /**
     * 沿線タイプ3を設定します。
     * @param ensenType3 沿線タイプ3
     */
    public void setEnsenType3(String ensenType3) {
        this.ensenType3 = ensenType3;
    }

    /**
     * 沿線タイプ4を取得します。
     * @return 沿線タイプ4
     */
    public String getEnsenType4() {
        return ensenType4;
    }

    /**
     * 沿線タイプ4を設定します。
     * @param ensenType4 沿線タイプ4
     */
    public void setEnsenType4(String ensenType4) {
        this.ensenType4 = ensenType4;
    }

    /**
     * レコード作成プログラムIDを返します。
     * @return レコード作成プログラムID
     */
    public String getInsPg() {
        return insPg;
    }

    /**
     * レコード作成プログラムIDを設定します。
     * @param insPg レコード作成プログラムID
     */
    public void setInsPg(String insPg) {
        this.insPg = insPg;
    }

    /**
     * レコード作成者を返します。
     * @return レコード作成者
     */
    public String getInsId() {
        return insId;
    }

    /**
     * レコード作成者を設定します。
     * @param insId レコード作成者
     */
    public void setInsId(String insId) {
        this.insId = insId;
    }
    /**
     *  店舗管理テーブル更新日時を返します。
     * @return  店舗管理テーブル更新日時
     */
    public String getShopKanriUpdDt() {
        return shopKanriUpdDt;
    }

    /**
     *  店舗管理テーブル更新日時を設定します。
     * @param shopKanriUpdDt   店舗管理テーブル更新日時
     */
    public void setShopKanriUpdDt(String shopKanriUpdDt) {
        this.shopKanriUpdDt = shopKanriUpdDt;
    }


    /**
     *  画像のファイルパスを返します。
     * @return imgRealPath
     */
    public String getImgRealPath() {
        return imgRealPath;
    }

    /**
     *  画像のファイルパスを設定します。
     * @param imgRealPath   画像のファイルパス
     */
    public void setImgRealPath(String imgRealPath) {
        this.imgRealPath = imgRealPath;
    }

    /**
     * 画像のファイル名を返します。
     * @return imgFileNm
     */
    public String getImgFileNm() {
        return imgFileNm;
    }

    /**
     * 画像のファイル名を設定します。
     * @param imgFileNm  画像のファイル名
     */
    public void setImgFileNm(String imgFileNm) {
        this.imgFileNm = imgFileNm;
    }

    /**
     * 画像のURLを返します。
     * @return imgUrlPath
     */
    public String getImgUrlPath() {
        return imgUrlPath;
    }

    /**
     * 画像のURLを設定します。
     * @param imgUrlPath  画像のURL
     */
    public void setImgUrlPath(String imgUrlPath) {
        this.imgUrlPath = imgUrlPath;
    }

    /**
     * 画像の拡張子を返します。
     * @return imgFileType
     */
    public String getImgFileType() {
        return imgFileType;
    }

    /**
     * 画像の拡張子を設定します。
     * @param imgFileType  imgFileType
     */
    public void setImgFileType(String imgFileType) {
        this.imgFileType = imgFileType;
    }

    /**
     * imgKbnを返します。
     * @return imgKbn
     */
    public String getImgKbn() {
        return imgKbn;
    }

    /**
     * imgKbnを設定します。
     * @param imgKbn  imgKbn
     */
    public void setImgKbn(String imgKbn) {
        this.imgKbn = imgKbn;
    }

    /**
     * imgIdを返します。
     * @return imgId
     */
	public String getImgId() {
		return imgId;
	}

    /**
     * imgIdを設定します。
     * @param imgId  imgId
     */
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

}

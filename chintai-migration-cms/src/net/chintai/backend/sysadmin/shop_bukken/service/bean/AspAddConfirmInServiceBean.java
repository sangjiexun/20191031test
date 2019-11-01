/*
 * $Id: AspAddConfirmInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

import java.util.List;
import java.util.SortedMap;

import net.chintai.backend.sysadmin.shop_bukken.domain.AspPrefInfo;

/**
 * 不動産ASP設定情報登録確認画面用InServiceBean
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspAddConfirmInServiceBean {

    /** 会社名 */
    private String company;

    /** 事務所名 */
    private String bumon;

    /** 店舗コード */
    private String shopCd;

    /** お客様設定パスワード */
    private String password;

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

    /** 会社ロゴ画像ファイル形式 */
    private String logoFlgImage;

    /** アップロードされた画像ファイルパス */
    private String logoFlgUrlPath;

    /** 個人情報保護方針表示フラグ */
    private String policyFlg;

    /** 個人情報保護方URL */
    private String policyUrl;

    /** 沿線設定 : JR */
    private String ensenCd1;

    /** 沿線設定 : 私鉄 */
    private String ensenCd2;

    /** 沿線設定 : 地下鉄 */
    private String ensenCd3;

    /** 設定された都道府県、沿線タイプのソートキー */
    private SortedMap<String, String[]> sortedMap;

    /** 都道府県リスト */
    private List<AspPrefInfo> prefList;

    /** イメージID */
    private String imgId;

    /**
     * 会社名を設定します。
     * @param company 会社名
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 会社名を取得します。
     * @return 会社名
     */
    public String getCompany() {
        return company;
    }

    /**
     * 事務所名を設定します。
     * @param bumon 事務所名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

    /**
     * 事務所名を取得します。
     * @return 事務所名
     */
    public String getBumon() {
        return bumon;
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
     * お客様設定パスワードを設定します。
     * @param password お客様設定パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * お客様設定パスワードを取得します。
     * @return お客様設定パスワード
     */
    public String getPassword() {
        return password;
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
     * 会社ロゴ画像ファイル形式を取得します。
     * @return 会社ロゴ画像ファイル形式
     */
    public String getLogoFlgImage() {
        return logoFlgImage;
    }

    /**
     * 会社ロゴ画像ファイル形式を設定します。
     * @param logoFlgImage 会社ロゴ画像ファイル形式
     */
    public void setLogoFlgImage(String logoFlgImage) {
        this.logoFlgImage = logoFlgImage;
    }

    /**
     * アップロードされた画像ファイルパスを設定します。
     * @param logoFlgUrlPath アップロードされた画像ファイルパス
     */
    public void setLogoFlgUrlPath(String logoFlgUrlPath) {
        this.logoFlgUrlPath = logoFlgUrlPath;
    }

    /**
     * アップロードされた画像ファイルパスを取得します。
     * @return アップロードされた画像ファイルパス
     */
    public String getLogoFlgUrlPath() {
        return logoFlgUrlPath;
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
     * 沿線設定 : JRを取得します。
     * @return 沿線設定 : JR
     */
    public String getEnsenCd1() {
        return ensenCd1;
    }

    /**
     * 沿線設定 : JRを設定します。
     * @param ensenCd1 沿線設定 : JR
     */
    public void setEnsenCd1(String ensenCd1) {
        this.ensenCd1 = ensenCd1;
    }

    /**
     * 沿線設定 : 私鉄を取得します。
     * @return 沿線設定 : 私鉄
     */
    public String getEnsenCd2() {
        return ensenCd2;
    }

    /**
     * 沿線設定 : 私鉄を設定します。
     * @param ensenCd2 沿線設定 : 私鉄
     */
    public void setEnsenCd2(String ensenCd2) {
        this.ensenCd2 = ensenCd2;
    }

    /**
     * 沿線設定 : 地下鉄を取得します。
     * @return 沿線設定 : 地下鉄
     */
    public String getEnsenCd3() {
        return ensenCd3;
    }

    /**
     * 沿線設定 : 地下鉄を設定します。
     * @param ensenCd3 沿線設定 : 地下鉄
     */
    public void setEnsenCd3(String ensenCd3) {
        this.ensenCd3 = ensenCd3;
    }

    /**
     * 設定された都道府県、沿線タイプのソートキーを設定します。
     * @param sortedMap 設定された都道府県、沿線タイプのソートキー
     */
    public void setSortedMap(SortedMap<String, String[]> sortedMap) {
        this.sortedMap = sortedMap;
    }

    /**
     * 設定された都道府県、沿線タイプのソートキーを取得します。
     * @return 設定された都道府県、沿線タイプのソートキー
     */
    public SortedMap<String, String[]> getSortedMap() {
        return sortedMap;
    }

    /**
     * 都道府県リストを設定します。
     * @param prefList 都道府県リスト
     */
    public void setPrefList(List<AspPrefInfo> prefList) {
        this.prefList = prefList;
    }

    /**
     * 都道府県リストを取得します。
     * @return 都道府県リスト
     */
    public List<AspPrefInfo> getPrefList() {
        return prefList;
    }

    /**
     * イメージID
     * @return 沿線設定 : 地下鉄
     */
    public String getImgId() {
        return imgId;
    }

    /**
     * イメージID
     * @param ensenCd3 イメージID
     */
    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

}

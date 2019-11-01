/*
 * $Id: AspUpdateOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

import java.util.List;

/**
 * 不動産ASP更新データ用OutServiceBean
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspUpdateOutServiceBean {

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
    private String logoImageType;

    /** 個人情報保護方針表示フラグ */
    private String policyFlg;

    /** 個人情報保護方URL */
    private String policyUrl;

    /** 状態 */
    private String aspShopStatus;

    /** 沿線タイプ1 : JR */
    private String ensenCd1;

    /** 沿線タイプ2 : 私鉄 */
    private String ensenCd2;

    /** 沿線タイプ3 : 地下鉄 */
    private String ensenCd3;

    /** 最終更新日付 */
    private String updDt;

    /** エリア設定リスト */
    private List<PrefListDetailView> prefList;

    /** 沿線設定 */
    private List<EnsenTypeListDetailView> ensenTypeList;

    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

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
     * 店舗コードを設定します。
     * @param shopCd 店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getShopCd() {
        return shopCd;
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
     * logoImageTypeを返します。
     * @return logoImageType
     */
    public String getLogoImageType() {
        return logoImageType;
    }

    /**
     * を設定します。
     * @param logoImageType  logoImageType
     */
    public void setLogoImageType(String logoImageType) {
        this.logoImageType = logoImageType;
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
     * 状態を設定します。
     * @param aspShopStatus 状態
     */
    public void setAspShopStatus(String aspShopStatus) {
        this.aspShopStatus = aspShopStatus;
    }

    /**
     * 状態を取得します。
     * @return 状態
     */
    public String getAspShopStatus() {
        return aspShopStatus;
    }

    /**
     * 沿線タイプ1 : JRを取得します。
     * @return 沿線タイプ1 : JR
     */
    public String getEnsenCd1() {
        return ensenCd1;
    }

    /**
     * 沿線タイプ1 : JRを設定します。
     * @param ensenCd1 沿線タイプ1 : JR
     */
    public void setEnsenCd1(String ensenCd1) {
        this.ensenCd1 = ensenCd1;
    }

    /**
     * 沿線タイプ2 : 私鉄を取得します。
     * @return 沿線タイプ2 : 私鉄
     */
    public String getEnsenCd2() {
        return ensenCd2;
    }

    /**
     * 沿線タイプ2 : 私鉄を設定します。
     * @param ensenCd2 沿線タイプ2 : 私鉄
     */
    public void setEnsenCd2(String ensenCd2) {
        this.ensenCd2 = ensenCd2;
    }

    /**
     * 沿線タイプ3 : 地下鉄を取得します。
     * @return 沿線タイプ3 : 地下鉄
     */
    public String getEnsenCd3() {
        return ensenCd3;
    }

    /**
     * 沿線タイプ3 : 地下鉄を設定します。
     * @param ensenCd3 沿線タイプ3 : 地下鉄
     */
    public void setEnsenCd3(String ensenCd3) {
        this.ensenCd3 = ensenCd3;
    }

    /**
     * 最終更新日付を設定します。
     * @param updDt 最終更新日付
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 最終更新日付を取得します。
     * @return 最終更新日付
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * エリア設定リストを設定します。
     * @param prefList エリア設定リスト
     */
    public void setPrefList(List<PrefListDetailView> prefList) {
        this.prefList = prefList;
    }

    /**
     * エリア設定リストを取得します。
     * @return エリア設定リスト
     */
    public List<PrefListDetailView> getPrefList() {
        return prefList;
    }

    public class PrefListDetailView {

        /** 都道府県コード */
        private String prefCd;

        /** 都道府県名 */
        private String prefName;

        /** 都道府県ソートキー */
        private String prefSortKey;

        /**
         * 都道府県コードを取得します。
         * @return prefCd 都道府県コード
         */
        public String getPrefCd() {
            return prefCd;
        }

        /**
         * 都道府県コードを設定します。
         * @param prefCd 都道府県コード
         */
        public void setPrefCd(String prefCd) {
            this.prefCd = prefCd;
        }

        /**
         * 都道府県名を取得します。
         * @return prefName 都道府県名
         */
        public String getPrefName() {
            return prefName;
        }

        /**
         * 都道府県名を設定します。
         * @param prefName 都道府県名
         */
        public void setPrefName(String prefName) {
            this.prefName = prefName;
        }

        /**
         * 都道府県ソートキーを取得します。
         * @return prefSortKey 都道府県ソートキー
         */
        public String getPrefSortKey() {
            return prefSortKey;
        }

        /**
         * 都道府県ソートキーを設定します。
         * @param prefSortKey 都道府県ソートキー
         */
        public void setPrefSortKey(String prefSortKey) {
            this.prefSortKey = prefSortKey;
        }

    }

    public class EnsenTypeListDetailView {

        /** 沿線タイプコード */
        private String ensenCd;

        /** 沿線タイプ名 */
        private String ensenName;

        /** 沿線タイプソートキー */
        private String ensenSortKey;

        /**
         * 沿線タイプコードを取得します。
         * @return ensenCd 沿線タイプコード
         */
        public String getEnsenCd() {
            return ensenCd;
        }

        /**
         * 沿線タイプコードを設定します。
         * @param ensenCd 沿線タイプコード
         */
        public void setEnsenCd(String ensenCd) {
            this.ensenCd = ensenCd;
        }

        /**
         * 沿線タイプ名を取得します。
         * @return ensenName 沿線タイプ名
         */
        public String getEnsenName() {
            return ensenName;
        }

        /**
         * 沿線タイプ名を設定します。
         * @param ensenName 沿線タイプ名
         */
        public void setEnsenName(String ensenName) {
            this.ensenName = ensenName;
        }

        /**
         * 沿線タイプソートキーを取得します。
         * @return ensenSortKey 沿線タイプソートキー
         */
        public String getEnsenSortKey() {
            return ensenSortKey;
        }

        /**
         * 沿線タイプソートキーを設定します。
         * @param ensenSortKey 沿線タイプソートキー
         */
        public void setEnsenSortKey(String ensenSortKey) {
            this.ensenSortKey = ensenSortKey;
        }

    }

    /**
     * 沿線設定を取得します。
     * @return 沿線設定
     */
    public List<EnsenTypeListDetailView> getEnsenTypeList() {
        return ensenTypeList;
    }

    /**
     * 沿線設定を設定します。
     * @param ensenTypeList 沿線設定
     */
    public void setEnsenTypeList(List<EnsenTypeListDetailView> ensenTypeList) {
        this.ensenTypeList = ensenTypeList;
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

}

/*
 * $Id: AspUpdateView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 不動産ASP設定更新画面で使用するViewHelper
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspUpdateView implements ViewHelper {

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

    /** 画像のファイルパス*/
    private String imgRealPath;

    /** 画像のファイル名 */
    private String imgFileNm;

    /** 画像のイメージ区分*/
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

    /** 沿線設定 : JR */
    private String ensenCd1;

    /** 沿線設定 : 私鉄 */
    private String ensenCd2;

    /** 沿線設定 : 地下鉄 */
    private String ensenCd3;

    /** エリアと都道府県のリスト */
    private List<AspAddPageDetailView> aspAreaPrefInfoList;

    /** 最終更新日付 */
    private String updDt;

    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

    /** imgId*/
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
     * イメージ区分を返します。
     * @return imgKbn
     */
    public String getImgKbn() {
        return imgKbn;
    }

    /**
     * イメージ区分を設定します。
     * @param imgKbn  イメージ区分
     */
    public void setImgKbn(String imgKbn) {
        this.imgKbn = imgKbn;
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
     * 最終更新日付を設定します。
     * @param updDt 最終更新日付
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 状態を取得します。
     * @return 状態
     */
    public String getAspShopStatus() {
        return aspShopStatus;
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
     * エリアと都道府県のリストを取得します。
     * @return エリアと都道府県のリスト
     */
    public List<AspAddPageDetailView> getAspAreaPrefInfoList() {
        return aspAreaPrefInfoList;
    }

    /**
     * エリアと都道府県のリストを設定します。
     * @param aspAreaPrefInfoList エリアと都道府県のリスト
     */
    public void setAspAreaPrefInfoList(List<AspAddPageDetailView> aspAreaPrefInfoList) {
        this.aspAreaPrefInfoList = aspAreaPrefInfoList;
    }

    public class AspAddPageDetailView {

        /** エリアコード */
        private String areaCd;

        /** エリア名 */
        private String areaName;

        /** 都道府県リスト */
        private List<AspAreaPrefInfoOutServiceDetailBean> prefList;

        /**
         * エリアコードを取得します。
         * @return エリアコード
         */
        public String getAreaCd() {
            return areaCd;
        }

        /**
         * エリアコードを設定します。
         * @param areaCd エリアコード
         */
        public void setAreaCd(String areaCd) {
            this.areaCd = areaCd;
        }

        /**
         * エリア名を取得します。
         * @return エリア名
         */
        public String getAreaName() {
            return areaName;
        }

        /**
         * エリア名を設定します。
         * @param areaName エリア名
         */
        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        /**
         * 都道府県リストを取得します。
         * @return 都道府県リスト
         */
        public List<AspAreaPrefInfoOutServiceDetailBean> getPrefList() {
            return prefList;
        }

        /**
         * 都道府県リストを設定します。
         * @param prefList 都道府県リスト
         */
        public void setPrefList(List<AspAreaPrefInfoOutServiceDetailBean> prefList) {
            this.prefList = prefList;
        }

        public class AspAreaPrefInfoOutServiceDetailBean {

            /** 都道府県コード */
            private String prefCd;

            /** 都道府県名 */
            private String prefName;

            /** エリア都道府県のコード名 */
            private String prefCodeName;

            /** 入力されたソートキー */
            private String prefSortKey;

            /**
             * 都道府県コードを取得します。
             * @return 都道府県コード
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
             * @return 都道府県名
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
             * エリア都道府県のコード名を取得します。
             * @return エリア都道府県のコード名
             */
            public String getPrefCodeName() {
                return prefCodeName;
            }

            /**
             * エリア都道府県のコード名を設定します。
             * @param prefCodeName エリア都道府県のコード名
             */
            public void setPrefCodeName(String prefCodeName) {
                this.prefCodeName = prefCodeName;
            }

            /**
             * 入力されたソートキーを取得します。
             * @return 入力されたソートキー
             */
            public String getPrefSortKey() {
                return prefSortKey;
            }

            /**
             * 入力されたソートキーを設定します。
             * @param prefSortKey 入力されたソートキー
             */
            public void setPrefSortKey(String prefSortKey) {
                this.prefSortKey = prefSortKey;
            }

        }
    }

    /**
     * 最終更新日付を取得します。
     * @return 最終更新日付
     */
    public String getUpdDt() {
        return updDt;
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

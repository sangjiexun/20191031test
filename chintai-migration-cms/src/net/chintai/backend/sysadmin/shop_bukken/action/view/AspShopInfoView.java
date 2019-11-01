/*
 * $Id: AspShopInfoView.java 3769 2008-01-21 10:41:43Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)沈鍾沿     新規作成
 * 2007/10/22  BGT)楊恩美     グループ追加
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 不動産ASP設定情報画面で使用するViewHelper
 *
 * @author Sim-JongYeon
 * @version $Revision: 3769 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspShopInfoView implements ViewHelper {

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

    /** 個人情報保護方針表示フラグ */
    private String policyFlg;

    /** 個人情報保護方URL */
    private String policyUrl;

    /** 状態 */
    private String aspShopStatus;

    /** 最終更新日付 */
    private String updDt;

    /** 登録日付 */
    private String insDt;

    /** エリア設定リスト */
    private List<PrefListDetailView> prefList;

    /** 沿線設定 */
    private List<EnsenTypeListDetailView> ensenTypeList;

    /** グループリスト */
    private List<AspGroupListDetailView> aspGroupList;

    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

    private String imgUrlPath;

    private String imgFileNm;

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
     * お客様設定パスワードを取得します。
     * @return お客様設定パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * お客様設定パスワードを設定します。
     * @param password お客様設定パスワード
     */
    public void setPassword(String password) {
        this.password = password;
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
     * 最終更新日付を取得します。
     * @return 最終更新日付
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日付を設定します。
     * @param updDt 最終更新日付
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 登録日付を取得します。
     * @return 登録日付
     */
    public String getInsDt() {
        return insDt;
    }

    /**
     * 登録日付を設定します。
     * @param insDt 登録日付
     */
    public void setInsDt(String insDt) {
        this.insDt = insDt;
    }

    /**
     * エリア設定リストを取得します。
     * @return エリア設定リスト
     */
    public List<PrefListDetailView> getPrefList() {
        return prefList;
    }

    /**
     * エリア設定リストを設定します。
     * @param prefList エリア設定リスト
     */
    public void setPrefList(List<PrefListDetailView> prefList) {
        this.prefList = prefList;
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
     * グループリストを取得します。
     * @return グループリスト
     */
    public List<AspGroupListDetailView> getAspGroupList() {
        return aspGroupList;
    }

    /**
     * グループリストを設定します。
     * @param aspGroupList グループリスト
     */
    public void setAspGroupList(List<AspGroupListDetailView> aspGroupList) {
        this.aspGroupList = aspGroupList;
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
     * imgUrlPathを返します。
     * @return imgUrlPath
     */
    public String getImgUrlPath() {
        return imgUrlPath;
    }

    /**
     * を設定します。
     * @param imgUrlPath  imgUrlPath
     */
    public void setImgUrlPath(String imgUrlPath) {
        this.imgUrlPath = imgUrlPath;
    }

    /**
     * imgFileNmを返します。
     * @return imgFileNm
     */
    public String getImgFileNm() {
        return imgFileNm;
    }

    /**
     * を設定します。
     * @param imgFileNm  imgFileNm
     */
    public void setImgFileNm(String imgFileNm) {
        this.imgFileNm = imgFileNm;
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
         * 都道府県ソートキーを取得します。
         * @return 都道府県ソートキー
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
         * @return 沿線タイプコード
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
         * @return 沿線タイプ名
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
         * @return 沿線タイプソートキー
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

    public class AspGroupListDetailView {

        /** 店舗コード */
        private String groupshopCd;

        /** 会社名 */
        private String company;

        /** 事務所名 */
        private String bumon;

        /** 店舗メールアドレス */
        private String email;

        /** 代表者名 */
        private String licTrust;

        /** 代表Tel */
        private String shopTel;

        /** 代表Fax */
        private String shopFax;

        /** 承認 */
        private String certifyFlg;

        /** 状態 */
        private String shopStatus;

        /** 区分 */
        private String datakubun;

        /** データ元 */
        private String clientsystemType;

        /** ASP */
        private String aspFlg;

        /** 売買 */
        private String adparkSendFlg;

        /** 有効物件数 */
        private String bukkenCnt;

        /** ユーザ最終更新日付 */
        private String updDt;

        /** グループ削除フラグ */
        private String delFlg;

        /** CHINTAI掲載 */
        private String ctFlg;

        /** エイブル掲載 */
        private String ablFlg;

        /**  不動産ＡＳＰ連番 add kashiyama */
        private Long aspShopSeq;

        /** 連動名 add kashiyama */
        private String rendoName;

        /**
         * グループ削除フラグを取得します。
         * @return グループ削除フラグ
         */
        public String getDelFlg() {
            return delFlg;
        }

        /**
         * グループ削除フラグを設定します。
         * @param delFlg グループ削除フラグ
         */
        public void setDelFlg(String delFlg) {
            this.delFlg = delFlg;
        }

        /**
         * 売買を取得します。
         * @return 売買
         */
        public String getAdparkSendFlg() {
            return adparkSendFlg;
        }

        /**
         * 売買を設定します。
         * @param adparkSendFlg 売買
         */
        public void setAdparkSendFlg(String adparkSendFlg) {
            this.adparkSendFlg = adparkSendFlg;
        }

        /**
         * ASPを取得します。
         * @return ASP
         */
        public String getAspFlg() {
            return aspFlg;
        }

        /**
         * ASPを設定します。
         * @param aspFlg ASP
         */
        public void setAspFlg(String aspFlg) {
            this.aspFlg = aspFlg;
        }

        /**
         * 有効物件数を取得します。
         * @return 有効物件数
         */
        public String getBukkenCnt() {
            return bukkenCnt;
        }

        /**
         * 有効物件数を設定します。
         * @param bukkenCnt 有効物件数
         */
        public void setBukkenCnt(String bukkenCnt) {
            this.bukkenCnt = bukkenCnt;
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
         * 承認を取得します。
         * @return 承認
         */
        public String getCertifyFlg() {
            return certifyFlg;
        }

        /**
         * 承認を設定します。
         * @param certifyFlg 承認
         */
        public void setCertifyFlg(String certifyFlg) {
            this.certifyFlg = certifyFlg;
        }

        /**
         * データ元を取得します。
         * @return データ元
         */
        public String getClientsystemType() {
            return clientsystemType;
        }

        /**
         * データ元を設定します。
         * @param clientsystemType データ元
         */
        public void setClientsystemType(String clientsystemType) {
            this.clientsystemType = clientsystemType;
        }

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
         * 店舗メールアドレスを取得します。
         * @return 店舗メールアドレス
         */
        public String getEmail() {
            return email;
        }

        /**
         * 店舗メールアドレスを設定します。
         * @param email 店舗メールアドレス
         */
        public void setEmail(String email) {
            this.email = email;
        }

        /**
         * 代表者名を取得します。
         * @return 代表者名
         */
        public String getLicTrust() {
            return licTrust;
        }

        /**
         * 代表者名を設定します。
         * @param licTrust 代表者名
         */
        public void setLicTrust(String licTrust) {
            this.licTrust = licTrust;
        }

        /**
         * 店舗コードを取得します。
         * @return 店舗コード
         */
        public String getGroupshopCd() {
            return groupshopCd;
        }

        /**
         * 店舗コードを設定します。
         * @param groupshopCd 店舗コード
         */
        public void setGroupshopCd(String groupshopCd) {
            this.groupshopCd = groupshopCd;
        }

        /**
         * 代表Faxを取得します。
         * @return 代表Fax
         */
        public String getShopFax() {
            return shopFax;
        }

        /**
         * 代表Faxを設定します。
         * @param shopFax 代表Fax
         */
        public void setShopFax(String shopFax) {
            this.shopFax = shopFax;
        }

        /**
         * 状態を取得します。
         * @return 状態
         */
        public String getShopStatus() {
            return shopStatus;
        }

        /**
         * 状態を設定します。
         * @param shopStatus 状態
         */
        public void setShopStatus(String shopStatus) {
            this.shopStatus = shopStatus;
        }

        /**
         * 代表Telを取得します。
         * @return 代表Tel
         */
        public String getShopTel() {
            return shopTel;
        }

        /**
         * 代表Telを設定します。
         * @param shopTel 代表Tel
         */
        public void setShopTel(String shopTel) {
            this.shopTel = shopTel;
        }

        /**
         * ユーザ最終更新日付を取得します。
         * @return ユーザ最終更新日付
         */
        public String getUpdDt() {
            return updDt;
        }

        /**
         * ユーザ最終更新日付を設定します。
         * @param updDt ユーザ最終更新日付
         */
        public void setUpdDt(String updDt) {
            this.updDt = updDt;
        }

        /**
         * 区分を取得します。
         * @return 区分
         */
        public String getDatakubun() {
            return datakubun;
        }

        /**
         * 区分を設定します。
         * @param datakubun 区分
         */
        public void setDatakubun(String datakubun) {
            this.datakubun = datakubun;
        }

        /**
         * CHINTAI掲載を取得します。
         * @return CHINTAI掲載
         */
        public String getCtFlg() {
            return ctFlg;
        }

        /**
         * CHINTAI掲載を設定します。
         * @param ctFlg CHINTAI掲載
         */
        public void setCtFlg(String ctFlg) {
            this.ctFlg = ctFlg;
        }

        /**
         * エイブル掲載を取得します。
         * @return エイブル掲載
         */
        public String getAblFlg() {
            return ablFlg;
        }

        /**
         * エイブル掲載を設定します。
         * @param ablFlg エイブル掲載
         */
        public void setAblFlg(String ablFlg) {
            this.ablFlg = ablFlg;
        }

        /**
         * 不動産ＡＳＰ連番を取得します。
         *
         * @return 不動産ＡＳＰ連番
         */
        public Long getAspShopSeq() {
            return aspShopSeq;
        }

        /**
         * 不動産ＡＳＰ連番を設定します。
         *
         * @param aspShopSeq
         *            不動産ＡＳＰ連番
         */
        public void setAspShopSeq(Long aspShopSeq) {
            this.aspShopSeq = aspShopSeq;
        }

        /**
         *  連動名を返します。
         * @return  連動名
         */
        public String getRendoName() {
            return rendoName;
        }

        /**
         *  連動名を設定します。
         * @param rendoName   連動名
         */
        public void setRendoName(String rendoName) {
            this.rendoName = rendoName;
        }
    }

}

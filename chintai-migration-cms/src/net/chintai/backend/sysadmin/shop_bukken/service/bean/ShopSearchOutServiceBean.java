/*
 * $Id: ShopSearchOutServiceBean.java 3853 2008-03-10 05:43:48Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 店舗一覧Bean
 *
 * @author JavaBeans Code Generator
 * @version $Revision: 3853 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSearchOutServiceBean {

    /** 会社名 */
    private String company;

    /** 事務所名 */
    private String bumon;

    /** 店舗コード */
    private String shopCd;

    /** パスワード */
    private String password;

    /** 所属団体 */
    private String dantai;

    /** 代表者名 */
    private String licTrust;

    /** 所属グループ */
    private String groupName;

    /** 郵便番号 */
    private String zip;

    /** 住所1 */
    private String address1;

    /** 住所2 */
    private String address2;

    /** 代表Tel */
    private String tel;

    /** 代表Fax */
    private String fax;

    /** 店舗メールアドレス */
    private String email;

    /** エリアコード */
    private String areaCd;

    /** エリア名 */
    private String areaName;

    /** 都道府県コード */
    private String prefCd;

    /** 都道府県名 */
    private String prefName;

    /** 市区町村コード */
    private String cityCd;

    /** 市区町村名 */
    private String cityName;

    /** 沿線タイプ */
    private String ensenType;

    /** 沿線コード */
    private String ensenCd;

    /** 沿線名 */
    private String ensenName;

    /** 駅コード */
    private String ekiCd;

    /** 駅名 */
    private String ekiName;

    /** 免許証番号 */
    private String licNum;

    /** 免許証登録日 */
    private String licEntry;

    /** 免許証有効期限 */
    private String licValid;

    /** 宅地建物取引主任者 */
    private String licChief;

    /** 担当者 */
    private String tantou;

    /** ホームページ名称 */
    private String hpName;

    /** ホームページURL */
    private String hpUrl;

    /** FAX/Mailフラグ */
    private String fmKbn;

    /** 店舗サイトへの最終ログイン時刻 */
    private String lastLoginDt;

    /** 店舗最終更新日時 */
    private String shopUpdDt;

    /** 承認状態 */
    private String certifyFlg;

    /** 店舗状態 */
    private String shopStatus;

    /** CHINTAI掲載 */
    private String ctFlg;

    /** エイブル掲載 */
    private String ablFlg;

    /** データ元 */
    private String clientsystemType;

    /** 店舗サイト権限 */
    private String shopSiteRole;

    /** 管理メモ */
    private String adminNote;

    /** 管理最終更新日時 */
    private String adminUpdDt;

    /** ピックアップ不動産利用状況 */
    private String pickUpCnt;

    /** 不動産ASP利用状況 */
    private String aspCnt;

    /** アドパーク送信可フラグ */
    private String adparkSendFlg;

    /** Webログ利用可フラグ */
    private String webLogFlg;

    /** 店舗地図フラグ */
    private String shopMapPctFlg;

    /** 店舗画像1フラグ */
    private String shopPhoto1Flg;

    /** 店舗画像2フラグ */
    private String shopPhoto2Flg;

    /** 店舗名カナ */
    private String bumonKana;

    /** CHINTAIサイト有効物件数 */
    private String chintaiBukkenCount;

    /** ABLEサイト有効物件数 */
    private String ableBukkenCount;

    /** 最終更新日時 */
    private String updDt;

    private String rendoCd;

    private String rendoName;


    /**
	 * @return rendoCd
	 */
	public String getRendoCd() {
		return rendoCd;
	}

	/**
	 * @param rendoCd the rendoCd to set
	 */
	public void setRendoCd(String rendoCd) {
		this.rendoCd = rendoCd;
	}

	/**
	 * @return rendoName
	 */
	public String getRendoName() {
		return rendoName;
	}

	/**
	 * @param rendoName the rendoName to set
	 */
	public void setRendoName(String rendoName) {
		this.rendoName = rendoName;
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
     * パスワードを取得します。
     * @return パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワードを設定します。
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 所属団体を取得します。
     * @return 所属団体
     */
    public String getDantai() {
        return dantai;
    }

    /**
     * 所属団体を設定します。
     * @param dantai 所属団体
     */
    public void setDantai(String dantai) {
        this.dantai = dantai;
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
     * 所属グループを取得します。
     * @return 所属グループ
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 所属グループを設定します。
     * @param groupName 所属グループ
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 郵便番号を取得します。
     * @return 郵便番号
     */
    public String getZip() {
        return zip;
    }

    /**
     * 郵便番号を設定します。
     * @param zip 郵便番号
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * 住所1を取得します。
     * @return 住所1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * 住所1を設定します。
     * @param address1 住所1
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * 住所2を取得します。
     * @return 住所2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * 住所2を設定します。
     * @param address2 住所2
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * 代表Telを取得します。
     * @return 代表Tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * 代表Telを設定します。
     * @param tel 代表Tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 代表Faxを取得します。
     * @return 代表Fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * 代表Faxを設定します。
     * @param fax 代表Fax
     */
    public void setFax(String fax) {
        this.fax = fax;
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
     * 市区町村コードを取得します。
     * @return 市区町村コード
     */
    public String getCityCd() {
        return cityCd;
    }

    /**
     * 市区町村コードを設定します。
     * @param cityCd 市区町村コード
     */
    public void setCityCd(String cityCd) {
        this.cityCd = cityCd;
    }

    /**
     * 市区町村名を取得します。
     * @return 市区町村名
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 市区町村名を設定します。
     * @param cityName 市区町村名
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 沿線タイプを取得します。
     * @return 沿線タイプ
     */
    public String getEnsenType() {
        return ensenType;
    }

    /**
     * 沿線タイプを設定します。
     * @param ensenType 沿線タイプ
     */
    public void setEnsenType(String ensenType) {
        this.ensenType = ensenType;
    }

    /**
     * 沿線コードを取得します。
     * @return 沿線コード
     */
    public String getEnsenCd() {
        return ensenCd;
    }

    /**
     * 沿線コードを設定します。
     * @param ensenCd 沿線コード
     */
    public void setEnsenCd(String ensenCd) {
        this.ensenCd = ensenCd;
    }

    /**
     * 沿線名を取得します。
     * @return 沿線名
     */
    public String getEnsenName() {
        return ensenName;
    }

    /**
     * 沿線名を設定します。
     * @param ensenName 沿線名
     */
    public void setEnsenName(String ensenName) {
        this.ensenName = ensenName;
    }

    /**
     * 駅コードを取得します。
     * @return 駅コード
     */
    public String getEkiCd() {
        return ekiCd;
    }

    /**
     * 駅コードを設定します。
     * @param ekiCd 駅コード
     */
    public void setEkiCd(String ekiCd) {
        this.ekiCd = ekiCd;
    }

    /**
     * 駅名を取得します。
     * @return 駅名
     */
    public String getEkiName() {
        return ekiName;
    }

    /**
     * 駅名を設定します。
     * @param ekiName 駅名
     */
    public void setEkiName(String ekiName) {
        this.ekiName = ekiName;
    }

    /**
     * 免許証番号を取得します。
     * @return 免許証番号
     */
    public String getLicNum() {
        return licNum;
    }

    /**
     * 免許証番号を設定します。
     * @param licNum 免許証番号
     */
    public void setLicNum(String licNum) {
        this.licNum = licNum;
    }

    /**
     * 免許証登録日を取得します。
     * @return 免許証登録日
     */
    public String getLicEntry() {
        return licEntry;
    }

    /**
     * 免許証登録日を設定します。
     * @param licEntry 免許証登録日
     */
    public void setLicEntry(String licEntry) {
        this.licEntry = licEntry;
    }

    /**
     * 免許証有効期限を取得します。
     * @return 免許証有効期限
     */
    public String getLicValid() {
        return licValid;
    }

    /**
     * 免許証有効期限を設定します。
     * @param licValid 免許証有効期限
     */
    public void setLicValid(String licValid) {
        this.licValid = licValid;
    }

    /**
     * 宅地建物取引主任者を取得します。
     * @return 宅地建物取引主任者
     */
    public String getLicChief() {
        return licChief;
    }

    /**
     * 宅地建物取引主任者を設定します。
     * @param licChief 宅地建物取引主任者
     */
    public void setLicChief(String licChief) {
        this.licChief = licChief;
    }

    /**
     * 担当者を取得します。
     * @return 担当者
     */
    public String getTantou() {
        return tantou;
    }

    /**
     * 担当者を設定します。
     * @param tantou 担当者
     */
    public void setTantou(String tantou) {
        this.tantou = tantou;
    }

    /**
     * ホームページ名称を取得します。
     * @return ホームページ名称
     */
    public String getHpName() {
        return hpName;
    }

    /**
     * ホームページ名称を設定します。
     * @param hpName ホームページ名称
     */
    public void setHpName(String hpName) {
        this.hpName = hpName;
    }

    /**
     * ホームページURLを取得します。
     * @return ホームページURL
     */
    public String getHpUrl() {
        return hpUrl;
    }

    /**
     * ホームページURLを設定します。
     * @param hpUrl ホームページURL
     */
    public void setHpUrl(String hpUrl) {
        this.hpUrl = hpUrl;
    }

    /**
     * FAX/Mailフラグを取得します。
     * @return FAX/Mailフラグ
     */
    public String getFmKbn() {
        return fmKbn;
    }

    /**
     * FAX/Mailフラグを設定します。
     * @param fmKbn FAX/Mailフラグ
     */
    public void setFmKbn(String fmKbn) {
        this.fmKbn = fmKbn;
    }

    /**
     * 店舗サイトへの最終ログイン時刻を取得します。
     * @return 店舗サイトへの最終ログイン時刻
     */
    public String getLastLoginDt() {
        return lastLoginDt;
    }

    /**
     * 店舗サイトへの最終ログイン時刻を設定します。
     * @param lastLoginDt 店舗サイトへの最終ログイン時刻
     */
    public void setLastLoginDt(String lastLoginDt) {
        this.lastLoginDt = lastLoginDt;
    }

    /**
     * 店舗最終更新日時を取得します。
     * @return 店舗最終更新日時
     */
    public String getShopUpdDt() {
        return shopUpdDt;
    }

    /**
     * 店舗最終更新日時を設定します。
     * @param shopUpdDt 店舗最終更新日時
     */
    public void setShopUpdDt(String shopUpdDt) {
        this.shopUpdDt = shopUpdDt;
    }

    /**
     * 承認状態を取得します。
     * @return 承認状態
     */
    public String getCertifyFlg() {
        return certifyFlg;
    }

    /**
     * 承認状態を設定します。
     * @param certifyFlg 承認状態
     */
    public void setCertifyFlg(String certifyFlg) {
        this.certifyFlg = certifyFlg;
    }

    /**
     * 店舗状態を取得します。
     * @return 店舗状態
     */
    public String getShopStatus() {
        return shopStatus;
    }

    /**
     * 店舗状態を設定します。
     * @param shopStatus 店舗状態
     */
    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
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
     * 店舗サイト権限を取得します。
     * @return 店舗サイト権限
     */
    public String getShopSiteRole() {
        return shopSiteRole;
    }

    /**
     * 店舗サイト権限を設定します。
     * @param shopSiteRole 店舗サイト権限
     */
    public void setShopSiteRole(String shopSiteRole) {
        this.shopSiteRole = shopSiteRole;
    }

    /**
     * 管理メモを取得します。
     * @return 管理メモ
     */
    public String getAdminNote() {
        return adminNote;
    }

    /**
     * 管理メモを設定します。
     * @param adminNote 管理メモ
     */
    public void setAdminNote(String adminNote) {
        this.adminNote = adminNote;
    }

    /**
     * 管理最終更新日時を取得します。
     * @return 管理最終更新日時
     */
    public String getAdminUpdDt() {
        return adminUpdDt;
    }

    /**
     * 管理最終更新日時を設定します。
     * @param adminUpdDt 管理最終更新日時
     */
    public void setAdminUpdDt(String adminUpdDt) {
        this.adminUpdDt = adminUpdDt;
    }

    /**
     * ピックアップ不動産利用状況を取得します。
     * @return ピックアップ不動産利用状況
     */
    public String getPickUpCnt() {
        return pickUpCnt;
    }

    /**
     * ピックアップ不動産利用状況を設定します。
     * @param pickUpCnt ピックアップ不動産利用状況
     */
    public void setPickUpCnt(String pickUpCnt) {
        this.pickUpCnt = pickUpCnt;
    }

    /**
     * 不動産ASP利用状況を取得します。
     * @return 不動産ASP利用状況
     */
    public String getAspCnt() {
        return aspCnt;
    }

    /**
     * 不動産ASP利用状況を設定します。
     * @param aspCnt 不動産ASP利用状況
     */
    public void setAspCnt(String aspCnt) {
        this.aspCnt = aspCnt;
    }

    /**
     * アドパーク送信可フラグを取得します。
     * @return アドパーク送信可フラグ
     */
    public String getAdparkSendFlg() {
        return adparkSendFlg;
    }

    /**
     * アドパーク送信可フラグを設定します。
     * @param adparkSendFlg アドパーク送信可フラグ
     */
    public void setAdparkSendFlg(String adparkSendFlg) {
        this.adparkSendFlg = adparkSendFlg;
    }

    /**
     * Webログ利用可フラグを取得します。
     * @return Webログ利用可フラグ
     */
    public String getWebLogFlg() {
        return webLogFlg;
    }

    /**
     * Webログ利用可フラグを設定します。
     * @param webLogFlg Webログ利用可フラグ
     */
    public void setWebLogFlg(String webLogFlg) {
        this.webLogFlg = webLogFlg;
    }

    /**
     * 店舗地図フラグを取得します。
     * @return 店舗地図フラグ
     */
    public String getShopMapPctFlg() {
        return shopMapPctFlg;
    }

    /**
     * 店舗地図フラグを設定します。
     * @param shopMapPctFlg 店舗地図フラグ
     */
    public void setShopMapPctFlg(String shopMapPctFlg) {
        this.shopMapPctFlg = shopMapPctFlg;
    }

    /**
     * 店舗画像1フラグを取得します。
     * @return 店舗画像1フラグ
     */
    public String getShopPhoto1Flg() {
        return shopPhoto1Flg;
    }

    /**
     * 店舗画像1フラグを設定します。
     * @param shopPhoto1Flg 店舗画像1フラグ
     */
    public void setShopPhoto1Flg(String shopPhoto1Flg) {
        this.shopPhoto1Flg = shopPhoto1Flg;
    }

    /**
     * 店舗画像2フラグを取得します。
     * @return 店舗画像2フラグ
     */
    public String getShopPhoto2Flg() {
        return shopPhoto2Flg;
    }

    /**
     * 店舗画像2フラグを設定します。
     * @param shopPhoto2Flg 店舗画像2フラグ
     */
    public void setShopPhoto2Flg(String shopPhoto2Flg) {
        this.shopPhoto2Flg = shopPhoto2Flg;
    }

    /**
     * 店舗名カナを取得します。
     * @return 店舗名カナ
     */
    public String getBumonKana() {
        return bumonKana;
    }

    /**
     * 店舗名カナを設定します。
     * @param bumonKana 店舗名カナ
     */
    public void setBumonKana(String bumonKana) {
        this.bumonKana = bumonKana;
    }

    /**
     * CHINTAIサイト有効物件数を取得します。
     * @return CHINTAIサイト有効物件数
     */
    public String getChintaiBukkenCount() {
        return chintaiBukkenCount;
    }

    /**
     * CHINTAIサイト有効物件数を設定します。
     * @param chintaiBukkenCount CHINTAIサイト有効物件数
     */
    public void setChintaiBukkenCount(String chintaiBukkenCount) {
        this.chintaiBukkenCount = chintaiBukkenCount;
    }

    /**
     * ABLEサイト有効物件数を取得します。
     * @return ABLEサイト有効物件数
     */
    public String getAbleBukkenCount() {
        return ableBukkenCount;
    }

    /**
     * ABLEサイト有効物件数を設定します。
     * @param ableBukkenCount ABLEサイト有効物件数
     */
    public void setAbleBukkenCount(String ableBukkenCount) {
        this.ableBukkenCount = ableBukkenCount;
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

}

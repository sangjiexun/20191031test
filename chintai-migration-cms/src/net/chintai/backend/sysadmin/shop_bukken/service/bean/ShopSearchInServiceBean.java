/*
 * $Id: ShopSearchInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

import java.util.HashMap;
import java.util.Map;

import net.chintai.backend.sysadmin.common.session.SessionSearchCondition;

/**
 * 店舗検索条件InServiceBean
 *
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSearchInServiceBean implements SessionSearchCondition {

    /** serialVersionUID */
    private static final long serialVersionUID = -400674161425240664L;

    /** 店舗コード */
    private String shopCd;

    /** 店舗メール */
    private String shopEmail;

    /** 代表者名 */
    private String licTrustName;

    /** 代表TEL/FAX */
    private String shopTelFax;

    /** 会社名/事務所名 */
    private String companyBumonName;

    /** AND/OR */
    private String andOrmode;

    /** 有効物件数が 0 の店舗だけを表示条件フラグ */
    private String noBukkenShop;

    /** ユーザ最終更新日（下限） */
    private String updateFrom;

    /** ユーザ最終更新日（下限:年） */
    private String updDtFromYear;

    /** ユーザ最終更新日（下限:月） */
    private String updDtFromMonth;

    /** ユーザ最終更新日（下限:日） */
    private String updDtFromDay;

    /** ユーザ最終更新日（下限:時） */
    private String updDtFromTime;

    /** ユーザ最終更新日（上限） */
    private String updateTo;

    /** ユーザ最終更新日（上限:年） */
    private String updDtToYear;

    /** ユーザ最終更新日（上限:月） */
    private String updDtToMonth;

    /** ユーザ最終更新日（上限:日） */
    private String updDtToDay;

    /** ユーザ最終更新日（上限:時） */
    private String updDtToTime;

    /** 承認 */
    private String certifyFlg;

    /** 状態 */
    private String shopStatus;

    /** CHINTAI掲載 */
    private String ctFlg;

    /** エイブル掲載 */
    private String ablFlg;

    /** データ元 */
    private String clientSystemType;

    /** ASP */
    private String aspFlg;

    /** 売買 */
    private String adparkFlg;

    /** エリア */
    private String area;

    /** 地域/沿線 */
    private String kbnAreaRosen;

    /** 都道府県 */
    private String pref;

    /** 市区町村 */
    private String city;

    /** 沿線 */
    private String ensenType;

    /** 沿線 */
    private String ensen;

    /** 駅 */
    private String eki;

    /** ソートキー */
    private String sortKey;

    /** 順序 */
    private String orderBy;

    /** 表示件数 */
    private String displayNum;

    /** 出力先 */
    private String outputMode;

	private String rendoCd;

	private Map<String, String> shopKeiyakus = new HashMap<>();

	/**
	 * @return shopKeiyakus
	 */
	public Map<String, String> getShopKeiyakus() {
		return this.shopKeiyakus;
	}

	/**
	 * @param shopKeiyakus the shopKeiyakus to set
	 */
	public void setShopKeiyakus(final Map<String, String> shopKeiyakus) {
		this.shopKeiyakus = shopKeiyakus;
	}

	/**
	 * @return rendoCd
	 */
	public String getRendoCd() {
		return this.rendoCd;
	}

	/**
	 * @param rendoCd the rendoCd to set
	 */
	public void setRendoCd(final String rendoCd) {
		this.rendoCd = rendoCd;
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
     * 店舗メールを取得します。
     * @return 店舗メール
     */
    public String getShopEmail() {
        return shopEmail;
    }

    /**
     * 店舗メールを設定します。
     * @param shopEmail 店舗メール
     */
    public void setShopEmail(String shopEmail) {
        this.shopEmail = shopEmail;
    }

    /**
     * 代表者名を取得します。
     * @return 代表者名
     */
    public String getLicTrustName() {
        return licTrustName;
    }

    /**
     * 代表者名を設定します。
     * @param licTrustName 代表者名
     */
    public void setLicTrustName(String licTrustName) {
        this.licTrustName = licTrustName;
    }

    /**
     * 代表TEL/FAXを取得します。
     * @return 代表TEL/FAX
     */
    public String getShopTelFax() {
        return shopTelFax;
    }

    /**
     * 代表TEL/FAXを設定します。
     * @param shopTelFax 代表TEL/FAX
     */
    public void setShopTelFax(String shopTelFax) {
        this.shopTelFax = shopTelFax;
    }

    /**
     * 会社名/事務所名を取得します。
     * @return 会社名/事務所名
     */
    public String getCompanyBumonName() {
        return companyBumonName;
    }

    /**
     * 会社名/事務所名を設定します。
     * @param companyBumonName 会社名/事務所名
     */
    public void setCompanyBumonName(String companyBumonName) {
        this.companyBumonName = companyBumonName;
    }

    /**
     * AND/ORを取得します。
     * @return AND/OR
     */
    public String getAndOrmode() {
        return andOrmode;
    }

    /**
     * AND/ORを設定します。
     * @param andOrmode AND/OR
     */
    public void setAndOrmode(String andOrmode) {
        this.andOrmode = andOrmode;
    }

    /**
     * 有効物件数が 0 の店舗だけを表示条件フラグを取得します。
     * @return 有効物件数が 0 の店舗だけを表示条件フラグ
     */
    public String getNoBukkenShop() {
        return noBukkenShop;
    }

    /**
     * 有効物件数が 0 の店舗だけを表示条件フラグを設定します。
     * @param noBukkenShop 有効物件数が 0 の店舗だけを表示条件フラグ
     */
    public void setNoBukkenShop(String noBukkenShop) {
        this.noBukkenShop = noBukkenShop;
    }

    /**
     * ユーザ最終更新日（下限）を取得します。
     * @return ユーザ最終更新日（下限）
     */
    public String getUpdateFrom() {
        return updateFrom;
    }

    /**
     * ユーザ最終更新日（下限）を設定します。
     * @param updateFrom ユーザ最終更新日（下限）
     */
    public void setUpdateFrom(String updateFrom) {
        this.updateFrom = updateFrom;
    }

    /**
     * ユーザ最終更新日（上限）を取得します。
     * @return ユーザ最終更新日（上限）
     */
    public String getUpdateTo() {
        return updateTo;
    }

    /**
     * ユーザ最終更新日（上限）を設定します。
     * @param updateTo ユーザ最終更新日（上限）
     */
    public void setUpdateTo(String updateTo) {
        this.updateTo = updateTo;
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
     * データ元を取得します。
     * @return データ元
     */
    public String getClientSystemType() {
        return clientSystemType;
    }

    /**
     * データ元を設定します。
     * @param clientSystemType データ元
     */
    public void setClientSystemType(String clientSystemType) {
        this.clientSystemType = clientSystemType;
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
     * 売買を取得します。
     * @return 売買
     */
    public String getAdparkFlg() {
        return adparkFlg;
    }

    /**
     * 売買を設定します。
     * @param adparkFlg 売買
     */
    public void setAdparkFlg(String adparkFlg) {
        this.adparkFlg = adparkFlg;
    }

    /**
     * エリアを取得します。
     * @return エリア
     */
    public String getArea() {
        return area;
    }

    /**
     * エリアを設定します。
     * @param area エリア
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 地域/沿線を取得します。
     * @return 地域/沿線
     */
    public String getKbnAreaRosen() {
        return kbnAreaRosen;
    }

    /**
     * 地域/沿線を設定します。
     * @param kbnAreaRosen 地域/沿線
     */
    public void setKbnAreaRosen(String kbnAreaRosen) {
        this.kbnAreaRosen = kbnAreaRosen;
    }

    /**
     * 都道府県を取得します。
     * @return 都道府県
     */
    public String getPref() {
        return pref;
    }

    /**
     * 都道府県を設定します。
     * @param pref 都道府県
     */
    public void setPref(String pref) {
        this.pref = pref;
    }

    /**
     * 市区町村を取得します。
     * @return 市区町村
     */
    public String getCity() {
        return city;
    }

    /**
     * 市区町村を設定します。
     * @param city 市区町村
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 沿線を取得します。
     * @return 沿線
     */
    public String getEnsenType() {
        return ensenType;
    }

    /**
     * 沿線を設定します。
     * @param ensenType 沿線
     */
    public void setEnsenType(String ensenType) {
        this.ensenType = ensenType;
    }

    /**
     * 沿線を取得します。
     * @return 沿線
     */
    public String getEnsen() {
        return ensen;
    }

    /**
     * 沿線を設定します。
     * @param ensen 沿線
     */
    public void setEnsen(String ensen) {
        this.ensen = ensen;
    }

    /**
     * 駅を取得します。
     * @return 駅
     */
    public String getEki() {
        return eki;
    }

    /**
     * 駅を設定します。
     * @param eki 駅
     */
    public void setEki(String eki) {
        this.eki = eki;
    }

    /**
     * ソートキーを取得します。
     * @return ソートキー
     */
    public String getSortKey() {
        return sortKey;
    }

    /**
     * ソートキーを設定します。
     * @param sortKey ソートキー
     */
    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    /**
     * 順序を取得します。
     * @return 順序
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 順序を設定します。
     * @param orderBy 順序
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * 表示件数を取得します。
     * @return 表示件数
     */
    public String getDisplayNum() {
        return displayNum;
    }

    /**
     * 表示件数を設定します。
     * @param displayNum 表示件数
     */
    public void setDisplayNum(String displayNum) {
        this.displayNum = displayNum;
    }

    /**
     * 出力先を取得します。
     * @return 出力先
     */
    public String getOutputMode() {
        return outputMode;
    }

    /**
     * 出力先を設定します。
     * @param outputMode 出力先
     */
    public void setOutputMode(String outputMode) {
        this.outputMode = outputMode;
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
     * ユーザ最終更新日（下限:日）を取得します。
     * @return ユーザ最終更新日（下限:日）
     */
    public String getUpdDtFromDay() {
        return updDtFromDay;
    }

    /**
     * ユーザ最終更新日（下限:日）を設定します。
     * @param updDtFromDay ユーザ最終更新日（下限:日）
     */
    public void setUpdDtFromDay(String updDtFromDay) {
        this.updDtFromDay = updDtFromDay;
    }

    /**
     * ユーザ最終更新日（下限:月）を取得します。
     * @return ユーザ最終更新日（下限:月）
     */
    public String getUpdDtFromMonth() {
        return updDtFromMonth;
    }

    /**
     * ユーザ最終更新日（下限:月）を設定します。
     * @param updDtFromMonth ユーザ最終更新日（下限:月）
     */
    public void setUpdDtFromMonth(String updDtFromMonth) {
        this.updDtFromMonth = updDtFromMonth;
    }

    /**
     * ユーザ最終更新日（下限:時）を取得します。
     * @return ユーザ最終更新日（下限:時）
     */
    public String getUpdDtFromTime() {
        return updDtFromTime;
    }

    /**
     * ユーザ最終更新日（下限:時）を設定します。
     * @param updDtFromTime ユーザ最終更新日（下限:時）
     */
    public void setUpdDtFromTime(String updDtFromTime) {
        this.updDtFromTime = updDtFromTime;
    }

    /**
     * ユーザ最終更新日（下限:年）を取得します。
     * @return ユーザ最終更新日（下限:年）
     */
    public String getUpdDtFromYear() {
        return updDtFromYear;
    }

    /**
     * ユーザ最終更新日（下限:年）を設定します。
     * @param updDtFromYear ユーザ最終更新日（下限:年）
     */
    public void setUpdDtFromYear(String updDtFromYear) {
        this.updDtFromYear = updDtFromYear;
    }

    /**
     * ユーザ最終更新日（上限:日）を取得します。
     * @return ユーザ最終更新日（上限:日）
     */
    public String getUpdDtToDay() {
        return updDtToDay;
    }

    /**
     * ユーザ最終更新日（上限:日）を設定します。
     * @param updDtToDay ユーザ最終更新日（上限:日）
     */
    public void setUpdDtToDay(String updDtToDay) {
        this.updDtToDay = updDtToDay;
    }

    /**
     * ユーザ最終更新日（上限:月）を取得します。
     * @return ユーザ最終更新日（上限:月）
     */
    public String getUpdDtToMonth() {
        return updDtToMonth;
    }

    /**
     * ユーザ最終更新日（上限:月）を設定します。
     * @param updDtToMonth ユーザ最終更新日（上限:月）
     */
    public void setUpdDtToMonth(String updDtToMonth) {
        this.updDtToMonth = updDtToMonth;
    }

    /**
     * ユーザ最終更新日（上限:時）を取得します。
     * @return ユーザ最終更新日（上限:時）
     */
    public String getUpdDtToTime() {
        return updDtToTime;
    }

    /**
     * ユーザ最終更新日（上限:時）を設定します。
     * @param updDtToTime ユーザ最終更新日（上限:時）
     */
    public void setUpdDtToTime(String updDtToTime) {
        this.updDtToTime = updDtToTime;
    }

    /**
     * ユーザ最終更新日（上限:年）を取得します。
     * @return ユーザ最終更新日（上限:年）
     */
    public String getUpdDtToYear() {
        return updDtToYear;
    }

    /**
     * ユーザ最終更新日（上限:年）を設定します。
     * @param updDtToYear ユーザ最終更新日（上限:年）
     */
    public void setUpdDtToYear(String updDtToYear) {
        this.updDtToYear = updDtToYear;
    }

}

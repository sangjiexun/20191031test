/*
 * $Id: MatchingDataDownloadOutServiceBean.java 4437 2010-01-26 05:27:27Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/28     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.service.bean;


/**
 * 照合結果ダウンロードOutServiceBean
 * @author e-ishii
 * @version $Revision: 4437 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MatchingDataDownloadOutServiceBean {


    /** グループ */
    private String groupName;

    /** エリアコード */
    private String areaCd;

    /** エリア名 */
    private String areaName;

    /** 店舗コード */
    private String shopCd;

    /** 店舗名 */
    private String bumon;

    /** 取引No */
    private String torihikiNo;

    /** 物件No */
    private String bkcd;

    /** 部屋番号 */
    private String roomCd;

    /** 部屋タイプ */
    private String roomType;

    /** 取引管理種別 */
    private String torihikiShubetsu;

    /** 取引管理種別名 */
    private String torihikiName;

    /** 家賃 */
    private String chinryo;

    /** 取引台帳作成日 */
    private String torihikiSakuseiDate;

    /** 手数入金額税込 */
    private String cmInsGaku;

    /** 手数入金日 */
    private String cmInsDt;

    /** 広告料入金回数 */
    private String adInsCnt;

    /** 広告料入金額税込 */
    private String adInsGaku;

    /** 広告料入金日 */
    private String adInsDt;

    /** 借主手数料（追加） */
    private String kashiCm;

    /** 貸主手数料（追加） */
    private String kariCm;

    /** 借主・貸主手数料の見積額 */
    private String cmMitsu;

    /** 借主・貸主手数料の見積AD額 */
    private String cmMitsuAd;

    /** 営業担当社員コード */
    private String tantouCd;

    /** 営業担当社員名 */
    private String tantouName;

    /** 貸主コード */
    private String kashiCd;

    /** データ種類 */
    private String dataType;

    /** 最新家賃 */
    private String lastChinryo;

    /** 発信日 */
    private String lastHassinDate;

    /** 不一致マーク */
    private String unMatchiFlg;

    /** 広告料合計 */
    private String koukokuSum;

    /** キャンペーン名称(略称) */
    private String campaignNameSimple;


    /**
     * グループを取得します。
     * @return グループ
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * グループを設定します。
     * @param groupName グループ
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
     * 店舗名を取得します。
     * @return 店舗名
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 店舗名を設定します。
     * @param bumon 店舗名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

    /**
     * 取引Noを取得します。
     * @return 取引No
     */
    public String getTorihikiNo() {
        return torihikiNo;
    }

    /**
     * 取引Noを設定します。
     * @param torihikiNo 取引No
     */
    public void setTorihikiNo(String torihikiNo) {
        this.torihikiNo = torihikiNo;
    }

    /**
     * 物件Noを取得します。
     * @return 物件No
     */
    public String getBkcd() {
        return bkcd;
    }

    /**
     * 物件Noを設定します。
     * @param bkcd 物件No
     */
    public void setBkcd(String bkcd) {
        this.bkcd = bkcd;
    }

    /**
     * 部屋番号を取得します。
     * @return 部屋番号
     */
    public String getRoomCd() {
        return roomCd;
    }

    /**
     * 部屋番号を設定します。
     * @param roomCd 部屋番号
     */
    public void setRoomCd(String roomCd) {
        this.roomCd = roomCd;
    }

    /**
     * 部屋タイプを取得します。
     * @return 部屋タイプ
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * 部屋タイプを設定します。
     * @param roomType 部屋タイプ
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    /**
     * 取引管理種別を取得します。
     * @return 取引管理種別
     */
    public String getTorihikiShubetsu() {
        return torihikiShubetsu;
    }

    /**
     * 取引管理種別を設定します。
     * @param torihikiShubetsu 取引管理種別
     */
    public void setTorihikiShubetsu(String torihikiShubetsu) {
        this.torihikiShubetsu = torihikiShubetsu;
    }

    /**
     * 取引管理種別名を取得します。
     * @return 取引管理種別名
     */
    public String getTorihikiName() {
        return torihikiName;
    }

    /**
     * 取引管理種別名を設定します。
     * @param torihikiName 取引管理種別名
     */
    public void setTorihikiName(String torihikiName) {
        this.torihikiName = torihikiName;
    }

    /**
     * 家賃を取得します。
     * @return 家賃
     */
    public String getChinryo() {
        return chinryo;
    }

    /**
     * 家賃を設定します。
     * @param chinryo 家賃
     */
    public void setChinryo(String chinryo) {
        this.chinryo = chinryo;
    }

    /**
     * 取引台帳作成日を取得します。
     * @return 取引台帳作成日
     */
    public String getTorihikiSakuseiDate() {
        return torihikiSakuseiDate;
    }

    /**
     * 取引台帳作成日を設定します。
     * @param torihikiSakuseiDate 取引台帳作成日
     */
    public void setTorihikiSakuseiDate(String torihikiSakuseiDate) {
        this.torihikiSakuseiDate = torihikiSakuseiDate;
    }

    /**
     * 手数入金額税込を取得します。
     * @return 手数入金額税込
     */
    public String getCmInsGaku() {
        return cmInsGaku;
    }

    /**
     * 手数入金額税込を設定します。
     * @param cmInsGaku 手数入金額税込
     */
    public void setCmInsGaku(String cmInsGaku) {
        this.cmInsGaku = cmInsGaku;
    }

    /**
     * 手数入金日を取得します。
     * @return 手数入金日
     */
    public String getCmInsDt() {
        return cmInsDt;
    }

    /**
     * 手数入金日を設定します。
     * @param cmInsDt 手数入金日
     */
    public void setCmInsDt(String cmInsDt) {
        this.cmInsDt = cmInsDt;
    }

    /**
     * 広告料入金回数を取得します。
     * @return 広告料入金回数
     */
    public String getAdInsCnt() {
        return adInsCnt;
    }

    /**
     * 広告料入金回数を設定します。
     * @param adInsCnt 広告料入金回数
     */
    public void setAdInsCnt(String adInsCnt) {
        this.adInsCnt = adInsCnt;
    }

    /**
     * 広告料入金額税込を取得します。
     * @return 広告料入金額税込
     */
    public String getAdInsGaku() {
        return adInsGaku;
    }

    /**
     * 広告料入金額税込を設定します。
     * @param adInsGaku 広告料入金額税込
     */
    public void setAdInsGaku(String adInsGaku) {
        this.adInsGaku = adInsGaku;
    }

    /**
     * 広告料入金日を取得します。
     * @return 広告料入金日
     */
    public String getAdInsDt() {
        return adInsDt;
    }

    /**
     * 広告料入金日を設定します。
     * @param adInsDt 広告料入金日
     */
    public void setAdInsDt(String adInsDt) {
        this.adInsDt = adInsDt;
    }

    /**
     * 借主手数料（追加）を取得します。
     * @return 借主手数料（追加）
     */
    public String getKashiCm() {
        return kashiCm;
    }

    /**
     * 借主手数料（追加）を設定します。
     * @param kashiCm 借主手数料（追加）
     */
    public void setKashiCm(String kashiCm) {
        this.kashiCm = kashiCm;
    }

    /**
     * 貸主手数料（追加）を取得します。
     * @return 貸主手数料（追加）
     */
    public String getKariCm() {
        return kariCm;
    }

    /**
     * 貸主手数料（追加）を設定します。
     * @param kariCm 貸主手数料（追加）
     */
    public void setKariCm(String kariCm) {
        this.kariCm = kariCm;
    }

    /**
     * 借主・貸主手数料の見積額を取得します。
     * @return 借主・貸主手数料の見積額
     */
    public String getCmMitsu() {
        return cmMitsu;
    }

    /**
     * 借主・貸主手数料の見積額を設定します。
     * @param cmMitsu 借主・貸主手数料の見積額
     */
    public void setCmMitsu(String cmMitsu) {
        this.cmMitsu = cmMitsu;
    }

    /**
     * 借主・貸主手数料の見積AD額を取得します。
     * @return 借主・貸主手数料の見積AD額
     */
    public String getCmMitsuAd() {
        return cmMitsuAd;
    }

    /**
     * 借主・貸主手数料の見積AD額を設定します。
     * @param cmMitsuAd 借主・貸主手数料の見積AD額
     */
    public void setCmMitsuAd(String cmMitsuAd) {
        this.cmMitsuAd = cmMitsuAd;
    }

    /**
     * 営業担当社員コードを取得します。
     * @return 営業担当社員コード
     */
    public String getTantouCd() {
        return tantouCd;
    }

    /**
     * 営業担当社員コードを設定します。
     * @param tantouCd 営業担当社員コード
     */
    public void setTantouCd(String tantouCd) {
        this.tantouCd = tantouCd;
    }

    /**
     * 営業担当社員名を取得します。
     * @return 営業担当社員名
     */
    public String getTantouName() {
        return tantouName;
    }

    /**
     * 営業担当社員名を設定します。
     * @param tantouName 営業担当社員名
     */
    public void setTantouName(String tantouName) {
        this.tantouName = tantouName;
    }

    /**
     * 貸主コードを取得します。
     * @return 貸主コード
     */
    public String getKashiCd() {
        return kashiCd;
    }

    /**
     * 貸主コードを設定します。
     * @param kashiCd 貸主コード
     */
    public void setKashiCd(String kashiCd) {
        this.kashiCd = kashiCd;
    }

    /**
     * データ種別を取得します。
     * @return データ種別
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * データ種別を設定します。
     * @param dataType データ種別
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * 最新家賃を取得します。
     * @return 最新家賃
     */
    public String getLastChinryo() {
        return lastChinryo;
    }

    /**
     * 最新家賃を設定します。
     * @param lastChinryo 最新家賃
     */
    public void setLastChinryo(String lastChinryo) {
        this.lastChinryo = lastChinryo;
    }

    /**
     * 発信日を取得します。
     * @return 発信日
     */
    public String getLastHassinDate() {
        return lastHassinDate;
    }

    /**
     * 発信日を設定します。
     * @param lastHassinDate 発信日
     */
    public void setLastHassinDate(String lastHassinDate) {
        this.lastHassinDate = lastHassinDate;
    }

    /**
     * 不一致マークを取得します。
     * @return 不一致マーク
     */
    public String getUnMatchiFlg() {
        return unMatchiFlg;
    }

    /**
     * 不一致マークを設定します。
     * @param unMatchiFlg 不一致マーク
     */
    public void setUnMatchiFlg(String unMatchiFlg) {
        this.unMatchiFlg = unMatchiFlg;
    }

    /**
     * 広告料合計を取得します。
     * @return 広告料合計
     */
    public String getKoukokuSum() {
        return koukokuSum;
    }

    /**
     * 広告料合計を設定します。
     * @param koukokuSum 広告料合計
     */
    public void setKoukokuSum(String koukokuSum) {
        this.koukokuSum = koukokuSum;
    }

    /**
     * キャンペーン名称(略称)を取得します。
     * @return キャンペーン名称(略称)
     */
    public String getCampaignNameSimple() {
        return campaignNameSimple;
    }

    /**
     * キャンペーン名称(略称)を設定します。
     * @param campaignNameSimple キャンペーン名称(略称)
     */
    public void setCampaignNameSimple(String campaignNameSimple) {
        this.campaignNameSimple = campaignNameSimple;
    }
}


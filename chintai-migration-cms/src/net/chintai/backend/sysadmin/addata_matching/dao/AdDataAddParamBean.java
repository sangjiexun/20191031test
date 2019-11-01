/*
 * $Id: AdDataAddParamBean.java 4380 2009-09-08 02:32:57Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/24     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.dao;

import java.sql.Timestamp;


/**
 * ADデータ登録ParamBean
 * @author e-ishii
 * @version $Revision: 4380 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AdDataAddParamBean {

    /** 対象年月 */
    private String taisyoYm;

    /** 対象年月(検索用：SQLの速度を上げるため) */
    private String taisyoYmforMatching;

    /** グループ */
    private String groupName;

    /** エリアコード */
    private String areaCd;

    /** エリア名 */
    private String areaName;

    /** 店舗コード */
    private String shopCd;

    /** 店舗コード(検索用：SQLの速度を上げるため) */
    private String shopCDforMatching;

    /** 店舗名 */
    private String bumon;

    /** 取引No */
    private String torihikiNo;

    /** 物件No */
    private String bkCd;

    /** 物件No (検索用：SQLの速度を上げるため)*/
    private String bkCdforMatching;

    /** 部屋番号 */
    private String  roomCd;

    /** 部屋タイプ */
    private String roomtType;

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

    /** 手数料入金日 */
    private String cmInsDt;

    /** 広告料入金回数 */
    private String adInsCnt;

    /** 広告料入金額税込 */
    private String adInsGaku;

    /** 広告料入金日 */
    private String adInsDt;

    /** 借主手数料（追加）*/
    private String kashiCm;

    /** 貸主手数料（追加）*/
    private String kariCm;

    /** 借主･貸主手数料の見積額 */
    private String cmMitsu;

    /** 借主･貸主手数料の見積AD額 */
    private String cmMitsuAd;

    /** 営業担当社員コード */
    private String tantouCd;

    /** 営業担当社員名 */
    private String tantouName;

    /** 貸主コード*/
    private String kashiCd;

    /** データ種別 */
    private String dataType;

    /** 更新ユーザID */
    private String operUserId;

    /** 更新プログラム名 */
    private String pgName;

    /** 登録日 */
    private Timestamp insDt;

    /** 更新日 */
    private Timestamp updDt;


    /**
     * 対象年月を取得します。
     * @return 対象年月
     */
    public String getTaisyoYm() {
        return taisyoYm;
    }

    /**
     * 対象年月を設定します。
     * @param taisyoYm 対象年月
     */
    public void setTaisyoYm(String taisyoYm) {
        this.taisyoYm = taisyoYm;
    }

    /**
     * 対象年月(検索用：SQLの速度を上げるため)を取得します。
     * @return 対象年月(検索用：SQLの速度を上げるため)
     */
    public String getTaisyoYmforMatching() {
        return taisyoYmforMatching;
    }

    /**
     * 対象年月(検索用：SQLの速度を上げるため)を設定します。
     * @param taisyoYmforMatching 対象年月(検索用：SQLの速度を上げるため)
     */
    public void setTaisyoYmforMatching(String taisyoYmforMatching) {
        this.taisyoYmforMatching = taisyoYmforMatching;
    }

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
     * 店舗コード(検索用：SQLの速度を上げるため)を取得します。
     * @return shopCDforMatching
     */
    public String getShopCDforMatching() {
        return shopCDforMatching;
    }

    /**
     * 店舗コード(検索用：SQLの速度を上げるため)を設定します。
     * @param shopCDforMatching 店舗コード(検索用：SQLの速度を上げるため)
     */
    public void setShopCDforMatching(String shopCDforMatching) {
        this.shopCDforMatching = shopCDforMatching;
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
    public String getBkCd() {
        return bkCd;
    }

    /**
     * 物件Noを設定します。
     * @param bkCd 物件No
     */
    public void setBkCd(String bkCd) {
        this.bkCd = bkCd;
    }

    /**
     * 物件No (検索用：SQLの速度を上げるため)を取得します。
     * @return bkCdforMatching 物件No (検索用：SQLの速度を上げるため)
     */
    public String getBkCdforMatching() {
        return bkCdforMatching;
    }

    /**
     * 物件No (検索用：SQLの速度を上げるため)を設定します。
     * @param bkCdforMatching bkCdforMatching
     */
    public void setBkCdforMatching(String bkCdforMatching) {
        this.bkCdforMatching = bkCdforMatching;
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
    public String getRoomtType() {
        return roomtType;
    }

    /**
     * 部屋タイプを設定します。
     * @param roomtType 部屋タイプ
     */
    public void setRoomtType(String roomtType) {
        this.roomtType = roomtType;
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
     * 手数料入金日を取得します。
     * @return 手数料入金日
     */
    public String getCmInsDt() {
        return cmInsDt;
    }

    /**
     * 手数料入金日を設定します。
     * @param cmInsDt 手数料入金日
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
     * 借主･貸主手数料の見積額を取得します。
     * @return 借主･貸主手数料の見積額
     */
    public String getCmMitsu() {
        return cmMitsu;
    }

    /**
     * 借主･貸主手数料の見積額を設定します。
     * @param cmMitsu 借主･貸主手数料の見積額
     */
    public void setCmMitsu(String cmMitsu) {
        this.cmMitsu = cmMitsu;
    }

    /**
     * 借主･貸主手数料の見積AD額を取得します。
     * @return 借主･貸主手数料の見積AD額
     */
    public String getCmMitsuAd() {
        return cmMitsuAd;
    }

    /**
     * 借主･貸主手数料の見積AD額を設定します。
     * @param cmMitsuAd 借主･貸主手数料の見積AD額
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
     * @param kashiName 貸主コード
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
     * 更新ユーザIDを取得します。
     * @return 更新ユーザID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 更新ユーザIDを設定します。
     * @param operUserId 更新ユーザID
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
    }

    /**
     * 更新プログラム名を取得します。
     * @return 更新プログラム名
     */
    public String getPgName() {
        return pgName;
    }

    /**
     * 更新プログラム名を設定します。
     * @param pgName 更新プログラム名
     */
    public void setPgName(String pgName) {
        this.pgName = pgName;
    }

    /**
     * 登録日を取得します。
     * @return 登録日
     */
    public Timestamp getInsDt() {
        return insDt;
    }

    /**
     * 登録日を設定します。
     * @param insDt 登録日
     */
    public void setInsDt(Timestamp insDt) {
        this.insDt = insDt;
    }

    /**
     * 更新日を取得します。
     * @return 更新日
     */
    public Timestamp getUpdDt() {
        return updDt;
    }

    /**
     * 更新日を設定します。
     * @param updDt 更新日
     */
    public void setUpdDt(Timestamp updDt) {
        this.updDt = updDt;
    }


}

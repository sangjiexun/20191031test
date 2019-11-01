/*
 * Bukken.java
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/07/19  BGT)児島   新規作成
 * 2008/05/27  BGT)李昊燮 「削除状態」判断用項目追加
 *                        (WEB審査物件ステータス,エイブル期間切れフラグ,CHINTAI期間切れフラグ)
 * 2009/08/02  BGT)李昊燮 物件詳細の所要時間と 各金額の単位表示方法修正対応
 */
package net.chintai.backend.sysadmin.shop_bukken.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.chintai.backend.sysadmin.common.properties.ApplicationResources;

/**
 * 物件データを表すBean
 *
 * @author KOJIMA Takanori
 * @version $Revision: 4535 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class Bukken {

    /** 受付番号 */
    private String uketukeCd;

    /** 店舗コード */
    private String shopCd;

    /** 物件コード */
    private String bkCd;

    /** 部屋連番 */
    private String roomNo;

    /** 物件名称 */
    private String bkName;

    /** 物件名称(カタカナ) */
    private String bkKana;

    /** 会社名 */
    private String company;

    /** 事務署名 */
    private String bumon;

    /** 店舗メールアドレス */
    private String email1;

    /** 店舗メールアドレス */
    private String email2;

    /** 店舗メールアドレス */
    private String email3;

    /** 店舗メールアドレス */
    private String email4;

    /** 店舗メールアドレス */
    private String email5;

    /** Ｅ－ＭＡＩＬアドレス用途区分1 */
    private String emailUseKbn1;

    /** Ｅ－ＭＡＩＬアドレス用途区分2 */
    private String emailUseKbn2;

    /** Ｅ－ＭＡＩＬアドレス用途区分3 */
    private String emailUseKbn3;

    /** Ｅ－ＭＡＩＬアドレス用途区分4 */
    private String emailUseKbn4;

    /** Ｅ－ＭＡＩＬアドレス用途区分5 */
    private String emailUseKbn5;

    /** 入稿状態 */
    private String insKbn;

    /** 管理最終更新日時（物件） */
    private String bukkenAdminUpdDt;

    /** 管理最終更新日時（店舗） */
    private String shopAdminUpdDt;

    /** 入稿登録日時 */
    private String insDt;

    /** 物件初回登録日時(CHINTAI) */
    private String ctStartDt;

    /** 物件初回登録日時(エイブル) */
    private String ablStartDt;

    /** 地図表示フラグ */
    private String mappingFlg;

    /** 座標情報(CHINTAI) */
    private String ctLocationFlg;

    /** 座標情報(エイブル) */
    private String ablLocationFlg;

    /** 座標情報取得日時 */
    private String locationUpd;

    /** 沿線名 */
    private String ensenName;

    /** 駅名 */
    private String ekiName;

    /** 所在地 */
    private String shozaichi;

    /** 所要時間(徒歩) */
    private String ekiToho;

    /** 所要時間（バス） */
    private String bus;

    /** 所要時間（バス停） */
    private String busTei;

    /** 所要時間(停歩) */
    private String busTeiho;

    /** 所要時間(車) */
    private String car;

    /** 所要距離(車利用距離) */
    private String carKyori;

    /** 家賃 */
    private String chinryo;

    /** 管理費・共益費 */
    private String kanriKin;

    /** 礼金 */
    private String reiKin;

    /** 敷金 */
    private String shikiKin;

    /** 保証金 */
    private String hoshoKin;

    /** 解約金 */
    private String kaiyakuKin;

    /** 償却金 */
    private String shoukyakuKin;

    /** 管理費・共益費単位 */
    private String kanriTan;

    /** 礼金単位 */
    private String reiTan;

    /** 敷金単位 */
    private String shikiTan;

    /** 保証金単位 */
    private String hoshoTan;

    /** 解約金単位 */
    private String kaiyakuTan;

    /** 償却金単位 */
    private String shoukyakuTan;

    /** 都道府県キー文字列 */
    private String prefKey;

    /** 地域コ－ド */
    private String areaCd;

    /** 間取 */
    private String madori;

    /** 面積 */
    private String senMenseki;

    /** 建物種別 */
    private String shubetsu;

    /** 建物種別コード */
    private String shubetsuCd;

    /** 構造 */
    private String kouzou;

    /** 築年 */
    private String chikunen;

    /** お客様設定パスワード */
    private String password;

    /** 承認状態 */
    private String certifyFlg;

    /** 店舗状態 */
    private String shopStatus;

    /** 備考 */
    private String adminNote;

    /** 管理最終更新日時 */
    private String skUpdDt;

    /** フロント反映状態 */
    private String frontFlg;

    /** フロント反映目安日時 */
    private String frontRefDt;

    /** 物件履歴連番（最新登録） */
    private String pkBukkenRirekiLast;

    /** 部屋止め区分 */
    private String heyadomeKbn;

// 2011.08 エイブル基幹に伴うCHINTAI改修 start
    /** CHINTAI NET掲載フラグ */
    private String ctFlg;

    /** エイブル掲載フラグ */
    private String ablFlg;
 // 2011.08 エイブル基幹に伴うCHINTAI改修 end

    /** ＣＨＩＮＴＡＩ掲載停止日時 */
    private String ctStopDt;

    /** エイブル掲載停止日時 */
    private String ablStopDt;

    /** 受配信ステータス */
    private String recSendStatus;

    /** レコード更新日時 */
    private String updDt;

    private String funcId;
    private String ctEndDtFlg;
    private String ablEndDtFlg;
    private String bkAdr1;
    private String bkAdr2;
    private String bkAdr3;
    private String keiyakuKbn;
    private String ckbShopcd;
    private String akbShopcd;

    private String roomKey;
    private String bukkenKanriLastUpdate;

    private String changeSourceKbn;

    private String ensencd;
    private String otherTransName;
    private String otherTransPlatform;

    /**
     * 物件コードを取得します。
     * @return 物件コード
     */
    public String getBkCd() {
        return bkCd;
    }

    /**
     * 物件名称(カタカナ)を取得します。
     * @return 物件名称(カタカナ)
     */
    public String getBkKana() {
        return bkKana;
    }

    /**
     * 物件名称(カタカナ)を設定します。
     * @param bkKana 物件名称(カタカナ)
     */
    public void setBkKana(String bkKana) {
        this.bkKana = bkKana;
    }

    /**
     * 物件名称を取得します。
     * @return 物件名称
     */
    public String getBkName() {
        return bkName;
    }

    /**
     * 物件名称を設定します。
     * @param bkName 物件名称
     */
    public void setBkName(String bkName) {
        this.bkName = bkName;
    }

    /**
     * 事務署名を取得します。
     * @return 事務署名
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 事務署名を設定します。
     * @param bumon 事務署名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
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
     * 入稿状態を取得します。
     * @return 入稿状態
     */
    public String getInsKbn() {
        return insKbn;
    }

    /**
     * 入稿状態を設定します。
     * @param insKbn 入稿状態
     */
    public void setInsKbn(String insKbn) {
        this.insKbn = insKbn;
    }

    /**
     * 物件コードを設定します。
     * @param bkCd 物件コード
     */
    public void setBkCd(String bkcd) {
        bkCd = bkcd;
    }

    /**
     * 部屋連番を取得します。
     * @return 部屋連番
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * 部屋連番を設定します。
     * @param roomNo 部屋連番
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
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
     * 受付番号を取得します。
     * @return 受付番号
     */
    public String getUketukeCd() {
        return uketukeCd;
    }

    /**
     * 受付番号を設定します。
     * @param uketukeCd 受付番号
     */
    public void setUketukeCd(String uketukeCd) {
        this.uketukeCd = uketukeCd;
    }

    /**
     * 座標情報(エイブル)を取得します。
     * @return 座標情報(エイブル)
     */
    public String getAblLocationFlg() {
        return ablLocationFlg;
    }

    /**
     * 座標情報(エイブル)を設定します。
     * @param ablLocationFlg 座標情報(エイブル)
     */
    public void setAblLocationFlg(String ablLocationFlg) {
        this.ablLocationFlg = ablLocationFlg;
    }

    /**
     * 物件初回登録日時(エイブル)を取得します。
     * @return 物件初回登録日時(エイブル)
     */
    public String getAblStartDt() {
        return ablStartDt;
    }

    /**
     * 物件初回登録日時(エイブル)を設定します。
     * @param ablStartDt 物件初回登録日時(エイブル)
     */
    public void setAblStartDt(String ablStartDt) {
        this.ablStartDt = ablStartDt;
    }

    /**
     * 備考を取得します。
     * @return 備考
     */
    public String getAdminNote() {
        return adminNote;
    }

    /**
     * 備考を設定します。
     * @param adminNote 備考
     */
    public void setAdminNote(String adminNote) {
        this.adminNote = adminNote;
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
     * 築年を取得します。
     * @return 築年
     */
    public String getChikunen() {
        return chikunen;
    }

    /**
     * 築年を設定します。
     * @param chikunen 築年
     */
    public void setChikunen(String chikunen) {
        if (chikunen != null) {
            this.chikunen = chikunen.substring(2, 4) + "/" + chikunen.substring(4, 6);
        }
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
     * 座標情報(CHINTAI)を取得します。
     * @return 座標情報(CHINTAI)
     */
    public String getCtLocationFlg() {
        return ctLocationFlg;
    }

    /**
     * 座標情報(CHINTAI)を設定します。
     * @param ctLocationFlg 座標情報(CHINTAI)
     */
    public void setCtLocationFlg(String ctLocationFlg) {
        this.ctLocationFlg = ctLocationFlg;
    }

    /**
     * 物件初回登録日時(CHINTAI)を取得します。
     * @return 物件初回登録日時(CHINTAI)
     */
    public String getCtStartDt() {
        return ctStartDt;
    }

    /**
     * 物件初回登録日時(CHINTAI)を設定します。
     * @param ctStartDt 物件初回登録日時(CHINTAI)
     */
    public void setCtStartDt(String ctStartDt) {
        this.ctStartDt = ctStartDt;
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
     * 管理最終更新日時（物件）を取得します。
     * @return 管理最終更新日時（物件）
     */
    public String getBukkenAdminUpdDt() {
        return bukkenAdminUpdDt;
    }

    /**
     * 管理最終更新日時（物件）を設定します。
     * @param bukkenAdminUpdDt 管理最終更新日時（物件）
     */
    public void setBukkenAdminUpdDt(String bukkenAdminUpdDt) {
        this.bukkenAdminUpdDt = bukkenAdminUpdDt;
    }

    /**
     * 管理最終更新日時（店舗）を取得します。
     * @return 管理最終更新日時（店舗）
     */
    public String getShopAdminUpdDt() {
        return shopAdminUpdDt;
    }

    /**
     * 管理最終更新日時（店舗）を設定します。
     * @param shopAdminUpdDt 管理最終更新日時（店舗）
     */
    public void setShopAdminUpdDt(String shopAdminUpdDt) {
        this.shopAdminUpdDt = shopAdminUpdDt;
    }

    /**
     * 入稿登録日時を取得します。
     * @return 入稿登録日時
     */
    public String getInsDt() {
        return insDt;
    }

    /**
     * 入稿登録日時を設定します。
     * @param insDt 入稿登録日時
     */
    public void setInsDt(String insDt) {
        setFrontRefDt(insDt);
        this.insDt = insDt;
    }

    /**
     * 構造を取得します。
     * @return 構造
     */
    public String getKouzou() {
        return kouzou;
    }

    /**
     * 構造を設定します。
     * @param kouzou 構造
     */
    public void setKouzou(String kouzou) {
        this.kouzou = kouzou;
    }

    /**
     * 座標情報取得日時を取得します。
     * @return 座標情報取得日時
     */
    public String getLocationUpd() {
        return locationUpd;
    }

    /**
     * 座標情報取得日時を設定します。
     * @param locationUpd 座標情報取得日時
     */
    public void setLocationUpd(String locationUpd) {
        this.locationUpd = locationUpd;
    }

    /**
     * 間取を取得します。
     * @return 間取
     */
    public String getMadori() {
        return madori;
    }

    /**
     * 間取を設定します。
     * @param madori 間取
     */
    public void setMadori(String madori) {
        this.madori = madori;
    }

    /**
     * 地図表示フラグを取得します。
     * @return 地図表示フラグ
     */
    public String getMappingFlg() {
        return mappingFlg;
    }

    /**
     * 地図表示フラグを設定します。
     * @param mappingFlg 地図表示フラグ
     */
    public void setMappingFlg(String mappingFlg) {
        this.mappingFlg = mappingFlg;
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
     * 面積を取得します。
     * @return 面積
     */
    public String getSenMenseki() {
        return senMenseki;
    }

    /**
     * 面積を設定します。
     * @param senMenseki 面積
     */
    public void setSenMenseki(String senMenseki) {
        this.senMenseki = senMenseki;
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
     * 所在地を取得します。
     * @return 所在地
     */
    public String getShozaichi() {
        return shozaichi;
    }

    /**
     * 所在地を設定します。
     * @param shozaichi 所在地
     */
    public void setShozaichi(String shozaichi) {
        this.shozaichi = shozaichi;
    }

    /**
     * 建物種別を取得します。
     * @return 建物種別
     */
    public String getShubetsu() {
        return shubetsu;
    }

    /**
     * 建物種別を設定します。
     * @param shubetsu 建物種別
     */
    public void setShubetsu(String shubetsu) {
        this.shubetsu = shubetsu;
    }

    /**
     * 建物種別コードを取得します。
     * @return 建物種別コード
     */
    public String getShubetsuCd() {
        return shubetsuCd;
    }

    /**
     * 建物種別コードを設定します。
     * @param shubetsuCd 建物種別コード
     */
    public void setShubetsuCd(String shubetsuCd) {
        this.shubetsuCd = shubetsuCd;
    }

    /**
     * 管理最終更新日時を取得します。
     * @return 管理最終更新日時
     */
    public String getSkUpdDt() {
        return skUpdDt;
    }

    /**
     * 管理最終更新日時を設定します。
     * @param skUpdDt 管理最終更新日時
     */
    public void setSkUpdDt(String skUpdDt) {
        this.skUpdDt = skUpdDt;
    }

    /**
     * フロント反映状態を取得します。
     * @return フロント反映状態
     */
    public String getFrontFlg() {
        return frontFlg;
    }

    /**
     * フロント反映状態を設定します。
     * @param frontFlg フロント反映状態
     */
    public void setFrontFlg(String frontFlg) {
        this.frontFlg = frontFlg;
    }

    /**
     * フロント反映目安日時を取得します。
     * @return フロント反映目安日時
     */
    public String getFrontRefDt() {
        return frontRefDt;
    }

    /**
     * フロント反映目安日時を設定します。
     * @param frontRefDt フロント反映目安日時
     */
    public void setFrontRefDt(String insDt) {
        this.frontRefDt = frontTime(insDt, 2);
    }

    /**
     * 物件履歴連番（最新登録）を取得します。
     * @return 物件履歴連番（最新登録）
     */
    public String getPkBukkenRirekiLast() {
        return pkBukkenRirekiLast;
    }

    /**
     * 物件履歴連番（最新登録）を設定します。
     * @param pkBukkenRirekiLast 物件履歴連番（最新登録）
     */
    public void setPkBukkenRirekiLast(String pkBukkenRirekiLast) {
        this.pkBukkenRirekiLast = pkBukkenRirekiLast;
    }

    /**
     * 反映目安日時
     * @param insDt レコード挿入日時
     * @param plusTime 加算する時間
     * @return 反映目安日時(挿入日時＋加算時間)
     */
    public String frontTime(String insDt, int plusTime) {
    	if(insDt != null){
	        Calendar c = Calendar.getInstance();

	        int year = new Integer(insDt.substring(0, 4));
	        int month = new Integer(insDt.substring(5, 7));
	        int date = new Integer(insDt.substring(8, 10));
	        int hourOfDay = new Integer(insDt.substring(11, 13));
	        int minute = new Integer(insDt.substring(14, 16));
	        int second = new Integer(insDt.substring(17, 19));
	        c.set(year, month - 1, date, hourOfDay + plusTime, minute, second);

	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	        String frontDt = sdf.format(c.getTime());
	        return frontDt;
    	}else{
    		return "";
    	}
    }

    /**
     * 管理費・共益費を取得します。
     * @return 管理費・共益費
     */
    public String getKanriKin() {
        return kanriKin;
    }

    /**
     * 管理費・共益費を設定します。
     * @param kanriKin 管理費・共益費
     */
    public void setKanriKin(String kanriKin) {
        this.kanriKin = kanriKin;
    }

    /**
     * 礼金を取得します。
     * @return 礼金
     */
    public String getReiKin() {
        return reiKin;
    }

    /**
     * 礼金を設定します。
     * @param reiKin 礼金
     */
    public void setReiKin(String reiKin) {
        this.reiKin = reiKin;
    }

    /**
     * 敷金を取得します。
     * @return 敷金
     */
    public String getShikiKin() {
        return shikiKin;
    }

    /**
     * 敷金を設定します。
     * @param shikiKin 敷金
     */
    public void setShikiKin(String shikiKin) {
        this.shikiKin = shikiKin;
    }

    /**
     * 保証金を取得します。
     * @return 保証金
     */
    public String getHoshoKin() {
        return hoshoKin;
    }

    /**
     * 保証金を設定します。
     * @param hoshoKin 保証金
     */
    public void setHoshoKin(String hoshoKin) {
        this.hoshoKin = hoshoKin;
    }

    /**
     * 解約金を取得します。
     * @return 解約金
     */
    public String getKaiyakuKin() {
        return kaiyakuKin;
    }

    /**
     * 解約金を設定します。
     * @param kaiyakuKin 解約金
     */
    public void setKaiyakuKin(String kaiyakuKin) {
        this.kaiyakuKin = kaiyakuKin;
    }

    /**
     * 償却金を取得します。
     * @return 償却金
     */
    public String getShoukyakuKin() {
        return shoukyakuKin;
    }

    /**
     * 償却金を設定します。
     * @param shoukyakuKin 償却金
     */
    public void setShoukyakuKin(String shoukyakuKin) {
        this.shoukyakuKin = shoukyakuKin;
    }

    /**
     * 管理費・共益費単位を取得します。
     * @return 管理費・共益費単位
     */
    public String getKanriTan() {
        return kanriTan;
    }

    /**
     * 管理費・共益費単位を設定します。
     * @param kanriTan 管理費・共益費単位
     */
    public void setKanriTan(String kanriTan) {
        this.kanriTan = kanriTan;
    }

    /**
     * 礼金単位を取得します。
     * @return 礼金単位
     */
    public String getReiTan() {
        return reiTan;
    }

    /**
     * 礼金単位を設定します。
     * @param reiTan 礼金単位
     */
    public void setReiTan(String reiTan) {
        this.reiTan = reiTan;
    }

    /**
     * 敷金単位を取得します。
     * @return 敷金単位
     */
    public String getShikiTan() {
        return shikiTan;
    }

    /**
     * 敷金単位を設定します。
     * @param shikiTan 敷金単位
     */
    public void setShikiTan(String shikiTan) {
        this.shikiTan = shikiTan;
    }

    /**
     * 保証金単位を取得します。
     * @return 保証金単位
     */
    public String getHoshoTan() {
        return hoshoTan;
    }

    /**
     * 保証金単位を設定します。
     * @param hoshoTan 保証金単位
     */
    public void setHoshoTan(String hoshoTan) {
        this.hoshoTan = hoshoTan;
    }

    /**
     * 解約金単位を取得します。
     * @return 解約金単位
     */
    public String getKaiyakuTan() {
        return kaiyakuTan;
    }

    /**
     * 解約金単位を設定します。
     * @param kaiyakuTan 解約金単位
     */
    public void setKaiyakuTan(String kaiyakuTan) {
        this.kaiyakuTan = kaiyakuTan;
    }


    /**
     * 償却金単位を取得します。
     * @return 償却金単位
     */
    public String getShoukyakuTan() {
        return shoukyakuTan;
    }

    /**
     * 償却金単位を設定します。
     * @param shoukyakuTan 償却金単位
     */
    public void setShoukyakuTan(String shoukyakuTan) {
        this.shoukyakuTan = shoukyakuTan;
    }

    /**
     * 都道府県キー文字列を取得します。
     * @return 都道府県キー文字列
     */
    public String getPrefKey() {
        return prefKey;
    }

    /**
     * 都道府県キー文字列を設定します。
     * @param prefKey 都道府県キー文字列
     */
    public void setPrefKey(String prefKey) {
        this.prefKey = prefKey;
    }

    /**
     * 地域コ－ドを取得します。
     * @return 地域コ－ド
     */
    public String getAreaCd() {
        return areaCd;
    }

    /**
     * 地域コ－ドを設定します。
     * @param areaCd 地域コ－ド
     */
    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    /**
     * 部屋止め区分を取得します。
     * @return 部屋止め区分
     */
    public String getHeyadomeKbn() {
        return heyadomeKbn;
    }

    /**
     * 部屋止め区分を設定します。
     * @param heyadomeKbn 部屋止め区分
     */
    public void setHeyadomeKbn(String heyadomeKbn) {
        this.heyadomeKbn = heyadomeKbn;
    }

    /**
     * CHINTAI NET掲載フラグを取得します。
     * @return CHINTAI NET掲載フラグ
     */
    public String getCtFlg() {
        return ctFlg;
    }

    /**
     * CHINTAI NET掲載フラグを設定します。
     * @param ctFlg CHINTAI NET掲載フラグ
     */
    public void setCtFlg(String ctFlg) {
        this.ctFlg = ctFlg;
    }

    /**
     * エイブル掲載フラグを取得します。
     * @return エイブル掲載フラグ
     */
    public String getAblFlg() {
        return ablFlg;
    }

    /**
     * エイブル掲載フラグを設定します。
     * @param ablFlg エイブル掲載フラグ
     */
    public void setAblFlg(String ablFlg) {
        this.ablFlg = ablFlg;
    }

	/**
	 * @return ctStopDt
	 */
	public String getCtStopDt() {
		return ctStopDt;
	}

	/**
	 * @param ctStopDt セットする ctStopDt
	 */
	public void setCtStopDt(String ctStopDt) {
		this.ctStopDt = ctStopDt;
	}

	/**
	 * @return ablStopDt
	 */
	public String getAblStopDt() {
		return ablStopDt;
	}

	/**
	 * @param ablStopDt セットする ablStopDt
	 */
	public void setAblStopDt(String ablStopDt) {
		this.ablStopDt = ablStopDt;
	}

	/**
	 * @return recSendStatus
	 */
	public String getRecSendStatus() {
		return recSendStatus;
	}

	/**
	 * @param recSendStatus セットする recSendStatus
	 */
	public void setRecSendStatus(String recSendStatus) {
		this.recSendStatus = recSendStatus;
	}

	/**
	 * @return updDt
	 */
	public String getUpdDt() {
		return updDt;
	}

	/**
	 * @param updDt セットする updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * @return ekiToho
	 */
	public String getEkiToho() {
		return ekiToho;
	}

	/**
	 * @param ekiToho セットする ekiToho
	 */
	public void setEkiToho(String ekiToho) {
		this.ekiToho = ekiToho;
	}

	/**
	 * @return bus
	 */
	public String getBus() {
		return bus;
	}

	/**
	 * @param bus セットする bus
	 */
	public void setBus(String bus) {
		this.bus = bus;
	}

	/**
	 * @return busTei
	 */
	public String getBusTei() {
		return busTei;
	}

	/**
	 * @param busTei セットする busTei
	 */
	public void setBusTei(String busTei) {
		this.busTei = busTei;
	}

	/**
	 * @return busTeiho
	 */
	public String getBusTeiho() {
		return busTeiho;
	}

	/**
	 * @param busTeiho セットする busTeiho
	 */
	public void setBusTeiho(String busTeiho) {
		this.busTeiho = busTeiho;
	}

	/**
	 * @return car
	 */
	public String getCar() {
		return car;
	}

	/**
	 * @param car セットする car
	 */
	public void setCar(String car) {
		this.car = car;
	}

	/**
	 * @return carKyori
	 */
	public String getCarKyori() {
		return carKyori;
	}

	/**
	 * @param carKyori セットする carKyori
	 */
	public void setCarKyori(String carKyori) {
		this.carKyori = carKyori;
	}

	/**
	 * @return funcId
	 */
	public String getFuncId() {
		return funcId;
	}

	/**
	 * @param funcId セットする funcId
	 */
	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	/**
	 * @return ctEndDtFlg
	 */
	public String getCtEndDtFlg() {
		return ctEndDtFlg;
	}

	/**
	 * @param ctEndDtFlg セットする ctEndDtFlg
	 */
	public void setCtEndDtFlg(String ctEndDtFlg) {
		this.ctEndDtFlg = ctEndDtFlg;
	}

	/**
	 * @return ablEndDtFlg
	 */
	public String getAblEndDtFlg() {
		return ablEndDtFlg;
	}

	/**
	 * @param ablEndDtFlg セットする ablEndDtFlg
	 */
	public void setAblEndDtFlg(String ablEndDtFlg) {
		this.ablEndDtFlg = ablEndDtFlg;
	}

	/**
	 * @return bkAdr1
	 */
	public String getBkAdr1() {
		return bkAdr1;
	}

	/**
	 * @param bkAdr1 セットする bkAdr1
	 */
	public void setBkAdr1(String bkAdr1) {
		this.bkAdr1 = bkAdr1;
	}

	/**
	 * @return bkAdr2
	 */
	public String getBkAdr2() {
		return bkAdr2;
	}

	/**
	 * @param bkAdr2 セットする bkAdr2
	 */
	public void setBkAdr2(String bkAdr2) {
		this.bkAdr2 = bkAdr2;
	}

	/**
	 * @return bkAdr3
	 */
	public String getBkAdr3() {
		return bkAdr3;
	}

	/**
	 * @param bkAdr3 セットする bkAdr3
	 */
	public void setBkAdr3(String bkAdr3) {
		this.bkAdr3 = bkAdr3;
	}

	/**
	 * @return email1
	 */
	public String getEmail1() {
		return email1;
	}

	/**
	 * @param email1 セットする email1
	 */
	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	/**
	 * @return email2
	 */
	public String getEmail2() {
		return email2;
	}

	/**
	 * @param email2 セットする email2
	 */
	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	/**
	 * @return email3
	 */
	public String getEmail3() {
		return email3;
	}

	/**
	 * @param email3 セットする email3
	 */
	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	/**
	 * @return email4
	 */
	public String getEmail4() {
		return email4;
	}

	/**
	 * @param email4 セットする email4
	 */
	public void setEmail4(String email4) {
		this.email4 = email4;
	}

	/**
	 * @return email5
	 */
	public String getEmail5() {
		return email5;
	}

	/**
	 * @param email5 セットする email5
	 */
	public void setEmail5(String email5) {
		this.email5 = email5;
	}

	/**
	 * @return ckbShopcd
	 */
	public String getCkbShopcd() {
		return ckbShopcd;
	}

	/**
	 * @param ckbShopcd セットする ckbShopcd
	 */
	public void setCkbShopcd(String ckbShopcd) {
		this.ckbShopcd = ckbShopcd;
	}

	/**
	 * @return akbShopcd
	 */
	public String getAkbShopcd() {
		return akbShopcd;
	}

	/**
	 * @param akbShopcd セットする akbShopcd
	 */
	public void setAkbShopcd(String akbShopcd) {
		this.akbShopcd = akbShopcd;
	}

	/**
	 * @return keiyakuKbn
	 */
	public String getKeiyakuKbn() {
		return keiyakuKbn;
	}

	/**
	 * @param keiyakuKbn セットする keiyakuKbn
	 */
	public void setKeiyakuKbn(String keiyakuKbn) {
		this.keiyakuKbn = keiyakuKbn;
	}

	/**
	 * @return emailUseKbn1
	 */
	public String getEmailUseKbn1() {
		return emailUseKbn1;
	}

	/**
	 * @param emailUseKbn1 セットする emailUseKbn1
	 */
	public void setEmailUseKbn1(String emailUseKbn1) {
		this.emailUseKbn1 = emailUseKbn1;
	}

	/**
	 * @return emailUseKbn2
	 */
	public String getEmailUseKbn2() {
		return emailUseKbn2;
	}

	/**
	 * @param emailUseKbn2 セットする emailUseKbn2
	 */
	public void setEmailUseKbn2(String emailUseKbn2) {
		this.emailUseKbn2 = emailUseKbn2;
	}

	/**
	 * @return emailUseKbn3
	 */
	public String getEmailUseKbn3() {
		return emailUseKbn3;
	}

	/**
	 * @param emailUseKbn3 セットする emailUseKbn3
	 */
	public void setEmailUseKbn3(String emailUseKbn3) {
		this.emailUseKbn3 = emailUseKbn3;
	}

	/**
	 * @return emailUseKbn4
	 */
	public String getEmailUseKbn4() {
		return emailUseKbn4;
	}

	/**
	 * @param emailUseKbn4 セットする emailUseKbn4
	 */
	public void setEmailUseKbn4(String emailUseKbn4) {
		this.emailUseKbn4 = emailUseKbn4;
	}

	/**
	 * @return emailUseKbn5
	 */
	public String getEmailUseKbn5() {
		return emailUseKbn5;
	}

	/**
	 * @param emailUseKbn5 セットする emailUseKbn5
	 */
	public void setEmailUseKbn5(String emailUseKbn5) {
		this.emailUseKbn5 = emailUseKbn5;
	}

	/**
	 * @return roomKey
	 */
	public String getRoomKey() {
		return roomKey;
	}

	/**
	 * @param roomKey セットする roomKey
	 */
	public void setRoomKey(String roomKey) {
		this.roomKey = roomKey;
	}

    /**
     * 物件管理テーブルの最終更新日時を返します。
     * @return bukkenKanriLastUpdate
     */
    public String getBukkenKanriLastUpdate() {
        return bukkenKanriLastUpdate;
    }

    /**
     * 物件管理テーブルの最終更新日時を設定します。
     * @param bukkenKanriLastUpdate  bukkenKanriLastUpdate
     */
    public void setBukkenKanriLastUpdate(String bukkenKanriLastUpdate) {
        this.bukkenKanriLastUpdate = bukkenKanriLastUpdate;
    }
    /**
     * @return changeSourceKbn
     */
    public String getChangeSourceKbn() {
        return changeSourceKbn;
    }

    /**
     * @param changeSourceKbn セットする changeSourceKbn
     */
    public void setChangeSourceKbn(String changeSourceKbn) {
        this.changeSourceKbn = changeSourceKbn;
    }

    /**
     * @return ensencd
     */
    public String getEnsencd() {
        return ensencd;
    }

    /**
     * @param ensencd セットする ensencd
     */
    public void setEnsencd(String ensencd) {
        this.ensencd = ensencd;
    }

    /**
     * @return otherTransName
     */
    public String getOtherTransName() {
        return otherTransName;
    }

    /**
     * @param otherTransName セットする otherTransName
     */
    public void setOtherTransName(String otherTransName) {
        this.otherTransName = otherTransName;
    }

    /**
     * @return otherTransPlatform
     */
    public String getOtherTransPlatform() {
        return otherTransPlatform;
    }

    /**
     * @param otherTransPlatform セットする otherTransPlatform
     */
    public void setOtherTransPlatform(String otherTransPlatform) {
        this.otherTransPlatform = otherTransPlatform;
    }

}
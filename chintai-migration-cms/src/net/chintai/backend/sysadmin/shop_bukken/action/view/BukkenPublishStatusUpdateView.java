/*
 * $Id: BukkenPublishStatusUpdateView.java 4535 2011-11-04 05:46:53Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/02  BGT)金東珍     新規作成
 * 2008/05/27  BGT)李昊燮     「削除状態」判断用項目追加
 *                            (WEB審査物件ステータス,エイブル期間切れフラグ,CHINTAI期間切れフラグ)
 * 2009/08/02  BGT)李昊燮     物件詳細の所要時間と 各金額の単位表示方法修正対応
 */
package net.chintai.backend.sysadmin.shop_bukken.action.view;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 物件掲載状態変更画面に遷移ViewHelper
 *
 * @author Kim Dong Jin
 * @version $Revision: 4535 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenPublishStatusUpdateView implements ViewHelper {

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

    /** 管理最終更新日時(物件) */
    private String bukkenAdminUpdDt;

    /** 入稿状態 */
    private String insKbn;

    /** フロント反映状態 */
    private String frontFlg;

    /** フロント反映目安日時 */
    private String frontRefDt;

    /** 座標情報(CHINTAI/エイブル) */
    private String locationFlg;

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

    /** 所要時間(車１) */
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

    /** 間取 */
    private String madori;

    /** 面積 */
    private String senMenseki;

    /** 建物種別 */
    private String shubetsu;

    /** 構造 */
    private String kouzou;

    /** 築年 */
    private String chikunen;

    /** 部屋止め区分 */
    private String heyadomeKbn;

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
     * 物件コードを取得します。
     * @return 物件コード
     */
    public String getBkCd() {
        return bkCd;
    }

    /**
     * 物件コードを設定します。
     * @param bkCd 物件コード
     */
    public void setBkCd(String bkCd) {
        this.bkCd = bkCd;
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
     * 管理最終更新日時(物件)を取得します。
     * @return 管理最終更新日時(物件)
     */
    public String getBukkenAdminUpdDt() {
        return bukkenAdminUpdDt;
    }

    /**
     * 管理最終更新日時(物件)を設定します。
     * @param bukkenAdminUpdDt 管理最終更新日時(物件)
     */
    public void setBukkenAdminUpdDt(String bukkenAdminUpdDt) {
        this.bukkenAdminUpdDt = bukkenAdminUpdDt;
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
    public void setFrontRefDt(String frontRefDt) {
        this.frontRefDt = frontRefDt;
    }

    /**
     * 座標情報(CHINTAI/エイブル)を取得します。
     * @return 座標情報(CHINTAI/エイブル)
     */
    public String getLocationFlg() {
        return locationFlg;
    }

    /**
     * 座標情報(CHINTAI/エイブル)を設定します。
     * @param locationFlg 座標情報(CHINTAI/エイブル)
     */
    public void setLocationFlg(String locationFlg) {
        this.locationFlg = locationFlg;
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
        this.insDt = insDt;
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
        this.chikunen = chikunen;
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

}
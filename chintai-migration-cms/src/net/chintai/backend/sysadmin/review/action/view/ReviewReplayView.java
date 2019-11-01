/*
 * $Id: ReviewReplayView.java 4323 2009-08-03 01:58:09Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/12  BGT)李昊燮     新規作成
 * 2009/08/02  BGT)李昊燮     物件詳細の所要時間と 各金額の単位表示方法修正対応
 *
 */
package net.chintai.backend.sysadmin.review.action.view;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 返信入力機能共通
 * @author Lee Hosup
 * @version $Revision: 4323 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewReplayView implements ViewHelper {

    /** 店舗コード */
    private String shopCd;

    /** 物件コード */
    private String bkCd;

    /** 部屋連番 */
    private String roomNo;

    /** 物件名称 */
    private String bkName;

    /** 物件名称(カナ) */
    private String bkKana;

    /** 沿線名称 */
    private String ensenName;

    /** 駅名称 */
    private String ekiName;

    /** 所在地 */
    private String shozaichi;

    /** 駅からの歩く時間 */
    private String ekiToho;

    /** バスでかかる時間 */
    private String bus;

    /** バス停 */
    private String busTei;

    /** バス停から歩く時間 */
    private String busTeiho;

    /** 車でかかる時間 */
    private String car;

    /** 車で移動距離 */
    private String carKyori;

    /** 賃料 */
    private String chinryo;

    /** 管理金 */
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
    private Double shoukyakuKin;

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

    /** 間取り */
    private String madori;

    /** 全面積 */
    private String senMenseki;

    /** 種別 */
    private String shubetsu;

    /** 構造 */
    private String kouzou;

    /** 築年 */
    private String chikunen;

    /** 取引形態 */
    private String torihikikeitai;

    /** 問い合せ番号 */
    private String uketsukeCd;

    /** Web審査警告履歴連番 */
    private String warningRirekiSeq;

    /** 警告コード */
    private String warningCd;

    /** 最終更新日時(Web審査履歴テーブル) */
    private String updDt;

    /** 最終更新日時(物件管理テーブル) */
    private String kanriUpdDt;

    /** 新築フラグ */
    private String shinchikuFlg;

    /** 空室予定年月日 */
    private String vacantYmd;

    /** 空室予定年 */
    private String vacantYear;

    /** 空室予定月 */
    private String vacantMonth;

    /** 空室予定日 */
    private String vacantDay;

    /** 最終条件確認年月日 */
    private String lastConfirmYmd;

    /** 最終条件確認年 */
    private String lastConfirmYear;

    /** 最終条件確認月 */
    private String lastConfirmMonth;

    /** 最終条件確認日 */
    private String lastConfirmDay;

    /** 処理区分 */
    private String syoriKbn;

    /** 備考 */
    private String bikou;

    private String ensencd;
    private String otherTransName;
    private String otherTransPlatform;

    /** 管理コード */
    private String kanriCd;
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
     * 物件名称(カナ)を取得します。
     * @return 物件名称(カナ)
     */
    public String getBkKana() {
        return bkKana;
    }

    /**
     * 物件名称(カナ)を設定します。
     * @param bkKana 物件名称(カナ)
     */
    public void setBkKana(String bkKana) {
        this.bkKana = bkKana;
    }

    /**
     * 沿線名称を取得します。
     * @return 沿線名称
     */
    public String getEnsenName() {
        return ensenName;
    }

    /**
     * 沿線名称を設定します。
     * @param ensenName 沿線名称
     */
    public void setEnsenName(String ensenName) {
        this.ensenName = ensenName;
    }

    /**
     * 駅名称を取得します。
     * @return 駅名称
     */
    public String getEkiName() {
        return ekiName;
    }

    /**
     * 駅名称を設定します。
     * @param ekiName 駅名称
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
     * 賃料を取得します。
     * @return 賃料
     */
    public String getChinryo() {
        return chinryo;
    }

    /**
     * 賃料を設定します。
     * @param chinryo 賃料
     */
    public void setChinryo(String chinryo) {
        this.chinryo = chinryo;
    }

    /**
     * 管理金を取得します。
     * @return 管理金
     */
    public String getKanriKin() {
        return kanriKin;
    }

    /**
     * 管理金を設定します。
     * @param kanriKin 管理金
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
    public Double getShoukyakuKin() {
        return shoukyakuKin;
    }

    /**
     * 償却金を設定します。
     * @param shoukyakuKin 償却金
     */
    public void setShoukyakuKin(Double shoukyakuKin) {
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
     * 間取りを取得します。
     * @return 間取り
     */
    public String getMadori() {
        return madori;
    }

    /**
     * 間取りを設定します。
     * @param madori 間取り
     */
    public void setMadori(String madori) {
        this.madori = madori;
    }

    /**
     * 全面積を取得します。
     * @return 全面積
     */
    public String getSenMenseki() {
        return senMenseki;
    }

    /**
     * 全面積を設定します。
     * @param senMenseki 全面積
     */
    public void setSenMenseki(String senMenseki) {
        this.senMenseki = senMenseki;
    }

    /**
     * 種別を取得します。
     * @return 種別
     */
    public String getShubetsu() {
        return shubetsu;
    }

    /**
     * 種別を設定します。
     * @param shubetsu 種別
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
     * 取引形態を取得します。
     * @return 取引形態
     */
    public String getTorihikikeitai() {
        return torihikikeitai;
    }

    /**
     * 取引形態を設定します。
     * @param torihikikeitai 取引形態
     */
    public void setTorihikikeitai(String torihikikeitai) {
        this.torihikikeitai = torihikikeitai;
    }

    /**
     * 問い合せ番号を取得します。
     * @return 問い合せ番号
     */
    public String getUketsukeCd() {
        return uketsukeCd;
    }

    /**
     * 問い合せ番号を設定します。
     * @param uketsukeCd 問い合せ番号
     */
    public void setUketsukeCd(String uketsukeCd) {
        this.uketsukeCd = uketsukeCd;
    }

    /**
     * Web審査警告履歴連番を取得します。
     * @return Web審査警告履歴連番
     */
    public String getWarningRirekiSeq() {
        return warningRirekiSeq;
    }

    /**
     * Web審査警告履歴連番を設定します。
     * @param warningRirekiSeq Web審査警告履歴連番
     */
    public void setWarningRirekiSeq(String warningRirekiSeq) {
        this.warningRirekiSeq = warningRirekiSeq;
    }

    /**
     * 警告コードを取得します。
     * @return 警告コード
     */
    public String getWarningCd() {
        return warningCd;
    }

    /**
     * 警告コードを設定します。
     * @param warningCd 警告コード
     */
    public void setWarningCd(String warningCd) {
        this.warningCd = warningCd;
    }

    /**
     * 最終更新日時(Web審査履歴テーブル)を取得します。
     * @return 最終更新日時(Web審査履歴テーブル)
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日時(Web審査履歴テーブル)を設定します。
     * @param updDt 最終更新日時(Web審査履歴テーブル)
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 最終更新日時(物件管理テーブル)を取得します。
     * @return 最終更新日時(物件管理テーブル)
     */
    public String getKanriUpdDt() {
        return kanriUpdDt;
    }

    /**
     * 最終更新日時(物件管理テーブル)を設定します。
     * @param kanriUpdDt 最終更新日時(物件管理テーブル)
     */
    public void setKanriUpdDt(String kanriUpdDt) {
        this.kanriUpdDt = kanriUpdDt;
    }

    /**
     * 新築フラグを取得します。
     * @return 新築フラグ
     */
    public String getShinchikuFlg() {
        return shinchikuFlg;
    }

    /**
     * 新築フラグを設定します。
     * @param shinchikuFlg 新築フラグ
     */
    public void setShinchikuFlg(String shinchikuFlg) {
        this.shinchikuFlg = shinchikuFlg;
    }

    /**
     * 空室予定年月日を取得します。
     * @return 空室予定年月日
     */
    public String getVacantYmd() {
        return vacantYmd;
    }

    /**
     * 空室予定年月日を設定します。
     * @param vacantYmd 空室予定年月日
     */
    public void setVacantYmd(String vacantYmd) {
        this.vacantYmd = vacantYmd;
    }

    /**
     * 空室予定年を取得します。
     * @return 空室予定年
     */
    public String getVacantYear() {
        return vacantYear;
    }

    /**
     * 空室予定年を設定します。
     * @param vacantYear 空室予定年
     */
    public void setVacantYear(String vacantYear) {
        this.vacantYear = vacantYear;
    }

    /**
     * 空室予定月を取得します。
     * @return 空室予定月
     */
    public String getVacantMonth() {
        return vacantMonth;
    }

    /**
     * 空室予定月を設定します。
     * @param vacantMonth 空室予定月
     */
    public void setVacantMonth(String vacantMonth) {
        this.vacantMonth = vacantMonth;
    }

    /**
     * 空室予定日を取得します。
     * @return 空室予定日
     */
    public String getVacantDay() {
        return vacantDay;
    }

    /**
     * 空室予定日を設定します。
     * @param vacantDay 空室予定日
     */
    public void setVacantDay(String vacantDay) {
        this.vacantDay = vacantDay;
    }

    /**
     * 最終条件確認年月日を取得します。
     * @return 最終条件確認年月日
     */
    public String getLastConfirmYmd() {
        return lastConfirmYmd;
    }

    /**
     * 最終条件確認年月日を設定します。
     * @param lastConfirmYmd 最終条件確認年月日
     */
    public void setLastConfirmYmd(String lastConfirmYmd) {
        this.lastConfirmYmd = lastConfirmYmd;
    }

    /**
     * 最終条件確認年を取得します。
     * @return 最終条件確認年
     */
    public String getLastConfirmYear() {
        return lastConfirmYear;
    }

    /**
     * 最終条件確認年を設定します。
     * @param lastConfirmYear 最終条件確認年
     */
    public void setLastConfirmYear(String lastConfirmYear) {
        this.lastConfirmYear = lastConfirmYear;
    }

    /**
     * 最終条件確認月を取得します。
     * @return 最終条件確認月
     */
    public String getLastConfirmMonth() {
        return lastConfirmMonth;
    }

    /**
     * 最終条件確認月を設定します。
     * @param lastConfirmMonth 最終条件確認月
     */
    public void setLastConfirmMonth(String lastConfirmMonth) {
        this.lastConfirmMonth = lastConfirmMonth;
    }

    /**
     * 最終条件確認日を取得します。
     * @return 最終条件確認日
     */
    public String getLastConfirmDay() {
        return lastConfirmDay;
    }

    /**
     * 最終条件確認日を設定します。
     * @param lastConfirmDay 最終条件確認日
     */
    public void setLastConfirmDay(String lastConfirmDay) {
        this.lastConfirmDay = lastConfirmDay;
    }

    /**
     * 処理区分を取得します。
     * @return 処理区分
     */
    public String getSyoriKbn() {
        return syoriKbn;
    }

    /**
     * 処理区分を設定します。
     * @param syoriKbn 処理区分
     */
    public void setSyoriKbn(String syoriKbn) {
        this.syoriKbn = syoriKbn;
    }

    /**
     * 備考を取得します。
     * @return 備考
     */
    public String getBikou() {
        return bikou;
    }

    /**
     * 備考を設定します。
     * @param bikou 備考
     */
    public void setBikou(String bikou) {
        this.bikou = bikou;
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

    /**
     * 管理コードを返します。
     * @return 管理コード
     */
    public String getKanriCd() {
        return kanriCd;
    }

    /**
     * 管理コードを設定します。
     * @param kanriCd  管理コード
     */
    public void setKanriCd(String kanriCd) {
        this.kanriCd = kanriCd;
    }



}

/*
 * $Id: ReviewBukkenSearchInServiceBean.java 3912 2008-05-27 08:06:03Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)李昊燮   新規作成
 * 2008/05/21  BGT)李昊燮   連続掲載日数関連項目追加
 */
package net.chintai.backend.sysadmin.review.service.bean;

import net.chintai.backend.sysadmin.common.session.SessionSearchCondition;

/**
 * 物件検索条件
 *
 * @author lee-hosup
 * @version $Revision: 3912 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenSearchInServiceBean implements SessionSearchCondition {

    /** serialVersionUID */
    private static final long serialVersionUID = -6191826261831887756L;

    /** 店舗コード */
    private String shopCd;

    /** 会社名/事務所名 */
    private String companyBumon;

    /** 状態 */
    private String shopStatus;

    /** 物件コード (物件) */
    private String bkCd;

    /** 部屋連番 */
    private String roomNo;

    /** 問い合せ番号 */
    private String uketsukeCd;

    /** 都道府県 */
    private String prefCd;

    /** 警告日(下限) */
    private String sendDtFrom;

    /** 警告日(上限) */
    private String sendDtTo;

    /** 平均家賃基準該当物件(返信なし) */
    private String warningCd01statusKbn01;

    /** 平均家賃基準該当物件(返信あり:非公開) */
    private String warningCd01statusKbn02;

    /** 平均家賃基準該当物件(返信なし:問題なし) */
    private String warningCd01statusKbn03;

    /** 平均家賃基準該当物件(警告対象外) */
    private String warningCd01statusKbn04;

    /** 連続掲載該当物件(返信なし) */
    private String warningCd02statusKbn01;

    /** 連続掲載該当物件(返信あり:非公開) */
    private String warningCd02statusKbn02;

    /** 連続掲載該当物件(返信なし:問題なし) */
    private String warningCd02statusKbn03;

    /** 連続掲載該当物件(警告対象外) */
    private String warningCd02statusKbn04;

    /** 連続掲載かつアクセス該当物件(返信なし) */
    private String warningCd03statusKbn01;

    /** 連続掲載かつアクセス該当物件(返信あり:非公開) */
    private String warningCd03statusKbn02;

    /** 連続掲載かつアクセス該当物件(返信なし:問題なし) */
    private String warningCd03statusKbn03;

    /** 連続掲載かつアクセス該当物件(警告対象外) */
    private String warningCd03statusKbn04;

    /** 連続掲載日数(下限) */
    private String shinsaStartDtFrom;

    /** 連続掲載日数(上限) */
    private String shinsaStartDtTo;

    /** ページング情報 */
    private int offSet;

    /** 号室 */
    private String roomCd;

    /** 物件名 */
    private String bkName;

    private String searchType;

    /** 店舗コード（物件管理コード） */
    private String bkKanriShopcd;

    /** 物件コード（物件管理コード） */
    private String bkKanriBkcd;

    /** 部屋連番（物件管理コード） */
    private String bkKanriRoomno;

    /** 連続掲載日数の下限か上限どちらかひとつでも入力されているかのチェック用*/
    private String chkFlgShinsaStartDt;

    /**
     * 会社名/事務所名を取得します。
     * @return 会社名/事務所名
     */
    public String getCompanyBumon() {
        return companyBumon;
    }

    /**
     * 会社名/事務所名を設定します。
     * @param companyBumon 会社名/事務所名
     */
    public void setCompanyBumon(String companyBumon) {
        this.companyBumon = companyBumon;
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
     * 物件コード (物件)を取得します。
     * @return 物件コード (物件)
     */
    public String getBkCd() {
        return bkCd;
    }

    /**
     * 物件コード (物件)を設定します。
     * @param bkCd 物件コード (物件)
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
     * 都道府県を取得します。
     * @return 都道府県
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府県を設定します。
     * @param prefCd 都道府県
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
    }

    /**
     * 警告日(下限)を取得します。
     * @return 警告日(下限)
     */
    public String getSendDtFrom() {
        return sendDtFrom;
    }

    /**
     * 警告日(下限)を設定します。
     * @param sendDtFrom 警告日(下限)
     */
    public void setSendDtFrom(String sendDtFrom) {
        this.sendDtFrom = sendDtFrom;
    }

    /**
     * 警告日(上限)を取得します。
     * @return 警告日(上限)
     */
    public String getSendDtTo() {
        return sendDtTo;
    }

    /**
     * 警告日(上限)を設定します。
     * @param sendDtTo 警告日(上限)
     */
    public void setSendDtTo(String sendDtTo) {
        this.sendDtTo = sendDtTo;
    }

    /**
     * 平均家賃基準該当物件(返信なし)を取得します。
     * @return 平均家賃基準該当物件(返信なし)
     */
    public String getWarningCd01statusKbn01() {
        return warningCd01statusKbn01;
    }

    /**
     * 平均家賃基準該当物件(返信なし)を設定します。
     * @param warningCd01statusKbn01 平均家賃基準該当物件(返信なし)
     */
    public void setWarningCd01statusKbn01(String warningCd01statusKbn01) {
        this.warningCd01statusKbn01 = warningCd01statusKbn01;
    }

    /**
     * 平均家賃基準該当物件(返信あり:非公開)を取得します。
     * @return 平均家賃基準該当物件(返信あり:非公開)
     */
    public String getWarningCd01statusKbn02() {
        return warningCd01statusKbn02;
    }

    /**
     * 平均家賃基準該当物件(返信あり:非公開)を設定します。
     * @param warningCd01statusKbn02 平均家賃基準該当物件(返信あり:非公開)
     */
    public void setWarningCd01statusKbn02(String warningCd01statusKbn02) {
        this.warningCd01statusKbn02 = warningCd01statusKbn02;
    }

    /**
     * 平均家賃基準該当物件(返信なし:問題なし)を取得します。
     * @return 平均家賃基準該当物件(返信なし:問題なし)
     */
    public String getWarningCd01statusKbn03() {
        return warningCd01statusKbn03;
    }

    /**
     * 平均家賃基準該当物件(返信なし:問題なし)を設定します。
     * @param warningCd01statusKbn03 平均家賃基準該当物件(返信なし:問題なし)
     */
    public void setWarningCd01statusKbn03(String warningCd01statusKbn03) {
        this.warningCd01statusKbn03 = warningCd01statusKbn03;
    }

    /**
     * 平均家賃基準該当物件(警告対象外)を取得します。
     * @return 平均家賃基準該当物件(警告対象外)
     */
    public String getWarningCd01statusKbn04() {
        return warningCd01statusKbn04;
    }

    /**
     * 平均家賃基準該当物件(警告対象外)を設定します。
     * @param warningCd01statusKbn04 平均家賃基準該当物件(警告対象外)
     */
    public void setWarningCd01statusKbn04(String warningCd01statusKbn04) {
        this.warningCd01statusKbn04 = warningCd01statusKbn04;
    }

    /**
     * 連続掲載該当物件(返信なし)を取得します。
     * @return 連続掲載該当物件(返信なし)
     */
    public String getWarningCd02statusKbn01() {
        return warningCd02statusKbn01;
    }

    /**
     * 連続掲載該当物件(返信なし)を設定します。
     * @param warningCd02statusKbn01 連続掲載該当物件(返信なし)
     */
    public void setWarningCd02statusKbn01(String warningCd02statusKbn01) {
        this.warningCd02statusKbn01 = warningCd02statusKbn01;
    }

    /**
     * 連続掲載該当物件(返信あり:非公開)を取得します。
     * @return 連続掲載該当物件(返信あり:非公開)
     */
    public String getWarningCd02statusKbn02() {
        return warningCd02statusKbn02;
    }

    /**
     * 連続掲載該当物件(返信あり:非公開)を設定します。
     * @param warningCd02statusKbn02 連続掲載該当物件(返信あり:非公開)
     */
    public void setWarningCd02statusKbn02(String warningCd02statusKbn02) {
        this.warningCd02statusKbn02 = warningCd02statusKbn02;
    }

    /**
     * 連続掲載該当物件(返信なし:問題なし)を取得します。
     * @return 連続掲載該当物件(返信なし:問題なし)
     */
    public String getWarningCd02statusKbn03() {
        return warningCd02statusKbn03;
    }

    /**
     * 連続掲載該当物件(返信なし:問題なし)を設定します。
     * @param warningCd02statusKbn03 連続掲載該当物件(返信なし:問題なし)
     */
    public void setWarningCd02statusKbn03(String warningCd02statusKbn03) {
        this.warningCd02statusKbn03 = warningCd02statusKbn03;
    }

    /**
     * 連続掲載該当物件(警告対象外)を取得します。
     * @return 連続掲載該当物件(警告対象外)
     */
    public String getWarningCd02statusKbn04() {
        return warningCd02statusKbn04;
    }

    /**
     * 連続掲載該当物件(警告対象外)を設定します。
     * @param warningCd02statusKbn04 連続掲載該当物件(警告対象外)
     */
    public void setWarningCd02statusKbn04(String warningCd02statusKbn04) {
        this.warningCd02statusKbn04 = warningCd02statusKbn04;
    }

    /**
     * 連続掲載かつアクセス該当物件(返信なし)を取得します。
     * @return 連続掲載かつアクセス該当物件(返信なし)
     */
    public String getWarningCd03statusKbn01() {
        return warningCd03statusKbn01;
    }

    /**
     * 連続掲載かつアクセス該当物件(返信なし)を設定します。
     * @param warningCd03statusKbn01 連続掲載かつアクセス該当物件(返信なし)
     */
    public void setWarningCd03statusKbn01(String warningCd03statusKbn01) {
        this.warningCd03statusKbn01 = warningCd03statusKbn01;
    }

    /**
     * 連続掲載かつアクセス該当物件(返信あり:非公開)を取得します。
     * @return 連続掲載かつアクセス該当物件(返信あり:非公開)
     */
    public String getWarningCd03statusKbn02() {
        return warningCd03statusKbn02;
    }

    /**
     * 連続掲載かつアクセス該当物件(返信あり:非公開)を設定します。
     * @param warningCd03statusKbn02 連続掲載かつアクセス該当物件(返信あり:非公開)
     */
    public void setWarningCd03statusKbn02(String warningCd03statusKbn02) {
        this.warningCd03statusKbn02 = warningCd03statusKbn02;
    }

    /**
     * 連続掲載かつアクセス該当物件(返信なし:問題なし)を取得します。
     * @return 連続掲載かつアクセス該当物件(返信なし:問題なし)
     */
    public String getWarningCd03statusKbn03() {
        return warningCd03statusKbn03;
    }

    /**
     * 連続掲載かつアクセス該当物件(返信なし:問題なし)を設定します。
     * @param warningCd03statusKbn03 連続掲載かつアクセス該当物件(返信なし:問題なし)
     */
    public void setWarningCd03statusKbn03(String warningCd03statusKbn03) {
        this.warningCd03statusKbn03 = warningCd03statusKbn03;
    }

    /**
     * 連続掲載かつアクセス該当物件(警告対象外)を取得します。
     * @return 連続掲載かつアクセス該当物件(警告対象外)
     */
    public String getWarningCd03statusKbn04() {
        return warningCd03statusKbn04;
    }

    /**
     * 連続掲載かつアクセス該当物件(警告対象外)を設定します。
     * @param warningCd03statusKbn04 連続掲載かつアクセス該当物件(警告対象外)
     */
    public void setWarningCd03statusKbn04(String warningCd03statusKbn04) {
        this.warningCd03statusKbn04 = warningCd03statusKbn04;
    }

    /**
     * ページング情報を取得します。
     * @return ページング情報
     */
    public int getOffSet() {
        return offSet;
    }

    /**
     * ページング情報を設定します。
     * @param offSet ページング情報
     */
    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

    /**
     * 連続掲載日数(下限)を取得します。
     * @return shinsaStartDtFrom
     */
    public String getShinsaStartDtFrom() {
        return shinsaStartDtFrom;
    }

    /**
     * 連続掲載日数(下限)を設定します。
     * @param shinsaStartDtFrom 設定する shinsaStartDtFrom
     */
    public void setShinsaStartDtFrom(String shinsaStartDtFrom) {
        this.shinsaStartDtFrom = shinsaStartDtFrom;
    }

    /**
     * 連続掲載日数(上限)を取得します。
     * @return shinsaStartDtTo
     */
    public String getShinsaStartDtTo() {
        return shinsaStartDtTo;
    }

    /**
     * 連続掲載日数(上限)を設定します。
     * @param shinsaStartDtTo 設定する shinsaStartDtTo
     */
    public void setShinsaStartDtTo(String shinsaStartDtTo) {
        this.shinsaStartDtTo = shinsaStartDtTo;
    }

	/**
	 * @return roomCd
	 */
	public String getRoomCd() {
		return roomCd;
	}

	/**
	 * @param roomCd セットする roomCd
	 */
	public void setRoomCd(String roomCd) {
		this.roomCd = roomCd;
	}

	/**
	 * @return bkName
	 */
	public String getBkName() {
		return bkName;
	}

	/**
	 * @param bkName セットする bkName
	 */
	public void setBkName(String bkName) {
		this.bkName = bkName;
	}

	/**
	 * @return shopCd
	 */
	public String getShopCd() {
		return shopCd;
	}

	/**
	 * @param shopCd セットする shopCd
	 */
	public void setShopCd(String shopCd) {
		this.shopCd = shopCd;
	}

	/**
	 * @return searchType
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * @param searchType セットする searchType
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	/**
	 * @return chkFlgShinsaStartDt
	 */
	public String getChkFlgShinsaStartDt() {
		return chkFlgShinsaStartDt;
	}

	/**
	 * @param chkFlgShinsaStartDt セットする chkFlgShinsaStartDt
	 */
	public void setChkFlgShinsaStartDt(String chkFlgShinsaStartDt) {
		this.chkFlgShinsaStartDt = chkFlgShinsaStartDt;
	}
    /**
     * @return bkKanriShopcd
     */
    public String getBkKanriShopcd() {
        return bkKanriShopcd;
    }

    /**
     * @param bkKanriShopcd セットする bkKanriShopcd
     */
    public void setBkKanriShopcd(String bkKanriShopcd) {
        this.bkKanriShopcd = bkKanriShopcd;
    }

    /**
     * @return bkKanriBkcd
     */
    public String getBkKanriBkcd() {
        return bkKanriBkcd;
    }

    /**
     * @param bkKanriBkcd セットする bkKanriBkcd
     */
    public void setBkKanriBkcd(String bkKanriBkcd) {
        this.bkKanriBkcd = bkKanriBkcd;
    }

    /**
     * @return bkKanriRoomno
     */
    public String getBkKanriRoomno() {
        return bkKanriRoomno;
    }

    /**
     * @param bkKanriRoomno セットする bkKanriRoomno
     */
    public void setBkKanriRoomno(String bkKanriRoomno) {
        this.bkKanriRoomno = bkKanriRoomno;
    }

}

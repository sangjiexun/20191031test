/*
 * $Id: CjnInquiryInfo.java 4308 2009-07-14 06:46:43Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.domain;

/**
 * 問い合せ詳細情報Bean
 *
 * @author Yang-EunMi
 * @author s-sugimoto
 *
 * @version $Revision: 4308 $
 * @version 2008.07.11 雑誌・ザガット対応のproperty追加 <br>
 *          このクラスは、[CJN_INQUIRY]テーブルのエンティティととらえる<br>
 *
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryInfo {

    /** 問い合せ日時 */
    private String insDt;

    /** 問い合せID */
    private String cjnInqId;

    /** 閲覧状況 */
    private String refFlg;

    /** 処理状況 */
    private String inquiryStatus;

    /** 最終閲覧ユーザ */
    private String lastRefUser;

    /** 最終処理ユーザ */
    private String lastOpeUser;

    /** 最終処理日時 */
    private String updDt;

    /** 最終閲覧日時 */
    private String lastRefDt;

    /** 最終処理日時 */
    private String lastOpeDt;

    /** 問い合せ内容 */
    private String inqContents;

    /**
     * キャリア種別
     */
    private String carrierType;

    /**
     * 伝票番号
     * @since 2008.07.11 雑誌・ザガットクレジット対応
     */
    private String fregiDenpyoNo;

    /**
     * 取引番号
     * @since 2008.07.11 雑誌・ザガットクレジット対応
     */
    private String fregiTorihikiNo;

    private String carrierTypeName;

    private String inquiryStatusName;

    /**
     * 問い合せ日時を設定します。
     * @return insDt
     */
    public String getInsDt() {
        return insDt;
    }

    /**
     * 問い合せ日時を取得します。
     * @param insDt
     */
    public void setInsDt(String insDt) {
        this.insDt = insDt;
    }

    /**
     * 問い合せIDを取得します。
     * @return 問い合せID
     */
    public String getCjnInqId() {
        return cjnInqId;
    }

    /**
     * 問い合せIDを設定します。
     * @param cjnInqId 問い合せID
     */
    public void setCjnInqId(String cjnInqId) {
        this.cjnInqId = cjnInqId;
    }

    /**
     * 閲覧状況を設定します。
     * @return refFlg
     */
    public String getRefFlg() {
        return refFlg;
    }

    /**
     * 閲覧状況を取得します。
     * @param refFlg
     */
    public void setRefFlg(String refFlg) {
        this.refFlg = refFlg;
    }

    /**
     * 処理状況を取得します。
     * @return 処理状況
     */
    public String getInquiryStatus() {
        return inquiryStatus;
    }

    /**
     * 処理状況を設定します。
     * @param inquiryStatus 処理状況
     */
    public void setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }

    /**
     * 最終閲覧ユーザを設定します。
     * @return lastRefUser
     */
    public String getLastRefUser() {
        return lastRefUser;
    }

    /**
     * 最終閲覧ユーザを取得します。
     * @param lastRefUser
     */
    public void setLastRefUser(String lastRefUser) {
        this.lastRefUser = lastRefUser;
    }

    /**
     * 最終処理ユーザを取得します。
     * @return 最終処理ユーザ
     */
    public String getLastOpeUser() {
        return lastOpeUser;
    }

    /**
     * 最終処理ユーザを設定します。
     * @param lastOpeUser 最終処理ユーザ
     */
    public void setLastOpeUser(String lastOpeUser) {
        this.lastOpeUser = lastOpeUser;
    }

    /**
     * 最終更新日時を設定します。
     * @return updDt
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日時を取得します。
     * @param updDt
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 最終閲覧日時を取得します。
     * @return 最終閲覧日時
     */
    public String getLastRefDt() {
        return lastRefDt;
    }

    /**
     * 最終閲覧日時を設定します。
     * @param lastRefDt 最終閲覧日時
     */
    public void setLastRefDt(String lastRefDt) {
        this.lastRefDt = lastRefDt;
    }

    /**
     * 最終処理日時を設定します。
     * @return lastOpeDt
     */
    public String getLastOpeDt() {
        return lastOpeDt;
    }

    /**
     * 最終処理日時を取得します。
     * @param lastOpeDt
     */
    public void setLastOpeDt(String lastOpeDt) {
        this.lastOpeDt = lastOpeDt;
    }

    /**
	 * @return inqContents
	 */
	public String getInqContents() {
		return inqContents;
	}

	/**
	 * @param inqContents セットする inqContents
	 */
	public void setInqContents(String inqContents) {
		this.inqContents = inqContents;
	}

	/**
	 * @return carrierType
	 */
	public String getCarrierType() {
		return carrierType;
	}

	/**
	 * @param carrierType セットする carrierType
	 */
	public void setCarrierType(String carrierType) {
		this.carrierType = carrierType;
	}

	/**
     * 伝票番号を取得します。
     * @return 伝票番号
     * @since 2008.07.11 雑誌・ザガットクレジット対応
     */
    public String getFregiDenpyoNo() {
        return fregiDenpyoNo;
    }

    /**
     * 伝票番号を設定します。
     * @param fregiDenpyoNo
     * @since 2008.07.11 雑誌・ザガットクレジット対応
     */
    public void setFregiDenpyoNo(String fregiDenpyoNo) {
        this.fregiDenpyoNo = fregiDenpyoNo;
    }

    /**
     * 取引番号を取得します。
     * @return 取引番号
     * @since 2008.07.11 雑誌・ザガットクレジット対応
     */
    public String getFregiTorihikiNo() {
        return fregiTorihikiNo;
    }

    /**
     * 取引番号を設定します。
     * @param fregiTorihikiNo
     * @since 2008.07.11 雑誌・ザガットクレジット対応
     */
    public void setFregiTorihikiNo(String fregiTorihikiNo) {
        this.fregiTorihikiNo = fregiTorihikiNo;
    }

	/**
	 * @return carrierTypeName
	 */
	public String getCarrierTypeName() {
		return carrierTypeName;
	}

	/**
	 * @param carrierTypeName セットする carrierTypeName
	 */
	public void setCarrierTypeName(String carrierTypeName) {
		this.carrierTypeName = carrierTypeName;
	}

	/**
	 * @return inquiryStatusName
	 */
	public String getInquiryStatusName() {
		return inquiryStatusName;
	}

	/**
	 * @param inquiryStatusName セットする inquiryStatusName
	 */
	public void setInquiryStatusName(String inquiryStatusName) {
		this.inquiryStatusName = inquiryStatusName;
	}
}

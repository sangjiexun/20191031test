package net.chintai.backend.sysadmin.cjn_inquiry.action.view;

/**
 * 雑誌・ザガット対応をきに、<br>
 * {@link CjnInquiryInfoView},および{@link CjnInquiryStatusUpdateView}で使用するプロパティを<br>
 * 共通なものを汎化。
 *
 * CjnInquiryのinfo、Search、Statusの各Actionで表示するview（jsp）に遷移した際に、<br>
 * 表示する情報をスコープに格納するviewHelperを作成する場合は、<br>
 * この抽象クラスを継承して必要なオブジェクトを生成してください。<br>
 * 場合によっては、このクラスを継承しないでviewHelperを作成する場合もありえます。<Br>
 *
 * @author s-sugimoto
 * @since 2008.07.14 14:55
 * @version $Revision: 3987 $
 */
public abstract class AbstractCjnInquiryBaseView {

    /** 問い合せシーケンス */
    private int cjnInqKindSeq;

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

    /** 現在位置 */
    private int offSet;

    /** キャリア種別 */
    private String carrierType;

    /** 伝票番号 */
    private String fregiDenpyoNo;

    /** 取引番号 */
    private String fregiTorihikiNo;

    private String refFlgName;
    private String inquiryStatusName;
    private String carrierTypeName;

    /**
     * 問い合せシーケンスを取得します。
     * @return 問い合せシーケンス
     */
    public int getCjnInqKindSeq() {
        return cjnInqKindSeq;
    }

    /**
     * 問い合せシーケンスを設定します。
     * @param cjnInqKindSeq 問い合せシーケンス
     */
    public void setCjnInqKindSeq(int cjnInqKindSeq) {
        this.cjnInqKindSeq = cjnInqKindSeq;
    }

    /**
     * 問い合せ日時を取得します。
     * @return 問い合せ日時
     */
    public String getInsDt() {
        return insDt;
    }

    /**
     * 問い合せ日時を設定します。
     * @param insDt 問い合せ日時
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
     * 閲覧状況を取得します。
     * @return 閲覧状況
     */
    public String getRefFlg() {
        return refFlg;
    }

    /**
     * 閲覧状況を設定します。
     * @param refFlg 閲覧状況
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
     * 最終閲覧ユーザを取得します。
     * @return 最終閲覧ユーザ
     */
    public String getLastRefUser() {
        return lastRefUser;
    }

    /**
     * 最終閲覧ユーザを設定します。
     * @param lastRefUser 最終閲覧ユーザ
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
     * 最終処理日時を取得します。
     * @return 最終処理日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終処理日時を設定します。
     * @param updDt 最終処理日時
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
     * 最終処理日時を取得します。
     * @return 最終処理日時
     */
    public String getLastOpeDt() {
        return lastOpeDt;
    }

    /**
     * 最終処理日時を設定します。
     * @param lastOpeDt 最終処理日時
     */
    public void setLastOpeDt(String lastOpeDt) {
        this.lastOpeDt = lastOpeDt;
    }

    /**
     * 現在位置を取得します。
     * @return 現在位置
     */
    public int getOffSet() {
        return offSet;
    }

    /**
     * 現在位置を設定します。
     * @param offSet 現在位置
     */
    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

    /**
     * 伝票番号を取得します。
     * @return 伝票番号
     */
    public String getFregiDenpyoNo() {
        return fregiDenpyoNo;
    }

    /**
     * 伝票番号を設定します。
     * @param fregiDenpyoNo 伝票番号
     */
    public void setFregiDenpyoNo(String fregiDenpyoNo) {
        this.fregiDenpyoNo = fregiDenpyoNo;
    }

    /**
     * 取引番号を取得します。
     * @return 取引番号
     */
    public String getFregiTorihikiNo() {
        return fregiTorihikiNo;
    }

    /**
     * 取引番号を設定します。
     * @param fregiTorihikiNo 取引番号
     */
    public void setFregiTorihikiNo(String fregiTorihikiNo) {
        this.fregiTorihikiNo = fregiTorihikiNo;
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
	 * @return refFlgName
	 */
	public String getRefFlgName() {
		return refFlgName;
	}

	/**
	 * @param refFlgName セットする refFlgName
	 */
	public void setRefFlgName(String refFlgName) {
		this.refFlgName = refFlgName;
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

}

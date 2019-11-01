/*
 * $Id: CjnInquiryStatusUpdateCommitParamBean.java 3991 2008-07-14 11:31:20Z s-sugimoto $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

/**
 * 問い合せ処理状況更新条件
 * @author Yang-EunMi
 * @author s-sugimoto
 * @version $Revision: 3991 $
 * @version 2008.07.11 雑誌・ザガット対応のproperty追加 <br>
 *          Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryStatusUpdateCommitParamBean {

    /** 問い合せID */
    private String cjnInqId;

    /** 処理状況 */
    private String inquiryStatus;

    /** 更新者ID */
    private String operUserId;

    /** 最終更新日時 */
    private String updDt;

    /** 更新プログラム名 */
    private String pgName;

    /**
     * 問い合せシーケンス
     * @since 2008.07.11 雑誌・ザガット時で確認したWHERE条件抜けの追加？
     */
    private int cjnInqKindSeq;

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
     * 問い合せIDを設定します。
     * @return cjnInqId
     */
    public String getCjnInqId() {
        return cjnInqId;
    }

    /**
     * 問い合せIDを取得します。
     * @param cjnInqId
     */
    public void setCjnInqId(String cjnInqId) {
        this.cjnInqId = cjnInqId;
    }

    /**
     * 処理状況を設定します。
     * @return inquiryStatus
     */
    public String getInquiryStatus() {
        return inquiryStatus;
    }

    /**
     * 処理状況を取得します。
     * @param inquiryStatus
     */
    public void setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }

    /**
     * 更新者IDを設定します。
     * @return operUserId
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 更新者IDを取得します。
     * @param operUserId
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
    }

    /**
     * 問い合せシーケンスを取得します。
     * @return 問い合せシーケンス
     * @since 2008.07.11 雑誌・ザガット時で確認したWHERE条件抜けの追加？
     */
    public int getCjnInqKindSeq() {
        return cjnInqKindSeq;
    }

    /**
     * 問い合せシーケンスを設定します。
     * @param cjnInqKindSeq 問い合せシーケンス
     * @since 2008.07.11 雑誌・ザガット時で確認したWHERE条件抜けの追加？
     */
    public void setCjnInqKindSeq(int cjnInqKindSeq) {
        this.cjnInqKindSeq = cjnInqKindSeq;
    }

	/**
	 * @return pgName
	 */
	public String getPgName() {
		return pgName;
	}

	/**
	 * @param pgName セットする pgName
	 */
	public void setPgName(String pgName) {
		this.pgName = pgName;
	}

}

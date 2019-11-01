/*
 * $Id: CjnInquiryTypeInfoUsers.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.domain;

/**
 * 問い合せ種別詳細・閲覧可能ユーザ一覧
 *
 * @author JavaBeans Code Generator
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeInfoUsers {

    /** 問い合せ種別シーケンス */
    private int cjnInqKindSeq;

    /** 閲覧可否 */
    private boolean exists;

    /** 名前 */
    private String userName;

    /** CHINTAI問い合せアカウントシーケンス */
    private Integer cjnAccountSeq;

    /** 最終更新日時 */
    private String updDt;

    /** 作業者ユーザID */
    private String operUserId;

    /** レコード登録プログラムID */
    private String pgName;

    /**
     * 問い合せ種別シーケンスを取得します。
     * @return 問い合せ種別シーケンス
     */
    public int getCjnInqKindSeq() {
        return cjnInqKindSeq;
    }

    /**
     * 問い合せ種別シーケンスを設定します。
     * @param cjnInqKindSeq 問い合せ種別シーケンス
     */
    public void setCjnInqKindSeq(int cjnInqKindSeq) {
        this.cjnInqKindSeq = cjnInqKindSeq;
    }

    /**
     * 閲覧可否を取得します。
     * @return 閲覧可否
     */
    public boolean isExists() {
        return exists;
    }

    /**
     * 閲覧可否を設定します。
     * @param exists 閲覧可否
     */
    public void setExists(boolean exists) {
        this.exists = exists;
    }

    /**
     * 名前を取得します。
     * @return 名前
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 名前を設定します。
     * @param userName 名前
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * CHINTAI問い合せアカウントシーケンスを取得します。
     * @return CHINTAI問い合せアカウントシーケンス
     */
    public Integer getCjnAccountSeq() {
        return cjnAccountSeq;
    }

    /**
     * CHINTAI問い合せアカウントシーケンスを設定します。
     * @param cjnAccountSeq CHINTAI問い合せアカウントシーケンス
     */
    public void setCjnAccountSeq(Integer cjnAccountSeq) {
        this.cjnAccountSeq = cjnAccountSeq;
    }

    /**
     * 最終更新日時を取得します。
     * @return 最終更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日時を設定します。
     * @param updDt 最終更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 作業者ユーザIDを取得します。
     * @return 作業者ユーザID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 作業者ユーザIDを設定します。
     * @param operUserId 作業者ユーザID
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
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

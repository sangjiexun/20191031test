/*
 * $Id: CjnUserAuthorityUpdateCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.bean;

/**
 * 閲覧可能問い合せ権限更新
 *
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAuthorityUpdateCommitInServiceBean {

    /** CHINTAIアカウントシーケンス */
    private String cjnAccountSeq;

    /** 問い合せマスタ識別シーケンス */
    private Integer[] cjnInqKindSeq;

    /** 更新者をユーザＩＤ */
    private String operUserId;

    /** 最終更新日時 */
    private String updDt;

    /** レコード登録プログラムID */
    private String pgName;

    /** ユーザID */
    private String userId;

    /**
     * CHINTAIアカウントシーケンスを取得します。
     * @return CHINTAIアカウントシーケンス
     */
    public String getCjnAccountSeq() {
        return cjnAccountSeq;
    }

    /**
     * CHINTAIアカウントシーケンスを設定します。
     * @param cjnAccountSeq CHINTAIアカウントシーケンス
     */
    public void setCjnAccountSeq(String cjnAccountSeq) {
        this.cjnAccountSeq = cjnAccountSeq;
    }

    /**
     * 問い合せマスタ識別シーケンスを取得します。
     * @return 問い合せマスタ識別シーケンス
     */
    public Integer[] getCjnInqKindSeq() {
        return cjnInqKindSeq;
    }

    /**
     * 問い合せマスタ識別シーケンスを設定します。
     * @param cjnInqKindSeq 問い合せマスタ識別シーケンス
     */
    public void setCjnInqKindSeq(Integer[] cjnInqKindSeq) {
        this.cjnInqKindSeq = cjnInqKindSeq;
    }

    /**
     * 更新者をユーザＩＤを取得します。
     * @return 更新者をユーザＩＤ
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 更新者をユーザＩＤを設定します。
     * @param operUserId 更新者をユーザＩＤ
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
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

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}

/*
 * $Id: CjnUserAuthorityUpdateParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

/**
 * 問い合わせ権限リスト照会Bean
 *
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAuthorityUpdateParamBean {

    /** CHINTAIアカウントシーケンス */
    private String cjnAccountSeq;

    /** 問い合せマスタ識別シーケンス */
    private Integer cjnInqKindSeq;

    /** 更新者をユーザID */
    private String operUserId;

    /** レコード登録プログラムID */
    private String pgName;

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
    public Integer getCjnInqKindSeq() {
        return cjnInqKindSeq;
    }

    /**
     * 問い合せマスタ識別シーケンスを設定します。
     * @param cjnInqKindSeq 問い合せマスタ識別シーケンス
     */
    public void setCjnInqKindSeq(Integer cjnInqKindSeq) {
        this.cjnInqKindSeq = cjnInqKindSeq;
    }

    /**
     * 更新者をユーザIDを取得します。
     * @return 更新者をユーザID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 更新者をユーザIDを設定します。
     * @param operUserId 更新者をユーザID
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

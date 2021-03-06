/*
 * $Id: CjnUserUpdateCommitParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

/**
 * 問い合せユーザの更新情報を格納するBean。
 *
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserUpdateCommitParamBean {

    /** ユーザID */
    private String userId;

    /** 名前 */
    private String userName;

    /** お知らせ送付メールアドレス1 */
    private String email1;

    /** お知らせ送付メールアドレス1状態 */
    private String emailStatus1;

    /** お知らせ送付メールアドレス2 */
    private String email2;

    /** お知らせ送付メールアドレス2状態 */
    private String emailStatus2;

    /** お知らせ送付メールアドレス3 */
    private String email3;

    /** お知らせ送付メールアドレス3状態 */
    private String emailStatus3;

    /** レベル */
    private String accountLevel;

    /** 登録日時 */
    private String insDt;

    /** 更新日時 */
    private String updDt;

    /** CHINTAIアカウントシーケンス */
    private String cjnAccountSeq;

    /** 管理メモ */
    private String adminNote;

    /** 作業者ユーザID */
    private String operUserId;

    /** レコード登録プログラムID */
    private String pgName;

    /**
     * ユーザIDを取得します。
     * @return ユーザID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザIDを設定します。
     * @param userId ユーザID
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * お知らせ送付メールアドレス1を取得します。
     * @return お知らせ送付メールアドレス1
     */
    public String getEmail1() {
        return email1;
    }

    /**
     * お知らせ送付メールアドレス1を設定します。
     * @param email1 お知らせ送付メールアドレス1
     */
    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    /**
     * お知らせ送付メールアドレス1状態を取得します。
     * @return お知らせ送付メールアドレス1状態
     */
    public String getEmailStatus1() {
        return emailStatus1;
    }

    /**
     * お知らせ送付メールアドレス1状態を設定します。
     * @param emailStatus1 お知らせ送付メールアドレス1状態
     */
    public void setEmailStatus1(String emailStatus1) {
        this.emailStatus1 = emailStatus1;
    }

    /**
     * お知らせ送付メールアドレス2を取得します。
     * @return お知らせ送付メールアドレス2
     */
    public String getEmail2() {
        return email2;
    }

    /**
     * お知らせ送付メールアドレス2を設定します。
     * @param email2 お知らせ送付メールアドレス2
     */
    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    /**
     * お知らせ送付メールアドレス2状態を取得します。
     * @return お知らせ送付メールアドレス2状態
     */
    public String getEmailStatus2() {
        return emailStatus2;
    }

    /**
     * お知らせ送付メールアドレス2状態を設定します。
     * @param emailStatus2 お知らせ送付メールアドレス2状態
     */
    public void setEmailStatus2(String emailStatus2) {
        this.emailStatus2 = emailStatus2;
    }

    /**
     * お知らせ送付メールアドレス3を取得します。
     * @return お知らせ送付メールアドレス3
     */
    public String getEmail3() {
        return email3;
    }

    /**
     * お知らせ送付メールアドレス3を設定します。
     * @param email3 お知らせ送付メールアドレス3
     */
    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    /**
     * お知らせ送付メールアドレス3状態を取得します。
     * @return お知らせ送付メールアドレス3状態
     */
    public String getEmailStatus3() {
        return emailStatus3;
    }

    /**
     * お知らせ送付メールアドレス3状態を設定します。
     * @param emailStatus3 お知らせ送付メールアドレス3状態
     */
    public void setEmailStatus3(String emailStatus3) {
        this.emailStatus3 = emailStatus3;
    }

    /**
     * レベルを取得します。
     * @return レベル
     */
    public String getAccountLevel() {
        return accountLevel;
    }

    /**
     * レベルを設定します。
     * @param accountLevel レベル
     */
    public void setAccountLevel(String accountLevel) {
        this.accountLevel = accountLevel;
    }

    /**
     * 登録日時を取得します。
     * @return 登録日時
     */
    public String getInsDt() {
        return insDt;
    }

    /**
     * 登録日時を設定します。
     * @param insDt 登録日時
     */
    public void setInsDt(String insDt) {
        this.insDt = insDt;
    }

    /**
     * 更新日時を取得します。
     * @return 更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 更新日時を設定します。
     * @param updDt 更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

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
     * 管理メモを取得します。
     * @return 管理メモ
     */
    public String getAdminNote() {
        return adminNote;
    }

    /**
     * 管理メモを設定します。
     * @param adminNote 管理メモ
     */
    public void setAdminNote(String adminNote) {
        this.adminNote = adminNote;
    }

	/**
	 * @return operUserId
	 */
	public String getOperUserId() {
		return operUserId;
	}

	/**
	 * @param operUserId セットする operUserId
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

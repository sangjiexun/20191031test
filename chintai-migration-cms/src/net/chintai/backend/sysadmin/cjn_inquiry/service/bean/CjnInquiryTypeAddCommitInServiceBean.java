/*
 * $Id: CjnInquiryTypeAddCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.bean;

/**
 * 問い合せ種別登録
 *
 * @author JavaBeans Code Generator
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeAddCommitInServiceBean {

    /** 問い合せタイトル */
    private String inqTitle;

    /** 問い合せ説明 */
    private String inqComment;

    /** 問い合せURL */
    private String inqUrl;

    /** 表示用タイトル */
    private String dispTitle;

    /** 表示用ソートキー */
    private int dispSortKey;

    /** 問い合せグループ */
    private String inqGroupType;

    /** 管理メモ */
    private String adminNote;

    /** 作業者ユーザID */
    private String operUserId;

    /** レコード登録プログラムID */
    private String pgName;

    /**
     * 問い合せタイトルを取得します。
     * @return 問い合せタイトル
     */
    public String getInqTitle() {
        return inqTitle;
    }

    /**
     * 問い合せタイトルを設定します。
     * @param inqTitle 問い合せタイトル
     */
    public void setInqTitle(String inqTitle) {
        this.inqTitle = inqTitle;
    }

    /**
     * 問い合せ説明を取得します。
     * @return 問い合せ説明
     */
    public String getInqComment() {
        return inqComment;
    }

    /**
     * 問い合せ説明を設定します。
     * @param inqComment 問い合せ説明
     */
    public void setInqComment(String inqComment) {
        this.inqComment = inqComment;
    }

    /**
     * 問い合せURLを取得します。
     * @return 問い合せURL
     */
    public String getInqUrl() {
        return inqUrl;
    }

    /**
     * 問い合せURLを設定します。
     * @param inqUrl 問い合せURL
     */
    public void setInqUrl(String inqUrl) {
        this.inqUrl = inqUrl;
    }

    /**
     * 表示用タイトルを取得します。
     * @return 表示用タイトル
     */
    public String getDispTitle() {
        return dispTitle;
    }

    /**
     * 表示用タイトルを設定します。
     * @param dispTitle 表示用タイトル
     */
    public void setDispTitle(String dispTitle) {
        this.dispTitle = dispTitle;
    }

    /**
     * 表示用ソートキーを取得します。
     * @return 表示用ソートキー
     */
    public int getDispSortKey() {
        return dispSortKey;
    }

    /**
     * 表示用ソートキーを設定します。
     * @param dispSortKey 表示用ソートキー
     */
    public void setDispSortKey(int dispSortKey) {
        this.dispSortKey = dispSortKey;
    }

    /**
     * 問い合せグループを取得します。
     * @return 問い合せグループ
     */
    public String getInqGroupType() {
        return inqGroupType;
    }

    /**
     * 問い合せグループを設定します。
     * @param inqGroupType 問い合せグループ
     */
    public void setInqGroupType(String inqGroupType) {
        this.inqGroupType = inqGroupType;
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

/*
 * $Id: CjnUserAvailabilityUpdateCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 2007/09/28  BGT)児島       実際のデータ構造に合わせて修正
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.bean;

import java.util.List;

/**
 * 閲覧可能ユーザ更新情報Bean。
 *
 * @author JavaBeans Code Generator
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAvailabilityUpdateCommitInServiceBean {

    /** 問い合せ種別シーケンス */
    private int cjnInqKindSeq;

    /** 前回のデータ参照時の最終更新日時 */
    private String lastUpdateTime;

    /** 更新者ユーザID */
    private String operUserId;

    /** レコード登録プログラムID */
    private String pgName;

    /**
     * 閲覧可能ユーザリスト(閲覧不可ユーザは含まない)<br>
     * ユーザのCHINTAI問い合せアカウントシーケンスを設定する。
     */
    private List<Integer> readableUsersSeqList;

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
     * 前回のデータ参照時の最終更新日時を取得します。
     * @return 前回のデータ参照時の最終更新日時
     */
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 前回のデータ参照時の最終更新日時を設定します。
     * @param lastUpdateTime 前回のデータ参照時の最終更新日時
     */
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 更新者ユーザIDを取得します。
     * @return 更新者ユーザID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 更新者ユーザIDを設定します。
     * @param operUserId 更新者ユーザID
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
    }

    /**
     * 閲覧可能ユーザリスト(閲覧不可ユーザは含まない)を取得します。
     * @return 閲覧可能ユーザリスト(閲覧不可ユーザは含まない)
     */
    public List<Integer> getReadableUsersSeqList() {
        return readableUsersSeqList;
    }

    /**
     * 閲覧可能ユーザリスト(閲覧不可ユーザは含まない)を設定します。
     * @param readableUsersSeqList 閲覧可能ユーザリスト(閲覧不可ユーザは含まない)
     */
    public void setReadableUsersSeqList(List<Integer> readableUsersSeqList) {
        this.readableUsersSeqList = readableUsersSeqList;
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

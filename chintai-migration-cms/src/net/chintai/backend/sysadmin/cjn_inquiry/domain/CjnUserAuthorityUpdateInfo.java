/*
 * $Id: CjnUserAuthorityUpdateInfo.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.domain;

/**
 * 問い合わせ閲覧可能権限取得したデータを格納するドメイン
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAuthorityUpdateInfo {

    /** 問い合わせタイトル */
    private String inqTitle;

    /** 問い合わせ説明 */
    private String inqComment;

    /** 閲覧可否カウンター */
    private int cnt;

    /** 問い合せマスタ識別シーケンス */
    private String cjnInqKindSeq;

    /**
     * 問い合わせ説明を取得します。
     * @return 問い合わせ説明
     */
    public String getInqComment() {
        return inqComment;
    }

    /**
     * 問い合わせ説明を設定します。
     * @param inqComment 問い合わせ説明
     */
    public void setInqComment(String inqComment) {
        this.inqComment = inqComment;
    }

    /**
     * 問い合わせタイトルを取得します。
     * @return 問い合わせタイトル
     */
    public String getInqTitle() {
        return inqTitle;
    }

    /**
     * 問い合わせタイトルを設定します。
     * @param inqTitle 問い合わせタイトル
     */
    public void setInqTitle(String inqTitle) {
        this.inqTitle = inqTitle;
    }

    /**
     * 閲覧可否カウンターを取得します。
     * @return 閲覧可否カウンター
     */
    public int getCnt() {
        return cnt;
    }

    /**
     * 閲覧可否カウンターを設定します。
     * @param cnt 閲覧可否カウンター
     */
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    /**
     * 問い合せマスタ識別シーケンスを取得します。
     * @return 問い合せマスタ識別シーケンス
     */
    public String getCjnInqKindSeq() {
        return cjnInqKindSeq;
    }

    /**
     * 問い合せマスタ識別シーケンスを設定します。
     * @param cjnInqKindSeq 問い合せマスタ識別シーケンス
     */
    public void setCjnInqKindSeq(String cjnInqKindSeq) {
        this.cjnInqKindSeq = cjnInqKindSeq;
    }
}

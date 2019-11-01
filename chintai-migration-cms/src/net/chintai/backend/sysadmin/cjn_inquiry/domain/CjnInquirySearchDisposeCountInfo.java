/*
 * $Id: CjnInquirySearchDisposeCountInfo.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.domain;

/**
 * 問い合せ検索(処理件数)Bean
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquirySearchDisposeCountInfo {

    /** 総件数 */
    private String totalCount;

    /** 未読件数 */
    private String noReadCount;

    /** 未処理件数 */
    private String noShoriCount;

    /** 問い合せシーケンス */
    private int cjnInqKindSeq;

    /**
     * 総件数を取得します。
     * @return 総件数
     */
    public String getTotalCount() {
        return totalCount;
    }

    /**
     * 総件数を設定します。
     * @param totalCount 総件数
     */
    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 未読件数を取得します。
     * @return 未読件数
     */
    public String getNoReadCount() {
        return noReadCount;
    }

    /**
     * 未読件数を設定します。
     * @param noReadCount 未読件数
     */
    public void setNoReadCount(String noReadCount) {
        this.noReadCount = noReadCount;
    }

    /**
     * 総件数を取得します。
     * @return noShoriCount
     */
    public String getNoShoriCount() {
        return noShoriCount;
    }

    /**
     * 総件数を設定します。
     * @param noShoriCount
     */
    public void setNoShoriCount(String noShoriCount) {
        this.noShoriCount = noShoriCount;
    }

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

}

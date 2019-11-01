/*
 * $Id: CjnInquirySearchDisposeCountOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.bean;

/**
 * 問い合せ処理件数情報
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquirySearchDisposeCountOutServiceBean {

    /** 総件数 */
    private String totalCount;

    /** 未読件数 */
    private String noReadCount;

    /** 処理件数 */
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
     * 処理件数を取得します。
     * @return 処理件数
     */
    public String getNoShoriCount() {
        return noShoriCount;
    }

    /**
     * 処理件数を設定します。
     * @param noShoriCount 処理件数
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

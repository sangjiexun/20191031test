/*
 * $Id: CjnUserAuthorityUpdatePageOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.bean;

/**
 * 閲覧可能問い合せ権限情報
 * 
 * @author JavaBeans Code Generator
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAuthorityUpdatePageOutServiceBean {

    /** 問い合せタイトル */
    private String inqTitle;

    /** 問い合せ説明 */
    private String inqComment;

    /** 問い合せ件数 */
    private int cnt;

    /** 問い合せマスタシーケンス */
    private int cjnInqKindSeq;

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
     * 問い合せ件数を取得します。
     * @return 問い合せ件数
     */
    public int getCnt() {
        return cnt;
    }

    /**
     * 問い合せ件数を設定します。
     * @param cnt 問い合せ件数
     */
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    /**
     * 問い合せマスタシーケンスを取得します。
     * @return 問い合せマスタシーケンス
     */
    public int getCjnInqKindSeq() {
        return cjnInqKindSeq;
    }

    /**
     * 問い合せマスタシーケンスを設定します。
     * @param cjnInqKindSeq 問い合せマスタシーケンス
     */
    public void setCjnInqKindSeq(int cjnInqKindSeq) {
        this.cjnInqKindSeq = cjnInqKindSeq;
    }

}

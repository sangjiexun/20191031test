/*
 * $Id: InquiryDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/07  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.common.tags.domain;

/**
 * お問合せ種別プルダウン中身作成用
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryDomain {

    /** 問い合せマスタ識別シーケンス */
    private String inqKindSeq;

    /** タイトル */
    private String inqTitle;

    /**
     * 問い合せマスタ識別シーケンスを取得します。
     * @return 問い合せマスタ識別シーケンス
     */
    public String getInqKindSeq() {
        return inqKindSeq;
    }

    /**
     * 問い合せマスタ識別シーケンスを設定します。
     * @param inqKindSeq 問い合せマスタ識別シーケンス
     */
    public void setInqKindSeq(String inqKindSeq) {
        this.inqKindSeq = inqKindSeq;
    }

    /**
     * タイトルを取得します。
     * @return タイトル
     */
    public String getInqTitle() {
        return inqTitle;
    }

    /**
     * タイトルを設定します。
     * @param inqTitle タイトル
     */
    public void setInqTitle(String inqTitle) {
        this.inqTitle = inqTitle;
    }

}

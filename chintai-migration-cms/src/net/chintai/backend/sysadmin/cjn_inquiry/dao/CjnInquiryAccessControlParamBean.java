/*
 * $Id: CjnInquiryAccessControlParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/11/04   BGT)児島      新規作成
 * 
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

/**
 * 問い合せ画面アクセスコントロール判定情報取得用パラメータ
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryAccessControlParamBean {

    /** 問い合せ種別シーケンス */
    private int cjnInqKindSeq;

    /** ユーザID */
    private String userId;

    /** 問い合せID */
    private String cjnInqId;

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
     * 問い合せIDを取得します。
     * @return 問い合せID
     */
    public String getCjnInqId() {
        return cjnInqId;
    }

    /**
     * 問い合せIDを設定します。
     * @param cjnInqId 問い合せID
     */
    public void setCjnInqId(String cjnInqId) {
        this.cjnInqId = cjnInqId;
    }
}

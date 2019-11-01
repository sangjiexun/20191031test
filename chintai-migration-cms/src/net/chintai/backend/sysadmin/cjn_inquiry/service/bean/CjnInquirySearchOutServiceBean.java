/*
 * $Id: CjnInquirySearchOutServiceBean.java 3990 2008-07-14 11:31:11Z s-sugimoto $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 2007/09/29  BGT)児島       DB設計書に合わせて修正
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.bean;

/**
 * 問い合せ検索結果を格納するBean。
 * 
 * @author JavaBeans Code Generator
 * @author KOJIMA Takanori
 * @author s-sugimoto
 * @version $Revision: 3990 $
 * @version 2008.07.10 雑誌・ザガットクレジット対応のため、property追加<br>
 * @version 2008.07.14 汎化した抽象クラスを継承するように変更した<br>
 *          Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquirySearchOutServiceBean extends AbstractCjnInquiryBaseServiceBean {

    // /** 問い合せID */
    // private String cjnInqId;
    //
    // /** 問い合せ日時 */
    // private String insDt;
    //
    // /** 最終閲覧日時 */
    // private String lastRefDt;
    //
    // /** 最終閲覧ユーザ */
    // private String lastRefUser;
    //
    // /** 処理状況 */
    // private String inquiryStatus;
    //
    // /** 最終処理日時 */
    // private String lastOpeDt;
    //
    // /** 最終処理者ユーザ */
    // private String lastOpeUser;
    //
    // /** 最終更新日時 */
    // private String updDt;
    //
    // /** 閲覧状況 */
    // private String refFlg;
    //
    // /** 問い合せシーケンス */
    // private int cjnInqKindSeq;

    /** CHINTAIアカウントシーケンス */
    private String cjnAccountSeq;

    // /**
    // * PC・モバイル区分
    // * @since 2008.07.10 雑誌・ザガットクレジット対応
    // */
    // private String mobileKbn;
    //
    // /**
    // * 伝票番号
    // * @since 2008.07.10 雑誌・ザガットクレジット対応
    // */
    // private String fregiDenpyoNo;
    //
    // /**
    // * 取引番号
    // * @since 2008.07.10 雑誌・ザガットクレジット対応
    // */
    // private String fregiTorihikiNo;

    // /**
    // * PC・モバイル区分を取得します。
    // * @return
    // * @since 2008.07.10 雑誌・ザガットクレジット対応
    // */
    // public String getMobileKbn() {
    // return mobileKbn;
    // }
    //
    // /**
    // * PC・モバイル区分を設定します。
    // * @param mobileKbn
    // * @since 2008.07.10 雑誌・ザガットクレジット対応
    // */
    // public void setMobileKbn(String mobileKbn) {
    // this.mobileKbn = mobileKbn;
    // }
    //
    // /**
    // * 伝票番号を取得します。
    // * @return
    // * @since 2008.07.10 雑誌・ザガットクレジット対応
    // */
    // public String getFregiDenpyoNo() {
    // return fregiDenpyoNo;
    // }
    //
    // /**
    // * 伝票番号を設定します。
    // * @param fregiDenpyoNo
    // * @since 2008.07.10 雑誌・ザガットクレジット対応
    // */
    // public void setFregiDenpyoNo(String fregiDenpyoNo) {
    // this.fregiDenpyoNo = fregiDenpyoNo;
    // }
    //
    // /**
    // * 取引番号を取得します。
    // * @return
    // * @since 2008.07.10 雑誌・ザガットクレジット対応
    // */
    // public String getFregiTorihikiNo() {
    // return fregiTorihikiNo;
    // }
    //
    // /**
    // * 取引番号を設定します。
    // * @param fregiTorihikiNo
    // * @since 2008.07.10 雑誌・ザガットクレジット対応
    // */
    // public void setFregiTorihikiNo(String fregiTorihikiNo) {
    // this.fregiTorihikiNo = fregiTorihikiNo;
    // }

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

    // /**
    // * 問い合せIDを取得します。
    // * @return 問い合せID
    // */
    // public String getCjnInqId() {
    // return cjnInqId;
    // }
    //
    // /**
    // * 問い合せIDを設定します。
    // * @param cjnInqId 問い合せID
    // */
    // public void setCjnInqId(String cjnInqId) {
    // this.cjnInqId = cjnInqId;
    // }
    //
    // /**
    // * 問い合せ日時を取得します。
    // * @return 問い合せ日時
    // */
    // public String getInsDt() {
    // return insDt;
    // }
    //
    // /**
    // * 問い合せ日時を設定します。
    // * @param insDt 問い合せ日時
    // */
    // public void setInsDt(String insDt) {
    // this.insDt = insDt;
    // }
    //
    // /**
    // * 最終閲覧日時を取得します。
    // * @return 最終閲覧日時
    // */
    // public String getLastRefDt() {
    // return lastRefDt;
    // }
    //
    // /**
    // * 最終閲覧日時を設定します。
    // * @param lastRefDt 最終閲覧日時
    // */
    // public void setLastRefDt(String lastRefDt) {
    // this.lastRefDt = lastRefDt;
    // }
    //
    // /**
    // * 最終閲覧ユーザを取得します。
    // * @return 最終閲覧ユーザ
    // */
    // public String getLastRefUser() {
    // return lastRefUser;
    // }
    //
    // /**
    // * 最終閲覧ユーザを設定します。
    // * @param lastRefUser 最終閲覧ユーザ
    // */
    // public void setLastRefUser(String lastRefUser) {
    // this.lastRefUser = lastRefUser;
    // }
    //
    // /**
    // * 処理状況を取得します。
    // * @return 処理状況
    // */
    // public String getInquiryStatus() {
    // return inquiryStatus;
    // }
    //
    // /**
    // * 処理状況を設定します。
    // * @param inquiryStatus 処理状況
    // */
    // public void setInquiryStatus(String inquiryStatus) {
    // this.inquiryStatus = inquiryStatus;
    // }
    //
    // /**
    // * 最終処理日時を取得します。
    // * @return 最終処理日時
    // */
    // public String getLastOpeDt() {
    // return lastOpeDt;
    // }
    //
    // /**
    // * 最終処理日時を設定します。
    // * @param lastOpeDt 最終処理日時
    // */
    // public void setLastOpeDt(String lastOpeDt) {
    // this.lastOpeDt = lastOpeDt;
    // }
    //
    // /**
    // * 最終処理者ユーザを取得します。
    // * @return 最終処理者ユーザ
    // */
    // public String getLastOpeUser() {
    // return lastOpeUser;
    // }
    //
    // /**
    // * 最終処理者ユーザを設定します。
    // * @param lastOpeUser 最終処理者ユーザ
    // */
    // public void setLastOpeUser(String lastOpeUser) {
    // this.lastOpeUser = lastOpeUser;
    // }
    //
    // /**
    // * 最終更新日時を取得します。
    // * @return 最終更新日時
    // */
    // public String getUpdDt() {
    // return updDt;
    // }
    //
    // /**
    // * 最終更新日時を設定します。
    // * @param updDt 最終更新日時
    // */
    // public void setUpdDt(String updDt) {
    // this.updDt = updDt;
    // }
    //
    // /**
    // * 閲覧状況を取得します。
    // * @return 閲覧状況
    // */
    // public String getRefFlg() {
    // return refFlg;
    // }
    //
    // /**
    // * 閲覧状況を設定します。
    // * @param refFlg 閲覧状況
    // */
    // public void setRefFlg(String refFlg) {
    // this.refFlg = refFlg;
    // }
    //
    // /**
    // * 問い合せシーケンスを取得します。
    // * @return 問い合せシーケンス
    // */
    // public int getCjnInqKindSeq() {
    // return cjnInqKindSeq;
    // }
    //
    // /**
    // * 問い合せシーケンスを設定します。
    // * @param cjnInqKindSeq 問い合せシーケンス
    // */
    // public void setCjnInqKindSeq(int cjnInqKindSeq) {
    // this.cjnInqKindSeq = cjnInqKindSeq;
    // }

}

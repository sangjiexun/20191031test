/*
 * $Id: CjnInquiryStatusUpdateView.java 3987 2008-07-14 11:25:27Z s-sugimoto $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action.view;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 問い合せ変更情報
 * 
 * @author JavaBeans Code Generator
 * @author s-sugimoto
 * @version $Revision: 3987 $
 * @version 2008.07.11 雑誌・ザガット対応のproperty追加 <br>
 *          CjnInquiryInfoView.java<br>
 *          CjnInquirySearchListViewのインナークラスCjnInquirySearchListDetailView<br>
 *          は同じpropertyをもつので共通部分を抜粋したAbstractクラスなどを使いたいところ。<br>
 * @version 2008.07.14 汎化した抽象クラスを継承するように変更した<br>
 * 
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryStatusUpdateView extends AbstractCjnInquiryBaseView implements ViewHelper {

    // /** 問い合せシーケンス */
    // private int cjnInqKindSeq;
    //
    // /** 問い合せ日時 */
    // private String insDt;
    //
    // /** 問い合せID */
    // private String cjnInqId;
    //
    // /** 閲覧状況 */
    // private String refFlg;
    //
    // /** 処理状況 */
    // private String inquiryStatus;
    //
    // /** 最終閲覧ユーザ */
    // private String lastRefUser;
    //
    // /** 最終処理ユーザ */
    // private String lastOpeUser;
    //
    // /** 最終処理日時 */
    // private String updDt;
    //
    // /** 最終閲覧日時 */
    // private String lastRefDt;
    //
    // /** 最終処理日時 */
    // private String lastOpeDt;
    //
    // /** 問い合せ内容1 */
    // private String inqContents1;
    //
    // /** 問い合せ内容2 */
    // private String inqContents2;
    //
    // /** 問い合せ内容3 */
    // private String inqContents3;
    //
    // /** 問い合せ内容4 */
    // private String inqContents4;
    //
    // /** 問い合せ内容5 */
    // private String inqContents5;
    //
    // /** 問い合せ内容6 */
    // private String inqContents6;
    //
    // /** 問い合せ内容7 */
    // private String inqContents7;
    //
    // /** 問い合せ内容8 */
    // private String inqContents8;
    //
    // /** 問い合せ内容9 */
    // private String inqContents9;
    //
    // /** 問い合せ内容10 */
    // private String inqContents10;
    //
    // /** 問い合せ内容結合 */
    // private String inqContents;
    //
    // /** 現在位置 */
    // private int offSet;
    //
    // /**
    // * PC・モバイル区分
    // * @since 2008.07.11 雑誌・ザガットクレジット対応
    // */
    // private String mobileKbn;
    //
    // /**
    // * 伝票番号
    // * @since 2008.07.11 雑誌・ザガットクレジット対応
    // */
    // private String fregiDenpyoNo;
    //
    // /**
    // * 取引番号
    // * @since 2008.07.11 雑誌・ザガットクレジット対応
    // */
    // private String fregiTorihikiNo;
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
    // * 問い合せ内容1を取得します。
    // * @return 問い合せ内容1
    // */
    // public String getInqContents1() {
    // return inqContents1;
    // }
    //
    // /**
    // * 問い合せ内容1を設定します。
    // * @param inqContents1 問い合せ内容1
    // */
    // public void setInqContents1(String inqContents1) {
    // this.inqContents1 = inqContents1;
    // }
    //
    // /**
    // * 問い合せ内容2を取得します。
    // * @return 問い合せ内容2
    // */
    // public String getInqContents2() {
    // return inqContents2;
    // }
    //
    // /**
    // * 問い合せ内容2を設定します。
    // * @param inqContents2 問い合せ内容2
    // */
    // public void setInqContents2(String inqContents2) {
    // this.inqContents2 = inqContents2;
    // }
    //
    // /**
    // * 問い合せ内容3を取得します。
    // * @return 問い合せ内容3
    // */
    // public String getInqContents3() {
    // return inqContents3;
    // }
    //
    // /**
    // * 問い合せ内容3を設定します。
    // * @param inqContents3 問い合せ内容3
    // */
    // public void setInqContents3(String inqContents3) {
    // this.inqContents3 = inqContents3;
    // }
    //
    // /**
    // * 問い合せ内容4を取得します。
    // * @return 問い合せ内容4
    // */
    // public String getInqContents4() {
    // return inqContents4;
    // }
    //
    // /**
    // * 問い合せ内容4を設定します。
    // * @param inqContents4 問い合せ内容4
    // */
    // public void setInqContents4(String inqContents4) {
    // this.inqContents4 = inqContents4;
    // }
    //
    // /**
    // * 問い合せ内容5を取得します。
    // * @return 問い合せ内容5
    // */
    // public String getInqContents5() {
    // return inqContents5;
    // }
    //
    // /**
    // * 問い合せ内容5を設定します。
    // * @param inqContents5 問い合せ内容5
    // */
    // public void setInqContents5(String inqContents5) {
    // this.inqContents5 = inqContents5;
    // }
    //
    // /**
    // * 問い合せ内容6を取得します。
    // * @return 問い合せ内容6
    // */
    // public String getInqContents6() {
    // return inqContents6;
    // }
    //
    // /**
    // * 問い合せ内容6を設定します。
    // * @param inqContents6 問い合せ内容6
    // */
    // public void setInqContents6(String inqContents6) {
    // this.inqContents6 = inqContents6;
    // }
    //
    // /**
    // * 問い合せ内容7を取得します。
    // * @return 問い合せ内容7
    // */
    // public String getInqContents7() {
    // return inqContents7;
    // }
    //
    // /**
    // * 問い合せ内容7を設定します。
    // * @param inqContents7 問い合せ内容7
    // */
    // public void setInqContents7(String inqContents7) {
    // this.inqContents7 = inqContents7;
    // }
    //
    // /**
    // * 問い合せ内容8を取得します。
    // * @return 問い合せ内容8
    // */
    // public String getInqContents8() {
    // return inqContents8;
    // }
    //
    // /**
    // * 問い合せ内容8を設定します。
    // * @param inqContents8 問い合せ内容8
    // */
    // public void setInqContents8(String inqContents8) {
    // this.inqContents8 = inqContents8;
    // }
    //
    // /**
    // * 問い合せ内容9を取得します。
    // * @return 問い合せ内容9
    // */
    // public String getInqContents9() {
    // return inqContents9;
    // }
    //
    // /**
    // * 問い合せ内容9を設定します。
    // * @param inqContents9 問い合せ内容9
    // */
    // public void setInqContents9(String inqContents9) {
    // this.inqContents9 = inqContents9;
    // }
    //
    // /**
    // * 問い合せ内容10を設定します。
    // * @return inqContents10
    // */
    // public String getInqContents10() {
    // return inqContents10;
    // }
    //
    // /**
    // * 問い合せ内容10を取得します。
    // * @param inqContents10
    // */
    // public void setInqContents10(String inqContents10) {
    // this.inqContents10 = inqContents10;
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
    // * 最終処理ユーザを取得します。
    // * @return 最終処理ユーザ
    // */
    // public String getLastOpeUser() {
    // return lastOpeUser;
    // }
    //
    // /**
    // * 最終処理ユーザを設定します。
    // * @param lastOpeUser 最終処理ユーザ
    // */
    // public void setLastOpeUser(String lastOpeUser) {
    // this.lastOpeUser = lastOpeUser;
    // }
    //
    // /**
    // * 最終更新日時を設定します。
    // * @return updDt
    // */
    // public String getUpdDt() {
    // return updDt;
    // }
    //
    // /**
    // * 最終更新日時を取得します。
    // * @param updDt
    // */
    // public void setUpdDt(String updDt) {
    // this.updDt = updDt;
    // }
    //
    // /**
    // * 問い合せ内容結合を取得します。
    // * @return 問い合せ内容結合
    // */
    // public String getInqContents() {
    // return inqContents;
    // }
    //
    // /**
    // * 問い合せ内容結合を設定します。
    // * @param inqContents 問い合せ内容結合
    // */
    // public void setInqContents(String inqContents) {
    // this.inqContents = inqContents;
    // }
    //
    // /**
    // * 現在位置を取得します。
    // * @return 現在位置
    // */
    // public int getOffSet() {
    // return offSet;
    // }
    //
    // /**
    // * 現在位置を設定します。
    // * @param offSet 現在位置
    // */
    // public void setOffSet(int offSet) {
    // this.offSet = offSet;
    // }
    //
    // /**
    // * PC・モバイル区分を取得します。
    // * @return
    // * @since 2008.07.11 雑誌・ザガットクレジット対応
    // */
    // public String getMobileKbn() {
    // return mobileKbn;
    // }
    //
    // /**
    // * PC・モバイル区分を設定します。
    // * @param mobileKbn
    // * @since 2008.07.11 雑誌・ザガットクレジット対応
    // */
    // public void setMobileKbn(String mobileKbn) {
    // this.mobileKbn = mobileKbn;
    // }
    //
    // /**
    // * 伝票番号を取得します。
    // * @return
    // * @since 2008.07.11 雑誌・ザガットクレジット対応
    // */
    // public String getFregiDenpyoNo() {
    // return fregiDenpyoNo;
    // }
    //
    // /**
    // * 伝票番号を設定します。
    // * @param fregiDenpyoNo
    // * @since 2008.07.11 雑誌・ザガットクレジット対応
    // */
    // public void setFregiDenpyoNo(String fregiDenpyoNo) {
    // this.fregiDenpyoNo = fregiDenpyoNo;
    // }
    //
    // /**
    // * 取引番号を取得します。
    // * @return
    // * @since 2008.07.11 雑誌・ザガットクレジット対応
    // */
    // public String getFregiTorihikiNo() {
    // return fregiTorihikiNo;
    // }
    //
    // /**
    // * 取引番号を設定します。
    // * @param fregiTorihikiNo
    // * @since 2008.07.11 雑誌・ザガットクレジット対応
    // */
    // public void setFregiTorihikiNo(String fregiTorihikiNo) {
    // this.fregiTorihikiNo = fregiTorihikiNo;
    // }
}

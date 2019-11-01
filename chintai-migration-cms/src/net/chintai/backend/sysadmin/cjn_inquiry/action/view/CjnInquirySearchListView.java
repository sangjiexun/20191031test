/*
 * $Id: CjnInquirySearchListView.java 3987 2008-07-14 11:25:27Z s-sugimoto $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/10/09   BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.PagerCondition;
import net.chintai.backend.sysadmin.common.pager.PagerViewHelper;

/**
 * 問い合せ検索結果ViewHelper。
 *
 * @author Yang-EunMi
 * @author s-sugimoto
 * @version $Revision: 3987 $
 * @version 2008.07.10 雑誌・ザガットクレジット対応のため、property追加<br>
 * @version 2008.07.14 汎化した抽象クラスを継承するように変更した<br>
 *          Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquirySearchListView extends PagerViewHelper {

    /**
     * コンストラクター
     * @param condition ページング情報
     */
    public CjnInquirySearchListView(PagerCondition condition) {
        super(condition);
    }

    /** 問い合せ結果リスト */
    private List<CjnInquirySearchListDetailView> inquirySearchList;

    /** 総件数 */
    private String totalCount;

    /** 未読件数 */
    private String noReadCount;

    /** 未処理件数 */
    private String noShoriCount;

    /** 問い合せシーケンス */
    private int cjnInqKindSeq;

    /** 問い合せID */
    private String cjnInqId;

    /** キーワード */
    private String keywords;

    /** AND-OR */
    private String modeAndOr;

    /** 閲覧状況 */
    private String refFlg;

    /** 処理状況 */
    private String inquiryStatus;

    /** 問い合せ年月日時（下限） */
    private String insDateFromSearch;

    /** 問い合せ年月日時（上限） */
    private String insDateToSearch;

    /** 問い合せ年（下限） */
    private String insDtFromYear;

    /** 問い合せ月（下限） */
    private String insDtFromMonth;

    /** 問い合せ日（下限） */
    private String insDtFromDay;

    /** 問い合せ時（下限） */
    private String insDtFromTime;

    /** 問い合せ年（上限） */
    private String insDtToYear;

    /** 問い合せ月（上限） */
    private String insDtToMonth;

    /** 問い合せ日（上限） */
    private String insDtToDay;

    /** 問い合せ時（上限） */
    private String insDtToTime;

    /** ソートキー */
    private String sortKey;

    /** 順序 */
    private String orderBy;

    /** 表示件数 */
    private int displayNum;

    /**
     * PCモバイル区分
     * @since 2008.07.09
     */
    private String pcMobileStatus;

    /**
     * 伝票番号
     * @since 2008.07.09
     */
    private String slipNumber;

    /**
     * 取引番号
     * @since 2008.07.09
     */
    private String dealNumber;

    /**
     * PCモバイル区分を取得します。
     * @since 2008.07.09
     * @return PCモバイル区分
     */
    public String getPcMobileStatus() {
        return pcMobileStatus;
    }

    /**
     * PCモバイル区分を設定します。
     * @since 2008.07.09
     * @param pcMobileStatus PCモバイル区分
     */
    public void setPcMobileStatus(String pcMobileStatus) {
        this.pcMobileStatus = pcMobileStatus;
    }

    /**
     * 伝票番号を取得します。
     * @since 2008.07.09
     * @return 伝票番号
     */
    public String getSlipNumber() {
        return slipNumber;
    }

    /**
     * 伝票番号
     * @since 2008.07.09
     * @param slipNumber 伝票番号
     */
    public void setSlipNumber(String slipNumber) {
        this.slipNumber = slipNumber;
    }

    /**
     * 取引番号を取得します。
     * @since 2008.07.09
     * @return 取引番号
     */
    public String getDealNumber() {
        return dealNumber;
    }

    /**
     * 取引番号を設定します。
     * @since 2008.07.09
     * @param dealNumber
     */
    public void setDealNumber(String dealNumber) {
        this.dealNumber = dealNumber;
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

    /**
     * 問い合せ日（下限）を取得します。
     * @return 問い合せ日（下限）
     */
    public String getInsDtFromDay() {
        return insDtFromDay;
    }

    /**
     * 問い合せ日（下限）を設定します。
     * @param insDtFromDay 問い合せ日（下限）
     */
    public void setInsDtFromDay(String insDtFromDay) {
        this.insDtFromDay = insDtFromDay;
    }

    /**
     * 問い合せ月（下限）を取得します。
     * @return 問い合せ月（下限）
     */
    public String getInsDtFromMonth() {
        return insDtFromMonth;
    }

    /**
     * 問い合せ月（下限）を設定します。
     * @param insDtFromMonth 問い合せ月（下限）
     */
    public void setInsDtFromMonth(String insDtFromMonth) {
        this.insDtFromMonth = insDtFromMonth;
    }

    /**
     * 問い合せ時（下限）を取得します。
     * @return 問い合せ時（下限）
     */
    public String getInsDtFromTime() {
        return insDtFromTime;
    }

    /**
     * 問い合せ時（下限）を設定します。
     * @param insDtFromTime 問い合せ時（下限）
     */
    public void setInsDtFromTime(String insDtFromTime) {
        this.insDtFromTime = insDtFromTime;
    }

    /**
     * 問い合せ年（下限）を取得します。
     * @return 問い合せ年（下限）
     */
    public String getInsDtFromYear() {
        return insDtFromYear;
    }

    /**
     * 問い合せ年（下限）を設定します。
     * @param insDtFromYear 問い合せ年（下限）
     */
    public void setInsDtFromYear(String insDtFromYear) {
        this.insDtFromYear = insDtFromYear;
    }

    /**
     * 問い合せ日（上限）を取得します。
     * @return 問い合せ日（上限）
     */
    public String getInsDtToDay() {
        return insDtToDay;
    }

    /**
     * 問い合せ日（上限）を設定します。
     * @param insDtToDay 問い合せ日（上限）
     */
    public void setInsDtToDay(String insDtToDay) {
        this.insDtToDay = insDtToDay;
    }

    /**
     * 問い合せ月（上限）を取得します。
     * @return 問い合せ月（上限）
     */
    public String getInsDtToMonth() {
        return insDtToMonth;
    }

    /**
     * 問い合せ月（上限）を設定します。
     * @param insDtToMonth 問い合せ月（上限）
     */
    public void setInsDtToMonth(String insDtToMonth) {
        this.insDtToMonth = insDtToMonth;
    }

    /**
     * 問い合せ時（上限）を取得します。
     * @return 問い合せ時（上限）
     */
    public String getInsDtToTime() {
        return insDtToTime;
    }

    /**
     * 問い合せ時（上限）を設定します。
     * @param insDtToTime 問い合せ時（上限）
     */
    public void setInsDtToTime(String insDtToTime) {
        this.insDtToTime = insDtToTime;
    }

    /**
     * 問い合せ年（上限）を取得します。
     * @return 問い合せ年（上限）
     */
    public String getInsDtToYear() {
        return insDtToYear;
    }

    /**
     * 問い合せ年（上限）を設定します。
     * @param insDtToYear 問い合せ年（上限）
     */
    public void setInsDtToYear(String insDtToYear) {
        this.insDtToYear = insDtToYear;
    }

    /**
     * AND-ORを取得します。
     * @return AND-OR
     */
    public String getModeAndOr() {
        return modeAndOr;
    }

    /**
     * AND-ORを設定します。
     * @param modeAndOr AND-OR
     */
    public void setModeAndOr(String modeAndOr) {
        this.modeAndOr = modeAndOr;
    }

    /**
     * 閲覧状況を取得します。
     * @return 閲覧状況
     */
    public String getRefFlg() {
        return refFlg;
    }

    /**
     * 閲覧状況を設定します。
     * @param refFlg 閲覧状況
     */
    public void setRefFlg(String refFlg) {
        this.refFlg = refFlg;
    }

    /**
     * 処理状況を取得します。
     * @return 処理状況
     */
    public String getInquiryStatus() {
        return inquiryStatus;
    }

    /**
     * 処理状況を設定します。
     * @param inquiryStatus 処理状況
     */
    public void setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }

    /**
     * 問い合せ年月日時（下限）を取得します。
     * @return 問い合せ年月日時（下限）
     */
    public String getInsDateFromSearch() {
        return insDateFromSearch;
    }

    /**
     * 問い合せ年月日時（下限）を設定します。
     * @param insDateFromSearch 問い合せ年月日時（下限）
     */
    public void setInsDateFromSearch(String insDateFromSearch) {
        this.insDateFromSearch = insDateFromSearch;
    }

    /**
     * 問い合せ年月日時（上限）を取得します。
     * @return 問い合せ年月日時（上限）
     */
    public String getInsDateToSearch() {
        return insDateToSearch;
    }

    /**
     * 問い合せ年月日時（上限）を設定します。
     * @param insDateToSearch 問い合せ年月日時（上限）
     */
    public void setInsDateToSearch(String insDateToSearch) {
        this.insDateToSearch = insDateToSearch;
    }

    /**
     * ソートキーを取得します。
     * @return ソートキー
     */
    public String getSortKey() {
        return sortKey;
    }

    /**
     * ソートキーを設定します。
     * @param sortKey ソートキー
     */
    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    /**
     * 順序を取得します。
     * @return 順序
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 順序を設定します。
     * @param orderBy 順序
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * 表示件数を取得します。
     * @return 表示件数
     */
    public int getDisplayNum() {
        return displayNum;
    }

    /**
     * 表示件数を設定します。
     * @param displayNum 表示件数
     */
    public void setDisplayNum(int displayNum) {
        this.displayNum = displayNum;
    }

    /**
     * キーワードを取得します。
     * @return キーワード
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * キーワードを設定します。
     * @param keywords キーワード
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

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
     * 未処理件数を取得します。
     * @return 未処理件数
     */
    public String getNoShoriCount() {
        return noShoriCount;
    }

    /**
     * 未処理件数を設定します。
     * @param noShoriCount 未処理件数
     */
    public void setNoShoriCount(String noShoriCount) {
        this.noShoriCount = noShoriCount;
    }

    /**
     * 問い合せ結果リストを取得します。
     * @return 問い合せ結果リスト
     */
    public List<CjnInquirySearchListDetailView> getInquirySearchList() {
        return inquirySearchList;
    }

    /**
     * 問い合せ結果リストを設定します。
     * @param inquirySearchList 問い合せ結果リスト
     */
    public void setInquirySearchList(List<CjnInquirySearchListDetailView> inquirySearchList) {
        this.inquirySearchList = inquirySearchList;
    }

    /**
     * 問い合せ結果リストを表現するインナークラス
     *
     * @author Yang-EunMi
     * @author s-sugimoto
     * @version 2008.07.10 雑誌・ザガットクレジット対応
     * @version 2008.07.14 汎化した抽象クラスを継承するように変更
     */
    public class CjnInquirySearchListDetailView extends AbstractCjnInquiryBaseView {

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
        // /** 閲覧状況 */
        // private String refFlg;
        //
        // /** 処理状況 */
        // private String inquiryStatus;
        //
        // /** 最終処理日時 */
        // private String lastOpeDt;
        //
        // /** 最終処理ユーザ */
        // private String lastOpeUser;
        //
        // /** 最終更新日時 */
        // private String updDt;
        //
        // /** 問い合せシーケンス */
        // private int cjnInqKindSeq;
        //
        // /** 現在位置 */
        // private int offSet;

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
        //
        /**
         * CHINTAIアカウントシーケンスを設定します。
         * @return cjnAccountSeq
         */
        public String getCjnAccountSeq() {
            return cjnAccountSeq;
        }

        //
        /**
         * CHINTAIアカウントシーケンスを取得します。
         * @param cjnAccountSeq
         */
        public void setCjnAccountSeq(String cjnAccountSeq) {
            this.cjnAccountSeq = cjnAccountSeq;
        }
        //
        // /**
        // * 現在位置を設定します。
        // * @return offSet 現在位置
        // */
        // public int getOffSet() {
        // return offSet;
        // }
        //
        // /**
        // * 現在位置を取得します。
        // * @param offSet 現在位置
        // */
        // public void setOffSet(int offSet) {
        // this.offSet = offSet;
        // }
        //
        // /**
        // * 処理状況を設定します。
        // * @return inquiryStatus
        // */
        // public String getInquiryStatus() {
        // return inquiryStatus;
        // }
        //
        // /**
        // * 処理状況を取得します。
        // * @param inquiryStatus
        // */
        // public void setInquiryStatus(String inquiryStatus) {
        // this.inquiryStatus = inquiryStatus;
        // }
        //
        // /**
        // * 問い合せ日時を設定します。
        // * @return insDt
        // */
        // public String getInsDt() {
        // return insDt;
        // }
        //
        // /**
        // * 問い合せ日時を取得します。
        // * @param insDt
        // */
        // public void setInsDt(String insDt) {
        // this.insDt = insDt;
        // }
        //
        // /**
        // * 最終処理日時を設定します。
        // * @return lastOpeDt
        // */
        // public String getLastOpeDt() {
        // return lastOpeDt;
        // }
        //
        // /**
        // * 最終処理日時を取得します。
        // * @param lastOpeDt
        // */
        // public void setLastOpeDt(String lastOpeDt) {
        // this.lastOpeDt = lastOpeDt;
        // }
        //
        // /**
        // * 最終処理ユーザを設定します。
        // * @return lastOpeUser
        // */
        // public String getLastOpeUser() {
        // return lastOpeUser;
        // }
        //
        // /**
        // * 最終処理ユーザを取得します。
        // * @param lastOpeUser
        // */
        // public void setLastOpeUser(String lastOpeUser) {
        // this.lastOpeUser = lastOpeUser;
        // }
        //
        // /**
        // * 最終閲覧日時を設定します。
        // * @return lastRefDt
        // */
        // public String getLastRefDt() {
        // return lastRefDt;
        // }
        //
        // /**
        // * 最終閲覧日時を取得します。
        // * @param lastRefDt
        // */
        // public void setLastRefDt(String lastRefDt) {
        // this.lastRefDt = lastRefDt;
        // }
        //
        // /**
        // * 閲覧状況を設定します。
        // * @return refFlg
        // */
        // public String getRefFlg() {
        // return refFlg;
        // }
        //
        // /**
        // * 閲覧状況を取得します。
        // * @param refFlg
        // */
        // public void setRefFlg(String refFlg) {
        // this.refFlg = refFlg;
        // }
        //
        // /**
        // * 最終閲覧ユーザを設定します。
        // * @return lastRefUser
        // */
        // public String getLastRefUser() {
        // return lastRefUser;
        // }
        //
        // /**
        // * 最終閲覧ユーザを取得します。
        // * @param lastRefUser
        // */
        // public void setLastRefUser(String lastRefUser) {
        // this.lastRefUser = lastRefUser;
        // }
        //
        // /**
        // * 問い合せIDを設定します。
        // * @return cjnInqId
        // */
        // public String getCjnInqId() {
        // return cjnInqId;
        // }
        //
        // /**
        // * 問い合せIDを取得します。
        // * @param cjnInqId
        // */
        // public void setCjnInqId(String cjnInqId) {
        // this.cjnInqId = cjnInqId;
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
        // * 問い合せシーケンスを設定します。
        // * @return cjnInqKindSeq
        // */
        // public int getCjnInqKindSeq() {
        // return cjnInqKindSeq;
        // }
        //
        // /**
        // * 問い合せシーケンスを取得します。
        // * @param cjnInqKindSeq
        // */
        // public void setCjnInqKindSeq(int cjnInqKindSeq) {
        // this.cjnInqKindSeq = cjnInqKindSeq;
        // }

    }

}

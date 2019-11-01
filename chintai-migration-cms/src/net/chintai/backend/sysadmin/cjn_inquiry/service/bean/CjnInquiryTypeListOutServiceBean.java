/*
 * $Id: CjnInquiryTypeListOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.bean;

/**
 * 問い合せ種別一覧(閲覧可能ユーザ除く)
 * 
 * @author JavaBeans Code Generator
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeListOutServiceBean {

    /** 問い合せ種別シーケンス */
    private int cjnInqKindSeq;

    /** 問い合せタイトル */
    private String inqTitle;

    /** 問い合せURL */
    private String inqUrl;

    /** 問い合せ説明 */
    private String inqComment;

    /** 総数 */
    private int totalCount;

    /** 未読件数 */
    private int noReadCount;

    /** 未処理件数 */
    private int noShoriCount;

    /** 問い合せグループ */
    private String inqGroupType;

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
     * 問い合せURLを取得します。
     * @return 問い合せURL
     */
    public String getInqUrl() {
        return inqUrl;
    }

    /**
     * 問い合せURLを設定します。
     * @param inqUrl 問い合せURL
     */
    public void setInqUrl(String inqUrl) {
        this.inqUrl = inqUrl;
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
     * 総数を取得します。
     * @return 総数
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 総数を設定します。
     * @param totalCount 総数
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 未読件数を取得します。
     * @return 未読件数
     */
    public int getNoReadCount() {
        return noReadCount;
    }

    /**
     * 未読件数を設定します。
     * @param noReadCount 未読件数
     */
    public void setNoReadCount(int noReadCount) {
        this.noReadCount = noReadCount;
    }

    /**
     * 未処理件数を取得します。
     * @return 未処理件数
     */
    public int getNoShoriCount() {
        return noShoriCount;
    }

    /**
     * 未処理件数を設定します。
     * @param noShoriCount 未処理件数
     */
    public void setNoShoriCount(int noShoriCount) {
        this.noShoriCount = noShoriCount;
    }

    /**
     * 問い合せグループを取得します。
     * @return 問い合せグループ
     */
    public String getInqGroupType() {
        return inqGroupType;
    }

    /**
     * 問い合せグループを設定します。
     * @param inqGroupType 問い合せグループ
     */
    public void setInqGroupType(String inqGroupType) {
        this.inqGroupType = inqGroupType;
    }
}

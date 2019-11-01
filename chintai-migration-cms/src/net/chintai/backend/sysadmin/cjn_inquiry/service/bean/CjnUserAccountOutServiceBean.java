/*
 * $Id: CjnUserAccountOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/12  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.bean;

/**
 * 問い合せユーザアカウントリスト
 * 
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAccountOutServiceBean {

    /** 問い合せタイトル */
    private String inqTitle;

    /** 問い合せ説明 */
    private String inqComment;

    /** 閲覧可否カウンター */
    private int cnt;

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
}
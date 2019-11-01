/*
 * $Id: ReviewAutoDelDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.domain;

/**
 * 自動削除設定内容照会
 * 
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewAutoDelDomain {

    /** 審査設定名称 */
    private String shinsaName;

    /** 自動削除期間 */
    private String autoDelKikan;

    /**
     * 審査設定名称を取得します。
     * @return 審査設定名称
     */
    public String getShinsaName() {
        return shinsaName;
    }

    /**
     * 審査設定名称を設定します。
     * @param shinsaName 審査設定名称
     */
    public void setShinsaName(String shinsaName) {
        this.shinsaName = shinsaName;
    }

    /**
     * 自動削除期間を取得します。
     * @return 自動削除期間
     */
    public String getAutoDelKikan() {
        return autoDelKikan;
    }

    /**
     * 自動削除期間を設定します。
     * @param autoDelKikan 自動削除期間
     */
    public void setAutoDelKikan(String autoDelKikan) {
        this.autoDelKikan = autoDelKikan;
    }

}
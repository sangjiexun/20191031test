/*
 * $Id: ReviewConfigDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.domain;

/**
 * 審査設定内容照会
 * 
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewConfigDomain {

    /** 審査設定名称 */
    private String shinsaName;

    /** 審査条件 */
    private String jouken;

    /** 審査条件上下フラグ */
    private String joukenFlg;

    /** 審査除外条件 */
    private String jogai;

    /** 審査除外条件上下フラグ */
    private String jogaiFlg;

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
     * 審査条件を取得します。
     * @return 審査条件
     */
    public String getJouken() {
        return jouken;
    }

    /**
     * 審査条件を設定します。
     * @param jouken 審査条件
     */
    public void setJouken(String jouken) {
        this.jouken = jouken;
    }

    /**
     * 審査条件上下フラグを取得します。
     * @return 審査条件上下フラグ
     */
    public String getJoukenFlg() {
        return joukenFlg;
    }

    /**
     * 審査条件上下フラグを設定します。
     * @param joukenFlg 審査条件上下フラグ
     */
    public void setJoukenFlg(String joukenFlg) {
        this.joukenFlg = joukenFlg;
    }

    /**
     * 審査除外条件を取得します。
     * @return 審査除外条件
     */
    public String getJogai() {
        return jogai;
    }

    /**
     * 審査除外条件を設定します。
     * @param jogai 審査除外条件
     */
    public void setJogai(String jogai) {
        this.jogai = jogai;
    }

    /**
     * 審査除外条件上下フラグを取得します。
     * @return 審査除外条件上下フラグ
     */
    public String getJogaiFlg() {
        return jogaiFlg;
    }

    /**
     * 審査除外条件上下フラグを設定します。
     * @param jogaiFlg 審査除外条件上下フラグ
     */
    public void setJogaiFlg(String jogaiFlg) {
        this.jogaiFlg = jogaiFlg;
    }
}
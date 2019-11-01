/*
 * $Id: FudousanDeleteCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/05     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 不動産会社削除Bean
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanDeleteCommitInServiceBean {

    /** 不動産会社コードのリスト */
    private String[] fudousanCd;

    /** 更新日 */
    private String[] updDt;

    /** 更新者ID */
    private String updId;

    /** 更新PG */
    private String updPg;

    /**
     * @return fudousanCd
     */
    public String[] getFudousanCd() {
        return fudousanCd;
    }

    /**
     * @param fudousanCd 設定する fudousanCd
     */
    public void setFudousanCd(String[] fudousanCd) {
        this.fudousanCd = fudousanCd;
    }

    /**
     * @return updDt
     */
    public String[] getUpdDt() {
        return updDt;
    }

    /**
     * @param updDt 設定する updDt
     */
    public void setUpdDt(String[] updDt) {
        this.updDt = updDt;
    }

    /**
     * @return updId
     */
    public String getUpdId() {
        return updId;
    }

    /**
     * @param updId 設定する updId
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }

    /**
     * @return updPg
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * @param updPg 設定する updPg
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

}

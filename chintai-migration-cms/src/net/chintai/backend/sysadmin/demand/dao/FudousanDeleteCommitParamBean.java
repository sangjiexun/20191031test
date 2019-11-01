/*
 * $Id: FudousanDeleteCommitParamBean.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/05     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

/**
 * 不動産会社削除
 *
 * @author TAKAHASHI Yuki
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanDeleteCommitParamBean {

    /** 不動産会社コード */
    private String fudousanCd;

    /** 更新日 */
    private String updDt;

    /** 更新者ID */
    private String updId;

    /** 更新PG */
    private String updPg;

    /**
     * 不動産会社コードを取得します。
     * @return 不動産会社コード
     */
    public String getFudousanCd() {
        return fudousanCd;
    }

    /**
     * 不動産会社コードを設定します。
     * @param fudousanCd 不動産会社コード
     */
    public void setFudousanCd(String fudousanCd) {
        this.fudousanCd = fudousanCd;
    }

    /**
     * 更新日を取得します。
     * @return 更新日
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 更新日を設定します。
     * @param updDt 更新日
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 更新者IDを取得します。
     * @return 更新者ID
     */
    public String getUpdId() {
        return updId;
    }

    /**
     * 更新者IDを設定します。
     * @param updId 更新者ID
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }

    /**
     * 更新PGを取得します。
     * @return 更新PG
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 更新PGを設定します。
     * @param updPg 更新PG
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

}

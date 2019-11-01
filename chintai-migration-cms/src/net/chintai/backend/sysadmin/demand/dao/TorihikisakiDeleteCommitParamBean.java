/*
 * $Id: TorihikisakiDeleteCommitParamBean.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/07  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

/**
 * 取引先削除対象情報
 *
 * @author lee-hosup
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiDeleteCommitParamBean {

    /** 取引先削除対象シーケンス番号 */
    private String torihikisakiSeq;

    /** 最終更新日時 */
    private String updDt;

    /** 更新者ID */
    private String updId;

    /** 更新者プログラム */
    private String updPg;

    /**
     * 取引先削除対象シーケンス番号を取得します。
     * @return 取引先削除対象シーケンス番号
     */
    public String getTorihikisakiSeq() {
        return torihikisakiSeq;
    }

    /**
     * 取引先削除対象シーケンス番号を設定します。
     * @param torihikisakiSeq 取引先削除対象シーケンス番号
     */
    public void setTorihikisakiSeq(String torihikisakiSeq) {
        this.torihikisakiSeq = torihikisakiSeq;
    }

    /**
     * 最終更新日時を取得します。
     * @return 最終更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日時を設定します。
     * @param updDt 最終更新日時
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
     * 更新者プログラムを取得します。
     * @return 更新者プログラム
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 更新者プログラムを設定します。
     * @param updPg 更新者プログラム
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }
}

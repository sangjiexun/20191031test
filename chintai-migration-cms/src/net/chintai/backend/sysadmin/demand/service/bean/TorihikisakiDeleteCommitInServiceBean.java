/*
 * $Id: TorihikisakiDeleteCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/07  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 取引先削除対象情報
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiDeleteCommitInServiceBean {

    /** 取引先削除対象リスト */
    private String[] delFlgList;

    /** 最終更新日時情報リスト */
    private String[] updDt;

    /** 更新者ID */
    private String updId;

    /** 更新者プログラム */
    private String updPg;

    /**
     * 取引先削除対象リストを取得します。
     * @return 取引先削除対象リスト
     */
    public String[] getDelFlgList() {
        return delFlgList;
    }

    /**
     * 取引先削除対象リストを設定します。
     * @param delFlgList 取引先削除対象リスト
     */
    public void setDelFlgList(String[] delFlgList) {
        this.delFlgList = delFlgList;
    }

    /**
     * 最終更新日時情報リストを取得します。
     * @return 最終更新日時情報リスト
     */
    public String[] getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日時情報リストを設定します。
     * @param updDt 最終更新日時情報リスト
     */
    public void setUpdDt(String[] updDt) {
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

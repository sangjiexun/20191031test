/*
 * $Id: TorihikisakiWakuInfoDeleteConfirmParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

/**
 * 削除する取引先物件枠情報の検索条件
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoDeleteConfirmParamBean {

    /** 取引先シーケンス番号 */
    private String torihikisakiSeq;

    /** 削除する適用月リスト */
    private String[] delFlgList;

    /**
     * 取引先シーケンス番号を取得します。
     * @return 取引先シーケンス番号
     */
    public String getTorihikisakiSeq() {
        return torihikisakiSeq;
    }

    /**
     * 取引先シーケンス番号を設定します。
     * @param torihikisakiSeq 取引先シーケンス番号
     */
    public void setTorihikisakiSeq(String torihikisakiSeq) {
        this.torihikisakiSeq = torihikisakiSeq;
    }

    /**
     * 削除する適用月リストを取得します。
     * @return 削除する適用月リスト
     */
    public String[] getDelFlgList() {
        return delFlgList;
    }

    /**
     * 削除する適用月リストを設定します。
     * @param delFlgList 削除する適用月リスト
     */
    public void setDelFlgList(String[] delFlgList) {
        this.delFlgList = delFlgList;
    }
}

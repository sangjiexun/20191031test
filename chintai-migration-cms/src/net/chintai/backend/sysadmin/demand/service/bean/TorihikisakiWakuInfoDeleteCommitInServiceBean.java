/*
 * $Id: TorihikisakiWakuInfoDeleteCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 取引先物件枠設定情報削除
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoDeleteCommitInServiceBean {

    /** 取引先シーケンス番号 */
    private String torihikisakiSeq;

    /** 削除する適用月リスト */
    private String[] delFlgList;

    /** 取引先テーブルの最終更新日付 */
    private String torihikisakiUpdDt;

    /** 更新者ID */
    private String updId;

    /** 更新プログラム */
    private String updPg;

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

    /**
	 * 取引先テーブルの最終更新日付を取得します。
	 * @return 取引先テーブルの最終更新日付
	 */
	public String getTorihikisakiUpdDt() {
	    return torihikisakiUpdDt;
	}

	/**
	 * 取引先テーブルの最終更新日付を設定します。
	 * @param torihikisakiUpdDt 取引先テーブルの最終更新日付
	 */
	public void setTorihikisakiUpdDt(String torihikisakiUpdDt) {
	    this.torihikisakiUpdDt = torihikisakiUpdDt;
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
     * 更新プログラムを取得します。
     * @return 更新プログラム
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 更新プログラムを設定します。
     * @param updPg 更新プログラム
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

}

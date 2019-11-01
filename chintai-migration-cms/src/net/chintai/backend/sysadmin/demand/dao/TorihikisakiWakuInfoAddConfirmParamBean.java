/*
 * $Id: TorihikisakiWakuInfoAddConfirmParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/13  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;


/**
* 取引先物件枠設定情報新規登録確認
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoAddConfirmParamBean {

    /** 取引先シーケンス番号 */
    private int torihikisakiSeq;

    /** 適用年 */
    private String applyYear;

    /** 適用月 */
    private String applyMonth;

    /**
     * 取引先シーケンス番号を取得します。
     * @return 取引先シーケンス番号
     */
    public int getTorihikisakiSeq() {
        return torihikisakiSeq;
    }

    /**
     * 取引先シーケンス番号を設定します。
     * @param torihikisakiSeq 取引先シーケンス番号
     */
    public void setTorihikisakiSeq(int torihikisakiSeq) {
        this.torihikisakiSeq = torihikisakiSeq;
    }

    /**
     * 適用年を取得します。
     * @return 適用年
     */
    public String getApplyYear() {
        return applyYear;
    }

    /**
     * 適用年を設定します。
     * @param applyYear 適用年
     */
    public void setApplyYear(String applyYear) {
        this.applyYear = applyYear;
    }

    /**
     * 適用月を取得します。
     * @return 適用月
     */
    public String getApplyMonth() {
        return applyMonth;
    }

    /**
     * 適用月を設定します。
     * @param applyMonth 適用月
     */
    public void setApplyMonth(String applyMonth) {
        this.applyMonth = applyMonth;
    }

}
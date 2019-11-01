package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 契約明細詳細(契約数量あり)情報(削除確認用)
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountDeleteConfirmOutServiceBean {

    /** 適用年月日 */
    private String appStartDt;

    /** 適用年月日（画面表示分） */
    private String startYmdh;

    /** 物件枠 */
    private String wakuCnt;

    /** 更新日時 */
    private String updDt;

    /**
     * 適用年月日を取得します。
     * @return 適用月
     */
    public String getAppStartDt() {
        return appStartDt;
    }

    /**
     * 適用年月日を設定します。
     * @param startYm 適用月
     */
    public void setAppStartDt(String appStartDt) {
        this.appStartDt = appStartDt;
    }

    /**
     * 適用年月日を取得します。
     * @return 適用月
     */
    public String getStartYmdh() {
        return startYmdh;
    }

    /**
     * 適用年月日を設定します。
     * @param startYm 適用月
     */
    public void setStartYmdh(String startYmdh) {
        this.startYmdh = startYmdh;
    }

    /**
     * 枠を取得します。
     * @return 物件枠
     */
    public String getWakuCnt() {
        return wakuCnt;
    }

    /**
     * 枠を設定します。
     * @param bukkenCnt 物件枠
     */
    public void setWakuCnt(String wakuCnt) {
        this.wakuCnt = wakuCnt;
    }

    /**
     * 更新日時を返します。
     * @return updDt
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 更新日時を設定します。
     * @param updDt  更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

}

package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 契約明細詳細(契約数量あり)設定情報(更新ページ用)
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountUpdatePageOutServiceBean {

    /** 適用月 */
    private String appStartDt;

    /** 物件枠 */
    private String wakuCnt;

    /** 表示用適用年月日時*/
    private String startYmdh;

    /**
     * 適用月を取得します。
     * @return 適用月
     */
    public String getAppStartDt() {
        return appStartDt;
    }

    /**
     * 適用月を設定します。
     * @param startYm 適用月
     */
    public void setAppStartDt(String appStartDt) {
        this.appStartDt = appStartDt;
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
     * 表示用適用年月日時を返します。
     * @return startYmdh
     */
    public String getStartYmdh() {
        return startYmdh;
    }

    /**
     * 表示用適用年月日時を設定します。
     * @param startYmdh  表示用適用年月日時
     */
    public void setStartYmdh(String startYmdh) {
        this.startYmdh = startYmdh;
    }


}

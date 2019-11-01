/*
 * $Id: Eki.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.domain;

/**
 * 店舗検索の地域・沿線から検索するときに使用する駅Bean
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class Eki {

    /** 駅コード */
    private String ekiCode;

    /** 駅名 */
    private String ekiName;

    /**
     * 駅コードを取得します。
     * @return ekiCode 駅コード
     */
    public String getEkiCode() {
        return ekiCode;
    }

    /**
     * 駅コードを設定します。
     * @param ekiCode 駅コード
     */
    public void setEkiCode(String ekiCode) {
        this.ekiCode = ekiCode;
    }

    /**
     * 駅名を取得します。
     * @return ekiName 駅名
     */
    public String getEkiName() {
        return ekiName;
    }

    /**
     * 駅名を設定します。
     * @param ekiName 駅名
     */
    public void setEkiName(String ekiName) {
        this.ekiName = ekiName;
    }
}

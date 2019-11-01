/*
 * $Id: Ensen.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.domain;

/**
 * 店舗検索の地域・沿線から検索するときに使用する沿線Bean
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class Ensen {

    /** 沿線名 */
    private String ensenCode;

    /** 沿線コード */
    private String ensenName;

    /**
     * 沿線コードを取得します。
     * @return ensenCode 沿線コード
     */
    public String getEnsenCode() {
        return ensenCode;
    }

    /**
     * 沿線コードを設定します。
     * @param ensenCode 沿線コード
     */
    public void setEnsenCode(String ensenCode) {
        this.ensenCode = ensenCode;
    }

    /**
     * 沿線名を設定します。
     * @return ensenName 沿線名
     */
    public String getEnsenName() {
        return ensenName;
    }

    /**
     * 沿線名を取得します。
     * @param ensenName 沿線名
     */
    public void setEnsenName(String ensenName) {
        this.ensenName = ensenName;
    }

}

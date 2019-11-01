/*
 * $Id: Area.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.domain;

/**
 * 店舗検索の地域・沿線から検索するときに使用するエリアBean
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class Area {

    /** エリアコード */
    private String areaCode;

    /** エリア名 */
    private String areaName;

    /**
     * エリアコードを取得します。
     * @return areaCode エリアコード
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * エリアコードを設定します。
     * @param areaCode エリアコード
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * エリア名を設定します。
     * @return areaName エリア名
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * エリア名を設定します。
     * @param areaName エリア名
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}

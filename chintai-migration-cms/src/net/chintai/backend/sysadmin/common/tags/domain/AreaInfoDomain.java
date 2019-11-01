/*
 * $Id: AreaInfoDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/25  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.common.tags.domain;

/**
 * エリア情報
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AreaInfoDomain {

    /** エリアコード */
    private String areaCd;

    /** エリア名称 */
    private String areaName;

    /**
     * エリアコードを取得します。
     * @return エリアコード
     */
    public String getAreaCd() {
        return areaCd;
    }

    /**
     * エリアコードを設定します。
     * @param areaCd エリアコード
     */
    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    /**
     * エリア名称を取得します。
     * @return エリア名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * エリア名称を設定します。
     * @param areaName エリア名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

}

/*
 * $Id: YearType.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/08/01  BGT)児島   新規作成
 * 
 */
package net.chintai.backend.sysadmin.common.tags.datetype;

import net.chintai.backend.sysadmin.common.util.DateUtil;

/**
 * 年 (year) の状態を表すクラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class YearType implements DateType {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.tags.DateType#getDropDownListValues()
     */
    public String[] getDropDownListValues() {
        return DateUtil.getYearsList();
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.tags.DateType#getPresentValue()
     */
    public String getPresentValue() {
        return DateUtil.getCurrentYear();
    }
}

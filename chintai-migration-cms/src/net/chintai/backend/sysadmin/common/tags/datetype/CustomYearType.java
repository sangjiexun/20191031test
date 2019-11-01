/*
 * $Id: CustomYearType.java 4349 2009-08-25 09:00:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2009/03/19  BGT)李     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.tags.datetype;

import net.chintai.backend.sysadmin.common.util.DateUtil;

/**
 * 年 (year) の状態を表すクラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 4349 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CustomYearType implements DateType {

    /** 年度補正値 */
    private String addYear;

    /** 開始年度 */
    private String startYear;

    /**
     * Default Constructor
     * @param addYear
     */
    public CustomYearType(String startYear, String addYear) {
        super();
        this.addYear = addYear;
        this.startYear = startYear;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.tags.DateType#getDropDownListValues()
     */
    public String[] getDropDownListValues() {
        return DateUtil.getYearsList(startYear, addYear);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.tags.DateType#getPresentValue()
     */
    public String getPresentValue() {
        return DateUtil.getCurrentYear();
    }

    /**
     * 年度補正値を設定します。
     * @param addYear 年度補正値
     */
    public void setAddYear(String addYear) {
        this.addYear = addYear;
    }

    /**
     * 開始年度を設定します。
     * @param startYear 開始年度
     */
    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }
}

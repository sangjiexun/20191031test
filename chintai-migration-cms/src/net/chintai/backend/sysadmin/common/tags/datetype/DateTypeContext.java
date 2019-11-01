/*
 * $Id: DateTypeContext.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/08/01  BGT)児島   新規作成
 * 
 */
package net.chintai.backend.sysadmin.common.tags.datetype;

/**
 * 日付タイプの状態を管理するクラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class DateTypeContext {

    /** 日付タイプ */
    private DateType dateType = null;

    /**
     * コンストラクタ
     */
    public DateTypeContext() {
    }

    /**
     * コンストラクタ
     * @param dateType
     */
    public DateTypeContext(DateType dateType) {
        setDateType(dateType);
    }

    /**
     * 日付タイプを設定します。
     * @param dateType 日付タイプ
     */
    public void setDateType(DateType dateType) {
        this.dateType = dateType;
    }

    /**
     * 日付タイプを取得します。
     * @return 日付タイプ
     */
    public DateType getDateType() {
        return this.dateType;
    }

    /**
     * 現在時刻に対応する値を取得します。
     * @return 現在時刻に対応する値
     */
    public String getPresentDate() {
        return this.dateType.getPresentValue();
    }

    /**
     * ドロップダウンリストの値を取得します。
     * @return ドロップダウンリストに表示する値のリスト
     */
    public String[] getDropDownListValues() {
        return this.dateType.getDropDownListValues();
    }

}

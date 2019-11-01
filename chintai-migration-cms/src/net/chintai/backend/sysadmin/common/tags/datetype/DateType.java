/*
 * $Id: DateType.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/08/01  BGT)児島   新規作成
 * 
 */
package net.chintai.backend.sysadmin.common.tags.datetype;

/**
 * 日付タイプを定めるインターフェース。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface DateType {

    /**
     * 現在時刻に対応する値を取得します。取得できる値は実装に依存します。
     * @return 現在時刻に対応する値
     */
    public String getPresentValue();

    /**
     * ドロップダウンリストの値を取得します。
     * @return ドロップダウンリストに表示する値のリスト
     */
    public String[] getDropDownListValues();
}

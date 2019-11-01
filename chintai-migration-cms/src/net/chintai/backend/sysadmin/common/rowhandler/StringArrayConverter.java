/*
 * $Id: StringArrayConverter.java 3802 2008-02-20 00:34:49Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/12/26   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.common.rowhandler;


/**
 * CsvRowHandler 向けのインターフェース。<br>
 * このインターフェースは、レコードオブジェクト(JavaBeans)から<br>
 * String 配列を作成するメソッドを持ちます。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3802 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface StringArrayConverter {
    
    /**
     * レコードオブジェクトからString配列を生成します。
     * @param obj レコードオブジェクト
     * @return CSV出力用String配列
     */
    public String[] toStringArray(Object obj);
}

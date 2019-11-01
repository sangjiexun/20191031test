/*
 * $Id: CsvException.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/18   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.common.util;

/**
 * CSV エクスポート処理で問題が発生した場合にスローされる例外。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CsvException extends Exception {

    /** serialVersionUID */
    private static final long serialVersionUID = 7847964401185447216L;

    public CsvException() {
        super();
    }

    public CsvException(String message, Throwable cause) {
        super(message, cause);
    }

    public CsvException(String message) {
        super(message);
    }

    public CsvException(Throwable cause) {
        super(cause);
    }
}

/*
 * $Id: FTPClientException.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/25   BGT)児島      新規作成(chintai-imagetool より拝借)
 *
 */
package net.chintai.backend.sysadmin.common.ftp;

/**
 * FTPクライアントオブジェクトの操作中に問題が発生した場合に<br>
 * スローされる例外です。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FTPClientException extends Exception {

    /** serialVersionUID */
    private static final long serialVersionUID = 1271831645491873879L;

    public FTPClientException() {
        super();
    }

    public FTPClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public FTPClientException(String message) {
        super(message);
    }

    public FTPClientException(Throwable cause) {
        super(cause);
    }
}

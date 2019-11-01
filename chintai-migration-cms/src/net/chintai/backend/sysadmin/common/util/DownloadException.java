package net.chintai.backend.sysadmin.common.util;


/**
 * ファイルのダウンロード処理で問題が発生した場合にスローされる例外。
 *
 * @author e-ishii
 * @version $Revision: 4512 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class DownloadException extends Exception {

    /** serialVersionUID */
    private static final long serialVersionUID = -6118361131702350497L;

    public DownloadException() {
        super();
    }

    public DownloadException(String message, Throwable cause) {
        super(message, cause);
    }

    public DownloadException(String message) {
        super(message);
    }

    public DownloadException(Throwable cause) {
        super(cause);
    }
}

package net.chintai.backend.sysadmin.common.util;

import javax.servlet.http.HttpServletResponse;
import static net.chintai.backend.sysadmin.common.properties.SystemProperties.getProperty;

/**
 * Zip のメタ情報を保持する Bean です。
 *
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class ZipStatusBean {

    /** HTTPレスポンスオブジェクト */
    private HttpServletResponse response;

    /**
     * HTTP Content-Type ヘッダ<br>
     * デフォルトは SystemProperties.C_CSV_CONTENT_TYPE の値を使用します。
     */
    private String contentType;

    /**
     * 出力ファイル名<br>
     * 入力必須項目です。
     */
    private String fileName;

    /**
     * ファイルの文字コード<br>
     * デフォルトは SystemProperties.C_CSV_CHARSET の値を使用します。
     */
    private String charset;

    /**
     * コンストラクター
     */
    public ZipStatusBean() {
        this.contentType = getProperty("C_ZIP_CONTENT_TYPE");
        this.charset = getProperty("C_ZIP_CHARSET");
    }

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}


}

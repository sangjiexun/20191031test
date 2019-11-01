/*
 * $Id: CsvStatusBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/26   BGT)児島      新規作成
 * 2007/10/30   BGT)児島      デフォルト値をプロパティファイルに移動
 */
package net.chintai.backend.sysadmin.common.util;

import javax.servlet.http.HttpServletResponse;
import static net.chintai.backend.sysadmin.common.properties.SystemProperties.getProperty;

/**
 * CSV のメタ情報を保持する Bean です。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class CsvStatusBean {

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
     * ファイルの改行コード<br>
     * デフォルトは SystemProperties.C_CSV_LINE_END の値を使用します。
     */
    private String lineEnd;

    /**
     * ファイルの文字コード<br>
     * デフォルトは SystemProperties.C_CSV_CHARSET の値を使用します。
     */
    private String charset;

    /**
     * 項目のクォート文字<br>
     * デフォルトは SystemProperties.C_CSV_QUOTE_CHAR の値を使用します。
     */
    private char quoteChar;

    /**
     * 項目の区切り文字<br>
     * デフォルトは SystemProperties.C_CSV_SEPARATEOR の値を使用します。
     */
    private char separator;

    /**
     * 先頭行の取扱いを制御します。true のとき先頭行を無視します。<br>
     * デフォルトでは false に設定されています。
     */
    private boolean ignoreStartLine;

    /**
     * コンストラクター
     */
    public CsvStatusBean() {
        this.contentType = getProperty("C_CSV_CONTENT_TYPE");
        this.lineEnd = getProperty("C_CSV_LINE_END");
        this.charset = getProperty("C_CSV_CHARSET");
        this.quoteChar = getProperty("C_CSV_QUOTE_CHAR").charAt(0);
        this.separator = getProperty("C_CSV_SEPARATEOR").charAt(0);
        this.ignoreStartLine = false;
    }

    /**
     * HTTPレスポンスオブジェクトを取得します。
     * @return HTTPレスポンスオブジェクト
     */
    public HttpServletResponse getResponse() {
        return response;
    }

    /**
     * HTTPレスポンスオブジェクトを設定します。
     * @param response HTTPレスポンスオブジェクト
     */
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    /**
     * HTTP Content-Type ヘッダを取得します。
     * @return HTTP Content-Type ヘッダ
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * HTTP Content-Type ヘッダを設定します。
     * @param contentType HTTP Content-Type ヘッダ
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * 出力ファイル名を取得します。
     * @return 出力ファイル名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 出力ファイル名を設定します。
     * @param fileName 出力ファイル名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * ファイルの改行コードを取得します。
     * @return ファイルの改行コード
     */
    public String getLineEnd() {
        return lineEnd;
    }

    /**
     * ファイルの改行コードを設定します。
     * @param lineEnd ファイルの改行コード
     */
    public void setLineEnd(String lineEnd) {
        this.lineEnd = lineEnd;
    }

    /**
     * ファイルの文字コードを取得します。
     * @return ファイルの文字コード
     */
    public String getCharset() {
        return charset;
    }

    /**
     * ファイルの文字コードを設定します。
     * @param charset ファイルの文字コード
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    /**
     * 項目のクォート文字を取得します。
     * @return 項目のクォート文字
     */
    public char getQuoteChar() {
        return quoteChar;
    }

    /**
     * 項目のクォート文字を設定します。
     * @param quoteChar 項目のクォート文字
     */
    public void setQuoteChar(char quoteChar) {
        this.quoteChar = quoteChar;
    }

    /**
     * 項目の区切り文字を取得します。
     * @return 項目の区切り文字
     */
    public char getSeparator() {
        return separator;
    }

    /**
     * 項目の区切り文字を設定します。
     * @param separator 項目の区切り文字
     */
    public void setSeparator(char separator) {
        this.separator = separator;
    }

    /**
     * 先頭行を無視するかどうかを判定します。
     * @return ignoreStartLine
     */
    public boolean isIgnoreStartLine() {
        return ignoreStartLine;
    }

    /**
     * 先頭行無視フラグを設定します。
     * @param ignoreStartLine
     */
    public void setIgnoreStartLine(boolean ignoreStartLine) {
        this.ignoreStartLine = ignoreStartLine;
    }

}

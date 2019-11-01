package net.chintai.backend.sysadmin.common.util;

import static net.chintai.backend.sysadmin.common.properties.SystemProperties.getProperty;

import javax.servlet.http.HttpServletResponse;


/**
 * ファイルのダウンロードに関する情報を保持するクラス
 *
 * @author e-ishii
 * @version $Revision: 4512 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class DownloadFileStatusBean {


    /** HTTPレスポンスオブジェクト */
    private HttpServletResponse response;

    /** HTTP Content-Type ヘッダ */
    private String contentType;

    /** 出力ファイル名 */
    private String fileName;

    /** ダウンロードする物理ファイル */
    private String downloadFilePath;


    /**
     * コンストラクタ
     */
    public DownloadFileStatusBean() {
        this.contentType = getProperty("C_FILE_DOWNLOAD_CONTENT_TYPE");
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
     * HTTP Content-Type ヘッダ<br>を取得します。
     * @return HTTP Content-Type ヘッダ<br>
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * HTTP Content-Type ヘッダ<br>を設定します。
     * @param contentType HTTP Content-Type ヘッダ<br>
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * 出力ファイル名<br>を取得します。
     * @return 出力ファイル名<br>
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 出力ファイル名<br>を設定します。
     * @param fileName 出力ファイル名<br>
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * downloadFilePathを取得します。
     * @return downloadFilePath
     */
    public String getDownloadFilePath() {
        return downloadFilePath;
    }

    /**
     * downloadFilePathを設定します。
     * @param downloadFilePath downloadFilePath
     */
    public void setDownloadFilePath(String downloadFilePath) {
        this.downloadFilePath = downloadFilePath;
    }


}

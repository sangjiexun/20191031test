/*
 * $Id: UploadUtil.java 4020 2008-10-23 04:06:46Z s-hasegawa $
 * ---------------------------------------------------------
 * 更新日      更新者      内容
 * ---------------------------------------------------------
 * 2007/07/31  BGT)劉俊秀  新規作成
 * 2007/07/31  BGT)児島    読み込みバッファを定数化
 *                         ドキュメンテーションコメントを追加
 * 2007/08/02  BGT)児島    IOException 発生時の処理を追加
 * 2007/08/13  BGT)児島    C_READ_BUFFER_LENGTH の定義を
 *                         SystemProperties クラスに移動
 */
package net.chintai.backend.sysadmin.common.util;

import static net.chintai.backend.sysadmin.common.properties.SystemProperties.getProperty;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

/**
 * ファイルアップロードユーティリティ。<br>
 * ブラウザのファイルアップロードフォームから<br>
 * アップロードされたファイルをサーバ側で受け取り、<br>
 * 処理するためのクラスです。
 * 
 * @author yoo-junsu
 * @author KOJIMA Takanori
 * @version $Revision: 4020 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public final class UploadUtil {

    /** 1回の読み込みで使用するバッファのサイズ */
    private static final int C_READ_BUFFER_LENGTH = Integer.valueOf(getProperty("C_READ_BUFFER_LENGTH"));

    /**
     * 外部からのインスタンス化はできません。
     */
    private UploadUtil() {
    }

    /**
     * ファイルのアップロードを行います。<br>
     * ブラウザから送られてくるバイト列を、そのままファイルに書き込みます。
     * @param in InputStream
     * @param filePath ファイルの保存先
     * @throws IOException
     */
    public static void upload(InputStream in, String filePath) throws IOException {
        OutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream(filePath));
            int bytesRead = 0;
            byte[] buffer = new byte[C_READ_BUFFER_LENGTH];
            while ((bytesRead = in.read(buffer, 0, C_READ_BUFFER_LENGTH)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * CSV ファイルのアップロードを行います。<br>
     * アップされた CSV は、List として戻されます。
     * @param in InputStream
     * @param bean CSV出力設定
     * @return CSVの内容
     * @throws CsvException 読み込みエラー発生時にスローされます。
     */
    @SuppressWarnings("unchecked")
    public static List<String[]> uploadCsv(InputStream in, CsvStatusBean bean) throws CsvException {

        // 読み飛ばす行数を設定
        int skipLine = bean.isIgnoreStartLine() ? 1 : 0;
        CSVReader csvReader = null;
        try {
            csvReader =
                    new CSVReader(new BufferedReader(new InputStreamReader(in, bean.getCharset())),
                            bean.getSeparator(), bean.getQuoteChar(), skipLine);

            List<String[]> csv;
            csv = csvReader.readAll();
            return csv;

        } catch (IOException e) {
            throw new CsvException(e);
        } finally {
            try {
                if (csvReader != null) {
                    csvReader.close();
                }
            } catch (IOException e) {
            }

        }
    }
}

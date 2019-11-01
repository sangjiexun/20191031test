/*
 * $Id: CsvExportUtil.java 3706 2007-12-26 05:41:30Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/07/31  BGT)劉俊秀 新規作成
 * 2007/07/31  BGT)児島   利用されない download メソッドを削除
 *                        リファクタリング、コメント追加
 * 2007/10/30  BGT)児島   CSV出力専用の static method を実装
 */
package net.chintai.backend.sysadmin.common.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import au.com.bytecode.opencsv.CSVWriter;

/**
 * CSV のエクスポート処理を行うユーティリティクラス。
 * 
 * @author yoo-junsu
 * @author KOJIMA Takanori
 * @version $Revision: 3706 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class CsvExportUtil {

    /**
     * 外部からのインスタンス化はできません。
     */
    private CsvExportUtil() {
    }

    /**
     * HttpResponse に直接 CSV を書き込みます。<br>
     * CSV 出力の各種設定は、CsvStatusBean にて行います。<br>
     * このメソッドを呼んだ後は、画面遷移が発生しないよう<br>
     * Action の戻り先に null を指定するようにして下さい。
     * 
     * @param bean CSV出力設定 (HttpResponse, Filename は必ずセットすること)
     * @param output CSV出力する List (List の要素は String[] であること)
     * @throws CsvException 処理中に問題が起こった場合にスローされます。
     */
    public static void export(CsvStatusBean bean, List<String[]> output) throws CsvException {

        // 必須項目検証
        validate(bean);

        // レスポンスヘッダー
        bean.getResponse().setContentType(bean.getContentType());
        bean.getResponse().setHeader("Content-Disposition", "attachment; filename=" + bean.getFileName());

        // CSV 出力
        CSVWriter csvWriter = null;
        try {
            csvWriter =
                    new CSVWriter(
                            new BufferedWriter(
                                    new OutputStreamWriter(bean.getResponse().getOutputStream(), bean.getCharset())
                                    ),
                                    bean.getSeparator(),
                                    bean.getQuoteChar(),
                                    bean.getLineEnd());
            csvWriter.writeAll(output);
            csvWriter.close();
            
        } catch (IOException e) {
            // ClientAbortException は無視します。
            if (!StringUtils.contains(e.toString(), "ClientAbortException")) {
                throw new CsvException(e);
            }
            
        } catch (IllegalStateException e) {
            if (bean.getResponse().isCommitted()) {
                // no-op
            } else {
                throw e;
            }
        }
    }

    /**
     * CSV出力時の必須項目をチェックする内部メソッド。
     * @param bean CSV出力設定
     * @throws CsvException 必須項目がない場合にスローされます。
     */
    private static void validate(CsvStatusBean bean) throws CsvException {

        if (bean.getResponse() == null) {
            throw new CsvException();
        }

        if (StringUtils.isEmpty(bean.getFileName())) {
            throw new CsvException();
        }
    }
}
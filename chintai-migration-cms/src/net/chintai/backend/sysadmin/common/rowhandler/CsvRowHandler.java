/*
 * $Id: CsvRowHandler.java 3822 2008-02-20 04:16:50Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/12/26   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.common.rowhandler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.http.HttpServletResponse;

import net.chintai.backend.sysadmin.common.util.CsvException;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;

import org.apache.commons.lang.StringUtils;

import au.com.bytecode.opencsv.CSVWriter;

import com.ibatis.sqlmap.client.event.RowHandler;

/**
 * CSV出力用の汎用RowHandler。<br>
 * 出力されるCSVのフォーマットは、コンストラクタに渡す<br>
 * CsvStatusBean および StringArrayConverter で決定されます。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3822 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CsvRowHandler implements RowHandler {

    /** CSVWriter */
    private CSVWriter csvWriter;
    
    /** コンバータ */
    private StringArrayConverter converter;

    /**
     * コンストラクター
     * @param bean CSVメタ情報
     * @throws CsvException 初期化に失敗した場合にスローされます。
     */
    public CsvRowHandler(CsvStatusBean bean, StringArrayConverter converter) throws CsvException {
        
        // 必須チェック
        validate(bean, converter);
        
        this.converter = converter;

        try {
            // レスポンスヘッダー設定
            HttpServletResponse response = bean.getResponse();
            response.setContentType(bean.getContentType());
            response.setHeader("Content-disposition", "attachment; filename=" + bean.getFileName());

            this.csvWriter =
                    new CSVWriter(
                            new BufferedWriter(
                                    new OutputStreamWriter(response.getOutputStream(), bean.getCharset())
                            ),
                            bean.getSeparator(),
                            bean.getQuoteChar(),
                            bean.getLineEnd());

        } catch (IOException e) {
            throw new CsvException(e);
        }
    }

    /**
     * ヘッダーを書き込みます。
     * @param tokens ヘッダートークン配列
     */
    public void setCsvHeader(String[] tokens) {
        csvWriter.writeNext(tokens);
    }
    
    /*
     * (非 Javadoc)
     * @see com.ibatis.sqlmap.client.event.RowHandler#handleRow(java.lang.Object)
     */
    public void handleRow(Object obj) {
        String[] line = converter.toStringArray(obj);
        csvWriter.writeNext(line);
    }
    
    /**
     * 後処理を行います。
     * @throws CsvException
     */
    public void close() throws CsvException {
        try {
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            throw new CsvException(e);
        }
    }

    /**
     * CSV出力時の必須項目をチェックする内部メソッド。
     * @param bean CSV出力設定
     * @param converter コンバータ
     * @throws CsvException 必須項目がない場合にスローされます。
     * @throws NullPointerException コンバータが指定されていない場合にスローされます。
     */
    private void validate(CsvStatusBean bean, StringArrayConverter converter) throws CsvException {
        if (StringUtils.isEmpty(bean.getFileName())) {
            throw new CsvException();
        }

        if (bean.getResponse() == null) {
            throw new CsvException();
        }

        if (converter == null) {
            throw new NullPointerException();
        }
    }
}

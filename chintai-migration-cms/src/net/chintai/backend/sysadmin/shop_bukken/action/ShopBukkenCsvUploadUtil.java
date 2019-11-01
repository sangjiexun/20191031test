/*
 * $Id: DemandCsvUploadUtil.java 4650 2013-10-09 07:59:35Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/09/30     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.util.CsvException;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.common.util.UploadUtil;

import org.apache.struts.upload.FormFile;


/**
 * CSVアップロード処理についての共通ユーティリティクラス
 * @author KAMEDA Takuma
 * @version $Revision: 4650 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class ShopBukkenCsvUploadUtil {


    /** このクラスはインスタンス化できません。 */
    private ShopBukkenCsvUploadUtil() {
    }

    /**
     * ファイル拡張子のチェックを行います。このパッケージ内でのみ呼び出し可能です。
     * @param uploadFileName アップロードファイル名
     * @return 拡張子が既定通り : true, 既定に反する :false
     */
    protected static boolean validateFileSuffix(String uploadFileName) {
        String csvSuffix = ApplicationResources.getProperty("shop_bukken.uploadFileExtensions");
        String uploadFileType = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1, uploadFileName.length());
        return csvSuffix.equals(uploadFileType.toUpperCase()) ? true : false;
    }

    /**
     * CSVをアップロードを行います。このパッケージ内でのみ呼び出し可能です。
     * @param formFile フォームから送られてきたCSVデータ
     * @return CSV変換後のString配列リスト
     * @throws CsvException CSV変換中にエラーが発生した場合にスローされる
     * @throws IOException formFile の読み込み時にエラーが発生した場合にスローされる
     */
    protected static List<String[]> uploadCsv(FormFile formFile) throws CsvException, IOException {
        InputStream in = formFile.getInputStream();

        CsvStatusBean csvStatusBean = new CsvStatusBean();
        csvStatusBean.setFileName(formFile.getFileName());
        csvStatusBean.setIgnoreStartLine(true);

        return UploadUtil.uploadCsv(in, csvStatusBean);
    }

}

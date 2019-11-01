/*
 * $Id：$
 * $Id: MasterZipUploadUtil.java 4535 2011-11-04 05:46:53Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2011/06/15     BGT)大原       新規作成
 *
 */
package net.chintai.backend.sysadmin.master.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

import net.chintai.backend.sysadmin.common.properties.ApplicationResources;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * マスタ管理機能のZIPアップロード処理についての共通ユーティリティクラス。
 *
 * @author OOHARA Takashi
 * @version $Revision: 4535 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MasterZipUploadUtil {

    /** ログインスタンス */
    private static Log log = LogFactory.getLog(ShikutyosonAddAction.class);

    /**
     * このクラスはインスタンス化できません。
     */
    private MasterZipUploadUtil() {
    }

    /**
     * ファイル拡張子のチェックを行います。このパッケージ内でのみ呼び出し可能です。
     * @param uploadFileName アップロードファイル名
     * @return 拡張子が既定通り : true, 既定に反する :false
     */
    protected static boolean validateFileSuffix(String uploadFileName) {
        String zipSuffix = ApplicationResources.getProperty("master.uploadZipFileExtensions");
        String uploadFileType = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1, uploadFileName.length());
        return zipSuffix.equals(uploadFileType.toUpperCase()) ? true : false;
    }

    /**
     * ZIPファイルのチェックを行います。このパッケージ内でのみ呼び出し可能です。<br>
     * 以下の場合にチェックNGを返却します。<br>
     * ・Zipファイルにエントリが存在しない場合<br>
     * ・ZIPファイルのエントリのCRCチェックサムが不明の場合<br>
     * ・ZIPファイルエラーの場合<br>
     * ・入出力エラーの場合<br>
     * @param inputStream ファイルの入力ストリーム
     * @return チェックOK : true, チェックNG :false
     */
    protected static boolean checkZipFile(InputStream inputStream) {
        ZipInputStream zipInputStream = null;
        try {
            zipInputStream = new ZipInputStream(inputStream);
            ZipEntry entry = zipInputStream.getNextEntry();
            if (null == entry) {
                log.debug("ZIPファイルにエントリが存在しない");
                return false;
            }
            if (-1 == entry.getCrc()) {
                log.debug("ZIPファイルのエントリのCRCチェックサムが不明");
                return false;
            }
            return true;
        } catch (ZipException e) {
            log.debug("ZIPファイルエラー発生:" + e.getMessage());
            return false;
        } catch (IOException e) {
            log.debug("入出力エラー発生:" + e.getMessage());
            return false;
        } finally {
            try {
                if (zipInputStream != null) {
                    zipInputStream.close();
                }
            } catch (IOException e) {
                log.debug("入力ストリームのクローズに失敗:" + e.getMessage());
                return false;
            }
        }
    }
}

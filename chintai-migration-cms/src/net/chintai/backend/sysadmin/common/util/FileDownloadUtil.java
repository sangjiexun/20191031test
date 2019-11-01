package net.chintai.backend.sysadmin.common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * ファイルダウンロードユーティリティクラス
 *
 * @author e-ishii
 * @version $Revision: 4512 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class FileDownloadUtil {

    /**
     * コンストラクタ
     */
    private FileDownloadUtil() {}


    /**
     * ファイルをダウンロードします。
     *
     * @param bean ダウンロードに関する情報を保持するビーン
     * @throws DownloadException ダウンロード時に問題が起こった場合にスローされます。
     */
    public static void download(DownloadFileStatusBean bean) throws DownloadException{

        OutputStream out = null;
        InputStream in = null;

        try {
            bean.getResponse().setContentType(bean.getContentType());
            bean.getResponse().setHeader(
                "Content-Disposition",
                "filename=" + bean.getFileName());

            in = new FileInputStream(bean.getDownloadFilePath());
            out = bean.getResponse().getOutputStream();

            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = in.read(buff, 0, buff.length)) != -1) {
                out.write(buff, 0, len);
            }

        } catch (FileNotFoundException e) {
            throw new DownloadException(e);

        } catch (IOException e) {
            throw new DownloadException(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
     }

}

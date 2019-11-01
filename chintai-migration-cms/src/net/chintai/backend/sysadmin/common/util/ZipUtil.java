package net.chintai.backend.sysadmin.common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class ZipUtil {

    /**
     * 外部からのインスタンス化はできません。
     */
    private ZipUtil() {
    }

    public static void compress(final ZipStatusBean bean, final File[] compressFile, final String[] entryFilename) throws IOException {

    	// レスポンスヘッダー
        bean.getResponse().setContentType(bean.getContentType());
        bean.getResponse().setHeader("Content-Disposition", "attachment; filename=" + bean.getFileName());

		try (
				ZipOutputStream zos  = new ZipOutputStream(new CheckedOutputStream(bean.getResponse().getOutputStream(), new CRC32()), Charset.forName(bean.getCharset()));
			){

			byte[] buf = new byte[1048576];

			for (int i = 0; i < compressFile.length; i++) {
				try (
						BufferedInputStream bis = new BufferedInputStream(new FileInputStream(compressFile[i].toString()));
					) {

					if (entryFilename == null) {
						zos.putNextEntry(new ZipEntry(compressFile[i].getName()));
					} else {
						zos.putNextEntry(new ZipEntry(entryFilename[i]));
					}

					int len = 0;
					while ((len = bis.read(buf, 0, buf.length)) != -1) {
						zos.write(buf, 0, len);
					}
				}
			}
		}
	}
}
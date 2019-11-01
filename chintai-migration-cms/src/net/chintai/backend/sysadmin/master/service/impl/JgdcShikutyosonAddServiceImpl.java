/*
 * $Id: JgdcShikutyosonAddServiceImpl.java 4535 2011-11-04 05:46:53Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2011/06/15     BGT)大原       新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.impl;

import java.io.*;

import net.chintai.backend.sysadmin.common.dao.SystemControlDao;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.ftp.FTPClientException;
import net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper;
import net.chintai.backend.sysadmin.common.ftp.impl.FTPClientWrapperImpl;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.properties.ServerProperties;
import net.chintai.backend.sysadmin.master.action.ShikutyosonAddAction;
import net.chintai.backend.sysadmin.master.service.JgdcShikutyosonAddService;
import net.chintai.backend.sysadmin.master.service.bean.JgdcShikutyosonAddInServiceBean;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;

/**
 * ZIPファイルをFTPサーバにアップロード機能を提供するServiceの実装クラス。
 *
 * @author OOHARA Takashi
 * @version $Revision: 4535 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class JgdcShikutyosonAddServiceImpl implements JgdcShikutyosonAddService {

    /** ログインスタンス */
    private static Log log = LogFactory.getLog(ShikutyosonAddAction.class);

    private SystemControlDao systemControlDao;
    public void setSystemControlDao(SystemControlDao dao) {
        systemControlDao = dao;
    }

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.master.service.JgdcShikutyosonAddService#zipUploadToServer(org.apache.struts.upload.FormFile)
	 */
	public void zipUploadToServer(FormFile formFile) throws FTPClientException, ApplicationException, FileNotFoundException, IOException {
		  //getInputStreamメソッドを使用し、入力ストリームを取得
		  InputStream is = formFile.getInputStream();
		  //力ストリームをバッファリング
		  BufferedInputStream inBuffer = new BufferedInputStream(is);
		  //ファイルのアップロード先を指定して、出力ストリームを生成
		  FileOutputStream fos = new FileOutputStream(ServerProperties.getProperty("maf4cFileDir")+ formFile.getFileName());
		  //出力ストリームをバッファリング
		  BufferedOutputStream outBuffer = new BufferedOutputStream(fos);

		  int contents = 0;

		  //入力データがなくなるまで入出力処理を実行
		  while ((contents = inBuffer.read()) != -1) {
		    outBuffer.write(contents);
		  }

		  outBuffer.flush();
		  inBuffer.close();
		  outBuffer.close();

		  //一時領域のアップロードデータを削除
		  formFile.destroy();
	}

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.action.util.service.ZipUploadToFtpServerService#imageUploadToFtpServer(net.chintai.backend.sysadmin.master.action.util.service.bean.ZipUploadToFtpServerInServiceBean)
     */
    public void zipUploadToFtpServer(JgdcShikutyosonAddInServiceBean serviceBean) throws FTPClientException, ApplicationException {

        // FTP接続情報を取得
        String ftpHostName = systemControlDao.selectSystemControlValue("jgdc_upload_send_sv_ftp_ip");
        // FTP各種設定を取得
        String ftpUserName = ApplicationResources.getProperty("master.ftpUserName");
        String ftpPassword = ApplicationResources.getProperty("master.ftpPassword");
        String ftpWorkingDirectory = ApplicationResources.getProperty("master.jgdcAddressDirectory");
        int ftpRetryMaxCount = Integer.valueOf(ApplicationResources.getProperty("master.jgdcAddressFtpRetryCount"));

        // FTP接続情報のチェック
        if (StringUtils.isEmpty(ftpHostName)) {
            throw new NullPointerException("ftpHostName is empty");
        } else if (StringUtils.isEmpty(ftpUserName)) {
            throw new NullPointerException("ftpUserName is empty");
        } else if (StringUtils.isEmpty(ftpPassword)) {
            throw new NullPointerException("ftpPassword is empty");
        }

        int ftpConnectRetryCount = 0;
        int ftpStoreRetryCount = 0;
        boolean isConnected = false;
        boolean isStored = false;
        FTPClientWrapper ftp = null;
        String ftpStoreFile = ftpWorkingDirectory + serviceBean.getFileName();

        try {
            while (ftpRetryMaxCount >= ftpConnectRetryCount) {
                try {
                    // FTPクライアント生成
                    ftp = new FTPClientWrapperImpl(ftpHostName, ftpUserName, ftpPassword, ftpWorkingDirectory);
                    log.debug("カレント:" + ftp.getWorkingDirectory());
                    // 接続確認
                    isConnected = ftp.isConnected();
                    if (isConnected) {
                        log.debug("FTP接続:" +  Boolean.toString(isConnected));
                        break;
                    } else {
                        ftpConnectRetryCount++;
                        log.debug("FTP接続リトライ=" + Integer.toString(ftpConnectRetryCount));
                    }
                } catch (FTPClientException e) {
                    if (ftpRetryMaxCount <= ftpConnectRetryCount) {
                        throw e;
                    }
                    ftpConnectRetryCount++;
                    log.debug("FTP接続リトライ=" + Integer.toString(ftpConnectRetryCount));
                }
            }
            if (isConnected) {
                while (ftpRetryMaxCount >= ftpStoreRetryCount) {
                    // FTP転送実行
                    isStored = ftp.storeFile(ftpStoreFile, serviceBean.getInputStream());
                    if (isStored) {
                        log.debug("FTP転送:" +  Boolean.toString(isStored));
                        break;
                    } else {
                        ftpStoreRetryCount++;
                        log.debug("FTP転送リトライ=" + Integer.toString(ftpStoreRetryCount) + ":" + ftp.getReplyString());
                    }
                }
            }

            // 結果確認
            log.debug("FTP接続:" + Boolean.toString(isConnected));
            log.debug("FTP転送:" + Boolean.toString(isStored));
            if (!isConnected || !isStored) {
                log.debug("FTPレスポンス:" + ftp.getReplyString());
                throw new ApplicationException("ERROR.M.MASTER.0023");
            }
        } catch (FTPClientException e) {
            log.error("FTP通信中に例外が発生しました。", e);
            throw e;
        } finally {
            try {
                if (ftp != null) {
                    ftp.disconnect();
                }
            } catch (FTPClientException e) {
                log.error("FTP通信中に例外が発生しました。", e);
                throw e;
            }
        }
    }
}

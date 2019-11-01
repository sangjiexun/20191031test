/*
 * $Id: JgdcShikutyosonAddService.java 4535 2011-11-04 05:46:53Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2011/06/15     BGT)大原       新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.struts.upload.FormFile;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.ftp.FTPClientException;
import net.chintai.backend.sysadmin.master.service.bean.JgdcShikutyosonAddInServiceBean;

/**
 * ZIPファイルをFTPサーバにアップロード機能を提供するService。
 *
 * @author OOHARA Takashi
 * @version $Revision: 4535 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface JgdcShikutyosonAddService {

    /**
     * ZIPファイルをFTPサーバにアップロードする。
     *
     * @param serviceBean ZIPファイルアップロード機能用ServiceBean
     * @throws FTPClientException FTP例外
     * @throws ApplicationException FTPアップロード処理に失敗した場合
     */
    public void zipUploadToFtpServer(JgdcShikutyosonAddInServiceBean serviceBean) throws FTPClientException, ApplicationException;

    public void zipUploadToServer(FormFile formFile) throws FTPClientException, ApplicationException, FileNotFoundException, IOException;

}

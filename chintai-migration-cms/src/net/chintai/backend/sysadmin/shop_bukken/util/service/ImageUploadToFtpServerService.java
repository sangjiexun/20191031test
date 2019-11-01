/*
 * $Id: ImageUploadToFtpServerService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/31  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service;

import java.io.IOException;

import net.chintai.backend.sysadmin.common.ftp.FTPClientException;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUploadToFtpServerInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUploadToFtpServerOutServiceBean;

/**
 * 画像ファイルをFTPサーバにアップロード機能を提供するService。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ImageUploadToFtpServerService {

    /**
     * 画像ファイルをFTPサーバにアップロード
     * 
     * @param inServiceBean アップロードする画像ファイル
     * @return FTPサーバにアップロードした結果
     * @throws FTPClientException FTPエラー
     * @throws IOException ネットワクエラー
     */
    public ImageUploadToFtpServerOutServiceBean imageUploadToFtpServer(ImageUploadToFtpServerInServiceBean inServiceBean)
            throws FTPClientException, IOException;

}

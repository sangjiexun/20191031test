/*
 * $Id: ImageUploadToFtpServerServiceImpl.java 3894 2008-04-23 07:33:09Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/31  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.chintai.backend.sysadmin.common.dao.SystemControlDao;
import net.chintai.backend.sysadmin.common.ftp.FTPClientException;
import net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper;
import net.chintai.backend.sysadmin.common.ftp.impl.FTPClientWrapperImpl;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.shop_bukken.util.service.ImageUploadToFtpServerService;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUploadToFtpServerInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUploadToFtpServerOutServiceBean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPFile;

/**
 * ImageUploadToFtpServerServiceの実装クラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3894 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ImageUploadToFtpServerServiceImpl implements ImageUploadToFtpServerService {

    private static Log log = LogFactory.getLog(ImageUploadToFtpServerServiceImpl.class);

    private SystemControlDao systemControlDao;

    public void setSystemControlDao(SystemControlDao dao) {
        systemControlDao = dao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.util.service.ImageUploadToFtpServerService#imageUploadToFtpServer(net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUploadToFtpServerInServiceBean)
     */
    public ImageUploadToFtpServerOutServiceBean imageUploadToFtpServer(
            ImageUploadToFtpServerInServiceBean ftpInServiceBean) throws FTPClientException, IOException {

        // FTP接続情報を取得
        String ftpHostName = systemControlDao.selectSystemControlValue("image_mst_sv_ftp_ip");

        String ftpUserName = ApplicationResources.getProperty("shop.ftpUserName");
        String ftpPassword = ApplicationResources.getProperty("shop.ftpPassword");
        String ftpWorkingDirectory = ApplicationResources.getProperty("shop.ftpWorkingDirectory");
        String tmpImgageFile = ApplicationResources.getProperty("shop.tmpImageFile");

        // 処理基本情報を取得(店舗コードのディレクトリ用)
        String shopCd = ftpInServiceBean.getShopCd();
        String ftpShopDirectory = ftpWorkingDirectory + shopCd;

        // FTP処理結果フラグ、画像配信サーバ用パスを設定。
        ImageUploadToFtpServerOutServiceBean ftpOutServiceBean = new ImageUploadToFtpServerOutServiceBean();
        List<String> imageUrlPathList = new ArrayList<String>();
        List<String> executeServletList = new ArrayList<String>();

        try {

            // FTPクライアント生成
            FTPClientWrapper ftp = new FTPClientWrapperImpl(ftpHostName, ftpUserName, ftpPassword, ftpWorkingDirectory);

            // 画像ファイル伝送成功フラグ
            boolean ftpSuccessFlg = false;

            if (ftp.isConnected()) {

                Map ftpSendImageMap = ftpInServiceBean.getFtpSendFileMap();
                Map executeServletMap = ftpInServiceBean.getExecuteServletMap();

                Iterator it = ftpSendImageMap.entrySet().iterator();
                Entry entry = null;
                String workCode = null;
                String fileLogicalPath = null;
                String logoImageType = null;
                String imageUrlPath = null;
                while (it.hasNext()) {

                    entry = (Entry) it.next();
                    workCode = (String) entry.getKey();
                    fileLogicalPath = (String) ftpSendImageMap.get(workCode);
                    logoImageType =
                            fileLogicalPath.substring(fileLogicalPath.lastIndexOf("."), fileLogicalPath.length());

                    // マスタ画像サーバーへのコピーさせるパスを設定。
                    imageUrlPath = "shop" + "/" + shopCd + "/" + workCode + "/" + shopCd + logoImageType;
                    imageUrlPathList.add(imageUrlPath);

                    // 実行させるServletを設定。
                    if (executeServletMap != null) {
                        executeServletList.add((String) executeServletMap.get(workCode));
                    }

                    boolean existDirFlg = false;
                    FTPFile[] FTPFiles = ftp.listFiles(ftpWorkingDirectory);

                    // 店舗コードのディレクトリの存在チェック
                    for (int i = 0; i < FTPFiles.length; i++) {
                        FTPFile ftpFile = FTPFiles[i];
                        if (shopCd.equals(ftpFile.getName()) && ftpFile.isDirectory()) {
                            existDirFlg = true;
                            break;
                        }
                        existDirFlg = false;
                    }

                    // 店舗コードでディレクトリを生成
                    if (!existDirFlg) {
                        ftp.makeDirectory(ftpShopDirectory + "/" + tmpImgageFile);
                    }

                    FTPFile[] FTPWorkFiles = ftp.listFiles(ftpShopDirectory + "/");

                    // 画像別の作業ディレクトリに画像ファイルをアップロドする。
                    for (int i = 0; i < FTPWorkFiles.length; i++) {
                        if (workCode.equals(FTPWorkFiles[i].getName()) && FTPWorkFiles[i].isDirectory()) {
                            existDirFlg = true;
                            break;
                        }
                        existDirFlg = false;
                    }

                    // 作業フォルダがない場合作業フォルダを生成する。
                    if (!existDirFlg) {
                        ftp.makeDirectory(ftpShopDirectory + "/" + workCode + "/" + tmpImgageFile);
                    }

                    // 画像ファイルをFTPで伝送
                    FileInputStream fis = new FileInputStream(fileLogicalPath);

                    ftpSuccessFlg =
                            ftp.storeFile(ftpShopDirectory + "/" + workCode + "/" + shopCd + logoImageType, fis);

                    if (!ftpSuccessFlg) {
                        break;
                    }
                }
            }
            ftp.disconnect();

            ftpOutServiceBean.setFtpSuccessFlg(ftpSuccessFlg);
            ftpOutServiceBean.setImageUrlPathList(imageUrlPathList);
            ftpOutServiceBean.setExecuteServletList(executeServletList);

            return ftpOutServiceBean;

        } catch (FTPClientException e) {
            log.error("画像マスタサーバとのFTP通信中に例外が発生しました。shopCd=" + shopCd, e);
            throw e;
        } catch (IOException e) {
            log.error("画像マスタサーバとのFTP通信中にI/O例外が発生しました。shopCd=" + shopCd, e);
            throw e;
        }
    }
}

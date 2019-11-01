/*
 * $Id: ImageCopyToMasterServerService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/31  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageCopyToMasterServerInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageCopyToMasterServerOutServiceBean;

/**
 * FTPにアップロードされた画像ファイルを画像配信サーバにコピーするサービスクラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ImageCopyToMasterServerService {

    /**
     * FTPにアップロードされた画像ファイルを画像配信サーバにコピーします。
     * 
     * @param inServiceBean FTPに配置された元ファイルのパス
     * @return 画像配信サーバにコピー結果
     * @throws HttpException HttpClientエラー
     * @throws IOException ネットワクエラー
     */
    public ImageCopyToMasterServerOutServiceBean imageCopyToMasterServer(
            ImageCopyToMasterServerInServiceBean inServiceBean) throws HttpException, IOException;

}

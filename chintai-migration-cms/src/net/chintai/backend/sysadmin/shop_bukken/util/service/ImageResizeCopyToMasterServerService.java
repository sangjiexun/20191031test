/*
 * $Id: ImageResizeCopyToMasterServerService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageResizeCopyToMasterServerInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageResizeCopyToMasterServerOutServiceBean;

/**
 * FTPにアップロードされた画像ファイルを画像の幅をリサイズして 画像配信サーバにコピーするサービスクラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ImageResizeCopyToMasterServerService {

    /**
     * FTPにアップロードされた画像ファイルを画像の幅をリサイズして 画像配信サーバにコピーする
     * 
     * @param inServiceBean 画像ファイルをマスタサーバにコピーする時に使用するInServiceBean
     * @return outServiceBean マスタサーバの画像を参照する時に使用するOutServiceBean
     * @throws Exception
     */
    public ImageResizeCopyToMasterServerOutServiceBean imageCopyToMasterServer(
            ImageResizeCopyToMasterServerInServiceBean inServiceBean) throws HttpException, IOException;

}

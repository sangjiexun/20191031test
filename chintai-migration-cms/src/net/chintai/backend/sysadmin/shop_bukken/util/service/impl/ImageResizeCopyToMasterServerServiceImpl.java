/*
 * $Id: ImageResizeCopyToMasterServerServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service.impl;

import java.io.IOException;

import net.chintai.backend.sysadmin.common.dao.SystemControlDao;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.properties.ServerProperties;
import net.chintai.backend.sysadmin.shop_bukken.util.service.ImageResizeCopyToMasterServerService;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageResizeCopyToMasterServerInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageResizeCopyToMasterServerOutServiceBean;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ImageResizeCopyToMasterServerServiceの実装クラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ImageResizeCopyToMasterServerServiceImpl implements ImageResizeCopyToMasterServerService {

    private static Log log = LogFactory.getLog(ImageResizeCopyToMasterServerServiceImpl.class);

    private SystemControlDao systemControlDao;

    public void setSystemControlDao(SystemControlDao dao) {
        systemControlDao = dao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.util.service.ImageResizeCopyToMasterServerService#imageCopyToMasterServer(net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageResizeCopyToMasterServerInServiceBean)
     */
    public ImageResizeCopyToMasterServerOutServiceBean imageCopyToMasterServer(
            ImageResizeCopyToMasterServerInServiceBean inServiceBean) throws HttpException, IOException {

        // マスタサーバのURLと元の画像ファイルのパスを取得
        String masterServerUrl = systemControlDao.selectSystemControlValue("image_mst_sv_api_ip");
        String copyServletServerPort = ServerProperties.getProperty("shop.copyServletServerPort");
        String imgCopySuccessMsg = ApplicationResources.getProperty("shop.imgResizeCopySuccessMsg");
        String imageCopyParameter = ApplicationResources.getProperty("shop.imageResizeParameter");
        String imageResizeWidthValue = ApplicationResources.getProperty("shop.imageResizeWidthValue");
        String masterFilePathList = inServiceBean.getMasterPath();

        // マスタサーバーへのコピー結果を渡すOutBeanを生成。
        ImageResizeCopyToMasterServerOutServiceBean imageCopyOutServiceBean =
                new ImageResizeCopyToMasterServerOutServiceBean();

        // 画像送信結果フラグ
        boolean sendSuccessFlg = true;

        String url =
                "http://" + masterServerUrl + copyServletServerPort + "/imagetool/" + imageCopyParameter
                        + masterFilePathList + imageResizeWidthValue;

        // HttpClientを生成。
        HttpClient client = new HttpClient();

        // メッソドを取得
        GetMethod method = new GetMethod(url);

        // リトライハンドルを設定。
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));

        try {
            // マスタサーバに画像をコピーする。
            client.executeMethod(method);
            String errMsg = method.getResponseBodyAsString().substring(0, 15);

            // 送信結果チェック。
            if (!imgCopySuccessMsg.equals(errMsg)) {
                sendSuccessFlg = false;
            }
        } catch (HttpException e) {
            log.error("画像マスタサーバとのHTTP通信中にHTTP例外が発生しました。URL=" + url, e);
        } catch (IOException e) {
            log.error("画像マスタサーバとのHTTP通信中にI/O例外が発生しました。URL=" + url, e);
        } finally {
            method.releaseConnection();
        }

        imageCopyOutServiceBean.setSendSuccessFlg(sendSuccessFlg);
        return imageCopyOutServiceBean;

    }

}

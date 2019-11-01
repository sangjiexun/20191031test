/*
 * $Id: ImageCopyToMasterServerServiceImpl.java 4580 2013-05-13 05:28:04Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/31  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service.impl;

import java.io.IOException;

import net.chintai.backend.sysadmin.common.dao.SystemControlDao;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.properties.ServerProperties;
import net.chintai.backend.sysadmin.shop_bukken.util.service.ImageCopyToMasterServerService;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageCopyToMasterServerInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageCopyToMasterServerOutServiceBean;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ImageCopyToMasterServerServiceの実装クラス
 *
 * @author Sim-JongYeon
 * @version $Revision: 4580 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ImageCopyToMasterServerServiceImpl implements ImageCopyToMasterServerService {

    private static Log log = LogFactory.getLog(ImageCopyToMasterServerServiceImpl.class);

    private SystemControlDao systemControlDao;

    public void setSystemControlDao(SystemControlDao dao) {
        systemControlDao = dao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.util.service.ImageCopyToMasterServerService#imageCopyToMasterServer(java.lang.String)
     */
    public ImageCopyToMasterServerOutServiceBean imageCopyToMasterServer(
            ImageCopyToMasterServerInServiceBean imageCopyInServiceBean) throws HttpException, IOException {

        // マスタサーバのURLと元の画像ファイルのパスを取得
        String masterServerUrl = systemControlDao.selectSystemControlValue("image_mst_sv_api_ip");
        String copyServletServerPort = ServerProperties.getProperty("shop.copyServletServerPort");
        String imgCopySuccessMsg = ApplicationResources.getProperty("shop.imgCopySuccessMsg");
        String imageCopyParameter = ApplicationResources.getProperty("shop.imageCopyParameter");
        String masterFilePathList = imageCopyInServiceBean.getMasterPath();

        // マスタサーバーへのコピー結果を渡すOutBeanを生成。
        ImageCopyToMasterServerOutServiceBean imageCopyOutServiceBean = new ImageCopyToMasterServerOutServiceBean();

        // 画像送信結果フラグ
        boolean sendSuccessFlg = true;

        String url =
                "http://" + masterServerUrl + copyServletServerPort + "/imagetool/" + imageCopyParameter
                        + masterFilePathList;

        // HttpClientを生成。
        HttpClient client = new HttpClient();

        // メッソドを取得
        GetMethod method = new GetMethod(url);

        // リトライハンドルを設定。
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));

        try {
            // マスタサーバに画像をコピーする。
            client.executeMethod(method);
            String errMsg = method.getResponseBodyAsString().substring(0, 13);

            // 送信結果チェック。
            if (!imgCopySuccessMsg.equals(errMsg)) {
                sendSuccessFlg = false;
            }

        } catch (HttpException e) {
            log.error("画像マスタサーバとのHTTP通信中にHTTP例外が発生しました。URL=" + url, e);
            throw e;
        } catch (IOException e) {
            log.error("画像マスタサーバとのHTTP通信中にI/O例外が発生しました。URL=" + url, e);
            throw e;
        } finally {
            if (method != null) {
                method.releaseConnection();
            }
        }

        imageCopyOutServiceBean.setSendSuccessFlg(sendSuccessFlg);
        return imageCopyOutServiceBean;

    }

}

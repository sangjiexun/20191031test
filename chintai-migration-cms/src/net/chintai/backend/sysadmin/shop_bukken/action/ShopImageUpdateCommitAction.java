/*
 * $Id: ShopImageUpdateCommitAction.java 4580 2013-05-13 05:28:04Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)沈鍾沿     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.net.ConnectException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.ftp.FTPClientException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.ImageUtils;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopImageUpdateConfirmView;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopImageUpdateCommitDbService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopImageUpdateCommitDbInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.ImageCopyToMasterServerService;
import net.chintai.backend.sysadmin.shop_bukken.util.service.ImageResizeCopyToMasterServerService;
import net.chintai.backend.sysadmin.shop_bukken.util.service.ImageUploadToFtpServerService;
import net.chintai.backend.sysadmin.shop_bukken.util.service.ImageWidthSizeCheckService;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageCopyToMasterServerInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageCopyToMasterServerOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageResizeCopyToMasterServerInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageResizeCopyToMasterServerOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUploadToFtpServerInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUploadToFtpServerOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageWidthSizeCheckInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageWidthSizeCheckOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 店舗画像を更新完了して、店舗詳細画面を表示するアクション
 *
 * @author Sim-JongYeon
 * @version $Revision: 4580 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopImageUpdateCommitAction extends BaseActionSupport {


    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面リロード対策
        if (!isTokenValid(context.getRequest())) {
            context.setForward("success");
            return;
        }
        resetToken(context.getRequest());

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ShopImageUpdateConfirmView view = new ShopImageUpdateConfirmView();
        BeanUtils.copyProperties(view, form);

        String shopMapPctFileLogicalPath = (String) form.get("shopMapPctFileLogicalPath");
        String shopPhoto1FileLogicalPath = (String) form.get("shopPhoto1FileLogicalPath");
        String shopPhoto2FileLogicalPath = (String) form.get("shopPhoto2FileLogicalPath");
        String shopPhoto3FileLogicalPath = (String) form.get("shopPhoto3FileLogicalPath");
        String shopPhoto4FileLogicalPath = (String) form.get("shopPhoto4FileLogicalPath");

        // 画像別作業コードを取得。
        String mapPctWorkCode = ApplicationResources.getProperty("shop.mapPctWorkCode");
        String photo1WorkCode = ApplicationResources.getProperty("shop.photo1WorkCode");
        String photo2WorkCode = ApplicationResources.getProperty("shop.photo2WorkCode");
        String photo3WorkCode = ApplicationResources.getProperty("shop.photo3WorkCode");
        String photo4WorkCode = ApplicationResources.getProperty("shop.photo4WorkCode");

        // 画像ファイルをマップに設定。
        Map<String, String> ftpSendFileMap = new HashMap<String, String>();
        if (shopMapPctFileLogicalPath.length() > 0) {
            ftpSendFileMap.put(mapPctWorkCode, shopMapPctFileLogicalPath);
        }
        if (shopPhoto1FileLogicalPath.length() > 0) {
            ftpSendFileMap.put(photo1WorkCode, shopPhoto1FileLogicalPath);
        }
        if (shopPhoto2FileLogicalPath.length() > 0) {
            ftpSendFileMap.put(photo2WorkCode, shopPhoto2FileLogicalPath);
        }
        if (shopPhoto3FileLogicalPath.length() > 0) {
            ftpSendFileMap.put(photo3WorkCode, shopPhoto3FileLogicalPath);
        }
        if (shopPhoto4FileLogicalPath.length() > 0) {
            ftpSendFileMap.put(photo4WorkCode, shopPhoto4FileLogicalPath);
        }

        // エラーフラグ設定
        boolean errFlg = true;

        // ApplicationContext 設定。
        ApplicationContext ac = getWebApplicationContext();

        // 画像の幅サイズチェックの結果を取得するOutServiceBeanを設定
        ImageWidthSizeCheckOutServiceBean imageWidthSizeCheckOutServiceBean = null;

        // 画像別幅のチェック。
        {
            // 画像別幅サイズをチェックして、実行させるServletを決める。
            ImageWidthSizeCheckService imageWidthSizeCheckOutService =
                    (ImageWidthSizeCheckService) ac.getBean("imageWidthSizeCheckService");

            // チェックする画像ファイルをInServiceBeanに設定。
            ImageWidthSizeCheckInServiceBean imageWidthSizeCheckInServiceBean = new ImageWidthSizeCheckInServiceBean();
            imageWidthSizeCheckInServiceBean.setImgLogicalPathMap(ftpSendFileMap);

            // 画像ファイルの幅サイズチェックを実行。
            imageWidthSizeCheckOutServiceBean =
                    imageWidthSizeCheckOutService.getWidthHeight(imageWidthSizeCheckInServiceBean);
        }

        // FTP送信結果を取得するOutServiceBeanを設定
        ImageUploadToFtpServerOutServiceBean ftpOutServiceBean = null;

        // 画像別FTP送信。
        {
            // FTP用InServiceBean にFTP送信する情報を設定。
            ImageUploadToFtpServerInServiceBean ftpInServiceBean = new ImageUploadToFtpServerInServiceBean();
            ftpInServiceBean.setShopCd((String) form.get("shopCd"));
            ftpInServiceBean.setFtpSendFileMap(ftpSendFileMap);
            ftpInServiceBean.setExecuteServletMap(imageWidthSizeCheckOutServiceBean.getExecuteServletMap());

            // FTP送信Service Injection
            ImageUploadToFtpServerService imageUploadToFtpServerService =
                    (ImageUploadToFtpServerService) ac.getBean("imageUploadToFtpServerService");

            // FTP 送信 実行
            try{
                ftpOutServiceBean = imageUploadToFtpServerService.imageUploadToFtpServer(ftpInServiceBean);
            }catch(FTPClientException e){
                errFlg = false;
            }
        }

        // FTP処理成功
        if (errFlg) {

            // 実行させるServletのフラグを取得する。
            String imageResizeServlet = ApplicationResources.getProperty("shop.imageResize");
            String imageCopyServlet = ApplicationResources.getProperty("shop.imageCopy");

            // 画像配信(copyServlet) Service Bean。
            ImageCopyToMasterServerService imageCopyToMasterServerService =
                    (ImageCopyToMasterServerService) ac.getBean("imageCopyToMasterServerService");

            // 画像サーバーにコピーする画像ファイルをInBeanに設定。
            ImageCopyToMasterServerInServiceBean imageCopyInServiceBean = new ImageCopyToMasterServerInServiceBean();

            ImageCopyToMasterServerOutServiceBean imageCopyOutServiceBean = null;

            // 画像配信(resizeCopyServlet) Service Bean。
            ImageResizeCopyToMasterServerService imageResizeCopyToMasterServerService =
                    (ImageResizeCopyToMasterServerService) ac.getBean("imageResizeCopyToMasterServerService");

            ImageResizeCopyToMasterServerInServiceBean imageResizeCopyToMasterServerInServiceBean =
                    new ImageResizeCopyToMasterServerInServiceBean();

            ImageResizeCopyToMasterServerOutServiceBean imageResizeCopyToMasterServerOutServiceBean = null;

            // 画像サーバーにコピーする画像リストを取得する。
            List<String> imgCopyList = ftpOutServiceBean.getImageUrlPathList();

            // 実行させるServletリストを取得する。
            List<String> executeServletList = ftpOutServiceBean.getExecuteServletList();

            for (int i = 0; i < imgCopyList.size(); i++) {

                // 実行させる該当Servletを取得する。
                String executeServlet = executeServletList.get(i);

                // Servlet を実行。
                if (imageResizeServlet.equals(executeServlet)) {
                    imageResizeCopyToMasterServerInServiceBean.setMasterPath(imgCopyList.get(i));

                    try{
                        // 画像サーバーへのコピーを実行
                        imageResizeCopyToMasterServerOutServiceBean =
                                imageResizeCopyToMasterServerService
                                        .imageCopyToMasterServer(imageResizeCopyToMasterServerInServiceBean);
                    }catch(ConnectException e){
                        errFlg = false;
                        break;
                    }

                    if (!imageResizeCopyToMasterServerOutServiceBean.getSendSuccessFlg()) {
                        errFlg = false;
                        break;
                    }
                } else if (imageCopyServlet.equals(executeServlet)) {
                    imageCopyInServiceBean.setMasterPath(imgCopyList.get(i));

                    try{
                        // 画像サーバーへのコピーを実行
                        imageCopyOutServiceBean =
                                imageCopyToMasterServerService.imageCopyToMasterServer(imageCopyInServiceBean);
                    }catch(ConnectException e){
                        errFlg = false;
                        break;
                    }

                    if (!imageCopyOutServiceBean.getSendSuccessFlg()) {
                        errFlg = false;
                        break;
                    }
                }
            }

            // FTP送信やServletの実行でエラー発生されなかった場合のみ
            // DBを更新する。
            if (errFlg) {

                // 画像サーバへのコピー完了後、APサーバの臨時ファイルを削除
                ImageUtils.deleteTmpImg(form);

                // Injection
                ShopImageUpdateCommitDbService shopImageUpdateCommitDbService =
                        (ShopImageUpdateCommitDbService) ac.getBean("shopImageUpdateCommitDbService");

                // 更新する店舗画像のフラグを取得。
                ShopImageUpdateCommitDbInServiceBean dbInServiceBean = new ShopImageUpdateCommitDbInServiceBean();
                BeanUtils.copyProperties(dbInServiceBean, form);

                // 店舗地図
                if (StringUtils.isNotEmpty(shopMapPctFileLogicalPath)) {
                    dbInServiceBean.setShopMapPctFlgOrg(ConstValues.FLG_ON);
                } else {
                    dbInServiceBean.setShopMapPctFlgOrg((String) form.get("shopMapPctFlgOrg"));
                }

                // 店舗画像1
                if (StringUtils.isNotEmpty(shopPhoto1FileLogicalPath)) {
                    dbInServiceBean.setShopPhoto1FlgOrg(ConstValues.FLG_ON);
                } else {
                    dbInServiceBean.setShopPhoto1FlgOrg((String) form.get("shopPhoto1FlgOrg"));
                }

                // 店舗画像2
                if (StringUtils.isNotEmpty(shopPhoto2FileLogicalPath)) {
                    dbInServiceBean.setShopPhoto2FlgOrg(ConstValues.FLG_ON);
                } else {
                    dbInServiceBean.setShopPhoto2FlgOrg((String) form.get("shopPhoto2FlgOrg"));
                }

                // 店舗画像3
                if (StringUtils.isNotEmpty(shopPhoto3FileLogicalPath)) {
                    dbInServiceBean.setShopPhoto3FlgOrg(ConstValues.FLG_ON);
                } else {
                    dbInServiceBean.setShopPhoto3FlgOrg((String) form.get("shopPhoto3FlgOrg"));
                }

                // 店舗画像4
                if (StringUtils.isNotEmpty(shopPhoto4FileLogicalPath)) {
                    dbInServiceBean.setShopPhoto4FlgOrg(ConstValues.FLG_ON);
                } else {
                    dbInServiceBean.setShopPhoto4FlgOrg((String) form.get("shopPhoto4FlgOrg"));
                }

                // 店舗地図コメント
                dbInServiceBean.setShopMapPctComment(form.getString("editedMapPctComment"));
                dbInServiceBean.setShopPhoto1Comment(form.getString("editedPhoto1Comment"));
                dbInServiceBean.setShopPhoto2Comment(form.getString("editedPhoto2Comment"));
                dbInServiceBean.setShopPhoto3Comment(form.getString("editedPhoto3Comment"));
                dbInServiceBean.setShopPhoto4Comment(form.getString("editedPhoto4Comment"));

                dbInServiceBean.setUpdId(context.getSessionBean().getUserId());
                dbInServiceBean.setUpdDt((String) form.get("updDt"));
                dbInServiceBean.setUpdPg(this.getClass().getName());

                // 操作ログ記録サービス
                OperationLoggingService loggingService =
                        (OperationLoggingService) ac.getBean("operationLoggingService");

                String operUserId = context.getSessionBean().getUserId();

                try {
                    // 取得した店舗画像フラグで、DBに反映。
                    shopImageUpdateCommitDbService.shopImageUpdateCommitDb(dbInServiceBean);

                    context.setMessage("INFO.M.SHOP_BUKKEN.0011", ApplicationResources.getProperty("shop.imgFile"));

                    // 更新成功ログ、メッセージ設定
                    loggingService.write("01009", operUserId, SessionStatus.SUCCESS, "店舗コード "
                            + (String) form.get("shopCd"), this.getClass().getName());

                } catch (ApplicationException e) {

                    // 二重更新防止トークンをセット
                    saveToken(context.getRequest());

                    // 登録失敗ログ
                    loggingService.write("01009", operUserId, SessionStatus.FAILURE, "店舗コード "
                            + (String) form.get("shopCd"), this.getClass().getName());

                    context.setError("ERROR.M.SHOP_BUKKEN.0011");
                    context.setForward("fail", view);
                    return;
                }

            }
            // FTPエラー
        } else {
            errFlg = false;
        }

        if (!errFlg) {
            context.setError("ERROR.M.SHOP_BUKKEN.0008");
            context.setForward("fail", view);
            return;
        }else{
            context.setForward("success");
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }

}

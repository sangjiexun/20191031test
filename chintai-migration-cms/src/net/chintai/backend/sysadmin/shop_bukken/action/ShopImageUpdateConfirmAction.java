/*
 * $Id: ShopImageUpdateConfirmAction.java 4577 2013-05-13 04:56:44Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)沈鍾沿     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.addata_matching.action.AdDataUploadAction;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.properties.ServerProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.ValidatorUtils;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopImageUpdateConfirmView;
import net.chintai.backend.sysadmin.shop_bukken.service.UploadImageFileService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.UploadImageFileInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.UploadImageFileOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 店舗画像更新確認画面を表示するアクション
 *
 * @author Sim-JongYeon
 * @version $Revision: 4577 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopImageUpdateConfirmAction extends BaseActionSupport {

    /** 画像更新フラグ:更新中 */
    private static final String C_IMG_UPDATING = "1";

    /** 画像更新フラグ:更新中以外 */
    private static final String C_IMG_UPDATING_ETC = "0";

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai
     * .backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        boolean errFlg = true;

        // 入力された店舗地図画像をチェックする
        FormFile shopMapPicFile = (FormFile) form.get("shopMapPctFile");
        if (!StringUtils.isEmpty(shopMapPicFile.getFileName())) {

            // 画像のサイズが0byte、又はパスが正しいかどうかをチェックする。
            if (shopMapPicFile.getFileSize() == 0) {
                context.setError("WARN.M.SHOP_BUKKEN.0120",
                        ApplicationResources.getProperty("shop.mapFile"));
                errFlg = false;
            }

            // GIF形式をチェックする。
            if (ValidatorUtils.isNotGIF(shopMapPicFile.getFileName())) {
                context.setError("WARN.M.SHOP_BUKKEN.0051",
                        ApplicationResources.getProperty("shop.mapFile"),
                        ApplicationResources.getProperty("shop.gifFileExtensions").substring(1),
                        ApplicationResources.getProperty("shop.common.img"));
                errFlg = false;
            }

            // 画像ファイルのサイズをチェック。
            if (ValidatorUtils.isInvalidMapFileSize(shopMapPicFile.getFileSize())) {
                context.setError("WARN.M.SHOP_BUKKEN.0115",
                        ApplicationResources.getProperty("shop.mapFile"),
                        ApplicationResources.getProperty("shop.mapPctLimit"));
                errFlg = false;
            }
        }

        // 入力された店舗画像1(店外写真)をチェックする。
        FormFile shopPhoto1File = (FormFile) form.get("shopPhoto1File");
        if (!StringUtils.isEmpty(shopPhoto1File.getFileName())) {

            // 画像のサイズが0byte、又はパスが正しいかどうかをチェックする。
            if (shopPhoto1File.getFileSize() == 0) {
                context.setError("WARN.M.SHOP_BUKKEN.0121",
                        ApplicationResources.getProperty("shop.photo1"));
                errFlg = false;
            }

            // JPG形式をチェックする。
            if (ValidatorUtils.isNotJPG(shopPhoto1File.getFileName())) {
                context.setError("WARN.M.SHOP_BUKKEN.0052",
                        ApplicationResources.getProperty("shop.photo1"),
                        ApplicationResources.getProperty("shop.jpgFileExtensions").substring(1),
                        ApplicationResources.getProperty("shop.common.img"));
                errFlg = false;
            }

            // 画像ファイルのサイズをチェック。
            if (ValidatorUtils.isInvalidShopPhotoFileSize(shopPhoto1File.getFileSize())) {
                context.setError("WARN.M.SHOP_BUKKEN.0116",
                        ApplicationResources.getProperty("shop.photo1"),
                        ApplicationResources.getProperty("shop.shopPhotoLimit"));
                errFlg = false;
            }
        }

        // 入力された店舗画像2(スタッフ写真)をチェックする。
        FormFile shopPhoto2File = (FormFile) form.get("shopPhoto2File");
        if (!StringUtils.isEmpty(shopPhoto2File.getFileName())) {

            // 画像のサイズが0byte、又はパスが正しいかどうかをチェックする。
            if (shopPhoto2File.getFileSize() == 0) {
                context.setError("WARN.M.SHOP_BUKKEN.0122",
                        ApplicationResources.getProperty("shop.photo2"));
                errFlg = false;
            }

            // JPG形式をチェックする。
            if (ValidatorUtils.isNotJPG(shopPhoto2File.getFileName())) {
                context.setError("WARN.M.SHOP_BUKKEN.0112",
                        ApplicationResources.getProperty("shop.photo2"),
                        ApplicationResources.getProperty("shop.jpgFileExtensions").substring(1),
                        ApplicationResources.getProperty("shop.common.img"));
                errFlg = false;
            }

            // 画像ファイルのサイズをチェック。
            if (ValidatorUtils.isInvalidShopPhotoFileSize(shopPhoto2File.getFileSize())) {
                context.setError("WARN.M.SHOP_BUKKEN.0117",
                        ApplicationResources.getProperty("shop.photo2"),
                        ApplicationResources.getProperty("shop.shopPhotoLimit"));
                errFlg = false;
            }
        }

        // 入力された店舗画像3(店外写真)をチェックする。
        FormFile shopPhoto3File = (FormFile) form.get("shopPhoto3File");
        if (!StringUtils.isEmpty(shopPhoto3File.getFileName())) {

            // 画像のサイズが0byte、又はパスが正しいかどうかをチェックする。
            if (shopPhoto3File.getFileSize() == 0) {
                context.setError("WARN.M.SHOP_BUKKEN.0123",
                        ApplicationResources.getProperty("shop.photo3"));
                errFlg = false;
            }

            // JPG形式をチェックする。
            if (ValidatorUtils.isNotJPG(shopPhoto3File.getFileName())) {
                context.setError("WARN.M.SHOP_BUKKEN.0113",
                        ApplicationResources.getProperty("shop.photo3"),
                        ApplicationResources.getProperty("shop.jpgFileExtensions").substring(1),
                        ApplicationResources.getProperty("shop.common.img"));
                errFlg = false;
            }

            // 画像ファイルのサイズをチェック。
            if (ValidatorUtils.isInvalidShopPhotoFileSize(shopPhoto3File.getFileSize())) {
                context.setError("WARN.M.SHOP_BUKKEN.0118",
                        ApplicationResources.getProperty("shop.photo3"),
                        ApplicationResources.getProperty("shop.shopPhotoLimit"));
                errFlg = false;
            }
        }

        // 入力された店舗画像4(スタッフ接客写真)をチェックする。
        FormFile shopPhoto4File = (FormFile) form.get("shopPhoto4File");
        if (!StringUtils.isEmpty(shopPhoto4File.getFileName())) {

            // 画像のサイズが0byte、又はパスが正しいかどうかをチェックする。
            if (shopPhoto4File.getFileSize() == 0) {
                context.setError("WARN.M.SHOP_BUKKEN.0124",
                        ApplicationResources.getProperty("shop.photo4"));
                errFlg = false;
            }

            // JPG形式をチェックする。
            if (ValidatorUtils.isNotJPG(shopPhoto4File.getFileName())) {
                context.setError("WARN.M.SHOP_BUKKEN.0114",
                        ApplicationResources.getProperty("shop.photo4"),
                        ApplicationResources.getProperty("shop.jpgFileExtensions").substring(1),
                        ApplicationResources.getProperty("shop.common.img"));
                errFlg = false;
            }

            // 画像ファイルのサイズをチェック。
            if (ValidatorUtils.isInvalidShopPhotoFileSize(shopPhoto4File.getFileSize())) {
                context.setError("WARN.M.SHOP_BUKKEN.0119",
                        ApplicationResources.getProperty("shop.photo4"),
                        ApplicationResources.getProperty("shop.shopPhotoLimit"));
                errFlg = false;
            }
        }

        // 店舗地図コメントのクロススクリプトチェック
        String editedMapPctComment = form.getString("editedMapPctComment");
        if (!ValidatorUtils.validateScripting(editedMapPctComment)) {
            context.setError("WARN.M.SHOP_BUKKEN.0102",
                    ApplicationResources.getProperty("shop.mapPctComment"));
            errFlg = false;
        }

        // 店舗地図コメントの長さチェック
        int mapPctCommentLimit =
                Integer.parseInt(ApplicationResources.getProperty("shop.mapPctCommentLimit"));
        if (StringUtils.isNotEmpty(editedMapPctComment)
                && editedMapPctComment.replace("\r\n","\n").length() > mapPctCommentLimit) {
            context.setError("WARN.M.SHOP_BUKKEN.0101",
                    ApplicationResources.getProperty("shop.mapPctComment"),
                    ApplicationResources.getProperty("shop.mapPctCommentLimit"));
            errFlg = false;
        }

        // 店舗画像１コメントのクロススクリプトチェック
        String editedPhoto1Comment = form.getString("editedPhoto1Comment");
        if (!ValidatorUtils.validateScripting(editedPhoto1Comment)) {
            context.setError("WARN.M.SHOP_BUKKEN.0104",
                    ApplicationResources.getProperty("shop.photo1Comment"));
            errFlg = false;
        }

        // 店舗画像１コメントの長さチェック
        int photoCommentLimit =
                Integer.parseInt(ApplicationResources.getProperty("shop.photoCommentLimit"));
        if (StringUtils.isNotEmpty(editedPhoto1Comment)
                && editedPhoto1Comment.replace("\r\n","\n").length() > photoCommentLimit) {
            context.setError("WARN.M.SHOP_BUKKEN.0103",
                    ApplicationResources.getProperty("shop.photo1Comment"),
                    ApplicationResources.getProperty("shop.photoCommentLimit"));
            errFlg = false;
        }

        // 店舗画像２コメントのクロススクリプトチェック
        String editedPhoto2Comment = form.getString("editedPhoto2Comment");
        if (!ValidatorUtils.validateScripting(editedPhoto2Comment)) {
            context.setError("WARN.M.SHOP_BUKKEN.0106",
                    ApplicationResources.getProperty("shop.photo2Comment"));
            errFlg = false;
        }

        // 店舗画像２コメントの長さチェック
        if (StringUtils.isNotEmpty(editedPhoto2Comment)
                && editedPhoto2Comment.replace("\r\n","\n").length() > photoCommentLimit) {
            context.setError("WARN.M.SHOP_BUKKEN.0105",
                    ApplicationResources.getProperty("shop.photo2Comment"),
                    ApplicationResources.getProperty("shop.photoCommentLimit"));
            errFlg = false;
        }

        // 店舗画像３コメントのクロススクリプトチェック
        String editedPhoto3Comment = form.getString("editedPhoto3Comment");
        if (!ValidatorUtils.validateScripting(editedPhoto3Comment)) {
            context.setError("WARN.M.SHOP_BUKKEN.0108",
                    ApplicationResources.getProperty("shop.photo3Comment"));
            errFlg = false;
        }

        // 店舗画像３コメントの長さチェック
        if (StringUtils.isNotEmpty(editedPhoto3Comment)
                && editedPhoto3Comment.replace("\r\n","\n").length() > photoCommentLimit) {
            context.setError("WARN.M.SHOP_BUKKEN.0107",
                    ApplicationResources.getProperty("shop.photo3Comment"),
                    ApplicationResources.getProperty("shop.photoCommentLimit"));
            errFlg = false;
        }

        // 店舗画像４コメントのクロススクリプトチェック
        String editedPhoto4Comment = form.getString("editedPhoto4Comment");
        if (!ValidatorUtils.validateScripting(editedPhoto4Comment)) {
            context.setError("WARN.M.SHOP_BUKKEN.0110",
                    ApplicationResources.getProperty("shop.photo4Comment"));
            errFlg = false;
        }

        // 店舗画像４コメントの長さチェック
        if (StringUtils.isNotEmpty(editedPhoto4Comment)
                && editedPhoto4Comment.replace("\r\n","\n").length() > photoCommentLimit) {
            context.setError("WARN.M.SHOP_BUKKEN.0109",
                    ApplicationResources.getProperty("shop.photo4Comment"),
                    ApplicationResources.getProperty("shop.photoCommentLimit"));
            errFlg = false;
        }

        // 各チェック後、エラーが発生する場合はエラーメッセージを表示させる。
        if (!errFlg) {
            context.setForward("fail");
            return;
        }

        // アップロード先をチェックする。
        File tmpStoreDir = new File(ServerProperties.getProperty("shop.tmpStoreDirForShopImg"));
        if (!tmpStoreDir.exists()) {
            if (!tmpStoreDir.mkdirs()) {
                context.setError("ERROR.M.SHOP_BUKKEN.0013",
                        ApplicationResources.getProperty("shop.imgFile"));
                context.setForward("fail");
                return;
            }
        }

        // 店舗画像別作業コードを取得
        List<String> workCodeList = new ArrayList<String>();
        workCodeList.add(ApplicationResources.getProperty("shop.mapPctWorkCode"));
        workCodeList.add(ApplicationResources.getProperty("shop.photo1WorkCode"));
        workCodeList.add(ApplicationResources.getProperty("shop.photo2WorkCode"));
        workCodeList.add(ApplicationResources.getProperty("shop.photo3WorkCode"));
        workCodeList.add(ApplicationResources.getProperty("shop.photo4WorkCode"));

        // アップロード用InBeanを生成。
        UploadImageFileInServiceBean uploadInServiceBean = new UploadImageFileInServiceBean();
        uploadInServiceBean.setShopCd((String) form.get("shopCd"));
        uploadInServiceBean.setSessionId(context.getRequest().getSession().getId());

        Map<String, FormFile> uploadFileMap = new HashMap<String, FormFile>();

        // アップロードさせる画像ファイルをInBeanに設定。
        // 店舗画像ファイルを格納
        List<FormFile> formFileList = new ArrayList<FormFile>();
        formFileList.add(shopMapPicFile);
        formFileList.add(shopPhoto1File);
        formFileList.add(shopPhoto2File);
        formFileList.add(shopPhoto3File);
        formFileList.add(shopPhoto4File);

        for (int i = 0; i < formFileList.size(); i++) {
            FormFile ff = (FormFile) formFileList.get(i);
            if (StringUtils.isNotEmpty(ff.getFileName())) {
                uploadFileMap.put(workCodeList.get(i), ff);
            }
        }
        uploadInServiceBean.setUploadFileMap(uploadFileMap);

        // アップロードService Injection
        ApplicationContext ac = getWebApplicationContext();
        UploadImageFileService uploadImageFileService =
                (UploadImageFileService) ac.getBean("uploadImageFileService");

        // アップロードServiceを呼び出し。
        UploadImageFileOutServiceBean uploadOutServiceBean = null;

        try {
            uploadOutServiceBean = uploadImageFileService.uploadImageFile(uploadInServiceBean);
        } catch (IOException e) {
            errFlg = false;
        }

        if (errFlg) {
            // 店舗画像情報をViewHelperに設定
            ShopImageUpdateConfirmView view = new ShopImageUpdateConfirmView();
            BeanUtils.copyProperties(view, form);

            // アップロードされた画像のURLパスを取得。
            List<String> workCdList = uploadOutServiceBean.getWorkCdList();
            for (int i = 0; i < workCdList.size(); i++) {

                String imageFileUrlPath = uploadOutServiceBean.getImageFileUrlPathList().get(i);
                String imageFileLogicalPath =
                        uploadOutServiceBean.getImageFileLogicalPathList().get(i);

                if (workCodeList.get(0).equals(workCdList.get(i))) {
                    view.setShopMapPctFileUrlPath(imageFileUrlPath);
                    view.setShopMapPctFileLogicalPath(imageFileLogicalPath);
                    view.setShopMapPctFlgUpdateFlg(C_IMG_UPDATING);
                } else if (workCodeList.get(1).equals(workCdList.get(i))) {
                    view.setShopPhoto1FileUrlPath(imageFileUrlPath);
                    view.setShopPhoto1FileLogicalPath(imageFileLogicalPath);
                    view.setShopPhoto1FlgUpdateFlg(C_IMG_UPDATING);
                } else if (workCodeList.get(2).equals(workCdList.get(i))) {
                    view.setShopPhoto2FileUrlPath(imageFileUrlPath);
                    view.setShopPhoto2FileLogicalPath(imageFileLogicalPath);
                    view.setShopPhoto2FlgUpdateFlg(C_IMG_UPDATING);
                } else if (workCodeList.get(3).equals(workCdList.get(i))) {
                    view.setShopPhoto3FileUrlPath(imageFileUrlPath);
                    view.setShopPhoto3FileLogicalPath(imageFileLogicalPath);
                    view.setShopPhoto3FlgUpdateFlg(C_IMG_UPDATING);
                } else if (workCodeList.get(4).equals(workCdList.get(i))) {
                    view.setShopPhoto4FileUrlPath(imageFileUrlPath);
                    view.setShopPhoto4FileLogicalPath(imageFileLogicalPath);
                    view.setShopPhoto4FlgUpdateFlg(C_IMG_UPDATING);
                }

            }

            // 既存登録された画像が更新されなかった場合、
            // 既存画像を表示するようにマスタ画像サーバーの画像パスを設定。
            if (StringUtils.isEmpty(view.getShopMapPctFileUrlPath())) {
                if (!StringUtils.isEmpty((String) form.get("shopMapPctFilePath"))) {
                    view.setShopMapPctFileUrlPath((String) form.get("shopMapPctFilePath"));
                    view.setShopMapPctFlgUpdateFlg(C_IMG_UPDATING_ETC);
                }
            }
            if (StringUtils.isEmpty(view.getShopPhoto1FileUrlPath())) {
                if (!StringUtils.isEmpty((String) form.get("shopPhoto1FilePath"))) {
                    view.setShopPhoto1FileUrlPath((String) form.get("shopPhoto1FilePath"));
                    view.setShopPhoto1FlgUpdateFlg(C_IMG_UPDATING_ETC);
                }
            }
            if (StringUtils.isEmpty(view.getShopPhoto2FileUrlPath())) {
                if (!StringUtils.isEmpty((String) form.get("shopPhoto2FilePath"))) {
                    view.setShopPhoto2FileUrlPath((String) form.get("shopPhoto2FilePath"));
                    view.setShopPhoto2FlgUpdateFlg(C_IMG_UPDATING_ETC);
                }
            }

            if (StringUtils.isEmpty(view.getShopPhoto3FileUrlPath())) {
                if (!StringUtils.isEmpty((String) form.get("shopPhoto3FilePath"))) {
                    view.setShopPhoto3FileUrlPath((String) form.get("shopPhoto3FilePath"));
                    view.setShopPhoto3FlgUpdateFlg(C_IMG_UPDATING_ETC);
                }
            }

            if (StringUtils.isEmpty(view.getShopPhoto4FileUrlPath())) {
                if (!StringUtils.isEmpty((String) form.get("shopPhoto4FilePath"))) {
                    view.setShopPhoto4FileUrlPath((String) form.get("shopPhoto4FilePath"));
                    view.setShopPhoto4FlgUpdateFlg(C_IMG_UPDATING_ETC);
                }
            }

            // 二重更新防止トークンをセット
            saveToken(context.getRequest());

            context.setForward("success", view);
        }

        if (!errFlg) {
            context.setError("ERROR.M.SHOP_BUKKEN.0006");
            context.setForward("fail");
            return;
        }
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java
     * .lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }

}

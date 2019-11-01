/*
 * $Id: ImageUrlFromMasterServerServiceImpl.java 4295 2009-07-07 12:59:59Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/31  BGT)沈鍾沿     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.properties.ServerProperties;
import net.chintai.backend.sysadmin.shop_bukken.util.service.ImageUrlFromMasterServerService;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUrlFromMasterServerInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUrlFromMasterServerOutServiceBean;

/**
 * ImageUrlFromMasterServerServiceの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 4295 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ImageUrlFromMasterServerServiceImpl implements ImageUrlFromMasterServerService {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.util.service.ImageUrlFromMasterServerService#imageUploadToFtpServer(net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUrlFromMasterServerInServiceBean)
     */
    public ImageUrlFromMasterServerOutServiceBean imageUrlFromMasterServer(
            ImageUrlFromMasterServerInServiceBean imgUrlInServiceBean) {

        // 画像別の作業コード取得(841,821,811,812)
        String imageRefServerUrl = ServerProperties.getProperty("shop.imageRefServerUrl");
        String aspCompanyLogoWorkCode = ApplicationResources.getProperty("shop.aspCompanyLogoWorkCode");
        String mapPctWorkCode = ApplicationResources.getProperty("shop.mapPctWorkCode");
        String photo1WorkCode = ApplicationResources.getProperty("shop.photo1WorkCode");
        String photo2WorkCode = ApplicationResources.getProperty("shop.photo2WorkCode");
        String photo3WorkCode = ApplicationResources.getProperty("shop.photo3WorkCode");
        String photo4WorkCode = ApplicationResources.getProperty("shop.photo4WorkCode");

        String gifFileExtensions = ApplicationResources.getProperty("shop.gifFileExtensions");
        String jpgFileExtensions = ApplicationResources.getProperty("shop.jpgFileExtensions");

        // 店舗コード、作業コードを取得する。
        String shopCd = imgUrlInServiceBean.getShopCd();
        List<String> inWorkCdList = imgUrlInServiceBean.getWorkCdList();

        // 画像配信サーバの画像パスを渡すOutServiceBean
        ImageUrlFromMasterServerOutServiceBean imgUrlOutServiceBean = new ImageUrlFromMasterServerOutServiceBean();
        List<String> outWorkCdList = new ArrayList<String>();
        List<String> imageUrlPathList = new ArrayList<String>();

        // 不動産会社ロゴ用拡張子
        String photoFileExtensions = "." + imgUrlInServiceBean.getPhotoFileExtensions();

        // 画像マスタサーバ上の画像Urlパスを設定する。
        for (int i = 0; i < inWorkCdList.size(); i++) {
            String workCd = inWorkCdList.get(i);
            String imageUrlPath = null;
            String extensions;

            // 拡張子判定
            if (aspCompanyLogoWorkCode.equals(workCd)) {
                extensions = photoFileExtensions;
            } else if (mapPctWorkCode.equals(workCd)) {
                extensions = gifFileExtensions;
            } else if (photo1WorkCode.equals(workCd)) {
                extensions = jpgFileExtensions;
            } else if (photo2WorkCode.equals(workCd)) {
                extensions = jpgFileExtensions;
            } else if (photo3WorkCode.equals(workCd)) {
                extensions = jpgFileExtensions;
            } else if (photo4WorkCode.equals(workCd)) {
                extensions = jpgFileExtensions;
            } else {
                extensions = "";
            }
            imageUrlPath = createImageUrlPath(imageRefServerUrl, shopCd, workCd, extensions);

            outWorkCdList.add(workCd);
            imageUrlPathList.add(imageUrlPath);
        }

        imgUrlOutServiceBean.setWorkCdList(outWorkCdList);
        imgUrlOutServiceBean.setImageUrlPathList(imageUrlPathList);

        return imgUrlOutServiceBean;
    }

    /**
     * 画像URLを生成する内部メソッド。<br>
     * キャッシュ対策のため、無意味なランダム文字列をパラメータとして付加します。
     * @param masterUrl 画像サーバURL
     * @param shopCd 店舗コード
     * @param workCd 画像区分
     * @param extensions 拡張子
     * @return 画像URL
     */
    private String createImageUrlPath(String masterUrl, String shopCd, String workCd, String extensions) {

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        sb.append(masterUrl);
        sb.append("shop/");
        sb.append(shopCd);
        sb.append("/");
        sb.append(workCd);
        sb.append("/");
        sb.append(shopCd);
        sb.append(extensions);
        sb.append("?r=");
        sb.append(Math.abs(random.nextLong())); // 画像キャッシュ対策のため無意味なランダムパラメータを付加
        return sb.toString();
    }
}

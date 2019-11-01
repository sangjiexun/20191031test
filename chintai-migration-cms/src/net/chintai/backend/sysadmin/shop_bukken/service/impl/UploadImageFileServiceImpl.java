/*
 * $Id: UploadImageFileServiceImpl.java 4302 2009-07-13 05:54:31Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/30   BGT)沈鍾沿    新規作成
 * 2008/03/10   BGT)児島      リファクタリング
 * 2009/07/06   BGT)李昊燮    エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.properties.ServerProperties;
import net.chintai.backend.sysadmin.common.util.UploadUtil;
import net.chintai.backend.sysadmin.shop_bukken.service.UploadImageFileService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.UploadImageFileInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.UploadImageFileOutServiceBean;

import org.apache.struts.upload.FormFile;

/**
 * UploadImageFileServiceの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 4302 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UploadImageFileServiceImpl implements UploadImageFileService {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.UploadImageFileService#uploadImageFile(net.chintai.backend.sysadmin.shop_bukken.service.bean.UploadImageFileInServiceBean)
     */
    public UploadImageFileOutServiceBean uploadImageFile(UploadImageFileInServiceBean inBean) throws IOException {

        // アップロード後の結果を渡すBeanを生成
        UploadImageFileOutServiceBean uploadOutServiceBean = new UploadImageFileOutServiceBean();
        List<String> workCdList = new ArrayList<String>();
        List<String> imageFileUrlPathList = new ArrayList<String>();
        List<String> imageFileLogicalPathList = new ArrayList<String>();

        Map<String, FormFile> uploadImageMap = inBean.getUploadFileMap();

        Iterator it = uploadImageMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String workCode = (String) entry.getKey();

            // アップロードする画像ファイルを取得
            FormFile ff = (FormFile) uploadImageMap.get(workCode);
            String fileName = ff.getFileName();
            long fileSize = ff.getFileSize();

            // 画像ファイルをアップロードする。
            if (fileSize > 0) {
                InputStream in = ff.getInputStream();

                // アップロード先情報を取得
                String tmpStoreDir = null;
                String webTmpImgRoot = null;

                // 画像別の作業コード取得(841, 821, 811, 812)
                String aspCompanyLogoWorkCode = ApplicationResources.getProperty("shop.aspCompanyLogoWorkCode");
                String mapPctWorkCode = ApplicationResources.getProperty("shop.mapPctWorkCode");
                String photo1WorkCode = ApplicationResources.getProperty("shop.photo1WorkCode");
                String photo2WorkCode = ApplicationResources.getProperty("shop.photo2WorkCode");
                String photo3WorkCode = ApplicationResources.getProperty("shop.photo3WorkCode");
                String photo4WorkCode = ApplicationResources.getProperty("shop.photo4WorkCode");

                // ファイルの拡張子を取得
                String gifFileExtensions = ApplicationResources.getProperty("shop.gifFileExtensions");
                String jpgFileExtensions = ApplicationResources.getProperty("shop.jpgFileExtensions");

                // 拡張子判定
                String suffix;
                if (aspCompanyLogoWorkCode.equals(workCode)) {
                    suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
                    tmpStoreDir = ServerProperties.getProperty("shop.tmpStoreDir");
                    webTmpImgRoot = ApplicationResources.getProperty("shop.webTmpImgRoot");
                } else if (mapPctWorkCode.equals(workCode)) {
                    suffix = gifFileExtensions;
                    tmpStoreDir = ServerProperties.getProperty("shop.tmpStoreDirForShopImg");
                    webTmpImgRoot = ApplicationResources.getProperty("shop.webTmpImgRootForShopImg");
                } else if (photo1WorkCode.equals(workCode)) {
                    suffix = jpgFileExtensions;
                    tmpStoreDir = ServerProperties.getProperty("shop.tmpStoreDirForShopImg");
                    webTmpImgRoot = ApplicationResources.getProperty("shop.webTmpImgRootForShopImg");
                } else if (photo2WorkCode.equals(workCode)) {
                    suffix = jpgFileExtensions;
                    tmpStoreDir = ServerProperties.getProperty("shop.tmpStoreDirForShopImg");
                    webTmpImgRoot = ApplicationResources.getProperty("shop.webTmpImgRootForShopImg");
                } else if (photo3WorkCode.equals(workCode)) {
                    suffix = jpgFileExtensions;
                    tmpStoreDir = ServerProperties.getProperty("shop.tmpStoreDirForShopImg");
                    webTmpImgRoot = ApplicationResources.getProperty("shop.webTmpImgRootForShopImg");
                } else if (photo4WorkCode.equals(workCode)) {
                    suffix = jpgFileExtensions;
                    tmpStoreDir = ServerProperties.getProperty("shop.tmpStoreDirForShopImg");
                    webTmpImgRoot = ApplicationResources.getProperty("shop.webTmpImgRootForShopImg");
                } else {
                    throw new RuntimeException();
                }

                String uploadFileName = inBean.getShopCd() + workCode + inBean.getSessionId() + suffix;
                String outputPath = tmpStoreDir + uploadFileName;

                // アップロードを実行。
                UploadUtil.upload(in, outputPath);

                workCdList.add(workCode);
                imageFileUrlPathList.add(webTmpImgRoot + uploadFileName);
                imageFileLogicalPathList.add(tmpStoreDir + uploadFileName);

                ff.destroy();
            }
        }

        uploadOutServiceBean.setShopCd(inBean.getShopCd());
        uploadOutServiceBean.setUploadSuccessFlg(true);
        uploadOutServiceBean.setWorkCdList(workCdList);
        uploadOutServiceBean.setImageFileUrlPathList(imageFileUrlPathList);
        uploadOutServiceBean.setImageFileLogicalPathList(imageFileLogicalPathList);

        return uploadOutServiceBean;
    }
}

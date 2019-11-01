/*
 * $Id: ImageWidthSizeCheckServiceImpl.java 4302 2009-07-13 05:54:31Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service.impl;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.shop_bukken.util.service.ImageWidthSizeCheckService;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageWidthSizeCheckInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageWidthSizeCheckOutServiceBean;

/**
 * ImageWidthSizeCheckServiceの実装クラス
 *
 * @author Sim-JongYeon
 * @version $Revision: 4302 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ImageWidthSizeCheckServiceImpl implements ImageWidthSizeCheckService {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.util.service.ImageWidhtHeightService#getWidthHeight(net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageWidhtHeightInServiceBean)
     */
    public ImageWidthSizeCheckOutServiceBean getWidthHeight(ImageWidthSizeCheckInServiceBean inServiceBean)
            throws IOException {

        // 画像チェック条件を取得。
        String imageCopyServlet = ApplicationResources.getProperty("shop.imageCopy");
        String imageResizeServlet = ApplicationResources.getProperty("shop.imageResize");
        int photoFileMaxWidthSize = Integer.parseInt(ApplicationResources.getProperty("shop.photoFileMaxWidthSize"));
        String photo1WorkCode = ApplicationResources.getProperty("shop.photo1WorkCode");
        String photo2WorkCode = ApplicationResources.getProperty("shop.photo2WorkCode");
        String photo3WorkCode = ApplicationResources.getProperty("shop.photo3WorkCode");
        String photo4WorkCode = ApplicationResources.getProperty("shop.photo4WorkCode");

        // チェック結果を渡すマップを設定。
        Map<String, String> executeServletMap = new HashMap<String, String>();

        // マップからチェックするファイルを取得する。
        Map imgLogicalPathMap = inServiceBean.getImgLogicalPathMap();

        Iterator it = imgLogicalPathMap.entrySet().iterator();
        Entry entry = null;
        String workCode = null;
        String fileLogicalPath = null;

        BufferedImage readImage;
        FileInputStream io = null;

        while (it.hasNext()) {

            entry = (Entry) it.next();
            workCode = (String) entry.getKey();

            // 画像が店舗画像(1～4)の場合。
            if (photo1WorkCode.equals(workCode) || photo2WorkCode.equals(workCode) ||
                    photo3WorkCode.equals(workCode) || photo4WorkCode.equals(workCode)) {
                fileLogicalPath = (String) imgLogicalPathMap.get(workCode);

                io = new FileInputStream(fileLogicalPath);
                readImage = ImageIO.read(io);

                // 画像別元の幅サイズを取得する。
                int widthPixcelSize = readImage.getWidth();

                // 幅サイズが227pxを超えるかどうかをチェックする。
                if (widthPixcelSize > photoFileMaxWidthSize) {
                    executeServletMap.put(workCode, imageResizeServlet);
                } else {
                    executeServletMap.put(workCode, imageCopyServlet);
                }
            } else {
                executeServletMap.put(workCode, imageCopyServlet);
            }
        }

        // チェック結果を渡す、OutServiceBeanを設定。
        ImageWidthSizeCheckOutServiceBean outServiceBean = new ImageWidthSizeCheckOutServiceBean();
        outServiceBean.setExecuteServletMap(executeServletMap);

        // 計算結果を渡す。
        return outServiceBean;
    }
}

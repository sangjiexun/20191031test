/*
 * $Id: AspShopInfoServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import jp.co.interoffice.util.Utils;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspShopImgInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.AspShopImageService;
import net.chintai.batch.common.ImgCategory;
import net.chintai.batch.common.ShopBukkenKbn;
import net.chintai.batch.common.domain.MstImgKbn;
import net.chintai.batch.common.domain.ShopRireki;
import net.chintai.batch.common.domain.ShopRirekiImg;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * AspShopImageServiceの実装クラス
 *
 * @author
 * @version $Revision: $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspShopImageServiceImpl implements AspShopImageService {

    @Autowired
    private MasterService masterService;
    @Autowired
    private ShopService shopService;

    /**
     * 店舗コードから、イメージのURLを取得します。
     *
     * @param shopCd
     */
    public ShopRirekiImg getAspShopImage(String shopCd) {

        final ShopRireki shopRireki = this.shopService
                .selectShopRirekiByShopcd(shopCd);

        Map<String, ShopRirekiImg> imgMap;
        try {
            imgMap = Utils.toKeyObject(this.shopService
                    .selectShopRirekiImgByPkShopRireki(shopRireki
                            .getPkShopRireki()), "imgKbn");

        } catch (IllegalArgumentException | IllegalAccessException
                | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        String imgKbn = getImgKubun();
        // 不動産ASPの履歴イメージレコードを返す。
        return imgMap.get(imgKbn);

    }

    /**
     * 店舗画像をアップロードします。
     *
     * @throws IOException
     * @throws IllegalStateException
     *
     */
    public AspShopImgInfo uploadImage(AspShopImgInfo aspImageInfo)
            throws IllegalStateException, IOException {


        final String fileName = this.shopService.toShopImgName(aspImageInfo
                .getShopCd(), getImgKubun(), aspImageInfo.getImgId(),
                aspImageInfo.getFile().getFileName());

        final File f = new File(aspImageInfo.getImgRealPath() + File.separator
                + fileName);

        try {
            OutputStream out = new BufferedOutputStream(new FileOutputStream(
                f.getPath()));
            try {
                out.write(aspImageInfo.getFile().getFileData(), 0,aspImageInfo.getFile().getFileSize() );
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new IOException(e);
        }

        aspImageInfo.setImgUrlPath("/tmp/img/");
        aspImageInfo.setImgFileNm(fileName);

        return aspImageInfo;
    }

    /**
     *
     * @return
     */
    public String getImgKubun() {

        for (MstImgKbn kbn : masterService
                .selectMstImgKbnByShopBukkenKbnAndImgCategory(
                        ShopBukkenKbn.SHOP.getValue(),
                        ImgCategory.ASP_LOGO.getValue())) {
            return kbn.getImgKbn();
        }
        return null;
    }

}

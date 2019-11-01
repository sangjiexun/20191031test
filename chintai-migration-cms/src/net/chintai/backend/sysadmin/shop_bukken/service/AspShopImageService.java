/*
 * $Id: AspShopInfoService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.io.IOException;

import net.chintai.backend.sysadmin.shop_bukken.domain.AspShopImgInfo;
import net.chintai.batch.common.domain.ShopRirekiImg;


/**
 * 不動産ASPで使用するイメージ用サービスクラス
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspShopImageService {

    /**
     * 店舗コードから、イメージのURLを取得します。
     * @param shopCd
     */
    public ShopRirekiImg getAspShopImage(String shopCd);

    /**
     * 店舗画像をアップロードします。
     *
     */
    public AspShopImgInfo uploadImage(AspShopImgInfo aspShopImg) throws IllegalStateException, IOException ;

    /**
     * ASP画像アップロードの画像区分を取得します。
     * @return 画像区分
     */
    public String getImgKubun();
}

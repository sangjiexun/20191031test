/*
 * $Id: ShopImageUpdateCommitDbService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopImageUpdateCommitDbInServiceBean;

/**
 * 店舗画像登録する時にDBを変更するService
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopImageUpdateCommitDbService {

    /**
     * FTP Serverに伝送された店舗画像に対して、SHOP_KANRIのフラグを変更する。
     * 
     * @param inServiceBean 店舗画像フラグ
     * @throws Exception
     */
    public void shopImageUpdateCommitDb(ShopImageUpdateCommitDbInServiceBean inServiceBean)
            throws Exception;
}

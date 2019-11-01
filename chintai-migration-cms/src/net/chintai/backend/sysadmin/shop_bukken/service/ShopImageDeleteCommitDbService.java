/*
 * $Id: ShopImageDeleteCommitDbService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/29  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopImageDeleteCommitDbInServiceBean;


/**
 * 店舗画像を削除する時にDBを変更するService
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopImageDeleteCommitDbService {
    
    /**
     * FTP Server上の削除された店舗画像に対して、SHOP_KANRIのフラグを変更する。
     * 
     * @param inServiceBean 更新する削除された店舗画像のフラグ。
     * @throws Exception
     */
    public void shopImageUpdateCommitDb(ShopImageDeleteCommitDbInServiceBean inServiceBean)
    throws Exception;
}

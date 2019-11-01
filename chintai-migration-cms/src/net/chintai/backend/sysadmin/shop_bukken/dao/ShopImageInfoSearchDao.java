/*
 * $Id: ShopImageInfoSearchDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 店舗画像情報を照会するDao
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopImageInfoSearchDao {

    /**
     * 店舗コードから店舗画像情報を照会する。
     * 
     * @param paramBean 店舗コード
     * @return 取得された店舗画像情報
     */
    public Object selectShopImageInfoSearchByShopCd(ShopImageInfoSearchParamBean paramBean);

}

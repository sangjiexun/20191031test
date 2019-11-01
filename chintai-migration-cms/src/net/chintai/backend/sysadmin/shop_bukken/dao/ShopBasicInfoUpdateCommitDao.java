/*
 * $Id: ShopBasicInfoUpdateCommitDao.java 4295 2009-07-07 12:59:59Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;


/**
 * 店舗基本情報更新DAO
 *
 * @author Lee Hosup
 * @version $Revision: 4295 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopBasicInfoUpdateCommitDao {

    /**
     * 店舗基本情報更新を行う。
     *
     * @param paramBean
     */
    void updateShopBasicInfo(ShopBasicInfoUpdateCommitParamBean paramBean);

}

/*
 * $Id: ShopBindUpdatePageDao.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import net.chintai.backend.sysadmin.demand.domain.ShopBindUpdateDomain;


/**
 * 店舗情報詳細取得DAO
 *
 * @author lee-hosup
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopBindUpdatePageDao {

    /**
     * 店舗詳細情報を検索します。
     * @param paramBean 検索パラメータ（店舗コード）
     * @return 店舗詳細情報
     */
    public ShopBindUpdateDomain getShopInfoDetail(ShopBindUpdatePageParamBean paramBean);

}

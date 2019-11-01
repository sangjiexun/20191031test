/*
 * $Id: KeiyakuRegisterPageDaoImpl.java 4281 2009-07-06 12:10:17Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuRegisterPageDao;

/**
 * KeiyakuRegisterPageDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4281 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuRegisterPageDaoImpl extends SqlMapClientDaoSupport implements
        KeiyakuRegisterPageDao {

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuRegisterPageDao#
     * searchUpdDt(java.lang.String)
     */
    public String searchUpdDt(String shopCd) {
        return (String) getSqlMapClientTemplate().queryForObject(
                "shopListing.searchKeiyakuShopUpdDt", shopCd);
    }

}

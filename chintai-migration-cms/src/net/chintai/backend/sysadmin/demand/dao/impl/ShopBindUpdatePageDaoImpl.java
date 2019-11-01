/*
 * $Id: ShopBindUpdatePageDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.demand.dao.ShopBindUpdatePageDao;
import net.chintai.backend.sysadmin.demand.dao.ShopBindUpdatePageParamBean;
import net.chintai.backend.sysadmin.demand.domain.ShopBindUpdateDomain;

/**
 * ShopBindUpdatePageDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBindUpdatePageDaoImpl extends SqlMapClientDaoSupport implements
        ShopBindUpdatePageDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ShopBindUpdatePageDao#getShopInfoDetail(net.chintai.backend.sysadmin.demand.dao.ShopBindUpdatePageParamBean)
     */
    public ShopBindUpdateDomain getShopInfoDetail(ShopBindUpdatePageParamBean paramBean) {

        return (ShopBindUpdateDomain)
                getSqlMapClientTemplate().queryForObject("demand.selectShopInfoDetail", paramBean);
    }

}

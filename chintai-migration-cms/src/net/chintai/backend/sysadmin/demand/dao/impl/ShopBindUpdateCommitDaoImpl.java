/*
 * $Id: ShopBindUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/16  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.demand.dao.ShopBindUpdateCommitDao;
import net.chintai.backend.sysadmin.demand.dao.ShopBindUpdateCommitParamBean;


/**
 * ShopBindUpdateCommitDaoの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBindUpdateCommitDaoImpl extends SqlMapClientDaoSupport
                                        implements ShopBindUpdateCommitDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ShopBindUpdateCommitDao#updateShopBindInfo(net.chintai.backend.sysadmin.demand.dao.ShopBindUpdateCommitParamBean)
     */
    public void updateShopBindInfo(ShopBindUpdateCommitParamBean paramBean) {

        getSqlMapClientTemplate().update("demand.updateShopBindInfo", paramBean,1);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ShopBindUpdateCommitDao#updateShopBindInfo2(net.chintai.backend.sysadmin.demand.dao.ShopBindUpdateCommitParamBean)
     */
    public int updateShopBindInfo2(ShopBindUpdateCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("demand.updateShopBindInfo2", paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ShopBindUpdateCommitDao#updateLastUpdateTime(net.chintai.backend.sysadmin.demand.dao.ShopBindUpdateCommitParamBean)
     */
    public void updateLastUpdateTime(ShopBindUpdateCommitParamBean paramBean) {
        getSqlMapClientTemplate().update("demand.updateLastUpdateTime", paramBean,1);
    }
}

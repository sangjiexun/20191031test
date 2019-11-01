/*
 * $Id: KeiyakuUpdateCompleteDaoImpl.java 4249 2009-03-24 05:36:55Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/25     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao.impl;

import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuUpdateCompleteDao;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuUpdateCompleteParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * KeiyakuUpdateCompleteDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4249 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuUpdateCompleteDaoImpl extends SqlMapClientDaoSupport implements
        KeiyakuUpdateCompleteDao {

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuUpdateCompleteDao#
     * updateKeiykuInfo
     * (net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuUpdateCompleteParamBean)
     */
    public void updateKeiykuInfo(KeiyakuUpdateCompleteParamBean paramBean) {
        getSqlMapClientTemplate().update("shopListing.updateKeiyakuRireki", paramBean, 1);
    }

}

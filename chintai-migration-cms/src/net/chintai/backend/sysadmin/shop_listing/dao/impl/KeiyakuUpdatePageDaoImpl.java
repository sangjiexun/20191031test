/*
 * $Id: KeiyakuUpdatePageDaoImpl.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/25     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao.impl;

import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuUpdatePageDao;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuUpdatePageParamBean;
import net.chintai.backend.sysadmin.shop_listing.domain.KihonKeiyakuInfoDomin;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * KeiyakuUpdatePageDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuUpdatePageDaoImpl extends SqlMapClientDaoSupport implements
        KeiyakuUpdatePageDao {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuUpdatePageDao#
     * selectKeiyakuInfo(
     * net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuUpdatePageParamBean)
     */
    public KihonKeiyakuInfoDomin selectKeiyakuInfo(KeiyakuUpdatePageParamBean paramBean) {
        return (KihonKeiyakuInfoDomin) getSqlMapClientTemplate().queryForObject(
                "shopListing.selectKeiyakuInfoByListingSeq", paramBean);
    }

}

/*
 * $Id: BukkenQueryIdSearchDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenQueryIdSearchDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenQueryIdSearchParamBean;

/**
 * BukkenQueryIdSearchDao の実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenQueryIdSearchDaoImpl extends SqlMapClientDaoSupport 
    implements BukkenQueryIdSearchDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenQueryIdSearchDao#bukkenQueryIdSearch(net.chintai.backend.sysadmin.shop_bukken.dao.BukkenQueryIdSearchParamBean)
     */
    public List bukkenQueryIdSearch(BukkenQueryIdSearchParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("shopBukken.bukkenQueryIdSearchList",
                paramBean);
    }
}
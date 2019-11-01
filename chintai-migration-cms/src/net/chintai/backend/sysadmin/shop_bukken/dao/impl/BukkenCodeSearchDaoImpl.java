/*
 * $Id: BukkenCodeSearchDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenCodeSearchDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenCodeSearchParamBean;

/**
 * BukkenCodeSearchDao の実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenCodeSearchDaoImpl extends SqlMapClientDaoSupport 
    implements BukkenCodeSearchDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenCodeSearchDao#bukkenCodeSearch(net.chintai.backend.sysadmin.shop_bukken.dao.BukkenCodeSearchParamBean)
     */
    public List bukkenCodeSearch(BukkenCodeSearchParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("shopBukken.bukkenCodeSearchList",
                paramBean);
    }
}
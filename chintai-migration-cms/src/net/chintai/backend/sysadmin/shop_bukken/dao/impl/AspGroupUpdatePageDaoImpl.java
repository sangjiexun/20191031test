/*
 * $Id: AspGroupUpdatePageDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/25  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupSearchParamBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupUpdatePageDao;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspGroupInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 *AspGroupUpdatePageDaoの実装クラス
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupUpdatePageDaoImpl extends SqlMapClientDaoSupport implements
        AspGroupUpdatePageDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupUpdatePageDao#selectGroupUpdatePage(java.lang.String)
     */
    public AspGroupInfo selectGroupUpdatePage(AspGroupSearchParamBean paramBean) {
       return (AspGroupInfo) getSqlMapClientTemplate().queryForObject(
                "shopBukken.selectAspGroupShop", paramBean);
    }

}

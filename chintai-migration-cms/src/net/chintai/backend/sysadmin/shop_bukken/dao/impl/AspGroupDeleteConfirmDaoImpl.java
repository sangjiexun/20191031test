/*
 * $Id: AspGroupDeleteConfirmDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupDeleteConfirmDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupSearchParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspGroupInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * AspGroupDeleteConfirmDaoの実装クラス
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupDeleteConfirmDaoImpl extends SqlMapClientDaoSupport implements
        AspGroupDeleteConfirmDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupDeleteConfirmDao#selectGroup(net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupSearchParamBean)
     */
    public AspGroupInfo selectGroup(AspGroupSearchParamBean paramBean) {
        return (AspGroupInfo) getSqlMapClientTemplate().queryForObject(
                "shopBukken.selectAspGroupShop", paramBean);
    }

}

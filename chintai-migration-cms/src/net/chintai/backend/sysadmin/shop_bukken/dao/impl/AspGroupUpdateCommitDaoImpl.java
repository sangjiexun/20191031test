/*
 * $Id: AspGroupUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/24  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupUpdateCommitParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * AspGroupUpdatePageDaoの実装クラス
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements
        AspGroupUpdateCommitDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupUpdatePageDao#aspGroupUpdateCommit(java.lang.String)
     */
    public int aspGroupUpdateCommit(AspGroupUpdateCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("shopBukken.aspGroupUpdateCommit", paramBean);
    }

}

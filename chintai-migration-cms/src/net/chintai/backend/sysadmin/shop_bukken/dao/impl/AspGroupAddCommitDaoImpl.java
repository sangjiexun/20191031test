/*
 * $Id: AspGroupAddCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/24  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupAddCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupAddCommitParamBean;

/**
 * AspGroupAddCommitDaoの実装クラス
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupAddCommitDaoImpl extends SqlMapClientDaoSupport implements
        AspGroupAddCommitDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupAddCommitDao#insertAspGroup(net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupAddCommitParamBean)
     */
    public void insertAspGroup(AspGroupAddCommitParamBean paramBean) {
        getSqlMapClientTemplate().insert("shopBukken.aspGroupAddCommit", paramBean);
    }

}

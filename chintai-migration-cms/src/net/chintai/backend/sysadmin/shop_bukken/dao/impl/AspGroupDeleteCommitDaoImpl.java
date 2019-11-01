/*
 * $Id: AspGroupDeleteCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/25  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupDeleteCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupDeleteCommitParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * AspGroupDeleteCommitDaoの実装クラス
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupDeleteCommitDaoImpl extends SqlMapClientDaoSupport implements
        AspGroupDeleteCommitDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupDeleteCommitDao#aspGroupDeleteCommit(net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupDeleteCommitParamBean)
     */
    public int aspGroupDeleteCommit(AspGroupDeleteCommitParamBean paramBean) {
        return getSqlMapClientTemplate().delete("shopBukken.aspGroupDeleteCommit", paramBean);
    }

}

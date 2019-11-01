/*
 * $Id: WebLogUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_bukken.dao.WebLogUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.WebLogUpdateCommitParamBean;

/**
 * WebLogUpdateCommitDaoインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class WebLogUpdateCommitDaoImpl extends SqlMapClientDaoSupport 
    implements WebLogUpdateCommitDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.WebLogUpdateCommitDao#webLogUpdateCommit(net.chintai.backend.sysadmin.shop_bukken.dao.WebLogUpdateCommitParamBean)
     */
    public int webLogUpdateCommit(WebLogUpdateCommitParamBean paramBean) {

        return getSqlMapClientTemplate().update
            ("shopBukken.webLogUpdateCommit", paramBean);
    }
}
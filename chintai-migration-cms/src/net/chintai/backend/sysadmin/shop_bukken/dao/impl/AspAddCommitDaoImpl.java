/*
 * $Id: AspAddCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspAddCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspAreaInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspContractInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * AspAddCommitDaoの実装クラス
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspAddCommitDaoImpl extends SqlMapClientDaoSupport implements AspAddCommitDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspAddCommitDao#insertAspAddCommit(net.chintai.backend.sysadmin.shop_bukken.domain.AspInfo)
     */
    public Long insertAspAddCommit(AspInfo aspInfo) {
        return (Long)getSqlMapClientTemplate().insert("shopBukken.insertAspAddCommit", aspInfo);

    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspAddCommitDao#insertAspAreaCommit(net.chintai.backend.sysadmin.shop_bukken.domain.AspAreaInfo)
     */
    public void insertAspAreaAddCommit(AspAreaInfo aspAreaInfo) {
        getSqlMapClientTemplate().insert("shopBukken.insertAspAreaCommit", aspAreaInfo);

    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspAddCommitDao#insertAspContractAddCommit(net.chintai.backend.sysadmin.shop_bukken.domain.AspContractInfo)
     */
    public void insertAspContractAddCommit(AspContractInfo aspContractInfo) {
        getSqlMapClientTemplate().insert("shopBukken.insertAspContractCommit", aspContractInfo);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspAddCommitDao#updateAspContractModifyCommit(net.chintai.backend.sysadmin.shop_bukken.domain.AspContractInfo)
     */
    public void updateAspContractModifyCommit(AspContractInfo aspContractInfo) {
        getSqlMapClientTemplate().update("shopBukken.updateAspContractCommit", aspContractInfo);
    }


}

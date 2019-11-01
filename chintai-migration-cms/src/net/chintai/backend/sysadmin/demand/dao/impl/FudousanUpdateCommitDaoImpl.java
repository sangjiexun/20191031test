/*
 * $Id: FudousanUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/01     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.demand.dao.FudousanUpdateCommitDao;
import net.chintai.backend.sysadmin.demand.dao.FudousanUpdateCommitParamBean;


/**
 * FudousanUpdateCommitDaoの実装クラス
 *
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements FudousanUpdateCommitDao{

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.FudousanUpdateCommitDao#updateFudousan(net.chintai.backend.sysadmin.demand.dao.FudousanUpdateCommitParamBean)
     */
    public int updateFudousan(FudousanUpdateCommitParamBean paramBean){
        return getSqlMapClientTemplate().update("demand.updateFudousan", paramBean);
    }
}

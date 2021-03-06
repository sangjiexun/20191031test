/*
 * $Id: FudousanDeleteCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/05     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import net.chintai.backend.sysadmin.demand.dao.FudousanDeleteCommitDao;
import net.chintai.backend.sysadmin.demand.dao.FudousanDeleteCommitParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * FudousanDeleteCommitDaoの実装クラス
 *
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanDeleteCommitDaoImpl extends SqlMapClientDaoSupport implements FudousanDeleteCommitDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.FudousanDeleteCommitDao#fudousanDeleteCommit(net.chintai.backend.sysadmin.demand.dao.FudousanDeleteCommitParamBean)
     */
    public int fudousanDeleteCommit(FudousanDeleteCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("demand.fudousanDeleteCommit",paramBean);
    }
    
    

}

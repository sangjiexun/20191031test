/*
 * $Id: FudousanInfoDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/29     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.demand.dao.FudousanInfoDao;
import net.chintai.backend.sysadmin.demand.dao.FudousanInfoParamBean;
import net.chintai.backend.sysadmin.demand.domain.FudousanDomain;

/**
 * FudousanInfoDaoの実装クラス
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanInfoDaoImpl extends SqlMapClientDaoSupport implements FudousanInfoDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.FudousanInfoDao#fudousanInfo(net.chintai.backend.sysadmin.demand.dao.FudousanInfoParamBean)
     */
    public FudousanDomain fudousanInfo(FudousanInfoParamBean paramBean) {

        return (FudousanDomain) getSqlMapClientTemplate().queryForObject("demand.fudousanInfo",
                paramBean);

    }

}
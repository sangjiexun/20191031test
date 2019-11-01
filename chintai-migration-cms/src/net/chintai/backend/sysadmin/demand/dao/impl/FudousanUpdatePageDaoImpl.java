/*
 * $Id: FudousanUpdatePageDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/29     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import net.chintai.backend.sysadmin.demand.dao.FudousanUpdatePageDao;
import net.chintai.backend.sysadmin.demand.dao.FudousanUpdatePageParamBean;
import net.chintai.backend.sysadmin.demand.domain.FudousanDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * FudousanUpdatePageDaoの実装クラス
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanUpdatePageDaoImpl extends SqlMapClientDaoSupport implements
        FudousanUpdatePageDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.FudousanUpdatePageDao#fudousanUpdatePage(net.chintai.backend.sysadmin.demand.dao.FudousanUpdatePageParamBean)
     */
    public FudousanDomain fudousanUpdatePage(FudousanUpdatePageParamBean paramBean) {

        return (FudousanDomain) getSqlMapClientTemplate().queryForObject("demand.fudousanUpdate",
                paramBean);
    }

}

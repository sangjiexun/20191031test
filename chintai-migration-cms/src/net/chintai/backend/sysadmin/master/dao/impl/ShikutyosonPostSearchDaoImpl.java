/*
 * $Id: ShikutyosonPostSearchDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.master.dao.ShikutyosonPostSearchDao;
import net.chintai.backend.sysadmin.master.dao.ShikutyosonSearchParamBean;
import net.chintai.backend.sysadmin.master.domain.ShikutyosonSearchInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * ShikutyosonPostSearchDaoの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonPostSearchDaoImpl extends SqlMapClientDaoSupport implements
        ShikutyosonPostSearchDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.ShikutyosonPostSearchDao#selectShikutyosonListByZipcode(net.chintai.backend.sysadmin.master.dao.ShikutyosonSearchParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<ShikutyosonSearchInfo> selectShikutyosonListByZipcode(
            ShikutyosonSearchParamBean param) {
        return getSqlMapClientTemplate().queryForList("master.selectShikutyosonByZipCd",param);
    }

}

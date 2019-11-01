/*
 * $Id: CjnUserListDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/12  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserListDao;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnUserList;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CjnUserListDaoの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserListDaoImpl extends SqlMapClientDaoSupport implements CjnUserListDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserListDao#selectCjnUserList()
     */
    @SuppressWarnings("unchecked")
    public List<CjnUserList> selectCjnUserList() {
        return getSqlMapClientTemplate().queryForList("cjn_inquiry.selectCjnUserList");
    }

}

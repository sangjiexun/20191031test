/*
 * $Id: CjnUserUpdatePageDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserUpdatePageDao;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnUserInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CjnUserUpdatePageDaoの実行クラス
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserUpdatePageDaoImpl
            extends SqlMapClientDaoSupport implements CjnUserUpdatePageDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserUpdatePageDao#selectUpadteCjnUser(java.lang.String)
     */
    public CjnUserInfo selectUpdateCjnUser(String cjnAccountSeq) {
        return (CjnUserInfo) getSqlMapClientTemplate().queryForObject("cjn_inquiry.selectCjnUser", cjnAccountSeq);
    }
}

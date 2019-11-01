/*
 * $Id: CustomTagDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/11  BGT)李昊燮   新規作成
 * 2007/11/02  BGT)劉俊秀   Q&Aカテゴリ取得処理追加
 */
package net.chintai.backend.sysadmin.common.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.common.dao.CustomTagDao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CustomTagDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CustomTagDaoImpl extends SqlMapClientDaoSupport implements CustomTagDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dao.CustomTagDao#getAreaTotal()
     */
    public List selectAreaTotal() {
        return getSqlMapClientTemplate().queryForList("customTag.selectAreaTotal");
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dao.CustomTagDao#getUserGroup()
     */
    public List selectUserGroup() {
        return getSqlMapClientTemplate().queryForList("customTag.selectUserGroup");
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dao.CustomTagDao#getOperationContents()
     */
    public List selectAuthority() {
        return getSqlMapClientTemplate().queryForList("customTag.selectOperationContents");
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dao.CustomTagDao#getAreaInfo()
     */
    public List selectAreaInfo() {
        return getSqlMapClientTemplate().queryForList("customTag.selectAreaInfo");
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dao.CustomTagDao#selectQaCategory()
     */
    public List selectQaCategory() {
        return getSqlMapClientTemplate().queryForList("customTag.selectMngMstQaCategory");
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dao.CustomTagDao#selectInquiryInfo()
     */
    public List selectInquiryInfo() {
        return getSqlMapClientTemplate().queryForList("customTag.selectInquiryInfo");
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dao.CustomTagDao#selectShisyaInfo()
     */
    public List selectShisyaInfo() {
        return getSqlMapClientTemplate().queryForList("customTag.selectShisyaInfo");
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dao.CustomTagDao#selectMstInquiryKbn(java.lang.String)
     */
    public List selectMstInquiryKbn(final String inqKbnColName) {
        return getSqlMapClientTemplate().queryForList("customTag.selectMstInquiryKbn", inqKbnColName);
    }

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.common.dao.CustomTagDao#selectMstRendo()
	 */
	public List selectMstRendo() {
		return getSqlMapClientTemplate().queryForList("customTag.selectMstRendo");
	}

}

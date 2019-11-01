/*
 * $Id: CjnInquiryTypeListDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島      新規作成
 * 2007/09/27   BGT)児島      パラメータ渡し忘れのバグを修正
 * 2007/10/21   BGT)児島      新規メソッド追加
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeListDao;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryReadableUser;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeList;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CjnInquiryTypeListDao の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeListDaoImpl extends SqlMapClientDaoSupport implements CjnInquiryTypeListDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeListDao#selectTypeList()
     */
    @SuppressWarnings("unchecked")
    public List<CjnInquiryTypeList> selectTypeList() {
        return getSqlMapClientTemplate().queryForList("cjn_inquiry.selectTypeList");
    }

    /*
     * 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeListDao#selectReadableUsersList()
     */
    @SuppressWarnings("unchecked")
    public List<CjnInquiryReadableUser> selectReadableUsersList() {
        return getSqlMapClientTemplate().queryForList("cjn_inquiry.selectReadableUsersList");
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeListDao#selectAccountType(java.lang.String)
     */
    public String selectAccountType(String userId) {
        return (String) getSqlMapClientTemplate().queryForObject("cjn_inquiry.selectAccountType", userId);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeListDao#selectKindSeqList(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public List<Integer> selectKindSeqList(String userId) {
        return getSqlMapClientTemplate().queryForList("cjn_inquiry.selectKindSeqList", userId);
    }
}

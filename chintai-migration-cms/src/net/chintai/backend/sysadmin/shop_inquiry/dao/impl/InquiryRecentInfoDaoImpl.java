/*
 * $Id: InquiryRecentInfoDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_inquiry.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryRecentInfoDao;
import net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryRecentInfoParamBean;
import net.chintai.backend.sysadmin.shop_inquiry.domain.InquiryRecent;

/**
 * InquiryRecentInfoDaoインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryRecentInfoDaoImpl extends SqlMapClientDaoSupport 
    implements InquiryRecentInfoDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryRecentInfoDao#inquiryRecentInfo(net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryRecentInfoParamBean)
     */
    public InquiryRecent inquiryRecentInfo(InquiryRecentInfoParamBean paramBean) {

        return (InquiryRecent) getSqlMapClientTemplate().queryForObject("shop_inquiry.inquiryRecentInfo",
                paramBean);
    }
}
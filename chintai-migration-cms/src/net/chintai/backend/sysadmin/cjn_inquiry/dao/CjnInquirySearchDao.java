/*
 * $Id: CjnInquirySearchDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島      新規作成
 * 2007/10/05   BGT)楊恩美   更新
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquirySearchList;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;

/**
 * 問い合せ検索DAO
 * 
 * @author KOJIMA Takanori
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquirySearchDao {

    /**
     * 問い合せ検索一覧
     * 
     * @param paramBean 検索条件
     * @return 問合わせ検索結果リスト
     */
    public List<CjnInquirySearchList> selectInquiryList(CjnInquirySearchParamBean paramBean,
            BasePagerCondition condition);

    /**
     * 問い合せ検索結果総件数
     * 
     * @param paramBean 検索条件
     * @return 問い合せ検索結果総件数
     */
    public int selectInquiryListCount(CjnInquirySearchParamBean paramBean);
}

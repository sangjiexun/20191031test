/*
 * $Id: InquiryRecentSearchDao.java 4464 2010-09-27 08:05:10Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_inquiry.dao;

import java.util.List;

import com.ibatis.sqlmap.client.event.RowHandler;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.shop_inquiry.domain.InquiryRecent;

/**
 * 問い合せ情報検索Dao
 *
 * @author Kim Dong Jin
 * @version $Revision: 4464 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface InquiryRecentSearchDao {

    /**
     * 問合せ検索
     * @param paramBean
     * @param condition
     * @return
     */
    public List inqueryRecentSearch
        (InquiryRecentSearchParamBean paramBean, BasePagerCondition condition);

    /**
     * 問合せ総件数取得
     * @param paramBean
     * @return
     */
    public int inqueryRecentTotalList(InquiryRecentSearchParamBean paramBean);

    /**
     * 問合せ情報CSV出力用を取得
     * @param handler
     * @param paramBean
     */
    public void inqueryRecentSearchForCsv(RowHandler handler, InquiryRecentSearchParamBean paramBean);

}
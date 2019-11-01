/*
 * $Id: CjnInquirySearchServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquirySearchDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquirySearchParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquirySearchList;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquirySearchService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquirySearchInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquirySearchOutServiceBean;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;

import org.apache.commons.beanutils.BeanUtils;

/**
 * CjnInquirySearchServiceの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquirySearchServiceImpl implements CjnInquirySearchService {

    /** 問い合せ検索DAOを宣言 */
    public CjnInquirySearchDao cjnInquirySearchDao = null;

    /** 問い合せ検索DAOを設定 */
    public void setCjnInquirySearchDao(CjnInquirySearchDao cjnInquirySearchDao) {
        this.cjnInquirySearchDao = cjnInquirySearchDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquirySearchService#cjnInquirySearch(net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquirySearchInServiceBean)
     */
    public List<CjnInquirySearchOutServiceBean> cjnInquirySearch(
            CjnInquirySearchInServiceBean inServiceBean, BasePagerCondition condition) {

        // 検索条件を取得
        CjnInquirySearchParamBean paramBean = new CjnInquirySearchParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // kewordList設定
        String keyword = inServiceBean.getKeywords();
        String[] keywords = keyword.split(" ");
        List<String> keywordList = new ArrayList<String>();
        for (int i = 0; i < keywords.length; i++) {
            keywordList.add(keywords[i]);
        }
        paramBean.setKeywordList(keywordList);

        // 総件数取得
        int totalCnt = cjnInquirySearchDao.selectInquiryListCount(paramBean);
        condition.setCount(totalCnt);

        // offset が総件数より大きい場合、offset-limit を設定
        if (totalCnt <= condition.getOffset()) {
            condition.setOffset(condition.getOffset() - condition.getLimit());
        }

        // 検索結果リスト取得
        List<CjnInquirySearchList> domainList =
                cjnInquirySearchDao.selectInquiryList(paramBean, condition);
        List<CjnInquirySearchOutServiceBean> listBean =
                new ArrayList<CjnInquirySearchOutServiceBean>();

        if (domainList != null) {
            for (int i = 0; i < domainList.size(); i++) {
                CjnInquirySearchOutServiceBean outServiceBean =
                        new CjnInquirySearchOutServiceBean();
                try {
                    BeanUtils.copyProperties(outServiceBean, domainList.get(i));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                listBean.add(outServiceBean);
            }
        }
        return listBean;
    }

}

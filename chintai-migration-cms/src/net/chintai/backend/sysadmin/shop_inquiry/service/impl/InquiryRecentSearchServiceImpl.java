/*
 * $Id: InquiryRecentSearchServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryRecentSearchDao;
import net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryRecentSearchParamBean;
import net.chintai.backend.sysadmin.shop_inquiry.domain.InquiryRecent;
import net.chintai.backend.sysadmin.shop_inquiry.service.InquiryRecentSearchService;
import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryRecentSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryRecentSearchOutServiceBean;

/**
 * InquiryRecentSearchService の実装クラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryRecentSearchServiceImpl implements
        InquiryRecentSearchService {

    /** 問い合せ情報検索DAO */
    private InquiryRecentSearchDao inquiryRecentSearchDao = null;

    /**
     * 問い合せ情報検索DAOを設定します。
     * @param inquiryRecentSearchDao
     */
    public void setInquiryRecentSearchDao(
            InquiryRecentSearchDao inquiryRecentSearchDao) {
        this.inquiryRecentSearchDao = inquiryRecentSearchDao;
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.InquiryRecentSearchService#inquiryRecentSearch(net.chintai.backend.sysadmin.cjn_inquiry.service.bean.InquiryRecentSearchInServiceBean)
     */
    public List inquiryRecentSearch(
            InquiryRecentSearchInServiceBean inServiceBean, BasePagerCondition condition){

        // 検索条件をParamBeanに設定
        InquiryRecentSearchParamBean paramBean =
            new InquiryRecentSearchParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 総件数取得
        int count = inquiryRecentSearchDao.inqueryRecentTotalList(paramBean);
        condition.setCount(count);

        // offset が総件数より大きい場合、offset-limit を設定
        if (count <= condition.getOffset()) {
            condition.setOffset(condition.getOffset() - condition.getLimit());
        }

        // 問い合せ情報リスト取得
        List inqueryList = inquiryRecentSearchDao.inqueryRecentSearch(paramBean, condition);

        // 問い合せ情報リストをInquiryRecentSearchOutServiceBeanに設定
        List<InquiryRecentSearchOutServiceBean> rsList =
            new ArrayList<InquiryRecentSearchOutServiceBean>();
        for(int i = 0; i < inqueryList.size(); i++){
            InquiryRecentSearchOutServiceBean outServiceBean =
                new InquiryRecentSearchOutServiceBean();
            InquiryRecent inquiryRecent = (InquiryRecent)inqueryList.get(i);
            try {
                BeanUtils.copyProperties(outServiceBean, inquiryRecent);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            rsList.add(outServiceBean);
        }
        return rsList;
    }
}
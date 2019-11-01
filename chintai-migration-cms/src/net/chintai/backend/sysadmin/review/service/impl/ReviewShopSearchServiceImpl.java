/*
 * $Id: ReviewShopSearchServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.review.dao.ReviewShopSearchDao;
import net.chintai.backend.sysadmin.review.dao.ReviewShopSearchParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewShopSearchDomain;
import net.chintai.backend.sysadmin.review.service.ReviewShopSearchService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopSearchInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopSearchOutServiceBean;

/**
 * ReviewShopSearchServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopSearchServiceImpl implements ReviewShopSearchService {

    /** 店舗検索DAO */
    private ReviewShopSearchDao reviewShopSearchDao;

    /**
     * 店舗検索DAO設定する
     * @param reviewShopSearchDao
     */
    public void setReviewShopSearchDao(ReviewShopSearchDao reviewShopSearchDao) {
        this.reviewShopSearchDao = reviewShopSearchDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewShopSearchService#getShopSearchList(net.chintai.backend.sysadmin.review.service.bean.ReviewShopSearchInServiceBean)
     */
    public List<ReviewShopSearchOutServiceBean> getShopSearchList(
            ReviewShopSearchInServiceBean inBean, BasePagerCondition condition) {

        // paramBean設定
        ReviewShopSearchParamBean paramBean = new ReviewShopSearchParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
/*
        //現在有効な物件サマリテーブル名を取得
        String tableName = reviewShopSearchDao.selectVaildTable();
        paramBean.setValidTableName(tableName);
*/
        int resultCnt = reviewShopSearchDao.selectTotalCnt(paramBean);
        condition.setCount(resultCnt);

        // offset が総件数より大きい場合、offset-limit を設定
        if (resultCnt <= condition.getOffset()) {
            condition.setOffset(condition.getOffset() - condition.getLimit());
        }

        // 検索を行う
        List<ReviewShopSearchDomain> rsList =
                reviewShopSearchDao.selectShopSearch(paramBean, condition);
        List<ReviewShopSearchOutServiceBean> returnList =
                new ArrayList<ReviewShopSearchOutServiceBean>();

        // 検索結果リターン
        for (int i = 0; i < rsList.size(); i++) {
            ReviewShopSearchOutServiceBean outBean = new ReviewShopSearchOutServiceBean();
            try {
                BeanUtils.copyProperties(outBean, rsList.get(i));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            returnList.add(outBean);
        }

        return returnList;
    }
}

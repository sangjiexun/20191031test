/*
 * $Id: ReviewBukkenSearchServiceImpl.java 3913 2008-05-27 08:09:28Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)李昊燮   新規作成
 * 2007/05/27  BGT)李昊燮   検索条件(連続掲載日)追加対応
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.review.dao.ReviewAutoDelInfoParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenSearchDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenSearchParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewBukkenSearchDomain;
import net.chintai.backend.sysadmin.review.service.ReviewBukkenSearchService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenSearchInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenSearchOutServiceBean;

/**
 * ReviewBukkenSearchServiceImplの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3913 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenSearchServiceImpl implements ReviewBukkenSearchService {

    /** 物件検索DAO */
    ReviewBukkenSearchDao reviewBukkenSearchDao;

    /**
     * reviewBukkenSearchDaoを設定する
     * @param reviewBukkenSearchDao
     */
    public void setReviewBukkenSearchDao(ReviewBukkenSearchDao reviewBukkenSearchDao) {
        this.reviewBukkenSearchDao = reviewBukkenSearchDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewBukkenSearchService#getBukkenAlertCount(net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenAlertCountInServiceBean,
     *      net.chintai.backend.sysadmin.common.pager.BasePagerCondition)
     */
    public List<ReviewBukkenSearchOutServiceBean> getBukkenSearchList(
            ReviewBukkenSearchInServiceBean inBean, BasePagerCondition condition) {

        ReviewBukkenSearchParamBean paramBean = new ReviewBukkenSearchParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 現在有効な物件サマリテーブル名を取得
//      String tableName = reviewBukkenSearchDao.selectVaildTable();
//      paramBean.setValidTableName(tableName);

        if(StringUtils.isNotEmpty(paramBean.getShopCd()) || StringUtils.isNotEmpty(paramBean.getUketsukeCd())){
        	paramBean.setShopCdorUketukeCd("1");
        }

        int resultCnt = reviewBukkenSearchDao.selectBukkenTotalCnt(paramBean);
        condition.setCount(resultCnt);

        // offset が総件数より大きい場合、offset-limit を設定
        if (resultCnt <= condition.getOffset()) {
            condition.setOffset(condition.getOffset() - condition.getLimit());
        }

        // DBから自動削除期間情報を取得
        ReviewAutoDelInfoParamBean delInfoParam = new ReviewAutoDelInfoParamBean();

        delInfoParam.setShinsaCd(ApplicationResources.getProperty("review.syokaiShinsaCd"));
        paramBean.setSyokaiAutoDel(reviewBukkenSearchDao.seleclAutoDelInfo(delInfoParam));

        delInfoParam.setShinsaCd(ApplicationResources.getProperty("review.teikiShinsaCd"));
        paramBean.setTeikiAutoDel(reviewBukkenSearchDao.seleclAutoDelInfo(delInfoParam));

        List<ReviewBukkenSearchDomain> rsList =
                reviewBukkenSearchDao.selectBukkenSearch(paramBean, condition);
        List<ReviewBukkenSearchOutServiceBean> returnList =
                new ArrayList<ReviewBukkenSearchOutServiceBean>();
        for (int i = 0; i < rsList.size(); i++) {
            ReviewBukkenSearchOutServiceBean outBean = new ReviewBukkenSearchOutServiceBean();
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

/*
 * $Id: ReviewShopMediaCountServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.review.dao.ReviewShopMediaCountDao;
import net.chintai.backend.sysadmin.review.dao.ReviewShopMediaCountParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewShopMediaCountDomain;
import net.chintai.backend.sysadmin.review.service.ReviewShopMediaCountService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopMediaCountInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopMediaCountOutServiceBean;

/**
 * ReviewShopMediaCountServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopMediaCountServiceImpl implements ReviewShopMediaCountService {

    /** 店舗別出稿状況集計取得Dao */
    ReviewShopMediaCountDao reviewShopMediaCountDao;

    /**
     * 店舗別出稿状況集計取得Daoを設定する
     * @param reviewShopMediaCountDao
     */
    public void setReviewShopMediaCountDao(ReviewShopMediaCountDao reviewShopMediaCountDao) {
        this.reviewShopMediaCountDao = reviewShopMediaCountDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewShopMediaCountService#getShopMediaCount(net.chintai.backend.sysadmin.review.service.bean.ReviewShopMediaCountInServiceBean)
     */
    public List<ReviewShopMediaCountOutServiceBean> getShopMediaCount(
            ReviewShopMediaCountInServiceBean inBean, BasePagerCondition condition) {

        // 検索条件設定
        ReviewShopMediaCountParamBean paramBean =
                ReviewShopMediaCountServiceImpl.setParamBean(inBean);

        // ページング設定
        int resultCnt = reviewShopMediaCountDao.selectTotalCnt(paramBean);
        condition.setCount(resultCnt);

        // offset が総件数より大きい場合、offset-limit を設定
        if (resultCnt <= condition.getOffset()) {
            condition.setOffset(condition.getOffset() - condition.getLimit());
        }

        // 検索開始
        List<ReviewShopMediaCountDomain> rsList =
                reviewShopMediaCountDao.selectShopMediaCnt(paramBean, condition);

        // outServiceBean設定
        List<ReviewShopMediaCountOutServiceBean> returnList =
                new ArrayList<ReviewShopMediaCountOutServiceBean>();

        for (int i = 0; i < rsList.size(); i++) {
            ReviewShopMediaCountDomain domain = rsList.get(i);
            ReviewShopMediaCountOutServiceBean outBean = new ReviewShopMediaCountOutServiceBean();

            try {
                BeanUtils.copyProperties(outBean, domain);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            returnList.add(outBean);
        }

        return returnList;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewShopMediaCountService#selectCntTime()
     */
    public ReviewShopMediaCountOutServiceBean selectCntTime() {
        ReviewShopMediaCountOutServiceBean outBean = new ReviewShopMediaCountOutServiceBean();
        outBean.setCntTime(reviewShopMediaCountDao.selectCntTime().getCntTime());
        return outBean;
    }

    /**
     * 検索条件をParamBeanに設定
     * @param InServiceBean
     * @return ParamBean
     */
    private static ReviewShopMediaCountParamBean setParamBean(
            ReviewShopMediaCountInServiceBean inBean) {

        ReviewShopMediaCountParamBean paramBean = new ReviewShopMediaCountParamBean();

        int year = Integer.parseInt(inBean.getSumYmdFromYear());
        int month = Integer.parseInt(inBean.getSumYmdFromMonth());

        String[] dates = new String[12];
        String date = "";

        // 入力された検索開始年月に基づいて検索終了年月と検索年月詳細を取得
        for (int i = 0; i < 12; i++) {
            date = String.valueOf(year);
            if (month < 10) {
                date = date + "0";
            }
            date = date + String.valueOf(month);
            dates[i] = date;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
        // paramBean設定
        paramBean.setSumYmdFrom(dates[0] + "00");
        paramBean.setSumYmdTo(date + "31");
        paramBean.setPrefCd(inBean.getPrefCd());
        paramBean.setDates(dates);
        paramBean.setCompanyBumon(inBean.getCompanyBumon());
        paramBean.setShopCd(inBean.getShopCd());
        paramBean.setOutPut(inBean.getOutPut());
        return paramBean;
    }
}

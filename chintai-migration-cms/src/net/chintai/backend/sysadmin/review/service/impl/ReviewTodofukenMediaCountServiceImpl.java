/*
 * $Id: ReviewTodofukenMediaCountServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.review.dao.ReviewTodofukenMediaCountDao;
import net.chintai.backend.sysadmin.review.dao.ReviewTodofukenMediaCountParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewTodofukenMediaCountDomain;
import net.chintai.backend.sysadmin.review.service.ReviewTodofukenMediaCountService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewTodofukenMediaCountInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewTodofukenMediaCountOutServiceBean;

/**
 * ReviewTodofukenMediaCountServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewTodofukenMediaCountServiceImpl implements ReviewTodofukenMediaCountService {

    /** 都道府県別出稿状況集計情報取得DAO */
    private ReviewTodofukenMediaCountDao reviewTodofukenMediaCountDao;

    /**
     * 都道府県別出稿状況集計情報取得DAOを設定する
     * @param reviewTodofukenMediaCountDao
     */
    public void setReviewTodofukenMediaCountDao(
            ReviewTodofukenMediaCountDao reviewTodofukenMediaCountDao) {
        this.reviewTodofukenMediaCountDao = reviewTodofukenMediaCountDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewTodofukenMediaCountService#getReviewConfigInfo()
     */
    public List<ReviewTodofukenMediaCountOutServiceBean> getMediaCountInfo(
            ReviewTodofukenMediaCountInServiceBean inBean) {

        // paramBean設定
        ReviewTodofukenMediaCountParamBean paramBean =
                ReviewTodofukenMediaCountServiceImpl.setParamBean(inBean);

        // 検索開始
        List<ReviewTodofukenMediaCountDomain> rsList =
                reviewTodofukenMediaCountDao.selectMediaCount(paramBean);

        // outServiceBean設定
        List<ReviewTodofukenMediaCountOutServiceBean> returnList =
                new ArrayList<ReviewTodofukenMediaCountOutServiceBean>();

        for (int i = 0; i < rsList.size(); i++) {
            ReviewTodofukenMediaCountDomain domain = rsList.get(i);
            ReviewTodofukenMediaCountOutServiceBean outBean =
                    new ReviewTodofukenMediaCountOutServiceBean();

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
     * @see net.chintai.backend.sysadmin.review.service.ReviewTodofukenMediaCountService#getCntTime()
     */
    public ReviewTodofukenMediaCountOutServiceBean getCntTime() {
        ReviewTodofukenMediaCountOutServiceBean outBean =
                new ReviewTodofukenMediaCountOutServiceBean();
        outBean.setCntTime(reviewTodofukenMediaCountDao.selectCntTime().getCntTime());

        return outBean;
    }

    /**
     * 都道府県別出稿状況集計情報検索条件設定する
     * @param ReviewTodofukenMediaCountInServiceBean
     */
    private static ReviewTodofukenMediaCountParamBean setParamBean(
            ReviewTodofukenMediaCountInServiceBean inBean) {

        ReviewTodofukenMediaCountParamBean paramBean = new ReviewTodofukenMediaCountParamBean();

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
        paramBean.setOutPut(inBean.getOutPut());

        return paramBean;
    }

}

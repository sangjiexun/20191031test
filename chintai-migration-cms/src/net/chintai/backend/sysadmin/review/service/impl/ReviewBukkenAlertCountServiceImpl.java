/*
 * $Id: ReviewBukkenAlertCountServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenAlertCountDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenAlertCountParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewBukkenAlertCountDomain;
import net.chintai.backend.sysadmin.review.service.ReviewBukkenAlertCountService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenAlertCountInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenAlertCountOutServiceBean;

/**
 * ReviewBukkenAlertCountServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenAlertCountServiceImpl implements ReviewBukkenAlertCountService {

    /** 警告対象物件一覧取得DAO */
    ReviewBukkenAlertCountDao reviewBukkenAlertCountDao;

    /**
     * 警告対象物件一覧取得を設定する
     * @param reviewBukkenAlertCountDao
     */
    public void setReviewBukkenAlertCountDao(ReviewBukkenAlertCountDao reviewBukkenAlertCountDao) {
        this.reviewBukkenAlertCountDao = reviewBukkenAlertCountDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewBukkenAlertCountService#getCityConfigInfo(net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenAlertCountInServiceBean)
     */
    public List<ReviewBukkenAlertCountOutServiceBean> getBukkenAlertCount(
            ReviewBukkenAlertCountInServiceBean inBean, BasePagerCondition condition) {

        // 検索条件の設定
        ReviewBukkenAlertCountParamBean paramBean = new ReviewBukkenAlertCountParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        List<String> warningCd = new ArrayList<String>();
        warningCd.add(inBean.getWarningCd0());
        warningCd.add(inBean.getWarningCd1());
        warningCd.add(inBean.getWarningCd2());

        paramBean.setWarningCd(warningCd);

        List<ReviewBukkenAlertCountDomain> rsList;

        if(inBean.getOutPut().equals("csv")){

            // 検索開始
            rsList = reviewBukkenAlertCountDao.selectAlertBukken(paramBean);

        } else {
            int resultCnt = reviewBukkenAlertCountDao.selectTotalCount(paramBean);
            condition.setCount(resultCnt);

            // offset が総件数より大きい場合、offset-limit を設定
            if (resultCnt <= condition.getOffset()) {
                condition.setOffset(condition.getOffset() - condition.getLimit());
            }

            // 検索開始
            rsList = reviewBukkenAlertCountDao.selectAlertBukken(paramBean, condition);
        }

        // 戻り値をOutServiceBeanにコピー
        List<ReviewBukkenAlertCountOutServiceBean> returnList =
                new ArrayList<ReviewBukkenAlertCountOutServiceBean>();

        for (int i = 0; i < rsList.size(); i++) {
            ReviewBukkenAlertCountOutServiceBean outBean =
                    new ReviewBukkenAlertCountOutServiceBean();

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

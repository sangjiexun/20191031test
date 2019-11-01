/*
 * $Id: ReviewBukkenInfoServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.review.dao.ReviewAutoDelInfoParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenInfoDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenInfoParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewBukkenInfoDomain;
import net.chintai.backend.sysadmin.review.service.ReviewBukkenInfoService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenInfoInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenInfoOutServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenInfoOutServiceBean.ReviewBukkenInfoOutServiceDetailBean;

/**
 * ReviewBukkenInfoServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenInfoServiceImpl implements ReviewBukkenInfoService {

    /** 物件詳細取得DAO */
    private ReviewBukkenInfoDao reviewBukkenInfoDao;

    /**
     * 物件詳細取得DAOを設定する
     * @param reviewBukkenInfoDao
     */
    public void setReviewBukkenInfoDao(ReviewBukkenInfoDao reviewBukkenInfoDao) {
        this.reviewBukkenInfoDao = reviewBukkenInfoDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewBukkenInfoService#getBukkenInfo(net.chintai.backend.sysadmin.review.dao.ReviewBukkenInfoParamBean)
     */
    public ReviewBukkenInfoOutServiceBean getBukkenInfo(ReviewBukkenInfoInServiceBean inBean) {

        ReviewBukkenInfoParamBean paramBean = new ReviewBukkenInfoParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // DBから自動削除期間情報を取得
        ReviewAutoDelInfoParamBean delInfoParam = new ReviewAutoDelInfoParamBean();

        delInfoParam.setShinsaCd(ApplicationResources.getProperty("review.syokaiShinsaCd"));
        paramBean.setSyokaiAutoDel(reviewBukkenInfoDao.seleclAutoDelInfo(delInfoParam));

        delInfoParam.setShinsaCd(ApplicationResources.getProperty("review.teikiShinsaCd"));
        paramBean.setTeikiAutoDel(reviewBukkenInfoDao.seleclAutoDelInfo(delInfoParam));

        // Web審査状態情報を取得
        ReviewBukkenInfoDomain statusDomain = reviewBukkenInfoDao.getReviewStatus(paramBean);

        // Web審査履歴情報を取得
        List<ReviewBukkenInfoDomain> rirekiList = reviewBukkenInfoDao.getReviewHistory(paramBean);

        ReviewBukkenInfoOutServiceBean returnBean = new ReviewBukkenInfoOutServiceBean();
        try {
            BeanUtils.copyProperties(returnBean, statusDomain);
            if (rirekiList != null && rirekiList.size() > 0) {
                List<ReviewBukkenInfoOutServiceDetailBean> historyList =
                        new ArrayList<ReviewBukkenInfoOutServiceDetailBean>();
                for (int i = 0; i < rirekiList.size(); i++) {
                    ReviewBukkenInfoOutServiceDetailBean historyBean =
                            returnBean.new ReviewBukkenInfoOutServiceDetailBean();
                    BeanUtils.copyProperties(historyBean, rirekiList.get(i));
                    historyList.add(historyBean);
                }
                returnBean.setRirekiList(historyList);
            }

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return returnBean;
    }
}

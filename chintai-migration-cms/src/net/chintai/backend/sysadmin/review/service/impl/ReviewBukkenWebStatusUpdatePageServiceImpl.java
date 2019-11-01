/*
 * $Id: ReviewBukkenWebStatusUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/19  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.review.dao.ReviewAutoDelInfoParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenWebStatusUpdatePageDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenWebStatusUpdatePageParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewBukkenWebStatusUpdateDomain;
import net.chintai.backend.sysadmin.review.service.ReviewBukkenWebStatusUpdatePageService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenWebStatusUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenWebStatusUpdatePageOutServiceBean;

/**
 * ReviewBukkenWebStatusUpdateServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenWebStatusUpdatePageServiceImpl implements
        ReviewBukkenWebStatusUpdatePageService {

    /** CHINTAI.NET掲載状態情報取得DAO */
    ReviewBukkenWebStatusUpdatePageDao reviewBukkenWebStatusUpdatePageDao;

    /**
     * CHINTAI.NET掲載状態情報取得DAOを設定します。
     * @param reviewBukkenWebStatusUpdatePageDao CHINTAI.NET掲載状態情報取得DAO
     */
    public void setReviewBukkenWebStatusUpdatePageDao(
            ReviewBukkenWebStatusUpdatePageDao reviewBukkenWebStatusUpdatePageDao) {
        this.reviewBukkenWebStatusUpdatePageDao = reviewBukkenWebStatusUpdatePageDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewBukkenWebStatusUpdatePageService#getBukkenWebStatusInfo(net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenWebStatusUpdatePageInServiceBean)
     */
    public ReviewBukkenWebStatusUpdatePageOutServiceBean getBukkenWebStatusInfo(
            ReviewBukkenWebStatusUpdatePageInServiceBean inBean) {

        // 検索条件設定
        ReviewBukkenWebStatusUpdatePageParamBean paramBean =
                new ReviewBukkenWebStatusUpdatePageParamBean();
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
        paramBean.setSyokaiAutoDel(reviewBukkenWebStatusUpdatePageDao.seleclAutoDelInfo(delInfoParam));

        delInfoParam.setShinsaCd(ApplicationResources.getProperty("review.teikiShinsaCd"));
        paramBean.setTeikiAutoDel(reviewBukkenWebStatusUpdatePageDao.seleclAutoDelInfo(delInfoParam));


        ReviewBukkenWebStatusUpdateDomain domain =
                reviewBukkenWebStatusUpdatePageDao.getBukkenWebStatusInfo(paramBean);
        ReviewBukkenWebStatusUpdatePageOutServiceBean outBean =
                new ReviewBukkenWebStatusUpdatePageOutServiceBean();

        try {
            BeanUtils.copyProperties(outBean, domain);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return outBean;
    }

}

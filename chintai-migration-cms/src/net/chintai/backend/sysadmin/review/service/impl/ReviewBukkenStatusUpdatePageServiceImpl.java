/*
 * $Id: ReviewBukkenStatusUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/17  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.review.dao.ReviewAutoDelInfoParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdatePageDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdatePageParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewBukkenStatusUpdateDomain;
import net.chintai.backend.sysadmin.review.service.ReviewBukkenStatusUpdatePageService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenStatusUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenStatusUpdatePageOutServiceBean;

/**
 * ReviewBukkenStatusUpdatePageServiceの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenStatusUpdatePageServiceImpl implements ReviewBukkenStatusUpdatePageService {

    /** 物件対象外設定用 物件情報取得DAO */
    ReviewBukkenStatusUpdatePageDao reviewBukkenStatusUpdatePageDao;

    /**
     * 物件対象外設定用 物件情報取得DAOを設定します。
     * @param reviewBukkenStatusUpdatePageDao 物件対象外設定用 物件情報取得DAO
     */
    public void setReviewBukkenStatusUpdatePageDao(
            ReviewBukkenStatusUpdatePageDao reviewBukkenStatusUpdatePageDao) {
        this.reviewBukkenStatusUpdatePageDao = reviewBukkenStatusUpdatePageDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewBukkenStatusUpdatePageService#getBukkenStatusInfo(net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenStatusUpdatePageInServiceBean)
     */
    public ReviewBukkenStatusUpdatePageOutServiceBean getBukkenStatusInfo(
            ReviewBukkenStatusUpdatePageInServiceBean inBean) {

        ReviewBukkenStatusUpdatePageParamBean paramBean =
                new ReviewBukkenStatusUpdatePageParamBean();
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
        paramBean.setSyokaiAutoDel(reviewBukkenStatusUpdatePageDao.seleclAutoDelInfo(delInfoParam));

        delInfoParam.setShinsaCd(ApplicationResources.getProperty("review.teikiShinsaCd"));
        paramBean.setTeikiAutoDel(reviewBukkenStatusUpdatePageDao.seleclAutoDelInfo(delInfoParam));


        ReviewBukkenStatusUpdateDomain domain =
                reviewBukkenStatusUpdatePageDao.getBukkenStatusInfo(paramBean);

        ReviewBukkenStatusUpdatePageOutServiceBean outBean =
                new ReviewBukkenStatusUpdatePageOutServiceBean();
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

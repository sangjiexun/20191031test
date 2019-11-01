/*
 * $Id: ReviewBukkenStatusUpdateConfirmServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/18  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.review.dao.ReviewAutoDelInfoParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdateConfirmDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdateConfirmParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewBukkenStatusUpdateDomain;
import net.chintai.backend.sysadmin.review.service.ReviewBukkenStatusUpdateConfirmService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenStatusUpdateConfirmInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenStatusUpdateConfirmOutServiceBean;

/**
 * ReviewBukkenStatusUpdateConfirmServiceの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenStatusUpdateConfirmServiceImpl implements
        ReviewBukkenStatusUpdateConfirmService {

    /** 物件情報取得DAO */
    ReviewBukkenStatusUpdateConfirmDao reviewBukkenStatusUpdateConfirmDao;

    /**
     * 物件情報取得DAOを設定します。
     * @param reviewBukkenStatusUpdateConfirmDao 物件情報取得DAO
     */
    public void setReviewBukkenStatusUpdateConfirmDao(
            ReviewBukkenStatusUpdateConfirmDao reviewBukkenStatusUpdateConfirmDao) {
        this.reviewBukkenStatusUpdateConfirmDao = reviewBukkenStatusUpdateConfirmDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewBukkenStatusUpdateConfirmService#getBukkenInfo(net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenStatusUpdateConfirmInServiceBean)
     */
    public ReviewBukkenStatusUpdateConfirmOutServiceBean getBukkenInfo(
            ReviewBukkenStatusUpdateConfirmInServiceBean inBean) {

        ReviewBukkenStatusUpdateConfirmParamBean paramBean =
                new ReviewBukkenStatusUpdateConfirmParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

//      DBから自動削除期間情報を取得
        ReviewAutoDelInfoParamBean delInfoParam = new ReviewAutoDelInfoParamBean();

        delInfoParam.setShinsaCd(ApplicationResources.getProperty("review.syokaiShinsaCd"));
        paramBean.setSyokaiAutoDel(reviewBukkenStatusUpdateConfirmDao.seleclAutoDelInfo(delInfoParam));

        delInfoParam.setShinsaCd(ApplicationResources.getProperty("review.teikiShinsaCd"));
        paramBean.setTeikiAutoDel(reviewBukkenStatusUpdateConfirmDao.seleclAutoDelInfo(delInfoParam));

        ReviewBukkenStatusUpdateDomain domain =
                reviewBukkenStatusUpdateConfirmDao.getBukkenInfo(paramBean);
        ReviewBukkenStatusUpdateConfirmOutServiceBean outBean =
                new ReviewBukkenStatusUpdateConfirmOutServiceBean();

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

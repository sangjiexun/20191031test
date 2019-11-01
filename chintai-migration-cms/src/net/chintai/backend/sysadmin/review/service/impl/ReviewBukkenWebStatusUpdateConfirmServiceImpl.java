/*
 * $Id: ReviewBukkenWebStatusUpdateConfirmServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/19  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.review.dao.ReviewAutoDelInfoParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenWebStatusUpdateConfirmDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenWebStatusUpdateConfirmParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewBukkenWebStatusUpdateDomain;
import net.chintai.backend.sysadmin.review.service.ReviewBukkenWebStatusUpdateConfirmService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenWebStatusUpdateConfirmInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenWebStatusUpdateConfirmOutServiceBean;

/**
 * ReviewBukkenWebStatusUpdateConfirmServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenWebStatusUpdateConfirmServiceImpl implements
        ReviewBukkenWebStatusUpdateConfirmService {

    /** 物件情報取得DAO */
    ReviewBukkenWebStatusUpdateConfirmDao reviewBukkenWebStatusUpdateConfirmDao;

    /**
     * 物件情報取得DAOを設定します。
     * @param reviewBukkenWebStatusUpdateConfirmDao 物件情報取得DAO
     */
    public void setReviewBukkenWebStatusUpdateConfirmDao(
            ReviewBukkenWebStatusUpdateConfirmDao reviewBukkenWebStatusUpdateConfirmDao) {
        this.reviewBukkenWebStatusUpdateConfirmDao = reviewBukkenWebStatusUpdateConfirmDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewBukkenWebStatusUpdateConfirmService#getBukkenInfo(net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenWebStatusUpdateConfirmInServiceBean)
     */
    public ReviewBukkenWebStatusUpdateConfirmOutServiceBean getBukkenInfo(
            ReviewBukkenWebStatusUpdateConfirmInServiceBean inBean) throws ApplicationException{

        ReviewBukkenWebStatusUpdateConfirmParamBean paramBean =
                new ReviewBukkenWebStatusUpdateConfirmParamBean();
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
        paramBean.setSyokaiAutoDel(reviewBukkenWebStatusUpdateConfirmDao.seleclAutoDelInfo(delInfoParam));

        delInfoParam.setShinsaCd(ApplicationResources.getProperty("review.teikiShinsaCd"));
        paramBean.setTeikiAutoDel(reviewBukkenWebStatusUpdateConfirmDao.seleclAutoDelInfo(delInfoParam));

        ReviewBukkenWebStatusUpdateDomain domain =
                reviewBukkenWebStatusUpdateConfirmDao.getBukkenWebStatusInfo(paramBean);
        ReviewBukkenWebStatusUpdateConfirmOutServiceBean outBean =
                new ReviewBukkenWebStatusUpdateConfirmOutServiceBean();

        try {
            BeanUtils.copyProperties(outBean, domain);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }


        // 更新失敗メッセージID追加
//        if ("0".equals(domain.getStatusKbn())
//                || "1".equals(domain.getStatusKbn())) {
//            throw new ApplicationException("ERROR.M.REVIEW.0083");
//        }

        return outBean;
    }

}

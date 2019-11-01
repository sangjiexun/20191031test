/*
 * $Id: ReviewReplayCommitServiceImpl.java 3846 2008-03-05 01:02:42Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.review.dao.ReviewReplayCommitDao;
import net.chintai.backend.sysadmin.review.dao.ReviewReplayCommitParamBean;
import net.chintai.backend.sysadmin.review.service.ReviewReplayCommitService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewReplayCommitInServiceBean;

/**
 * ReviewReplayServiceImplの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3846 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewReplayCommitServiceImpl implements ReviewReplayCommitService {

    /** 返信内容更新DAO */
    ReviewReplayCommitDao reviewReplayCommitDao;

    /**
     * 返信内容更新DAOを設定します。
     * @param reviewReplayCommitDao 返信内容更新DAO
     */
    public void setReviewReplayCommitDao(ReviewReplayCommitDao reviewReplayCommitDao) {
        this.reviewReplayCommitDao = reviewReplayCommitDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewReplayCommitService#updateWarningRireki(net.chintai.backend.sysadmin.review.service.bean.ReviewReplayCommitInServiceBean)
     */
    public void updateWarningRireki(ReviewReplayCommitInServiceBean inBean) throws ApplicationException {

        ReviewReplayCommitParamBean paramBean = new ReviewReplayCommitParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
            if (paramBean.getShinchikuFlg().isEmpty()) {
                paramBean.setShinchikuFlg("0");
            }
            paramBean.setUpdDt(inBean.getKanriUpdDt());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        int cnt = reviewReplayCommitDao.selectBukkenReviewReplayStatusCheck(paramBean);

        if (cnt == 0) {
            throw new ApplicationException("ERROR.M.REVIEW.0083");
        }

        try {
            reviewReplayCommitDao.updateWarningRireki(paramBean);
        } catch (RuntimeException e) {
            throw new ApplicationException("ERROR.M.REVIEW.0083", e);
        }
    }
}

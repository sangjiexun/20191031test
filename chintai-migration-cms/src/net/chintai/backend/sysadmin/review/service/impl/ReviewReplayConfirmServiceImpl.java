/*
 * $Id: ReviewReplayConfirmServiceImpl.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.review.dao.ReviewReplayConfirmDao;
import net.chintai.backend.sysadmin.review.dao.ReviewReplayConfirmParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewReplayDomain;
import net.chintai.backend.sysadmin.review.service.ReviewReplayConfirmService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewReplayConfirmInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewReplayConfirmOutServiceBean;

/**
 * ReviewReplayConfirmServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewReplayConfirmServiceImpl implements ReviewReplayConfirmService {

    /** 返信入力該当物件情報取得DAO */
    ReviewReplayConfirmDao reviewReplayConfirmDao;

    /**
     * 返信入力該当物件情報取得DAOを設定します。
     * @param reviewReplayConfirmDao 返信入力該当物件情報取得DAO
     */
    public void setReviewReplayConfirmDao(ReviewReplayConfirmDao reviewReplayConfirmDao) {
        this.reviewReplayConfirmDao = reviewReplayConfirmDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewReplayPageService#getReturnMailInfo(net.chintai.backend.sysadmin.review.service.bean.ReviewReplayPageInServiceBean)
     */
    public ReviewReplayConfirmOutServiceBean getReturnMailConfirmInfo(
            ReviewReplayConfirmInServiceBean inBean) {

        ReviewReplayConfirmParamBean paramBean = new ReviewReplayConfirmParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        ReviewReplayDomain domain = reviewReplayConfirmDao.getReplayBukkenInfo(paramBean);
        ReviewReplayConfirmOutServiceBean outBean = new ReviewReplayConfirmOutServiceBean();
        try {
            BeanUtils.copyProperties(outBean, domain);
            outBean.setKanriCd(outBean.getShopCd() + "-" + outBean.getBkCd() + "-" + outBean.getRoomNo());

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return outBean;
    }

}

/*
 * $Id: ReviewReplayPageServiceImpl.java 3865 2008-03-12 00:50:46Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.review.dao.ReviewReplayPageDao;
import net.chintai.backend.sysadmin.review.dao.ReviewReplayPageParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewReplayDomain;
import net.chintai.backend.sysadmin.review.service.ReviewReplayPageService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewReplayPageInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewReplayPageOutServiceBean;

/**
 * ReviewReplayPageServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3865 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewReplayPageServiceImpl implements ReviewReplayPageService {

    /** 返信入力該当物件情報取得DAO */
    ReviewReplayPageDao reviewReplayPageDao;

    /**
     * 返信入力該当物件情報取得DAOを設定します。
     * @param reviewReplayPageDao 返信入力該当物件情報取得DAO
     */
    public void setReviewReplayPageDao(ReviewReplayPageDao reviewReplayPageDao) {
        this.reviewReplayPageDao = reviewReplayPageDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewReplayPageService#getReturnMailInfo(net.chintai.backend.sysadmin.review.service.bean.ReviewReplayPageInServiceBean)
     */
    public ReviewReplayPageOutServiceBean getReturnMailInfo(ReviewReplayPageInServiceBean inBean) {

        ReviewReplayPageParamBean paramBean = new ReviewReplayPageParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        ReviewReplayDomain domain = reviewReplayPageDao.getReplayBukkenInfo(paramBean);
        ReviewReplayPageOutServiceBean outBean = new ReviewReplayPageOutServiceBean();
        try {
            if (domain != null) {
                BeanUtils.copyProperties(outBean, domain);
                outBean.setKanriCd(outBean.getShopCd() + "-" +
                                    outBean.getBkCd() + "-" +
                                    outBean.getRoomNo());
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return outBean;
    }

}

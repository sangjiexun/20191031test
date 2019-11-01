/*
 * $Id: ReviewConfigServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.review.dao.ReviewConfigDao;
import net.chintai.backend.sysadmin.review.domain.ReviewAutoDelDomain;
import net.chintai.backend.sysadmin.review.domain.ReviewConfigDomain;
import net.chintai.backend.sysadmin.review.domain.ReviewMadoriTypeDomain;
import net.chintai.backend.sysadmin.review.domain.ReviewPrefConfigDomain;
import net.chintai.backend.sysadmin.review.service.ReviewConfigService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigOutServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigOutServiceBean.AutoDelDetailBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigOutServiceBean.MadoriDetailBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigOutServiceBean.PrefDetailBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigOutServiceBean.ShinsaDatailBean;

/**
 * ReviewConfigServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewConfigServiceImpl implements ReviewConfigService {

    /** 審査設定内容取得DAO */
    private ReviewConfigDao reviewConfigDao;

    /**
     * 審査設定内容取得DAOを設定する
     * @param reviewConfigDao
     */
    public void setReviewConfigDao(ReviewConfigDao reviewConfigDao) {
        this.reviewConfigDao = reviewConfigDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewConfigService#getReviewConfigInfo()
     */
    public List<ShinsaDatailBean> getReviewConfigInfo() {
        List<ReviewConfigDomain> rsList = reviewConfigDao.selectReviewConfig();
        List<ShinsaDatailBean> returnList = new ArrayList<ShinsaDatailBean>();

        ReviewConfigOutServiceBean bean = new ReviewConfigOutServiceBean();
        try {
            for (int i = 0; i < rsList.size(); i++) {
                ShinsaDatailBean detailBean = bean.new ShinsaDatailBean();

                BeanUtils.copyProperties(detailBean, rsList.get(i));
                returnList.add(detailBean);
            }
            return returnList;

        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewConfigService#getMadoriConfigInfo()
     */
    public List<MadoriDetailBean> getMadoriConfigInfo() {
        List<ReviewMadoriTypeDomain> rsList = reviewConfigDao
                .selectMadoriConfig();
        List<MadoriDetailBean> returnList = new ArrayList<MadoriDetailBean>();

        ReviewConfigOutServiceBean bean = new ReviewConfigOutServiceBean();
        try {
            for (int i = 0; i < rsList.size(); i++) {
                MadoriDetailBean detailBean = bean.new MadoriDetailBean();

                BeanUtils.copyProperties(detailBean, rsList.get(i));
                returnList.add(detailBean);
            }
            return returnList;

        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewConfigService#getAutoDelConfigInfo()
     */
    public List<AutoDelDetailBean> getAutoDelConfigInfo() {
        List<ReviewAutoDelDomain> rsList = reviewConfigDao
                .selectAutoDelConfig();
        List<AutoDelDetailBean> returnList = new ArrayList<AutoDelDetailBean>();

        ReviewConfigOutServiceBean bean = new ReviewConfigOutServiceBean();
        try {
            for (int i = 0; i < rsList.size(); i++) {
                AutoDelDetailBean detailBean = bean.new AutoDelDetailBean();

                BeanUtils.copyProperties(detailBean, rsList.get(i));
                returnList.add(detailBean);
            }
            return returnList;

        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewConfigService#getPrefConfigInfo()
     */
    public List<PrefDetailBean> getPrefConfigInfo() {
        List<ReviewPrefConfigDomain> rsList = reviewConfigDao
                .selectPrefConfig();
        List<PrefDetailBean> returnList = new ArrayList<PrefDetailBean>();

        ReviewConfigOutServiceBean bean = new ReviewConfigOutServiceBean();
        try {
            for (int i = 0; i < rsList.size(); i++) {
                PrefDetailBean detailBean = bean.new PrefDetailBean();

                BeanUtils.copyProperties(detailBean, rsList.get(i));
                returnList.add(detailBean);
            }
            return returnList;

        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
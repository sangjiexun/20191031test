/*
 * $Id: ReviewConfigCityServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
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

import net.chintai.backend.sysadmin.review.dao.ReviewConfigCityDao;
import net.chintai.backend.sysadmin.review.dao.ReviewConfigCityParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewConfigCityDomain;
import net.chintai.backend.sysadmin.review.service.ReviewConfigCityService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigCityInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigCityOutServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigCityOutServiceBean.ReviewConfigCityDetailBean;

/**
 * ReviewConfigCityServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewConfigCityServiceImpl implements ReviewConfigCityService {

    /** 市区町村別比較対象設定内容取得DAO */
    private ReviewConfigCityDao reviewConfigCityDao;

    /**
     * 市区町村別比較対象設定内容取得DAOを設定する
     * @param reviewConfigCityDao
     */
    public void setReviewConfigCityDao(ReviewConfigCityDao reviewConfigCityDao) {
        this.reviewConfigCityDao = reviewConfigCityDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewConfigCityService#getCityConfigInfo()
     */
    public ReviewConfigCityOutServiceBean getCityConfigInfo(
            ReviewConfigCityInServiceBean inBean) {

        // 検索条件設定
        ReviewConfigCityParamBean paramBean = new ReviewConfigCityParamBean();
        paramBean.setPrefCd(inBean.getPrefCd());

        // 検索開始
        String prefName = reviewConfigCityDao.selectPrefName(paramBean)
                .getPrefName();

        List<ReviewConfigCityDomain> rsList = reviewConfigCityDao
                .selectCityConfig(paramBean);

        // 戻り値をOutServiceBeanにコピー
        ReviewConfigCityOutServiceBean outBean = new ReviewConfigCityOutServiceBean();
        List<ReviewConfigCityDetailBean> prefInfoList = new ArrayList<ReviewConfigCityDetailBean>();

        try {
            for (int i = 0; i < rsList.size(); i++) {
                ReviewConfigCityDetailBean detailBean = outBean.new ReviewConfigCityDetailBean();

                BeanUtils.copyProperties(detailBean, rsList.get(i));
                prefInfoList.add(detailBean);
            }
            outBean.setAreaName(prefName);
            outBean.setPrefInfoList(prefInfoList);
            return outBean;

        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}

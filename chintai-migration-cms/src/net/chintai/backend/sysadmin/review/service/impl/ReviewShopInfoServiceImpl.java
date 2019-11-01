/*
 * $Id: ReviewShopInfoServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/12  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.review.dao.ReviewShopInfoDao;
import net.chintai.backend.sysadmin.review.dao.ReviewShopInfoParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewShopInfoDomain;
import net.chintai.backend.sysadmin.review.service.ReviewShopInfoService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopInfoInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopInfoOutServiceBean;

/**
 * RevewiShopInfoServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopInfoServiceImpl implements ReviewShopInfoService {

    /** 店舗詳細DAO */
    ReviewShopInfoDao reviewShopInfoDao;

    /**
     * 店舗詳細DAOを設定する
     * @param reviewShopInfoDao
     */
    public void setReviewShopInfoDao(ReviewShopInfoDao reviewShopInfoDao) {
        this.reviewShopInfoDao = reviewShopInfoDao;
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewShopInfoService#selectShopInfo(net.chintai.backend.sysadmin.review.dao.ReviewShopInfoParamBean)
     */
    public ReviewShopInfoOutServiceBean selectShopInfo(ReviewShopInfoInServiceBean inBean) {

        ReviewShopInfoParamBean paramBean = new ReviewShopInfoParamBean();
        //String validTableName = reviewShopInfoDao.selectVaildTable();

        //paramBean.setValidTableName(validTableName);
        paramBean.setShopCd(inBean.getShopCd());

        ReviewShopInfoDomain domain = reviewShopInfoDao.getShopInfo(paramBean);
        ReviewShopInfoOutServiceBean outBean = new ReviewShopInfoOutServiceBean();

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

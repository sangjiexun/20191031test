/*
 * $Id: ReviewShopStatusUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdatePageDao;
import net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdatePageParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewShopStatusUpdateDomain;
import net.chintai.backend.sysadmin.review.service.ReviewShopStatusUpdatePageService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopStatusUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopStatusUpdatePageOutServiceBean;

/**
 * ReviewShopStatusUpdatePageServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopStatusUpdatePageServiceImpl implements ReviewShopStatusUpdatePageService {

    /** 店舗情報、店舗対象外設定取得DAO */
    ReviewShopStatusUpdatePageDao reviewShopStatusUpdatePageDao;

    /**
     * 店舗情報、店舗対象外設定取得DAOを設定します。
     * @param reviewShopStatusUpdatePageDao 店舗情報、店舗対象外設定取得DAO
     */
    public void setReviewShopStatusUpdatePageDao(
            ReviewShopStatusUpdatePageDao reviewShopStatusUpdatePageDao) {
        this.reviewShopStatusUpdatePageDao = reviewShopStatusUpdatePageDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewShopStatusUpdatePageService#getShopStatusUpdateInfo(net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdatePageParamBean)
     */
    public ReviewShopStatusUpdatePageOutServiceBean getShopStatusUpdateInfo(
            ReviewShopStatusUpdatePageInServiceBean inBean) {

        // paramBean設定
        ReviewShopStatusUpdatePageParamBean paramBean = new ReviewShopStatusUpdatePageParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
/*
        // 現在有効な物件サマリテーブル名を取得
        String tableName = reviewShopStatusUpdatePageDao.selectVaildTable();
        paramBean.setValidTableName(tableName);
*/
        // 検索開始
        ReviewShopStatusUpdateDomain domain =
                reviewShopStatusUpdatePageDao.selectShopStatusInfo(paramBean);
        ReviewShopStatusUpdatePageOutServiceBean outBean =
                new ReviewShopStatusUpdatePageOutServiceBean();

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

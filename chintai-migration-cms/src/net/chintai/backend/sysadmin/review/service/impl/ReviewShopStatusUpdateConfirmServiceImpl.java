/*
 * $Id: ReviewShopStatusUpdateConfirmServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdateConfirmDao;
import net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdateConfirmParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewShopStatusUpdateDomain;
import net.chintai.backend.sysadmin.review.service.ReviewShopStatusUpdateConfirmService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopStatusUpdateConfirmInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopStatusUpdateConfirmOutServiceBean;

/**
 * ReviewShopStatusUpdateConfirmServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopStatusUpdateConfirmServiceImpl implements
        ReviewShopStatusUpdateConfirmService {

    /** 店舗情報取得DAO */
    private ReviewShopStatusUpdateConfirmDao reviewShopStatusUpdateConfirmDao;

    /**
     * reviewShopStatusUpdateConfirmDaoを設定する
     * @param reviewShopStatusUpdateConfirmDao
     */
    public void setReviewShopStatusUpdateConfirmDao(
            ReviewShopStatusUpdateConfirmDao reviewShopStatusUpdateConfirmDao) {
        this.reviewShopStatusUpdateConfirmDao = reviewShopStatusUpdateConfirmDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewShopStatusUpdateConfirmService#getShopInfo(net.chintai.backend.sysadmin.review.service.bean.ReviewShopStatusUpdateConfirmInServiceBean)
     */
    public ReviewShopStatusUpdateConfirmOutServiceBean getShopInfo(
            ReviewShopStatusUpdateConfirmInServiceBean inBean) {
        // paramBean設定
        ReviewShopStatusUpdateConfirmParamBean paramBean =
                new ReviewShopStatusUpdateConfirmParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
/*
        // 現在有効な物件サマリテーブル名を取得
        String tableName = reviewShopStatusUpdateConfirmDao.selectVaildTable();
        paramBean.setValidTableName(tableName);
*/
        // 検索開始
        ReviewShopStatusUpdateDomain domain =
                reviewShopStatusUpdateConfirmDao.getShopInfo(paramBean);
        ReviewShopStatusUpdateConfirmOutServiceBean outBean =
                new ReviewShopStatusUpdateConfirmOutServiceBean();

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

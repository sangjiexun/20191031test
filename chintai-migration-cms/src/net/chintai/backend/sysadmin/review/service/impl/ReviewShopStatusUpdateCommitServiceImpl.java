/*
 * $Id: ReviewShopStatusUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/17  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.review.dao.ReviewShopRirekiAddCommitDao;
import net.chintai.backend.sysadmin.review.dao.ReviewShopRirekiAddParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdateCommitDao;
import net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdateCommitParamBean;
import net.chintai.backend.sysadmin.review.service.ReviewShopStatusUpdateCommitService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopStatusUpdateCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * ReviewShopStatusUpdateCommitServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopStatusUpdateCommitServiceImpl implements ReviewShopStatusUpdateCommitService {

    /** 店舗対象外設定更新Dao */
    ReviewShopStatusUpdateCommitDao reviewShopStatusUpdateCommitDao;

    /** 店舗履歴登録DAO */
    ReviewShopRirekiAddCommitDao reviewShopRirekiAddCommitDao;

    /**
     * 店舗対象外設定更新Daoを設定します。
     * @param reviewShopStatusUpdateCommitDao 店舗対象外設定更新Dao
     */
    public void setReviewShopStatusUpdateCommitDao(
            ReviewShopStatusUpdateCommitDao reviewShopStatusUpdateCommitDao) {
        this.reviewShopStatusUpdateCommitDao = reviewShopStatusUpdateCommitDao;
    }

    /**
     * 店舗履歴登録DAOを設定します。
     * @param reviewBukkenRirekiAddCommitDao  reviewBukkenRirekiAddCommitDao
     */
    public void setReviewShopRirekiAddCommitDao(ReviewShopRirekiAddCommitDao reviewShopRirekiAddCommitDao) {
        this.reviewShopRirekiAddCommitDao = reviewShopRirekiAddCommitDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewShopStatusUpdateCommitService#updateShopStatus(net.chintai.backend.sysadmin.review.service.bean.ReviewShopStatusUpdateCommitInServiceBean)
     */
    public void updateShopStatus(ReviewShopStatusUpdateCommitInServiceBean inBean)
            throws ApplicationException {

        // paramBean設定
        ReviewShopStatusUpdateCommitParamBean paramBean =
                new ReviewShopStatusUpdateCommitParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }





        /*
        List<ReviewShopRirekiAddParamBean> listReviewBUkkenRireki = makeListReviewShopRrekiAddParamBean(paramBean);
        for (ReviewShopRirekiAddParamBean parameter : listReviewBUkkenRireki) {
            reviewShopRirekiAddCommitDao.shopRirekiAdd(parameter);
        }
        */

    }


/*
    private List<ReviewShopRirekiAddParamBean>
        makeListReviewShopRrekiAddParamBean(ReviewShopStatusUpdateCommitParamBean paramBean) {

        List<ReviewShopRirekiAddParamBean> lstShopRirekiCreReq
                    = new ArrayList<ReviewShopRirekiAddParamBean>();

        // PK履歴番号を取得
        Long pkShopRireki = reviewShopRirekiAddCommitDao.selectPkShopRireki();
        int recordNum = 0;
        ReviewShopRirekiAddParamBean  reviewShopRrekiAddParamBean = null;

        reviewShopRrekiAddParamBean = new ReviewShopRirekiAddParamBean();
        recordNum  = recordNum + 1;
        reviewShopRrekiAddParamBean.setPkShopRireki(pkShopRireki);
        reviewShopRrekiAddParamBean.setCreReqSeq(recordNum);
        reviewShopRrekiAddParamBean.setShopCd(paramBean.getShopCd());
        reviewShopRrekiAddParamBean.setCommonNo(null);
        reviewShopRrekiAddParamBean.setSyoriReqKbn("00");
        reviewShopRrekiAddParamBean.setCreReqTable("SHOP_RIREKI");
        reviewShopRrekiAddParamBean.setCreReqCol("SYOKAI_SHINSA_SKIP_FLG");
        reviewShopRrekiAddParamBean.setCreReqVal(paramBean.getSyokaiShinsaSkipFlg());
        reviewShopRrekiAddParamBean.setReqKbn("2");
        reviewShopRrekiAddParamBean.setUpdPg(paramBean.getUpdPg());
        reviewShopRrekiAddParamBean.setOperUserId(paramBean.getUpdId());
        lstShopRirekiCreReq.add(reviewShopRrekiAddParamBean);

        reviewShopRrekiAddParamBean = new ReviewShopRirekiAddParamBean();
        recordNum  = recordNum + 1;
        reviewShopRrekiAddParamBean.setPkShopRireki(pkShopRireki);
        reviewShopRrekiAddParamBean.setCreReqSeq(recordNum);
        reviewShopRrekiAddParamBean.setShopCd(paramBean.getShopCd());
        reviewShopRrekiAddParamBean.setCommonNo(null);
        reviewShopRrekiAddParamBean.setSyoriReqKbn("00");
        reviewShopRrekiAddParamBean.setCreReqTable("SHOP_RIREKI");
        reviewShopRrekiAddParamBean.setCreReqCol("TEIKI_SHINSA_SKIP_FLG");
        reviewShopRrekiAddParamBean.setCreReqVal(paramBean.getTeikiShinsaSkipFlg());
        reviewShopRrekiAddParamBean.setReqKbn("2");
        reviewShopRrekiAddParamBean.setUpdPg(paramBean.getUpdPg());
        reviewShopRrekiAddParamBean.setOperUserId(paramBean.getUpdId());
        lstShopRirekiCreReq.add(reviewShopRrekiAddParamBean);

        reviewShopRrekiAddParamBean = new ReviewShopRirekiAddParamBean();
        recordNum  = recordNum + 1;
        reviewShopRrekiAddParamBean.setPkShopRireki(pkShopRireki);
        reviewShopRrekiAddParamBean.setCreReqSeq(recordNum);
        reviewShopRrekiAddParamBean.setShopCd(paramBean.getShopCd());
        reviewShopRrekiAddParamBean.setCommonNo(null);
        reviewShopRrekiAddParamBean.setSyoriReqKbn("00");
        reviewShopRrekiAddParamBean.setCreReqTable("SHOP_RIREKI");
        reviewShopRrekiAddParamBean.setCreReqCol("MAIL_SEND_SKIP_FLG");
        reviewShopRrekiAddParamBean.setCreReqVal(paramBean.getMailSendSkipFlg());
        reviewShopRrekiAddParamBean.setReqKbn("2");
        reviewShopRrekiAddParamBean.setUpdPg(paramBean.getUpdPg());
        reviewShopRrekiAddParamBean.setOperUserId(paramBean.getUpdId());
        lstShopRirekiCreReq.add(reviewShopRrekiAddParamBean);

        reviewShopRrekiAddParamBean = new ReviewShopRirekiAddParamBean();
        recordNum  = recordNum + 1;
        reviewShopRrekiAddParamBean.setPkShopRireki(pkShopRireki);
        reviewShopRrekiAddParamBean.setCreReqSeq(recordNum);
        reviewShopRrekiAddParamBean.setShopCd(paramBean.getShopCd());
        reviewShopRrekiAddParamBean.setCommonNo(null);
        reviewShopRrekiAddParamBean.setSyoriReqKbn("00");
        reviewShopRrekiAddParamBean.setCreReqTable("SHOP_RIREKI");
        reviewShopRrekiAddParamBean.setCreReqCol("AUTODEL_SKIP_FLG");
        reviewShopRrekiAddParamBean.setCreReqVal(paramBean.getAutoDelSkipFlg());
        reviewShopRrekiAddParamBean.setReqKbn("2");
        reviewShopRrekiAddParamBean.setUpdPg(paramBean.getUpdPg());
        reviewShopRrekiAddParamBean.setOperUserId(paramBean.getUpdId());
        lstShopRirekiCreReq.add(reviewShopRrekiAddParamBean);

        reviewShopRrekiAddParamBean = new ReviewShopRirekiAddParamBean();
        recordNum  = recordNum + 1;
        reviewShopRrekiAddParamBean.setPkShopRireki(pkShopRireki);
        reviewShopRrekiAddParamBean.setCreReqSeq(recordNum);
        reviewShopRrekiAddParamBean.setShopCd(paramBean.getShopCd());
        reviewShopRrekiAddParamBean.setCommonNo(null);
        reviewShopRrekiAddParamBean.setSyoriReqKbn("00");
        reviewShopRrekiAddParamBean.setCreReqTable("SHOP_RIREKI");
        reviewShopRrekiAddParamBean.setCreReqCol("SHINSA_SKIP_BIKOU");
        reviewShopRrekiAddParamBean.setCreReqVal(paramBean.getShinsaSkipBikou());
        reviewShopRrekiAddParamBean.setReqKbn("2");
        reviewShopRrekiAddParamBean.setUpdPg(paramBean.getUpdPg());
        reviewShopRrekiAddParamBean.setOperUserId(paramBean.getUpdId());
        lstShopRirekiCreReq.add(reviewShopRrekiAddParamBean);

        return lstShopRirekiCreReq;
    }
*/
}

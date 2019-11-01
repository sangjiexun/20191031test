/*
 * $Id: ReviewBukkenStatusUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/18  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenRirekiAddParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenRirekiAddCommitDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusAddParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdateCommitParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkennStatusUpdateCommitDao;
import net.chintai.backend.sysadmin.review.service.ReviewBukkenStatusUpdateCommitService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenStatusUpdateCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;


/**
 * ReviewBukkenStatusUpdateCommitServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenStatusUpdateCommitServiceImpl implements
        ReviewBukkenStatusUpdateCommitService {

    /** 物件対象外設定更新DAO */
    ReviewBukkennStatusUpdateCommitDao reviewBukkenStatusUpdateCommitDao;

    /** 物件履歴登録DAO */
    ReviewBukkenRirekiAddCommitDao reviewBukkenRirekiAddCommitDao;

    /**
     * 物件対象外設定更新DAOを設定します。
     * @param reviewBukkenStatusUpdateCommitDao 物件対象外設定更新DAO
     */
    public void setReviewBukkenStatusUpdateCommitDao(ReviewBukkennStatusUpdateCommitDao reviewBukkenStatusUpdateCommitDao) {
        this.reviewBukkenStatusUpdateCommitDao = reviewBukkenStatusUpdateCommitDao;
    }

    /**
     * 物件履歴登録DAOを設定します。
     * @param reviewBukkenRirekiAddCommitDao  reviewBukkenRirekiAddCommitDao
     */
    public void setReviewBukkenRirekiAddCommitDao(ReviewBukkenRirekiAddCommitDao reviewBukkenRirekiAddCommitDao) {
        this.reviewBukkenRirekiAddCommitDao = reviewBukkenRirekiAddCommitDao;
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewBukkenStatusUpdateCommitService#updateBukkenStatus(net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenStatusUpdateCommitInServiceBean)
     */
    public void updateBukkenStatus(ReviewBukkenStatusUpdateCommitInServiceBean inBean) throws ApplicationException {

        ReviewBukkenStatusUpdateCommitParamBean paramBean = new ReviewBukkenStatusUpdateCommitParamBean();

        try {
            BeanUtils.copyProperties(paramBean,inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        String changeStatusKbn = reviewBukkenStatusUpdateCommitDao.selectBukkenStatusCheck(paramBean);

        if( changeStatusKbn == null ){
            throw new ApplicationException("ERROR.M.REVIEW.0082");
        }

        paramBean.setPkBukkenRireki(reviewBukkenRirekiAddCommitDao.selectPkBukkenRireki());

        List<ReviewBukkenRirekiAddParamBean> listReviewBUkkenRireki = makeListReviewBukkenRrekiAddParamBean(paramBean);
        for (ReviewBukkenRirekiAddParamBean parameter : listReviewBUkkenRireki) {
            reviewBukkenRirekiAddCommitDao.bukkenRirekiAdd(parameter);
        }
        ReviewBukkenStatusAddParamBean bukkenStatusParam =
                new ReviewBukkenStatusAddParamBean();
        try {
            BeanUtils.copyProperties(bukkenStatusParam,paramBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        reviewBukkenRirekiAddCommitDao.bukkenStatusKanriAdd(bukkenStatusParam);

        //int updCnt  = reviewBukkenStatusUpdateCommitDao.selectBukkenStatusCheck(paramBean);
    }


   /**
    *
    * @param changeSourceKbn
    * @param paramBean
    */
   private List<ReviewBukkenRirekiAddParamBean>
       makeListReviewBukkenRrekiAddParamBean(ReviewBukkenStatusUpdateCommitParamBean paramBean) {

       List<ReviewBukkenRirekiAddParamBean> lstBukkenRirekiCreReq
                   = new ArrayList<ReviewBukkenRirekiAddParamBean>();

       // PK履歴番号を取得
       int recordNum = 0;
       ReviewBukkenRirekiAddParamBean  reviewBukkenRrekiAddParamBean = null;

       reviewBukkenRrekiAddParamBean = new ReviewBukkenRirekiAddParamBean();
       recordNum  = recordNum + 1;
       reviewBukkenRrekiAddParamBean.setPkBukkenRireki(paramBean.getPkBukkenRireki());
       reviewBukkenRrekiAddParamBean.setCreReqSeq(recordNum);
       reviewBukkenRrekiAddParamBean.setRoomKey(paramBean.getRoomKey());
       reviewBukkenRrekiAddParamBean.setCommonNo(null);
       reviewBukkenRrekiAddParamBean.setSyoriReqKbn("00");
       reviewBukkenRrekiAddParamBean.setCreReqTable("BUKKEN_RIREKI");
       reviewBukkenRrekiAddParamBean.setCreReqCol("SYOKAI_SHINSA_SKIP_FLG");
       reviewBukkenRrekiAddParamBean.setCreReqVal(paramBean.getSyokaiShinsaSkipFlg());
       reviewBukkenRrekiAddParamBean.setReqKbn("2");
       reviewBukkenRrekiAddParamBean.setUpdPg(paramBean.getUpdPg());
       reviewBukkenRrekiAddParamBean.setOperUserId(paramBean.getUpdId());
       lstBukkenRirekiCreReq.add(reviewBukkenRrekiAddParamBean);

       reviewBukkenRrekiAddParamBean = new ReviewBukkenRirekiAddParamBean();
       recordNum  = recordNum + 1;
       reviewBukkenRrekiAddParamBean.setPkBukkenRireki(paramBean.getPkBukkenRireki());
       reviewBukkenRrekiAddParamBean.setCreReqSeq(recordNum);
       reviewBukkenRrekiAddParamBean.setRoomKey(paramBean.getRoomKey());
       reviewBukkenRrekiAddParamBean.setCommonNo(null);
       reviewBukkenRrekiAddParamBean.setSyoriReqKbn("00");
       reviewBukkenRrekiAddParamBean.setCreReqTable("BUKKEN_RIREKI");
       reviewBukkenRrekiAddParamBean.setCreReqCol("TEIKI_SHINSA_SKIP_FLG");
       reviewBukkenRrekiAddParamBean.setCreReqVal(paramBean.getTeikiShinsaSkipFlg());
       reviewBukkenRrekiAddParamBean.setReqKbn("2");
       reviewBukkenRrekiAddParamBean.setUpdPg(paramBean.getUpdPg());
       reviewBukkenRrekiAddParamBean.setOperUserId(paramBean.getUpdId());
       lstBukkenRirekiCreReq.add(reviewBukkenRrekiAddParamBean);

       reviewBukkenRrekiAddParamBean = new ReviewBukkenRirekiAddParamBean();
       recordNum  = recordNum + 1;
       reviewBukkenRrekiAddParamBean.setPkBukkenRireki(paramBean.getPkBukkenRireki());
       reviewBukkenRrekiAddParamBean.setCreReqSeq(recordNum);
       reviewBukkenRrekiAddParamBean.setRoomKey(paramBean.getRoomKey());
       reviewBukkenRrekiAddParamBean.setCommonNo(null);
       reviewBukkenRrekiAddParamBean.setSyoriReqKbn("00");
       reviewBukkenRrekiAddParamBean.setCreReqTable("BUKKEN_RIREKI");
       reviewBukkenRrekiAddParamBean.setCreReqCol("AUTODEL_SKIP_FLG");
       reviewBukkenRrekiAddParamBean.setCreReqVal(paramBean.getAutoDelSkipFlg());
       reviewBukkenRrekiAddParamBean.setReqKbn("2");
       reviewBukkenRrekiAddParamBean.setUpdPg(paramBean.getUpdPg());
       reviewBukkenRrekiAddParamBean.setOperUserId(paramBean.getUpdId());
       lstBukkenRirekiCreReq.add(reviewBukkenRrekiAddParamBean);

       reviewBukkenRrekiAddParamBean = new ReviewBukkenRirekiAddParamBean();
       recordNum  = recordNum + 1;
       reviewBukkenRrekiAddParamBean.setPkBukkenRireki(paramBean.getPkBukkenRireki());
       reviewBukkenRrekiAddParamBean.setCreReqSeq(recordNum);
       reviewBukkenRrekiAddParamBean.setRoomKey(paramBean.getRoomKey());
       reviewBukkenRrekiAddParamBean.setCommonNo(null);
       reviewBukkenRrekiAddParamBean.setSyoriReqKbn("00");
       reviewBukkenRrekiAddParamBean.setCreReqTable("BUKKEN_RIREKI");
       reviewBukkenRrekiAddParamBean.setCreReqCol("SHINSA_SKIP_BIKOU");
       reviewBukkenRrekiAddParamBean.setCreReqVal(paramBean.getShinsaSkipBikou());
       reviewBukkenRrekiAddParamBean.setReqKbn("2");
       reviewBukkenRrekiAddParamBean.setUpdPg(paramBean.getUpdPg());
       reviewBukkenRrekiAddParamBean.setOperUserId(paramBean.getUpdId());
       lstBukkenRirekiCreReq.add(reviewBukkenRrekiAddParamBean);

       reviewBukkenRrekiAddParamBean = new ReviewBukkenRirekiAddParamBean();
       recordNum  = recordNum + 1;
       reviewBukkenRrekiAddParamBean.setPkBukkenRireki(paramBean.getPkBukkenRireki());
       reviewBukkenRrekiAddParamBean.setCreReqSeq(recordNum);
       reviewBukkenRrekiAddParamBean.setRoomKey(paramBean.getRoomKey());
       reviewBukkenRrekiAddParamBean.setCommonNo(null);
       reviewBukkenRrekiAddParamBean.setSyoriReqKbn("00");
       reviewBukkenRrekiAddParamBean.setCreReqTable("BUKKEN_RIREKI");
       reviewBukkenRrekiAddParamBean.setCreReqCol("CHANGE_SOURCE_KBN");
       reviewBukkenRrekiAddParamBean.setCreReqVal("2");
       reviewBukkenRrekiAddParamBean.setReqKbn("2");
       reviewBukkenRrekiAddParamBean.setUpdPg(paramBean.getUpdPg());
       reviewBukkenRrekiAddParamBean.setOperUserId(paramBean.getUpdId());
       lstBukkenRirekiCreReq.add(reviewBukkenRrekiAddParamBean);

       reviewBukkenRrekiAddParamBean = new ReviewBukkenRirekiAddParamBean();
       recordNum  = recordNum + 1;
       reviewBukkenRrekiAddParamBean.setPkBukkenRireki(paramBean.getPkBukkenRireki());
       reviewBukkenRrekiAddParamBean.setCreReqSeq(recordNum);
       reviewBukkenRrekiAddParamBean.setRoomKey(paramBean.getRoomKey());
       reviewBukkenRrekiAddParamBean.setCommonNo(null);
       reviewBukkenRrekiAddParamBean.setSyoriReqKbn("00");
       reviewBukkenRrekiAddParamBean.setCreReqTable("BUKKEN_RIREKI");
       reviewBukkenRrekiAddParamBean.setCreReqCol("ADMIN_UPD_DT");
       reviewBukkenRrekiAddParamBean.setCreReqVal("SYSTIMESTAMP");
       reviewBukkenRrekiAddParamBean.setReqKbn("2");
       reviewBukkenRrekiAddParamBean.setUpdPg(paramBean.getUpdPg());
       reviewBukkenRrekiAddParamBean.setOperUserId(paramBean.getUpdId());
       lstBukkenRirekiCreReq.add(reviewBukkenRrekiAddParamBean);

       return lstBukkenRirekiCreReq;
   }

}

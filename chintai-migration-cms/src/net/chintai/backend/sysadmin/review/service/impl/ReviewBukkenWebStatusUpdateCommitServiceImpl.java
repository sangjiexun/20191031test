/*
 * $Id: ReviewBukkenWebStatusUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/19  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenRirekiAddCommitDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenRirekiAddParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusAddParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenWebStatusUpdateCommitDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenWebStatusUpdateCommitParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewBukkenWebStatusDomain;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenWebStatusUpdateCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * ReviewBukkenWebStatusUpdateCommitServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenWebStatusUpdateCommitServiceImpl implements
        net.chintai.backend.sysadmin.review.service.ReviewBukkenWebStatusUpdateCommitService {

    private static final String KEISAI_TUJYO = "1";

    private static final String KEISAI_TEISHI = "0";

    /** CHINTAI.NET掲載状況更新DAO */
    ReviewBukkenWebStatusUpdateCommitDao reviewBukkenWebStatusUpdateCommitDao;

    /** 物件履歴登録*/
    ReviewBukkenRirekiAddCommitDao reviewBukkenRirekiAddCommitDao;

    /**
     * CHINTAI.NET掲載状況更新DAOを設定します。
     * @param reviewBukkenWebStatusUpdateCommitDao CHINTAI.NET掲載状況更新DAO
     */
    public void setReviewBukkenWebStatusUpdateCommitDao(
            ReviewBukkenWebStatusUpdateCommitDao reviewBukkenWebStatusUpdateCommitDao) {
        this.reviewBukkenWebStatusUpdateCommitDao = reviewBukkenWebStatusUpdateCommitDao;
    }

    /**
     * 物件履歴登録を設定します。
     * @param reviewBukkenRirekiAddCommitDao  物件履歴登録
     */
    public void setReviewBukkenRirekiAddCommitDao(
            ReviewBukkenRirekiAddCommitDao reviewBukkenRirekiAddCommitDao) {
        this.reviewBukkenRirekiAddCommitDao = reviewBukkenRirekiAddCommitDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.service.ReviewBukkenWebStatusUpdateCommitService#updateBukkenWebStatus(net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenWebStatusUpdateCommitInServiceBean)
     */
    public void updateBukkenWebStatus(ReviewBukkenWebStatusUpdateCommitInServiceBean inBean)
            throws ApplicationException {
        ReviewBukkenWebStatusUpdateCommitParamBean paramBean =
                new ReviewBukkenWebStatusUpdateCommitParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        ReviewBukkenWebStatusDomain retBean =
                reviewBukkenWebStatusUpdateCommitDao.selectBukkenWebStatusCheck(paramBean);

        if (retBean == null) {
          throw new ApplicationException("ERROR.M.REVIEW.0083");
          // 更新失敗メッセージID追加
        }

        // PK履歴番号を取得
        paramBean.setPkBukkenRireki(reviewBukkenRirekiAddCommitDao.selectPkBukkenRireki());


        List<ReviewBukkenRirekiAddParamBean> lstReviewBukkenRireki
                = makeListReviewBukkenRrekiAddParamBean(paramBean,retBean);

        for (ReviewBukkenRirekiAddParamBean paramRireki : lstReviewBukkenRireki) {
            reviewBukkenRirekiAddCommitDao.bukkenRirekiAdd(paramRireki);
        }

        ReviewBukkenStatusAddParamBean reviewBukkenStatusBean =
                new ReviewBukkenStatusAddParamBean();
        try {
            BeanUtils.copyProperties(reviewBukkenStatusBean, paramBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        reviewBukkenRirekiAddCommitDao.bukkenStatusKanriAdd(reviewBukkenStatusBean);

    }

   /**
    * 物件履歴登録情報を作成します。
    * @param changeSourceKbn
    * @param paramBean
    */
   private List<ReviewBukkenRirekiAddParamBean>
       makeListReviewBukkenRrekiAddParamBean(ReviewBukkenWebStatusUpdateCommitParamBean paramBean
               ,ReviewBukkenWebStatusDomain paramWebStatusDomain) {

       List<ReviewBukkenRirekiAddParamBean> lstBukkenRirekiCreReq
                   = new ArrayList<ReviewBukkenRirekiAddParamBean>();

       String ctStopDt = null;
       if (KEISAI_TEISHI.equals(paramBean.getBukkenStatusShinsaInput())) {
           ctStopDt = "SYSDATE";
       }

       int recordNum = 0;
       ReviewBukkenRirekiAddParamBean  reviewBukkenRrekiAddParamBean = null;

       //掲載状態が、通常(0)且つソース変更区分が0か2の場合
       if ((KEISAI_TEISHI.equals(paramBean.getBukkenStatusShinsaInput()) &&
                   paramWebStatusDomain.getCtStopDt() == null)
               || ((KEISAI_TUJYO.equals(paramBean.getBukkenStatusShinsaInput())
                   && paramWebStatusDomain.getCtStopDt() != null)
                   && ("2".equals(paramWebStatusDomain.getChangeSourceKbn())
                           || "0".equals(paramWebStatusDomain.getChangeSourceKbn())))) {
           reviewBukkenRrekiAddParamBean = new ReviewBukkenRirekiAddParamBean();
           recordNum  = recordNum + 1;
           reviewBukkenRrekiAddParamBean.setPkBukkenRireki(paramBean.getPkBukkenRireki());
           reviewBukkenRrekiAddParamBean.setCreReqSeq(recordNum);
           reviewBukkenRrekiAddParamBean.setRoomKey(paramBean.getRoomKey());
           reviewBukkenRrekiAddParamBean.setCommonNo(null);
           reviewBukkenRrekiAddParamBean.setSyoriReqKbn("00");
           reviewBukkenRrekiAddParamBean.setCreReqTable("BUKKEN_RIREKI");
           reviewBukkenRrekiAddParamBean.setCreReqCol("CT_STOP_DT");
           reviewBukkenRrekiAddParamBean.setCreReqVal(ctStopDt);
           reviewBukkenRrekiAddParamBean.setReqKbn("2");
           reviewBukkenRrekiAddParamBean.setUpdPg(paramBean.getUpdPg());
           reviewBukkenRrekiAddParamBean.setOperUserId(paramBean.getUpdId());
           lstBukkenRirekiCreReq.add(reviewBukkenRrekiAddParamBean);
       }

       reviewBukkenRrekiAddParamBean = new ReviewBukkenRirekiAddParamBean();
       recordNum  = recordNum + 1;
       reviewBukkenRrekiAddParamBean.setPkBukkenRireki(paramBean.getPkBukkenRireki());
       reviewBukkenRrekiAddParamBean.setCreReqSeq(recordNum);
       reviewBukkenRrekiAddParamBean.setRoomKey(paramBean.getRoomKey());
       reviewBukkenRrekiAddParamBean.setCommonNo(null);
       reviewBukkenRrekiAddParamBean.setSyoriReqKbn("00");
       reviewBukkenRrekiAddParamBean.setCreReqTable("BUKKEN_RIREKI");
       reviewBukkenRrekiAddParamBean.setCreReqCol("SHINSA_BUKKEN_STATUS_BIKOU");
       reviewBukkenRrekiAddParamBean.setCreReqVal(paramBean.getShinsaBukkenStatusBikou());
       reviewBukkenRrekiAddParamBean.setReqKbn("2");
       reviewBukkenRrekiAddParamBean.setUpdPg(paramBean.getUpdPg());
       reviewBukkenRrekiAddParamBean.setOperUserId(paramBean.getUpdId());
       lstBukkenRirekiCreReq.add(reviewBukkenRrekiAddParamBean);

       //掲載状態が、通常(0)且つソース変更区分が0か2の場合
       if (KEISAI_TEISHI.equals(paramBean.getBukkenStatusShinsaInput()) ||
               (KEISAI_TUJYO.equals(paramBean.getBukkenStatusShinsaInput())
               && ( "2".equals(paramWebStatusDomain.getChangeSourceKbn())
                       || "0".equals(paramWebStatusDomain.getChangeSourceKbn())))) {
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
       }

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


       //掲載状態が停止→通常の場合、名寄せ依頼処理
       if ((KEISAI_TUJYO.equals(paramBean.getBukkenStatusShinsaInput())
               && paramWebStatusDomain.getCtStopDt() != null)) {
           reviewBukkenRrekiAddParamBean = new ReviewBukkenRirekiAddParamBean();
           recordNum  = recordNum + 1;
           reviewBukkenRrekiAddParamBean.setPkBukkenRireki(paramBean.getPkBukkenRireki());
           reviewBukkenRrekiAddParamBean.setCreReqSeq(recordNum);
           reviewBukkenRrekiAddParamBean.setRoomKey(paramBean.getRoomKey());
           reviewBukkenRrekiAddParamBean.setCommonNo(null);
           reviewBukkenRrekiAddParamBean.setSyoriReqKbn("01");
           reviewBukkenRrekiAddParamBean.setCreReqTable(null);
           reviewBukkenRrekiAddParamBean.setCreReqCol(null);
           reviewBukkenRrekiAddParamBean.setCreReqVal(null);
           reviewBukkenRrekiAddParamBean.setReqKbn("2");
           reviewBukkenRrekiAddParamBean.setUpdPg(paramBean.getUpdPg());
           reviewBukkenRrekiAddParamBean.setOperUserId(paramBean.getUpdId());
           lstBukkenRirekiCreReq.add(reviewBukkenRrekiAddParamBean);
       }


       return lstBukkenRirekiCreReq;
   }

}

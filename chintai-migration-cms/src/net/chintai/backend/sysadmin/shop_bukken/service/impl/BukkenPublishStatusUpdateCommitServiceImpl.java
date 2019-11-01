/*
 * $Id: BukkenPublishStatusUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenPublishStatusRirekiAddCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenPublishStatusUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenPublishStatusUpdateCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenPublishStatusUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenPublishStatusUpdateCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * BukkenPublishStatusUpdateCommitService の実装クラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenPublishStatusUpdateCommitServiceImpl implements
        BukkenPublishStatusUpdateCommitService {

    private static final String KEISAI_TUJYO = "1";

    private static final String KEISAI_TEISHI = "0";

    /** 物件掲載状態変更完了DAO */
    private BukkenPublishStatusUpdateCommitDao bukkenPublishStatusUpdateCommitDao = null;

    /**
     * BukkenPublishStatusUpdateCommitDaoを設定する
     * @param bukkenPublishStatusUpdateCommitDao
     */
    public void setBukkenPublishStatusUpdateCommitDao(
            BukkenPublishStatusUpdateCommitDao bukkenPublishStatusUpdateCommitDao) {
        this.bukkenPublishStatusUpdateCommitDao = bukkenPublishStatusUpdateCommitDao;
    }
    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.BukkenPublishStatusUpdateCommitService#bukkenPublishStatusUpdateCommit(net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenPublishStatusUpdateCommitInServiceBean)
     */
    public void bukkenPublishStatusUpdateCommit(
            BukkenPublishStatusUpdateCommitInServiceBean inServiceBean)
            throws ApplicationException {
        BukkenPublishStatusUpdateCommitParamBean paramBean =
            new BukkenPublishStatusUpdateCommitParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        HashMap<String,Object> bukkenPublishStatus = (HashMap<String,Object>)bukkenPublishStatusUpdateCommitDao
                    .selectBukkenPublishStatusUpdateCheck(paramBean);

        if (bukkenPublishStatus == null){
            throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0003");
        }

        String changeSourceKbn = (String)bukkenPublishStatus.get("CHANGE_SOURCE_KBN");
        Timestamp ctStopDt =  (Timestamp)bukkenPublishStatus.get("ABL_STOP_DT");
        Timestamp ablStopDt =  (Timestamp)bukkenPublishStatus.get("CT_STOP_DT");

        // ステータスに変更がなかった場合は、終了
        if ((ctStopDt == null || ablStopDt == null) &&
                "1".equals(paramBean.getBukkenStatus())) {
            // 通常→通常
            return;
        } else if ((ctStopDt != null && ablStopDt != null) &&
                "0".equals(paramBean.getBukkenStatus())) {
            // 停止→停止
            return;
        }



        // PK履歴番号を取得
        paramBean.setPkBukkenRireki(bukkenPublishStatusUpdateCommitDao.selectSeqBUkkenRireki());

        // 物件履歴依頼テーブル登録（物件履歴・名寄せ）
        // changeSourceKbnの値によって登録するレコードが変わる
        List<BukkenPublishStatusRirekiAddCommitParamBean> lstBukkenRirekiCreReq
                    = makeListBukkenPublishStatusRirekiAddCommitParamBean(changeSourceKbn,paramBean);

        //物件ステータス管理登録
        bukkenPublishStatusUpdateCommitDao.bukkenStatuKanriAddCommit(paramBean);

        for (BukkenPublishStatusRirekiAddCommitParamBean paramRecord : lstBukkenRirekiCreReq) {
            bukkenPublishStatusUpdateCommitDao.bukkenPublishStatuRirekiAddCommit(paramRecord);
        }
    }
    /**
     * 物件履歴依頼テーブル登録（物件履歴・名寄せ）
     * @param changeSourceKbn
     * @param paramBean
     */
    private List<BukkenPublishStatusRirekiAddCommitParamBean>
        makeListBukkenPublishStatusRirekiAddCommitParamBean(
            String changeSourceKbn, BukkenPublishStatusUpdateCommitParamBean paramBean) {

        List<BukkenPublishStatusRirekiAddCommitParamBean> lstBukkenRirekiCreReq
                    = new ArrayList<BukkenPublishStatusRirekiAddCommitParamBean>();

        String ctStopDt = null;
        String ablStopDt = null;
        if (KEISAI_TEISHI.equals(paramBean.getBukkenStatus())) {
            ctStopDt ="SYSDATE";
            ablStopDt = "SYSDATE";
        }

        int recordNum = 0;
        BukkenPublishStatusRirekiAddCommitParamBean  bukkenRirekiCreReqParamBean = null;

        if (KEISAI_TEISHI.equals(paramBean.getBukkenStatus()) ||
                (KEISAI_TUJYO.equals(paramBean.getBukkenStatus()) &&
                        ("0".equals(changeSourceKbn) || "1".equals(changeSourceKbn)))) {
            bukkenRirekiCreReqParamBean = new BukkenPublishStatusRirekiAddCommitParamBean();
            recordNum  = recordNum + 1;
            bukkenRirekiCreReqParamBean.setPkBukkenRireki(paramBean.getPkBukkenRireki());
            bukkenRirekiCreReqParamBean.setCreReqSeq(recordNum);
            bukkenRirekiCreReqParamBean.setRoomKey(paramBean.getRoomKey());
            bukkenRirekiCreReqParamBean.setCommonNo(null);
            bukkenRirekiCreReqParamBean.setSyoriReqKbn("00");
            bukkenRirekiCreReqParamBean.setCreReqTable("BUKKEN_RIREKI");
            bukkenRirekiCreReqParamBean.setCreReqCol("CT_STOP_DT");
            bukkenRirekiCreReqParamBean.setCreReqVal(ctStopDt);
            bukkenRirekiCreReqParamBean.setReqKbn("2");
            bukkenRirekiCreReqParamBean.setUpdPg(paramBean.getUpdPg());
            bukkenRirekiCreReqParamBean.setOperUserId(paramBean.getOperUserId());
            lstBukkenRirekiCreReq.add(bukkenRirekiCreReqParamBean);
        }

        bukkenRirekiCreReqParamBean = new BukkenPublishStatusRirekiAddCommitParamBean();
        recordNum  = recordNum + 1;
        bukkenRirekiCreReqParamBean.setPkBukkenRireki(paramBean.getPkBukkenRireki());
        bukkenRirekiCreReqParamBean.setCreReqSeq(recordNum);
        bukkenRirekiCreReqParamBean.setRoomKey(paramBean.getRoomKey());
        bukkenRirekiCreReqParamBean.setCommonNo(null);
        bukkenRirekiCreReqParamBean.setSyoriReqKbn("00");
        bukkenRirekiCreReqParamBean.setCreReqTable("BUKKEN_RIREKI");
        bukkenRirekiCreReqParamBean.setCreReqCol("ABL_STOP_DT");
        bukkenRirekiCreReqParamBean.setCreReqVal(ablStopDt);
        bukkenRirekiCreReqParamBean.setReqKbn("2");
        bukkenRirekiCreReqParamBean.setUpdPg(paramBean.getUpdPg());
        bukkenRirekiCreReqParamBean.setOperUserId(paramBean.getOperUserId());
        lstBukkenRirekiCreReq.add(bukkenRirekiCreReqParamBean);

        if (KEISAI_TEISHI.equals(paramBean.getBukkenStatus()) ||
                (KEISAI_TUJYO.equals(paramBean.getBukkenStatus()) &&
                        ("0".equals(changeSourceKbn) || "1".equals(changeSourceKbn)))) {
            bukkenRirekiCreReqParamBean = new BukkenPublishStatusRirekiAddCommitParamBean();
            recordNum  = recordNum + 1;
            bukkenRirekiCreReqParamBean.setPkBukkenRireki(paramBean.getPkBukkenRireki());
            bukkenRirekiCreReqParamBean.setCreReqSeq(recordNum);
            bukkenRirekiCreReqParamBean.setRoomKey(paramBean.getRoomKey());
            bukkenRirekiCreReqParamBean.setCommonNo(null);
            bukkenRirekiCreReqParamBean.setSyoriReqKbn("00");
            bukkenRirekiCreReqParamBean.setCreReqTable("BUKKEN_RIREKI");
            bukkenRirekiCreReqParamBean.setCreReqCol("CHANGE_SOURCE_KBN");
            bukkenRirekiCreReqParamBean.setCreReqVal("1");
            bukkenRirekiCreReqParamBean.setReqKbn("2");
            bukkenRirekiCreReqParamBean.setUpdPg(paramBean.getUpdPg());
            bukkenRirekiCreReqParamBean.setOperUserId(paramBean.getOperUserId());
            lstBukkenRirekiCreReq.add(bukkenRirekiCreReqParamBean);
        }

        bukkenRirekiCreReqParamBean = new BukkenPublishStatusRirekiAddCommitParamBean();
        recordNum  = recordNum + 1;
        bukkenRirekiCreReqParamBean.setPkBukkenRireki(paramBean.getPkBukkenRireki());
        bukkenRirekiCreReqParamBean.setCreReqSeq(recordNum);
        bukkenRirekiCreReqParamBean.setRoomKey(paramBean.getRoomKey());
        bukkenRirekiCreReqParamBean.setCommonNo(null);
        bukkenRirekiCreReqParamBean.setSyoriReqKbn("00");
        bukkenRirekiCreReqParamBean.setCreReqTable("BUKKEN_RIREKI");
        bukkenRirekiCreReqParamBean.setCreReqCol("ADMIN_UPD_DT");
        bukkenRirekiCreReqParamBean.setCreReqVal("SYSTIMESTAMP");
        bukkenRirekiCreReqParamBean.setReqKbn("2");
        bukkenRirekiCreReqParamBean.setUpdPg(paramBean.getUpdPg());
        bukkenRirekiCreReqParamBean.setOperUserId(paramBean.getOperUserId());
        lstBukkenRirekiCreReq.add(bukkenRirekiCreReqParamBean);

        // 名寄せレコード作製（停止→通常）
        if (KEISAI_TUJYO.equals(paramBean.getBukkenStatus())){
            bukkenRirekiCreReqParamBean = new BukkenPublishStatusRirekiAddCommitParamBean();
            recordNum  = recordNum + 1;
            bukkenRirekiCreReqParamBean.setPkBukkenRireki(paramBean.getPkBukkenRireki());
            bukkenRirekiCreReqParamBean.setCreReqSeq(recordNum);
            bukkenRirekiCreReqParamBean.setRoomKey(paramBean.getRoomKey());
            bukkenRirekiCreReqParamBean.setCommonNo(null);
            bukkenRirekiCreReqParamBean.setSyoriReqKbn("01");
            bukkenRirekiCreReqParamBean.setCreReqTable(null);
            bukkenRirekiCreReqParamBean.setCreReqCol(null);
            bukkenRirekiCreReqParamBean.setCreReqVal(null);
            bukkenRirekiCreReqParamBean.setReqKbn("2");
            bukkenRirekiCreReqParamBean.setUpdPg(paramBean.getUpdPg());
            bukkenRirekiCreReqParamBean.setOperUserId(paramBean.getOperUserId());
            lstBukkenRirekiCreReq.add(bukkenRirekiCreReqParamBean);
        }


        return lstBukkenRirekiCreReq;
    }

}
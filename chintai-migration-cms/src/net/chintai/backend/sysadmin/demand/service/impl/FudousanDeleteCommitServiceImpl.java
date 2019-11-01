/*
 * $Id: FudousanDeleteCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/05     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.dao.FudousanDeleteCommitDao;
import net.chintai.backend.sysadmin.demand.dao.FudousanDeleteCommitParamBean;
import net.chintai.backend.sysadmin.demand.service.FudousanDeleteCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanDeleteCommitInServiceBean;

/**
 * FudousanDeleteCommitServiceの実装クラス
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanDeleteCommitServiceImpl implements FudousanDeleteCommitService {

    /** 不動産会社削除DAO */
    private FudousanDeleteCommitDao fudousanDeleteCommitDao;

    /**
     * @param fudousanDeleteCommitDao 設定する fudousanDeleteCommitDao
     */
    public void setFudousanDeleteCommitDao(FudousanDeleteCommitDao fudousanDeleteCommitDao) {
        this.fudousanDeleteCommitDao = fudousanDeleteCommitDao;
    }
    public void fudousanDeleteCommit(FudousanDeleteCommitInServiceBean inServiceBean)
            throws ApplicationException {

        // 不動産会社コードリストをParamBeanに設定
        FudousanDeleteCommitParamBean paramBean = new FudousanDeleteCommitParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        String[] fudousanCd = inServiceBean.getFudousanCd();
        String[] updDt = inServiceBean.getUpdDt();

        for (int i = 0; i < fudousanCd.length; i++) {
            paramBean.setFudousanCd(fudousanCd[i]);
            paramBean.setUpdDt(updDt[i]);
            // 削除処理結果をチェックする
            if (fudousanDeleteCommitDao.fudousanDeleteCommit(paramBean) == 0) {
                throw new ApplicationException("ERROR.M.DEMAND.0047");
            }
        }

    }

    


}

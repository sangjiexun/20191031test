/*
 * $Id: FudousanInfoServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/29     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.dao.FudousanInfoDao;
import net.chintai.backend.sysadmin.demand.dao.FudousanInfoParamBean;
import net.chintai.backend.sysadmin.demand.domain.FudousanDomain;
import net.chintai.backend.sysadmin.demand.service.FudousanInfoService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanInfoInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanInfoOutServiceBean;

/**
 * FudousanInfoServiceの実装クラス
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanInfoServiceImpl implements FudousanInfoService {

    /** 不動産会社詳細DAO */
    private FudousanInfoDao fudousanInfoDao = null;

    /**
     * FudousanInfoDaoを設定する
     * @param fudousanInfoDao
     */
    public void setFudousanInfoDao(FudousanInfoDao fudousanInfoDao) {
        this.fudousanInfoDao = fudousanInfoDao;
    }

    public FudousanInfoOutServiceBean fudousanInfo(FudousanInfoInServiceBean inServiceBean)
            throws ApplicationException {

        // 不動産会社コードをParamBeanに設定
        FudousanInfoParamBean paramBean = new FudousanInfoParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 不動産会社詳細情報を取得
        FudousanDomain fudousanInfo = fudousanInfoDao.fudousanInfo(paramBean);
        
        if(fudousanInfo == null) {
            throw new ApplicationException("ERROR.M.DEMAND.0125");
        }
        
        FudousanInfoOutServiceBean outServiceBean = new FudousanInfoOutServiceBean();

        try {
            BeanUtils.copyProperties(outServiceBean, fudousanInfo);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return outServiceBean;
    }

}

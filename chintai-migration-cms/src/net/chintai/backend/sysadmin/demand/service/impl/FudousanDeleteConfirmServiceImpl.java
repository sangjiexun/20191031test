/*
 * $Id: FudousanDeleteConfirmServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/04     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.dao.FudousanDeleteConfirmDao;
import net.chintai.backend.sysadmin.demand.dao.FudousanDeleteConfirmParamBean;
import net.chintai.backend.sysadmin.demand.domain.FudousanDomain;
import net.chintai.backend.sysadmin.demand.service.FudousanDeleteConfirmService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanDeleteConfirmInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanDeleteConfirmOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * FudousanDeleteConfirmServiceの実装クラス
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanDeleteConfirmServiceImpl implements FudousanDeleteConfirmService {

    /** 不動産削除リスト取得 DAO */
    private FudousanDeleteConfirmDao fudousanDeleteConfirmDao;

    /**
     * FudousanDeleteConfirmDaoを設定する
     * @param fudousanDeleteConfirmDao
     */
    public void setFudousanDeleteConfirmDao(FudousanDeleteConfirmDao fudousanDeleteConfirmDao) {
        this.fudousanDeleteConfirmDao = fudousanDeleteConfirmDao;
    }

    public List<FudousanDeleteConfirmOutServiceBean> fudousanDeleteConfirm(
            FudousanDeleteConfirmInServiceBean inServiceBean) throws ApplicationException {

        // 不動産会社削除リストをParamBeanに設定
        FudousanDeleteConfirmParamBean paramBean = new FudousanDeleteConfirmParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 不動産会社削除リスト取得
        List rsList = fudousanDeleteConfirmDao.fudousanDeleteConfirm(paramBean);

        int affected = rsList.size();

        if (affected != inServiceBean.getFudousanCd().length) {
            throw new ApplicationException("ERROR.M.DEMAND.0080");
        }

        // 不動産会社削除リストをFudousanDeleteConfirmOutServiceBeanに設定
        List<FudousanDeleteConfirmOutServiceBean> fudousanDeleteList =
                new ArrayList<FudousanDeleteConfirmOutServiceBean>();

        for (int i = 0; i < rsList.size(); i++) {
            FudousanDeleteConfirmOutServiceBean outServiceBean =
                    new FudousanDeleteConfirmOutServiceBean();
            FudousanDomain fudousan = (FudousanDomain) rsList.get(i);
            try {
                BeanUtils.copyProperties(outServiceBean, fudousan);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }

            fudousanDeleteList.add(outServiceBean);
        }

        return fudousanDeleteList;
    }

}

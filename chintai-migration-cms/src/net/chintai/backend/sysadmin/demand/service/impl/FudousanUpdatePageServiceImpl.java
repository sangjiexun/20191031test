/*
 * $Id: FudousanUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.demand.dao.FudousanUpdatePageDao;
import net.chintai.backend.sysadmin.demand.dao.FudousanUpdatePageParamBean;
import net.chintai.backend.sysadmin.demand.domain.FudousanDomain;
import net.chintai.backend.sysadmin.demand.service.FudousanUpdatePageService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanUpdatePageOutServiceBean;

/**
 * FudousanUpdatePageServiceの実装クラス
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanUpdatePageServiceImpl implements FudousanUpdatePageService {

    /** 不動産会社更新画面に遷移DAO */
    private FudousanUpdatePageDao fudousanUpdatePageDao = null;

    public void setFudousanUpdatePageDao(FudousanUpdatePageDao fudousanUpdatePageDao) {
        this.fudousanUpdatePageDao = fudousanUpdatePageDao;
    }

    public FudousanUpdatePageOutServiceBean fudousanUpdatePage(
            FudousanUpdatePageInServiceBean inServiceBean) throws ApplicationException {

        // 不動産会社コードをParamBeanに設定
        FudousanUpdatePageParamBean paramBean = new FudousanUpdatePageParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 不動産会社情報を取得
        FudousanDomain fudousan = fudousanUpdatePageDao.fudousanUpdatePage(paramBean);

        if (fudousan == null) {
            throw new ApplicationException("ERROR.M.DEMAND.0125");
        }

        FudousanUpdatePageOutServiceBean outServiceBean = new FudousanUpdatePageOutServiceBean();

        // 取得した情報をOutServiceBeanに設定
        try {
            BeanUtils.copyProperties(outServiceBean, fudousan);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return outServiceBean;
    }

}

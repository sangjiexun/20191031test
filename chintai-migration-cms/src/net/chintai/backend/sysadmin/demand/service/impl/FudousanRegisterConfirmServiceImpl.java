/*
 * $Id: FudousanRegisterConfirmServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/26  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.demand.dao.FudousanConfirmCompanyInfoParamBean;
import net.chintai.backend.sysadmin.demand.dao.FudousanRegisterConfirmServiceDao;
import net.chintai.backend.sysadmin.demand.service.FudousanRegisterConfirmService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanRegisterConfirmInServiceBean;

/**
 * FudousanRegisterConfirmServiceの実装クラス
 * 
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanRegisterConfirmServiceImpl implements FudousanRegisterConfirmService {

    /** 不動産会社登録確認DAO */
    FudousanRegisterConfirmServiceDao fudousanRegisterConfirmDao;

    /**
     * 不動産会社登録確認DAOを設定します。
     * @param fudousanRegisterConfirmDao 不動産会社登録確認DAO
     */
    public void setFudousanRegisterConfirmDao(
            FudousanRegisterConfirmServiceDao fudousanRegisterConfirmDao) {
        this.fudousanRegisterConfirmDao = fudousanRegisterConfirmDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.FudousanRegisterConfirmService#confirmKaisyaInfo(net.chintai.backend.sysadmin.demand.service.bean.FudousanRegisterConfirmInServiceBean)
     */
    public int confirmKaisyaInfo(FudousanRegisterConfirmInServiceBean inBean) {

        FudousanConfirmCompanyInfoParamBean paramBean = new FudousanConfirmCompanyInfoParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return fudousanRegisterConfirmDao.confirmCompanyInfo(paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.FudousanRegisterConfirmService#getNextFudousanCd()
     */
    public String getNextFudousanCd() {

        return fudousanRegisterConfirmDao.getNextFudousanCd();
    }
}

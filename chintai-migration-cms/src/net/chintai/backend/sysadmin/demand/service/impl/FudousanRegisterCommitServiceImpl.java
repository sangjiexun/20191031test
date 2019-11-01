/*
 * $Id: FudousanRegisterCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.demand.dao.FudousanRegisterCommitParamBean;
import net.chintai.backend.sysadmin.demand.dao.FudousanRegisterCommitDao;
import net.chintai.backend.sysadmin.demand.service.FudousanRegisterCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanRegisterCommitInServiceBean;


/**
 * FudousanRegisterCommitServiceの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanRegisterCommitServiceImpl implements FudousanRegisterCommitService {

    /** 不動産会社新規登録DAO */
    FudousanRegisterCommitDao fudousanRegisterCommitDao;

    /**
     * 不動産会社新規登録DAOを設定します。
     * @param fudousanRegisterCommitDao 不動産会社新規登録DAO
     */
    public void setFudousanRegisterCommitDao(FudousanRegisterCommitDao fudousanRegisterCommitDao) {
        this.fudousanRegisterCommitDao = fudousanRegisterCommitDao;
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.FudousanRegisterCommitService#insertFudousanCompanyInfo(net.chintai.backend.sysadmin.demand.service.bean.FudousanRegisterCommitInServiceBean)
     */
    public void insertFudousanCompanyInfo(FudousanRegisterCommitInServiceBean inBean) {

        FudousanRegisterCommitParamBean paramBean = new FudousanRegisterCommitParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        fudousanRegisterCommitDao.insertFudousanInfo(paramBean);

    }
}

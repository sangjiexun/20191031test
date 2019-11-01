/*
 * $Id: FudousanUpdateConfirmServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/04     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.demand.dao.FudousanConfirmCompanyInfoParamBean;
import net.chintai.backend.sysadmin.demand.dao.FudousanUpdateConfirmServiceDao;
import net.chintai.backend.sysadmin.demand.service.FudousanUpdateConfirmService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanUpdateConfirmInServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanUpdateConfirmServiceImpl implements FudousanUpdateConfirmService {

    /** 不動産会社更新確認DAO */
    FudousanUpdateConfirmServiceDao fudousanUpdateConfirmDao;

    /**
     * 不動産会社更新確認DAOを設定します。
     * @param fudousanUpdateConfirmDao 不動産会社更新確認DAO
     */
    public void setFudousanUpdateConfirmDao(FudousanUpdateConfirmServiceDao fudousanUpdateConfirmDao) {
        this.fudousanUpdateConfirmDao = fudousanUpdateConfirmDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.FudousanUpdateConfirmService#confirmKaisyaInfo(net.chintai.backend.sysadmin.demand.service.bean.FudousanUpdateConfirmInServiceBean)
     */
    public int confirmKaisyaInfo(FudousanUpdateConfirmInServiceBean inBean) {

        FudousanConfirmCompanyInfoParamBean paramBean = new FudousanConfirmCompanyInfoParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return fudousanUpdateConfirmDao.confirmCompanyInfo(paramBean);
    }

}

/*
 * $Id: CjnUserUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserUpdateCommitDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserUpdateCommitParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserUpdateCommitService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserUpdateCommitInServiceBean;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;

import org.apache.commons.beanutils.BeanUtils;

/**
 * CjnUserUpdateCommitServiceの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserUpdateCommitServiceImpl implements CjnUserUpdateCommitService {

    /** 問い合せユーザ更新DAO */
    private CjnUserUpdateCommitDao cjnUserUpdateCommitDao;

    /**
     * 問い合せユーザ更新DAO設定
     * @param cjnUserUpdateCommitDao
     */
    public void setCjnUserUpdateCommitDao(CjnUserUpdateCommitDao cjnUserUpdateCommitDao) {
        this.cjnUserUpdateCommitDao = cjnUserUpdateCommitDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserUpdateCommitService#cjnUserUpdateCommit(net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserUpdateCommitInServiceBean)
     */
    public void cjnUserUpdateCommit(CjnUserUpdateCommitInServiceBean inServiceBean)
            throws ApplicationException {

        // paramBeanにセット
        CjnUserUpdateCommitParamBean paramBean = new CjnUserUpdateCommitParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        int updateCnt = cjnUserUpdateCommitDao.updateCjnUser(paramBean);

        // エラー処理
        if (updateCnt == 0) {
            throw new ApplicationException("ERROR.M.CJN_INQUIRY.0004");
        }

    }

}

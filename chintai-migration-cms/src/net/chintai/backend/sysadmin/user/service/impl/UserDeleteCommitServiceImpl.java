/*
 * $Id: UserDeleteCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.dao.UserDeleteCommitDao;
import net.chintai.backend.sysadmin.user.dao.UserDeleteCommitParamBean;
import net.chintai.backend.sysadmin.user.service.UserDeleteCommitService;
import net.chintai.backend.sysadmin.user.service.bean.UserDeleteCommitInServiceBean;

/**
 * UserDeleteCommitServiceの実装クラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserDeleteCommitServiceImpl implements UserDeleteCommitService {

    /** ユーザ削除完了DAO */
    private UserDeleteCommitDao userDeleteCommitDao = null;

    /**
     * UserDeleteCommitDaoを設定する
     * @param userDeleteCommitDao
     */
    public void setUserDeleteCommitDao(UserDeleteCommitDao userDeleteCommitDao) {
        this.userDeleteCommitDao = userDeleteCommitDao;
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.UserDeleteCommitService#userDeleteCommit(net.chintai.backend.sysadmin.user.service.bean.UserDeleteCommitInServiceBean)
     */
    public void userDeleteCommit(UserDeleteCommitInServiceBean inServiceBean)
            throws ApplicationException {

        // ユーザ削除IDリストをParamBeanに設定
        UserDeleteCommitParamBean paramBean = new UserDeleteCommitParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        String[] userCheckId = inServiceBean.getUserCheckId();
        String[] updDt = inServiceBean.getUpdDt();

        for (int i = 0; i < userCheckId.length; i++) {
            paramBean.setUserCheckId(userCheckId[i]);
            paramBean.setUpdDt(updDt[i]);
            // 削除処理結果をチェックする
            if (userDeleteCommitDao.userDeleteCommit(paramBean) == 0) {
                throw new ApplicationException("ERROR.M.USER.0005");
            }
        }
    }
}
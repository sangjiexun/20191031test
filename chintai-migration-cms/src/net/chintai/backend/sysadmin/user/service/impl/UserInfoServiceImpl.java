/*
 * $Id: UserInfoServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.dao.UserInfoDao;
import net.chintai.backend.sysadmin.user.dao.UserInfoParamBean;
import net.chintai.backend.sysadmin.user.domain.UserDomain;
import net.chintai.backend.sysadmin.user.service.UserInfoService;
import net.chintai.backend.sysadmin.user.service.bean.UserInfoInServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.UserInfoOutServiceBean;

/**
 * UserInfoServiceの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserInfoServiceImpl implements UserInfoService {

    /** ユーザ詳細DAO */
    private UserInfoDao userInfoDao = null;

    /**
     * UserInfoDaoを設定する
     * @param userInfoDao
     */
    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.UserInfoService#userInfo(net.chintai.backend.sysadmin.user.service.bean.UserInfoInServiceBean)
     */
    public UserInfoOutServiceBean userInfo(UserInfoInServiceBean inServiceBean)
            throws ApplicationException {

        // ユーザIDをParamBeanに設定
        UserInfoParamBean paramBean = new UserInfoParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // ユーザ詳細情報を取得
        UserDomain user = userInfoDao.userInfo(paramBean);

        if(user == null) {
            throw new ApplicationException("ERROR.M.USER.0002");
        }
        UserInfoOutServiceBean outServiceBean = new UserInfoOutServiceBean();

        // 取得した情報をOutServiceBeanに設定
        try {
            BeanUtils.copyProperties(outServiceBean, user);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return outServiceBean;
    }
}
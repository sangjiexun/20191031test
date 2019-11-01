/*
 * $Id: UserUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.user.dao.UserUpdatePageDao;
import net.chintai.backend.sysadmin.user.dao.UserUpdatePageParamBean;
import net.chintai.backend.sysadmin.user.domain.UserDomain;
import net.chintai.backend.sysadmin.user.service.UserUpdatePageService;
import net.chintai.backend.sysadmin.user.service.bean.UserUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.UserUpdatePageOutServiceBean;


/**
 * UserUpdatePageServiceの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserUpdatePageServiceImpl implements UserUpdatePageService {

    /** ユーザ更新画面に遷移DAO */
    private UserUpdatePageDao userUpdatePageDao = null;

    /**
     * UserUpdatePageDaoを設定する
     * @param userUpdatePageDao
     */
    public void setUserUpdatePageDao(UserUpdatePageDao userUpdatePageDao) {
        this.userUpdatePageDao = userUpdatePageDao;
    }
    
    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.UserUpdatePageService#userUpdatePage(net.chintai.backend.sysadmin.user.service.bean.UserUpdatePageInServiceBean)
     */
    public UserUpdatePageOutServiceBean userUpdatePage(
            UserUpdatePageInServiceBean inServiceBean)
            throws ApplicationException {

        // ユーザIDをParamBeanに設定
        UserUpdatePageParamBean paramBean = new UserUpdatePageParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // ユーザ詳細情報を取得
        UserDomain user = userUpdatePageDao.userUpdatePage(paramBean);

        if (user == null) {
            throw new ApplicationException("ERROR.M.USER.0006");
        }

        UserUpdatePageOutServiceBean outServiceBean =
            new UserUpdatePageOutServiceBean();
        
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

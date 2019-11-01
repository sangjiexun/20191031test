/*
 * $Id: UserAddConfirmServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/20  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.user.dao.UserAddConfirmDao;
import net.chintai.backend.sysadmin.user.dao.UserAddConfirmParamBean;
import net.chintai.backend.sysadmin.user.service.UserAddConfirmService;
import net.chintai.backend.sysadmin.user.service.bean.UserAddConfirmInServiceBean;

/**
 * UserAddConfirmServiceの実装クラス。
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserAddConfirmServiceImpl implements UserAddConfirmService {

    /** ユーザIDのチェック DAO */
    private UserAddConfirmDao userAddConfirmDao = null;

    /**
     * UserAddConfirmDaoを設定する
     * @param userAddConfirmDao
     */
    public void setUserAddConfirmDao(UserAddConfirmDao userAddConfirmDao) {
        this.userAddConfirmDao = userAddConfirmDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.UserAddConfirmService#getUserId(net.chintai.backend.sysadmin.user.service.bean.UserAddConfirmInServiceBean)
     */
    public int userAddConfirm(UserAddConfirmInServiceBean inServiceBean) throws InvocationTargetException,
            IllegalAccessException {

        // 入力されたユーザIDをParamBeanに設定
        UserAddConfirmParamBean paramBean = new UserAddConfirmParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // ユーザIDチェックを行う
        return userAddConfirmDao.userAddConfirm(paramBean);
    }
}

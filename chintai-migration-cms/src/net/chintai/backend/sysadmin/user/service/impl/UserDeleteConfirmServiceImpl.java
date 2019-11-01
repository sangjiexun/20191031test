/*
 * $Id: UserDeleteConfirmServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.dao.UserDeleteConfirmDao;
import net.chintai.backend.sysadmin.user.dao.UserDeleteConfirmParamBean;
import net.chintai.backend.sysadmin.user.domain.UserDomain;
import net.chintai.backend.sysadmin.user.service.UserDeleteConfirmService;
import net.chintai.backend.sysadmin.user.service.bean.UserDeleteConfirmInServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.UserDeleteConfirmOutServiceBean;


/**
 * UserDeleteConfirmServiceの実装クラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserDeleteConfirmServiceImpl implements UserDeleteConfirmService {

    /** ユーザ削除リスト取得 DAO */
    private UserDeleteConfirmDao userDeleteConfirmDao = null;

    /**
     * UserDeleteConfirmDaoを設定する
     * @param userDeleteConfirmDao
     */
    public void setUserDeleteConfirmDao(UserDeleteConfirmDao userDeleteConfirmDao) {
        this.userDeleteConfirmDao = userDeleteConfirmDao;
    }
    
    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.UserDeleteConfirmService#userDeleteConfirm(net.chintai.backend.sysadmin.user.service.bean.UserDeleteConfirmInServiceBean)
     */
    public List userDeleteConfirm(UserDeleteConfirmInServiceBean inServiceBean)
            throws ApplicationException {

        // ユーザ削除IDリストをParamBeanに設定
        UserDeleteConfirmParamBean paramBean = new UserDeleteConfirmParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // ユーザ削除リスト取得
        List rsList = userDeleteConfirmDao.userDeleteConfirm(paramBean);

        int affected = rsList.size();

        if (affected != inServiceBean.getUserCheckId().length){
            throw new ApplicationException("ERROR.M.USER.0006");
        }

        // ユーザ削除リストをUserDeleteConfirmOutServiceBeanに設定
        List<UserDeleteConfirmOutServiceBean> userDeleteList = 
            new ArrayList<UserDeleteConfirmOutServiceBean>();
        
        for(int i = 0; i < rsList.size(); i++)
        {
            UserDeleteConfirmOutServiceBean outServiceBean =
                new UserDeleteConfirmOutServiceBean();
            UserDomain user = (UserDomain)rsList.get(i);
            try {
                BeanUtils.copyProperties(outServiceBean, user);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            userDeleteList.add(outServiceBean);
        }

        return userDeleteList;
    }


}

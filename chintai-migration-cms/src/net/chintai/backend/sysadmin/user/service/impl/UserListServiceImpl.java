/*
 * $Id: UserListServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/20  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.user.dao.UserListDao;
import net.chintai.backend.sysadmin.user.domain.UserDomain;
import net.chintai.backend.sysadmin.user.service.UserListService;
import net.chintai.backend.sysadmin.user.service.bean.UserListOutServiceBean;

/**
 * UserListServiceの実装クラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserListServiceImpl implements UserListService {

    /** ユーザリスト取得 DAO */
    private UserListDao userListDao;
    
    /**
     * UserListDaoを設定する
     * @param userListDao
     */
    
    public void setUserListDao(UserListDao userListDao) {
        this.userListDao = userListDao;
    }
    
    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.UserListService#getUserList()
     */
    public List userList() throws InvocationTargetException,
            IllegalAccessException {
        // ユーザリスト取得する
        List userList = userListDao.userList();
        
        // ユーザリストをUserListOutServiceBeanに設定
        List<UserListOutServiceBean> newList = new ArrayList<UserListOutServiceBean>();
        
        for(int i = 0; i < userList.size(); i++)
        {
            UserListOutServiceBean outServiceBean = new UserListOutServiceBean();
            UserDomain user = (UserDomain)userList.get(i);
            BeanUtils.copyProperties(outServiceBean, user);
            
            newList.add(outServiceBean);
            
        }
        return newList;
    }
}

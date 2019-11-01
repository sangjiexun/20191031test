/*
 * $Id: GroupNameServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.user.dao.GroupNameDao;
import net.chintai.backend.sysadmin.user.dao.GroupNameParamBean;
import net.chintai.backend.sysadmin.user.domain.UserDomain;
import net.chintai.backend.sysadmin.user.service.GroupNameService;
import net.chintai.backend.sysadmin.user.service.bean.GroupNameInServiceBean;

/**
 * UserUpdateConfirmServiceの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupNameServiceImpl implements GroupNameService {

    /** ユーザ更新確認のDAO */
    private GroupNameDao groupNameDao = null;

    /**
     * groupNameDaoを設定する
     * @param groupNameDao
     */
    public void setGroupNameDao(GroupNameDao groupNameDao) {
        this.groupNameDao = groupNameDao;
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.UserUpdateConfirmService#getGroupName(net.chintai.backend.sysadmin.user.service.bean.UserUpdateConfirmInServiceBean)
     */
    public String getGroupName(GroupNameInServiceBean inServiceBean)
        throws ApplicationException {

        // グループIDをParamBeanに設定
        GroupNameParamBean paramBean = new GroupNameParamBean();
        try{
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        
        // グループ名を取得
        UserDomain user = groupNameDao.getGroupName(paramBean);
        
        return user.getGroupName();
    }
}
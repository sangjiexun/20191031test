/*
 * $Id: GroupDeleteConfirmServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.dao.GroupDeleteConfirmDao;
import net.chintai.backend.sysadmin.user.dao.GroupDeleteConfirmParamBean;
import net.chintai.backend.sysadmin.user.domain.Group;
import net.chintai.backend.sysadmin.user.service.GroupDeleteConfirmService;
import net.chintai.backend.sysadmin.user.service.bean.GroupDeleteConfirmInServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.GroupDeleteConfirmOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;


/**
 * GroupDeleteConfirmService の実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupDeleteConfirmServiceImpl implements GroupDeleteConfirmService {
    
    /** グループの権限削除完了DAO */
    private GroupDeleteConfirmDao groupDeleteConfirmDao = null;

    /**
     * groupDeleteConfirmDaoを設定する
     * @param groupDeleteConfirmDao
     */
    public void setGroupDeleteConfirmDao(GroupDeleteConfirmDao groupDeleteConfirmDao) {
        this.groupDeleteConfirmDao = groupDeleteConfirmDao;
    }
    
    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.GroupDeleteConfirmService#getGroupListByGroupId(net.chintai.backend.sysadmin.user.service.bean.GroupDeleteConfirmInServiceBean)
     */
    public List getGroupListByGroupId(
            GroupDeleteConfirmInServiceBean inServiceBean) throws ApplicationException {
        
        GroupDeleteConfirmParamBean paramBean = new GroupDeleteConfirmParamBean();
        try{
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        
        List rsList = groupDeleteConfirmDao.selectGroupListByGroupId(paramBean);
        List<GroupDeleteConfirmOutServiceBean> groupList = new ArrayList<GroupDeleteConfirmOutServiceBean>();

        for (int i = 0; i < rsList.size(); i++) {
            Group group = (Group) rsList.get(i);

            GroupDeleteConfirmOutServiceBean groupBean = new GroupDeleteConfirmOutServiceBean();
            try{
                BeanUtils.copyProperties(groupBean, group);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            
            groupList.add(groupBean);
        }
        return groupList;
    }

}

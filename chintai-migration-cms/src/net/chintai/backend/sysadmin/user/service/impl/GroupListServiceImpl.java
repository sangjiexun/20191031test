/*
 * $Id: GroupListServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/18  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.dao.GroupListDao;
import net.chintai.backend.sysadmin.user.domain.Authority;
import net.chintai.backend.sysadmin.user.domain.Group;
import net.chintai.backend.sysadmin.user.service.GroupListService;
import net.chintai.backend.sysadmin.user.service.bean.AuthorityListOutServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.GroupListOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * GroupListService の実装クラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupListServiceImpl implements GroupListService {

    /** GroupList取得用 DAO */
    private GroupListDao selectGroupListDao = null;

    /**
     * selectForGroupDaoを設定する
     * @param selectGroupListDao
     */
    public void setSelectGroupListDao(GroupListDao selectGroupListDao) {
        this.selectGroupListDao = selectGroupListDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.GroupListService#getGroupList()
     */
    public List getGroupList() throws ApplicationException {
        List rsList = selectGroupListDao.getGroupList();
        List<GroupListOutServiceBean> groupList = new ArrayList<GroupListOutServiceBean>();

        for (int i = 0; i < rsList.size(); i++) {
            Group group = (Group) rsList.get(i);

            GroupListOutServiceBean groupBean = new GroupListOutServiceBean();
            try {
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

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.GroupListService#getAuthorityList()
     */
    public List getAuthorityList() throws ApplicationException {
        List rsList = selectGroupListDao.getAuthorityList();
        List<AuthorityListOutServiceBean> authorityList = new ArrayList<AuthorityListOutServiceBean>();

        for (int i = 0; i < rsList.size(); i++) {
            Authority authority = (Authority) rsList.get(i);

            AuthorityListOutServiceBean authorityBean = new AuthorityListOutServiceBean();
            try {
                BeanUtils.copyProperties(authorityBean, authority);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            authorityList.add(authorityBean);
        }
        return authorityList;
    }

}

/*
 * $Id: GroupUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/19  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.dao.GroupUpdatePageDao;
import net.chintai.backend.sysadmin.user.dao.GroupUpdatePageParamBean;
import net.chintai.backend.sysadmin.user.domain.GroupAuthority;
import net.chintai.backend.sysadmin.user.service.GroupUpdatePageService;
import net.chintai.backend.sysadmin.user.service.bean.GroupUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.GroupUpdatePageOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * GroupUpdatePageServiceの実装クラス
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupUpdatePageServiceImpl implements GroupUpdatePageService {

    private GroupUpdatePageDao selectGroupUpdatePageDao = null;

    public void setSelectGroupUpdatePageDao(GroupUpdatePageDao selectGroupUpdatePageDao) {
        this.selectGroupUpdatePageDao = selectGroupUpdatePageDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.GroupUpdatePageService#getGroupDetail(net.chintai.backend.sysadmin.user.service.bean.GroupUpdatePageInServiceBean)
     */
    public List getGroupDetail(GroupUpdatePageInServiceBean inServiceBean) throws Exception {

        GroupUpdatePageParamBean paramBean = new GroupUpdatePageParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);
        List rsList = selectGroupUpdatePageDao.selectUpdateGroup(paramBean);
        List<GroupUpdatePageOutServiceBean> groupList = new ArrayList<GroupUpdatePageOutServiceBean>();

        if (rsList == null) {
            throw new ApplicationException("ERROR.M.USER.0005");
        }

        for (int i = 0; i < rsList.size(); i++) {
            GroupUpdatePageOutServiceBean groupBean = new GroupUpdatePageOutServiceBean();
            GroupAuthority group = (GroupAuthority) rsList.get(i);

            BeanUtils.copyProperties(groupBean, group);
            groupList.add(groupBean);
        }
        return groupList;

    }

}

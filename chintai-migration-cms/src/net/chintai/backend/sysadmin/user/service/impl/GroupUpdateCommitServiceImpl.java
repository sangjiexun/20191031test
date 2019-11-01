/*
 * $Id: GroupUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.dao.GroupUpdateCommitDao;
import net.chintai.backend.sysadmin.user.dao.GroupUpdateCommitParamBean;
import net.chintai.backend.sysadmin.user.domain.Authority;
import net.chintai.backend.sysadmin.user.service.GroupUpdateCommitService;
import net.chintai.backend.sysadmin.user.service.bean.GroupUpdateCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * GroupUpdateCommitServiceの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupUpdateCommitServiceImpl implements GroupUpdateCommitService {

    /** グループの権限削除完了DAO */
    private GroupUpdateCommitDao groupUpdateCommitDao;

    /**
     * GroupUpdateCommitDaoを設定する
     * @param groupUpdateCommitDao
     */
    public void setGroupUpdateCommitDao(GroupUpdateCommitDao groupUpdateCommitDao) {
        this.groupUpdateCommitDao = groupUpdateCommitDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.GroupUpdateCommitService#updateGroup(net.chintai.backend.sysadmin.user.dao.GroupUpdateCommitParamBean)
     */
    public void updateGroup(GroupUpdateCommitInServiceBean inServiceBean) throws ApplicationException {

        GroupUpdateCommitParamBean paramBean = new GroupUpdateCommitParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 更新可能かどうかをチェック
        if (groupUpdateCommitDao.selectUpdatable(paramBean) == 0) {
            throw new ApplicationException("ERROR.M.USER.0004");
        }

        // グループ名を更新
        groupUpdateCommitDao.updateGroupName(paramBean);

        // 権限を更新
        // 全削除 → 必要な権限を Insert

        // 1. 全削除
        groupUpdateCommitDao.deleteGroupAuthority(paramBean);

        // 2. 必要な権限を Insert
        for (int i = 0; i < paramBean.getAuthorityId().length; i++) {
            Authority authority = new Authority();
            authority.setGroupId(paramBean.getGroupId());
            authority.setAuthorityId(paramBean.getAuthorityId()[i]);
            authority.setInsID(paramBean.getUpdId());
            authority.setUpdID(paramBean.getUpdId());
            authority.setPgName(paramBean.getPgName());
            groupUpdateCommitDao.insertGroupByAuthority(authority);
        }
    }
}

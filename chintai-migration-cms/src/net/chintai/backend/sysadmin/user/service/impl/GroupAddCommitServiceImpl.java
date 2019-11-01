/*
 * $Id: GroupAddCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import net.chintai.backend.sysadmin.user.dao.GroupAddCommitDao;
import net.chintai.backend.sysadmin.user.domain.Authority;
import net.chintai.backend.sysadmin.user.domain.Group;
import net.chintai.backend.sysadmin.user.service.GroupAddCommitService;
import net.chintai.backend.sysadmin.user.service.bean.GroupAddCommitInServiceBean;

/**
 * GroupAddCommitServiceの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupAddCommitServiceImpl implements GroupAddCommitService {

    /** グループ追加完了DAO */
    private GroupAddCommitDao groupAddCommitDao = null;

    /**
     * GroupUpdateCommitDaoを設定する
     * @param groupAddCommitDao
     */
    public void setGroupAddCommitDao(GroupAddCommitDao groupAddCommitDao) {
        this.groupAddCommitDao = groupAddCommitDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.GroupAddCommitService#insertGroup(net.chintai.backend.sysadmin.user.service.bean.GroupAddCommitInServiceBean)
     */
    public void insertGroup(GroupAddCommitInServiceBean inServiceBean) throws Exception {

        int groupId = groupAddCommitDao.selectSeqGroupID();

        Group group = new Group();
        group.setGroupId(groupId);
        group.setGroupName(inServiceBean.getGroupName());
        group.setInsID(inServiceBean.getOperUserId());
        group.setUpdID(inServiceBean.getOperUserId());
        group.setPgName(inServiceBean.getPgName());
        groupAddCommitDao.insertGroup(group);

        String operUserId = inServiceBean.getOperUserId();

        for (int i = 0; i < inServiceBean.getAuthorityId().length; i++) {

            Authority authority = new Authority();
            authority.setGroupId(groupId);
            authority.setAuthorityId(inServiceBean.getAuthorityId()[i]);
            authority.setInsID(operUserId);
            authority.setUpdID(operUserId);
            authority.setPgName(inServiceBean.getPgName());
            groupAddCommitDao.insertGroupByAuthority(authority);
        }

    }

}

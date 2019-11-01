/*
 * $Id: GroupDeleteCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.dao.GroupDeleteCommitDao;
import net.chintai.backend.sysadmin.user.dao.GroupDeleteCommitParamBean;
import net.chintai.backend.sysadmin.user.service.GroupDeleteCommitService;
import net.chintai.backend.sysadmin.user.service.bean.GroupDeleteCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;


/**
 * GroupDeleteCommitServiceの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupDeleteCommitServiceImpl implements GroupDeleteCommitService {

    /** グループの権限削除完了DAO */
    private GroupDeleteCommitDao groupDeleteCommitDao = null;

    /**
     * groupDeleteCommitDaoを設定する
     * @param groupDeleteCommitDao
     */
    public void setGroupDeleteCommitDao(GroupDeleteCommitDao groupDeleteCommitDao) {
        this.groupDeleteCommitDao = groupDeleteCommitDao;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.GroupDeleteCommitService#deleteGroupByGroupId(net.chintai.backend.sysadmin.user.service.bean.GroupDeleteCommitInServiceBean)
     */
    public void deleteGroupByGroupId(
            GroupDeleteCommitInServiceBean inServiceBean)
            throws ApplicationException {

        GroupDeleteCommitParamBean paramBean = new GroupDeleteCommitParamBean();
        try{
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        String[] groupId = inServiceBean.getGroupId();
        String[] updDt = inServiceBean.getUpdDt();

        for(int i=0; i < groupId.length; i++) {
            paramBean.setGroupId(groupId[i]);
            paramBean.setUpdDt(updDt[i]);
            // 削除処理結果をチェックする
            if(groupDeleteCommitDao.deleteGroupByGroupId(paramBean) == 0) {
                throw new ApplicationException("ERROR.M.USER.0005");    
            }
        }
    }
}
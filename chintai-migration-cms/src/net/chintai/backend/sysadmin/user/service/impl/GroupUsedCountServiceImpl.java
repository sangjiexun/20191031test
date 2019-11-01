/*
 * $Id: GroupUsedCountServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/12  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import net.chintai.backend.sysadmin.user.dao.GroupDeleteConfirmDao;
import net.chintai.backend.sysadmin.user.dao.GroupDeleteConfirmParamBean;
import net.chintai.backend.sysadmin.user.service.GroupUsedCountService;
import net.chintai.backend.sysadmin.user.service.bean.GroupDeleteConfirmInServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * GroupUsedCountServiceの実装クラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupUsedCountServiceImpl implements GroupUsedCountService {

    /** グループの権限削除完了DAO */
    private GroupDeleteConfirmDao groupDeleteConfirmDao = null;

    /**
     * groupDeleteConfirmDaoを設定する
     * @param groupDeleteConfirmDao
     */
    public void setGroupDeleteConfirmDao(GroupDeleteConfirmDao groupDeleteConfirmDao) {
        this.groupDeleteConfirmDao = groupDeleteConfirmDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.GroupUsedCountService#selectUsedGroupCount(net.chintai.backend.sysadmin.user.service.bean.GroupDeleteConfirmInServiceBean)
     */
    public int selectUsedGroupCount(GroupDeleteConfirmInServiceBean inServiceBean) throws Exception {

        // 削除するグループIDリストを取得する。
        GroupDeleteConfirmParamBean paramBean = new GroupDeleteConfirmParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // 削除するグループIDリスト中で使っているグループをカウント。
        int usedGroupCount = groupDeleteConfirmDao.selectUsedGroupCount(paramBean);

        return usedGroupCount;
    }

}

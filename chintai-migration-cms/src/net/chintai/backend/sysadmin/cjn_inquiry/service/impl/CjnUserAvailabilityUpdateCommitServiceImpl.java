/*
 * $Id: CjnUserAvailabilityUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserAvailabilityUpdateCommitDao;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfoUsers;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserAvailabilityUpdateCommitService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAvailabilityUpdateCommitInServiceBean;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;

/**
 * CjnUserAvailabilityUpdateCommitService の実装クラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAvailabilityUpdateCommitServiceImpl
        implements CjnUserAvailabilityUpdateCommitService {

    /** 閲覧可能ユーザ更新DAO */
    CjnUserAvailabilityUpdateCommitDao updateCommitDao;

    /**
     * 閲覧可能ユーザ更新DAO
     * @param dao
     */
    public void setCjnUserAvailabilityUpdateCommitDao(CjnUserAvailabilityUpdateCommitDao dao) {
        updateCommitDao = dao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserAvailabilityUpdateCommitService#updateTypeInfoUsers(net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAvailabilityUpdateCommitInServiceBean)
     */
    public void updateTypeInfoUsers(CjnUserAvailabilityUpdateCommitInServiceBean bean) throws ApplicationException {

        // 更新用データ作成
        List<CjnInquiryTypeInfoUsers> usersList = new ArrayList<CjnInquiryTypeInfoUsers>();
        for (int i = 0; i < bean.getReadableUsersSeqList().size(); i++) {
            CjnInquiryTypeInfoUsers users = new CjnInquiryTypeInfoUsers();
            users.setCjnInqKindSeq(bean.getCjnInqKindSeq());
            users.setCjnAccountSeq(bean.getReadableUsersSeqList().get(i));
            users.setOperUserId(bean.getOperUserId());
            users.setPgName(bean.getPgName());
            usersList.add(users);
        }

        // 更新実行
        // 更新競合時の throw Exception は下位クラスに委譲
        updateCommitDao.updateUsersAvailability(usersList, bean.getCjnInqKindSeq(), bean.getLastUpdateTime());
    }
}

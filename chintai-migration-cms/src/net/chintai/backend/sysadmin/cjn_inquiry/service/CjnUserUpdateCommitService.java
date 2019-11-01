/*
 * $Id: CjnUserUpdateCommitService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserUpdateCommitInServiceBean;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;

/**
 * 問い合せユーザ更新Service
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnUserUpdateCommitService {

    /**
     * 問い合せユーザ情報を更新します。
     * @param inServiceBean
     * @throws ApplicationException 
     */
    public void cjnUserUpdateCommit(CjnUserUpdateCommitInServiceBean inServiceBean)
            throws ApplicationException;

}

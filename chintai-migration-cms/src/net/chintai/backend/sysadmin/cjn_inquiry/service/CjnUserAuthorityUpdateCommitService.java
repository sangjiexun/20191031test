/*
 * $Id: CjnUserAuthorityUpdateCommitService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAuthorityUpdateCommitInServiceBean;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;

/**
 * 閲覧可能問い合せ権限更新コミットService
 * 
 * @author KOJIMA Takanori
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnUserAuthorityUpdateCommitService {

    /**
     * 閲覧可能問い合せ権限を更新します。
     * @param inServiceBean
     * @throws ApplicationException 
     */
    public void updateUserAuthority(CjnUserAuthorityUpdateCommitInServiceBean inServiceBean)
            throws ApplicationException;

}

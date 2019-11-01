/*
 * $Id: AspGroupDeleteCommitService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/25  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupDeleteCommitInServiceBean;

/**
 * 不動産ASPグループから外すコミットService
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspGroupDeleteCommitService {

    /**
     * グループから外す
     * @param inBean
     * @throws ApplicationException
     */
    public void aspGroupDelete(AspGroupDeleteCommitInServiceBean inBean)
            throws ApplicationException;
}

/*
 * $Id: WebLogUpdateCommitService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.WebLogUpdateCommitInServiceBean;

/**
 * Webログ利用可否完了サービスクラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface WebLogUpdateCommitService {

    /**
     * Webログ利用可否完了
     * @param inServiceBean
     * @throws ApplicationException
     */
    public void webLogUpdateCommit(WebLogUpdateCommitInServiceBean inServiceBean)
        throws ApplicationException;
}
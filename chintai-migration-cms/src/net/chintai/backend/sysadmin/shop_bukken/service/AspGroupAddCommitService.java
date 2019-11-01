/*
 * $Id: AspGroupAddCommitService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/24  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupAddCommitInServiceBean;

/**
 * 不動産ASPグループ登録Service
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspGroupAddCommitService {

    /**
     * グループ登録する。
     * @param inServiceBean
     */
    public void aspGroupCommit(AspGroupAddCommitInServiceBean inServiceBean) throws Exception;

}

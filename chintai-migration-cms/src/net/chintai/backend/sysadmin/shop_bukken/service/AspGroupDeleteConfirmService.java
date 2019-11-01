/*
 * $Id: AspGroupDeleteConfirmService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoOutServiceBean;

/**
 * 不動産ASPグループ情報削除確認Service
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspGroupDeleteConfirmService {

    /**
     * グループ情報取得
     * @param inServiceBean
     * @return グループ情報
     * @throws ApplicationException
     */
    public AspGroupInfoOutServiceBean selectGroupInfo(AspGroupInfoInServiceBean inServiceBean)
            throws ApplicationException;

}

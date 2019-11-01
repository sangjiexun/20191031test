/*
 * $Id: AspGroupUpdatePageService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/25  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoOutServiceBean;

/**
 * 不動産ASPグループ情報更新ページService
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspGroupUpdatePageService {

    /**
     * 不動産ASPグループ情報を照会する
     * @param inServiceBean
     * @return 不動産ASP情報
     */
    public AspGroupInfoOutServiceBean aspGroupUpdatePage(AspGroupInfoInServiceBean inServiceBean);
}

/*
 * $Id: WebLogUpdatePageDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import net.chintai.backend.sysadmin.shop_bukken.domain.ShopDetailInfo;

/**
 * Webログ利用可否画面に遷移Dao
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface WebLogUpdatePageDao {

    /**
     * Webログ利用可否画面に遷移
     * @param paramBean
     * @return ShopDetailInfo
     */
    public ShopDetailInfo webLogUpdatePage(WebLogUpdatePageParamBean paramBean);
}
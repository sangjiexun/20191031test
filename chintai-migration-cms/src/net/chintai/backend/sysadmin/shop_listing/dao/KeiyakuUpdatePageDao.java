/*
 * $Id: KeiyakuUpdatePageDao.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/25     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

import net.chintai.backend.sysadmin.shop_listing.domain.KihonKeiyakuInfoDomin;

/**
 * 契約情報更新画面の初期表示値を取得します。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface KeiyakuUpdatePageDao {

    /**
     * 契約情報を取得します。
     * @param paramBean
     * @return
     */
    public KihonKeiyakuInfoDomin selectKeiyakuInfo(KeiyakuUpdatePageParamBean paramBean);

}

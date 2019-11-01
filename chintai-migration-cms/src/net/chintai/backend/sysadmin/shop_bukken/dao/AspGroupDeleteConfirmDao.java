/*
 * $Id: AspGroupDeleteConfirmDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import net.chintai.backend.sysadmin.shop_bukken.domain.AspGroupInfo;

/**
 * 不動産ASPグループから外す確認Dao
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspGroupDeleteConfirmDao {

    /**
     * 削除グループ店舗情報取得
     * @param paramBean 検索パラメータ(店舗コード、グループ店舗コード)
     * @return グループ店舗情報
     */
    public AspGroupInfo selectGroup(AspGroupSearchParamBean paramBean);

}

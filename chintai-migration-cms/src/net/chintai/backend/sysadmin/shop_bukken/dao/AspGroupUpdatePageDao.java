/*
 * $Id: AspGroupUpdatePageDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/25  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import net.chintai.backend.sysadmin.shop_bukken.domain.AspGroupInfo;

/**
 * 不動産ASPグループ情報更新ページDAO
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspGroupUpdatePageDao {

    /**
     * 不動産ASPグループ情報を取得します。
     * @param paramBean 検索パラメータ(店舗コード、グループ店舗コード)
     * @return 不動産ASPグループ情報
     */
    public AspGroupInfo selectGroupUpdatePage(AspGroupSearchParamBean paramBean);

}

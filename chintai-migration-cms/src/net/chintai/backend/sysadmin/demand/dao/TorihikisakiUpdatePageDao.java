/*
 * $Id: TorihikisakiUpdatePageDao.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/05  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import net.chintai.backend.sysadmin.demand.domain.TorihikisakiUpdatePageDomain;

/**
 * 取引先情報取得DAO(更新用)
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiUpdatePageDao {

    /**
     * 取引先情報を取得します。
     * @param paramBean 検索パラメータ（不動産会社コード、取引先コード）
     * @return 取引先詳細情報
     */
    public TorihikisakiUpdatePageDomain getTorihikisakiInfo(
            TorihikisakiUpdatePageParamBean paramBean);
}

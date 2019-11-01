/*
 * $Id: PrefNameSearchDao.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/26  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import net.chintai.backend.sysadmin.demand.domain.PrefNameSearchDomain;

/**
 * 都道府県名称取得DAO
 *
 * @author lee-hosup
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface PrefNameSearchDao {

    /**
     * 都道府県名を取得します。
     * @param paramBean 検索パラメータ（都道府県コード）
     * @return 都道府県名
     */
    public PrefNameSearchDomain getPrefName(PrefNameSearchParamBean paramBean);

}

/*
 * $Id: ShisyaNameSearchDao.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/03  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import net.chintai.backend.sysadmin.demand.domain.ShisyaNameSearchDomain;


/**
 * 支社名称取得DAO
 *
 * @author lee-hosup
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShisyaNameSearchDao {

    /**
     * 取引先担当支社名称を取得します。
     * @param paramBean 検索パラメータ（支社コード）
     * @return 支社名称
     */
    public ShisyaNameSearchDomain getShisyaName(ShisyaNameSearchParamBean paramBean);
}

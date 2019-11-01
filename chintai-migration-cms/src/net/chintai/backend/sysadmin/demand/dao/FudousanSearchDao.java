/*
 * $Id: FudousanSearchDao.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/21  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.domain.FudousanSearchDomain;

/**
 * 不動産会社一覧情報検索DAO
 *
 * @author lee-hosup
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface FudousanSearchDao {

    /**
     * 不動産会社一覧情報を取得します。
     * @param paramBean 検索パラメータ。
     * @return List<FudousanSearchDomain> 不動産会社一覧情報リスト。
     */
    public List<FudousanSearchDomain> getFudousanList(FudousanSearchParamBean paramBean,
            BasePagerCondition condition);

    /**
     * 不動産会社一覧総件数を取得します。
     * @param paramBean 検索パラメータ。
     * @return int 不動産会社一覧の総件数。
     */
    public int selectTotalCount(FudousanSearchParamBean paramBean);
}

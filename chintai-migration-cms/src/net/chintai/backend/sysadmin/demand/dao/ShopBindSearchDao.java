/*
 * $Id: ShopBindSearchDao.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.domain.ShopBindSearchDomain;


/**
 * 店舗コード紐付検索DAO
 *
 * @author lee-hosup
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopBindSearchDao {

    /**
     * 総件数を取得します
     * @param paramBean 検索パラメータ
     * @return 総件数
     */
    public int selectTotalCount(ShopBindSearchParamBean paramBean);

    /**
     * 店舗コード紐付一覧を取得します。
     * @param paramBean 検索パラメータ
     * @return 店舗コード紐付一覧リスト
     */
    public List<ShopBindSearchDomain> selectAlertBukken(
            ShopBindSearchParamBean paramBean, BasePagerCondition condition);

}

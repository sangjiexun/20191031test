/*
 * $Id: ReviewShopSearchDao.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.review.domain.ReviewShopSearchDomain;

/**
 * 店舗検索DAO。
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewShopSearchDao {

    /**
     * 現在有効な物件サマリテーブル名を取得。
     * @return 現在有効な物件サマリテーブル名
     */
    public String selectVaildTable();

    /**
     * 総件数を取得。
     * @param paramBean 検索パラメータ
     * @return 総件数
     */
    public int selectTotalCnt(ReviewShopSearchParamBean paramBean);

    /**
     * 店舗検索を行う。
     * @param paramBean 検索パラメータ
     * @return 検索結果リスト
     */
    public List<ReviewShopSearchDomain> selectShopSearch(ReviewShopSearchParamBean paramBean,
            BasePagerCondition condition);

}

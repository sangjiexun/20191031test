/*
 * $Id: ReviewShopMediaCountDao.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.review.domain.ReviewShopMediaCountDomain;

/**
 * 店舗別出稿状況集計Dao。
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewShopMediaCountDao {

    /**
     * 総件数を取得。
     * @param paramBean 検索パラメータ
     * @return 総件数
     */
    public int selectTotalCnt(ReviewShopMediaCountParamBean paramBean);

    /**
     * 店舗別出稿状況集計情報を取得。
     * @param paramBean 検索パラメータ
     * @return 店舗別出稿状況集計情報
     */
    public List<ReviewShopMediaCountDomain> selectShopMediaCnt(
            ReviewShopMediaCountParamBean paramBean, BasePagerCondition condition);

    /**
     * 最終集計時間を取得します。
     * @return 最終集計時間
     */
    public ReviewShopMediaCountDomain selectCntTime();
}

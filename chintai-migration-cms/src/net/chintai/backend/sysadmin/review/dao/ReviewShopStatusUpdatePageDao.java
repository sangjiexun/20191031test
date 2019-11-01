/*
 * $Id: ReviewShopStatusUpdatePageDao.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

import net.chintai.backend.sysadmin.review.domain.ReviewShopStatusUpdateDomain;

/**
 * 店舗情報、店舗対象外設定取得DAO
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewShopStatusUpdatePageDao {

    /**
     * 現在有効な物件サマリテーブル名を取得。
     * @return 現在有効な物件サマリテーブル名
     */
    public String selectVaildTable();

    /**
     * 店舗情報、店舗対象外設定を取得します。
     * @param paramBean 検索パラメータ(店舗コード)
     * @return 検索結果
     */
    public ReviewShopStatusUpdateDomain
            selectShopStatusInfo(ReviewShopStatusUpdatePageParamBean paramBean);
}

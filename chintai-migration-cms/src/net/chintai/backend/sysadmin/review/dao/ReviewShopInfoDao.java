/*
 * $Id: ReviewShopInfoDao.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/12  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

import net.chintai.backend.sysadmin.review.domain.ReviewShopInfoDomain;

/**
 * 該当店舗のWeb審査関連情報
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewShopInfoDao {

    /**
     * 店舗詳細情報を検索
     * @param paramBean 検索パラメータ
     * @return 店舗詳細情報
     */
    public ReviewShopInfoDomain getShopInfo(ReviewShopInfoParamBean paramBean);

    /**
     * 現在有効な物件サマリテーブル名を取得。
     * @return 現在有効な物件サマリテーブル名
     */
    public String selectVaildTable();
}

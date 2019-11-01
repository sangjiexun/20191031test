/*
 * $Id: ReviewConfigCityDao.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

import java.util.List;

import net.chintai.backend.sysadmin.review.domain.ReviewConfigCityDomain;

/**
 * 市区町村別比較対象設定内容情報を取得するDAO。
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewConfigCityDao {

    /**
     * 都道府県名称を取得します。
     * @param paramBean 検索パラメータ（都道府県コード）
     * @return 都道府県名称
     */
    public ReviewConfigCityDomain selectPrefName(
            ReviewConfigCityParamBean paramBean);

    /**
     * 市区町村別比較対象設定内容情報を取得します。
     * @param paramBean 検索パラメータ（都道府県コード）
     * @return 審査内容情報リスト
     */
    public List<ReviewConfigCityDomain> selectCityConfig(
            ReviewConfigCityParamBean paramBean);
}

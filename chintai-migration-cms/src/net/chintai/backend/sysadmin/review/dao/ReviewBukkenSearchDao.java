/*
 * $Id: ReviewBukkenSearchDao.java 3910 2008-05-27 06:56:09Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)李昊燮   新規作成
 * 2008/05/27  BGT)李昊燮   メッソドselectVaildTable追加
 */
package net.chintai.backend.sysadmin.review.dao;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.review.domain.ReviewBukkenSearchDomain;

/**
 * 物件検索DAO。
 *
 * @author lee-hosup
 * @version $Revision: 3910 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewBukkenSearchDao {

    /**
     * 現在有効な物件サマリテーブル名を取得。
     * @return 現在有効な物件サマリテーブル名
     */
    public String selectVaildTable();

    /**
     * 物件検索結果一覧を取得します。
     * @param paramBean 検索パラメータ
     * @param condition ページング情報
     * @return 物件検索結果一覧リスト
     */
    public List<ReviewBukkenSearchDomain> selectBukkenSearch(ReviewBukkenSearchParamBean paramBean,
            BasePagerCondition condition);

    /**
     * 総件数を取得。
     * @param paramBean 検索パラメータ
     * @return 総件数
     */
    public int selectBukkenTotalCnt(ReviewBukkenSearchParamBean paramBean);

    /**
     * 自動削除期間を取得。
     * @param paramBean 検索パラメータ（審査コード）
     * @return 初期審査自動削除期間
     */
    public int seleclAutoDelInfo(ReviewAutoDelInfoParamBean paramBean);

}

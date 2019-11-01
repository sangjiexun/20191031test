/*
 * $Id: ReviewBukkenAlertCountDao.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.review.domain.ReviewBukkenAlertCountDomain;

/**
 * 警告対象物件一覧検索DAO
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewBukkenAlertCountDao {

    /**
     * 総件数を取得します
     * @param paramBean 検索パラメータ
     * @return 総件数
     */
    public int selectTotalCount(ReviewBukkenAlertCountParamBean paramBean);

    /**
     * 警告対象物件一覧を取得します(画面出力用)。
     * @param paramBean 検索パラメータ
     * @param condition ページング情報
     * @return 警告対象物件一覧リスト
     */
    public List<ReviewBukkenAlertCountDomain> selectAlertBukken(
            ReviewBukkenAlertCountParamBean paramBean, BasePagerCondition condition);

    /**
     * 警告対象物件一覧を取得します(CSV出力用)。
     * @param paramBean 検索パラメータ
     * @return 警告対象物件一覧リスト
     */
    public List<ReviewBukkenAlertCountDomain> selectAlertBukken(
            ReviewBukkenAlertCountParamBean paramBean);

}

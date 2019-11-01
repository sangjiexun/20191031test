/*
 * $Id: ReviewBukkenInfoDao.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

import java.util.List;

import net.chintai.backend.sysadmin.review.domain.ReviewBukkenInfoDomain;

/**
 * Web審査物件詳細を取得するDAO。
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewBukkenInfoDao {

    /**
     * Web審査状況情報を取得。
     * @param paramBean 検索
     * @return Web審査状況
     */
    public ReviewBukkenInfoDomain getReviewStatus(ReviewBukkenInfoParamBean paramBean);

    /**
     * Web審査履歴情報を取得。
     * @param paramBean 検索パラメータ
     * @return Web審査履歴
     */
    public List<ReviewBukkenInfoDomain> getReviewHistory(ReviewBukkenInfoParamBean paramBean);

    /**
     * 自動削除期間を取得。
     * @param delInfoParam 検索パラメータ（審査コード）
     * @return 初期審査自動削除期間
     */
    public int seleclAutoDelInfo(ReviewAutoDelInfoParamBean delInfoParam);

}

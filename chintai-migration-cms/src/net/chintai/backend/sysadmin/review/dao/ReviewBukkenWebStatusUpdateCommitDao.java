/*
 * $Id: ReviewBukkenWebStatusUpdateCommitDao.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/19  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

import net.chintai.backend.sysadmin.review.domain.ReviewBukkenWebStatusDomain;

/**
 * CHINTAI.NET掲載状況更新DAO。
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewBukkenWebStatusUpdateCommitDao {

    /**
     * 掲載状況を更新します。
     * @param paramBean 更新パラメータ
     * @return 更新件数
     */
    public int updateBukkenWebStatus(ReviewBukkenWebStatusUpdateCommitParamBean paramBean);

    /**
     * 掲載状態の更新前チェック情報を取得します。
     * @param paramBean チェックパラメータ
     * @return 更新チェック情報
     */
    public ReviewBukkenWebStatusDomain selectBukkenWebStatusCheck(ReviewBukkenWebStatusUpdateCommitParamBean paramBean);
}

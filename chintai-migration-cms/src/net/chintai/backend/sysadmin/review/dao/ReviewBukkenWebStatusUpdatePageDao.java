/*
 * $Id: ReviewBukkenWebStatusUpdatePageDao.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/19  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

import net.chintai.backend.sysadmin.review.domain.ReviewBukkenWebStatusUpdateDomain;

/**
 * CHINTAI.NET掲載状況情報取得DAO
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewBukkenWebStatusUpdatePageDao {

    /**
     * CHINTAI.NET掲載状況情報を取得する。
     * @param paramBean 検索パラメータ
     * @return CHINTAI.NET掲載状況情報
     */
    public ReviewBukkenWebStatusUpdateDomain getBukkenWebStatusInfo(
            ReviewBukkenWebStatusUpdatePageParamBean paramBean);

    /**
     * 自動削除期間を取得。
     * @param delInfoParam 検索パラメータ（審査コード）
     * @return 初期審査自動削除期間
     */
    public int seleclAutoDelInfo(ReviewAutoDelInfoParamBean delInfoParam);
}

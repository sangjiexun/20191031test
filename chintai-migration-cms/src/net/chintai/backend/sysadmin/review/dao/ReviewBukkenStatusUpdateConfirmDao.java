/*
 * $Id: ReviewBukkenStatusUpdateConfirmDao.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/18  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

import net.chintai.backend.sysadmin.review.domain.ReviewBukkenStatusUpdateDomain;

/**
 * 物件審査情報取得DAO。
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewBukkenStatusUpdateConfirmDao {

    /**
     * 物件審査情報を取得
     * @param paramBean 検索パラメータ
     * @return 物件審査情報
     */
    public ReviewBukkenStatusUpdateDomain getBukkenInfo(
            ReviewBukkenStatusUpdateConfirmParamBean paramBean);

    /**
     * 自動削除期間を取得。
     * @param paramBean 検索パラメータ（審査コード）
     * @return 初期審査自動削除期間
     */
    public int seleclAutoDelInfo(ReviewAutoDelInfoParamBean paramBean);
}

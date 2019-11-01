/*
 * $Id: ReviewBukkenStatusUpdatePageDao.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/17  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

import net.chintai.backend.sysadmin.review.domain.ReviewBukkenStatusUpdateDomain;

/**
 * 物件対象外設定用 物件情報取得DAO
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewBukkenStatusUpdatePageDao {

    /**
     * 物件情報を取得する。
     * @param paramBean 検索パラメータ
     * @return 物件情報
     */
    public ReviewBukkenStatusUpdateDomain getBukkenStatusInfo(
            ReviewBukkenStatusUpdatePageParamBean paramBean);

    /**
     * 自動削除期間を取得。
     * @param delInfoParam 検索パラメータ（審査コード）
     * @return 初期審査自動削除期間
     */
    public int seleclAutoDelInfo(ReviewAutoDelInfoParamBean delInfoParam);
}

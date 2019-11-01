/*
 * $Id: ReviewShopStatusUpdateCommitDao.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/17  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

/**
 * 店舗対象外設定更新DAO
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewShopStatusUpdateCommitDao {

    /**
     * 店舗対象外設定を更新します。
     * @param paramBean 更新パラメータ
     * @return 更新件数
     */
    public int updateShopStatus(ReviewShopStatusUpdateCommitParamBean paramBean);
}

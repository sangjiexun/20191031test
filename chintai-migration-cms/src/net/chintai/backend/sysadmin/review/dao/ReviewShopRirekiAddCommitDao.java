/*
 * $Id: ReviewBukkennStatusUpdateCommitDao.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/18  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

/**
 * 店舗履歴登録DAO
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewShopRirekiAddCommitDao {

    /**
     * 店舗履歴テーブルを登録します。
     * @param paramBean 更新パラメータ
     * @return 更新件数
     */
    public void shopRirekiAdd(ReviewShopRirekiAddParamBean paramBean);

    /**
     * 店舗履歴PKを取得します。
     * @return 物件履歴PK
     */
    public Long selectPkShopRireki();


}

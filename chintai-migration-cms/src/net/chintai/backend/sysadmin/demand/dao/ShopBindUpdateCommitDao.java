/*
 * $Id: ShopBindUpdateCommitDao.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/16  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

/**
 * 店舗紐付先情報更新DAO<BR>
 * 全3件の更新処理は同一トランザクションである
 * @author lee-hosup
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopBindUpdateCommitDao {


    /**
     * 店舗紐付先情報を更新します
     * @param paramBean 更新パラメータ
     */
    public void updateShopBindInfo(ShopBindUpdateCommitParamBean paramBean);

    /**
     * 元の紐付先情報を初期化します<BR>
     * @param paramBean 更新パラメータ
     * @return 更新件数
     */
    public int updateShopBindInfo2(ShopBindUpdateCommitParamBean paramBean);

    /**
     * 店舗管理テーブルの最終更新日を更新します
     * @param paramBean 更新パラメータ
     */
    public void updateLastUpdateTime(ShopBindUpdateCommitParamBean paramBean);
}

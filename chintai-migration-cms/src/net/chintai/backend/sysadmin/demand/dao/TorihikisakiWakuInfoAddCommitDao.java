/*
 * $Id: TorihikisakiWakuInfoAddCommitDao.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/09  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;


/**
 * 取引先物件枠設定情報更新DAO
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiWakuInfoAddCommitDao {

    /**
     * 物件枠設定情報を登録します。
     * @param paramBean 登録パラメータ
     */
    public void insertTorihikisakiWakuInfo(TorihikisakiWakuInfoAddCommitParamBean paramBean);

    /**
     * 取引先テーブルの最終更新日時を更新します。
     * @param paramBean 更新パラメータ
     * @return 更新件数
     */
    public int updateTorihikisakiUpdDt(TorihikisakiWakuInfoAddCommitParamBean paramBean);
}

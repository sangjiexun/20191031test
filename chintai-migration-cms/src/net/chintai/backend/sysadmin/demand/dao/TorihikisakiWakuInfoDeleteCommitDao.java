/*
 * $Id: TorihikisakiWakuInfoDeleteCommitDao.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

/**
 * 取引先物件枠設定情報削除DAO
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiWakuInfoDeleteCommitDao {

    /**
     * 物件枠設定情報を削除します。
     * @param paramBean 検索パラメータ（取引先シーケンス番号、適用月、最終更新日時）
     * @return 削除処理した件数
     */
    public int deleteWakuInfo(TorihikisakiWakuInfoDeleteCommitParamBean paramBean);

    /**
     * 取引先テーブルの最終更新日時を更新します。
     * @param paramBean 更新パラメータ
     * @return 更新件数
     */
    public int updateTorihikisakiUpdDt(TorihikisakiWakuInfoDeleteCommitParamBean paramBean);
}

/*
 * $Id: TorihikisakiWakuInfoAddConfirmDao.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/13  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

/**
 * 取引先物件枠設定情報確認DAO
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiWakuInfoAddConfirmDao {

    /**
     * 登録する物件枠情報と同じ適用月のデータがあるかを確認
     * @param paramBean 登録パラメータ（取引先シーケンス、適用月）
     * @return 検索結果件数
     */
    public int checkAppliyYm(TorihikisakiWakuInfoAddConfirmParamBean paramBean);
}

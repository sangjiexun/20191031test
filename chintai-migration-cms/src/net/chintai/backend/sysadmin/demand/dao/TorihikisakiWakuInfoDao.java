/*
 * $Id: TorihikisakiWakuInfoDao.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/08  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import java.util.List;

import net.chintai.backend.sysadmin.demand.domain.TorihikisakiWakuInfoDomain;

/**
 * 取引先物件枠情報取得DAO
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiWakuInfoDao {

    /**
     * 取引先物件枠情報を取得します。
     * @param paramBean 検索パラメータ（取引先シーケンス番号）
     * @return 取引先物件枠情報
     */
    public List<TorihikisakiWakuInfoDomain> getTorihikisakiWakuInfo(
            TorihikisakiWakuInfoParamBean paramBean);
}

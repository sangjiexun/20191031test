/*
 * $Id: TorihikisakiInfoDao.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/26  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import net.chintai.backend.sysadmin.demand.domain.TorihikisakiInfoDomain;

/**
 * 取引先詳細情報取得DAO
 *
 * @author lee-hosup
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiInfoDao {

    /**
     * 取引先詳細情報を検索
     * @param paramBean 検索パラメータ（不動産会社コード、取引先コード）
     * @return 取引先詳細情報
     */
    public TorihikisakiInfoDomain getTorihikisakiDetailInfo(TorihikisakiInfoParamBean paramBean);
}

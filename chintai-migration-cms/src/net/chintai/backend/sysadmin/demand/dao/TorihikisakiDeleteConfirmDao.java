/*
 * $Id: TorihikisakiDeleteConfirmDao.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/06  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import java.util.List;

import net.chintai.backend.sysadmin.demand.domain.TorihikisakiDeleteConfirmDomain;

/**
 * 取引先削除確認DAO
 *
 * @author lee-hosup
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiDeleteConfirmDao {

    /**
     * 削除する取引先の情報を取得
     * @param paramBean 取引先シーケンス番号リスト
     * @return 取引先詳細情報
     */
    public List<TorihikisakiDeleteConfirmDomain> getTorihikisakiInfoForDel(
            TorihikisakiDeleteConfirmParamBean paramBean);
}

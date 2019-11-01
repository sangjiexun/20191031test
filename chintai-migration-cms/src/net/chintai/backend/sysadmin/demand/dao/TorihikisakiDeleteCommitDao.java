/*
 * $Id: TorihikisakiDeleteCommitDao.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/07  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

/**
 * 取引先削除処理DAO
 *
 * @author lee-hosup
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiDeleteCommitDao {

    /**
     * 取引先削除処理を行います。
     * @param paramBean 削除パラメータ（シーケンス番号、最終更新日時）
     */
    public int deleteTorihikisaki(TorihikisakiDeleteCommitParamBean paramBean);
}

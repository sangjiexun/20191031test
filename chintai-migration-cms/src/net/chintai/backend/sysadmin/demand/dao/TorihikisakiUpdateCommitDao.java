/*
 * $Id: TorihikisakiUpdateCommitDao.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/06  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;


/**
 * 取引先情報更新DAO
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiUpdateCommitDao {

    /**
     * 新しい取引先コードを取得します。
     * @param fudousanCd 不動産会社コード
     * @return 新しい取引先コード
     */
    public String getNewTorihikisakiCd(String fudousanCd);

    /**
     * 取引先情報を更新します。
     * @param paramBean 更新パラメータ
     * @return 更新件数
     */
    public int updateTorihikisakiInfo(TorihikisakiUpdateCommitParamBean paramBean);

}

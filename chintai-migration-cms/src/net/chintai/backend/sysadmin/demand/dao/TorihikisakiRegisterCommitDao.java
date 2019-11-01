/*
 * $Id: TorihikisakiRegisterCommitDao.java 3674 2007-12-20 02:32:29Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/04  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;


/**
 * 取引先新規登録DAO
 *
 * @author lee-hosup
 * @version $Revision: 3674 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiRegisterCommitDao {

    /**
     * 取引先コードを取得します。<br>
     * 不動産会社テーブルも検索し<br>
     * 不動産会社テーブルに不動産会社コードが存在しない場合<br>
     * Nullをリターンします
     * @param fudousanCd 不動産会社コード
     * @return 登録する取引先コード、或いはヌル
     */
    public String getTorihikisakiCd(String fudousanCd);

    /**
     * 新しい取引先情報を登録します。（取引先テーブル）
     * @param paramBean 登録パラメータ
     * @return 登録した取引先のシーケンス番号
     */
    public int insertTorihikisaki(TorihikisakiRegisterCommitParamBean paramBean);

    /**
     * 新しい取引先情報を登録します。（取引先料金テーブル）
     * @param paramBean 登録パラメータ
     */
    public void insertTorihikisakiRyoukin(TorihikisakiRegisterCommitParamBean paramBean);
}

/*
 * $Id: AspGroupUpdateCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/24  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;


/**
 * 不動産ASPグループ情報更新Dao
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspGroupUpdateCommitDao {

    /**
     * 不動産ASPグループ情報更新します。
     * @param paramBean 検索パラメータ(店舗コード、グループ店舗コード、店舗状態ステータス)
     * @return 更新結果件数
     */
    public int aspGroupUpdateCommit(AspGroupUpdateCommitParamBean paramBean);

}

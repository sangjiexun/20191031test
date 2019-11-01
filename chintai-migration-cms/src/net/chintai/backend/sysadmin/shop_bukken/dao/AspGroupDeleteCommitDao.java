/*
 * $Id: AspGroupDeleteCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/25  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 不動産ASPグループから外す(削除)Dao
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspGroupDeleteCommitDao {

    /**
     * グループから外します。
     * @param paramBean 削除パラメータ(削除対象店舗コード)
     * @return 削除結果件数
     */
    public int aspGroupDeleteCommit(AspGroupDeleteCommitParamBean paramBean);
}

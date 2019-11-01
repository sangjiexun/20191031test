/*
 * $Id: FudousanDeleteCommitDao.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/05     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;


/**
 * 不動産会社削除DAO
 *
 * @author TAKAHASHI Yuki
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface FudousanDeleteCommitDao {

    /**
     * 不動産会社を削除します。
     * @param paramBean 検索パラメータ
     * @return 削除処理件数
     */
    public int fudousanDeleteCommit(FudousanDeleteCommitParamBean paramBean);

}

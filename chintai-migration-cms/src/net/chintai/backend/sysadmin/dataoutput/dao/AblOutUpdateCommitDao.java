/*
 * $Id: AblOutUpdateCommitDao.java 4715 2013-11-05 07:41:26Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao;


/**
 * エイブル担当店/取扱店出力情報設定用Dao
 * @author KAMEDA Takuma
 * @version $Revision: 4715 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AblOutUpdateCommitDao {

    /**
     * エイブル担当店/取扱店出力情報を設定
     * @param paramBean　入力内容
     * @return　処理結果件数
     */
    public int ablOutUpdate(AblOutUpdateParamBean paramBean);

}

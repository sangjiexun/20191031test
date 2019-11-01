/*
 * $Id: FudousanDeleteConfirmDao.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/04     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import java.util.List;


/**
 * 不動産会社削除確認
 * @author TAKAHASHI Yuki
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface FudousanDeleteConfirmDao {

    /**
     * 削除する不動産会社の情報を取得します。
     * @param paramBean 検索パラメータ
     * @return 削除する不動産会社情報リスト
     */
    public List fudousanDeleteConfirm(FudousanDeleteConfirmParamBean paramBean);

}

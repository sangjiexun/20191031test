/*
 * $Id: BukkenQueryIdSearchDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import java.util.List;

/**
 * 問合せ番号で検索DAO
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface BukkenQueryIdSearchDao {

    /**
     * 物件検索を行い、複数件の結果を受け取ります。
     * @param paramBean 検索キーワード
     * @return 検索結果リスト
     */
    public List bukkenQueryIdSearch(BukkenQueryIdSearchParamBean paramBean);
}
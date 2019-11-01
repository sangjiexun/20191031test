/*
 * $Id: KeiyakuRegisterPageDao.java 4281 2009-07-06 12:10:17Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/02     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

/**
 * 契約情報登録画面表示データ取得用DAO
 *
 * @author Lee Hosup
 * @version $Revision: 4281 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface KeiyakuRegisterPageDao {

    /**
     * 店舗リスティング契約情報テーブルで該当店舗の最終更新日を取得
     *
     * @param shopCd 店舗コード
     * @return 契約情報テーブルで該当店舗の最終更新日
     */
    public String searchUpdDt(String shopCd);

}

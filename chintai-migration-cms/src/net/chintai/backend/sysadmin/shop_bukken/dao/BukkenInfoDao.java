/*
 * $Id: BukkenInfoDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/01  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.domain.Bukken;

/**
 * 物件詳細情報処理DAO
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface BukkenInfoDao {

    /**
     * 物件詳細情報を取得します。
     * @param paramBean 検索パラメータ
     * @return Bukken 取得した物件情報
     */
    public Bukken bukkenInfo(BukkenInfoParamBean paramBean);

    /**
     * 物件詳細画面に表示する担当店を取得します。
     * @param paramBean
     * @return 取得した店舗情報
     */
    public List bukkenInfoTantouShop(BukkenInfoParamBean paramBean);
}
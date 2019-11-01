/*
 * $Id: BukkenPublishStatusUpdatePageDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/02  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import net.chintai.backend.sysadmin.shop_bukken.domain.Bukken;

/**
 * 物件掲載状態変更画面に遷移DAO
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface BukkenPublishStatusUpdatePageDao {

    /**
     * 物件詳細情報処理
     * @param paramBean
     * @return Bukken
     */
    public Bukken bukkenPublishStatusUpdatePage
        (BukkenPublishStatusUpdatePageParamBean paramBean);
}
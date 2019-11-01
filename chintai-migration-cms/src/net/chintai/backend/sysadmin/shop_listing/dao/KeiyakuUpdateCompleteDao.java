/*
 * $Id: KeiyakuUpdateCompleteDao.java 4249 2009-03-24 05:36:55Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/25     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

/**
 * 契約情報更新DAO。
 *
 * @author Lee Hosup
 * @version $Revision: 4249 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface KeiyakuUpdateCompleteDao {

    /**
     * 契約情報を更新します。
     *
     * @param paramBean
     * @return
     */
    public void updateKeiykuInfo(KeiyakuUpdateCompleteParamBean paramBean);

}

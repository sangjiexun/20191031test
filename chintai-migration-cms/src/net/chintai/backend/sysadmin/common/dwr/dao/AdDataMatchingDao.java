/*
 * $Id: AdDataMatchingDao.java 4352 2009-08-28 06:57:37Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/28     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.dao;


/**
 * ADデータ関連情報取得DAO
 *
 * @author Lee Hosup
 * @version $Revision: 4352 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AdDataMatchingDao {

    /**
     * 該当対象年月データの総件数を取得します。
     *
     * @param date
     * @return
     */
    public String countMonthlyAdData(String date);
}

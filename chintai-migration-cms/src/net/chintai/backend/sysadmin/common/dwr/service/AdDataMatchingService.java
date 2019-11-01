/*
 * $Id: AdDataMatchingService.java 4352 2009-08-28 06:57:37Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/28     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.service;



/**
 * ADデータと物件データ照合
 *
 * @author Lee Hosup
 * @version $Revision: 4352 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AdDataMatchingService {

    /**
     * 該当対象年月データの総件数を取得します。
     * @param date
     * @return
     */
    public String countMonthyAdData(String date);
}

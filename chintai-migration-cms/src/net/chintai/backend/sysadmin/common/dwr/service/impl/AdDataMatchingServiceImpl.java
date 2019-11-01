/*
 * $Id: AdDataMatchingServiceImpl.java 4352 2009-08-28 06:57:37Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/28     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.service.impl;

import net.chintai.backend.sysadmin.common.dwr.dao.AdDataMatchingDao;
import net.chintai.backend.sysadmin.common.dwr.service.AdDataMatchingService;


/**
 * AdDataMatchingServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4352 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AdDataMatchingServiceImpl implements AdDataMatchingService {

    /** ADデータ情報取得DAO */
    AdDataMatchingDao adDataMatchingDao;

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.dwr.service.AdDataMatchingService#
     * countMonthyAdData(java.lang.String)
     */
    public String countMonthyAdData(String date) {

        return adDataMatchingDao.countMonthlyAdData(date);
    }

    /**
     * ADデータ情報取得DAOを設定します。
     * @param adDataMatchingDao ADデータ情報取得DAO
     */
    public void setAdDataMatchingDao(AdDataMatchingDao adDataMatchingDao) {
        this.adDataMatchingDao = adDataMatchingDao;
    }

}

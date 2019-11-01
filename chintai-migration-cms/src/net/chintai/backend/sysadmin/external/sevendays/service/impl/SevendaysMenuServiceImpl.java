/*
 * $Id: SevendaysMenuServiceImpl.java 4517 2011-09-13 00:16:51Z e-ishii $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/15   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.external.sevendays.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.chintai.backend.sysadmin.addata_matching.action.MatchingDataDownloadAction;
import net.chintai.backend.sysadmin.external.sevendays.dao.SevendaysMenuDao;
import net.chintai.backend.sysadmin.external.sevendays.service.SevendaysMenuService;

import static net.chintai.backend.sysadmin.common.properties.SystemProperties.getProperty;

/**
 * SevendaysMenuService の実装クラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 4517 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class SevendaysMenuServiceImpl implements SevendaysMenuService {

    /** ログインスタンス */
    private static Log log = LogFactory.getLog(SevendaysMenuServiceImpl.class);

    /** 7days メニュー表示可否判定 DAO */
    SevendaysMenuDao sevendaysMenuDao;

    /**
     * 7days メニュー表示可否判定 DAO を設定します。
     * @param dao
     */
    public void setSevendaysMenuDao(SevendaysMenuDao dao) {
        sevendaysMenuDao = dao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.external.sevendays.service.SevendaysMenuService#isEnabledChintaiBukkenListing(java.lang.String)
     */
    public boolean isEnabledChintaiBukkenListing(String shopCode) {
        int count = sevendaysMenuDao.selectChintaiBukkenListingEnabled(shopCode);
        return (count > 0) ? true : false;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.external.sevendays.service.SevendaysMenuService#isEnabledChintaiLogAnalysis(java.lang.String)
     */
    public boolean isEnabledChintaiLogAnalysis(String shopCode) {
        int count = sevendaysMenuDao.selectChintaiLogAnalysisEnabled(shopCode);
        return (count > 0) ? true : false;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.external.sevendays.service.SevendaysMenuService#isEnabledKeisaiList(java.lang.String)
     */
    public boolean isEnabledKeisaiList(String shopCode) {
        // 2008-01-30) 将来チェック処理が実装される可能性のために予約。
        // 現状は常に true を返却。
        return true;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.external.sevendays.service.SevendaysMenuService#isEnabledCampaign(java.lang.String)
     */
    public boolean isEnabledCampaign(String shopCode) {

        String[] array = StringUtils.split(getProperty("SEVENDAYS_TAISHO_SHOPCD"), ",");

        List<String> list = Arrays.asList(array);

        if(list.contains(shopCode)) {
            return true;
        }

        return false;
    }

    public boolean isEnabledLogReportDownload(String shopCode) {

        String result = sevendaysMenuDao.selectLogReportEnabled(shopCode);

        if (StringUtils.equals(result, "1")) {
            return true;
        }

        return false;
    }
}

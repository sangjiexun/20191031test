/*
 * $Id: RosenDistributeCsvDownloadService.java 3714 2007-12-26 06:23:19Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/12/26   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;

/**
 * 配布用のCSVを作成するサービス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3714 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface RosenDistributeCsvDownloadService {

    /**
     * 配布用沿線CSVを作成します。
     * @param bean CSV出力情報
     * @throws ApplicationException CSV出力時に問題が発生した場合スローされます。
     */
    public void createEnsenCsv(CsvStatusBean bean) throws ApplicationException;

    /**
     * 配布用駅CSVを作成します。
     * @param bean CSV出力情報
     * @throws ApplicationException CSV出力時に問題が発生した場合スローされます。
     */
    public void createEkiCsv(CsvStatusBean bean) throws ApplicationException;

    /**
     * @return
     * @throws Exception
     */
    public List rosenEnsenSearchForCsv() throws Exception;

    /**
     * @return
     * @throws Exception
     */
    public List rosenEkiSearchForCsv() throws Exception;
}

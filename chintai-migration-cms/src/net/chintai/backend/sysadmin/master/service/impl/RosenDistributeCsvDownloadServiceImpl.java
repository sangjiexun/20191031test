/*
 * $Id: RosenDistributeCsvDownloadServiceImpl.java 3809 2008-02-20 00:50:51Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/12/26   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.rowhandler.CsvRowHandler;
import net.chintai.backend.sysadmin.common.util.CsvException;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.master.dao.RosenEkiSearchForDistributeCsvDao;
import net.chintai.backend.sysadmin.master.service.RosenDistributeCsvDownloadService;
import net.chintai.backend.sysadmin.master.service.rowhandler.EkiConverter;
import net.chintai.backend.sysadmin.master.service.rowhandler.EnsenConverter;

/**
 * RosenDistributeCsvDownloadService の実装クラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3809 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenDistributeCsvDownloadServiceImpl implements RosenDistributeCsvDownloadService {

    /** 配布用CSV取得DAO */
    RosenEkiSearchForDistributeCsvDao rosenEkiSearchForDistributeCsvDao;

    /**
     * 配布用CSV取得DAO を設定します。
     * @param dao 配布用CSV取得DAO
     */
    public void setRosenEkiSearchForDistributeCsvDao(RosenEkiSearchForDistributeCsvDao dao) {
        rosenEkiSearchForDistributeCsvDao = dao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.RosenDistributeCsvDownloadService#createEkiCsv(net.chintai.backend.sysadmin.common.util.CsvStatusBean)
     */
    public void createEkiCsv(CsvStatusBean bean) throws ApplicationException {

        try {
            CsvRowHandler handler = new CsvRowHandler(bean, new EkiConverter());
            rosenEkiSearchForDistributeCsvDao.selectEkiToCsv(handler);
            handler.close();

        } catch (CsvException e) {
            // ClientAbortException は無視します。
            if (!StringUtils.contains(e.toString(), "ClientAbortException")) {
                throw new ApplicationException("ERROR.M.MASTER.0001", e);
            }
        } catch (IllegalStateException e) {
            // レスポンスコミット済みの場合に発生する例外は
            // 無視します。それ以外について例外処理します。
            if (!bean.getResponse().isCommitted()) {
                throw new ApplicationException("ERROR.M.MASTER.0001", e);
            }
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.RosenDistributeCsvDownloadService#createEnsenCsv(net.chintai.backend.sysadmin.common.util.CsvStatusBean)
     */
    public void createEnsenCsv(CsvStatusBean bean) throws ApplicationException {

        try {
            CsvRowHandler handler = new CsvRowHandler(bean, new EnsenConverter());
            rosenEkiSearchForDistributeCsvDao.selectEnsenToCsv(handler);
            handler.close();

        } catch (CsvException e) {
            // ClientAbortException は無視します。
            if (!StringUtils.contains(e.toString(), "ClientAbortException")) {
                throw new ApplicationException("ERROR.M.MASTER.0001", e);
            }
        } catch (IllegalStateException e) {
            // レスポンスコミット済みの場合に発生する例外は
            // 無視します。それ以外について例外処理します。
            if (!bean.getResponse().isCommitted()) {
                throw new ApplicationException("ERROR.M.MASTER.0001", e);
            }
        }
    }

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.master.service.RosenDistributeCsvDownloadService#rosenEnsenSearchForCsv()
	 */
	public List rosenEnsenSearchForCsv() throws Exception {
		return rosenEkiSearchForDistributeCsvDao.selectEnsenToCsv();
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.master.service.RosenDistributeCsvDownloadService#rosenEkiSearchForCsv()
	 */
	public List rosenEkiSearchForCsv() throws Exception {
		return rosenEkiSearchForDistributeCsvDao.selectEkiToCsv();
	}
}

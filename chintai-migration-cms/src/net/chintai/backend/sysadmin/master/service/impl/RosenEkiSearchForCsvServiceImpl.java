/*
 * $Id: RosenEkiSearchForCsvServiceImpl.java 3809 2008-02-20 00:50:51Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/17  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.impl;

import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.rowhandler.CsvRowHandler;
import net.chintai.backend.sysadmin.common.util.CsvException;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.master.dao.RosenEkiSearchForCsvDao;
import net.chintai.backend.sysadmin.master.service.RosenEkiSearchForCsvService;
import net.chintai.backend.sysadmin.master.service.rowhandler.EnsenEkiConverter;

import org.apache.commons.lang.StringUtils;

/**
 * RosenEkiSearchForCsvServiceの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3809 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenEkiSearchForCsvServiceImpl implements RosenEkiSearchForCsvService {

    /** 沿線検索DAO */
    private RosenEkiSearchForCsvDao rosenEkiSearchForCsvDao = null;

    /**
     * rosenEkiSearchForCsvDaoを設定します。
     * @param rosenEkiSearchForCsvDao
     */
    public void setRosenEkiSearchForCsvDao(RosenEkiSearchForCsvDao rosenEkiSearchForCsvDao) {
        this.rosenEkiSearchForCsvDao = rosenEkiSearchForCsvDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.RosenEkiSearchForCsvService#createEnsenEkiCsv(net.chintai.backend.sysadmin.common.util.CsvStatusBean)
     */
    public void createEnsenEkiCsv(CsvStatusBean bean) throws ApplicationException {

        try {
            CsvRowHandler handler = new CsvRowHandler(bean, new EnsenEkiConverter());
            rosenEkiSearchForCsvDao.selectEnsenEkiToCsv(handler);
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
	 * @see net.chintai.backend.sysadmin.master.service.RosenEkiSearchForCsvService#rosenEkiSearchForCsv()
	 */
	public List rosenEkiSearchForCsv() throws Exception {
		return rosenEkiSearchForCsvDao.selectEnsenEkiToCsv();
	}
}

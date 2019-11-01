package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import org.apache.commons.lang.StringUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.rowhandler.CsvRowHandler;
import net.chintai.backend.sysadmin.common.util.CsvException;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;

import net.chintai.backend.sysadmin.shop_bukken.dao.NayoseSkipShopDao;
import net.chintai.backend.sysadmin.shop_bukken.service.NayoseSkipShopCsvDownloadService;
import net.chintai.backend.sysadmin.shop_bukken.service.rowHandler.NayoseSkipShopConverter;


/**
 * NayoseSkipShopCsvDownloadServiceの実装クラス
 *
 * @author e-ishii
 * @version $Revision: 4571 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class NayoseSkipShopCsvDownloadServiceImpl implements NayoseSkipShopCsvDownloadService{

    /** 名寄せ対象外店舗一覧取得Dao*/
    private NayoseSkipShopDao nayoseSkipShopDao;

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.NayoseSkipShopCsvDownloadService#getNayoseSkipShopCount()
     */
    public int getNayoseSkipShopCount() {

        return nayoseSkipShopDao.selectNayoseSkipShopCount();

    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.NayoseSkipShopCsvDownloadService#createNayoseSkipShopCsv(net.chintai.backend.sysadmin.common.util.CsvStatusBean)
     */
    public void createNayoseSkipShopCsv(CsvStatusBean bean) throws ApplicationException {

        try {
            CsvRowHandler handler = new CsvRowHandler(bean, new NayoseSkipShopConverter());
            handler.setCsvHeader(SystemProperties.getProperties("NayoseSkipShop.Header"));
            nayoseSkipShopDao.selectNayoseSkipShopCsv(handler);
            handler.close();

        } catch (CsvException e) {
            // ClientAbortException は無視します。
            if (!StringUtils.contains(e.toString(), "ClientAbortException")) {
                throw new ApplicationException("ERROR.M.NAYOSESKIPDOWNLOAD.0001", e);
            }
        } catch (IllegalStateException e) {
            // レスポンスコミット済みの場合に発生する例外は
            // 無視します。それ以外について例外処理します。
            if (!bean.getResponse().isCommitted()) {
                throw new ApplicationException("ERROR.M.NAYOSESKIPDOWNLOAD.0001", e);
            }
        }

    }

    /**
     * nayoseSkipShopDaoを設定します。
     * @param nayoseSkipShopDao nayoseSkipShopDao
     */
    public void setNayoseSkipShopDao(NayoseSkipShopDao nayoseSkipShopDao) {
        this.nayoseSkipShopDao = nayoseSkipShopDao;
    }
}

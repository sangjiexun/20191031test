package net.chintai.backend.sysadmin.shop_inquiry.service.impl;


import org.apache.commons.lang.StringUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.rowhandler.CsvRowHandler;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.common.util.CsvException;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryRecentSearchDao;
import net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryRecentSearchParamBean;
import net.chintai.backend.sysadmin.shop_inquiry.service.InquiryRecentListCsvService;
import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryRecentSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_inquiry.service.rowhandler.InquiryRecentConverter;



/**
 * InquiryRecentListCsvServiceの実装クラス
 * @author e-ishii
 * @version $Revision: 4464 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryRecentListCsvServiceImpl implements InquiryRecentListCsvService{

    /** 問い合せ情報検索DAO */
    private InquiryRecentSearchDao inquiryRecentSearchDao = null;

    /**
     * 問い合せ情報検索DAOを設定します。
     * @param inquiryRecentSearchDao
     */
    public void setInquiryRecentSearchDao(
            InquiryRecentSearchDao inquiryRecentSearchDao) {
        this.inquiryRecentSearchDao = inquiryRecentSearchDao;
    }


    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_inquiry.service.InquiryRecentListCsvService#createInquiryRecentListCsv(net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryRecentSearchInServiceBean, net.chintai.backend.sysadmin.common.util.CsvStatusBean)
     */
    public void createInquiryRecentListCsv(InquiryRecentSearchInServiceBean inServiceBean , CsvStatusBean csvStatusBean) throws ApplicationException {

        try {
            CsvRowHandler handler = new CsvRowHandler(csvStatusBean, new InquiryRecentConverter());
            handler.setCsvHeader(SystemProperties.getProperties("InquiryRecentSearch.Header"));
            InquiryRecentSearchParamBean paramBean = new InquiryRecentSearchParamBean();
            BeanUtilsWrapper.copyProperties(paramBean, inServiceBean);

            inquiryRecentSearchDao.inqueryRecentSearchForCsv(handler, paramBean);
            handler.close();

        } catch (CsvException e) {
            // ClientAbortException は無視します。
            if (!StringUtils.contains(e.toString(), "ClientAbortException")) {
                throw new ApplicationException("ERROR.M.MASTER.0001", e);
            }
        } catch (IllegalStateException e) {
            // レスポンスコミット済みの場合に発生する例外は
            // 無視します。それ以外について例外処理します。
            if (!csvStatusBean.getResponse().isCommitted()) {
                throw new ApplicationException("ERROR.M.MASTER.0001", e);
            }
        }

    }


    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_inquiry.service.InquiryRecentListCsvService#selectCountInquiryRecentList(net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryRecentSearchInServiceBean)
     */
    public int selectCountInquiryRecentList(InquiryRecentSearchInServiceBean inServiceBean) {

        InquiryRecentSearchParamBean paramBean = new InquiryRecentSearchParamBean();
        BeanUtilsWrapper.copyProperties(paramBean, inServiceBean);

        return inquiryRecentSearchDao.inqueryRecentTotalList(paramBean);
    }

}

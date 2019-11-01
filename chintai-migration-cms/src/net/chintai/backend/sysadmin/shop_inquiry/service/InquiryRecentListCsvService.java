package net.chintai.backend.sysadmin.shop_inquiry.service;


import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryRecentSearchInServiceBean;


/**
 * 問合せ情報CSV出力Service
 * @author e-ishii
 * @version $Revision: 4464 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface InquiryRecentListCsvService {

    /**
     * 問合せ情報CSV出力処理
     * @param inServiceBean
     * @param csvStatusBean
     * @throws ApplicationException
     */
    public void createInquiryRecentListCsv(InquiryRecentSearchInServiceBean inServiceBean , CsvStatusBean csvStatusBean) throws ApplicationException;

    /**
     * 問合せ情報(CSV用)検索の総件数取得
     * @param inServiceBean
     * @return
     */
    public int selectCountInquiryRecentList(InquiryRecentSearchInServiceBean inServiceBean);

}

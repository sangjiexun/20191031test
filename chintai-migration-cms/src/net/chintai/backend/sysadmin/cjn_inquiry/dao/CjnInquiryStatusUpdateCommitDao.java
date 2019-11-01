/*
 * $Id: CjnInquiryStatusUpdateCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

/**
 * 問い合せ処理状況更新Dao
 * 
 * @author KOJIMA Takanori
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryStatusUpdateCommitDao {

    /**
     * 問い合せ処理状況を更新します。
     * @param paramBean 処理状況情報
     * @return 更新行数
     */
    public int updateCjnInquiryStatus(CjnInquiryStatusUpdateCommitParamBean paramBean);
}

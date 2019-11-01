/*
 * $Id: CjnInquiryInfoDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryInfo;

/**
 * 問い合せ詳細を取得するDao。
 * 
 * @author KOJIMA Takanori
 * @author Yang EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryInfoDao {

    /**
     * 問い合せ詳細情報を取得します。
     * @param paramBean 検索条件
     * @return 問い合せ詳細
     */
    public CjnInquiryInfo selectCjnInquiryInfo(CjnInquiryInfoParamBean paramBean);

    /**
     * 問い合せ閲覧状況フラグ更新
     * @param paramBean 問い合せID
     * @return 更新ロウ数
     */
    public int updateRefFlg(CjnInquiryInfoParamBean paramBean);
}

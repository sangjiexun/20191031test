/*
 * $Id: CjnInquirySearchDisposeCountService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島       新規作成
 * 2007/10/05   BGT)楊恩美     更新
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquirySearchDisposeCountOutServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquirySearchDisposeCountPageInServiceBean;

/**
 * 問い合せ処理件数を取得するサービス。
 * 
 * @author KOJIMA Takanori
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquirySearchDisposeCountService {

    /**
     * 問い合せ処理件数を取得します。
     * @param inServiceBean 検索条件
     * @return 問い合せ処理件数情報
     */
    public CjnInquirySearchDisposeCountOutServiceBean selectDisposeCountList(
            CjnInquirySearchDisposeCountPageInServiceBean inServiceBean);

}

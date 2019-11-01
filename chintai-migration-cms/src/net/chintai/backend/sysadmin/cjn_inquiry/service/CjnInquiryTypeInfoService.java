/*
 * $Id: CjnInquiryTypeInfoService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26   BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeInfoInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeInfoOutServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeInfoUsersOutServiceBean;

/**
 * 問い合せ種別詳細を取得するサービス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryTypeInfoService {

    /**
     * 問い合せ種別詳細を取得します。
     * @param bean 検索パラメータ
     * @return 問い合せ種別詳細
     */
    public CjnInquiryTypeInfoOutServiceBean selectTypeInfo(CjnInquiryTypeInfoInServiceBean bean);

    /**
     * 指定された問い合せ種別について、ユーザ一覧および、<br>
     * ユーザ毎の問い合せ種別が閲覧可否情報を取得します。
     * @param bean 検索パラメータ
     * @return 閲覧可否情報付きユーザ一覧
     */
    public List<CjnInquiryTypeInfoUsersOutServiceBean>
                selectTypeInfoUsers(CjnInquiryTypeInfoInServiceBean bean);
}

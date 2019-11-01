/*
 * $Id: CjnInquiryTypeInfoDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/26   BGT)児島      新規作成
 * 2007/09/26   BGT)児島      メソッド追加 selectLastUpdateTimeForReadableUsers
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfo;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfoUsers;

/**
 * 問い合せ種別詳細を取得するDAO。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryTypeInfoDao {

    /**
     * 問い合せ種別詳細を取得します。
     * @param param 検索パラメータ
     * @return 問い合せ種別詳細情報
     */
    public CjnInquiryTypeInfo selectTypeInfo(CjnInquiryTypeInfoParamBean param);

    /**
     * 指定された問い合せ種別について、ユーザ一覧および、<br>
     * ユーザ毎の問い合せ種別が閲覧可否情報を取得します。
     * @param param 検索パラメータ
     * @return 閲覧可否情報付きユーザ一覧
     */
    public List<CjnInquiryTypeInfoUsers> selectTypeInfoUsers(CjnInquiryTypeInfoParamBean param);

    /**
     * 閲覧可能ユーザ情報の最終更新日時を取得します。<br>
     * 対象となる複数件のデータのうち、最も直近に更新されたデータの日時を取得します。
     * @param cjnInqKindSeq 対象とする問い合せ種別
     * @return 最終更新日時
     */
    public String selectLastUpdateTimeForReadableUsers(int cjnInqKindSeq);
}

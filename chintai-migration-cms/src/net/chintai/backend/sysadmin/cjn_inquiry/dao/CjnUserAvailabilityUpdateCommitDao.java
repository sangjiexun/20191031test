/*
 * $Id: CjnUserAvailabilityUpdateCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/28   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfoUsers;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;

/**
 * 閲覧可能ユーザリスト更新DAO。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnUserAvailabilityUpdateCommitDao {

    /**
     * 閲覧可能ユーザリストを更新します。
     * @param usersList 閲覧可能ユーザリスト(閲覧不可ユーザ情報は含まないこと)
     * @param cjnInqKindSeq 問い合せ種別シーケンス
     * @param lastUpdateTime 更新用データ取得時に同時に取得した最終更新日時
     * @throws ApplicationException 更新の競合が発生した場合にスローされる
     */
    public void updateUsersAvailability(List<CjnInquiryTypeInfoUsers> usersList,
            int cjnInqKindSeq, String lastUpdateTime) throws ApplicationException;
}

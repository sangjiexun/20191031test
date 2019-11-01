/*
 * $Id: CjnInquiryTypeListDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島      新規作成
 * 2007/10/21   BGT)児島      新規メソッド追加
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryReadableUser;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeList;

/**
 * 問い合せ種別一覧を取得するDAO。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryTypeListDao {

    /**
     * 問い合せ種別一覧を取得します。
     * @return 問い合せ種別情報のリスト
     */
    public List<CjnInquiryTypeList> selectTypeList();

    /**
     * 閲覧可能ユーザ名リストを取得します。
     * @return 閲覧可能ユーザ名リスト。
     */
    public List<CjnInquiryReadableUser> selectReadableUsersList();
    
    /**
     * ユーザIDに対応する閲覧可能問い合せ種別の一覧を取得します。
     * @param userId ユーザID
     * @return 閲覧可能問い合せ種別のIDリスト
     */
    public List<Integer> selectKindSeqList(String userId);
    
    /**
     * ユーザIDに対応するCHINTAI問い合せアカウント種別を取得します。
     * @param userId ユーザID
     * @return 問い合せアカウント種別
     */
    public String selectAccountType(String userId);
    

}

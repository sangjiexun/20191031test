/*
 * $Id: CjnInquiryTypeListService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeListOutServiceBean;

/**
 * 問い合せ種別一覧を取得するサービス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryTypeListService {

    /**
     * 問い合せ種別一覧を取得します。
     * @return 問い合せ種別情報のリスト
     */
    public List<CjnInquiryTypeListOutServiceBean> selectTypeList();

    /**
     * 閲覧可能ユーザ名リストのマップを取得します。
     * @return 閲覧可能ユーザ名リストのマップ。<br>
     *         マップの中に (問い合せ種別シーケンス, ユーザリスト) のペアが含まれる。
     */
    public Map<Integer, List<String>> selectReadableUsersListsMap();
    
    /**
     * ユーザIDに対応する問い合せ種別一覧を取得します。
     * @param userId ユーザID
     * @return 問い合せ種別一覧のIDリスト
     */
    public List<Integer> selectKindSeqList(String userId);
    
    /**
     * ユーザIDに対応するアカウント種別を取得します。
     * @param userId ユーザID
     * @return CHINTAI問い合せ管理アカウント種別
     */
    public String selectAccountType(String userId);
}

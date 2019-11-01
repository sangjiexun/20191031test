/*
 * $Id: CjnInquiryAccessControlService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/11/04   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

/**
 * CHINTAI問い合せ管理内部におけるアクセス制御を管理するサービス。<br>
 * システム共通の権限管理フレームの上に構築される前提とする。<br>
 * そのため、このインターフェースのメソッドが呼び出されるときは<br>
 * すでに共通の権限管理で認証を得ていることが前提となる。<br>
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryAccessControlService {

    /**
     * 指定されたユーザID、問い合せ種別シーケンスに対してアクセス権限があるかどうかチェックします。
     * @param userId ログインユーザID
     * @param cjnInqKindSeq 問い合せ種別ID
     * @return 権限あり: true, 権限なし: false
     */
    public boolean isAccessibleForKindSeq(String userId, int cjnInqKindSeq);

    /**
     * 指定されたユーザID、問い合せIDに対してアクセス権限があるかどうかチェックします。
     * @param userId ログインユーザID
     * @param cjnInqId 問い合せID
     * @return 権限あり: true, 権限なし: false
     */
    public boolean isAccessibleForInqId(String userId, String cjnInqId);
    
}

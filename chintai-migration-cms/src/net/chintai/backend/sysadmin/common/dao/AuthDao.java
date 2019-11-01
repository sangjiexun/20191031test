/*
 * $Id: AuthDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/08/08   BGT)児島      新規作成
 * 2007/10/31   BGT)児島      CJN_ACCOUNT_TYPE取得メソッド追加
 */
package net.chintai.backend.sysadmin.common.dao;

import java.util.List;

/**
 * 権限認証 DAO クラス。<br>
 * ログイン認証については、この DAO では扱いません。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AuthDao {

    /**
     * ユーザIDと権限IDをキーにして、グループ権限対応表を<br>
     * 検索した結果のレコード件数を返します。<br>
     * レコード件数が 1 の場合は権限あり、<br>
     * レコード件数が 0 の場合は権限なしとみなします。
     * @param bean 検索パラメータ (ユーザID、権限ID)
     * @return レコード件数 (0 or 1)
     */
    public int selectAuthorityCount(AuthParamBean bean);
    
    /**
     * 指定された検索パラメータをキーとして権限IDリストを取得します。
     * @param bean 検索パラメータ
     * @return 権限IDのリスト
     */
    public List<String> selectAuthorityList(AuthParamBean bean);
    
    /**
     * 指定されたユーザIDについて、CHINTAI問い合せ管理機能の権限を取得します。
     * @param userId ユーザID
     * @return 通常:0, 管理:1 (コード定義書に従う)
     */
    public String selectCjnAccountType(String userId);
}

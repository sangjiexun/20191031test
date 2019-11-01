/*
 * $Id: AuthService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/08/08     BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.common.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;

/**
 * アクセス権限判定サービスクラス。<br>
 * ログイン認証については、この Service では扱いません。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AuthService {

    /**
     * あるユーザに特定のアクセス権限があるかどうかを判定します。<br>
     * ユーザーIDと権限IDをもとにして判定し、権限がある場合には<br>
     * True を、権限がない場合には False を返します。
     * @param userId ユーザーID
     * @param authorityId 権限ID
     * @return 権限がある場合 True, ない場合 False
     */
    public boolean authenticate(String userId, AuthorityId authorityId);
    
    /**
     * 指定したユーザIDの権限リストを返します。
     * @param userId ユーザID
     * @return 権限リスト
     */
    public List<String> getAuthorityList(String userId);
    
    /**
     * CHINTAI問い合せ機能のユーザタイプ(管理/通常)を取得します。
     * @param userId ユーザID
     * @return ユーザタイプコード(コード値の意味はコード定義書を確認)
     */
    public String getCjnAccountType(String userId);
    
    /**
     * CHINTAI問い合せ機能のユーザタイプが「管理」かどうかを判定します。
     * @param userId ユーザID
     * @return 管理:1, 通常:0
     */
    public boolean isAdminCjnAccountType(String userId);
    
}

/*
 * LoginService.java
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/06/15  BGT)児島   新規作成
 *
 */
package net.chintai.backend.sysadmin.login.service;

import net.chintai.backend.sysadmin.common.session.SessionBean;
import net.chintai.backend.sysadmin.login.service.bean.LoginServiceBean;

/**
 * ログイン処理を提供するサービスクラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface LoginService {

    /**
     * ログインを行い、成功した場合にユーザ情報を戻します。
     * @param bean ログイン情報
     * @return ログイン成功時 loginServiceBean, ログイン失敗時 null
     */
    public LoginServiceBean login(LoginServiceBean bean);

    /**
     * ユーザIDと送信日をもとに認証を行い、成功した場合にユーザ情報を戻します。
     * @param userId ユーザ情報
     * @param postDate 送信日
     * @return 認証成功時 loginServiceBean, 認証失敗時 null
     */
    public LoginServiceBean getUserInfo(String userId, String postDate);

}

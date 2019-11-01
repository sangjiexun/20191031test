/*
 * LoginService.java
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/06/15  BGT)児島   新規作成
 *
 */
package net.chintai.backend.sysadmin.login.service;

import net.chintai.backend.sysadmin.login.service.bean.MngSessionInServiceBean;
import net.chintai.backend.sysadmin.login.service.bean.MngSessionOutServiceBean;

/**
 * ログイン処理時のセッション情報を提供するサービスクラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MngSessionService {

    /**
     * ユーザIDと送信日をもとに認証を行い、成功した場合にユーザ情報を戻します。
     * @param userId ユーザ情報
     * @param postDate 送信日
     * @return 認証成功時 loginServiceBean, 認証失敗時 null
     */
    public MngSessionOutServiceBean insertMngSession(MngSessionInServiceBean inBean);

    /**
     * ログインに成功した場合管理機能セッション管理テーブルに登録をする。
     * @param user ユーザ情報
     */
    public void deleteMngSession(Long sidId);
}

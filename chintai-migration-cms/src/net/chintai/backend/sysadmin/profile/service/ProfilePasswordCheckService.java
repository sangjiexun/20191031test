/*
 * $Id: ProfilePasswordCheckService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.service;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.profile.service.bean.ProfilePasswordCheckInServiceBean;

/**
 * プロフィールパスワードチェックサービスクラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ProfilePasswordCheckService {

    /**
     * プロフィールパスワードチェックします。
     * @param inServiceBean 検索パラメータ(ユーザID、現在のパスワード)
     * @return 検索結果件数
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public int profilePasswordCheck(ProfilePasswordCheckInServiceBean inServiceBean)
            throws InvocationTargetException, IllegalAccessException;
}
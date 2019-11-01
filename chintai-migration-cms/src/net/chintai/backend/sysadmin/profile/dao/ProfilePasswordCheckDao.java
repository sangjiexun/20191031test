/*
 * $Id: ProfilePasswordCheckDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.dao;

/**
 * プロフィールパスワードチェックDAO
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ProfilePasswordCheckDao {

    /**
     * プロフィールパスワードチェック
     * 
     * @param paramBean チェック条件(ユーザID, 現在のパスワード)
     * @return 検索結果の行数
     */
    public int profilePasswordCheck(ProfilePasswordCheckParamBean paramBean);
}
/*
 * $Id: UserPasswordChangeCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

/**
 * ユーザパスワード変更のDAO
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface UserPasswordChangeCommitDao {

    /**
     * ユーザパスワード変更
     * @param paramBean
     * @return int
     */
    public int userPasswordChange(UserPasswordChangeCommitParamBean paramBean);
}

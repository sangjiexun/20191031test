/*
 * $Id: UserAddCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/20  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

/**
 * ユーザ登録完了処理のDAO
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface UserAddCommitDao {

    /**
     * ユーザ登録完了
     * @param paramBean
     */
    public void userAddCommit(UserAddCommitParamBean paramBean);

    /**
     * CHINTAI問い合せ管理のアクセス権限チェック
     * @param paramBean
     */
    public int cjnAccountCheck(UserAddCommitParamBean paramBean);
}
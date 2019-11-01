/*
 * $Id: ProfilePasswordChangeCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.dao;

/**
 * プロフィルパスワード変更完了のDAO
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ProfilePasswordChangeCommitDao {

    /**
     * プロフィルパスワード変更完了
     * 
     * @param paramBean
     */
    public int profilePasswordChangeCommit(ProfilePasswordChangeCommitParamBean paramBean);
}
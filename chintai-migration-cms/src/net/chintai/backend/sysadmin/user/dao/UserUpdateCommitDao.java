/*
 * $Id: UserUpdateCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

/**
 * ユーザ更新完了のDAO
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface UserUpdateCommitDao {

    /**
     * ユーザ更新を実行します。
     * @param paramBean 更新情報
     * @return 更新に成功した件数
     */
    public int userUpdateCommit(UserUpdateCommitParamBean paramBean);

    /**
     * CHINTAI問い合せ管理のアクセス権限チェックを行いします。
     * @param paramBean 権限チェックに使用するパラメタ
     * @return アクセス可: 1, アクセス不可: 2
     */
    public int cjnAccountCheck(UserUpdateCommitParamBean paramBean);

    /**
     * CHINTAI問い合せ管理のアカウントレベルテーブルのデータを削除します。
     * @param paramBean 削除対象の情報
     * @return 削除に成功した件数
     */
    public int deleteCjnAccountLevel(UserUpdateCommitParamBean paramBean);

}
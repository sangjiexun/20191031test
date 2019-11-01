/*
 * $Id: ReviewReplayCommitDao.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;


/**
 * 返信内容更新DAO
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewReplayCommitDao {

    /**
     * 返信内容を更新します。
     * @param paramBean 更新パラメータ
     */
    public void updateWarningRireki(ReviewReplayCommitParamBean paramBean);


    /**
     * 排他チェック（他人から更新されていないことを確認）
     * @param paramBean roomKey ・最終更新日時
     * @return 件数
     */
    public int selectBukkenReviewReplayStatusCheck(ReviewReplayCommitParamBean paramBean);
}

/*
 * $Id: ReviewReplayConfirmDao.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

import net.chintai.backend.sysadmin.review.domain.ReviewReplayDomain;


/**
 * 返信入力確認DAO
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewReplayConfirmDao {

    /**
     * 物件情報を検索
     * @param paramBean 検索パラメータ
     * @return 物件情報
     */
    public ReviewReplayDomain getReplayBukkenInfo(ReviewReplayConfirmParamBean paramBean);
}
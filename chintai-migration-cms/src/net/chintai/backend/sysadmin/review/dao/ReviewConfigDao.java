/*
 * $Id: ReviewConfigDao.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

import java.util.List;

import net.chintai.backend.sysadmin.review.domain.ReviewAutoDelDomain;
import net.chintai.backend.sysadmin.review.domain.ReviewConfigDomain;
import net.chintai.backend.sysadmin.review.domain.ReviewMadoriTypeDomain;
import net.chintai.backend.sysadmin.review.domain.ReviewPrefConfigDomain;

/**
 * 審査設定内容情報を取得するDAO。
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewConfigDao {

    /**
     * 審査設定内容情報を取得します。
     * @return 審査内容情報リスト
     */
    public List<ReviewConfigDomain> selectReviewConfig();

    /**
     * 審査設定内容情報を取得します。
     * @return 審査内容情報リスト
     */
    public List<ReviewMadoriTypeDomain> selectMadoriConfig();

    /**
     * 審査設定内容情報を取得します。
     * @return 審査内容情報リスト
     */
    public List<ReviewAutoDelDomain> selectAutoDelConfig();

    /**
     * 審査設定内容情報を取得します。
     * @return 審査内容情報リスト
     */
    public List<ReviewPrefConfigDomain> selectPrefConfig();
}

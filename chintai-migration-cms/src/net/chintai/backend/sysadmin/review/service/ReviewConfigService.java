/*
 * $Id: ReviewConfigService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service;

import java.util.List;

import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigOutServiceBean;

/**
 * 審査設定内容情報を取得するサービス。
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewConfigService {

    /**
     * 審査設定内容情報を取得します。<br>
     * @return 審査内容情報リスト
     */
    public List<ReviewConfigOutServiceBean.ShinsaDatailBean> getReviewConfigInfo();

    /**
     * 間取りタイプ設定内容情報を取得します。<br>
     * @return 間取りタイプ設定内容情報リスト
     */
    public List<ReviewConfigOutServiceBean.MadoriDetailBean> getMadoriConfigInfo();

    /**
     * 自動削除設定内容情報を取得します。<br>
     * @return 自動削除設定内容情報リスト
     */
    public List<ReviewConfigOutServiceBean.AutoDelDetailBean> getAutoDelConfigInfo();

    /**
     * 市区町村設定内容情報を取得します。<br>
     * @return 市区町村設定内容情報リスト
     */
    public List<ReviewConfigOutServiceBean.PrefDetailBean> getPrefConfigInfo();
}

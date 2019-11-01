/*
 * $Id: ReviewBukkenSearchService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenSearchInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenSearchOutServiceBean;

/**
 * 物件検索サービスを提供します。
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewBukkenSearchService {

    /**
     * 物件検索結果一覧情報リストを取得します。<br>
     * @param condition ページング条件
     * @param inBean 検索条件
     * @return 警告対象物件一覧情報リスト
     */
    public List<ReviewBukkenSearchOutServiceBean> getBukkenSearchList(
            ReviewBukkenSearchInServiceBean inBean, BasePagerCondition condition);
}

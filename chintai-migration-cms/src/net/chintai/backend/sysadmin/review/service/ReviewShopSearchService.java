/*
 * $Id: ReviewShopSearchService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopSearchInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopSearchOutServiceBean;

/**
 * 店舗検索サービスを提供します。
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewShopSearchService {

    /**
     * 店舗検索結果を取得します。<br>
     * @param inBean 検索パラメータ
     * @return 検索結果リスト
     */
    public List<ReviewShopSearchOutServiceBean> getShopSearchList(
            ReviewShopSearchInServiceBean inBean, BasePagerCondition condition);

}

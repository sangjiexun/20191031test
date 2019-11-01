/*
 * $Id: ReviewShopMediaCountService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopMediaCountInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopMediaCountOutServiceBean;

/**
 * 店舗別出稿状況集計サービスクラス。
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewShopMediaCountService {

    /**
     * 店舗別出稿状況集計情報を提供します<br>
     * @param inBean 検索パラメータ
     * @return 店舗別出稿状況集計情報リスト
     */
    public List<ReviewShopMediaCountOutServiceBean> getShopMediaCount(
            ReviewShopMediaCountInServiceBean inBean, BasePagerCondition condition);

    /**
     * 集計時間を取得します<br>
     * @return 集計時間
     */
    public ReviewShopMediaCountOutServiceBean selectCntTime();
}

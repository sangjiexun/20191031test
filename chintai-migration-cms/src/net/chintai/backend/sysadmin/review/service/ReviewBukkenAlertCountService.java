/*
 * $Id: ReviewBukkenAlertCountService.java 3679 2007-12-20 04:49:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenAlertCountInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenAlertCountOutServiceBean;

/**
 * 警告対象物件一覧情報を提供するサービスクラス。
 *
 * @author lee-hosup
 * @version $Revision: 3679 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewBukkenAlertCountService {

    /**
     * 警告対象物件一覧情報リストを取得します。<br>
     * @param condition ページング条件
     * @param inBean 検索条件
     * @return 警告対象物件一覧情報リスト
     */
    public List<ReviewBukkenAlertCountOutServiceBean> getBukkenAlertCount(
            ReviewBukkenAlertCountInServiceBean inBean, BasePagerCondition condition);
}

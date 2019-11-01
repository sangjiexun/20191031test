/*
 * $Id: ReviewBukkenWebStatusUpdatePageService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/19  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service;

import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenWebStatusUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenWebStatusUpdatePageOutServiceBean;

/**
 * CHINTAI.NET掲載情報変更サービス
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewBukkenWebStatusUpdatePageService {

    /**
     * CHINTAI.NET掲載情報変更画面に表示する情報を取得
     * @param inBean 検索パラメータ
     * @return CHINTAI.NET掲載情報情報
     */
    ReviewBukkenWebStatusUpdatePageOutServiceBean getBukkenWebStatusInfo(
            ReviewBukkenWebStatusUpdatePageInServiceBean inBean);

}

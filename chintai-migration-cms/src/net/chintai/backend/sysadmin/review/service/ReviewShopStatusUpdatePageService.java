/*
 * $Id: ReviewShopStatusUpdatePageService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service;

import net.chintai.backend.sysadmin.review.service.bean.ReviewShopStatusUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopStatusUpdatePageOutServiceBean;

/**
 * 店舗対象外設定変更サービス
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewShopStatusUpdatePageService {

    /**
     * 店舗基本情報、対象外設定情報を取得します。
     * @param inBean 検索パラメータ（店舗コード）
     * @return 検索結果
     */
    public ReviewShopStatusUpdatePageOutServiceBean getShopStatusUpdateInfo(
            ReviewShopStatusUpdatePageInServiceBean inBean);
}

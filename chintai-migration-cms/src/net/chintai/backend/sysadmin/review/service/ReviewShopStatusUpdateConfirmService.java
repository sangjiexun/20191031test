/*
 * $Id: ReviewShopStatusUpdateConfirmService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service;

import net.chintai.backend.sysadmin.review.service.bean.ReviewShopStatusUpdateConfirmInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopStatusUpdateConfirmOutServiceBean;

/**
 * 店舗対象外設定変更画面の表示情報を取得
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewShopStatusUpdateConfirmService {

    /**
     * 店舗情報を取得する。
     * @param inBean 検索パラメータ(店舗コード)
     * @return 店舗情報
     */
    public ReviewShopStatusUpdateConfirmOutServiceBean getShopInfo(
            ReviewShopStatusUpdateConfirmInServiceBean inBean);
}

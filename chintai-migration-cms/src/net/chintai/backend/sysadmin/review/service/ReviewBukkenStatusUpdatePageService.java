/*
 * $Id: ReviewBukkenStatusUpdatePageService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/17  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service;

import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenStatusUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenStatusUpdatePageOutServiceBean;


/**
 * 物件対象外設定変更画面サービス
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewBukkenStatusUpdatePageService {

    /**
     * 物件対象外設定変更画面に表示する情報を取得
     * @param inBean 検索パラメータ
     * @return 物件対象外設定情報
     */

    public ReviewBukkenStatusUpdatePageOutServiceBean getBukkenStatusInfo(
            ReviewBukkenStatusUpdatePageInServiceBean inBean);
}

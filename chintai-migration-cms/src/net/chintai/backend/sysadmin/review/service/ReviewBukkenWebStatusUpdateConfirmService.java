/*
 * $Id: ReviewBukkenWebStatusUpdateConfirmService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/19  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenWebStatusUpdateConfirmInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenWebStatusUpdateConfirmOutServiceBean;

/**
 * CHINTAI.NET掲載状況変更確認サービス
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewBukkenWebStatusUpdateConfirmService {

    /**
     * 物件対象外設定確認画面に表示する物件情報を取得
     * @param inBean 検索パラメータ
     * @return 物件情報
     */

    public ReviewBukkenWebStatusUpdateConfirmOutServiceBean getBukkenInfo(
            ReviewBukkenWebStatusUpdateConfirmInServiceBean inBean)  throws ApplicationException;
}

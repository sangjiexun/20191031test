/*
 * $Id: ReviewBukkenStatusUpdateCommitService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/18  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenStatusUpdateCommitInServiceBean;

/**
 * 物件対象外設定更新サービス。
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewBukkenStatusUpdateCommitService {

    /**
     * 物件対象外設定を更新します。
     * @param inBean 更新パラメータ
     * @throws ApplicationException
     */
    public void updateBukkenStatus(ReviewBukkenStatusUpdateCommitInServiceBean inBean)
            throws ApplicationException;

}

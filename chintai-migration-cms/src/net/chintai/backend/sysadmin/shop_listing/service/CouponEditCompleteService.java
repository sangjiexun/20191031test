/*
 * $Id: CouponEditCompleteService.java 4248 2009-03-24 01:59:32Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/05     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service;

import net.chintai.backend.sysadmin.shop_listing.service.bean.CouponEditCompleteInServiceBean;

/**
 * クーポン情報編集完了サービス
 *
 * @author Lee Hosup
 * @version $Revision: 4248 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CouponEditCompleteService {

    /**
     * クーポン情報を編集します。
     *
     * @param inBean
     */
    public void editCouponInfo(CouponEditCompleteInServiceBean inBean);

}

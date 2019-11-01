/*
 * $Id: ShopRegistrationStatusUpdatePageService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopRegistrationStautsUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopRegistrationStautsUpdatePageOutServiceBean;

/**
 * 登録状況更新データの照会を提供するサービスクラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopRegistrationStatusUpdatePageService {

    /**
     * 登録状況更新データの照会する。
     * 
     * @param inServiceBean 店舗コード
     * @return 登録状況
     * @throws ApplicationException
     */
    public ShopRegistrationStautsUpdatePageOutServiceBean shopRegistrationStautsSearchByShopCd(
            ShopRegistrationStautsUpdatePageInServiceBean inServiceBean)
            throws ApplicationException;

}

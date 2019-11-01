/*
 * $Id: ShopInfoService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoOutServiceBean;

/**
 * 不動産ASPを設定するときに使用する店舗基本情報を照会するサビースクラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopInfoService {

    /**
     * 不動産ASPを設定するときに使用する店舗基本情報を照会する。
     * 
     * @param inServiceBean 店舗コード
     * @return 店舗基本情報
     * @throws Exception
     */
    public AspShopInfoOutServiceBean aspShopInfoSearchByShopCd(
            AspShopInfoInServiceBean inServiceBean) throws Exception;

}

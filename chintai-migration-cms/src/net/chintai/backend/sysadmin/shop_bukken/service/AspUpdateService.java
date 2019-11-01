/*
 * $Id: AspUpdateService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateOutServiceBean;

/**
 * 更新する不動産ASP情報を照会するService。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspUpdateService {

    /**
     * 更新する不動産ASP情報を照会する。
     * 
     * @param inServiceBean 店舗コード
     * @return 更新する不動産ASP情報
     * @throws Exception
     */
    public AspUpdateOutServiceBean aspShopInfoSearchByShopCd(AspUpdateInServiceBean inServiceBean)
            throws Exception;

}

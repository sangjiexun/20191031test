package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingUpdatePageOutServiceBean;


/**
 * 店舗リスティング設定情報更新
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopListingUpdagePageService {

    /**
     * 店舗リスティング設定情報を登録します。
     * @param inBean 登録パラメータ
     * @throws ApplicationException
     */
    public ShopListingUpdatePageOutServiceBean getShopListing(ShopListingUpdatePageInServiceBean inBean) throws ApplicationException;
}

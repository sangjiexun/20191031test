package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingUpdateCommitInServiceBean;

/**
 * 店舗リスティング設定情報更新
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopListingUpdateCommitService {

    /**
     * 店舗リスティング設定情報を更新します。
     * @param inBean 更新パラメータ
     * @throws ApplicationException
     */
    public void updateShopListing(ShopListingUpdateCommitInServiceBean inBean)
            throws ApplicationException;
}

package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingAddCommitInServiceBean;


/**
 * 店舗リスティング設定情報登録
 *
 * @author 
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopListingAddCommitService {

    /**
     * 店舗リスティング設定情報を登録します。
     * @param inBean 登録パラメータ
     * @throws ApplicationException
     */
    public void insertShopListing(ShopListingAddCommitInServiceBean inBean) throws ApplicationException;
}

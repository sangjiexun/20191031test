package net.chintai.backend.sysadmin.shop_bukken.service;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingDeleteConfirmInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingDeleteConfirmOutServiceBean;

/**
 * 削除する店舗リスティング情報を取得
 *
 * @author 
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopListingDeleteConfirmService {

    /**
     * 削除する店舗リスティング情報を取得
     * @param inBean 検索パラメータ（取引先シーケンス番号、適用月）
     * @return 店舗リスティング情報
     */
    public List<ShopListingDeleteConfirmOutServiceBean>  getShopListingForDelete(
            ShopListingDeleteConfirmInServiceBean inBean);
}

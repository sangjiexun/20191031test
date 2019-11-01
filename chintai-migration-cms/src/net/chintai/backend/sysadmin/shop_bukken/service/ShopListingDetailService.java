package net.chintai.backend.sysadmin.shop_bukken.service;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingOutServiceBean;

/**
 * 店舗リスティング情報を取得
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopListingDetailService {

    /**
     * 店舗リスティング情報を取得します。
     * @param inBean 検索パラメータ（契約管理コード、契約管理オプションコード、店舗コード）
     * @return 店舗リスティング情報
     */
    public List<ShopListingOutServiceBean> getShopListingDetail(
            ShopListingInServiceBean inBean);

}

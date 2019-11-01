package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInfoOutServiceBean;

/**
 * 契約情報取得
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopListingInfoService {

    /**
     * 契約情報を検索
     * @param inBean 検索パラメータ（店舗コード）
     * @return 店舗リスティング情報
     * @throws ApplicationException
     */
    public ShopListingInfoOutServiceBean getContractInfo(
            ShopListingInfoInServiceBean inBean) throws ApplicationException;


    /**
     * @param keiyakuCd
     * @param keiyakuSubCd
     * @return
     */
    public String isWakuDisp(String keiyakuCd, String keiyakuSubCd);
}

package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingDeleteCommitInServiceBean;

/**
 * 店舗リスティング設定情報を削除処理
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopListingDeleteCommitService {

    /**
     * 店舗リスティング設定情報を削除します。
     * @param inBean 削除処理パラメータ（契約番号）
     * @throws ApplicationException
     */
    public void deleteKeiyakuInfo(ShopListingDeleteCommitInServiceBean inBean)
            throws ApplicationException;

}

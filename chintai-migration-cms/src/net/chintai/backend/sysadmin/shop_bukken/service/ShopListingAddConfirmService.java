package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingAddConfirmInServiceBean;

/**
 * 店舗リスティング新規登録確認
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopListingAddConfirmService {

    /**
     * 登録する店舗リスティング情報と同じ適用月のデータがあるかを確認
     * @param inBean 登録パラメータ（取引先シーケンス、適用月）
     * @throws ApplicationException 重複データが存在した場合
     */
    public void countApplyYmdh(ShopListingAddConfirmInServiceBean inBean)
            throws ApplicationException;
}

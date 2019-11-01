package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountAddConfirmInServiceBean;

/**
 * 物件枠新規登録確認
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractAmountAddConfirmService {

    /**
     * 登録する物件枠情報と同じ適用月のデータがあるかを確認
     * @param inBean 登録パラメータ（取引先シーケンス、適用月）
     * @throws ApplicationException
     */
    public void countApplyYmdh(ContractAmountAddConfirmInServiceBean inBean)
            throws ApplicationException;
}

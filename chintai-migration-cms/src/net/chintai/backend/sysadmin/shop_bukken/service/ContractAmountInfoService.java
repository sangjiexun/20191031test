package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountInfoOutServiceBean;

/**
 * 契約情報取得
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractAmountInfoService {

    /**
     * 契約情報を検索
     * @param inBean 検索パラメータ（店舗コード）
     * @return 取引先詳細情報
     * @throws ApplicationException
     */
    public ContractAmountInfoOutServiceBean getContractInfo(
            ContractAmountInfoInServiceBean inBean) throws ApplicationException;
}

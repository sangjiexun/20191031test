package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountUpdateCommitInServiceBean;

/**
 * 契約明細詳細(契約数量あり)設定情報更新
 *
 * @author 
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractAmountUpdateCommitService {

    /**
     * 契約明細詳細(契約数量あり)設定情報を更新します。
     * @param inBean 更新パラメータ
     * @throws ApplicationException
     */
    public void updateContractAmount(ContractAmountUpdateCommitInServiceBean inBean)
            throws ApplicationException;
}

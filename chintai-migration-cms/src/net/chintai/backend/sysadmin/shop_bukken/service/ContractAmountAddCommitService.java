package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountAddCommitInServiceBean;


/**
 * 契約明細詳細(契約数量あり)設定情報登録
 *
 * @author 
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractAmountAddCommitService {

    /**
     * 物件枠設定情報を登録します。
     * @param inBean 登録パラメータ
     * @throws ApplicationException
     */
    public void insertContractAmount(ContractAmountAddCommitInServiceBean inBean) throws ApplicationException;
}

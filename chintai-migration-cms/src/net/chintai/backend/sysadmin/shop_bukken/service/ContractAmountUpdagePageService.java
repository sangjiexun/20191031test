package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountUpdatePageOutServiceBean;


/**
 * 契約明細詳細(契約数量あり)設定情報更新
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractAmountUpdagePageService {

    /**
     * 物件枠設定情報を登録します。
     * @param inBean 登録パラメータ
     * @throws ApplicationException
     */
    public ContractAmountUpdatePageOutServiceBean getContractAmount(ContractAmountUpdatePageInServiceBean inBean) throws ApplicationException;
}

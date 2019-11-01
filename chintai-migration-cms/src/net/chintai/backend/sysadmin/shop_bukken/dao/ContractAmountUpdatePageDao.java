package net.chintai.backend.sysadmin.shop_bukken.dao;

import net.chintai.backend.sysadmin.shop_bukken.domain.ContractAmountDomain;

/**
 * 契約明細詳細(契約数量あり)設定情報取得DAO
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractAmountUpdatePageDao {

    /**
     * 枠情報を取得します。
     * @param paramBean 検索パラメータ（取引先シーケンス番号、適用月）
     * @return 物件枠情報
     */
    public ContractAmountDomain getContractAmount(
            ContractAmountUpdatePageParamBean paramBean);

}

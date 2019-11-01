package net.chintai.backend.sysadmin.shop_bukken.dao;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.domain.ContractAmountDomain;

/**
 * 契約明細詳細(契約数量あり)設定情報確認DAO
 *
 * @author 
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractAmountDeleteConfirmDao {

    /**
     * 削除する契約明細詳細(契約数量あり)情報を取得
     * @param paramBean 検索パラメータ（取引先シーケンス番号、適用月）
     * @return 契約明細詳細(契約数量あり)情報
     */
    public List<ContractAmountDomain> getContractAmountForDelete(
            ContractAmountDeleteConfirmParamBean paramBean);

}

package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 契約明細詳細(契約数量あり)設定情報更新DAO
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractAmountUpdateCommitDao {

    /**
     * 契約明細詳細(契約数量あり)設定情報を更新します。
     * @param paramBean 更新パラメータ
     * @return 更新件数
     */
    public int updateContractAmount(ContractAmountUpdateCommitParamBean paramBean);

}

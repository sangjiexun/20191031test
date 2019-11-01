package net.chintai.backend.sysadmin.shop_bukken.dao;



/**
 * 契約明細詳細(契約数量あり)設定情報更新DAO
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractAmountAddCommitDao {

    /**
     * 契約情報を登録します。
     * @param paramBean 登録パラメータ
     */
    public String insertContractAmount(ContractAmountAddCommitParamBean paramBean);

    /**
     * 契約明細を登録します。
     * @param paramBean 登録パラメータ
     */
    public void insertContractAmountDetail(ContractAmountAddCommitParamBean paramBean);

}

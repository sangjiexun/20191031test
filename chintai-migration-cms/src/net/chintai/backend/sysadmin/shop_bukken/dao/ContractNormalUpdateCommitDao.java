package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 契約明細設定（数量なし）完了DAO
 *
 * @author m-kashiyama
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractNormalUpdateCommitDao {

    /**
     * 契約明細設定（数量なし）過去契約情報の契約終了日の設定完了
     *
     * @param paramBean
     * @return int
     */
    public int contractNormalUpdateCommit(ContractNormalUpdateCommitParamBean paramBean);

    /**
     * 契約明細設定（数量なし）の新規契約情報の登録完了
     * @param paramBean
     * @return Long 契約番号
     */
    public Long contractNormalAddCommit(ContractNormalUpdateCommitParamBean paramBean);

}
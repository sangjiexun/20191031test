package net.chintai.backend.sysadmin.shop_bukken.dao;

import net.chintai.backend.sysadmin.shop_bukken.domain.ContractNormal;

/**
 * 契約明細設定（数量なし）画面に遷移Dao
 *
 * @author m-kashiyama
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractNormalUpdatePageDao {

    /**
     * 契約明細設定（数量なし）画面に遷移
     * @param paramBean
     * @return ContractNormal
     */
    public ContractNormal contractNormalkUpdatePage(ContractNormalUpdatePageParamBean paramBean);
}
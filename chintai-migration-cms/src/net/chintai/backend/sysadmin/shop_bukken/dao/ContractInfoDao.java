package net.chintai.backend.sysadmin.shop_bukken.dao;

import net.chintai.backend.sysadmin.shop_bukken.domain.ContractInfo;



/**
 * 契約明細設定（数量なし）を設定するときに使用するDAO。。
 *
 * @author m-kashiyama
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractInfoDao {

    /**
     * 不動産ASPを設定するときに登録された不動産ASPの契約情報を照会する。
     *
     * @param paramBean 店舗コード
     * @return 契約情報
     */
    public ContractInfo selectShopContractInfo(ContractInfoParameterBean paramBean);
}

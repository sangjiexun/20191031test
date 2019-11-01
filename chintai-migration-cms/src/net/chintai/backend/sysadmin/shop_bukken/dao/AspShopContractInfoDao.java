package net.chintai.backend.sysadmin.shop_bukken.dao;



/**
 * 不動産ASPを設定するときに使用するDAO。
 *
 * @author m-kashiyama
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspShopContractInfoDao {

    /**
     * 不動産ASPを設定するときに登録された不動産ASPの契約情報を照会する。
     *
     * @param paramBean 店舗コード
     * @return 不動産ASPの契約情報
     */
    public Object selectAspShopContractInfo(AspShopContractInfoParameterBean paramBean);
}

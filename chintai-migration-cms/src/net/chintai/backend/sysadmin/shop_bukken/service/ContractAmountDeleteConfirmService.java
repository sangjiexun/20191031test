package net.chintai.backend.sysadmin.shop_bukken.service;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountDeleteConfirmInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountDeleteConfirmOutServiceBean;

/**
 * 削除する契約明細詳細(契約数量あり)情報を取得
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractAmountDeleteConfirmService {

    /**
     * 削除する契約明細詳細(契約数量あり)情報を取得
     * @param inBean 検索パラメータ（取引先シーケンス番号、適用月）
     * @return 契約明細詳細(契約数量あり)情報
     */
    public List<ContractAmountDeleteConfirmOutServiceBean>  getContractAmountForDelete(
            ContractAmountDeleteConfirmInServiceBean inBean);
}

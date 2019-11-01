package net.chintai.backend.sysadmin.shop_bukken.service;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountOutServiceBean;

/**
 * 物件枠情報を取得
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractAmountDetailService {

    /**
     * 物件枠情報を取得します。
     * @param inBean 検索パラメータ（契約管理コード、契約管理オプションコード、店舗コード）
     * @return 物件枠情報
     */
    public List<ContractAmountOutServiceBean> getContractAmountDetail(
            ContractAmountInServiceBean inBean);

}

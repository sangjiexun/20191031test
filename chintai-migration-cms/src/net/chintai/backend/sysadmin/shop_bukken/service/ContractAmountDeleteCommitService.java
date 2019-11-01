package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountDeleteCommitInServiceBean;

/**
 * 契約明細詳細(契約数量あり)設定情報を削除処理
 *
 * @author 
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractAmountDeleteCommitService {

    /**
     * 物件枠設定情報を削除します。
     * @param inBean 削除処理パラメータ（取引先シーケンス番号、適用月、最終更新日時）
     * @throws ApplicationException
     */
    public void deleteWakuInfo(ContractAmountDeleteCommitInServiceBean inBean)
            throws ApplicationException;

}

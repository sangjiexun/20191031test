package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 契約明細詳細(契約数量あり)設定情報確認DAO
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractAmountAddConfirmDao {

    /**
     * 登録する物件枠情報と同じ適用月のデータがあるかを確認
     * @param paramBean 登録パラメータ（取引先シーケンス、適用月）
     * @return 検索結果件数
     */
    public int checkAppliyYmdh(ContractAmountAddConfirmParamBean paramBean);
}

package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 契約明細詳細(契約数量あり)設定削除確認
 *
 * @author
 * @version $Revision: $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountDeleteConfirmInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** 契約コード */
    private String keiyakuCd;

    /** 契約サブコード */
    private String keiyakuSubCd;

    /** 削除する適用月リスト */
    private String[] delFlgList;

    /**
     * shopCdを返します。
     *
     * @return shopCd
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * を設定します。
     *
     * @param shopCd
     *            shopCd
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * keiyakuCdを返します。
     *
     * @return keiyakuCd
     */
    public String getKeiyakuCd() {
        return keiyakuCd;
    }

    /**
     * を設定します。
     *
     * @param keiyakuCd
     *            keiyakuCd
     */
    public void setKeiyakuCd(String keiyakuCd) {
        this.keiyakuCd = keiyakuCd;
    }

    /**
     * keiyakuSubCdを返します。
     *
     * @return keiyakuSubCd
     */
    public String getKeiyakuSubCd() {
        return keiyakuSubCd;
    }

    /**
     * を設定します。
     *
     * @param keiyakuSubCd
     *            keiyakuSubCd
     */
    public void setKeiyakuSubCd(String keiyakuSubCd) {
        this.keiyakuSubCd = keiyakuSubCd;
    }

    /**
     * 削除する適用月リストを取得します。
     *
     * @return 削除する適用月リスト
     */
    public String[] getDelFlgList() {
        return delFlgList;
    }

    /**
     * 削除する適用月リストを設定します。
     *
     * @param delFlgList
     *            削除する適用月リスト
     */
    public void setDelFlgList(String[] delFlgList) {
        this.delFlgList = delFlgList;
    }
}

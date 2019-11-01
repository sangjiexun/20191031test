package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 店舗リスティング設定情報削除
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingDeleteCommitParamBean {

    /** 契約番号  */
    private String keiyakuNo;

    /**
     *  契約番号を返します。
     * @return  契約番号
     */
    public String getKeiyakuNo() {
        return keiyakuNo;
    }

    /**
     *  契約番号を設定します。
     * @param keiyakuNo   契約番号
     */
    public void setKeiyakuNo(String keiyakuNo) {
        this.keiyakuNo = keiyakuNo;
    }
}

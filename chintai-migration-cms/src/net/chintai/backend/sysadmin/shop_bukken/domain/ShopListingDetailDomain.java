package net.chintai.backend.sysadmin.shop_bukken.domain;

/**
 * 店舗リスティング詳細情報
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingDetailDomain {

	/** 物件枠 */
    private String wakuCnt;

    /** 契約番号 */
    private Long keiyakuNo;

    /** 店舗コード */
    private String shopCd;

    /** 契約コード*/
    private String keiyakuCd;

    /** 契約オプションコード */
    private String keiyakuSubCd;

    /** 備考 */
    private String keiyakuNote;

    /** 契約開始日時 */
    private String keiyakuStartDt;

    /** 契約終了日時 */
    private String keiyakuEndDt;

    /** 更新日時 */
    private String updDt;

    /** 予約元区分 */
    private String reserveKbn;


    /**
     * 契約番号を返します。
     * @return keiyakuNo
     */
    public Long getKeiyakuNo() {
        return keiyakuNo;
    }

    /**
     * 契約番号を設定します。
     * @param keiyakuNo  契約番号
     */
    public void setKeiyakuNo(Long keiyakuNo) {
        this.keiyakuNo = keiyakuNo;
    }

    /**
     * 店舗コードを返します。
     * @return shopCd
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     * @param shopCd  店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 契約コードを返します。
     * @return 契約コード
     */
    public String getKeiyakuCd() {
        return keiyakuCd;
    }

    /**
     * 契約コードを設定します。
     * @param keiyakuCd  契約コード
     */
    public void setKeiyakuCd(String keiyakuCd) {
        this.keiyakuCd = keiyakuCd;
    }

    /**
     *  契約オプションコードを返します。
     * @return  契約オプションコード
     */
    public String getKeiyakuSubCd() {
        return keiyakuSubCd;
    }

    /**
     *  契約オプションコードを設定します。
     * @param keiyakuSubCd   契約オプションコード
     */
    public void setKeiyakuSubCd(String keiyakuSubCd) {
        this.keiyakuSubCd = keiyakuSubCd;
    }

    /**
     * 備考を返します。
     * @return 備考
     */
    public String getKeiyakuNote() {
        return keiyakuNote;
    }

    /**
     * 備考を設定します。
     * @param keiyakuNote  備考
     */
    public void setKeiyakuNote(String keiyakuNote) {
        this.keiyakuNote = keiyakuNote;
    }

    /**
     * 契約開始日時を返します。
     * @return 契約開始日時
     */
    public String getKeiyakuStartDt() {
        return keiyakuStartDt;
    }

    /**
     * 契約開始日時を設定します。
     * @param keiyakuStartDt  契約開始日時
     */
    public void setKeiyakuStartDt(String keiyakuStartDt) {
        this.keiyakuStartDt = keiyakuStartDt;
    }

    /**
     * 契約終了日時を返します。
     * @return 契約終了日時
     */
    public String getKeiyakuEndDt() {
        return keiyakuEndDt;
    }

    /**
     * 契約終了日時を設定します。
     * @param keiyakuEndDt  keiyakuEndDt
     */
    public void setKeiyakuEndDt(String keiyakuEndDt) {
        this.keiyakuEndDt = keiyakuEndDt;
    }

    /**
     * 更新日時を返します。
     * @return updDt
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 更新日時を設定します。
     * @param updDt  更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

	public String getReserveKbn() {
		return reserveKbn;
	}

	public void setReserveKbn(String reserveKbn) {
		this.reserveKbn = reserveKbn;
	}

	public String getWakuCnt() {
		return wakuCnt;
	}

	public void setWakuCnt(String wakuCnt) {
		this.wakuCnt = wakuCnt;
	}

}

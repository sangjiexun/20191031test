package net.chintai.backend.sysadmin.shop_bukken.domain;

/**
 * 契約明細（数量あり）情報
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountDomain {

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

	public String getWakuCnt() {
		return wakuCnt;
	}

	public void setWakuCnt(String wakuCnt) {
		this.wakuCnt = wakuCnt;
	}

	public Long getKeiyakuNo() {
		return keiyakuNo;
	}

	public void setKeiyakuNo(Long keiyakuNo) {
		this.keiyakuNo = keiyakuNo;
	}

	public String getShopCd() {
		return shopCd;
	}

	public void setShopCd(String shopCd) {
		this.shopCd = shopCd;
	}

	public String getKeiyakuCd() {
		return keiyakuCd;
	}

	public void setKeiyakuCd(String keiyakuCd) {
		this.keiyakuCd = keiyakuCd;
	}

	public String getKeiyakuSubCd() {
		return keiyakuSubCd;
	}

	public void setKeiyakuSubCd(String keiyakuSubCd) {
		this.keiyakuSubCd = keiyakuSubCd;
	}

	public String getKeiyakuNote() {
		return keiyakuNote;
	}

	public void setKeiyakuNote(String keiyakuNote) {
		this.keiyakuNote = keiyakuNote;
	}

	public String getKeiyakuStartDt() {
		return keiyakuStartDt;
	}

	public void setKeiyakuStartDt(String keiyakuStartDt) {
		this.keiyakuStartDt = keiyakuStartDt;
	}

	public String getKeiyakuEndDt() {
		return keiyakuEndDt;
	}

	public void setKeiyakuEndDt(String keiyakuEndDt) {
		this.keiyakuEndDt = keiyakuEndDt;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	public String getReserveKbn() {
		return reserveKbn;
	}

	public void setReserveKbn(String reserveKbn) {
		this.reserveKbn = reserveKbn;
	}


}

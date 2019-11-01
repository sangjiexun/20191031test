package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 店舗リスティング情報(削除確認用)
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingDeleteConfirmOutServiceBean {

    /** 契約番号 */
    private Long keiyakuNo;

    /** 契約開始日時 */
    private String keiyakuStartDt;

    /** 契約終了日時 */
    private String keiyakuEndDt;

    /** 契約開始日時表示用 */
    private String keiyakuStartYmForDisplay;

    /** 契約終了日時表示用 */
    private String keiyakuEndYmForDisplay;

    /** 更新日時 */
    private String updDt;

    /** 備考 */
    private String keiyakuNote;

    /** 予約元区分 */
    private String reserveKbn;

    /** 物件枠 */
    private String wakuCnt;

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
     * 契約開始日時表示用を返します。
     * @return 契約開始日時表示用
     */
    public String getKeiyakuStartYmForDisplay() {
        return keiyakuStartYmForDisplay;
    }

    /**
     * 契約開始日時表示用を設定します。
     * @param keiyakuStartYmForDisplay  契約開始日時表示用
     */
    public void setKeiyakuStartYmForDisplay(String keiyakuStartYmForDisplay) {
        this.keiyakuStartYmForDisplay = keiyakuStartYmForDisplay;
    }

    /**
     * 契約終了日時表示用を返します。
     * @return 契約終了日時表示用
     */
    public String getKeiyakuEndYmForDisplay() {
        return keiyakuEndYmForDisplay;
    }

    /**
     * 契約終了日時表示用を設定します。
     * @param keiyakuEndYmForDisplay  契約終了日時表示用
     */
    public void setKeiyakuEndYmForDisplay(String keiyakuEndYmForDisplay) {
        this.keiyakuEndYmForDisplay = keiyakuEndYmForDisplay;
    }

    /**
     * 最終更新日を取得します。
     * @return 最終更新日
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日を設定します。
     * @param updDt 最終更新日
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
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

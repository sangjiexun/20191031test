package net.chintai.backend.sysadmin.master.service.bean;

public class RendoSendListOutServiceBean {
    /** 連動元コード */
    private String rendoCd;

    /** 連動元名称 */
    private String rendoName;

    /** 連動会社名 */
    private String rendoCompany;

    /** 契約管理コード */
    private String keiyakuCd;

    /** 契約管理オプションコード */
    private String keiyakuSubCd;

    /** 連動元出稿表示名 */
    private String rendoSendDispName;

    /** 予約数 **/
    private String reserveCnt;

    /** 契約フラグ */
    private String permitFlg;

    /**
     * 連動元コードを取得します。
     * @return 連動元コード
     */
    public String getRendoCd() {
        return rendoCd;
    }

    /**
     * 連動元コードを設定します。
     * @param rendoCd 連動元コード
     */
    public void setRendoCd(String rendoCd) {
        this.rendoCd = rendoCd;
    }

    /**
     * 連動元名称を取得します。
     * @return 連動元名称
     */
    public String getRendoName() {
        return rendoName;
    }

    /**
     * 連動元名称を設定します。
     * @param rendoName 連動元名称
     */
    public void setRendoName(String rendoName) {
        this.rendoName = rendoName;
    }

    /**
     * 連動会社名を取得します。
     * @return 連動会社名
     */
    public String getRendoCompany() {
        return rendoCompany;
    }

    /**
     * 連動会社名を設定します。
     * @param rendoCompany 連動会社名
     */
    public void setRendoCompany(String rendoCompany) {
        this.rendoCompany = rendoCompany;
    }

    /**
     * 契約管理コードを取得します。
     * @return 契約管理コード
     */
    public String getKeiyakuCd() {
        return keiyakuCd;
    }

    /**
     * 契約管理コードを設定します。
     * @param keiyakuCd 契約管理コード
     */
    public void setKeiyakuCd(String keiyakuCd) {
        this.keiyakuCd = keiyakuCd;
    }

    /**
     * 契約管理オプションコードを取得します。
     * @return 契約管理オプションコード
     */
    public String getKeiyakuSubCd() {
        return keiyakuSubCd;
    }

    /**
     * 契約管理オプションコードを設定します。
     * @param keiyakuSubCd 契約管理オプションコード
     */
    public void setKeiyakuSubCd(String keiyakuSubCd) {
        this.keiyakuSubCd = keiyakuSubCd;
    }

    /**
     * 契約フラグを取得します。
     * @return 契約フラグ
     */
    public String getPermitFlg() {
        return permitFlg;
    }

    /**
     * 契約フラグを設定します。
     * @param permitFlg 契約フラグ
     */
    public void setPermitFlg(String permitFlg) {
        this.permitFlg = permitFlg;
    }

	/**
	 * 予約数を取得します。
	 * @return 予約数
	 */
	public String getReserveCnt() {
		return reserveCnt;
	}

	/**
	 * 予約数を設定します。
	 * @param reserveCnt 予約数
	 */
	public void setReserveCnt(String reserveCnt) {
		this.reserveCnt = reserveCnt;
	}

    /**
     * 連動元出稿表示名を取得します。
     * @return 連動元出稿表示名
     */
    public String getRendoSendDispName() {
        return rendoSendDispName;
    }

    /**
     * 連動元出稿表示名を設定します。
     * @param rendoSendDispName 連動元出稿表示名
     */
    public void setRendoSendDispName(String rendoSendDispName) {
        this.rendoSendDispName = rendoSendDispName;
    }
}
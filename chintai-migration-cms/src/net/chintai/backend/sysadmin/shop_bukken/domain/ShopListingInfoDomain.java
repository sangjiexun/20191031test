package net.chintai.backend.sysadmin.shop_bukken.domain;

/**
 * 店舗リスティング契約情報
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingInfoDomain {

    /** 店舗コード */
    private String shopCd;

    /** 契約コード */
    private String keiyakuCd;

    /** 契約オプションコード */
    private String keiyakuSubCd;

    /** 会社名 */
    private String company;

    /** 事務所名 */
    private String bumon;

    /** お客様設定パスワード */
    private String password;

    /** 契約名 */
    private String keiyakuName;

    /** 契約コメント */
    private String keiyakuCommnet;

    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

    /** 契約開始日時 */
    private String keiyakuStartDt;

    /** 契約終了日時 */
    private String keiyakuEndDt;

    /** 枠数文字列 */
    private String strAmountList;

    /** 枠の桁数*/
    private Integer amountLenth;

    /**
     * 店舗コードを返します。
     * @return 店舗コード
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
     * 契約オプションコードを返します。
     * @return 契約オプションコード
     */
    public String getKeiyakuSubCd() {
        return keiyakuSubCd;
    }

    /**
     * 契約オプションコードを設定します。
     * @param keiyakuSubCd  契約オプションコード
     */
    public void setKeiyakuSubCd(String keiyakuSubCd) {
        this.keiyakuSubCd = keiyakuSubCd;
    }

    /**
     * 会社名を返します。
     * @return 会社名
     */
    public String getCompany() {
        return company;
    }

    /**
     * 会社名を設定します。
     * @param company  会社名
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * bumonを返します。
     * @return bumon
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 事務所名を設定します。
     * @param bumon  事務所名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

    /**
     * お客様設定パスワードを返します。
     * @return お客様設定パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * お客様設定パスワードを設定します。
     * @param password  お客様設定パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 契約名を返します。
     * @return 契約名
     */
    public String getKeiyakuName() {
        return keiyakuName;
    }

    /**
     * 契約名を設定します。
     * @param keiyakuName  契約名
     */
    public void setKeiyakuName(String keiyakuName) {
        this.keiyakuName = keiyakuName;
    }

    /**
     * 契約コメントを返します。
     * @return 契約コメント
     */
    public String getKeiyakuCommnet() {
        return keiyakuCommnet;
    }

    /**
     * 契約コメントを設定します。
     * @param keiyakuCommnet  契約コメント
     */
    public void setKeiyakuCommnet(String keiyakuCommnet) {
        this.keiyakuCommnet = keiyakuCommnet;
    }

    /**
     *  店舗管理テーブル更新日時を返します。
     * @return  店舗管理テーブル更新日時
     */
    public String getShopKanriUpdDt() {
        return shopKanriUpdDt;
    }

    /**
     *  店舗管理テーブル更新日時を設定します。
     * @param shopKanriUpdDt   店舗管理テーブル更新日時
     */
    public void setShopKanriUpdDt(String shopKanriUpdDt) {
        this.shopKanriUpdDt = shopKanriUpdDt;
    }

	public String getStrAmountList() {
		return strAmountList;
	}

	public void setStrAmountList(String strAmountList) {
		this.strAmountList = strAmountList;
	}

	public Integer getAmountLenth() {
		return amountLenth;
	}

	public void setAmountLenth(Integer amountLenth) {
		this.amountLenth = amountLenth;
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

}

/*
 * $Id: ShopMailSearchForCsvOutServiceBean.java 3725 2008-01-09 02:27:12Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/11/20   BGT)沈鍾沿    新規作成
 * 2008/01/09   BGT)児島      項目追加(仕様変更)
 *
 */
package net.chintai.backend.sysadmin.master.service.bean;

/**
 * CSV ファイルのダウンロード用不動産会社メールアドレスOutServiceBean
 *
 * @author Sim-JongYeon
 * @version $Revision: 3725 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopMailSearchForCsvOutServiceBean {

    /** エリアコード */
    private String areaCd;

    /** エリア名 */
    private String areaName;

    /** 都道府県コード */
    private String prefCd;

    /** 都道府県名 */
    private String prefName;

    /** 店舗コード */
    private String shopCd;

    /** 会社名 */
    private String company;

    /** 事務所名 */
    private String bumon;

    /** 郵便番号 */
    private String zip;

    /** 住所1 */
    private String address1;

    /** 住所2 */
    private String address2;

    /** 電話番号 */
    private String tel;

    /** FAX番号 */
    private String fax;

    /** メールアドレス1 */
    private String email1;

    /** メールアドレス2 */
    private String email2;

    /** メールアドレス3 */
    private String email3;

    /** メールアドレス4 */
    private String email4;

    /** メールアドレス5 */
    private String email5;

    /** 代表者名 */
    private String licTrust;

    /** 担当者名 */
    private String tantou;

    /** 送信元タイプ */
    private String clientsystemType;

    /** 店舗ステータス */
    private String shopStatus;

    /**
     * エリアコードを取得します。
     * @return エリアコード
     */
    public String getAreaCd() {
        return areaCd;
    }

    /**
     * エリアコードを設定します。
     * @param areaCd エリアコード
     */
    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    /**
     * エリア名を取得します。
     * @return エリア名
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * エリア名を設定します。
     * @param areaName エリア名
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 都道府県コードを取得します。
     * @return 都道府県コード
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府県コードを設定します。
     * @param prefCd 都道府県コード
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
    }

    /**
     * 都道府県名を取得します。
     * @return 都道府県名
     */
    public String getPrefName() {
        return prefName;
    }

    /**
     * 都道府県名を設定します。
     * @param prefName 都道府県名
     */
    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     * @param shopCd 店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 会社名を取得します。
     * @return 会社名
     */
    public String getCompany() {
        return company;
    }

    /**
     * 会社名を設定します。
     * @param company 会社名
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 事務所名を取得します。
     * @return 事務所名
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 事務所名を設定します。
     * @param bumon 事務所名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

    /**
     * 郵便番号を取得します。
     * @return 郵便番号
     */
    public String getZip() {
        return zip;
    }

    /**
     * 郵便番号を設定します。
     * @param zip 郵便番号
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * 住所1を取得します。
     * @return 住所1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * 住所1を設定します。
     * @param address1 住所1
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * 住所2を取得します。
     * @return 住所2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * 住所2を設定します。
     * @param address2 住所2
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * 電話番号を取得します。
     * @return 電話番号
     */
    public String getTel() {
        return tel;
    }

    /**
     * 電話番号を設定します。
     * @param tel 電話番号
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * FAX番号を取得します。
     * @return FAX番号
     */
    public String getFax() {
        return fax;
    }

    /**
     * FAX番号を設定します。
     * @param fax FAX番号
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 代表者名を取得します。
     * @return 代表者名
     */
    public String getLicTrust() {
        return licTrust;
    }

    /**
     * 代表者名を設定します。
     * @param licTrust 代表者名
     */
    public void setLicTrust(String licTrust) {
        this.licTrust = licTrust;
    }

    /**
     * 担当者名を取得します。
     * @return 担当者名
     */
    public String getTantou() {
        return tantou;
    }

    /**
     * 担当者名を設定します。
     * @param tantou 担当者名
     */
    public void setTantou(String tantou) {
        this.tantou = tantou;
    }

    /**
     * 送信元タイプを取得します。
     * @return 送信元タイプ
     */
    public String getClientsystemType() {
        return clientsystemType;
    }

    /**
     * 送信元タイプを設定します。
     * @param clientsystemType 送信元タイプ
     */
    public void setClientsystemType(String clientsystemType) {
        this.clientsystemType = clientsystemType;
    }

    /**
     * 店舗ステータスを取得します。
     * @return 店舗ステータス
     */
    public String getShopStatus() {
        return shopStatus;
    }

    /**
     * 店舗ステータスを設定します。
     * @param shopStatus 店舗ステータス
     */
    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

	/**
	 * @return email1
	 */
	public String getEmail1() {
		return email1;
	}

	/**
	 * @param email1 セットする email1
	 */
	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	/**
	 * @return email2
	 */
	public String getEmail2() {
		return email2;
	}

	/**
	 * @param email2 セットする email2
	 */
	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	/**
	 * @return email3
	 */
	public String getEmail3() {
		return email3;
	}

	/**
	 * @param email3 セットする email3
	 */
	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	/**
	 * @return email4
	 */
	public String getEmail4() {
		return email4;
	}

	/**
	 * @param email4 セットする email4
	 */
	public void setEmail4(String email4) {
		this.email4 = email4;
	}

	/**
	 * @return email5
	 */
	public String getEmail5() {
		return email5;
	}

	/**
	 * @param email5 セットする email5
	 */
	public void setEmail5(String email5) {
		this.email5 = email5;
	}
}

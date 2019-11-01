/*
 * $Id: InquiryRecentSearchOutServiceBean.java 4464 2010-09-27 08:05:10Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)児島       新規作成
 * 2007/06/25  BGT)李昊燮     キャリアタイプ追加
 */
package net.chintai.backend.sysadmin.shop_inquiry.service.bean;

/**
 * 問い合せ情報検索OutServiceBean
 *
 * @author JavaBeans Code Generator
 * @version $Revision: 4464 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryRecentSearchOutServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** 会社名 */
    private String company;

    /** 事務所名 */
    private String bumon;

    /** 問い合せ日時 */
    private String insDt;

    /** 問い合せID */
    private String inqId;

    /** 問い合せ種類 */
    private String inqFlg;

    /** 問い合せ元 */
    private String sysFlg;

    /** キャリアタイプ */
    private String carrierType;

    /** 閲覧状況 */
    private String refFlg;

    /** 処理状況 */
    private String inquiryStatus;

    /** 最終更新日時 */
    private String updDt;

    /** 問合せ内容*/
    private String upInquiry;

    /** 物件情報テキスト1 */
    private String bkInfo01;

    /** 物件情報テキスト2 */
    private String bkInfo02;

    /** 物件情報テキスト3 */
    private String bkInfo03;

    /** 物件情報テキスト4 */
    private String bkInfo04;

    /** 物件情報テキスト5 */
    private String bkInfo05;

    /** 物件情報テキスト6 */
    private String bkInfo06;

    /** 物件情報テキスト7 */
    private String bkInfo07;

    /** 物件情報テキスト8 */
    private String bkInfo08;

    /** 物件情報テキスト9 */
    private String bkInfo09;

    /** 物件情報テキスト10 */
    private String bkInfo10;

    private String schoolName;

    private String refFlgName;
    private String inquiryStatusName;
    private String carrierTypeName;
    private String inqFlgName;
    private String sysFlgName;
    private String siteTypeName;

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
     * 問い合せ日時を取得します。
     * @return 問い合せ日時
     */
    public String getInsDt() {
        return insDt;
    }

    /**
     * 問い合せ日時を設定します。
     * @param insDt 問い合せ日時
     */
    public void setInsDt(String insDt) {
        this.insDt = insDt;
    }

    /**
     * 問い合せIDを取得します。
     * @return 問い合せID
     */
    public String getInqId() {
        return inqId;
    }

    /**
     * 問い合せIDを設定します。
     * @param inqId 問い合せID
     */
    public void setInqId(String inqId) {
        this.inqId = inqId;
    }

    /**
     * 問い合せ種類を取得します。
     * @return 問い合せ種類
     */
    public String getInqFlg() {
        return inqFlg;
    }

    /**
     * 問い合せ種類を設定します。
     * @param inqFlg 問い合せ種類
     */
    public void setInqFlg(String inqFlg) {
        this.inqFlg = inqFlg;
    }

    /**
     * 問い合せ元を取得します。
     * @return 問い合せ元
     */
    public String getSysFlg() {
        return sysFlg;
    }

    /**
     * 問い合せ元を設定します。
     * @param sysFlg 問い合せ元
     */
    public void setSysFlg(String sysFlg) {
        this.sysFlg = sysFlg;
    }

    /**
     * キャリアタイプを取得します。
     * @return キャリアタイプ
     */
    public String getCarrierType() {
        return carrierType;
    }

    /**
     * キャリアタイプを設定します。
     * @param carrierType キャリアタイプ
     */
    public void setCarrierType(String carrierType) {
        this.carrierType = carrierType;
    }

    /**
     * 閲覧状況を取得します。
     * @return 閲覧状況
     */
    public String getRefFlg() {
        return refFlg;
    }

    /**
     * 閲覧状況を設定します。
     * @param refFlg 閲覧状況
     */
    public void setRefFlg(String refFlg) {
        this.refFlg = refFlg;
    }

    /**
     * 処理状況を取得します。
     * @return 処理状況
     */
    public String getInquiryStatus() {
        return inquiryStatus;
    }

    /**
     * 処理状況を設定します。
     * @param inquiryStatus 処理状況
     */
    public void setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }

    /**
     * 最終更新日時を取得します。
     * @return 最終更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日時を設定します。
     * @param updDt 最終更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 問合せ内容を取得します。
     * @return 問合せ内容
     */
    public String getUpInquiry() {
        return upInquiry;
    }

    /**
     * 問合せ内容を設定します。
     * @param upInquiry 問合せ内容
     */
    public void setUpInquiry(String upInquiry) {
        this.upInquiry = upInquiry;
    }

    /**
     * 物件情報テキスト1を取得します。
     * @return 物件情報テキスト1
     */
    public String getBkInfo01() {
        return bkInfo01;
    }

    /**
     * 物件情報テキスト1を設定します。
     * @param bkInfo01 物件情報テキスト1
     */
    public void setBkInfo01(String bkInfo01) {
        this.bkInfo01 = bkInfo01;
    }

    /**
     * 物件情報テキスト2を取得します。
     * @return 物件情報テキスト2
     */
    public String getBkInfo02() {
        return bkInfo02;
    }

    /**
     * 物件情報テキスト2を設定します。
     * @param bkInfo02 物件情報テキスト2
     */
    public void setBkInfo02(String bkInfo02) {
        this.bkInfo02 = bkInfo02;
    }

    /**
     * 物件情報テキスト3を取得します。
     * @return 物件情報テキスト3
     */
    public String getBkInfo03() {
        return bkInfo03;
    }

    /**
     * 物件情報テキスト3を設定します。
     * @param bkInfo03 物件情報テキスト3
     */
    public void setBkInfo03(String bkInfo03) {
        this.bkInfo03 = bkInfo03;
    }

    /**
     * 物件情報テキスト4を取得します。
     * @return 物件情報テキスト4
     */
    public String getBkInfo04() {
        return bkInfo04;
    }

    /**
     * 物件情報テキスト4を設定します。
     * @param bkInfo04 物件情報テキスト4
     */
    public void setBkInfo04(String bkInfo04) {
        this.bkInfo04 = bkInfo04;
    }

    /**
     * 物件情報テキスト5を取得します。
     * @return 物件情報テキスト5
     */
    public String getBkInfo05() {
        return bkInfo05;
    }

    /**
     * 物件情報テキスト5を設定します。
     * @param bkInfo05 物件情報テキスト5
     */
    public void setBkInfo05(String bkInfo05) {
        this.bkInfo05 = bkInfo05;
    }

    /**
     * 物件情報テキスト6を取得します。
     * @return 物件情報テキスト6
     */
    public String getBkInfo06() {
        return bkInfo06;
    }

    /**
     * 物件情報テキスト6を設定します。
     * @param bkInfo06 物件情報テキスト6
     */
    public void setBkInfo06(String bkInfo06) {
        this.bkInfo06 = bkInfo06;
    }

    /**
     * 物件情報テキスト7を取得します。
     * @return 物件情報テキスト7
     */
    public String getBkInfo07() {
        return bkInfo07;
    }

    /**
     * 物件情報テキスト7を設定します。
     * @param bkInfo07 物件情報テキスト7
     */
    public void setBkInfo07(String bkInfo07) {
        this.bkInfo07 = bkInfo07;
    }

    /**
     * 物件情報テキスト8を取得します。
     * @return 物件情報テキスト8
     */
    public String getBkInfo08() {
        return bkInfo08;
    }

    /**
     * 物件情報テキスト8を設定します。
     * @param bkInfo08 物件情報テキスト8
     */
    public void setBkInfo08(String bkInfo08) {
        this.bkInfo08 = bkInfo08;
    }

    /**
     * 物件情報テキスト9を取得します。
     * @return 物件情報テキスト9
     */
    public String getBkInfo09() {
        return bkInfo09;
    }

    /**
     * 物件情報テキスト9を設定します。
     * @param bkInfo09 物件情報テキスト9
     */
    public void setBkInfo09(String bkInfo09) {
        this.bkInfo09 = bkInfo09;
    }

    /**
     * 物件情報テキスト10を取得します。
     * @return 物件情報テキスト10
     */
    public String getBkInfo10() {
        return bkInfo10;
    }

    /**
     * 物件情報テキスト10を設定します。
     * @param bkInfo10 物件情報テキスト10
     */
    public void setBkInfo10(String bkInfo10) {
        this.bkInfo10 = bkInfo10;
    }

    /**
     * schoolNameを取得します。
     * @return schoolName
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * schoolNameを設定します。
     * @param schoolName schoolName
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

	/**
	 * @return refFlgName
	 */
	public String getRefFlgName() {
		return refFlgName;
	}

	/**
	 * @param refFlgName セットする refFlgName
	 */
	public void setRefFlgName(String refFlgName) {
		this.refFlgName = refFlgName;
	}

	/**
	 * @return inquiryStatusName
	 */
	public String getInquiryStatusName() {
		return inquiryStatusName;
	}

	/**
	 * @param inquiryStatusName セットする inquiryStatusName
	 */
	public void setInquiryStatusName(String inquiryStatusName) {
		this.inquiryStatusName = inquiryStatusName;
	}

	/**
	 * @return carrierTypeName
	 */
	public String getCarrierTypeName() {
		return carrierTypeName;
	}

	/**
	 * @param carrierTypeName セットする carrierTypeName
	 */
	public void setCarrierTypeName(String carrierTypeName) {
		this.carrierTypeName = carrierTypeName;
	}

	/**
	 * @return inqFlgName
	 */
	public String getInqFlgName() {
		return inqFlgName;
	}

	/**
	 * @param inqFlgName セットする inqFlgName
	 */
	public void setInqFlgName(String inqFlgName) {
		this.inqFlgName = inqFlgName;
	}

	/**
	 * @return sysFlgName
	 */
	public String getSysFlgName() {
		return sysFlgName;
	}

	/**
	 * @param sysFlgName セットする sysFlgName
	 */
	public void setSysFlgName(String sysFlgName) {
		this.sysFlgName = sysFlgName;
	}

	/**
	 * @return siteTypeName
	 */
	public String getSiteTypeName() {
		return siteTypeName;
	}

	/**
	 * @param siteTypeName セットする siteTypeName
	 */
	public void setSiteTypeName(String siteTypeName) {
		this.siteTypeName = siteTypeName;
	}
}
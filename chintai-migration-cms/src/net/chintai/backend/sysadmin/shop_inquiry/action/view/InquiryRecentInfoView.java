/*
 * $Id: InquiryRecentInfoView.java 4464 2010-09-27 08:05:10Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)児島       新規作成
 * 2007/06/25  BGT)李昊燮     キャリアタイプ追加
 *
 */
package net.chintai.backend.sysadmin.shop_inquiry.action.view;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 問い合せ履歴詳細ViewHelper
 *
 * @author JavaBeans Code Generator
 * @version $Revision: 4464 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryRecentInfoView implements ViewHelper {

    /** 店舗コード */
    private String shopCd;

    /** 店舗パスワード */
    private String password;

    /** 会社名 */
    private String company;

    /** 事務所名 */
    private String bumon;

    /** 住所1 */
    private String address1;

    /** 住所2 */
    private String address2;

    /** TEL */
    private String tel;

    /** FAX */
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

    /** Ｅ－ＭＡＩＬアドレス用途区分1 */
    private String emailUseKbn1;

    /** Ｅ－ＭＡＩＬアドレス用途区分2 */
    private String emailUseKbn2;

    /** Ｅ－ＭＡＩＬアドレス用途区分3 */
    private String emailUseKbn3;

    /** Ｅ－ＭＡＩＬアドレス用途区分4 */
    private String emailUseKbn4;

    /** Ｅ－ＭＡＩＬアドレス用途区分5 */
    private String emailUseKbn5;

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

    /** 送信時の店舗表記(会社名) */
    private String sendCompanyNm;

    /** 送信時の店舗表記(事務所名) */
    private String sendOfficeNm;

    /** 送信時の店舗表記(メールアドレス) */
    private String sendEmail;

    /** 問い合せ者氏名 */
    private String upName;

    /** 問い合せ者氏名(カナ) */
    private String upNameKana;

    /** 性別 */
    private String upSex;

    /** 生年月日 */
    private String upBirthday;

    /** 連絡方法（連絡可能時間） */
    private String upResTime;

    /** 連絡方法（メールアドレス） */
    private String upResEmail;

    /** 連絡方法（電話番号） */
    private String upResTel;

    /** 連絡方法（FAX番号） */
    private String upResFax;

    /** 連絡方法（その他連絡方法） */
    private String upResOther;

    /** 問い合せ内容 */
    private String upInquiry;

    /** 引越し時期 */
    private String ubMoveTime;

    /** 引越動機 */
    private String ubMoveReason;

    /** 希望エリア・沿線・駅 */
    private String ubHopeArea;

    /** 希望間取り */
    private String ubHopeRoom;

    /** 希望家賃(Down) */
    private String ubHopeRentDown;

    /** 希望家賃(Up) */
    private String ubHopeRentUp;

    /** 現在家賃 */
    private String ubNowRent;

    /** 希望のこだわり内容 */
    private String ubHopeBody;

    /** 物件情報 */
    private String bkInfo;

    /** 連絡方法指定 Email */
    private String upResFlgEmail;

    /** 連絡方法指定 TEL */
    private String upResFlgTel;

    /** 連絡方法指定 FAX */
    private String upResFlgFax;

    /** 連絡方法指定 その他 */
    private String upResFlgOther;

    /** 大学名 */
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
     * 店舗パスワードを取得します。
     * @return 店舗パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * 店舗パスワードを設定します。
     * @param password 店舗パスワード
     */
    public void setPassword(String password) {
        this.password = password;
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
     * TELを取得します。
     * @return TEL
     */
    public String getTel() {
        return tel;
    }

    /**
     * TELを設定します。
     * @param tel TEL
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * FAXを取得します。
     * @return FAX
     */
    public String getFax() {
        return fax;
    }

    /**
     * FAXを設定します。
     * @param fax FAX
     */
    public void setFax(String fax) {
        this.fax = fax;
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
     * 送信時の店舗表記(会社名)を取得します。
     * @return 送信時の店舗表記(会社名)
     */
    public String getSendCompanyNm() {
        return sendCompanyNm;
    }

    /**
     * 送信時の店舗表記(会社名)を設定します。
     * @param sendCompanyNm 送信時の店舗表記(会社名)
     */
    public void setSendCompanyNm(String sendCompanyNm) {
        this.sendCompanyNm = sendCompanyNm;
    }

    /**
     * 送信時の店舗表記(事務所名)を取得します。
     * @return 送信時の店舗表記(事務所名)
     */
    public String getSendOfficeNm() {
        return sendOfficeNm;
    }

    /**
     * 送信時の店舗表記(事務所名)を設定します。
     * @param sendOfficeNm 送信時の店舗表記(事務所名)
     */
    public void setSendOfficeNm(String sendOfficeNm) {
        this.sendOfficeNm = sendOfficeNm;
    }

    /**
     * 送信時の店舗表記(メールアドレス)を取得します。
     * @return 送信時の店舗表記(メールアドレス)
     */
    public String getSendEmail() {
        return sendEmail;
    }

    /**
     * 送信時の店舗表記(メールアドレス)を設定します。
     * @param sendEmail 送信時の店舗表記(メールアドレス)
     */
    public void setSendEmail(String sendEmail) {
        this.sendEmail = sendEmail;
    }

    /**
     * 問い合せ者氏名を取得します。
     * @return 問い合せ者氏名
     */
    public String getUpName() {
        return upName;
    }

    /**
     * 問い合せ者氏名を設定します。
     * @param upName 問い合せ者氏名
     */
    public void setUpName(String upName) {
        this.upName = upName;
    }

    /**
     * 問い合せ者氏名(カナ)を取得します。
     * @return 問い合せ者氏名(カナ)
     */
    public String getUpNameKana() {
        return upNameKana;
    }

    /**
     * 問い合せ者氏名(カナ)を設定します。
     * @param upNameKana 問い合せ者氏名(カナ)
     */
    public void setUpNameKana(String upNameKana) {
        this.upNameKana = upNameKana;
    }

    /**
     * 性別を取得します。
     * @return 性別
     */
    public String getUpSex() {
        return upSex;
    }

    /**
     * 性別を設定します。
     * @param upSex 性別
     */
    public void setUpSex(String upSex) {
        this.upSex = upSex;
    }

    /**
     * 生年月日を取得します。
     * @return 生年月日
     */
    public String getUpBirthday() {
        return upBirthday;
    }

    /**
     * 生年月日を設定します。
     * @param upBirthday 生年月日
     */
    public void setUpBirthday(String upBirthday) {
        this.upBirthday = upBirthday;
    }

    /**
     * 連絡方法（連絡可能時間）を取得します。
     * @return 連絡方法（連絡可能時間）
     */
    public String getUpResTime() {
        return upResTime;
    }

    /**
     * 連絡方法（連絡可能時間）を設定します。
     * @param upResTime 連絡方法（連絡可能時間）
     */
    public void setUpResTime(String upResTime) {
        this.upResTime = upResTime;
    }

    /**
     * 連絡方法（メールアドレス）を取得します。
     * @return 連絡方法（メールアドレス）
     */
    public String getUpResEmail() {
        return upResEmail;
    }

    /**
     * 連絡方法（メールアドレス）を設定します。
     * @param upResEmail 連絡方法（メールアドレス）
     */
    public void setUpResEmail(String upResEmail) {
        this.upResEmail = upResEmail;
    }

    /**
     * 連絡方法（電話番号）を取得します。
     * @return 連絡方法（電話番号）
     */
    public String getUpResTel() {
        return upResTel;
    }

    /**
     * 連絡方法（電話番号）を設定します。
     * @param upResTel 連絡方法（電話番号）
     */
    public void setUpResTel(String upResTel) {
        this.upResTel = upResTel;
    }

    /**
     * 連絡方法（FAX番号）を取得します。
     * @return 連絡方法（FAX番号）
     */
    public String getUpResFax() {
        return upResFax;
    }

    /**
     * 連絡方法（FAX番号）を設定します。
     * @param upResFax 連絡方法（FAX番号）
     */
    public void setUpResFax(String upResFax) {
        this.upResFax = upResFax;
    }

    /**
     * 連絡方法（その他連絡方法）を取得します。
     * @return 連絡方法（その他連絡方法）
     */
    public String getUpResOther() {
        return upResOther;
    }

    /**
     * 連絡方法（その他連絡方法）を設定します。
     * @param upResOther 連絡方法（その他連絡方法）
     */
    public void setUpResOther(String upResOther) {
        this.upResOther = upResOther;
    }

    /**
     * 問い合せ内容を取得します。
     * @return 問い合せ内容
     */
    public String getUpInquiry() {
        return upInquiry;
    }

    /**
     * 問い合せ内容を設定します。
     * @param upInquiry 問い合せ内容
     */
    public void setUpInquiry(String upInquiry) {
        this.upInquiry = upInquiry;
    }

    /**
     * 引越し時期を取得します。
     * @return 引越し時期
     */
    public String getUbMoveTime() {
        return ubMoveTime;
    }

    /**
     * 引越し時期を設定します。
     * @param ubMoveTime 引越し時期
     */
    public void setUbMoveTime(String ubMoveTime) {
        this.ubMoveTime = ubMoveTime;
    }

    /**
     * 引越動機を取得します。
     * @return 引越動機
     */
    public String getUbMoveReason() {
        return ubMoveReason;
    }

    /**
     * 引越動機を設定します。
     * @param ubMoveReason 引越動機
     */
    public void setUbMoveReason(String ubMoveReason) {
        this.ubMoveReason = ubMoveReason;
    }

    /**
     * 希望エリア・沿線・駅を取得します。
     * @return 希望エリア・沿線・駅
     */
    public String getUbHopeArea() {
        return ubHopeArea;
    }

    /**
     * 希望エリア・沿線・駅を設定します。
     * @param ubHopeArea 希望エリア・沿線・駅
     */
    public void setUbHopeArea(String ubHopeArea) {
        this.ubHopeArea = ubHopeArea;
    }

    /**
     * 希望間取りを取得します。
     * @return 希望間取り
     */
    public String getUbHopeRoom() {
        return ubHopeRoom;
    }

    /**
     * 希望間取りを設定します。
     * @param ubHopeRoom 希望間取り
     */
    public void setUbHopeRoom(String ubHopeRoom) {
        this.ubHopeRoom = ubHopeRoom;
    }

    /**
     * 希望家賃(Down)を取得します。
     * @return 希望家賃(Down)
     */
    public String getUbHopeRentDown() {
        return ubHopeRentDown;
    }

    /**
     * 希望家賃(Down)を設定します。
     * @param ubHopeRentDown 希望家賃(Down)
     */
    public void setUbHopeRentDown(String ubHopeRentDown) {
        this.ubHopeRentDown = ubHopeRentDown;
    }

    /**
     * 希望家賃(Up)を取得します。
     * @return 希望家賃(Up)
     */
    public String getUbHopeRentUp() {
        return ubHopeRentUp;
    }

    /**
     * 希望家賃(Up)を設定します。
     * @param ubHopeRentUp 希望家賃(Up)
     */
    public void setUbHopeRentUp(String ubHopeRentUp) {
        this.ubHopeRentUp = ubHopeRentUp;
    }

    /**
     * 現在家賃を取得します。
     * @return 現在家賃
     */
    public String getUbNowRent() {
        return ubNowRent;
    }

    /**
     * 現在家賃を設定します。
     * @param ubNowRent 現在家賃
     */
    public void setUbNowRent(String ubNowRent) {
        this.ubNowRent = ubNowRent;
    }

    /**
     * 希望のこだわり内容を取得します。
     * @return 希望のこだわり内容
     */
    public String getUbHopeBody() {
        return ubHopeBody;
    }

    /**
     * 希望のこだわり内容を設定します。
     * @param ubHopeBody 希望のこだわり内容
     */
    public void setUbHopeBody(String ubHopeBody) {
        this.ubHopeBody = ubHopeBody;
    }

    /**
     * 物件情報を取得します。
     * @return 物件情報
     */
    public String getBkInfo() {
        return bkInfo;
    }

    /**
     * 物件情報を設定します。
     * @param bkInfo 物件情報
     */
    public void setBkInfo(String bkInfo) {
        this.bkInfo = bkInfo;
    }

    /**
     * 連絡方法指定 Emailを取得します。
     * @return 連絡方法指定 Email
     */
    public String getUpResFlgEmail() {
        return upResFlgEmail;
    }

    /**
     * 連絡方法指定 Emailを設定します。
     * @param upResFlgEmail 連絡方法指定 Email
     */
    public void setUpResFlgEmail(String upResFlgEmail) {
        this.upResFlgEmail = upResFlgEmail;
    }

    /**
     * 連絡方法指定 TELを取得します。
     * @return 連絡方法指定 TEL
     */
    public String getUpResFlgTel() {
        return upResFlgTel;
    }

    /**
     * 連絡方法指定 TELを設定します。
     * @param upResFlgTel 連絡方法指定 TEL
     */
    public void setUpResFlgTel(String upResFlgTel) {
        this.upResFlgTel = upResFlgTel;
    }

    /**
     * 連絡方法指定 FAXを取得します。
     * @return 連絡方法指定 FAX
     */
    public String getUpResFlgFax() {
        return upResFlgFax;
    }

    /**
     * 連絡方法指定 FAXを設定します。
     * @param upResFlgFax 連絡方法指定 FAX
     */
    public void setUpResFlgFax(String upResFlgFax) {
        this.upResFlgFax = upResFlgFax;
    }

    /**
     * 連絡方法指定 その他を取得します。
     * @return 連絡方法指定 その他
     */
    public String getUpResFlgOther() {
        return upResFlgOther;
    }

    /**
     * 連絡方法指定 その他を設定します。
     * @param upResFlgOther 連絡方法指定 その他
     */
    public void setUpResFlgOther(String upResFlgOther) {
        this.upResFlgOther = upResFlgOther;
    }

    /**
     * 大学名を取得します。
     * @return 大学名
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * 大学名を設定します。
     * @param schoolName 大学名
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
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
	 * @return emailUseKbn1
	 */
	public String getEmailUseKbn1() {
		return emailUseKbn1;
	}

	/**
	 * @param emailUseKbn1 セットする emailUseKbn1
	 */
	public void setEmailUseKbn1(String emailUseKbn1) {
		this.emailUseKbn1 = emailUseKbn1;
	}

	/**
	 * @return emailUseKbn2
	 */
	public String getEmailUseKbn2() {
		return emailUseKbn2;
	}

	/**
	 * @param emailUseKbn2 セットする emailUseKbn2
	 */
	public void setEmailUseKbn2(String emailUseKbn2) {
		this.emailUseKbn2 = emailUseKbn2;
	}

	/**
	 * @return emailUseKbn3
	 */
	public String getEmailUseKbn3() {
		return emailUseKbn3;
	}

	/**
	 * @param emailUseKbn3 セットする emailUseKbn3
	 */
	public void setEmailUseKbn3(String emailUseKbn3) {
		this.emailUseKbn3 = emailUseKbn3;
	}

	/**
	 * @return emailUseKbn4
	 */
	public String getEmailUseKbn4() {
		return emailUseKbn4;
	}

	/**
	 * @param emailUseKbn4 セットする emailUseKbn4
	 */
	public void setEmailUseKbn4(String emailUseKbn4) {
		this.emailUseKbn4 = emailUseKbn4;
	}

	/**
	 * @return emailUseKbn5
	 */
	public String getEmailUseKbn5() {
		return emailUseKbn5;
	}

	/**
	 * @param emailUseKbn5 セットする emailUseKbn5
	 */
	public void setEmailUseKbn5(String emailUseKbn5) {
		this.emailUseKbn5 = emailUseKbn5;
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
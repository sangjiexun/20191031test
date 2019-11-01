package net.chintai.backend.sysadmin.shop_bukken.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 店舗リスティング情報登録
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingAddView implements ViewHelper {
	private String isWakuDisp;

    /** 会社名 */
    private String company;

    /** 事務所名 */
    private String bumon;

    /** 店舗コード */
    private String shopCd;

    /** お客様設定パスワード */
    private String password;

    /** 契約コード */
    private String keiyakuCd;

    /** 契約サブコード */
    private String keiyakuSubCd;

    /** 契約名 */
    private String keiyakuName;

    /** 備考 */
    private String keiyakuNote;

    /** 契約開始日時(年) */
    private String keiyakuStartYear;

    /** 契約開始日時(月) */
    private String keiyakuStartMonth;

    /** 契約開始日時(日) */
    private String keiyakuStartDay;

    /** 契約開始日時(時) */
    private String keiyakuStartHour;

    /** 契約開始日時(分) */
    private String keiyakuStartMinute;

    /** 契約開始日時(秒) */
    private String keiyakuStartSecond;

    /** 契約終了日時(年) */
    private String keiyakuEndYear;

    /** 契約終了日時(月) */
    private String keiyakuEndMonth;

    /** 契約終了日時(日) */
    private String keiyakuEndDay;

    /** 契約終了日時(時) */
    private String keiyakuEndHour;

    /** 契約終了日時(分) */
    private String keiyakuEndMinute;

    /** 契約終了日時(秒) */
    private String keiyakuEndSecond;

    /** Validation用 日付項目*/
    private String nowDate;

    /** 年度リスト */
    private List<String[]> applyYearList;

    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;



    /** 枠数(ラジオボタン) */
    private String wakuCnt;

    /** 枠数(テキスト) */
    private String wakuCntNote;

    /** 適用枠数データ */
    private List<Long> listAmount;

    /** Validation用 桁数*/
    private Long amountLenth;

    /** Validation用のチェックタイプ*/
    private String wakuCntChecker;

    /** Validation用のチェックタイプ*/
    private String maxNum;

    /** テキストボックスフラグ*/
    private String textBoxFlg;

    /** テキストボックス名*/
    private String textBoxName;


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
     * 事務所名を返します。
     * @return 事務所名
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
     * 契約サブコードを返します。
     * @return 契約サブコード
     */
    public String getKeiyakuSubCd() {
        return keiyakuSubCd;
    }

    /**
     * 契約サブコードを設定します。
     * @param keiyakuSubCd  契約サブコード
     */
    public void setKeiyakuSubCd(String keiyakuSubCd) {
        this.keiyakuSubCd = keiyakuSubCd;
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
     * 契約開始日時(年)を返します。
     * @return 契約開始日時(年)
     */
    public String getKeiyakuStartYear() {
        return keiyakuStartYear;
    }

    /**
     * 契約開始日時(年)を設定します。
     * @param keiyakuStartYear  契約開始日時(年)
     */
    public void setKeiyakuStartYear(String keiyakuStartYear) {
        this.keiyakuStartYear = keiyakuStartYear;
    }

    /**
     * 契約開始日時(月)を返します。
     * @return 契約開始日時(月)
     */
    public String getKeiyakuStartMonth() {
        return keiyakuStartMonth;
    }

    /**
     * 契約開始日時(月)を設定します。
     * @param keiyakuStartMonth  契約開始日時(月)
     */
    public void setKeiyakuStartMonth(String keiyakuStartMonth) {
        this.keiyakuStartMonth = keiyakuStartMonth;
    }

    /**
     * 契約開始日時(日) を返します。
     * @return 契約開始日時(日)
     */
    public String getKeiyakuStartDay() {
        return keiyakuStartDay;
    }

    /**
     * 契約開始日時(日) を設定します。
     * @param keiyakuStartDay  契約開始日時(日)
     */
    public void setKeiyakuStartDay(String keiyakuStartDay) {
        this.keiyakuStartDay = keiyakuStartDay;
    }

    /**
     * 契約開始日時(時)を返します。
     * @return 契約開始日時(時)
     */
    public String getKeiyakuStartHour() {
        return keiyakuStartHour;
    }

    /**
     * 契約開始日時(時)を設定します。
     * @param keiyakuStartHour  契約開始日時(時)
     */
    public void setKeiyakuStartHour(String keiyakuStartHour) {
        this.keiyakuStartHour = keiyakuStartHour;
    }

    /**
     * 契約終了日時(年)を返します。
     * @return 契約終了日時(年)
     */
    public String getKeiyakuEndYear() {
        return keiyakuEndYear;
    }

    /**
     * 契約終了日時(年)を設定します。
     * @param keiyakuEndYear  契約終了日時(年)
     */
    public void setKeiyakuEndYear(String keiyakuEndYear) {
        this.keiyakuEndYear = keiyakuEndYear;
    }

    /**
     * 契約終了日時(月)を返します。
     * @return keiyakuEndMonth
     */
    public String getKeiyakuEndMonth() {
        return keiyakuEndMonth;
    }

    /**
     * 契約終了日時(月)を設定します。
     * @param keiyakuEndMonth  契約終了日時(月)
     */
    public void setKeiyakuEndMonth(String keiyakuEndMonth) {
        this.keiyakuEndMonth = keiyakuEndMonth;
    }

    /**
     * 契約終了日時(日)を返します。
     * @return 契約終了日時(日)
     */
    public String getKeiyakuEndDay() {
        return keiyakuEndDay;
    }

    /**
     * 契約終了日時(日)を設定します。
     * @param keiyakuEndDay  契約終了日時(日)
     */
    public void setKeiyakuEndDay(String keiyakuEndDay) {
        this.keiyakuEndDay = keiyakuEndDay;
    }

    /**
     * 契約終了日時(時)を返します。
     * @return 契約終了日時(時)
     */
    public String getKeiyakuEndHour() {
        return keiyakuEndHour;
    }

    /**
     * 契約終了日時(時)を設定します。
     * @param keiyakuEndHour  契約終了日時(時)
     */
    public void setKeiyakuEndHour(String keiyakuEndHour) {
        this.keiyakuEndHour = keiyakuEndHour;
    }

    /**
     * Validation用 日付項目を返します。
     * @return Validation用 日付項目
     */
    public String getNowDate() {
        return nowDate;
    }

    /**
     * Validation用 日付項目を設定します。
     * @param nowDate  Validation用 日付項目
     */
    public void setNowDate(String nowDate) {
        this.nowDate = nowDate;
    }

    /**
     * 年度リストを返します。
     * @return 年度リスト
     */
    public List<String[]> getApplyYearList() {
        return applyYearList;
    }

    /**
     * 年度リストを設定します。
     * @param applyYearList  年度リスト
     */
    public void setApplyYearList(List<String[]> applyYearList) {
        this.applyYearList = applyYearList;
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

	public String getWakuCnt() {
		return wakuCnt;
	}

	public void setWakuCnt(String wakuCnt) {
		this.wakuCnt = wakuCnt;
	}

	public String getWakuCntNote() {
		return wakuCntNote;
	}

	public void setWakuCntNote(String wakuCntNote) {
		this.wakuCntNote = wakuCntNote;
	}

	public List<Long> getListAmount() {
		return listAmount;
	}

	public void setListAmount(List<Long> listAmount) {
		this.listAmount = listAmount;
	}

	public Long getAmountLenth() {
		return amountLenth;
	}

	public void setAmountLenth(Long amountLenth) {
		this.amountLenth = amountLenth;
	}

	public String getWakuCntChecker() {
		return wakuCntChecker;
	}

	public void setWakuCntChecker(String wakuCntChecker) {
		this.wakuCntChecker = wakuCntChecker;
	}

	public String getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(String maxNum) {
		this.maxNum = maxNum;
	}

	public String getTextBoxFlg() {
		return textBoxFlg;
	}

	public void setTextBoxFlg(String textBoxFlg) {
		this.textBoxFlg = textBoxFlg;
	}

	public String getTextBoxName() {
		return textBoxName;
	}

	public void setTextBoxName(String textBoxName) {
		this.textBoxName = textBoxName;
	}

	public String getIsWakuDisp() {
		return isWakuDisp;
	}

	public void setIsWakuDisp(String isWakuDisp) {
		this.isWakuDisp = isWakuDisp;
	}

	public String getKeiyakuStartMinute() {
		return keiyakuStartMinute;
	}

	public void setKeiyakuStartMinute(String keiyakuStartMinute) {
		this.keiyakuStartMinute = keiyakuStartMinute;
	}

	public String getKeiyakuStartSecond() {
		return keiyakuStartSecond;
	}

	public void setKeiyakuStartSecond(String keiyakuStartSecond) {
		this.keiyakuStartSecond = keiyakuStartSecond;
	}

	public String getKeiyakuEndMinute() {
		return keiyakuEndMinute;
	}

	public void setKeiyakuEndMinute(String keiyakuEndMinute) {
		this.keiyakuEndMinute = keiyakuEndMinute;
	}

	public String getKeiyakuEndSecond() {
		return keiyakuEndSecond;
	}

	public void setKeiyakuEndSecond(String keiyakuEndSecond) {
		this.keiyakuEndSecond = keiyakuEndSecond;
	}
}

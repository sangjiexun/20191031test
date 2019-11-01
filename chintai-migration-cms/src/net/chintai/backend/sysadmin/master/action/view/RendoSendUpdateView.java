package net.chintai.backend.sysadmin.master.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 連動元出稿許可表示情報
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RendoSendUpdateView implements ViewHelper {
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

	/** 契約名称 */
	private String keiyakuName;

	/** 契約番号 */
	private String rendoSendNo;

	/** 出稿許可開始日時 */
	private String permitStartDt;

	/** 出稿許可終了日時 */
	private String permitEndDt;

	/** 出稿許可開始日時表示用 */
	private String permitStartDtForDisplay;

	/** 出稿許可終了日時表示用 */
	private String permitEndDtForDisplay;

	/** 備考 */
	private String note;

	/** 更新日時 */
	private String updDt;

    /** 処理区分 */
    private String procKbn;

    /** 年度リスト */
    private List<String[]> applyYearList;

    /** ページ再表示フラグ */
    private String repeatFlg;

    /** 出稿許可開始編集フラグ */
    private String permitStartEditFlg;

    /** 現在日付 */
    private String nowDate;


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
	 * 契約名称を取得します。
	 * @return 契約名称
	 */
	public String getKeiyakuName() {
		return keiyakuName;
	}

	/**
	 * 契約名称を設定します。
	 * @param keiyakuName 契約名称
	 */
	public void setKeiyakuName(String keiyakuName) {
		this.keiyakuName = keiyakuName;
	}

	/**
	 * 契約番号を返します。
	 * @return rendoSendNo
	 */
	public String getRendoSendNo() {
		return rendoSendNo;
	}

	/**
	 * 契約番号を設定します。
	 * @param rendoSendNo  契約番号
	 */
	public void setRendoSendNo(String rendoSendNo) {
		this.rendoSendNo = rendoSendNo;
	}

	/**
	 * 出稿許可開始日時を返します。
	 * @return 出稿許可開始日時
	 */
	public String getPermitStartDt() {
		return permitStartDt;
	}

	/**
	 * 出稿許可開始日時を設定します。
	 * @param permitStartDt  出稿許可開始日時
	 */
	public void setPermitStartDt(String permitStartDt) {
		this.permitStartDt = permitStartDt;
	}

	/**
	 * 出稿許可終了日時を返します。
	 * @return 出稿許可終了日時
	 */
	public String getPermitEndDt() {
		return permitEndDt;
	}

	/**
	 * 出稿許可終了日時を設定します。
	 * @param permitEndDt  permitEndDt
	 */
	public void setPermitEndDt(String permitEndDt) {
		this.permitEndDt = permitEndDt;
	}

	/**
	 * 出稿許可開始日時表示用を返します。
	 * @return 出稿許可開始日時表示用
	 */
	public String getPermitStartDtForDisplay() {
		return permitStartDtForDisplay;
	}

	/**
	 * 出稿許可開始日時表示用を設定します。
	 * @param permitStartDtForDisplay  出稿許可開始日時表示用
	 */
	public void setPermitStartDtForDisplay(String permitStartDtForDisplay) {
		this.permitStartDtForDisplay = permitStartDtForDisplay;
	}

	/**
	 * 出稿許可終了日時表示用を返します。
	 * @return 出稿許可終了日時表示用
	 */
	public String getPermitEndDtForDisplay() {
		return permitEndDtForDisplay;
	}

	/**
	 * 出稿許可終了日時表示用を設定します。
	 * @param permitEndDtForDisplay  出稿許可終了日時表示用
	 */
	public void setPermitEndDtForDisplay(String permitEndDtForDisplay) {
		this.permitEndDtForDisplay = permitEndDtForDisplay;
	}

	/**
	 * 備考を返します。
	 * @return 備考
	 */
	public String getNote() {
		return note;
	}

	/**
	 * 備考を設定します。
	 * @param note  備考
	 */
	public void setNote(String note) {
		this.note = note;
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
     * 処理区分を取得します。
     * @return 処理区分
     */
    public String getProcKbn() {
        return procKbn;
    }

    /**
     * 処理区分を設定します。
     * @param procKbn 処理区分
     */
    public void setProcKbn(String procKbn) {
        this.procKbn = procKbn;
    }

    /**
     * 年度リストを取得します。
     * @return 年度リスト
     */
    public List<String[]> getApplyYearList() {
        return applyYearList;
    }

    /**
     * 年度リストを設定します。
     * @param applyYearList 年度リスト
     */
    public void setApplyYearList(List<String[]> applyYearList) {
        this.applyYearList = applyYearList;
    }

    /**
     * ページ再表示フラグを取得します。
     * @return ページ再表示フラグ
     */
    public String getRepeatFlg() {
    	return repeatFlg;
    }

    /**
     * ページ再表示フラグを設定します。
     * @param repeatFlg ページ再表示フラグ
     */
    public void setRepeatFlg(String repeatFlg) {
    	this.repeatFlg = repeatFlg;
    }

    /**
     * 出稿許可開始編集フラグを取得します。
     * @return 出稿許可開始編集フラグ
     */
    public String getPermitStartEditFlg() {
        return permitStartEditFlg;
    }

    /**
     * 出稿許可開始編集フラグを設定します。
     * @param permitStartEditFlg 出稿許可開始編集フラグ
     */
    public void setPermitStartEditFlg(String permitStartEditFlg) {
        this.permitStartEditFlg = permitStartEditFlg;
    }

    /**
     * 現在日付を取得します。
     * @return 現在日付
     */
    public String getNowDate() {
    	return nowDate;
    }

    /**
     * 現在日付を設定します。
     * @param nowDate 現在日付
     */
    public void setNowDate(String nowDate) {
    	this.nowDate = nowDate;
    }
}


/*
 * $Id: AspInfo.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.domain;


/**
 * 不動産ASP設定情報Domain
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class AspInfo {

	/** 会社名 */
	private String company;

	/** 事務所名 */
	private String bumon;

	/** 店舗コード */
	private String shopCd;

	/** タイトル表示用 */
	private String title;

	/** 画面レイアウト */
	private String layout;

	/** セレクトボックスタイプ */
	private String selectBoxType;

	/** テンプレートカラー */
	private String templateColor;

	/** 検索条件付加項目1 */
	private String searchItem1;

	/** 検索条件付加項目2 */
	private String searchItem2;

	/** 会社ロゴ表示フラグ */
	private String logoFlg;

	/** 会社ロゴ画像ファイル形式 */
	private String logoImageType;

	/** 個人情報保護方針表示フラグ */
	private String policyFlg;

	/** 個人情報保護方URL */
	private String policyUrl;

	/** 状態 */
	private String aspShopStatus;

	/** 沿線タイプ1 */
	private String ensenType1;

	/** 沿線タイプ2 */
	private String ensenType2;

	/** 沿線タイプ3 */
	private String ensenType3;

	/** 最終更新日付 */
	private String updDt;

	/** 登録日付 */
	private String insDt;

	/** 適用開始日時 add kashiyama */
	private String appStartDt;

	/** 不動産ＡＳＰ連番 add kashiyama */
	private Long aspShopSeq;

	/** レコード作成プログラムＩＤ add kashiyama */
	private String insPg;

	/** レコード作成者 add kashiyama */
	private String insId;

    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

	/**
	 * 会社名を取得します。
	 *
	 * @return 会社名
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * 会社名を設定します。
	 *
	 * @param company
	 *            会社名
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * 事務所名を取得します。
	 *
	 * @return 事務所名
	 */
	public String getBumon() {
		return bumon;
	}

	/**
	 * 事務所名を設定します。
	 *
	 * @param bumon
	 *            事務所名
	 */
	public void setBumon(String bumon) {
		this.bumon = bumon;
	}

	/**
	 * 店舗コードを取得します。
	 *
	 * @return 店舗コード
	 */
	public String getShopCd() {
		return shopCd;
	}

	/**
	 * 店舗コードを設定します。
	 *
	 * @param shopCd
	 *            店舗コード
	 */
	public void setShopCd(String shopCd) {
		this.shopCd = shopCd;
	}

	/**
	 * タイトル表示用を取得します。
	 *
	 * @return タイトル表示用
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * タイトル表示用を設定します。
	 *
	 * @param title
	 *            タイトル表示用
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 画面レイアウトを取得します。
	 *
	 * @return 画面レイアウト
	 */
	public String getLayout() {
		return layout;
	}

	/**
	 * 画面レイアウトを設定します。
	 *
	 * @param layout
	 *            画面レイアウト
	 */
	public void setLayout(String layout) {
		this.layout = layout;
	}

	/**
	 * セレクトボックスタイプを取得します。
	 *
	 * @return セレクトボックスタイプ
	 */
	public String getSelectBoxType() {
		return selectBoxType;
	}

	/**
	 * セレクトボックスタイプを設定します。
	 *
	 * @param selectBoxType
	 *            セレクトボックスタイプ
	 */
	public void setSelectBoxType(String selectBoxType) {
		this.selectBoxType = selectBoxType;
	}

	/**
	 * テンプレートカラーを取得します。
	 *
	 * @return テンプレートカラー
	 */
	public String getTemplateColor() {
		return templateColor;
	}

	/**
	 * テンプレートカラーを設定します。
	 *
	 * @param templateColor
	 *            テンプレートカラー
	 */
	public void setTemplateColor(String templateColor) {
		this.templateColor = templateColor;
	}

	/**
	 * 検索条件付加項目1を取得します。
	 *
	 * @return 検索条件付加項目1
	 */
	public String getSearchItem1() {
		return searchItem1;
	}

	/**
	 * 検索条件付加項目1を設定します。
	 *
	 * @param searchItem1
	 *            検索条件付加項目1
	 */
	public void setSearchItem1(String searchItem1) {
		this.searchItem1 = searchItem1;
	}

	/**
	 * 検索条件付加項目2を取得します。
	 *
	 * @return 検索条件付加項目2
	 */
	public String getSearchItem2() {
		return searchItem2;
	}

	/**
	 * 検索条件付加項目2を設定します。
	 *
	 * @param searchItem2
	 *            検索条件付加項目2
	 */
	public void setSearchItem2(String searchItem2) {
		this.searchItem2 = searchItem2;
	}

	/**
	 * 会社ロゴ表示フラグを取得します。
	 *
	 * @return 会社ロゴ表示フラグ
	 */
	public String getLogoFlg() {
		return logoFlg;
	}

	/**
	 * 会社ロゴ表示フラグを設定します。
	 *
	 * @param logoFlg
	 *            会社ロゴ表示フラグ
	 */
	public void setLogoFlg(String logoFlg) {
		this.logoFlg = logoFlg;
	}

	/**
	 * 会社ロゴ画像ファイル形式を取得します。
	 *
	 * @return 会社ロゴ画像ファイル形式
	 */
	public String getLogoImageType() {
		return logoImageType;
	}

	/**
	 * 会社ロゴ画像ファイル形式を設定します。
	 *
	 * @param logoImageType
	 *            会社ロゴ画像ファイル形式
	 */
	public void setLogoImageType(String logoImageType) {
		this.logoImageType = logoImageType;
	}

	/**
	 * 個人情報保護方針表示フラグを取得します。
	 *
	 * @return 個人情報保護方針表示フラグ
	 */
	public String getPolicyFlg() {
		return policyFlg;
	}

	/**
	 * 個人情報保護方針表示フラグを設定します。
	 *
	 * @param policyFlg
	 *            個人情報保護方針表示フラグ
	 */
	public void setPolicyFlg(String policyFlg) {
		this.policyFlg = policyFlg;
	}

	/**
	 * 個人情報保護方URLを取得します。
	 *
	 * @return 個人情報保護方URL
	 */
	public String getPolicyUrl() {
		return policyUrl;
	}

	/**
	 * 個人情報保護方URLを設定します。
	 *
	 * @param policyUrl
	 *            個人情報保護方URL
	 */
	public void setPolicyUrl(String policyUrl) {
		this.policyUrl = policyUrl;
	}

	/**
	 * 状態を取得します。
	 *
	 * @return 状態
	 */
	public String getAspShopStatus() {
		return aspShopStatus;
	}

	/**
	 * 状態を設定します。
	 *
	 * @param aspShopStatus
	 *            状態
	 */
	public void setAspShopStatus(String aspShopStatus) {
		this.aspShopStatus = aspShopStatus;
	}

	/**
	 * 沿線タイプ1を取得します。
	 *
	 * @return 沿線タイプ1
	 */
	public String getEnsenType1() {
		return ensenType1;
	}

	/**
	 * 沿線タイプ1を設定します。
	 *
	 * @param ensenType1
	 *            沿線タイプ1
	 */
	public void setEnsenType1(String ensenType1) {
		this.ensenType1 = ensenType1;
	}

	/**
	 * 沿線タイプ2を取得します。
	 *
	 * @return 沿線タイプ2
	 */
	public String getEnsenType2() {
		return ensenType2;
	}

	/**
	 * 沿線タイプ2を設定します。
	 *
	 * @param ensenType2
	 *            沿線タイプ2
	 */
	public void setEnsenType2(String ensenType2) {
		this.ensenType2 = ensenType2;
	}

	/**
	 * 沿線タイプ3を取得します。
	 *
	 * @return 沿線タイプ3
	 */
	public String getEnsenType3() {
		return ensenType3;
	}

	/**
	 * 沿線タイプ3を設定します。
	 *
	 * @param ensenType3
	 *            沿線タイプ3
	 */
	public void setEnsenType3(String ensenType3) {
		this.ensenType3 = ensenType3;
	}

	/**
	 * 最終更新日付を取得します。
	 *
	 * @return 最終更新日付
	 */
	 public String getUpdDt() {
	     return updDt;
	 }

	/**
	 * 最終更新日付を設定します。
	 *
	 * @param updDt
	 *            最終更新日付
	 */
	 public void setUpdDt(String updDt) {
	     this.updDt = updDt;
	 }

	/**
	 * 登録日付を取得します。
	 *
	 * @return 登録日付
	 */
	 public String getInsDt() {
	     return insDt;
	 }

	/**
	 * 登録日付を設定します。
	 *
	 * @param insDt
	 *            登録日付
	 */
	 public void setInsDt(String insDt) {
	     this.insDt = insDt;
	 }

	/**
	 * 適用開始日を取得します。
	 *
	 * @return 適用開始日(yyyyMMdd24hhmmss)
	 */
	public String getAppStartDt() {
		return appStartDt;
	}

	/**
	 * 適用開始日を設定します。
	 *
	 * @param appStartDt
	 *            適用開始日
	 */
	public void setAppStartDt(String appStartDt) {
		this.appStartDt = appStartDt;
	}

	/**
	 * 不動産ＡＳＰ連番を取得します。
	 *
	 * @return 不動産ＡＳＰ連番
	 */
	public Long getAspShopSeq() {
		return aspShopSeq;
	}

	/**
	 * 不動産ＡＳＰ連番を設定します。
	 *
	 * @param aspShopSeq
	 *            不動産ＡＳＰ連番
	 */
	public void setAspShopSeq(Long aspShopSeq) {
		this.aspShopSeq = aspShopSeq;
	}

	/**
	 * レコード作成プログラムＩＤを返します。
	 *
	 * @return レコード作成プログラムＩＤ
	 */
	public String getInsPg() {
		return insPg;
	}

	/**
	 * レコード作成プログラムＩＤを設定します。
	 *
	 * @param insPg
	 *            レコード作成プログラムＩＤ
	 */
	public void setInsPg(String insPg) {
		this.insPg = insPg;
	}

	/**
	 * レコード作成者を返します。
	 *
	 * @return レコード作成者
	 */
	public String getInsId() {
		return insId;
	}

	/**
	 * レコード作成者を設定します。
	 *
	 * @param insId
	 *            レコード作成者
	 */
	public void setInsId(String insId) {
		this.insId = insId;
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

}

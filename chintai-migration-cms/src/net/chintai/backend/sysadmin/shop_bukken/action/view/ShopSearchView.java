/*
 * $Id: ShopSearchView.java 3853 2008-03-10 05:43:48Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.pager.PagerCondition;
import net.chintai.backend.sysadmin.common.pager.PagerViewHelper;

/**
 * 店舗検索一覧のViewHelper
 *
 * @author Sim-JongYeon
 * @version $Revision: 3853 $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSearchView extends PagerViewHelper {

	/**
	 * コンストラクター
	 * @param condition
	 */
	public ShopSearchView(final PagerCondition condition) {
		super(condition);
	}

	/** 検索条件 : 店舗コード */
	private String shopCd;

	/** 検索条件 : 店舗メール */
	private String shopEmail;

	/** 検索条件 : 代表者名 */
	private String licTrustName;

	/** 検索条件 : 代表TEL/FAX */
	private String shopTelFax;

	/** 検索条件 : 会社名/事務所名 */
	private String companyBumonName;

	/** 検索条件 : AND/OR */
	private String andOrmode;

	/** 検索条件 : ユーザ最終更新日（下限） */
	private String updateFrom;

	/** 検索条件 : ユーザ最終更新日（下限:年） */
	private String updDtFromYear;

	/** 検索条件 : ユーザ最終更新日（下限:月） */
	private String updDtFromMonth;

	/** 検索条件 : ユーザ最終更新日（下限:日） */
	private String updDtFromDay;

	/** 検索条件 : ユーザ最終更新日（下限:時） */
	private String updDtFromTime;

	/** 検索条件 : ユーザ最終更新日（上限） */
	private String updateTo;

	/** 検索条件 : ユーザ最終更新日（上限:年） */
	private String updDtToYear;

	/** 検索条件 : ユーザ最終更新日（上限:月） */
	private String updDtToMonth;

	/** 検索条件 : ユーザ最終更新日（上限:日） */
	private String updDtToDay;

	/** 検索条件 : ユーザ最終更新日（上限:時） */
	private String updDtToTime;

	/** 有効物件数が 0 の店舗だけを表示フラグ */
	private String noBukkenShop;

	/** 検索条件 : 承認 */
	private String certifyFlg;

	/** 検索条件 : 状態 */
	private String shopStatus;

	/** 検索条件 : CHINTAI掲載 */
	private String ctFlg;

	/** 検索条件 : エイブル掲載 */
	private String ablFlg;

	/** 検索条件 : データ元 */
	private String clientSystemType;

	/** 検索条件 : ASP */
	private String aspFlg;

	/** 検索条件 : 売買 */
	private String adparkFlg;

	/** 検索条件 : エリア */
	private String area;

	/** 検索条件 : 地域/沿線 */
	private String kbnAreaRosen;

	/** 検索条件 : 都道府県 */
	private String pref;

	/** 検索条件 : 市区町村 */
	private String city;

	/** 検索条件 : 沿線 */
	private String ensenType;

	/** 検索条件 : 沿線 */
	private String ensen;

	/** 検索条件 : 駅 */
	private String eki;

	/** 検索条件 : ソートキー */
	private String sortKey;

	/** 検索条件 : 順序 */
	private String orderBy;

	/** 検索条件 : 表示件数 */
	private String displayNum;

	/** 検索条件 : 出力先 */
	private String outputMode;

	/** 店舗検索結果リスト */
	private List<ShopSearchDetailView> shopSearchList;

	private String rendoCd;

	private Map<String, String> shopKeiyakus = new HashMap<>();

	/**
	 * @return shopKeiyakus
	 */
	public Map<String, String> getShopKeiyakus() {
		return this.shopKeiyakus;
	}

	/**
	 * @param shopKeiyakus the shopKeiyakus to set
	 */
	public void setShopKeiyakus(final Map<String, String> shopKeiyakus) {
		this.shopKeiyakus = shopKeiyakus;
	}

	/**
	 * @return rendoCd
	 */
	public String getRendoCd() {
		return this.rendoCd;
	}

	/**
	 * @param rendoCd the rendoCd to set
	 */
	public void setRendoCd(final String rendoCd) {
		this.rendoCd = rendoCd;
	}

	/**
	 * 店舗検索結果リストを取得します。
	 * @return 店舗検索結果リスト
	 */
	public List<ShopSearchDetailView> getShopSearchList() {
		return this.shopSearchList;
	}

	/**
	 * 店舗検索結果リストを設定します。
	 * @param shopSearchList 店舗検索結果リスト
	 */
	public void setShopSearchList(final List<ShopSearchDetailView> shopSearchList) {
		this.shopSearchList = shopSearchList;
	}

	/**
	 * 検索条件 : 店舗コードを取得します。
	 * @return 検索条件 : 店舗コード
	 */
	public String getShopCd() {
		return this.shopCd;
	}

	/**
	 * 検索条件 : 店舗コードを設定します。
	 * @param shopCd 検索条件 : 店舗コード
	 */
	public void setShopCd(final String shopCd) {
		this.shopCd = shopCd;
	}

	/**
	 * 検索条件 : 店舗メールを取得します。
	 * @return 検索条件 : 店舗メール
	 */
	public String getShopEmail() {
		return this.shopEmail;
	}

	/**
	 * 検索条件 : 店舗メールを設定します。
	 * @param shopEmail 検索条件 : 店舗メール
	 */
	public void setShopEmail(final String shopEmail) {
		this.shopEmail = shopEmail;
	}

	/**
	 * 検索条件 : 代表者名を取得します。
	 * @return 検索条件 : 代表者名
	 */
	public String getLicTrustName() {
		return this.licTrustName;
	}

	/**
	 * 検索条件 : 代表者名を設定します。
	 * @param licTrustName 検索条件 : 代表者名
	 */
	public void setLicTrustName(final String licTrustName) {
		this.licTrustName = licTrustName;
	}

	/**
	 * 検索条件 : 代表TEL/FAXを取得します。
	 * @return 検索条件 : 代表TEL/FAX
	 */
	public String getShopTelFax() {
		return this.shopTelFax;
	}

	/**
	 * 検索条件 : 代表TEL/FAXを設定します。
	 * @param shopTelFax 検索条件 : 代表TEL/FAX
	 */
	public void setShopTelFax(final String shopTelFax) {
		this.shopTelFax = shopTelFax;
	}

	/**
	 * 検索条件 : 会社名/事務所名を取得します。
	 * @return 検索条件 : 会社名/事務所名
	 */
	public String getCompanyBumonName() {
		return this.companyBumonName;
	}

	/**
	 * 検索条件 : 会社名/事務所名を設定します。
	 * @param companyBumonName 検索条件 : 会社名/事務所名
	 */
	public void setCompanyBumonName(final String companyBumonName) {
		this.companyBumonName = companyBumonName;
	}

	/**
	 * 検索条件 : AND/ORを取得します。
	 * @return 検索条件 : AND/OR
	 */
	public String getAndOrmode() {
		return this.andOrmode;
	}

	/**
	 * 検索条件 : AND/ORを設定します。
	 * @param andOrmode 検索条件 : AND/OR
	 */
	public void setAndOrmode(final String andOrmode) {
		this.andOrmode = andOrmode;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（下限）を取得します。
	 * @return 検索条件 : ユーザ最終更新日（下限）
	 */
	public String getUpdateFrom() {
		return this.updateFrom;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（下限）を設定します。
	 * @param updateFrom 検索条件 : ユーザ最終更新日（下限）
	 */
	public void setUpdateFrom(final String updateFrom) {
		this.updateFrom = updateFrom;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（上限）を取得します。
	 * @return 検索条件 : ユーザ最終更新日（上限）
	 */
	public String getUpdateTo() {
		return this.updateTo;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（上限）を設定します。
	 * @param updateTo 検索条件 : ユーザ最終更新日（上限）
	 */
	public void setUpdateTo(final String updateTo) {
		this.updateTo = updateTo;
	}

	/**
	 * 検索条件 : 承認を取得します。
	 * @return 検索条件 : 承認
	 */
	public String getCertifyFlg() {
		return this.certifyFlg;
	}

	/**
	 * 検索条件 : 承認を設定します。
	 * @param certifyFlg 検索条件 : 承認
	 */
	public void setCertifyFlg(final String certifyFlg) {
		this.certifyFlg = certifyFlg;
	}

	/**
	 * 検索条件 : 状態を取得します。
	 * @return 検索条件 : 状態
	 */
	public String getShopStatus() {
		return this.shopStatus;
	}

	/**
	 * 検索条件 : 状態を設定します。
	 * @param shopStatus 検索条件 : 状態
	 */
	public void setShopStatus(final String shopStatus) {
		this.shopStatus = shopStatus;
	}

	/**
	 * 検索条件 : データ元を取得します。
	 * @return 検索条件 : データ元
	 */
	public String getClientSystemType() {
		return this.clientSystemType;
	}

	/**
	 * 検索条件 : データ元を設定します。
	 * @param clientSystemType 検索条件 : データ元
	 */
	public void setClientSystemType(final String clientSystemType) {
		this.clientSystemType = clientSystemType;
	}

	/**
	 * 検索条件 : ASPを取得します。
	 * @return 検索条件 : ASP
	 */
	public String getAspFlg() {
		return this.aspFlg;
	}

	/**
	 * 検索条件 : ASPを設定します。
	 * @param aspFlg 検索条件 : ASP
	 */
	public void setAspFlg(final String aspFlg) {
		this.aspFlg = aspFlg;
	}

	/**
	 * 検索条件 : 売買を取得します。
	 * @return 検索条件 : 売買
	 */
	public String getAdparkFlg() {
		return this.adparkFlg;
	}

	/**
	 * 検索条件 : 売買を設定します。
	 * @param adparkFlg 検索条件 : 売買
	 */
	public void setAdparkFlg(final String adparkFlg) {
		this.adparkFlg = adparkFlg;
	}

	/**
	 * 検索条件 : エリアを取得します。
	 * @return 検索条件 : エリア
	 */
	public String getArea() {
		return this.area;
	}

	/**
	 * 検索条件 : エリアを設定します。
	 * @param area 検索条件 : エリア
	 */
	public void setArea(final String area) {
		this.area = area;
	}

	/**
	 * 検索条件 : 地域/沿線を取得します。
	 * @return 検索条件 : 地域/沿線
	 */
	public String getKbnAreaRosen() {
		return this.kbnAreaRosen;
	}

	/**
	 * 検索条件 : 地域/沿線を設定します。
	 * @param kbnAreaRosen 検索条件 : 地域/沿線
	 */
	public void setKbnAreaRosen(final String kbnAreaRosen) {
		this.kbnAreaRosen = kbnAreaRosen;
	}

	/**
	 * 検索条件 : 都道府県を取得します。
	 * @return 検索条件 : 都道府県
	 */
	public String getPref() {
		return this.pref;
	}

	/**
	 * 検索条件 : 都道府県を設定します。
	 * @param pref 検索条件 : 都道府県
	 */
	public void setPref(final String pref) {
		this.pref = pref;
	}

	/**
	 * 検索条件 : 市区町村を取得します。
	 * @return 検索条件 : 市区町村
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * 検索条件 : 市区町村を設定します。
	 * @param city 検索条件 : 市区町村
	 */
	public void setCity(final String city) {
		this.city = city;
	}

	/**
	 * 検索条件 : 沿線を取得します。
	 * @return 検索条件 : 沿線
	 */
	public String getEnsenType() {
		return this.ensenType;
	}

	/**
	 * 検索条件 : 沿線を設定します。
	 * @param ensenType 検索条件 : 沿線
	 */
	public void setEnsenType(final String ensenType) {
		this.ensenType = ensenType;
	}

	/**
	 * 検索条件 : 沿線を取得します。
	 * @return 検索条件 : 沿線
	 */
	public String getEnsen() {
		return this.ensen;
	}

	/**
	 * 検索条件 : 沿線を設定します。
	 * @param ensen 検索条件 : 沿線
	 */
	public void setEnsen(final String ensen) {
		this.ensen = ensen;
	}

	/**
	 * 検索条件 : 駅を取得します。
	 * @return 検索条件 : 駅
	 */
	public String getEki() {
		return this.eki;
	}

	/**
	 * 検索条件 : 駅を設定します。
	 * @param eki 検索条件 : 駅
	 */
	public void setEki(final String eki) {
		this.eki = eki;
	}

	/**
	 * 検索条件 : ソートキーを取得します。
	 * @return 検索条件 : ソートキー
	 */
	public String getSortKey() {
		return this.sortKey;
	}

	/**
	 * 検索条件 : ソートキーを設定します。
	 * @param sortKey 検索条件 : ソートキー
	 */
	public void setSortKey(final String sortKey) {
		this.sortKey = sortKey;
	}

	/**
	 * 検索条件 : 順序を取得します。
	 * @return 検索条件 : 順序
	 */
	public String getOrderBy() {
		return this.orderBy;
	}

	/**
	 * 検索条件 : 順序を設定します。
	 * @param orderBy 検索条件 : 順序
	 */
	public void setOrderBy(final String orderBy) {
		this.orderBy = orderBy;
	}

	/**
	 * 検索条件 : 表示件数を取得します。
	 * @return 検索条件 : 表示件数
	 */
	public String getDisplayNum() {
		return this.displayNum;
	}

	/**
	 * 検索条件 : 表示件数を設定します。
	 * @param displayNum 検索条件 : 表示件数
	 */
	public void setDisplayNum(final String displayNum) {
		this.displayNum = displayNum;
	}

	/**
	 * 検索条件 : 出力先を取得します。
	 * @return 検索条件 : 出力先
	 */
	public String getOutputMode() {
		return this.outputMode;
	}

	/**
	 * 検索条件 : 出力先を設定します。
	 * @param outputMode 検索条件 : 出力先
	 */
	public void setOutputMode(final String outputMode) {
		this.outputMode = outputMode;
	}

	/**
	 * 検索条件 : エイブル掲載を取得します。
	 * @return 検索条件 : エイブル掲載
	 */
	public String getAblFlg() {
		return this.ablFlg;
	}

	/**
	 * 検索条件 : エイブル掲載を設定します。
	 * @param ablFlg 検索条件 : エイブル掲載
	 */
	public void setAblFlg(final String ablFlg) {
		this.ablFlg = ablFlg;
	}

	/**
	 * 検索条件 : CHINTAI掲載を取得します。
	 * @return 検索条件 : CHINTAI掲載
	 */
	public String getCtFlg() {
		return this.ctFlg;
	}

	/**
	 * 検索条件 : CHINTAI掲載を設定します。
	 * @param ctFlg 検索条件 : CHINTAI掲載
	 */
	public void setCtFlg(final String ctFlg) {
		this.ctFlg = ctFlg;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（下限:日）を取得します。
	 * @return 検索条件 : ユーザ最終更新日（下限:日）
	 */
	public String getUpdDtFromDay() {
		return this.updDtFromDay;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（下限:日）を設定します。
	 * @param updDtFromDay 検索条件 : ユーザ最終更新日（下限:日）
	 */
	public void setUpdDtFromDay(final String updDtFromDay) {
		this.updDtFromDay = updDtFromDay;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（下限:月）を取得します。
	 * @return 検索条件 : ユーザ最終更新日（下限:月）
	 */
	public String getUpdDtFromMonth() {
		return this.updDtFromMonth;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（下限:月）を設定します。
	 * @param updDtFromMonth 検索条件 : ユーザ最終更新日（下限:月）
	 */
	public void setUpdDtFromMonth(final String updDtFromMonth) {
		this.updDtFromMonth = updDtFromMonth;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（下限:時）を取得します。
	 * @return 検索条件 : ユーザ最終更新日（下限:時）
	 */
	public String getUpdDtFromTime() {
		return this.updDtFromTime;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（下限:時）を設定します。
	 * @param updDtFromTime 検索条件 : ユーザ最終更新日（下限:時）
	 */
	public void setUpdDtFromTime(final String updDtFromTime) {
		this.updDtFromTime = updDtFromTime;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（下限:年）を取得します。
	 * @return 検索条件 : ユーザ最終更新日（下限:年）
	 */
	public String getUpdDtFromYear() {
		return this.updDtFromYear;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（下限:年）を設定します。
	 * @param updDtFromYear 検索条件 : ユーザ最終更新日（下限:年）
	 */
	public void setUpdDtFromYear(final String updDtFromYear) {
		this.updDtFromYear = updDtFromYear;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（上限:日）を取得します。
	 * @return 検索条件 : ユーザ最終更新日（上限:日）
	 */
	public String getUpdDtToDay() {
		return this.updDtToDay;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（上限:日）を設定します。
	 * @param updDtToDay 検索条件 : ユーザ最終更新日（上限:日）
	 */
	public void setUpdDtToDay(final String updDtToDay) {
		this.updDtToDay = updDtToDay;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（上限:月）を取得します。
	 * @return 検索条件 : ユーザ最終更新日（上限:月）
	 */
	public String getUpdDtToMonth() {
		return this.updDtToMonth;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（上限:月）を設定します。
	 * @param updDtToMonth 検索条件 : ユーザ最終更新日（上限:月）
	 */
	public void setUpdDtToMonth(final String updDtToMonth) {
		this.updDtToMonth = updDtToMonth;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（上限:時）を取得します。
	 * @return 検索条件 : ユーザ最終更新日（上限:時）
	 */
	public String getUpdDtToTime() {
		return this.updDtToTime;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（上限:時）を設定します。
	 * @param updDtToTime 検索条件 : ユーザ最終更新日（上限:時）
	 */
	public void setUpdDtToTime(final String updDtToTime) {
		this.updDtToTime = updDtToTime;
	}

	/**
	 * 有効物件数が 0 の店舗だけを表示フラグを取得します。
	 * @return 有効物件数が 0 の店舗だけを表示フラグ
	 */
	public String getNoBukkenShop() {
		return this.noBukkenShop;
	}

	/**
	 * 有効物件数が 0 の店舗だけを表示フラグを設定します。
	 * @param noBukkenShop 有効物件数が 0 の店舗だけを表示フラグ
	 */
	public void setNoBukkenShop(final String noBukkenShop) {
		this.noBukkenShop = noBukkenShop;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（上限:年）を取得します。
	 * @return 検索条件 : ユーザ最終更新日（上限:年）
	 */
	public String getUpdDtToYear() {
		return this.updDtToYear;
	}

	/**
	 * 検索条件 : ユーザ最終更新日（上限:年）を設定します。
	 * @param updDtToYear 検索条件 : ユーザ最終更新日（上限:年）
	 */
	public void setUpdDtToYear(final String updDtToYear) {
		this.updDtToYear = updDtToYear;
	}

	/**
	 * 店舗検索詳細Innerクラス
	 *
	 * @author Sim-JongYeon
	 */
	public class ShopSearchDetailView {

		/** 店舗コード */
		private String shopCd;

		/** 会社名 */
		private String company;

		/** 事務所名 */
		private String bumon;

		/** 店舗メールアドレス */
		private String email;

		/** 代表者名 */
		private String licTrust;

		/** 代表Tel */
		private String tel;

		/** 代表Fax */
		private String fax;

		/** 承認 */
		private String certifyFlg;

		/** 状態 */
		private String shopStatus;

		/** CHINTAI掲載 */
		private String ctFlg;

		/** エイブル掲載 */
		private String ablFlg;

		/** データ元 */
		private String clientsystemType;

		/** ASP */
		private String aspCnt;

		/** 売買 */
		private String adparkSendFlg;

		/** 店舗最終更新日時 */
		private String shopUpdDt;

		/** 管理最終更新日時 */
		private String adminUpdDt;

		/** 最終更新日時 */
		private String updDt;

	    private String rendoCd;

	    private String rendoName;


		/**
		 * @return rendoCd
		 */
		public String getRendoCd() {
			return rendoCd;
		}

		/**
		 * @param rendoCd the rendoCd to set
		 */
		public void setRendoCd(String rendoCd) {
			this.rendoCd = rendoCd;
		}

		/**
		 * @return rendoName
		 */
		public String getRendoName() {
			return rendoName;
		}

		/**
		 * @param rendoName the rendoName to set
		 */
		public void setRendoName(String rendoName) {
			this.rendoName = rendoName;
		}

		/**
		 * 店舗コードを取得します。
		 * @return 店舗コード
		 */
		public String getShopCd() {
			return this.shopCd;
		}

		/**
		 * 店舗コードを設定します。
		 * @param shopCd 店舗コード
		 */
		public void setShopCd(final String shopCd) {
			this.shopCd = shopCd;
		}

		/**
		 * 会社名を取得します。
		 * @return 会社名
		 */
		public String getCompany() {
			return this.company;
		}

		/**
		 * 会社名を設定します。
		 * @param company 会社名
		 */
		public void setCompany(final String company) {
			this.company = company;
		}

		/**
		 * 事務所名を取得します。
		 * @return 事務所名
		 */
		public String getBumon() {
			return this.bumon;
		}

		/**
		 * 事務所名を設定します。
		 * @param bumon 事務所名
		 */
		public void setBumon(final String bumon) {
			this.bumon = bumon;
		}

		/**
		 * 店舗メールアドレスを取得します。
		 * @return 店舗メールアドレス
		 */
		public String getEmail() {
			return this.email;
		}

		/**
		 * 店舗メールアドレスを設定します。
		 * @param email 店舗メールアドレス
		 */
		public void setEmail(final String email) {
			this.email = email;
		}

		/**
		 * 代表者名を取得します。
		 * @return 代表者名
		 */
		public String getLicTrust() {
			return this.licTrust;
		}

		/**
		 * 代表者名を設定します。
		 * @param licTrust 代表者名
		 */
		public void setLicTrust(final String licTrust) {
			this.licTrust = licTrust;
		}

		/**
		 * 代表Telを取得します。
		 * @return 代表Tel
		 */
		public String getTel() {
			return this.tel;
		}

		/**
		 * 代表Telを設定します。
		 * @param tel 代表Tel
		 */
		public void setTel(final String tel) {
			this.tel = tel;
		}

		/**
		 * 代表Faxを取得します。
		 * @return 代表Fax
		 */
		public String getFax() {
			return this.fax;
		}

		/**
		 * 代表Faxを設定します。
		 * @param fax 代表Fax
		 */
		public void setFax(final String fax) {
			this.fax = fax;
		}

		/**
		 * 承認を取得します。
		 * @return 承認
		 */
		public String getCertifyFlg() {
			return this.certifyFlg;
		}

		/**
		 * 承認を設定します。
		 * @param certifyFlg 承認
		 */
		public void setCertifyFlg(final String certifyFlg) {
			this.certifyFlg = certifyFlg;
		}

		/**
		 * 状態を取得します。
		 * @return 状態
		 */
		public String getShopStatus() {
			return this.shopStatus;
		}

		/**
		 * 状態を設定します。
		 * @param shopStatus 状態
		 */
		public void setShopStatus(final String shopStatus) {
			this.shopStatus = shopStatus;
		}

		/**
		 * CHINTAI掲載を取得します。
		 * @return CHINTAI掲載
		 */
		public String getCtFlg() {
			return this.ctFlg;
		}

		/**
		 * CHINTAI掲載を設定します。
		 * @param ctFlg CHINTAI掲載
		 */
		public void setCtFlg(final String ctFlg) {
			this.ctFlg = ctFlg;
		}

		/**
		 * エイブル掲載を取得します。
		 * @return エイブル掲載
		 */
		public String getAblFlg() {
			return this.ablFlg;
		}

		/**
		 * エイブル掲載を設定します。
		 * @param ablFlg エイブル掲載
		 */
		public void setAblFlg(final String ablFlg) {
			this.ablFlg = ablFlg;
		}

		/**
		 * データ元を取得します。
		 * @return データ元
		 */
		public String getClientsystemType() {
			return this.clientsystemType;
		}

		/**
		 * データ元を設定します。
		 * @param clientsystemType データ元
		 */
		public void setClientsystemType(final String clientsystemType) {
			this.clientsystemType = clientsystemType;
		}

		/**
		 * ASPを取得します。
		 * @return ASP
		 */
		public String getAspCnt() {
			return this.aspCnt;
		}

		/**
		 * ASPを設定します。
		 * @param aspCnt ASP
		 */
		public void setAspCnt(final String aspCnt) {
			this.aspCnt = aspCnt;
		}

		/**
		 * 売買を取得します。
		 * @return 売買
		 */
		public String getAdparkSendFlg() {
			return this.adparkSendFlg;
		}

		/**
		 * 売買を設定します。
		 * @param adparkSendFlg 売買
		 */
		public void setAdparkSendFlg(final String adparkSendFlg) {
			this.adparkSendFlg = adparkSendFlg;
		}

		/**
		 * 店舗最終更新日時を取得します。
		 * @return 店舗最終更新日時
		 */
		public String getShopUpdDt() {
			return this.shopUpdDt;
		}

		/**
		 * 店舗最終更新日時を設定します。
		 * @param shopUpdDt 店舗最終更新日時
		 */
		public void setShopUpdDt(final String shopUpdDt) {
			this.shopUpdDt = shopUpdDt;
		}

		/**
		 * 管理最終更新日時を取得します。
		 * @return 管理最終更新日時
		 */
		public String getAdminUpdDt() {
			return this.adminUpdDt;
		}

		/**
		 * 管理最終更新日時を設定します。
		 * @param adminUpdDt 管理最終更新日時
		 */
		public void setAdminUpdDt(final String adminUpdDt) {
			this.adminUpdDt = adminUpdDt;
		}

		/**
		 * 最終更新日時を取得します。
		 * @return 最終更新日時
		 */
		public String getUpdDt() {
			return this.updDt;
		}

		/**
		 * 最終更新日時を設定します。
		 * @param updDt 最終更新日時
		 */
		public void setUpdDt(final String updDt) {
			this.updDt = updDt;
		}
	}
}

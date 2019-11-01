/*
 * $Id: ShopDetailInfoSearchOutServiceBean.java 4590 2013-08-02 08:31:23Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)沈鍾沿     新規作成
 * 2009/03/23  BGT)李昊燮     「地図上の店舗アイコン表示状態」コメント処理
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 * 2013/08/02  BGT)亀田拓真   店舗電話番号表示変更にて3項目追加
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

import java.util.List;

import net.chintai.backend.sysadmin.crnwl.dto.BukkenCount;
import net.chintai.batch.common.domain.CtNayoseSkipShop;
import net.chintai.batch.common.domain.PpcInfo;
import net.chintai.batch.common.domain.ShopReserve;
import net.chintai.batch.common.domain.ShopRireki;
import net.chintai.batch.common.domain.ShopRirekiCampaign;
import net.chintai.batch.common.domain.ShopRirekiCharacter;
import net.chintai.batch.common.domain.ShopRirekiComment;
import net.chintai.batch.common.domain.ShopRirekiEki;
import net.chintai.batch.common.domain.ShopRirekiImg;
import net.chintai.batch.common.domain.ShopRirekiProudArea;
import net.chintai.batch.common.domain.ShopRirekiProudEki;
import net.chintai.batch.common.domain.ShopRirekiStaff;
import net.chintai.batch.common.domain.VAspGroupShop;
import net.chintai.batch.common.domain.VShopKeiyakuDetail;

/**
 * 店舗詳細OutServiceBean
 *
 * @author Sim-JongYeon
 * @version $Revision: 4590 $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopDetailInfoSearchOutServiceBean {

	/** 店舗名(会社名) */
	private String company;

	/** 店舗名(事務所名) */
	private String bumon;

	/** 店舗コード */
	private String shopCd;

	/** お客様設定パスワード */
	private String password;

	/** 所属団体名 */
	private String dantai;

	/** 代表者名 */
	private String licTrust;

	/** グループ名 */
	private String groupName;

	/** 郵便番号 */
	private String zipCd;

	/** 住所（都道府県、市区町村） */
	private String address1;

	/** 住所（地先） */
	private String address2;

	/** TEL */
	private String tel;

	// 2013/07/25 店舗電話番号変更対応２次リリース分 ３項目追加
	/** フリーコール用TEL */
	private String shopTelFree;

	/** 電話番号選択 */
	private String shopTelKbn;

	/** 雑誌用TEL */
	private String shopTelMagazine;

	// 2013/7/25 end

	/** FAX */
	private String fax;

	/** エリアコード */
	private String areaCd;

	/** 地域(エリア) */
	private String areaName;

	/** 都道府県コード */
	private String prefCd;

	/** 地域(都道府県) */
	private String prefName;

	/** 市区町村コード */
	private String cityCd;

	/** 地域(市区町村) */
	private String cityName;

	/** 沿線エリアコード */
	private String ensenAreaCd;

	/** 沿線タイプ */
	private String ensenType;

	/** 沿線コード */
	private String ensenCd;

	/** 沿線(沿線) */
	private String ensenName;

	/** 駅名コード */
	private String ekiCd;

	/** 沿線(駅名) */
	private String ekiName;

	/** 免許証番号 */
	private String licNum;

	/** 免許証登録日 */
	private String licEntry;

	/** 免許証有効期限 */
	private String licValid;

	/** 宅建取引主任者名 */
	private String licChief;

	/** 担当者名 */
	private String tantou;

	/** ホームページリンク名称 */
	private String hpName;

	/** 自社ホームページURL */
	private String hpUrl;

	/** メールアドレス */
	private String email;

	/** 営業時間 */
	private String businessHours;

	/** 定休日 */
	private String holiday;

	/** 混雑時間帯(曜日) */
	private String busyComment;

	/** 連絡方法 */
	private String fmKbn;

	/** 最終サインアップ日 */
	private String lastLoginDt;

	/** 店舗最終更新日時 */
	private String shopUpdDt;

	/** 承認状態 */
	private String certifyFlg;

	/** 状態 */
	private String shopStatus;

	/** レコード情報(CHINTAIに掲載) */
	private String ctFlg;

	/** レコード情報(エイブルに掲載) */
	private String ablFlg;

	/** レコード情報(送信元アプリケーション) */
	private String clientsystemType;

	/** レコード情報(不動産会社に探してもらう) */
	private String shopSiteRole;

	/** 備考 */
	private String adminNote;

	/** 管理最終更新日時 */
	private String adminUpdDt;

	/** Pickup不動産 */
	private String pickUpCnt;

	/** 不動産ASP */
	private String aspCnt;

	/** 売買(アドパーク送信) */
	private String adparkSendFlg;

	/** Webログ利用可否 */
	private String webLogFlg;

	/** 店舗地図表示フラグ */
	private String shopMapPctFlgOrg;

	/** 店舗画像(左側)表示フラグ */
	private String shopPhoto1FlgOrg;

	/** 店舗画像(右側)表示フラグ */
	private String shopPhoto2FlgOrg;

	/** 店舗地図パス */
	private String shopMapPctFilePath;

	/** 店舗画像(左側)パス */
	private String shopPhoto1FilePath;

	/** 店舗画像(右側)パス */
	private String shopPhoto2FilePath;

	/** 店舗画像3(店内写真)表示フラグ */
	private String shopPhoto3FlgOrg;

	/** 店舗画像4(スタッフ接客写真) */
	private String shopPhoto4FlgOrg;

	/** 店舗画像3(店内写真)パス */
	private String shopPhoto3FilePath;

	/** 店舗画像4(スタッフ接客写真)パス */
	private String shopPhoto4FilePath;

	/** 店舗地図コメント */
	private String shopMapPctComment;

	/** 店舗画像１(店内写真)コメント */
	private String shopPhoto1Comment;

	/** 店舗画像２(スタッフ写真)コメント */
	private String shopPhoto2Comment;

	/** 店舗画像３(店内写真)コメント */
	private String shopPhoto3Comment;

	/** 店舗画像４(スタッフ接客写真)コメント */
	private String shopPhoto4Comment;

	/** 店舗名かな */
	private String bumonKana;

	// ** 地図上の店舗アイコン表示状態 */
	// private String shopIconDelFlg;
	// 2009/03/23 李昊燮 「地図上の店舗アイコン表示状態」削除

	/** 有効物件数CHINTAI */
	private String chintaiBukkenCount;

	/** 有効物件数エイブル */
	private String ableBukkenCount;

	/** 最終更新日時 */
	private String updDt;

    private Integer pkShopRireki;

	private List<ShopRirekiEki> shopRirekiEkis;

	private ShopRireki shopRireki;

	private List<VAspGroupShop> vAspGroupShops;

	private List<VShopKeiyakuDetail> vShopKeiyakuDetails;

	private BukkenCount bukkenCount;

	private List<ShopRirekiImg> shopRirekiImgs;

	private List<ShopRirekiComment> shopRirekiComments;

	private List<ShopRirekiProudArea> shopRirekiProudAreas;

	private List<ShopRirekiProudEki> shopRirekiProudEkis;

	private List<ShopRirekiCharacter> shopRirekiCharacters;

	private List<ShopRirekiStaff> shopRirekiStaffs;

	private List<ShopRirekiCampaign> shopRirekiCampaigns;

	private CtNayoseSkipShop ctNayoseSkipShop;

	private List<PpcInfo> ppcInfo;

	private List<ShopReserve> shopReserve;

	private String rendoCd;

	private String certifyChkFlg;

	private String ctShisyaCd;

	private String inqMngEmail;

	private String noticeEmail;

	private String locationX;

	private String locationY;

	// 2015/12/10 櫻庭哲史 店舗LINE＠ID追加
	/** 店舗LINE＠ID */
	private String lineAccount;

	/**
	 * @return ctNayoseSkipShop
	 */
	public CtNayoseSkipShop getCtNayoseSkipShop() {
		return this.ctNayoseSkipShop;
	}

	/**
	 * @param ctNayoseSkipShop the ctNayoseSkipShop to set
	 */
	public void setCtNayoseSkipShop(final CtNayoseSkipShop ctNayoseSkipShop) {
		this.ctNayoseSkipShop = ctNayoseSkipShop;
	}

	/**
	 * @return shopRirekiCampaigns
	 */
	public List<ShopRirekiCampaign> getShopRirekiCampaigns() {
		return this.shopRirekiCampaigns;
	}

	/**
	 * @param shopRirekiCampaigns the shopRirekiCampaigns to set
	 */
	public void setShopRirekiCampaigns(final List<ShopRirekiCampaign> shopRirekiCampaigns) {
		this.shopRirekiCampaigns = shopRirekiCampaigns;
	}

	/**
	 * @return shopRirekiStaffs
	 */
	public List<ShopRirekiStaff> getShopRirekiStaffs() {
		return this.shopRirekiStaffs;
	}

	/**
	 * @param shopRirekiStaffs the shopRirekiStaffs to set
	 */
	public void setShopRirekiStaffs(final List<ShopRirekiStaff> shopRirekiStaffs) {
		this.shopRirekiStaffs = shopRirekiStaffs;
	}

	/**
	 * @return shopRirekiComments
	 */
	public List<ShopRirekiComment> getShopRirekiComments() {
		return this.shopRirekiComments;
	}

	/**
	 * @param shopRirekiComments the shopRirekiComments to set
	 */
	public void setShopRirekiComments(final List<ShopRirekiComment> shopRirekiComments) {
		this.shopRirekiComments = shopRirekiComments;
	}

	/**
	 * @return shopRirekiProudAreas
	 */
	public List<ShopRirekiProudArea> getShopRirekiProudAreas() {
		return this.shopRirekiProudAreas;
	}

	/**
	 * @param shopRirekiProudAreas the shopRirekiProudAreas to set
	 */
	public void setShopRirekiProudAreas(final List<ShopRirekiProudArea> shopRirekiProudAreas) {
		this.shopRirekiProudAreas = shopRirekiProudAreas;
	}

	/**
	 * @return shopRirekiProudEkis
	 */
	public List<ShopRirekiProudEki> getShopRirekiProudEkis() {
		return this.shopRirekiProudEkis;
	}

	/**
	 * @param shopRirekiProudEkis the shopRirekiProudEkis to set
	 */
	public void setShopRirekiProudEkis(final List<ShopRirekiProudEki> shopRirekiProudEkis) {
		this.shopRirekiProudEkis = shopRirekiProudEkis;
	}

	/**
	 * @return shopRirekiCharacters
	 */
	public List<ShopRirekiCharacter> getShopRirekiCharacters() {
		return this.shopRirekiCharacters;
	}

	/**
	 * @param shopRirekiCharacters the shopRirekiCharacters to set
	 */
	public void setShopRirekiCharacters(final List<ShopRirekiCharacter> shopRirekiCharacters) {
		this.shopRirekiCharacters = shopRirekiCharacters;
	}

	/**
	 * @return shopRirekiImgs
	 */
	public List<ShopRirekiImg> getShopRirekiImgs() {
		return this.shopRirekiImgs;
	}

	/**
	 * @param shopRirekiImgs the shopRirekiImgs to set
	 */
	public void setShopRirekiImgs(final List<ShopRirekiImg> shopRirekiImgs) {
		this.shopRirekiImgs = shopRirekiImgs;
	}

	/**
	 * @return bukkenCount
	 */
	public BukkenCount getBukkenCount() {
		return this.bukkenCount;
	}

	/**
	 * @param bukkenCount the bukkenCount to set
	 */
	public void setBukkenCount(final BukkenCount bukkenCount) {
		this.bukkenCount = bukkenCount;
	}

	/**
	 * @return vAspGroupShops
	 */
	public List<VAspGroupShop> getvAspGroupShops() {
		return this.vAspGroupShops;
	}

	/**
	 * @param vAspGroupShops the vAspGroupShops to set
	 */
	public void setvAspGroupShops(final List<VAspGroupShop> vAspGroupShops) {
		this.vAspGroupShops = vAspGroupShops;
	}

	/**
	 * @return vShopKeiyakuDetails
	 */
	public List<VShopKeiyakuDetail> getvShopKeiyakuDetails() {
		return this.vShopKeiyakuDetails;
	}

	/**
	 * @param vShopKeiyakuDetails the vShopKeiyakuDetails to set
	 */
	public void setvShopKeiyakuDetails(final List<VShopKeiyakuDetail> vShopKeiyakuDetails) {
		this.vShopKeiyakuDetails = vShopKeiyakuDetails;
	}

	/**
	 * @return shopRireki
	 */
	public ShopRireki getShopRireki() {
		return this.shopRireki;
	}

	/**
	 * @param shopRireki the shopRireki to set
	 */
	public void setShopRireki(final ShopRireki shopRireki) {
		this.shopRireki = shopRireki;
	}

	/**
	 * @return shopRirekiEkis
	 */
	public List<ShopRirekiEki> getShopRirekiEkis() {
		return this.shopRirekiEkis;
	}

	/**
	 * @param shopRirekiEkis the shopRirekiEkis to set
	 */
	public void setShopRirekiEkis(final List<ShopRirekiEki> shopRirekiEkis) {
		this.shopRirekiEkis = shopRirekiEkis;
	}

	/**
	 * @return pkShopRireki
	 */
	public Integer getPkShopRireki() {
		return this.pkShopRireki;
	}

	/**
	 * @param pkShopRireki the pkShopRireki to set
	 */
	public void setPkShopRireki(final Integer pkShopRireki) {
		this.pkShopRireki = pkShopRireki;
	}

	/**
	 * 店舗名(会社名)を取得します。
	 * @return 店舗名(会社名)
	 */
	public String getCompany() {
		return this.company;
	}

	/**
	 * 店舗名(会社名)を設定します。
	 * @param company 店舗名(会社名)
	 */
	public void setCompany(final String company) {
		this.company = company;
	}

	/**
	 * 店舗名(事務所名)を取得します。
	 * @return 店舗名(事務所名)
	 */
	public String getBumon() {
		return this.bumon;
	}

	/**
	 * 店舗名(事務所名)を設定します。
	 * @param bumon 店舗名(事務所名)
	 */
	public void setBumon(final String bumon) {
		this.bumon = bumon;
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
	 * お客様設定パスワードを取得します。
	 * @return お客様設定パスワード
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * お客様設定パスワードを設定します。
	 * @param password お客様設定パスワード
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * 所属団体名を取得します。
	 * @return 所属団体名
	 */
	public String getDantai() {
		return this.dantai;
	}

	/**
	 * 所属団体名を設定します。
	 * @param dantai 所属団体名
	 */
	public void setDantai(final String dantai) {
		this.dantai = dantai;
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
	 * グループ名を取得します。
	 * @return グループ名
	 */
	public String getGroupName() {
		return this.groupName;
	}

	/**
	 * グループ名を設定します。
	 * @param groupName グループ名
	 */
	public void setGroupName(final String groupName) {
		this.groupName = groupName;
	}

	/**
	 * 郵便番号を取得します。
	 * @return 郵便番号
	 */
	public String getZipCd() {
		return this.zipCd;
	}

	/**
	 * 郵便番号を設定します。
	 * @param zipCd 郵便番号
	 */
	public void setZipCd(final String zipCd) {
		this.zipCd = zipCd;
	}

	/**
	 * 住所（都道府県、市区町村）を取得します。
	 * @return 住所（都道府県、市区町村）
	 */
	public String getAddress1() {
		return this.address1;
	}

	/**
	 * 住所（都道府県、市区町村）を設定します。
	 * @param address1 住所（都道府県、市区町村）
	 */
	public void setAddress1(final String address1) {
		this.address1 = address1;
	}

	/**
	 * 住所（地先）を取得します。
	 * @return 住所（地先）
	 */
	public String getAddress2() {
		return this.address2;
	}

	/**
	 * 住所（地先）を設定します。
	 * @param address2 住所（地先）
	 */
	public void setAddress2(final String address2) {
		this.address2 = address2;
	}

	/**
	 * TELを取得します。
	 * @return TEL
	 */
	public String getTel() {
		return this.tel;
	}

	/**
	 * TELを設定します。
	 * @param tel TEL
	 */
	public void setTel(final String tel) {
		this.tel = tel;
	}

	// 2013/07/25 店舗電話番号変更対応２次リリース分 ３項目追加
	/**
	 * フリーコール用TELを取得します。
	 * @return SHOP_TEL_FREE
	 */
	public String getShopTelFree() {
		return this.shopTelFree;
	}

	/**
	 * フリーコール用TELを設定します。
	 * @param shopTelFree SHOP_TEL_FREE
	 */
	public void setShopTelFree(final String shopTelFree) {
		this.shopTelFree = shopTelFree;
	}

	/**
	 * 電話番号選択を取得します。
	 * @return SHOP_TEL_KBN
	 */
	public String getShopTelKbn() {
		return this.shopTelKbn;
	}

	/**
	 * 電話番号選択を設定します。
	 * @param shopTelKbn SHOP_TEL_KBN
	 */
	public void setShopTelKbn(final String shopTelKbn) {
		this.shopTelKbn = shopTelKbn;
	}

	/**
	 * 雑誌用TELを取得します。
	 * @return SHOP_TEL_MAGAZINE
	 */
	public String getShopTelMagazine() {
		return this.shopTelMagazine;
	}

	/**
	 * 雑誌用TELを設定します。
	 * @param shopTelMagazine SHOP_TEL_MAGAZINE
	 */
	public void setShopTelMagazine(final String shopTelMagazine) {
		this.shopTelMagazine = shopTelMagazine;
	}

	// 2013/7/26 end

	/**
	 * FAXを取得します。
	 * @return FAX
	 */
	public String getFax() {
		return this.fax;
	}

	/**
	 * FAXを設定します。
	 * @param fax FAX
	 */
	public void setFax(final String fax) {
		this.fax = fax;
	}

	/**
	 * エリアコードを取得します。
	 * @return エリアコード
	 */
	public String getAreaCd() {
		return this.areaCd;
	}

	/**
	 * エリアコードを設定します。
	 * @param areaCd エリアコード
	 */
	public void setAreaCd(final String areaCd) {
		this.areaCd = areaCd;
	}

	/**
	 * 地域(エリア)を取得します。
	 * @return 地域(エリア)
	 */
	public String getAreaName() {
		return this.areaName;
	}

	/**
	 * 地域(エリア)を設定します。
	 * @param areaName 地域(エリア)
	 */
	public void setAreaName(final String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 都道府県コードを取得します。
	 * @return 都道府県コード
	 */
	public String getPrefCd() {
		return this.prefCd;
	}

	/**
	 * 都道府県コードを設定します。
	 * @param prefCd 都道府県コード
	 */
	public void setPrefCd(final String prefCd) {
		this.prefCd = prefCd;
	}

	/**
	 * 地域(都道府県)を取得します。
	 * @return 地域(都道府県)
	 */
	public String getPrefName() {
		return this.prefName;
	}

	/**
	 * 地域(都道府県)を設定します。
	 * @param prefName 地域(都道府県)
	 */
	public void setPrefName(final String prefName) {
		this.prefName = prefName;
	}

	/**
	 * 市区町村コードを取得します。
	 * @return 市区町村コード
	 */
	public String getCityCd() {
		return this.cityCd;
	}

	/**
	 * 市区町村コードを設定します。
	 * @param cityCd 市区町村コード
	 */
	public void setCityCd(final String cityCd) {
		this.cityCd = cityCd;
	}

	/**
	 * 地域(市区町村)を取得します。
	 * @return 地域(市区町村)
	 */
	public String getCityName() {
		return this.cityName;
	}

	/**
	 * 地域(市区町村)を設定します。
	 * @param cityName 地域(市区町村)
	 */
	public void setCityName(final String cityName) {
		this.cityName = cityName;
	}

	/**
	 * 沿線エリアコードを取得します。
	 * @return 沿線エリアコード
	 */
	public String getEnsenAreaCd() {
		return this.ensenAreaCd;
	}

	/**
	 * 沿線エリアコードを設定します。
	 * @param ensenAreaCd 沿線エリアコード
	 */
	public void setEnsenAreaCd(final String ensenAreaCd) {
		this.ensenAreaCd = ensenAreaCd;
	}

	/**
	 * 沿線タイプを取得します。
	 * @return 沿線タイプ
	 */
	public String getEnsenType() {
		return this.ensenType;
	}

	/**
	 * 沿線タイプを設定します。
	 * @param ensenType 沿線タイプ
	 */
	public void setEnsenType(final String ensenType) {
		this.ensenType = ensenType;
	}

	/**
	 * 沿線コードを取得します。
	 * @return 沿線コード
	 */
	public String getEnsenCd() {
		return this.ensenCd;
	}

	/**
	 * 沿線コードを設定します。
	 * @param ensenCd 沿線コード
	 */
	public void setEnsenCd(final String ensenCd) {
		this.ensenCd = ensenCd;
	}

	/**
	 * 沿線(沿線)を取得します。
	 * @return 沿線(沿線)
	 */
	public String getEnsenName() {
		return this.ensenName;
	}

	/**
	 * 沿線(沿線)を設定します。
	 * @param ensenName 沿線(沿線)
	 */
	public void setEnsenName(final String ensenName) {
		this.ensenName = ensenName;
	}

	/**
	 * 駅名コードを取得します。
	 * @return 駅名コード
	 */
	public String getEkiCd() {
		return this.ekiCd;
	}

	/**
	 * 駅名コードを設定します。
	 * @param ekiCd 駅名コード
	 */
	public void setEkiCd(final String ekiCd) {
		this.ekiCd = ekiCd;
	}

	/**
	 * 沿線(駅名)を取得します。
	 * @return 沿線(駅名)
	 */
	public String getEkiName() {
		return this.ekiName;
	}

	/**
	 * 沿線(駅名)を設定します。
	 * @param ekiName 沿線(駅名)
	 */
	public void setEkiName(final String ekiName) {
		this.ekiName = ekiName;
	}

	/**
	 * 免許証番号を取得します。
	 * @return 免許証番号
	 */
	public String getLicNum() {
		return this.licNum;
	}

	/**
	 * 免許証番号を設定します。
	 * @param licNum 免許証番号
	 */
	public void setLicNum(final String licNum) {
		this.licNum = licNum;
	}

	/**
	 * 免許証登録日を取得します。
	 * @return 免許証登録日
	 */
	public String getLicEntry() {
		return this.licEntry;
	}

	/**
	 * 免許証登録日を設定します。
	 * @param licEntry 免許証登録日
	 */
	public void setLicEntry(final String licEntry) {
		this.licEntry = licEntry;
	}

	/**
	 * 免許証有効期限を取得します。
	 * @return 免許証有効期限
	 */
	public String getLicValid() {
		return this.licValid;
	}

	/**
	 * 免許証有効期限を設定します。
	 * @param licValid 免許証有効期限
	 */
	public void setLicValid(final String licValid) {
		this.licValid = licValid;
	}

	/**
	 * 宅建取引主任者名を取得します。
	 * @return 宅建取引主任者名
	 */
	public String getLicChief() {
		return this.licChief;
	}

	/**
	 * 宅建取引主任者名を設定します。
	 * @param licChief 宅建取引主任者名
	 */
	public void setLicChief(final String licChief) {
		this.licChief = licChief;
	}

	/**
	 * 担当者名を取得します。
	 * @return 担当者名
	 */
	public String getTantou() {
		return this.tantou;
	}

	/**
	 * 担当者名を設定します。
	 * @param tantou 担当者名
	 */
	public void setTantou(final String tantou) {
		this.tantou = tantou;
	}

	/**
	 * ホームページリンク名称を取得します。
	 * @return ホームページリンク名称
	 */
	public String getHpName() {
		return this.hpName;
	}

	/**
	 * ホームページリンク名称を設定します。
	 * @param hpName ホームページリンク名称
	 */
	public void setHpName(final String hpName) {
		this.hpName = hpName;
	}

	/**
	 * 自社ホームページURLを取得します。
	 * @return 自社ホームページURL
	 */
	public String getHpUrl() {
		return this.hpUrl;
	}

	/**
	 * 自社ホームページURLを設定します。
	 * @param hpUrl 自社ホームページURL
	 */
	public void setHpUrl(final String hpUrl) {
		this.hpUrl = hpUrl;
	}

	/**
	 * メールアドレスを取得します。
	 * @return メールアドレス
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * メールアドレスを設定します。
	 * @param email メールアドレス
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * 営業時間を取得します。
	 * @return 営業時間
	 */
	public String getBusinessHours() {
		return this.businessHours;
	}

	/**
	 * 営業時間を設定します。
	 * @param businessHours 営業時間
	 */
	public void setBusinessHours(final String businessHours) {
		this.businessHours = businessHours;
	}

	/**
	 * 定休日を取得します。
	 * @return 定休日
	 */
	public String getHoliday() {
		return this.holiday;
	}

	/**
	 * 定休日を設定します。
	 * @param holiday 定休日
	 */
	public void setHoliday(final String holiday) {
		this.holiday = holiday;
	}

	/**
	 * 混雑時間帯(曜日)を取得します。
	 * @return 混雑時間帯(曜日)
	 */
	public String getBusyComment() {
		return this.busyComment;
	}

	/**
	 * 混雑時間帯(曜日)を設定します。
	 * @param busyComment 混雑時間帯(曜日)
	 */
	public void setBusyComment(final String busyComment) {
		this.busyComment = busyComment;
	}

	/**
	 * 連絡方法を取得します。
	 * @return 連絡方法
	 */
	public String getFmKbn() {
		return this.fmKbn;
	}

	/**
	 * 連絡方法を設定します。
	 * @param fmKbn 連絡方法
	 */
	public void setFmKbn(final String fmKbn) {
		this.fmKbn = fmKbn;
	}

	/**
	 * 最終サインアップ日を取得します。
	 * @return 最終サインアップ日
	 */
	public String getLastLoginDt() {
		return this.lastLoginDt;
	}

	/**
	 * 最終サインアップ日を設定します。
	 * @param lastLoginDt 最終サインアップ日
	 */
	public void setLastLoginDt(final String lastLoginDt) {
		this.lastLoginDt = lastLoginDt;
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
	 * 承認状態を取得します。
	 * @return 承認状態
	 */
	public String getCertifyFlg() {
		return this.certifyFlg;
	}

	/**
	 * 承認状態を設定します。
	 * @param certifyFlg 承認状態
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
	 * レコード情報(CHINTAIに掲載)を取得します。
	 * @return レコード情報(CHINTAIに掲載)
	 */
	public String getCtFlg() {
		return this.ctFlg;
	}

	/**
	 * レコード情報(CHINTAIに掲載)を設定します。
	 * @param ctFlg レコード情報(CHINTAIに掲載)
	 */
	public void setCtFlg(final String ctFlg) {
		this.ctFlg = ctFlg;
	}

	/**
	 * レコード情報(エイブルに掲載)を取得します。
	 * @return レコード情報(エイブルに掲載)
	 */
	public String getAblFlg() {
		return this.ablFlg;
	}

	/**
	 * レコード情報(エイブルに掲載)を設定します。
	 * @param ablFlg レコード情報(エイブルに掲載)
	 */
	public void setAblFlg(final String ablFlg) {
		this.ablFlg = ablFlg;
	}

	/**
	 * レコード情報(送信元アプリケーション)を取得します。
	 * @return レコード情報(送信元アプリケーション)
	 */
	public String getClientsystemType() {
		return this.clientsystemType;
	}

	/**
	 * レコード情報(送信元アプリケーション)を設定します。
	 * @param clientsystemType レコード情報(送信元アプリケーション)
	 */
	public void setClientsystemType(final String clientsystemType) {
		this.clientsystemType = clientsystemType;
	}

	/**
	 * レコード情報(不動産会社に探してもらう)を取得します。
	 * @return レコード情報(不動産会社に探してもらう)
	 */
	public String getShopSiteRole() {
		return this.shopSiteRole;
	}

	/**
	 * レコード情報(不動産会社に探してもらう)を設定します。
	 * @param shopSiteRole レコード情報(不動産会社に探してもらう)
	 */
	public void setShopSiteRole(final String shopSiteRole) {
		this.shopSiteRole = shopSiteRole;
	}

	/**
	 * 備考を取得します。
	 * @return 備考
	 */
	public String getAdminNote() {
		return this.adminNote;
	}

	/**
	 * 備考を設定します。
	 * @param adminNote 備考
	 */
	public void setAdminNote(final String adminNote) {
		this.adminNote = adminNote;
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
	 * Pickup不動産を取得します。
	 * @return Pickup不動産
	 */
	public String getPickUpCnt() {
		return this.pickUpCnt;
	}

	/**
	 * Pickup不動産を設定します。
	 * @param pickUpCnt Pickup不動産
	 */
	public void setPickUpCnt(final String pickUpCnt) {
		this.pickUpCnt = pickUpCnt;
	}

	/**
	 * 不動産ASPを取得します。
	 * @return 不動産ASP
	 */
	public String getAspCnt() {
		return this.aspCnt;
	}

	/**
	 * 不動産ASPを設定します。
	 * @param aspCnt 不動産ASP
	 */
	public void setAspCnt(final String aspCnt) {
		this.aspCnt = aspCnt;
	}

	/**
	 * 売買(アドパーク送信)を取得します。
	 * @return 売買(アドパーク送信)
	 */
	public String getAdparkSendFlg() {
		return this.adparkSendFlg;
	}

	/**
	 * 売買(アドパーク送信)を設定します。
	 * @param adparkSendFlg 売買(アドパーク送信)
	 */
	public void setAdparkSendFlg(final String adparkSendFlg) {
		this.adparkSendFlg = adparkSendFlg;
	}

	/**
	 * Webログ利用可否を取得します。
	 * @return Webログ利用可否
	 */
	public String getWebLogFlg() {
		return this.webLogFlg;
	}

	/**
	 * Webログ利用可否を設定します。
	 * @param webLogFlg Webログ利用可否
	 */
	public void setWebLogFlg(final String webLogFlg) {
		this.webLogFlg = webLogFlg;
	}

	/**
	 * 店舗地図表示フラグを取得します。
	 * @return 店舗地図表示フラグ
	 */
	public String getShopMapPctFlgOrg() {
		return this.shopMapPctFlgOrg;
	}

	/**
	 * 店舗地図表示フラグを設定します。
	 * @param shopMapPctFlgOrg 店舗地図表示フラグ
	 */
	public void setShopMapPctFlgOrg(final String shopMapPctFlgOrg) {
		this.shopMapPctFlgOrg = shopMapPctFlgOrg;
	}

	/**
	 * 店舗画像(左側)表示フラグを取得します。
	 * @return 店舗画像(左側)表示フラグ
	 */
	public String getShopPhoto1FlgOrg() {
		return this.shopPhoto1FlgOrg;
	}

	/**
	 * 店舗画像(左側)表示フラグを設定します。
	 * @param shopPhoto1FlgOrg 店舗画像(左側)表示フラグ
	 */
	public void setShopPhoto1FlgOrg(final String shopPhoto1FlgOrg) {
		this.shopPhoto1FlgOrg = shopPhoto1FlgOrg;
	}

	/**
	 * 店舗画像(右側)表示フラグを取得します。
	 * @return 店舗画像(右側)表示フラグ
	 */
	public String getShopPhoto2FlgOrg() {
		return this.shopPhoto2FlgOrg;
	}

	/**
	 * 店舗画像(右側)表示フラグを設定します。
	 * @param shopPhoto2FlgOrg 店舗画像(右側)表示フラグ
	 */
	public void setShopPhoto2FlgOrg(final String shopPhoto2FlgOrg) {
		this.shopPhoto2FlgOrg = shopPhoto2FlgOrg;
	}

	/**
	 * 店舗地図パスを取得します。
	 * @return 店舗地図パス
	 */
	public String getShopMapPctFilePath() {
		return this.shopMapPctFilePath;
	}

	/**
	 * 店舗地図パスを設定します。
	 * @param shopMapPctFilePath 店舗地図パス
	 */
	public void setShopMapPctFilePath(final String shopMapPctFilePath) {
		this.shopMapPctFilePath = shopMapPctFilePath;
	}

	/**
	 * 店舗画像(左側)パスを取得します。
	 * @return 店舗画像(左側)パス
	 */
	public String getShopPhoto1FilePath() {
		return this.shopPhoto1FilePath;
	}

	/**
	 * 店舗画像(左側)パスを設定します。
	 * @param shopPhoto1FilePath 店舗画像(左側)パス
	 */
	public void setShopPhoto1FilePath(final String shopPhoto1FilePath) {
		this.shopPhoto1FilePath = shopPhoto1FilePath;
	}

	/**
	 * 店舗画像(右側)パスを取得します。
	 * @return 店舗画像(右側)パス
	 */
	public String getShopPhoto2FilePath() {
		return this.shopPhoto2FilePath;
	}

	/**
	 * 店舗画像(右側)パスを設定します。
	 * @param shopPhoto2FilePath 店舗画像(右側)パス
	 */
	public void setShopPhoto2FilePath(final String shopPhoto2FilePath) {
		this.shopPhoto2FilePath = shopPhoto2FilePath;
	}

	/**
	 * 店舗画像3(店内写真)表示フラグを取得します。
	 * @return 店舗画像3(店内写真)表示フラグ
	 */
	public String getShopPhoto3FlgOrg() {
		return this.shopPhoto3FlgOrg;
	}

	/**
	 * 店舗画像3(店内写真)表示フラグを設定します。
	 * @param shopPhoto3FlgOrg 店舗画像3(店内写真)表示フラグ
	 */
	public void setShopPhoto3FlgOrg(final String shopPhoto3FlgOrg) {
		this.shopPhoto3FlgOrg = shopPhoto3FlgOrg;
	}

	/**
	 * 店舗画像4(スタッフ接客写真)を取得します。
	 * @return 店舗画像4(スタッフ接客写真)
	 */
	public String getShopPhoto4FlgOrg() {
		return this.shopPhoto4FlgOrg;
	}

	/**
	 * 店舗画像4(スタッフ接客写真)を設定します。
	 * @param shopPhoto4FlgOrg 店舗画像4(スタッフ接客写真)
	 */
	public void setShopPhoto4FlgOrg(final String shopPhoto4FlgOrg) {
		this.shopPhoto4FlgOrg = shopPhoto4FlgOrg;
	}

	/**
	 * 店舗画像3(店内写真)パスを取得します。
	 * @return 店舗画像3(店内写真)パス
	 */
	public String getShopPhoto3FilePath() {
		return this.shopPhoto3FilePath;
	}

	/**
	 * 店舗画像3(店内写真)パスを設定します。
	 * @param shopPhoto3FilePath 店舗画像3(店内写真)パス
	 */
	public void setShopPhoto3FilePath(final String shopPhoto3FilePath) {
		this.shopPhoto3FilePath = shopPhoto3FilePath;
	}

	/**
	 * 店舗画像4(スタッフ接客写真)パスを取得します。
	 * @return 店舗画像4(スタッフ接客写真)パス
	 */
	public String getShopPhoto4FilePath() {
		return this.shopPhoto4FilePath;
	}

	/**
	 * 店舗画像4(スタッフ接客写真)パスを設定します。
	 * @param shopPhoto4FilePath 店舗画像4(スタッフ接客写真)パス
	 */
	public void setShopPhoto4FilePath(final String shopPhoto4FilePath) {
		this.shopPhoto4FilePath = shopPhoto4FilePath;
	}

	/**
	 * 店舗地図コメントを取得します。
	 * @return 店舗地図コメント
	 */
	public String getShopMapPctComment() {
		return this.shopMapPctComment;
	}

	/**
	 * 店舗地図コメントを設定します。
	 * @param shopMapPctComment 店舗地図コメント
	 */
	public void setShopMapPctComment(final String shopMapPctComment) {
		this.shopMapPctComment = shopMapPctComment;
	}

	/**
	 * 店舗画像１(店内写真)コメントを取得します。
	 * @return 店舗画像１(店内写真)コメント
	 */
	public String getShopPhoto1Comment() {
		return this.shopPhoto1Comment;
	}

	/**
	 * 店舗画像１(店内写真)コメントを設定します。
	 * @param shopPhoto1Comment 店舗画像１(店内写真)コメント
	 */
	public void setShopPhoto1Comment(final String shopPhoto1Comment) {
		this.shopPhoto1Comment = shopPhoto1Comment;
	}

	/**
	 * 店舗画像２(スタッフ写真)コメントを取得します。
	 * @return 店舗画像２(スタッフ写真)コメント
	 */
	public String getShopPhoto2Comment() {
		return this.shopPhoto2Comment;
	}

	/**
	 * 店舗画像２(スタッフ写真)コメントを設定します。
	 * @param shopPhoto2Comment 店舗画像２(スタッフ写真)コメント
	 */
	public void setShopPhoto2Comment(final String shopPhoto2Comment) {
		this.shopPhoto2Comment = shopPhoto2Comment;
	}

	/**
	 * 店舗画像３(店内写真)コメントを取得します。
	 * @return 店舗画像３(店内写真)コメント
	 */
	public String getShopPhoto3Comment() {
		return this.shopPhoto3Comment;
	}

	/**
	 * 店舗画像３(店内写真)コメントを設定します。
	 * @param shopPhoto3Comment 店舗画像３(店内写真)コメント
	 */
	public void setShopPhoto3Comment(final String shopPhoto3Comment) {
		this.shopPhoto3Comment = shopPhoto3Comment;
	}

	/**
	 * 店舗画像４(スタッフ接客写真)コメントを取得します。
	 * @return 店舗画像４(スタッフ接客写真)コメント
	 */
	public String getShopPhoto4Comment() {
		return this.shopPhoto4Comment;
	}

	/**
	 * 店舗画像４(スタッフ接客写真)コメントを設定します。
	 * @param shopPhoto4Comment 店舗画像４(スタッフ接客写真)コメント
	 */
	public void setShopPhoto4Comment(final String shopPhoto4Comment) {
		this.shopPhoto4Comment = shopPhoto4Comment;
	}

	/**
	 * 店舗名かなを取得します。
	 * @return 店舗名かな
	 */
	public String getBumonKana() {
		return this.bumonKana;
	}

	/**
	 * 店舗名かなを設定します。
	 * @param bumonKana 店舗名かな
	 */
	public void setBumonKana(final String bumonKana) {
		this.bumonKana = bumonKana;
	}

	/**
	 * 有効物件数CHINTAIを取得します。
	 * @return 有効物件数CHINTAI
	 */
	// public String getShopIconDelFlg() {
	// return shopIconDelFlg;
	// }
	/**
	 * 地図上の店舗アイコン表示状態を設定します。
	 * @param shopIconDelFlg 地図上の店舗アイコン表示状態
	 */
	// public void setShopIconDelFlg(String shopIconDelFlg) {
	// this.shopIconDelFlg = shopIconDelFlg;
	// }
	/**
	 * 有効物件数CHINTAIを取得します。
	 * @return 有効物件数CHINTAI
	 */
	public String getChintaiBukkenCount() {
		return this.chintaiBukkenCount;
	}

	/**
	 * 有効物件数CHINTAIを設定します。
	 * @param chintaiBukkenCount 有効物件数CHINTAI
	 */
	public void setChintaiBukkenCount(final String chintaiBukkenCount) {
		this.chintaiBukkenCount = chintaiBukkenCount;
	}

	/**
	 * 有効物件数エイブルを取得します。
	 * @return 有効物件数エイブル
	 */
	public String getAbleBukkenCount() {
		return this.ableBukkenCount;
	}

	/**
	 * 有効物件数エイブルを設定します。
	 * @param ableBukkenCount 有効物件数エイブル
	 */
	public void setAbleBukkenCount(final String ableBukkenCount) {
		this.ableBukkenCount = ableBukkenCount;
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

	/**
	 * 店舗LINE＠IDを取得します。
	 * @return 店舗LINE＠ID
	 */
	public String getLineAccount() {
		return lineAccount;
	}

	/**
	 * 店舗LINE＠IDを設定します。
	 * @param lineAccount 店舗LINE＠ID
	 */
	public void setLineAccount(String lineAccount) {
		this.lineAccount = lineAccount;
	}

	public String getRendoCd() {
		return rendoCd;
	}

	public void setRendoCd(String rendoCd) {
		this.rendoCd = rendoCd;
	}

	public String getCtShisyaCd() {
		return ctShisyaCd;
	}

	public void setCtShisyaCd(String ctShisyaCd) {
		this.ctShisyaCd = ctShisyaCd;
	}

	public String getInqMngEmail() {
		return inqMngEmail;
	}

	public void setInqMngEmail(String inqMngEmail) {
		this.inqMngEmail = inqMngEmail;
	}

	public String getNoticeEmail() {
		return noticeEmail;
	}

	public void setNoticeEmail(String noticeEmail) {
		this.noticeEmail = noticeEmail;
	}

	public String getLocationX() {
		return locationX;
	}

	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}

	public String getLocationY() {
		return locationY;
	}

	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}

	public List<PpcInfo> getPpcInfo() {
		return ppcInfo;
	}

	public void setPpcInfo(List<PpcInfo> ppcInfo) {
		this.ppcInfo = ppcInfo;
	}

	public List<ShopReserve> getShopReserve() {
		return shopReserve;
	}

	public void setShopReserve(List<ShopReserve> shopReserve) {
		this.shopReserve = shopReserve;
	}

	public String getCertifyChkFlg() {
		return certifyChkFlg;
	}

	public void setCertifyChkFlg(String certifyChkFlg) {
		this.certifyChkFlg = certifyChkFlg;
	}

}

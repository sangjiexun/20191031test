package net.chintai.backend.sysadmin.crnwl.form.shop_bukken;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import net.chintai.backend.sysadmin.crnwl.validation.validator.constraints.SpelAssert;
import net.chintai.batch.common.EmailUseKbn;
import net.chintai.batch.common.FmKbn;
import net.chintai.batch.common.TelDispKbn;
import net.chintai.receive.crsplus.validator.DatePatterns;
import net.chintai.receive.crsplus.validator.Patterns;
import net.chintai.receive.crsplus.validator.constraints.CustomDateFormat;
import net.chintai.receive.crsplus.validator.constraints.CustomUrl;
import net.chintai.receive.crsplus.validator.constraints.LocationXY;
import net.chintai.receive.crsplus.validator.constraints.OtherTransName;
import net.chintai.receive.crsplus.validator.constraints.OtherTransPlatform;
import net.chintai.receive.crsplus.validator.constraints.Tel;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;

/**
 * <pre>
 * ShopBasicInfoUpdateForm
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2015-12-17 16:46:36 +0900 (木, 17 12 2015) $ by $Author: s-sakuraba $
 * @version $Revision: 7240 $
 * @since 1.0
 */
public class ShopBasicInfoUpdateForm {
	// @SpelAssert(value="#shopService.selectShopKanriByprimaryKey(#this) != null")
	private String shopcd;

	private String ablHtml;

	private String chintaiHtml;

	private String magazineHtml;

	private Date shopKanriUpdDt;

	private boolean nayoseSkip = true;

	// @NotBlank
	// private String companyKbn;

	@NotBlank
	private String rendoCd;

	// @NotBlank
	// private String clientsystemType;

	@NotBlank
	@Length(max = 200, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	@SafeHtml
	private String company;

	// 事務所名
	@SafeHtml
	@Length(max = 200, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	private String bumon;

	// 所属団体名
	@Length(max = 60, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	@SafeHtml
	private String dantai;

	// 代表者名
	@Length(max = 50, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	@SafeHtml
	private String licTrust;

	// グループ名
	@Length(max = 40, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	@SafeHtml
	private String groupname;

	@NotBlank
	// @Zip
	@SpelAssert(value = "#this == '' ? true : @masterService.getAddress(#this)['address'] != ''", message = "{net.chintai.receive.crsplus.validator.constraints.Zip.message}")
	private String zip;

	@NotBlank
	@SafeHtml
	@Length(max = 120, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	private String address1;

	@Length(max = 100, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	@SafeHtml
	private String address2;

	/**
	 * 経度１０進
	 */
	@LocationXY
	@Range(min = 120, max = 150)
	private String locationX;

	/**
	 * 緯度１０進
	 */
	@LocationXY
	@Range(min = 20, max = 50)
	private String locationY;

	/**
	 * 経度１０進の入力チェック。
	 * @return 未入力は false、以外は true
	 */
	@AssertTrue(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	public boolean isNotBlankLocationX() {
		if (StringUtils.isNotBlank(this.locationY)) {
			if (StringUtils.isBlank(this.locationX)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 経度１０進の入力チェック。
	 * @return 未入力は false、以外は true
	 */
	@AssertTrue(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	public boolean isNotBlankLocationY() {
		if (StringUtils.isNotBlank(this.locationX)) {
			if (StringUtils.isBlank(this.locationY)) {
				return false;
			}
		}
		return true;
	}

	@NotBlank
	@Tel
	private String tel;

	@Tel
	private String telMagazine;

	@NotBlank
	@Tel
	private String telInq;

	@NotBlank
	private String telDispKbn;

	@Tel
	private String telFreeCt;

	private String telFreeCtKbn;

	@AssertTrue(message = "{error.message.selectValidTelFreeCtKbn}")
	public boolean isValidTelFreeCtKbn() {
		if (TelDispKbn.FREE_CALL_CH.getValue().equals(this.telDispKbn)) {
			return !"0".equals(this.telFreeCtKbn);
		}
		return true;
	}

	private String telMagazineKbn;

	@Tel
	private String telFreeShop;

	@AssertTrue(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	public boolean isValidTelFreeShop() {
		if (TelDispKbn.FREE_CALL_SHOP.getValue().equals(this.telDispKbn) || TelDispKbn.FREE_CALL_SHOP.getValue().equals(this.telDispKbnAbl)) {
			return !"".equals(this.telFreeShop);
		}
		return true;
	}

	@NotBlank
	private String telDispKbnAbl;

	// @Tel
	private String telFreeAbl;

	private String telFreeAblKbn;

	@AssertTrue(message = "{error.message.selectValidTelFreeAblKbn}")
	public boolean isValidTelFreeAblKbn() {
		if (TelDispKbn.FREE_CALL_ABL.getValue().equals(this.telDispKbnAbl)) {
			return !"0".equals(this.telFreeAblKbn);
		}
		return true;
	}

	@Tel
	private String fax;

	@AssertTrue(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	public boolean isValidFax() {
		if (FmKbn.FAX.getValue().equals(this.fmKbn)) {
			return !"".equals(this.fax);
		}
		return true;
	}

	@NotEmpty
	@Valid
	private Map<Integer, Eki> ekis = new TreeMap<>();

	@NotBlank
	@Length(max = 40, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	@SafeHtml
	private String licNum;// 免許証番号

	@CustomDateFormat(patterns = { "yyyyMMdd" }, message = "{error.message.yyyymmdd}")
	@Length(max = 8)
	private String licEntry;// 免許登録日

	/**
	 * 免許登録日の過去日チェック。 免許登録日が過去日であればOK
	 * @return NGは false、OKは true
	 */
	@AssertTrue(message = "{javax.validation.constraints.Past.message}")
	public boolean isPastLicEntry() {
		if (StringUtils.isNotBlank(this.licEntry)) {
			try {
				final Date targetDate = DateUtils.parseDateStrictly(this.licEntry,
						new String[] { DatePatterns.YYYYMMDD });
				if (targetDate.compareTo(new Date()) > 0) { // targetDate は 00:00:00.000 だからこれで大丈夫
					return false;
				}
			}
			catch (final ParseException e) {
				// 何もしない
			}
		}
		return true;
	}

	/**
	 * 免許登録日と免許証有効期限の比較チェック。 免許登録日≦免許証有効期限であればOK
	 * @return NGは false、OKは true
	 */
	@AssertTrue(message = "{error.message.lessEqualLicValid}")
	public boolean isLicEntryLessEqualLicValid() {
		if (StringUtils.isNotBlank(this.licEntry) && StringUtils.isNotBlank(this.licValid)) {
			try {
				final Date licEntryDate = DateUtils.parseDateStrictly(this.licEntry,
						new String[] { DatePatterns.YYYYMMDD });
				final Date licValidDate = DateUtils.parseDateStrictly(this.licValid,
						new String[] { DatePatterns.YYYYMMDD });
				if (licEntryDate.compareTo(licValidDate) >= 0) { // targetDate は 00:00:00.000 だからこれで大丈夫
					return false;
				}
			}
			catch (final ParseException e) {
				// 何もしない
			}
		}
		return true;
	}

	@CustomDateFormat(patterns = { "yyyyMMdd" }, message = "{error.message.yyyymmdd}")
	@Length(max = 8)
	private String licValid;// 免許証有効期限

	@Length(max = 50, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	@SafeHtml
	private String licChief;// 宅地建物取引主任者

	@Length(max = 50, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	@SafeHtml
	private String tantou;// 担当者

	@Valid
	private Map<Integer, Hp> hps = new TreeMap<>();

	@Valid
	private Map<Integer, Mail> mails = new TreeMap<>();

	/**
	 * E-Mailアドレスデータの入力チェック。
	 * @return NGは false、OKは true
	 */
	@AssertTrue(message = "{error.message.notFoundValidEmailUseKbnWhenBlankInqMngEmail}")
	public boolean isFoundValidEmailUseKbnWhenBlankInqMngEmail() {
		if (StringUtils.isBlank(this.inqMngEmail) && FmKbn.MAIL.getValue().equals(this.fmKbn)) {
			if (getMails() != null) {
				boolean isFoundCommon = false;
				boolean isFoundInquiry = false;
				boolean isFoundWebShinsa = false;
				for (final Map.Entry<Integer, Mail> e : getMails().entrySet()) {
					final Mail shopEmailForm = e.getValue();
					if (EmailUseKbn.COMMON.getValue().equals(shopEmailForm.getUseKbn())) {
						isFoundCommon = true;
						break;
					}
					else if (EmailUseKbn.INQUIRY.getValue().equals(shopEmailForm.getUseKbn())) {
						isFoundInquiry = true;
					}
					else if (EmailUseKbn.WEB_SHINSA.getValue().equals(shopEmailForm.getUseKbn())) {
						isFoundWebShinsa = true;
					}
				}
				if (!((isFoundCommon) || ((isFoundInquiry) && (isFoundWebShinsa)))) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * E-Mailアドレスデータの入力チェック。
	 * @return NGは false、OKは true
	 */
	@AssertTrue(message = "{error.message.notFoundValidEmailUseKbnWhenNotBlankInqMngEmail}")
	public boolean isFoundValidEmailUseKbnWhenNotBlankInqMngEmail() {
		if (StringUtils.isNotBlank(this.inqMngEmail) && FmKbn.MAIL.getValue().equals(this.fmKbn)) {
			if (getMails() != null) {
				boolean isFoundCommon = false;
				boolean isFoundWebShinsa = false;
				for (final Map.Entry<Integer, Mail> e : getMails().entrySet()) {
					final Mail shopEmailForm = e.getValue();
					if (EmailUseKbn.COMMON.getValue().equals(shopEmailForm.getUseKbn())) {
						isFoundCommon = true;
						break;
					}
					else if (EmailUseKbn.WEB_SHINSA.getValue().equals(shopEmailForm.getUseKbn())) {
						isFoundWebShinsa = true;
					}
				}
				if (!((isFoundCommon) || (isFoundWebShinsa))) {
					return false;
				}
			}
		}
		return true;
	}

	@NotBlank
	private String fmKbn;

	@Length(max = 50, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	@SafeHtml
	private String businessHours;

	@Length(max = 50, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	@SafeHtml
	private String holiday;

	// @Length(max = 250, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	// @SafeHtml
	// private String busyComment;

	@Length(max = 50, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	@SafeHtml
	private String bumonkana;

	// @NotBlank
	private String ctShisyaCd;

	// 2015/12/10 櫻庭哲史 店舗LINE＠ID追加
	/**
	 * 店舗LINE＠ID
	 */
	@Length(max = 50, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	@Size(max = 50, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	@Pattern(regexp = Patterns.C_ALPHANUMERIC_SYMBOL_ALL, message = "{WARN.MSG.0067}")
	private String lineAccount;

	@AssertTrue(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	public boolean isValidCtShisyaCd() {
		if ("".equals(this.shopcd)) {
			// 店舗基本情報更新では任意
			return !"".equals(this.ctShisyaCd);
		}
		return true;
	}

	// @NotBlank
	@Length(max = 1284, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	@SafeHtml
	@SpelAssert(value = "#this != '' ? #this.split(',').length <= 5 : true ", message = "{0}は5件以下で入力してください。")
	private String noticeEmail;

	@AssertTrue(message = "{org.hibernate.validator.constraints.Email.message}")
	public boolean isValidNoticeEmail() {
		if (org.springframework.util.StringUtils.hasText(this.noticeEmail)) {
			for (final String email : this.noticeEmail.split(",")) {
				if (!email.matches(Patterns.C_EMAIL)) {
					return false;
				}
			}
		}
		return true;
	};

	@AssertTrue(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	public boolean isValidNoticeEmailNotBlank() {
		if ("".equals(this.shopcd)) {
			// 店舗基本情報更新では任意
			return !"".equals(this.noticeEmail);
		}
		return true;
	}

	@Length(max = 256, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
	@Pattern(regexp = Patterns.C_EMAIL, message = "{org.hibernate.validator.constraints.Email.message}")
	private String inqMngEmail;

	public static class Mail {

		@Length(max = 256, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		@Pattern(regexp = Patterns.C_EMAIL, message = "{org.hibernate.validator.constraints.Email.message}")
		private String email;

		private String useKbn;

		@AssertTrue(message = "{WARN.MSG.0010}")
		public boolean isValidUseKbn() {
			if (!"".equals(this.email)) {
				return !"".equals(this.useKbn);
			}
			return true;
		}

		@AssertTrue(message = "{org.hibernate.validator.constraints.NotBlank.message}")
		public boolean isValidEmail() {
			if (!"".equals(this.useKbn)) {
				return !"".equals(this.email);
			}
			return true;
		}

		/**
		 * @return email
		 */
		public String getEmail() {
			return this.email;
		}

		/**
		 * @param email the email to set
		 */
		public void setEmail(final String email) {
			this.email = email;
		}

		/**
		 * @return useKbn
		 */
		public String getUseKbn() {
			return this.useKbn;
		}

		/**
		 * @param useKbn the useKbn to set
		 */
		public void setUseKbn(final String useKbn) {
			this.useKbn = useKbn;
		}

	}

	public static class Hp {

		@Length(max = 1024, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		@CustomUrl
		private String url;

		@Length(max = 128, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		@SafeHtml
		private String name;

		// @AssertTrue(message = "{WARN.MSG.0010}")
		// public boolean isName() {
		// if (!"".equals(this.url)) {
		// return !"".equals(this.name);
		// }
		// return true;
		// }

		@AssertTrue(message = "{org.hibernate.validator.constraints.NotBlank.message}")
		public boolean isValidUrl() {
			if (!"".equals(this.name)) {
				return !"".equals(this.url);
			}
			return true;
		}

		@AssertTrue(message = "{org.hibernate.validator.constraints.NotBlank.message}")
		public boolean isValidName() {
			if (!"".equals(this.url)) {
				return !"".equals(this.name);
			}
			return true;
		}

		/**
		 * @return url
		 */
		public String getUrl() {
			return this.url;
		}

		/**
		 * @param url the url to set
		 */
		public void setUrl(final String url) {
			this.url = url;
		}

		/**
		 * @return name
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(final String name) {
			this.name = name;
		}

	}

	public static class Eki {
		private String ensencd;

		private String ekicd;

		@OtherTransName
		@SafeHtml
		private String otherTransName;

		@OtherTransPlatform
		@SafeHtml
		private String otherTransPlatform;

		/**
		 * @return ensencd
		 */
		public String getEnsencd() {
			return this.ensencd;
		}

		/**
		 * @param ensencd the ensencd to set
		 */
		public void setEnsencd(final String ensencd) {
			this.ensencd = ensencd;
		}

		/**
		 * @return ekicd
		 */
		public String getEkicd() {
			return this.ekicd;
		}

		/**
		 * @param ekicd the ekicd to set
		 */
		public void setEkicd(final String ekicd) {
			this.ekicd = ekicd;
		}

		/**
		 * @return otherTransName
		 */
		public String getOtherTransName() {
			return this.otherTransName;
		}

		/**
		 * @param otherTransName the otherTransName to set
		 */
		public void setOtherTransName(final String otherTransName) {
			this.otherTransName = otherTransName;
		}

		/**
		 * @return otherTransPlatform
		 */
		public String getOtherTransPlatform() {
			return this.otherTransPlatform;
		}

		/**
		 * @param otherTransPlatform the otherTransPlatform to set
		 */
		public void setOtherTransPlatform(final String otherTransPlatform) {
			this.otherTransPlatform = otherTransPlatform;
		}

	}

	/**
	 * @return shopcd
	 */
	public String getShopcd() {
		return this.shopcd;
	}

	/**
	 * @param shopcd the shopcd to set
	 */
	public void setShopcd(final String shopcd) {
		this.shopcd = shopcd;
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
	 * @return company
	 */
	public String getCompany() {
		return this.company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(final String company) {
		this.company = company;
	}

	/**
	 * @return bumon
	 */
	public String getBumon() {
		return this.bumon;
	}

	/**
	 * @param bumon the bumon to set
	 */
	public void setBumon(final String bumon) {
		this.bumon = bumon;
	}

	/**
	 * @return dantai
	 */
	public String getDantai() {
		return this.dantai;
	}

	/**
	 * @param dantai the dantai to set
	 */
	public void setDantai(final String dantai) {
		this.dantai = dantai;
	}

	/**
	 * @return licTrust
	 */
	public String getLicTrust() {
		return this.licTrust;
	}

	/**
	 * @param licTrust the licTrust to set
	 */
	public void setLicTrust(final String licTrust) {
		this.licTrust = licTrust;
	}

	/**
	 * @return groupname
	 */
	public String getGroupname() {
		return this.groupname;
	}

	/**
	 * @param groupname the groupname to set
	 */
	public void setGroupname(final String groupname) {
		this.groupname = groupname;
	}

	/**
	 * @return zip
	 */
	public String getZip() {
		return this.zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(final String zip) {
		this.zip = zip;
	}

	/**
	 * @return address1
	 */
	public String getAddress1() {
		return this.address1;
	}

	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(final String address1) {
		this.address1 = address1;
	}

	/**
	 * @return address2
	 */
	public String getAddress2() {
		return this.address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(final String address2) {
		this.address2 = address2;
	}

	/**
	 * @return tel
	 */
	public String getTel() {
		return this.tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(final String tel) {
		this.tel = tel;
	}

	/**
	 * @return telMagazine
	 */
	public String getTelMagazine() {
		return this.telMagazine;
	}

	/**
	 * @param telMagazine the telMagazine to set
	 */
	public void setTelMagazine(final String telMagazine) {
		this.telMagazine = telMagazine;
	}

	/**
	 * @return telInq
	 */
	public String getTelInq() {
		return this.telInq;
	}

	/**
	 * @param telInq the telInq to set
	 */
	public void setTelInq(final String telInq) {
		this.telInq = telInq;
	}

	/**
	 * @return telDispKbn
	 */
	public String getTelDispKbn() {
		return this.telDispKbn;
	}

	/**
	 * @param telDispKbn the telDispKbn to set
	 */
	public void setTelDispKbn(final String telDispKbn) {
		this.telDispKbn = telDispKbn;
	}

	/**
	 * @return telFreeCt
	 */
	public String getTelFreeCt() {
		return this.telFreeCt;
	}

	/**
	 * @param telFreeCt the telFreeCt to set
	 */
	public void setTelFreeCt(final String telFreeCt) {
		this.telFreeCt = telFreeCt;
	}

	/**
	 * @return telFreeShop
	 */
	public String getTelFreeShop() {
		return this.telFreeShop;
	}

	/**
	 * @param telFreeShop the telFreeShop to set
	 */
	public void setTelFreeShop(final String telFreeShop) {
		this.telFreeShop = telFreeShop;
	}

	/**
	 * @return fax
	 */
	public String getFax() {
		return this.fax;
	}

	/**
	 * @param fax the fax to set
	 */
	public void setFax(final String fax) {
		this.fax = fax;
	}

	/**
	 * @return ekis
	 */
	public Map<Integer, Eki> getEkis() {
		return this.ekis;
	}

	/**
	 * @param ekis the ekis to set
	 */
	public void setEkis(final Map<Integer, Eki> ekis) {
		this.ekis = ekis;
	}

	/**
	 * @return licNum
	 */
	public String getLicNum() {
		return this.licNum;
	}

	/**
	 * @param licNum the licNum to set
	 */
	public void setLicNum(final String licNum) {
		this.licNum = licNum;
	}

	/**
	 * @return licEntry
	 */
	public String getLicEntry() {
		return this.licEntry;
	}

	/**
	 * @param licEntry the licEntry to set
	 */
	public void setLicEntry(final String licEntry) {
		this.licEntry = licEntry;
	}

	/**
	 * @return licValid
	 */
	public String getLicValid() {
		return this.licValid;
	}

	/**
	 * @param licValid the licValid to set
	 */
	public void setLicValid(final String licValid) {
		this.licValid = licValid;
	}

	/**
	 * @return licChief
	 */
	public String getLicChief() {
		return this.licChief;
	}

	/**
	 * @param licChief the licChief to set
	 */
	public void setLicChief(final String licChief) {
		this.licChief = licChief;
	}

	/**
	 * @return tantou
	 */
	public String getTantou() {
		return this.tantou;
	}

	/**
	 * @param tantou the tantou to set
	 */
	public void setTantou(final String tantou) {
		this.tantou = tantou;
	}

	/**
	 * @return hps
	 */
	public Map<Integer, Hp> getHps() {
		return this.hps;
	}

	/**
	 * @param hps the hps to set
	 */
	public void setHps(final Map<Integer, Hp> hps) {
		this.hps = hps;
	}

	/**
	 * @return mails
	 */
	public Map<Integer, Mail> getMails() {
		return this.mails;
	}

	/**
	 * @param mails the mails to set
	 */
	public void setMails(final Map<Integer, Mail> mails) {
		this.mails = mails;
	}

	/**
	 * @return fmKbn
	 */
	public String getFmKbn() {
		return this.fmKbn;
	}

	/**
	 * @param fmKbn the fmKbn to set
	 */
	public void setFmKbn(final String fmKbn) {
		this.fmKbn = fmKbn;
	}

	/**
	 * @return businessHours
	 */
	public String getBusinessHours() {
		return this.businessHours;
	}

	/**
	 * @param businessHours the businessHours to set
	 */
	public void setBusinessHours(final String businessHours) {
		this.businessHours = businessHours;
	}

	/**
	 * @return holiday
	 */
	public String getHoliday() {
		return this.holiday;
	}

	/**
	 * @param holiday the holiday to set
	 */
	public void setHoliday(final String holiday) {
		this.holiday = holiday;
	}

	/**
	 * @return bumonkana
	 */
	public String getBumonkana() {
		return this.bumonkana;
	}

	/**
	 * @param bumonkana the bumonkana to set
	 */
	public void setBumonkana(final String bumonkana) {
		this.bumonkana = bumonkana;
	}

	/**
	 * @return ctShisyaCd
	 */
	public String getCtShisyaCd() {
		return this.ctShisyaCd;
	}

	/**
	 * @param ctShisyaCd the ctShisyaCd to set
	 */
	public void setCtShisyaCd(final String ctShisyaCd) {
		this.ctShisyaCd = ctShisyaCd;
	}

	/**
	 * @return noticeEmail
	 */
	public String getNoticeEmail() {
		return this.noticeEmail;
	}

	/**
	 * @param noticeEmail the noticeEmail to set
	 */
	public void setNoticeEmail(final String noticeEmail) {
		this.noticeEmail = noticeEmail;
	}

	/**
	 * @return locationX
	 */
	public String getLocationX() {
		return this.locationX;
	}

	/**
	 * @param locationX the locationX to set
	 */
	public void setLocationX(final String locationX) {
		this.locationX = locationX;
	}

	/**
	 * @return locationY
	 */
	public String getLocationY() {
		return this.locationY;
	}

	/**
	 * @param locationY the locationY to set
	 */
	public void setLocationY(final String locationY) {
		this.locationY = locationY;
	}

	/**
	 * @return shopKanriUpdDt
	 */
	public Date getShopKanriUpdDt() {
		return this.shopKanriUpdDt;
	}

	/**
	 * @param shopKanriUpdDt the shopKanriUpdDt to set
	 */
	public void setShopKanriUpdDt(final Date shopKanriUpdDt) {
		this.shopKanriUpdDt = shopKanriUpdDt;
	}

	/**
	 * @return inqMngEmail
	 */
	public String getInqMngEmail() {
		return this.inqMngEmail;
	}

	/**
	 * @param inqMngEmail the inqMngEmail to set
	 */
	public void setInqMngEmail(final String inqMngEmail) {
		this.inqMngEmail = inqMngEmail;
	}

	/**
	 * @return nayoseSkip
	 */
	public boolean isNayoseSkip() {
		return this.nayoseSkip;
	}

	/**
	 * @param nayoseSkip the nayoseSkip to set
	 */
	public void setNayoseSkip(final boolean nayoseSkip) {
		this.nayoseSkip = nayoseSkip;
	}

	public String getTelFreeCtKbn() {
		return telFreeCtKbn;
	}

	public void setTelFreeCtKbn(String telFreeCtKbn) {
		this.telFreeCtKbn = telFreeCtKbn;
	}

	public String getTelMagazineKbn() {
		return telMagazineKbn;
	}

	public void setTelMagazineKbn(String telMagazineKbn) {
		this.telMagazineKbn = telMagazineKbn;
	}

	public String getChintaiHtml() {
		return chintaiHtml;
	}

	public void setChintaiHtml(String chintaiHtml) {
		this.chintaiHtml = chintaiHtml;
	}

	public String getMagazineHtml() {
		return magazineHtml;
	}

	public void setMagazineHtml(String magazineHtml) {
		this.magazineHtml = magazineHtml;
	}

	public String getTelDispKbnAbl() {
		return telDispKbnAbl;
	}

	public void setTelDispKbnAbl(String telDispKbnAbl) {
		this.telDispKbnAbl = telDispKbnAbl;
	}

	public String getTelFreeAblKbn() {
		return telFreeAblKbn;
	}

	public void setTelFreeAblKbn(String telFreeAblKbn) {
		this.telFreeAblKbn = telFreeAblKbn;
	}

	public String getTelFreeAbl() {
		return telFreeAbl;
	}

	public void setTelFreeAbl(String telFreeAbl) {
		this.telFreeAbl = telFreeAbl;
	}

	public String getAblHtml() {
		return ablHtml;
	}

	public void setAblHtml(String ablHtml) {
		this.ablHtml = ablHtml;
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

}

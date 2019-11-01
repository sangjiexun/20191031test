package net.chintai.backend.sysadmin.crnwl.form.shop_bukken;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import net.chintai.backend.sysadmin.crnwl.validation.validator.constraints.SpelAssert;
import net.chintai.receive.crsplus.validator.constraints.CustomDateFormat;
import net.chintai.receive.crsplus.validator.constraints.CustomUrl;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.web.multipart.MultipartFile;

/**
 * <pre>
 * ShopImageUpdateForm
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-10-14 17:59:47 +0900 (火, 14 10 2014) $ by $Author: kentaro.araya $
 * @version $Revision: 5906 $
 * @since 1.0
 */
public class ShopImageUpdateForm {
	@NotBlank
	private String shopcd;

	@NotNull
	private Date shopKanriUpdDt;

	@NotBlank
	private String imgId;

	@Valid
	private List<Img> imgs = new ArrayList<>();

	/*
	 * @Valid private Map<Integer, Staff> staffs = new TreeMap<>();
	 *
	 * @Valid private Map<Integer, Campaign> campaigns = new TreeMap<>();
	 */
	public static class Img {

		private String imgCategory;

		@AssertTrue(message = "{org.hibernate.validator.constraints.NotBlank.message}")
		public boolean isValidimgCategory() {
			if (this.del) {
				return true;
			}
			if (isNoValidate()) {
				return true;
			}
			if (!StringUtils.isBlank(this.imgCategoryName)
					|| !StringUtils.isBlank(this.imgCategory)) {
				return true;
			}
			return false;
		}

		private String imgCategoryName;

		private String imgKbn;

		private boolean del = false;

		private boolean existCurrentShopRirekiImg = false;

		@Length(max = 1024, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		@CustomUrl
		private String imgOuterUrl;

		@Length(max = 30, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String imgCatch;

		@SafeHtml
		@Length(max = 500, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String imgComment;

		private String imgUrlPath;

		private String imgFileNm;

		@SpelAssert(value = "@masterService.getMstContentTypeByPrimaryKey(#this.getContentType()) != null", message = "{net.chintai.receive.crsplus.invalidContentType}")
		private MultipartFile file;

		/**
		 * ファイルバイナリのサイズチェック。
		 * @return サイズが 0 より大きい場合は true、以外は false
		 */
		@AssertTrue(message = "{notSizeZeroFile}")
		public boolean isNotSizeZeroFile() {
			if (this.file != null) {
				if (this.file.getSize() > 0) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return true;
			}
		}

		// @NotNull
		private Short imgPriority;

		@AssertTrue(message = "{org.hibernate.validator.constraints.NotBlank.message}")
		public boolean isValidImgPriority() {
			if (this.del) {
				return true;
			}
			if (isNoValidate()) {
				return true;
			}
			return this.imgPriority != null;
		}

		@Length(max = 1024, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		@CustomUrl
		private String imgThumbnailUrl;

		/**
		 * 画像サムネイルURLの入力チェック。
		 * @return 未入力は false、以外は true
		 */
		@AssertTrue(message = "{org.hibernate.validator.constraints.NotBlank.message}")
		public boolean isNotBlankImgThumbnailUrl() {
			if (StringUtils.isNotBlank(this.imgOuterUrl)) {
				if (StringUtils.isBlank(this.imgThumbnailUrl)) {
					return false;
				}
			}
			else if (StringUtils.isNotBlank(this.imgThumbnailUrl)) {
				if (StringUtils.isBlank(this.imgOuterUrl)) {
					return false;
				}
			}
			return true;
		}

		public boolean isNoValidate() {
			//画面の入力項目
			//画面の入力項目が追加されたらここに追加してください。
			if(!existCurrentShopRirekiImg &&
					StringUtils.isEmpty(imgCategory) &&
					StringUtils.isEmpty(imgOuterUrl) &&
					StringUtils.isEmpty(imgComment) &&
					StringUtils.isEmpty(imgUrlPath) &&
					StringUtils.isEmpty(imgFileNm) &&
					(imgPriority == null || imgPriority == Short.MIN_VALUE) &&
					file == null &&
					StringUtils.isEmpty(imgThumbnailUrl)){
				return true;
			}else{
				return false;
			}
		}

		/**
		 * @return imgThumbnailUrl
		 */
		public String getImgThumbnailUrl() {
			return this.imgThumbnailUrl;
		}

		/**
		 * @param imgThumbnailUrl the imgThumbnailUrl to set
		 */
		public void setImgThumbnailUrl(final String imgThumbnailUrl) {
			this.imgThumbnailUrl = imgThumbnailUrl;
		}

		/**
		 * @return imgPriority
		 */
		public Short getImgPriority() {
			return this.imgPriority;
		}

		/**
		 * @param imgPriority the imgPriority to set
		 */
		public void setImgPriority(final Short imgPriority) {
			this.imgPriority = imgPriority;
		}

		/**
		 * @return imgKbn
		 */
		public String getImgKbn() {
			return this.imgKbn;
		}

		/**
		 * @param imgKbn the imgKbn to set
		 */
		public void setImgKbn(final String imgKbn) {
			this.imgKbn = imgKbn;
		}

		/**
		 * @return imgOuterUrl
		 */
		public String getImgOuterUrl() {
			return this.imgOuterUrl;
		}

		/**
		 * @param imgOuterUrl the imgOuterUrl to set
		 */
		public void setImgOuterUrl(final String imgOuterUrl) {
			this.imgOuterUrl = imgOuterUrl;
		}

		/**
		 * @return imgCatch
		 */
		public String getImgCatch() {
			return this.imgCatch;
		}

		/**
		 * @param imgCatch the imgCatch to set
		 */
		public void setImgCatch(final String imgCatch) {
			this.imgCatch = imgCatch;
		}

		/**
		 * @return imgComment
		 */
		public String getImgComment() {
			return this.imgComment;
		}

		/**
		 * @param imgComment the imgComment to set
		 */
		public void setImgComment(final String imgComment) {
			this.imgComment = imgComment;
		}

		/**
		 * @return imgUrlPath
		 */
		public String getImgUrlPath() {
			return this.imgUrlPath;
		}

		/**
		 * @param imgUrlPath the imgUrlPath to set
		 */
		public void setImgUrlPath(final String imgUrlPath) {
			this.imgUrlPath = imgUrlPath;
		}

		/**
		 * @return imgFileNm
		 */
		public String getImgFileNm() {
			return this.imgFileNm;
		}

		/**
		 * @param imgFileNm the imgFileNm to set
		 */
		public void setImgFileNm(final String imgFileNm) {
			this.imgFileNm = imgFileNm;
		}

		/**
		 * @return file
		 */
		public MultipartFile getFile() {
			return this.file;
		}

		/**
		 * @param file the file to set
		 */
		public void setFile(final MultipartFile file) {
			this.file = file;
		}

		/**
		 * @return del
		 */
		public boolean isDel() {
			return this.del;
		}

		/**
		 * @param del the del to set
		 */
		public void setDel(final boolean del) {
			this.del = del;
		}

		/**
		 * @return imgCategory
		 */
		public String getImgCategory() {
			return this.imgCategory;
		}

		/**
		 * @param imgCategory the imgCategory to set
		 */
		public void setImgCategory(final String imgCategory) {
			this.imgCategory = imgCategory;
		}

		/**
		 * @return categoryName
		 */
		public String getImgCategoryName() {
			return this.imgCategoryName;
		}

		/**
		 * @param categoryName the file to categoryName
		 */
		public void setImgCategoryName(final String imgCategoryName) {
			this.imgCategoryName = imgCategoryName;
		}

		public boolean isExistCurrentShopRirekiImg() {
			return existCurrentShopRirekiImg;
		}

		public void setExistCurrentShopRirekiImg(boolean existCurrentShopRirekiImg) {
			this.existCurrentShopRirekiImg = existCurrentShopRirekiImg;
		}


	}

	public static final class Staff extends Img {
		/**
		 * スタッフ名
		 */
		@SafeHtml
		@Length(max = 30, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String staffName;

		/**
		 * スタッフ性別
		 */
		@SafeHtml
		@Length(max = 10, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String staffSex;

		/**
		 * スタッフ業界経験
		 */
		@SafeHtml
		@Length(max = 10, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String staffExperience;

		/**
		 * スタッフ年齢
		 */
		@SafeHtml
		@Length(max = 10, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String staffAge;

		/**
		 * スタッフ得意エリア
		 */
		@SafeHtml
		@Length(max = 128, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String staffProudArea;

		/**
		 * スタッフ得意分野
		 */
		@SafeHtml
		@Length(max = 100, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String staffProudField;

		/**
		 * スタッフ出身地
		 */
		@SafeHtml
		@Length(max = 128, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String staffHometown;

		/**
		 * スタッフ資格
		 */
		@SafeHtml
		@Length(max = 30, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String staffQualification;

		/**
		 * スタッフ対応言語
		 */
		@SafeHtml
		@Length(max = 40, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String staffLanguage;

		/**
		 * @return staffName
		 */
		public String getStaffName() {
			return this.staffName;
		}

		/**
		 * @param staffName the staffName to set
		 */
		public void setStaffName(final String staffName) {
			this.staffName = staffName;
		}

		/**
		 * @return staffSex
		 */
		public String getStaffSex() {
			return this.staffSex;
		}

		/**
		 * @param staffSex the staffSex to set
		 */
		public void setStaffSex(final String staffSex) {
			this.staffSex = staffSex;
		}

		/**
		 * @return staffExperience
		 */
		public String getStaffExperience() {
			return this.staffExperience;
		}

		/**
		 * @param staffExperience the staffExperience to set
		 */
		public void setStaffExperience(final String staffExperience) {
			this.staffExperience = staffExperience;
		}

		/**
		 * @return staffAge
		 */
		public String getStaffAge() {
			return this.staffAge;
		}

		/**
		 * @param staffAge the staffAge to set
		 */
		public void setStaffAge(final String staffAge) {
			this.staffAge = staffAge;
		}

		/**
		 * @return staffProudArea
		 */
		public String getStaffProudArea() {
			return this.staffProudArea;
		}

		/**
		 * @param staffProudArea the staffProudArea to set
		 */
		public void setStaffProudArea(final String staffProudArea) {
			this.staffProudArea = staffProudArea;
		}

		/**
		 * @return staffProudField
		 */
		public String getStaffProudField() {
			return this.staffProudField;
		}

		/**
		 * @param staffProudField the staffProudField to set
		 */
		public void setStaffProudField(final String staffProudField) {
			this.staffProudField = staffProudField;
		}

		/**
		 * @return staffHometown
		 */
		public String getStaffHometown() {
			return this.staffHometown;
		}

		/**
		 * @param staffHometown the staffHometown to set
		 */
		public void setStaffHometown(final String staffHometown) {
			this.staffHometown = staffHometown;
		}

		/**
		 * @return staffQualification
		 */
		public String getStaffQualification() {
			return this.staffQualification;
		}

		/**
		 * @param staffQualification the staffQualification to set
		 */
		public void setStaffQualification(final String staffQualification) {
			this.staffQualification = staffQualification;
		}

		/**
		 * @return staffLanguage
		 */
		public String getStaffLanguage() {
			return this.staffLanguage;
		}

		/**
		 * @param staffLanguage the staffLanguage to set
		 */
		public void setStaffLanguage(final String staffLanguage) {
			this.staffLanguage = staffLanguage;
		}

	}

	public static final class Campaign extends Img {
		@SafeHtml
		@Length(max = 100, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String campaignRiyouTaisyo;

		@SafeHtml
		@Length(max = 80, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String campaignTokuten;

		@SafeHtml
		@Length(max = 60, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String campaignJouken;

		@CustomDateFormat(patterns = { "yyyyMMdd" }, message = "{error.message.yyyymmdd}")
		private String campaignStartYmd;

		@CustomDateFormat(patterns = { "yyyyMMdd" }, message = "{error.message.yyyymmdd}")
		private String campaignEndYmd;

		/**
		 * @return campaignRiyouTaisyo
		 */
		public String getCampaignRiyouTaisyo() {
			return this.campaignRiyouTaisyo;
		}

		/**
		 * @param campaignRiyouTaisyo the campaignRiyouTaisyo to set
		 */
		public void setCampaignRiyouTaisyo(final String campaignRiyouTaisyo) {
			this.campaignRiyouTaisyo = campaignRiyouTaisyo;
		}

		/**
		 * @return campaignTokuten
		 */
		public String getCampaignTokuten() {
			return this.campaignTokuten;
		}

		/**
		 * @param campaignTokuten the campaignTokuten to set
		 */
		public void setCampaignTokuten(final String campaignTokuten) {
			this.campaignTokuten = campaignTokuten;
		}

		/**
		 * @return campaignJouken
		 */
		public String getCampaignJouken() {
			return this.campaignJouken;
		}

		/**
		 * @param campaignJouken the campaignJouken to set
		 */
		public void setCampaignJouken(final String campaignJouken) {
			this.campaignJouken = campaignJouken;
		}

		/**
		 * @return campaignStartYmd
		 */
		public String getCampaignStartYmd() {
			return this.campaignStartYmd;
		}

		/**
		 * @param campaignStartYmd the campaignStartYmd to set
		 */
		public void setCampaignStartYmd(final String campaignStartYmd) {
			this.campaignStartYmd = campaignStartYmd;
		}

		/**
		 * @return campaignEndYmd
		 */
		public String getCampaignEndYmd() {
			return this.campaignEndYmd;
		}

		/**
		 * @param campaignEndYmd the campaignEndYmd to set
		 */
		public void setCampaignEndYmd(final String campaignEndYmd) {
			this.campaignEndYmd = campaignEndYmd;
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
	 * @return imgs
	 */
	public List<Img> getImgs() {
		return this.imgs;
	}

	/**
	 * @param imgs the imgs to set
	 */
	public void setImgs(final List<Img> imgs) {
		this.imgs = imgs;
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
	 * @return imgId
	 */
	public String getImgId() {
		return this.imgId;
	}

	/**
	 * @param imgId the imgId to set
	 */
	public void setImgId(final String imgId) {
		this.imgId = imgId;
	}

}

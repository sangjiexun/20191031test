package net.chintai.backend.sysadmin.crnwl.form.shop_bukken;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import net.chintai.backend.sysadmin.crnwl.validation.validator.constraints.SpelAssert;
import net.chintai.receive.crsplus.validator.constraints.CustomUrl;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.web.multipart.MultipartFile;

/**
 * <pre>
 * ShopImageStaffUpdateForm
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-10-14 17:59:47 +0900 (火, 14 10 2014) $ by $Author: kentaro.araya $
 * @version $Revision: 5906 $
 * @since 1.0
 */
public class ShopImageStaffUpdateForm {
	@NotBlank
	private String shopcd;

	@NotNull
	private Date shopKanriUpdDt;

	@NotBlank
	private String imgId;

	@Valid
	private Map<Integer, Staff> staffs = new TreeMap<>();

	// @SpelAssert(value="del ? true : staffName.trim() != '' ",message="{org.hibernate.validator.constraints.NotBlank.message}")
	public static final class Staff {
		@NotBlank
		private String imgKbn;

		private boolean del = false;

		private boolean existCurrentShopRirekiStaff = false;

		@Length(max = 1024, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		@CustomUrl
		private String imgOuterUrl;

		// @Length(max = 30, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		// private String imgCatch;
		//
		// @Length(max = 500, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		// private String imgComment;

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
				} else {
					return false;
				}
			} else {
				return true;
			}
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
			} else if (StringUtils.isNotBlank(this.imgThumbnailUrl)) {
				if (StringUtils.isBlank(this.imgOuterUrl)) {
					return false;
				}
			}
			return true;
		}

		/**
		 * スタッフ名
		 */
		@SafeHtml
		@Length(max = 30, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String staffName;

		@AssertTrue(message = "{org.hibernate.validator.constraints.NotBlank.message}")
		public boolean isNotBlankStaffName() {
			if (!this.del && !isNoValidate()) {
				if (StringUtils.isBlank(this.staffName)) {
					return false;
				}
			}
			return true;
		}

		public boolean isNoValidate() {
			//画面の入力項目
			//画面の入力項目が追加されたらここに追加してください。
			if(!existCurrentShopRirekiStaff &&
					StringUtils.isEmpty(staffName) &&
					StringUtils.isEmpty(staffSex) &&
					StringUtils.isEmpty(staffAge) &&
					StringUtils.isEmpty(staffExperience) &&
					StringUtils.isEmpty(staffProudArea) &&
					StringUtils.isEmpty(staffProudField) &&
					StringUtils.isEmpty(staffHometown) &&
					StringUtils.isEmpty(staffQualification) &&
					StringUtils.isEmpty(staffLanguage) &&
					StringUtils.isEmpty(staffCatch) &&
					StringUtils.isEmpty(staffComment) &&
					StringUtils.isEmpty(imgUrlPath) &&
					StringUtils.isEmpty(imgFileNm) &&
					file == null){
				return true;
			}else{
				return false;
			}
		}

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
		 * スタッフキャッチ
		 */
		@SafeHtml
		@Length(max = 30, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String staffCatch;

		/**
		 * スタッフコメント
		 */
		@SafeHtml
		@Length(max = 100, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String staffComment;

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
		 * @return staffCatch
		 */
		public String getStaffCatch() {
			return this.staffCatch;
		}

		/**
		 * @param staffCatch the staffCatch to set
		 */
		public void setStaffCatch(final String staffCatch) {
			this.staffCatch = staffCatch;
		}

		/**
		 * @return staffComment
		 */
		public String getStaffComment() {
			return this.staffComment;
		}

		/**
		 * @param staffComment the staffComment to set
		 */
		public void setStaffComment(final String staffComment) {
			this.staffComment = staffComment;
		}

		public boolean isExistCurrentShopRirekiStaff() {
			return existCurrentShopRirekiStaff;
		}

		public void setExistCurrentShopRirekiStaff(boolean existCurrentShopRirekiStaff) {
			this.existCurrentShopRirekiStaff = existCurrentShopRirekiStaff;
		}

	}

	/**
	 * @return staffs
	 */
	public Map<Integer, Staff> getStaffs() {
		return this.staffs;
	}

	/**
	 * @param staffs the staffs to set
	 */
	public void setStaffs(final Map<Integer, Staff> staffs) {
		this.staffs = staffs;
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

package net.chintai.backend.sysadmin.crnwl.form.shop_bukken;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import net.chintai.backend.sysadmin.crnwl.validation.validator.constraints.SpelAssert;
import net.chintai.receive.crsplus.validator.DatePatterns;
import net.chintai.receive.crsplus.validator.constraints.CustomDateFormat;
import net.chintai.receive.crsplus.validator.constraints.CustomUrl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.web.multipart.MultipartFile;

/**
 * <pre>
 * ShopImageCampaignUpdateForm
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-10-14 17:59:47 +0900 (火, 14 10 2014) $ by $Author: kentaro.araya $
 * @version $Revision: 5906 $
 * @since 1.0
 */
public class ShopImageCampaignUpdateForm {
	@NotBlank
	private String shopcd;

	@NotNull
	private Date shopKanriUpdDt;

	@NotBlank
	private String imgId;

	@Valid
	private Map<Integer, Campaign> campaigns = new TreeMap<>();

	@Valid
	private Map<String, Comment> comments = new TreeMap<>();

	public static final class Comment {
		@SafeHtml
		private String commentText;

		/**
		 * @return commentText
		 */
		public String getCommentText() {
			return this.commentText;
		}

		/**
		 * @param commentText the commentText to set
		 */
		public void setCommentText(final String commentText) {
			this.commentText = commentText;
		}

	}

	/*
	@SpelAssert.List({
			@SpelAssert(value = " del || campaignRiyouTaisyo != '' ", message = "{org.hibernate.validator.constraints.NotBlank.message}"),
			@SpelAssert(value = " del || campaignTokuten != '' ", message = "{org.hibernate.validator.constraints.NotBlank.message}"),
			@SpelAssert(value = " del || campaignJouken != '' ", message = "{org.hibernate.validator.constraints.NotBlank.message}") })
	*/
	public static final class Campaign {
		@NotBlank
		private String imgKbn;

		private boolean del = false;

		private boolean existCurrentShopRirekiCampaign = false;

		@Length(max = 1024, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		@CustomUrl
		private String imgOuterUrl;

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

		@SafeHtml
		//@SpelAssert(value = " #this == null || !#this.isEmpty() ", message = "{org.hibernate.validator.constraints.NotBlank.message}")
		@Length(max = 100, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String campaignRiyouTaisyo;

		@AssertTrue(message = "{org.hibernate.validator.constraints.NotBlank.message}")
		public boolean isNotCampaignRiyouTaisyo() {
			if (!this.del && !isNoValidate()) {
				if (StringUtils.isBlank(this.campaignRiyouTaisyo)) {
					return false;
				}
			}
			return true;
		}


		@SafeHtml
		//@SpelAssert(value = " #this == null || !#this.isEmpty() ", message = "{org.hibernate.validator.constraints.NotBlank.message}")
		@Length(max = 80, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String campaignTokuten;

		@AssertTrue(message = "{org.hibernate.validator.constraints.NotBlank.message}")
		public boolean isNotCampaignTokuten() {
			if (!this.del && !isNoValidate()) {
				if (StringUtils.isBlank(this.campaignTokuten)) {
					return false;
				}
			}
			return true;
		}


		@SafeHtml
		//@SpelAssert(value = " #this == null || !#this.isEmpty() ", message = "{org.hibernate.validator.constraints.NotBlank.message}")
		@Length(max = 60, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String campaignJouken;

		@AssertTrue(message = "{org.hibernate.validator.constraints.NotBlank.message}")
		public boolean isNotCampaignJouken() {
			if (!this.del && !isNoValidate()) {
				if (StringUtils.isBlank(this.campaignJouken)) {
					return false;
				}
			}
			return true;
		}


		@CustomDateFormat(patterns = { "yyyyMMdd" }, message = "{error.message.yyyymmdd}")
		private String campaignStartYmd;

		@AssertTrue(message = "{org.hibernate.validator.constraints.NotBlank.message}")
		public boolean isNotBlankCampaignStartYmd() {
			if (!this.del && !isNoValidate()) {
				if (StringUtils.isBlank(this.campaignStartYmd)) {
					return false;
				}
			}
			return true;
		}

		@CustomDateFormat(patterns = { "yyyyMMdd" }, message = "{error.message.yyyymmdd}")
		private String campaignEndYmd;

		/**
		 * キャンペーン開始日・終了日のチェック。
		 * @return キャンペーン終了日<キャンペーン開始日は false 以外は false
		 */
		@AssertTrue(message = "{error.message.startEndYmd}")
		public boolean isLittleEqualStartYmdThanEndYmd() {
			if ((StringUtils.isNotBlank(this.campaignStartYmd)) && (StringUtils.isNotBlank(this.campaignEndYmd))) {
				try {
					final Date start = DateUtils.parseDateStrictly(this.campaignStartYmd,
							new String[] { DatePatterns.YYYYMMDD });
					final Date end = DateUtils.parseDateStrictly(this.campaignEndYmd,
							new String[] { DatePatterns.YYYYMMDD });
					if (start.compareTo(end) > 0) {
						return false;
					}
				}
				catch (final ParseException e) {
					// 何もしない
				}
			}
			return true;
		}

		public boolean isNoValidate() {
			//画面の入力項目
			//画面の入力項目が追加されたらここに追加してください。
			if(!existCurrentShopRirekiCampaign &&
					StringUtils.isEmpty(campaignStartYmd) &&
					StringUtils.isEmpty(campaignEndYmd) &&
					StringUtils.isEmpty(campaignRiyouTaisyo) &&
					StringUtils.isEmpty(campaignTokuten) &&
					StringUtils.isEmpty(campaignJouken) &&
					StringUtils.isEmpty(campaignComment) &&
					StringUtils.isEmpty(imgUrlPath) &&
					StringUtils.isEmpty(imgFileNm) &&
					file == null){
				return true;
			}else{
				return false;
			}
		}

		/**
		 * キャンペーンコメント
		 */
		@SafeHtml
		@Length(max = 500, message = "{org.hibernate.validator.constraints.Length.message.maxOnly}")
		private String campaignComment;

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

		/**
		 * @return campaignComment
		 */
		public String getCampaignComment() {
			return this.campaignComment;
		}

		/**
		 * @param campaignComment the campaignComment to set
		 */
		public void setCampaignComment(final String campaignComment) {
			this.campaignComment = campaignComment;
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

		public boolean isExistCurrentShopRirekiCampaign() {
			return existCurrentShopRirekiCampaign;
		}

		public void setExistCurrentShopRirekiCampaign(
				boolean existCurrentShopRirekiCampaign) {
			this.existCurrentShopRirekiCampaign = existCurrentShopRirekiCampaign;
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

	/**
	 * @return campaigns
	 */
	public Map<Integer, Campaign> getCampaigns() {
		return this.campaigns;
	}

	/**
	 * @return comments
	 */
	public Map<String, Comment> getComments() {
		return this.comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(final Map<String, Comment> comments) {
		this.comments = comments;
	}

	/**
	 * @param campaigns the campaigns to set
	 */
	public void setCampaigns(final Map<Integer, Campaign> campaigns) {
		this.campaigns = campaigns;
	}

}

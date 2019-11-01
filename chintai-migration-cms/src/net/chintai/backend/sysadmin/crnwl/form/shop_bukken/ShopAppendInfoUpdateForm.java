package net.chintai.backend.sysadmin.crnwl.form.shop_bukken;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.chintai.batch.common.GenericFlg;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

/**
 * <pre>
 * ShopAppendInfoUpdateForm
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-08-07 15:08:39 +0900 (木, 07 8 2014) $ by $Author: hasegawa $
 * @version $Revision: 4295 $
 * @since 1.0
 */
public class ShopAppendInfoUpdateForm {
	@NotBlank
	private String shopcd;

	@NotNull
	private Date shopKanriUpdDt;

	@Valid
	private Map<String, Comment> comments = new TreeMap<>();

	private String listIconFlgMovie;

	private String listIconFlgCampaign;

	private String listIconFlgShop;

	@Valid
	private Map<String, CharComment> charComments = new TreeMap<>();

	// @NotEmpty
	@Valid
	@Size(max = 10)
	private Map<Integer, Area> areas = new TreeMap<>();

	// @NotEmpty
	@Valid
	@Size(max = 10)
	private Map<Integer, Eki> ekis = new TreeMap<>();

	public static final class CharComment {
		@SafeHtml
		private String charComment;

		private String priorityDispFlg = GenericFlg.OFF.getValue();

		/**
		 * @return charComment
		 */
		public String getCharComment() {
			return this.charComment;
		}

		/**
		 * @param charComment the charComment to set
		 */
		public void setCharComment(final String charComment) {
			this.charComment = charComment;
		}

		/**
		 * @return priorityDispFlg
		 */
		public String getPriorityDispFlg() {
			return this.priorityDispFlg;
		}

		/**
		 * @param priorityDispFlg the priorityDispFlg to set
		 */
		public void setPriorityDispFlg(final String priorityDispFlg) {
			this.priorityDispFlg = priorityDispFlg;
		}

	}

	// @SpelAssert("commentText.length() < @masterService.selectMstCommentKbnByPrimaryKey('5').commentMaxLength")
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

	public static class Area {
		private String prefcd;

		private String citycd;

		/**
		 * @return prefcd
		 */
		public String getPrefcd() {
			return this.prefcd;
		}

		/**
		 * @param prefcd the prefcd to set
		 */
		public void setPrefcd(final String prefcd) {
			this.prefcd = prefcd;
		}

		/**
		 * @return citycd
		 */
		public String getCitycd() {
			return this.citycd;
		}

		/**
		 * @param citycd the citycd to set
		 */
		public void setCitycd(final String citycd) {
			this.citycd = citycd;
		}
	}

	public static class Eki {
		private String ensencd;

		private String ekicd;

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
	 * @return listIconFlgMovie
	 */
	public String getListIconFlgMovie() {
		return this.listIconFlgMovie;
	}

	/**
	 * @param listIconFlgMovie the listIconFlgMovie to set
	 */
	public void setListIconFlgMovie(final String listIconFlgMovie) {
		this.listIconFlgMovie = listIconFlgMovie;
	}

	/**
	 * @return listIconFlgCampaign
	 */
	public String getListIconFlgCampaign() {
		return this.listIconFlgCampaign;
	}

	/**
	 * @param listIconFlgCampaign the listIconFlgCampaign to set
	 */
	public void setListIconFlgCampaign(final String listIconFlgCampaign) {
		this.listIconFlgCampaign = listIconFlgCampaign;
	}

	/**
	 * @return listIconFlgShop
	 */
	public String getListIconFlgShop() {
		return this.listIconFlgShop;
	}

	/**
	 * @param listIconFlgShop the listIconFlgShop to set
	 */
	public void setListIconFlgShop(final String listIconFlgShop) {
		this.listIconFlgShop = listIconFlgShop;
	}

	/**
	 * @return charComments
	 */
	public Map<String, CharComment> getCharComments() {
		return this.charComments;
	}

	/**
	 * @param charComments the charComments to set
	 */
	public void setCharComments(final Map<String, CharComment> charComments) {
		this.charComments = charComments;
	}

	/**
	 * @return areas
	 */
	public Map<Integer, Area> getAreas() {
		return this.areas;
	}

	/**
	 * @param areas the areas to set
	 */
	public void setAreas(final Map<Integer, Area> areas) {
		this.areas = areas;
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

}

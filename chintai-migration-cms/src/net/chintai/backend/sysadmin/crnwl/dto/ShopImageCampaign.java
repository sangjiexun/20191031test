package net.chintai.backend.sysadmin.crnwl.dto;

import java.util.ArrayList;
import java.util.List;

import net.chintai.batch.common.domain.ShopRirekiCampaign;
import net.chintai.batch.common.domain.ShopRirekiComment;

/**
 * <pre>
 * ShopImageCampaign
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-07-18 15:06:26 +0900 (金, 18 7 2014) $ by $Author: hasegawa $
 * @version $Revision: 3530 $
 * @since 1.0
 */
public class ShopImageCampaign extends ShopImage {

	private List<ShopRirekiCampaign> shopRirekiCampaigns = new ArrayList<>();

	private List<ShopRirekiComment> shopRirekiComments = new ArrayList<>();

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

}

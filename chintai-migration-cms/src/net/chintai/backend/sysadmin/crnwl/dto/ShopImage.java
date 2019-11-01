package net.chintai.backend.sysadmin.crnwl.dto;

import java.util.ArrayList;
import java.util.List;

import net.chintai.batch.common.domain.ShopRirekiImg;

/**
 * <pre>
 * ShopBasicInfo
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-07-03 14:49:55 +0900 (木, 03 7 2014) $ by $Author: hasegawa $
 * @version $Revision: 2815 $
 * @since 1.0
 */
public class ShopImage extends Shop {

	private List<ShopRirekiImg> shopRirekiImgs = new ArrayList<>();

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

}

package net.chintai.backend.sysadmin.crnwl.dto;

import java.util.ArrayList;
import java.util.List;

import net.chintai.batch.common.domain.ShopRirekiEki;

/**
 * <pre>
 * ShopBasicInfo
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-07-31 14:32:52 +0900 (木, 31 7 2014) $ by $Author: hasegawa $
 * @version $Revision: 4047 $
 * @since 1.0
 */
public class ShopBasicInfo extends Shop {

	private List<ShopRirekiEki> shopRirekiEkis = new ArrayList<>();

	private boolean nayoseSkip;

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

}

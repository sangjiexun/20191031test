package net.chintai.backend.sysadmin.crnwl.dto;

import java.util.List;

import net.chintai.batch.common.domain.ShopRirekiCharacter;
import net.chintai.batch.common.domain.ShopRirekiComment;
import net.chintai.batch.common.domain.ShopRirekiProudArea;
import net.chintai.batch.common.domain.ShopRirekiProudEki;

/**
 * <pre>
 * ShopAppendInfo
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-07-07 18:58:09 +0900 (月, 07 7 2014) $ by $Author: hasegawa $
 * @version $Revision: 2956 $
 * @since 1.0
 */
public class ShopAppendInfo extends Shop {

	private List<ShopRirekiComment> shopRirekiComments;

	private List<ShopRirekiProudArea> shopRirekiProudAreas;

	private List<ShopRirekiProudEki> shopRirekiProudEkis;

	private List<ShopRirekiCharacter> shopRirekiCharacters;

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

}

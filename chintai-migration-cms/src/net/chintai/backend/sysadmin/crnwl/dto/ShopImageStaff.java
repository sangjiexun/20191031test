package net.chintai.backend.sysadmin.crnwl.dto;

import java.util.ArrayList;
import java.util.List;

import net.chintai.batch.common.domain.ShopRirekiStaff;

/**
 * <pre>
 * ShopImageStaff
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-07-11 16:58:58 +0900 (金, 11 7 2014) $ by $Author: hasegawa $
 * @version $Revision: 3249 $
 * @since 1.0
 */
public class ShopImageStaff extends ShopImage {

	private List<ShopRirekiStaff> shopRirekiStaffs = new ArrayList<>();

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

}

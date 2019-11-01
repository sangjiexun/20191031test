package net.chintai.backend.sysadmin.crnwl.dto;

import java.util.Date;

import net.chintai.batch.common.domain.ShopRireki;

/**
 * <pre>
 * Shop
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-07-04 16:56:31 +0900 (金, 04 7 2014) $ by $Author: hasegawa $
 * @version $Revision: 2895 $
 * @since 1.0
 */
public class Shop {
	private String shopcd;

	private Date shopKanriUpdDt;

	private ShopRireki shopRireki;

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
	 * @return shopRireki
	 */
	public ShopRireki getShopRireki() {
		return this.shopRireki;
	}

	/**
	 * @param shopRireki the shopRireki to set
	 */
	public void setShopRireki(final ShopRireki shopRireki) {
		this.shopRireki = shopRireki;
	}

}

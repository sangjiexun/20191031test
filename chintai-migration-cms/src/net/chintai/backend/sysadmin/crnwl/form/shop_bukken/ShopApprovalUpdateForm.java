package net.chintai.backend.sysadmin.crnwl.form.shop_bukken;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * <pre>
 * ShopApprovalUpdateForm
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-07-04 18:04:48 +0900 (金, 04 7 2014) $ by $Author: hasegawa $
 * @version $Revision: 2903 $
 * @since 1.0
 */
public class ShopApprovalUpdateForm {
	@NotBlank
	private String certifyFlg = "0";

	@NotBlank
	private String shopcd;

	@NotNull
	private Date shopKanriUpdDt;

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
	 * @return certifyFlg
	 */
	public String getCertifyFlg() {
		return this.certifyFlg;
	}

	/**
	 * @param certifyFlg the certifyFlg to set
	 */
	public void setCertifyFlg(final String certifyFlg) {
		this.certifyFlg = certifyFlg;
	}

}

package net.chintai.backend.sysadmin.crnwl;

/**
 * <pre>
 * MstCommentKbn
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-05-29 21:49:06 +0900 (木, 29 5 2014) $ by $Author: hasegawa $
 * @version $Revision: 1530 $
 * @since 1.0
 */
public enum MstCommentKbn {
	DATA_KBN_SHOP("1"), ;

	private String value;

	/**
	 * @param value
	 */
	private MstCommentKbn(final String value) {
		this.value = value;
	}

	/**
	 * @return
	 */
	public String getValue() {
		return this.value;
	}

}

package net.chintai.backend.sysadmin.crnwl.web.tags;

import javax.servlet.jsp.JspException;

import org.springframework.util.StringUtils;

/**
 * <pre>
 * SelectTag
 * for strust type parameter name
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-06-20 18:08:43 +0900 (金, 20 6 2014) $ by $Author: hasegawa $
 * @version $Revision: 2297 $
 * @since 1.0
 */
public class SpringSelectTag extends org.springframework.web.servlet.tags.form.SelectTag {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * null || map || list,array
	 */
	private String pathType;

	/*
	 * (非 Javadoc)
	 *
	 * @see org.springframework.web.servlet.tags.form.AbstractDataBoundFormElementTag#getName()
	 */
	@Override
	protected String getName() throws JspException {
		String ret = super.getName();
		if ("map".equals(getPathType())) {
			ret = StringUtils.replace(ret, "[", "(");
			ret = StringUtils.replace(ret, "]", ")");
		}
		return ret;
	}

	/**
	 * @return pathType
	 */
	public String getPathType() {
		return this.pathType;
	}

	/**
	 * @param pathType the pathType to set
	 */
	public void setPathType(final String pathType) {
		this.pathType = pathType;
	}

}

package net.chintai.backend.sysadmin.crnwl.web.tags;

import javax.servlet.jsp.JspException;

import net.chintai.backend.sysadmin.crnwl.web.jstl.Utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.tags.form.InputTag;

/**
 * <pre>
 * InputResolveMaxLengthTag
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-07-08 19:05:49 +0900 (火, 08 7 2014) $ by $Author: hasegawa $
 * @version $Revision: 3015 $
 * @since 1.0
 */
public class InputResolveMaxLengthTag extends InputTag {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private boolean sameSizeMaxlength;

	/*
	 * (非 Javadoc)
	 *
	 * @see org.springframework.web.servlet.tags.form.InputTag#getMaxlength()
	 */
	@Override
	protected String getMaxlength() {
		final String s = super.getMaxlength();
		if (StringUtils.hasText(s)) {
			return s;
		}
		Object root;
		String fieldName;
		try {
			final BindingResult bindingResult = (BindingResult) getBindStatus().getErrors();
			final Object form = bindingResult.getTarget();

			if (getPath().lastIndexOf(".") == -1) {
				root = form;
				fieldName = getPath();
			}
			else {
				final BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(form);
				root = bw.getPropertyValue(getPath().substring(0, getPath().lastIndexOf(".")));
				fieldName = getPath().substring(getPath().lastIndexOf(".") + 1);
			}
		}
		catch (BeansException | JspException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		final Integer len = Utils.maxLength(root, fieldName);
		return len == null ? "" : len.toString();
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see org.springframework.web.servlet.tags.form.InputTag#getSize()
	 */
	@Override
	protected String getSize() {
		if(isSameSizeMaxlength()){
			return getMaxlength();
		}
		final String s = super.getSize();
		if (StringUtils.hasText(s)) {
			return s;
		}
		return getMaxlength();
	}

	/**
	 * @return sameSizeMaxlength
	 */
	public boolean isSameSizeMaxlength() {
		return this.sameSizeMaxlength;
	}

	/**
	 * @param sameSizeMaxlength the sameSizeMaxlength to set
	 */
	public void setSameSizeMaxlength(final boolean sameSizeMaxlength) {
		this.sameSizeMaxlength = sameSizeMaxlength;
	}

}

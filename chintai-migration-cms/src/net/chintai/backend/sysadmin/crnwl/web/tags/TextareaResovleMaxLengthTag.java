package net.chintai.backend.sysadmin.crnwl.web.tags;

import javax.servlet.jsp.JspException;

import net.chintai.backend.sysadmin.crnwl.web.jstl.Utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.tags.form.TagWriter;
import org.springframework.web.servlet.tags.form.TextareaTag;

/**
 * <pre>
 * TextareaResovleMaxLengthTag
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-06-20 18:08:43 +0900 (金, 20 6 2014) $ by $Author: hasegawa $
 * @version $Revision: 2297 $
 * @since 1.0
 */
public class TextareaResovleMaxLengthTag extends TextareaTag {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static final String MAXLENGTH_ATTRIBUTE = "maxlength";

	private String maxlength;

	/*
	 * (非 Javadoc)
	 *
	 * @see
	 * org.springframework.web.servlet.tags.form.AbstractHtmlElementTag#writeDefaultAttributes(org.springframework.web
	 * .servlet.tags.form.TagWriter)
	 */
	@Override
	protected void writeDefaultAttributes(final TagWriter tagWriter) throws JspException {
		super.writeDefaultAttributes(tagWriter);
		writeOptionalAttribute(tagWriter, MAXLENGTH_ATTRIBUTE, getMaxlength());
	}

	/**
	 * @return maxlength
	 */
	public String getMaxlength() {
		String s = this.maxlength;
		if(StringUtils.hasText(s)){
			return s;
		}
		Object root;
		String fieldName;
		try {
			BindingResult bindingResult = (BindingResult) getBindStatus().getErrors();
			Object form = bindingResult.getTarget();

			if(getPath().lastIndexOf(".") == -1){
				root = form;
				fieldName = getPath();
			}else{
				BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(form);
				root = bw.getPropertyValue(getPath().substring(0,getPath().lastIndexOf(".")));
				fieldName = getPath().substring(getPath().lastIndexOf(".") + 1);
			}
		}
		catch (BeansException | JspException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		Integer len = Utils.maxLength(root, fieldName);
		return len == null ? "" : len.toString();
	}

	/**
	 * @param maxlength the maxlength to set
	 */
	public void setMaxlength(final String maxlength) {
		this.maxlength = maxlength;
	}

}

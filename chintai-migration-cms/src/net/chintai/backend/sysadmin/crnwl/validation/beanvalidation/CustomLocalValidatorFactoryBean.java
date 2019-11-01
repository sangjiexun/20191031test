package net.chintai.backend.sysadmin.crnwl.validation.beanvalidation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.validation.metadata.ConstraintDescriptor;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * <pre>
 * CustomLocalValidatorFactoryBean
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-07-08 19:05:49 +0900 (火, 08 7 2014) $ by $Author: hasegawa $
 * @version $Revision: 3015 $
 * @since 1.0
 */
public class CustomLocalValidatorFactoryBean extends LocalValidatorFactoryBean {

	/*
	 * (非 Javadoc)
	 *
	 * @see
	 * org.springframework.validation.beanvalidation.SpringValidatorAdapter#getArgumentsForConstraint(java.lang.String,
	 * java.lang.String, javax.validation.metadata.ConstraintDescriptor)
	 */
	@Override
	protected Object[] getArgumentsForConstraint(final String objectName, final String field,
			final ConstraintDescriptor<?> descriptor) {
		final Object[] arguments = super.getArgumentsForConstraint(objectName, field, descriptor);
		if (field.indexOf(".") > -1) {
			MessageSourceResolvable messageSourceResolvable = (MessageSourceResolvable)arguments[0];
			String[] codes = (String[]) ArrayUtils.add(messageSourceResolvable.getCodes(), field.substring(field.indexOf(".") + 1))  ;
			arguments[0] = new DefaultMessageSourceResolvable(codes , field);
		}
		return arguments;
	}

}

package net.chintai.backend.sysadmin.crnwl.validation.validator.constraints;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.context.ApplicationContext;
import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * <pre>
 * SpelAssertValidator
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-07-08 19:05:49 +0900 (火, 08 7 2014) $ by $Author: hasegawa $
 * @version $Revision: 3015 $
 * @since 1.0
 */
public class SpelAssertValidator implements ConstraintValidator<SpelAssert, Object> {

	@Inject
	private ApplicationContext applicationContext;

	@Inject
	private ExpressionParser parser;

	private Expression expression;

	/* (非 Javadoc)
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
	 */
	@Override
	public void initialize(final SpelAssert constraintAnnotation) {

		final String rawExpression = constraintAnnotation.value();

		if (rawExpression == null) {
			throw new IllegalArgumentException("The expression specified in @" + SpelAssert.class.getSimpleName()
					+ " must not be null.");
		}

		this.expression = this.parser.parseExpression(rawExpression);
	}

	/* (非 Javadoc)
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {

		if (value == null) {
			return true;
		}

		final StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();
		standardEvaluationContext.setBeanResolver(new MyBeanResolver(this.applicationContext));
		return Boolean.TRUE.equals(this.expression.getValue(standardEvaluationContext, value, Boolean.class));
	}

	/**
	 * <pre>
	 * MyBeanResolver
	 * </pre>
	 * @author hasegawa
	 * @lastModified $Date: 2014-07-08 19:05:49 +0900 (火, 08 7 2014) $ by $Author: hasegawa $
	 * @version $Revision: 3015 $
	 * @since 1.0
	 */
	private static final class MyBeanResolver implements BeanResolver {
		private final ApplicationContext applicationContext;

		public MyBeanResolver(final ApplicationContext applicationContext) {
			super();
			this.applicationContext = applicationContext;
		}

		/*
		 * (非 Javadoc)
		 *
		 * @see org.springframework.expression.BeanResolver#resolve(org.springframework.expression.EvaluationContext,
		 * java.lang.String)
		 */
		@Override
		public Object resolve(final EvaluationContext context, final String beanName) throws AccessException {
			return this.applicationContext.getBean(beanName);
		}

	}
}

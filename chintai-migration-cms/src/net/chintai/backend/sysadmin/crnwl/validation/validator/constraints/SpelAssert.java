package net.chintai.backend.sysadmin.crnwl.validation.validator.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * <pre>
 * SpelAssert
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-07-08 19:05:49 +0900 (火, 08 7 2014) $ by $Author: hasegawa $
 * @version $Revision: 3015 $
 * @since 1.0
 */
@Target({ FIELD, TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = SpelAssertValidator.class)
@Documented
public @interface SpelAssert {

	String message() default "{net.chintai.backend.sysadmin.crnwl.validator.SpelAssert.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * A SpEL script expression to be evaluated against the annotated object. This expression must return
	 * {@link Boolean#TRUE} if the annotated object is valid, {@link Boolean#FALSE} otherwise. Any expression returning
	 * a non boolean value will yield in an exception upon validation.
	 *
	 * @return A SpEL script expression.
	 */
	String value();

	/**
	 * Defines several {@link SpelAssert} annotations on the same element.
	 */
	@Target({ FIELD, TYPE })
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		SpelAssert[] value();
	}
}
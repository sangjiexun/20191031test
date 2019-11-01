package net.chintai.backend.sysadmin.crnwl.web.jstl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import net.chintai.batch.common.util.CryptUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * <pre>
 * Utils
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2015-01-27 14:52:50 +0900 (火, 27 1 2015) $ by $Author: kentaro.araya $
 * @version $Revision: 6741 $
 * @since 1.0
 */
public abstract class Utils {
	protected final static Log logger = LogFactory.getLog(Utils.class);

	private static final List<Class<? extends Annotation>> requiredAnnotations = new ArrayList<>();
	static {
		requiredAnnotations.add(NotBlank.class);
		requiredAnnotations.add(NotEmpty.class);
		requiredAnnotations.add(NotNull.class);
	}

	/**
	 * @param encryptedString
	 * @return
	 */
	public static String decypt(final String encryptedString) {
		try {
			return CryptUtils.decypt(encryptedString);
		}
		catch (Exception e) {
			logger.warn(e.getMessage(), e);
			return encryptedString;
		}
	}

	/**
	 * @param root
	 * @param fieldName
	 * @param annotationClass
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public static <T extends Annotation> T getFieldAnnotation(final Object root, final String fieldName,
			final Class<T> annotationClass) throws NoSuchFieldException, SecurityException {
		T a = root.getClass().getDeclaredField(fieldName).getAnnotation(annotationClass);
		if (a == null) {
			for (final Annotation an : root.getClass().getDeclaredField(fieldName).getAnnotations()) {
				a = an.annotationType().getAnnotation(annotationClass);
				if (a != null) {
					break;
				}
			}
		}
		return a;
	}

	/**
	 * @param root
	 * @param fieldName
	 * @return
	 */
	public static Integer maxLength(final Object root, final String fieldName) {
		Length a;
		try {
			a = getFieldAnnotation(root, fieldName, Length.class);
		}
		catch (NoSuchFieldException | SecurityException e) {
			return null;
		}
		if(a == null){
//			try {
//				Field f = root.getClass().getDeclaredField(fieldName);
//				Class<? extends Number> num = f.getType().asSubclass(Number.class);
//			}
//			catch (ClassCastException| NoSuchFieldException | SecurityException e) {
//				return null;
//			}
		}
		return a == null ? null : a.max();
	}

	/**
	 * @param root
	 * @param fieldName
	 * @return
	 */
	public static boolean isRequired(final Object root, final String fieldName) {
		for (final Class<? extends Annotation> a : requiredAnnotations) {
			try {
				if (getFieldAnnotation(root, fieldName, a) != null) {
					return true;
				}
			}
			catch (NoSuchFieldException | SecurityException e) {
			}
		}
		return false;
	}
}

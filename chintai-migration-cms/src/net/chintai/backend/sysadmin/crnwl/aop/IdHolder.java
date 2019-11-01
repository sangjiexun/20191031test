package net.chintai.backend.sysadmin.crnwl.aop;

import org.springframework.core.NamedThreadLocal;

/**
 * <pre>
 * IdHolder
 * </pre>
 *
 * @author hasegawa
 * @lastModified $Date: 2014-06-25 20:52:34 +0900 (水, 25 6 2014) $ by $Author: hasegawa $
 * @version $Revision: 2523 $
 * @since 1.0
 */
public abstract class IdHolder {
	private static ThreadLocal<String> id = new NamedThreadLocal<String>("IdHolder");

	/**
	 * @return called
	 */
	public static final String getId() {
		return id.get();
	}

	public static final void setId(final String value) {
		id.set(value);
	}

	public static final void resetId() {
		id.set(null);
	}
}

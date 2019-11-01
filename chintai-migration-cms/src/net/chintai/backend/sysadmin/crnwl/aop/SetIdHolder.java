package net.chintai.backend.sysadmin.crnwl.aop;

import net.chintai.backend.sysadmin.common.session.SessionBean;
import net.chintai.backend.sysadmin.common.session.SessionBeanManager;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * <pre>
 * SetIdHolder
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-06-30 17:17:41 +0900 (月, 30 6 2014) $ by $Author: hasegawa $
 * @version $Revision: 2669 $
 * @since 1.0
 */
@Aspect
public class SetIdHolder {

	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping))")
	private void around() {
	}
	/**
	 * around
	 *
	 * @throws Throwable void
	 */
	@Around("around()")
	public Object around(final ProceedingJoinPoint joinPoint) throws Throwable {
		final SessionBean sessionBean = SessionBeanManager
				.getSessionBean(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
						.getRequest());
		IdHolder.setId(sessionBean.getUserId());
		final Object ret = joinPoint.proceed();
		IdHolder.resetId();
		return ret;
	}

}

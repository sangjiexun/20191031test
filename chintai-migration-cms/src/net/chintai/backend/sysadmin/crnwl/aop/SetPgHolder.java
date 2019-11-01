package net.chintai.backend.sysadmin.crnwl.aop;

import net.chintai.batch.common.aop.PgHolder;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * <pre>
 * SetPgHolder
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-06-23 19:09:35 +0900 (月, 23 6 2014) $ by $Author: hasegawa $
 * @version $Revision: 2378 $
 * @since 1.0
 */
@Aspect
public class SetPgHolder {

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
		PgHolder.setPg(joinPoint.getTarget().getClass().getName());
		final Object ret = joinPoint.proceed();
		PgHolder.resetPg();
		return ret;
	}

}

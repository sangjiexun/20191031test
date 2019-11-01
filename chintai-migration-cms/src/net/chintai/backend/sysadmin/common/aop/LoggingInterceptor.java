/*
 * $Id: LoggingInterceptor.java 3759 2008-01-21 06:28:19Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2008/01/21   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.common.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.AbstractTraceInterceptor;

/**
 * ロギング用インターセプター。<br>
 * Spring framework 付属の
 * {@link org.springframework.aop.interceptor.SimpleTraceInterceptor} を改造したもの。
 * 
 * @author KOJIMA Takanori
 */
public class LoggingInterceptor extends AbstractTraceInterceptor {

    /** serialVersionUID */
    private static final long serialVersionUID = 7556894809626882126L;

    /**
     * Create a new SimpleTraceInterceptor with a static logger.
     */
    public LoggingInterceptor() {
    }

    /**
     * Create a new LoggingInterceptor with dynamic or static logger, according
     * to the given flag.
     * @param useDynamicLogger whether to use a dynamic logger or a static
     *        logger
     * @see #setUseDynamicLogger
     */
    public LoggingInterceptor(boolean useDynamicLogger) {
        setUseDynamicLogger(useDynamicLogger);
    }

    /*
     * (非 Javadoc)
     * @see org.springframework.aop.interceptor.AbstractTraceInterceptor#invokeUnderTrace(org.aopalliance.intercept.MethodInvocation,
     *      org.apache.commons.logging.Log)
     */
    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, Log logger) throws Throwable {
        String invocationDescription = getInvocationDescription(invocation);
        if (logger.isInfoEnabled()) {
            logger.info("[AppLog] Entering: " + invocationDescription);
        }
        try {
            Object rval = invocation.proceed();
            return rval;
        } catch (Throwable ex) {
            if (logger.isInfoEnabled()) {
                logger.info("[AppLog] 例外発生: " + invocationDescription, ex);
            }
            throw ex;
        }
    }

    /**
     * Return a description for the given method invocation.
     * @param invocation the invocation to describe
     * @return the description
     */
    protected String getInvocationDescription(MethodInvocation invocation) {
        return "method '" + invocation.getMethod().getName() + "' of class ["
                + invocation.getThis().getClass().getName() + "]";
    }

    /*
     * (非 Javadoc)
     * @see org.springframework.aop.interceptor.AbstractTraceInterceptor#isLogEnabled(org.apache.commons.logging.Log)
     */
    @Override
    protected boolean isLogEnabled(Log logger) {
        return logger.isInfoEnabled();
    }

}

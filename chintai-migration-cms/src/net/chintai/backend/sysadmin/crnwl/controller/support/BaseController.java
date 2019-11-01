/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package net.chintai.backend.sysadmin.crnwl.controller.support;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.exception.SystemException;
import net.chintai.backend.sysadmin.common.properties.CodeProperties;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.TokenProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * BaseController
 *
 * Don't modify name. see AbstractConstRegisterInterceptor
 * </pre>
 *
 * @author hasegawa
 * @lastModified $Date: 2014-10-14 17:59:47 +0900 (火, 14 10 2014) $ by $Author: kentaro.araya $
 * @version $Revision: 5906 $
 * @since 1.0
 */
public abstract class BaseController {
	public static final String CANCEL_KEY = "net.chintai.backend.sysadmin.crnwl.controller.CANCEL";

	private static TokenProcessor token = TokenProcessor.getInstance();

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	protected MessageSource messageSource;
	@Autowired
	protected ServletContext servletContext;

	@Qualifier("operationLoggingService")
	@Autowired
	protected OperationLoggingService loggingService;

	/**
	 * @author io
	 *
	 */
	public class errorMsgComparator implements Comparator<String> {
		@Override
		public int compare(String str1, String str2) {
			final String s1 =  str1.substring(str1.indexOf("[") + 1, str1.indexOf("]"));
			final String s2 =  str2.substring(str2.indexOf("[") + 1, str2.indexOf("]"));
			return Integer.parseInt(s1) < Integer.parseInt(s2) ? -1 : 1;
		}
	}

	/**
	 * @see AuthorityId
	 * @return
	 */
	public abstract AuthorityId getAuthorityId();

	/**
	 * @param redirectAttrs
	 * @param messageId
	 * @param placeHolders
	 */
	protected void saveMsg(final HttpServletRequest request, final String messageId, final String... placeHolders) {
		final String messageKey = CodeProperties.getProperty(messageId);
		final ActionMessages errors = new ActionMessages();
		final ActionMessage error = new ActionMessage(messageKey, placeHolders);
		errors.add(error.getKey(), error);
		//redirectAttrs.addFlashAttribute(Globals.MESSAGE_KEY, errors);
		request.getSession().setAttribute(Globals.MESSAGE_KEY, errors);
	}

	/**
	 * @param redirectAttrs
	 * @param messageId
	 * @param placeHolders
	 */
	protected void saveErrMsg(final HttpServletRequest request, final String messageId) {
		final String messageKey = CodeProperties.getProperty(messageId);
		final ActionMessages errors = new ActionMessages();
		final ActionMessage error = new ActionMessage(messageKey, null);
		errors.add(error.getKey(), error);
		//redirectAttrs.addFlashAttribute(Globals.ERROR_KEY, errors);
		request.getSession().setAttribute(Globals.ERROR_KEY, errors);
	}

	/**
	 * initDataBinder
	 *
	 * @param binder
	 * @param request void
	 */
	@InitBinder
	public void initDataBinder(final DataBinder binder, final HttpServletRequest request) {
		// binder.registerCustomEditor(byte[].class, new
		// ResolveCharsetByteArrayPropertyEditor(this.appProperties.getProperty("contentsCharset")));
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("\t"));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyyMMddHHmmssSSS"), true));
		final DecimalFormat fmt = new DecimalFormat("#");
		binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(BigDecimal.class, fmt, true));
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}

	/**
	 * <p>
	 * Return <code>true</code> if there is a transaction token stored in the user's current session, and the value
	 * submitted as a request parameter with this action matches it. Returns <code>false</code> under any of the
	 * following circumstances:
	 * </p>
	 *
	 * <ul>
	 *
	 * <li>No session associated with this request</li>
	 * <li>No transaction token saved in the session</li>
	 *
	 * <li>No transaction token included as a request parameter</li>
	 *
	 * <li>The included transaction token value does not match the transaction token in the user's session</li>
	 *
	 * </ul>
	 *
	 * @param request The servlet request we are processing
	 * @param reset Should we reset the token after checking it?
	 * @return <code>true</code> if there is a transaction token and it is valid; <code>false</code> otherwise.
	 */
	protected final boolean isTokenInValid(final HttpServletRequest request, final boolean reset) {
		return !token.isTokenValid(request, reset);
	}

	/**
	 * @param request
	 * @see org.apache.struts.util.TokenProcessor#resetToken(javax.servlet.http.HttpServletRequest)
	 */
	protected void resetToken(final HttpServletRequest request) {
		token.resetToken(request);
	}

	/**
	 * <p>
	 * Returns <code>true</code> if the current form's cancel button was pressed. This method will check if the
	 * <code>Globals.CANCEL_KEY</code> request attribute has been set, which normally occurs if the cancel button
	 * generated by <strong>CancelTag</strong> was pressed by the user in the current request. If <code>true</code>,
	 * validation performed by an <strong>ActionForm</strong>'s <code>validate()</code> method will have been skipped by
	 * the controller servlet.
	 * </p>
	 *
	 * <p>
	 * Since Action 1.3.0, the mapping for a cancellable Action must also have the new "cancellable" property set to
	 * true. If "cancellable" is not set, and the magic Cancel token is found in the request, the standard Composable
	 * Request Processor will throw an InvalidCancelException.
	 * </p>
	 *
	 * @param request The servlet request we are processing
	 * @return <code>true</code> if the cancel button was pressed; <code>false</code> otherwise.
	 */
	protected boolean isCancelled(final HttpServletRequest request) {
		return (request.getParameter(CANCEL_KEY) != null);
	}

	/**
	 * isTokenInValid
	 *
	 * @param request
	 * @param reset
	 * @param result
	 * @return
	 */
	protected final boolean isTokenInValid(final HttpServletRequest request, final boolean reset, final Errors result) {
		final boolean ret = isTokenInValid(request, reset);

		if (ret) {
			result.reject("view.error.TokenError", "リクエストが完成しませんでした。操作が順番どおりではありません、始めからやり直してください。");
		}

		return ret;
	}

	/**
	 * <p>
	 * Save a new transaction token in the user's current session, creating a new session if necessary.
	 * </p>
	 *
	 * @param request The servlet request we are processing
	 */
	protected final void saveToken(final HttpServletRequest request) {
		token.saveToken(request);
	}

	// <!-- ========== Global Exception Definitions =========================== -->
	// <global-exceptions>
	// <exception key="APPLICATION.ERROR.KEY"
	// type="net.chintai.backend.sysadmin.common.exception.ApplicationException"
	// path="/WEB-INF/jsp/error/ApplicationException.jsp"
	// handler="net.chintai.backend.sysadmin.common.exception.ApplicationExceptionHandler" />
	/**
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(ApplicationException.class)
	public ModelAndView handleApplicationException(final ApplicationException ex, final HttpServletRequest request) {
		if (this.logger.isErrorEnabled()) {
			this.logger.error(ex.getErrorId(), ex);
		}
		final ActionMessages errors = new ActionMessages();
		final ActionMessage error = new ActionMessage(ex.getMessageId(), ex.getPlaceHolders());
		errors.add(error.getKey(), error);
		request.setAttribute(Globals.ERROR_KEY, errors);
		final ModelAndView modelAndView = new ModelAndView("/error/ApplicationException");
		return modelAndView;

	}

	// <exception key="SYSTEM.ERROR.KEY"
	// type="net.chintai.backend.sysadmin.common.exception.SystemException"
	// path="/WEB-INF/jsp/error/SystemException.jsp"
	// handler="net.chintai.backend.sysadmin.common.exception.SystemExceptionHandler" />
	// </global-exceptions>

	/**
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler({ SystemException.class, Exception.class })
	public ModelAndView handleSystemException(final Exception e, final HttpServletRequest request) {
		SystemException ex;
		if (e instanceof SystemException) {
			ex = (SystemException) e;
		}
		else {
			ex = new SystemException("FETAL.M.SYSTEM.0001", e);
		}
		if (this.logger.isErrorEnabled()) {
			this.logger.error(ex.getErrorId(), ex);
		}
		final ActionMessages errors = new ActionMessages();
		final ActionMessage error = new ActionMessage(ex.getMessageId(), ex.getPlaceHolders());
		errors.add(error.getKey(), error);
		request.setAttribute(Globals.ERROR_KEY, errors);
		final ModelAndView modelAndView = new ModelAndView("/error/SystemException");
		return modelAndView;

	}

	// /**
	// * handleHttpSessionRequiredException
	// *
	// * @param ex
	// * @param request
	// * @return
	// */
	// @ExceptionHandler(HttpSessionRequiredException.class)
	// public View handleHttpSessionRequiredException(final Exception ex, final HttpServletRequest request) {
	// return new RedirectView("/", true, true, false);
	// }
	//
	// /**
	// * handleHttpRequestMethodNotSupportedException
	// *
	// * @param ex
	// * @param request
	// * @return
	// */
	// @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	// public View handleHttpRequestMethodNotSupportedException(final Exception ex, final HttpServletRequest request) {
	// this.logger.debug(ex.getMessage(), ex);
	// return new RedirectView("/", true, true, false);
	// }
	//
	// /**
	// * handleNoSuchRequestHandlingMethodException
	// *
	// * @param ex
	// * @param request
	// * @return
	// */
	// @ExceptionHandler(NoSuchRequestHandlingMethodException.class)
	// public View handleNoSuchRequestHandlingMethodException(final Exception ex, final HttpServletRequest request) {
	// this.logger.debug(ex.getMessage(), ex);
	// return new RedirectView("/", true, true, false);
	// }
	//
	// /**
	// * handleTypeMismatchExceptionException for binding type mismatch
	// *
	// * @param ex
	// * @param request
	// * @return
	// */
	// @ExceptionHandler(TypeMismatchException.class)
	// public View handleTypeMismatchExceptionException(final Exception ex, final HttpServletRequest request) {
	// this.logger.debug(ex.getMessage(), ex);
	// return new RedirectView("/", true, true, false);
	// }
	//
	// /**
	// * handleMissingServletRequestParameterException for binding type mismatch
	// *
	// * @param ex
	// * @param request
	// * @return
	// */
	// @ExceptionHandler(MissingServletRequestParameterException.class)
	// public View handleMissingServletRequestParameterException(final Exception ex, final HttpServletRequest request) {
	// this.logger.debug(ex.getMessage(), ex);
	// return new RedirectView("/", true, true, false);
	// }
	//
	// /**
	// * @param ex
	// * @param request
	// * @return
	// */
	// @ExceptionHandler(IllegalStateException.class)
	// public View handleIllegalStateException(final Exception ex, final HttpServletRequest request) {
	// this.logger.debug(ex.getMessage(), ex);
	// return new RedirectView("/", true, true, false);
	// }
}

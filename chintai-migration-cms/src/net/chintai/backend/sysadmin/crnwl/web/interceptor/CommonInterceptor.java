package net.chintai.backend.sysadmin.crnwl.web.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionBean;
import net.chintai.backend.sysadmin.common.session.SessionBeanManager;
import net.chintai.backend.sysadmin.crnwl.controller.support.BaseController;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * <pre>
 * CommonInterceptor
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-06-27 17:56:24 +0900 (金, 27 6 2014) $ by $Author: hasegawa $
 * @version $Revision: 2607 $
 * @since 1.0
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private ServletContext servletContext;

	@Autowired
	private AuthService authService;

	/*
	 * (非 Javadoc)
	 *
	 * @see
	 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception {

		final HttpSession session = request.getSession(false);

		if (session != null) {
			// Remove messages as needed
			ActionMessages messages = (ActionMessages) session.getAttribute(Globals.MESSAGE_KEY);

			if (messages != null) {
				if (messages.isAccessed()) {
					session.removeAttribute(Globals.MESSAGE_KEY);
				}
			}

			// Remove error messages as needed
			messages = (ActionMessages) session.getAttribute(Globals.ERROR_KEY);

			if (messages != null) {
				if (messages.isAccessed()) {
					session.removeAttribute(Globals.ERROR_KEY);
				}
			}
		}

		// セッションを取得
		final SessionBean sessionBean = SessionBeanManager.getSessionBean(request);

		String userId = null;
		if (sessionBean != null) {
			userId = sessionBean.getUserId();
		}

		BaseController ctlr = null;
		if (handler instanceof HandlerMethod) {
			final HandlerMethod hm = (HandlerMethod) handler;
			if (hm.getBean() instanceof BaseController) {
				ctlr = (BaseController) hm.getBean();
			}
		}
		else if (handler instanceof BaseController) {
			ctlr = (BaseController) handler;
		}
		if (ctlr != null) {
			// アクセス権限チェック
			if (!this.authService.authenticate(userId, ctlr.getAuthorityId())) {
				throw new ApplicationException("ERROR.M.APP.0003");
			}
			return super.preHandle(request, response, handler);

		}

		throw new ApplicationException("ERROR.M.APP.0003");

	}

}

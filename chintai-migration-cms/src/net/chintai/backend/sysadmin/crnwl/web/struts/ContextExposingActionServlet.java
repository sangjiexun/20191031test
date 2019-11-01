package net.chintai.backend.sysadmin.crnwl.web.struts;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.chintai.backend.sysadmin.crnwl.ImgKbn;
import net.chintai.backend.sysadmin.crnwl.MstCommentKbn;
import net.chintai.backend.sysadmin.crnwl.controller.support.BaseController;

import org.apache.struts.action.ActionServlet;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.ContextExposingHttpServletRequest;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * <pre>
 * ContextExposingActionServlet
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-06-11 20:45:39 +0900 (水, 11 6 2014) $ by $Author: hasegawa $
 * @version $Revision: 1894 $
 * @since 1.0
 */
public class ContextExposingActionServlet extends ActionServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (非 Javadoc)
	 *
	 * @see org.apache.struts.action.ActionServlet#process(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void process(final HttpServletRequest request, final HttpServletResponse response) throws IOException,
			ServletException {
		final WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(request
				.getServletContext());
		final HttpServletRequest req = new ContextExposingHttpServletRequest(request, wc, null);
		super.process(req, response);
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see org.apache.struts.action.ActionServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		final ServletContext context = getServletContext();
		for (final Map.Entry<String, Object> e : ConstUtil.getConstMap().entrySet()) {
			context.setAttribute(e.getKey(), e.getValue());
		}
	}

	/**
	 * <pre>
	 * TODO うまいやりかた？
	 * </pre>
	 * @author hasegawa
	 * @lastModified $Date: 2014-06-11 20:45:39 +0900 (水, 11 6 2014) $ by $Author: hasegawa $
	 * @version $Revision: 1894 $
	 * @since 1.0
	 */
	private abstract static class ConstUtil {

		public static Map<String, Object> getConstMap() {
			Map<String, Object> constMap;
			{
				final Map<String, Object> map = new HashMap<String, Object>();

				{
					final Map<String, Object> m = new HashMap<String, Object>();

					for (final ImgKbn c : ImgKbn.values()) {
						m.put(c.name(), c.getValue());
					}

					map.put("ImgKbn", Collections.unmodifiableMap(m));
				}
				{
					final Map<String, Object> m = new HashMap<String, Object>();

					for (final MstCommentKbn c : MstCommentKbn.values()) {
						m.put(c.name(), c.getValue());
					}

					map.put("MstCommentKbn", Collections.unmodifiableMap(m));
				}
				{
					final Map<String, Object> m = new HashMap<String, Object>();
					m.put("CANCEL_KEY",BaseController.CANCEL_KEY);
					map.put("BaseController", Collections.unmodifiableMap(m));
				}

				constMap = Collections.unmodifiableMap(map);
			}
			return constMap;
		}
	}
}

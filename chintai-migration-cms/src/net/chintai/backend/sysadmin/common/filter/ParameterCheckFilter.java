package net.chintai.backend.sysadmin.common.filter;

import net.chintai.backend.sysadmin.common.util.InvalidParameterChecker;

import org.apache.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

import java.util.Enumeration;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 不正パラメータチェックフィルター
 * @author araya
 */
public class ParameterCheckFilter extends OncePerRequestFilter {

    /* (non-Javadoc)
     * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
     */
    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain) throws ServletException, IOException {
        Enumeration<?> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String p = (String) params.nextElement();
            if (InvalidParameterChecker.judge(p)) {
            	//不正パラメータが存在
            	response.sendError(response.SC_GONE);
				return;
            }
        }
        chain.doFilter(request, response);
    }
}

/*
 * $Id: ApplicationExceptionHandler.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/07/10  BGT)児島   新規作成
 * 
 */
package net.chintai.backend.sysadmin.common.exception;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

/**
 * ApplicationException の例外ハンドラ。<br>
 * Action クラスから ApplicationException がスローされると、<br>
 * エラー内容をロギングしてエラー画面に遷移します。<br>
 * このハンドラは Struts によって自動的に呼び出されますが、<br>
 * ハンドラの利用には struts-config.xml#global-exceptions<br>
 * への登録が必要です。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ApplicationExceptionHandler extends ExceptionHandler {

    private static Log log = LogFactory
            .getLog(ApplicationExceptionHandler.class);

    /*
     * (非 Javadoc)
     * @see org.apache.struts.action.ExceptionHandler#execute(java.lang.Exception,
     *      org.apache.struts.config.ExceptionConfig,
     *      org.apache.struts.action.ActionMapping,
     *      org.apache.struts.action.ActionForm,
     *      javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(Exception e, ExceptionConfig config,
            ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws ServletException {

        ActionForward forward = super.execute(e, config, mapping, form,
                request, response);
        ActionMessage error = null;
        String property = null;

        if (e instanceof ApplicationException) {
            ApplicationException ae = (ApplicationException) e;
            error = new ActionMessage(ae.getMessageId(), ae.getPlaceHolders());
            property = error.getKey();

            if (log.isErrorEnabled()) {
                log.error(ae.getErrorId(), e);
            }
        } else {
            error = new ActionMessage(config.getKey(), e.getMessage());
            property = error.getKey();

            if (log.isErrorEnabled()) {
                log.error(error.getKey(), e);
            }
        }

        // Store the exception
        request.setAttribute(Globals.MESSAGE_KEY, error);
        this.storeException(request, property, error, forward, config
                .getScope());

        return forward;
    }
}

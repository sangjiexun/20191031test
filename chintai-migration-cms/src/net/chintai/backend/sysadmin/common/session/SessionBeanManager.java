/*
 * $Id: SessionBeanManager.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/06/21  BGT)児島   新規作成
 * 
 */
package net.chintai.backend.sysadmin.common.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * セッションビーンを管理するクラス。<br>
 * セッションビーンの取得や設定、削除を行います。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class SessionBeanManager {

    /** セッションオブジェクトの名前 */
    private static final String C_SESSION_BEAN_NAME = "SessionBean";

    /**
     * 外部からのインスタンス生成はできません。
     */
    private SessionBeanManager() {
    }

    /**
     * 空のセッションビーンを新規作成します。
     * @return セッションビーン
     */
    public static SessionBean createSessionBean() {
        return new SessionBean();
    }

    /**
     * セッションビーンを取得します。<br>
     * 取得できなかった場合は、空のセッションビーンを新規作成します。
     * @param request HTTPリクエスト
     * @return セッションビーン
     */
    public static SessionBean createSessionBean(HttpServletRequest request) {
        return createSessionBean(request.getSession());
    }

    /**
     * セッションビーンを取得します。<br>
     * 取得できなかった場合は空のセッションビーンを新規作成します。
     * @param session HTTPセッション
     * @return セッションビーン
     */
    public static SessionBean createSessionBean(HttpSession session) {
        SessionBean sessionBean = getSessionBean(session);
        if (sessionBean == null) {
            return new SessionBean();
        }
        return sessionBean;
    }

    /**
     * セッションビーンを取得します。<br>
     * 取得できなかった場合は null を返します。
     * @param request HTTPリクエスト
     * @return セッションビーン
     */
    public static SessionBean getSessionBean(HttpServletRequest request) {
        return getSessionBean(request.getSession());
    }

    /**
     * セッションビーンを取得します。<br>
     * 取得できなかった場合は null を返します。
     * @param session HTTPセッション
     * @return セッションビーン
     */
    public static SessionBean getSessionBean(HttpSession session) {
        Object sessionObject = session.getAttribute(C_SESSION_BEAN_NAME);
        if (sessionObject != null && sessionObject instanceof SessionBean) {
            return (SessionBean) sessionObject;
        }
        return null;
    }

    /**
     * セッションビーンを設定します。
     * @param request HTTPリクエスト
     * @param bean セッションビーン
     */
    public static void setSessionBean(HttpServletRequest request, SessionBean bean) {
        setSessionBean(request.getSession(), bean);
    }

    /**
     * セッションビーンを設定します。
     * @param session HTTPセッション
     * @param bean セッションビーン
     */
    public static void setSessionBean(HttpSession session, SessionBean bean) {
        session.setAttribute(C_SESSION_BEAN_NAME, bean);
    }

    /**
     * セッションビーンを削除します。
     * @param request HTTPリクエスト
     */
    public static void removeSessionBean(HttpServletRequest request) {
        removeSessionBean(request.getSession());
    }

    /**
     * セッションビーンを削除します。
     * @param session HTTPセッション
     */
    public static void removeSessionBean(HttpSession session) {
        session.invalidate();
    }
}

/*
 * $Id: BusinessContext.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/07/10   BGT)児島      新規作成
 * 2007/07/24   BGT)児島      フィールドに HttpServletRequest を追加
 * 2007/09/27   BGT)児島      パラメータ付 ActionForward への対応
 * 2007/09/27   BGT)児島      不要な Setter/Getter の削除
 */
package net.chintai.backend.sysadmin.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.chintai.backend.sysadmin.common.properties.CodeProperties;
import net.chintai.backend.sysadmin.common.session.SessionBean;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 * Action クラスが利用するコンテキストです。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class BusinessContext {

    /** フォームオブジェクト */
    private ActionForm form;

    /** リクエストオブジェクト */
    private HttpServletRequest request;

    /** レスポンスオブジェクト */
    private HttpServletResponse response;

    /** セッションビーン */
    private SessionBean sessionBean;

    /** メッセージ集合 */
    private ActionMessages messages;

    /** エラーメッセージ集合 */
    private ActionMessages errors;

    /** 遷移先 */
    private String forwardName;

    /** ビューヘルパ */
    private ViewHelper viewHelper;

    /** ActionForward のパラメータ */
    private Map<String, String> forwardParameterMap;

    /** フォワードURL */
    private String forwardUrl;

    /** リダイレクトフラグ */
    private boolean redirect = false;

    /** コンストラクタ */
    public BusinessContext() {
    }

    /**
     * フォームオブジェクトを設定します。
     * @param form フォームオブジェクト
     */
    public void setForm(ActionForm form) {
        this.form = form;
    }

    /**
     * フォームオブジェクトを取得します。
     * @return フォームオブジェクト
     */
    public ActionForm getForm() {
        return this.form;
    }

    /**
     * セッションビーンを設定します。
     * @param sessionBean セッションビーン
     */
    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    /**
     * セッションビーンを取得します。
     * @return セッションビーン
     */
    public SessionBean getSessionBean() {
        return this.sessionBean;
    }

    /**
     * セッションビーンを削除します。
     */
    public void removeSessionBean() {
        this.sessionBean = null;
    }

    /**
     * リクエストオブジェクトを設定します。
     * @param request リクエストオブジェクト
     */
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * リクエストオブジェクトを取得します。
     * @return リクエストオブジェクト
     */
    public HttpServletRequest getRequest() {
        return request;
    }

    /**
     * レスポンスオブジェクトを設定します。
     * @param response レスポンスオブジェクト
     */
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    /**
     * レスポンスオブジェクトを取得します。
     * @return レスポンスオブジェクト
     */
    public HttpServletResponse getResponse() {
        return response;
    }

    /**
     * メッセージを設定します。
     * @param messageId メッセージID
     */
    public void setMessage(String messageId) {
        setMessage(messageId, (String[]) null);
    }

    /**
     * メッセージを設定します。
     * @param messageId メッセージID
     * @param placeHolders プレースホルダ
     */
    public void setMessage(String messageId, String... placeHolders) {
        String messageKey = CodeProperties.getProperty(messageId);
        ActionMessage message = new ActionMessage(messageKey, placeHolders);
        if (this.messages == null) {
            this.messages = new ActionMessages();
        }
        this.messages.add(ActionMessages.GLOBAL_MESSAGE, message);
    }

    /**
     * メッセージ集合を取得します。
     * @return メッセージ集合
     */
    public ActionMessages getMessages() {
        return this.messages;
    }

    /**
     * エラーメッセージを設定します。
     * @param errorId エラーID
     */
    public void setError(String errorId) {
        setError(errorId, (String[]) null);
    }

    /**
     * エラーメッセージを設定します。
     * @param errorId エラーID
     * @param placeHolders プレースホルダ
     */
    public void setError(String errorId, String... placeHolders) {
        String messageKey = CodeProperties.getProperty(errorId);
        ActionMessage error = new ActionMessage(messageKey, placeHolders);
        if (this.errors == null) {
            this.errors = new ActionErrors();
        }
        this.errors.add(ActionErrors.GLOBAL_MESSAGE, error);
    }

    /**
     * エラーメッセージ集合を取得します。
     * @return エラーメッセージ集合
     */
    public ActionMessages getErrors() {
        return this.errors;
    }

    /**
     * 遷移先を設定します。
     * @param forwardName 遷移先
     */
    public void setForward(String forwardName) {
        this.forwardName = forwardName;
    }

    /**
     * 遷移先および、遷移先で使用するビューヘルパを設定します。
     * @param forwardName 遷移先
     * @param viewHelper 遷移先で使用するビューヘルパ
     */
    public void setForward(String forwardName, ViewHelper viewHelper) {
        this.forwardName = forwardName;
        this.viewHelper = viewHelper;
    }

    /**
     * 遷移先を取得します。
     * @return 遷移先
     */
    public String getForward() {
        return this.forwardName;
    }

    /**
     * ビューヘルパを設定します。
     * @param viewHelper ビューヘルパ
     */
    public void setViewHelper(ViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * ビューヘルパを取得します。
     * @return ビューヘルパ
     */
    public ViewHelper getViewHelper() {
        return this.viewHelper;
    }

    /**
     * ビューヘルパ名を取得します。取得できなかった場合は null を返します。
     * @return ビューヘルパ名
     */
    public String getViewHelperName() {
        if (viewHelper == null) {
            return null;
        }
        return this.viewHelper.getClass().getSimpleName();
    }

    /**
     * ActionForward のパラメータを取得します。
     * @return ActionForward のパラメータ
     */
    public Map<String, String> getForwardParameterMap() {
        return forwardParameterMap;
    }

    /**
     * ActionForward のパラメータを設定します。
     * @param forwardParameterMap ActionForward のパラメータ
     */
    public void setForwardParameterMap(Map<String, String> forwardParameterMap) {
        this.forwardParameterMap = forwardParameterMap;
    }

    /**
     * フォワードURLを取得します。
     * @return フォワードURL
     */
    public String getForwardUrl() {
        return forwardUrl;
    }

    /**
     * フォワードURLを設定します。
     * @param forwardUrl フォワードURL
     */
    public void setForwardUrl(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }

    /**
     * リダイレクトフラグを取得します。
     * @return リダイレクトフラグ
     */
    public boolean isRedirect() {
        return redirect;
    }

    /**
     * リダイレクトフラグを設定します。
     * @param redirect リダイレクトフラグ
     */
    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }
}
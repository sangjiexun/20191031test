/*
 * $Id: BaseActionSupport.java 3773 2008-01-30 07:20:40Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/06/21   BGT)児島      新規作成
 * 2007/07/31   BGT)児島      コンテキストの設定項目を追加
 * 2007/09/19   BGT)児島      画面タイトル取得ロジックを追加
 * 2007/09/19   BGT)児島      サイドバー表示ロジックを追加
 * 2007/09/27   BGT)児島      パラメータ付 ActionForward への対応
 * 2007/09/28   BGT)児島      画面タイトル取得ロジック削除
 * 2008/01/21   BGT)児島      ロギング処理を追加
 */
package net.chintai.backend.sysadmin.common;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.exception.SystemException;
import net.chintai.backend.sysadmin.common.session.SessionBean;
import net.chintai.backend.sysadmin.common.session.SessionBeanManager;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionRedirect;
import org.springframework.web.struts.ActionSupport;

/**
 * Action の基底クラスです。<br>
 * すべての Action は、このクラスを継承します。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3773 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public abstract class BaseActionSupport extends ActionSupport {

    private static Log log = LogFactory.getLog(BaseActionSupport.class);

    /**
     * Action が実行されるとき Struts によって呼び出されるメソッド。<br>
     * このメソッドはオーバーライドできません。
     * 
     * @see org.apache.struts.action.Action#execute(
     *      org.apache.struts.action.ActionMapping,
     *      org.apache.struts.action.ActionForm,
     *      javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @Override
    public final ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        if (log.isInfoEnabled()) {
            log.info("[AppLog] Execute Action: " + getClass().getName());
        }
        
        try {
            // セッションを取得
            SessionBean sessionBean = SessionBeanManager.getSessionBean(request);

            String userId = null;
            if (sessionBean != null) {
                userId = sessionBean.getUserId();
            }

            // アクセス権限チェック
            if (!isAuthorized(userId)) {
                throw new ApplicationException("ERROR.M.APP.0003");
            }

            // コンテキストを設定
            BusinessContext context = new BusinessContext();
            context.setForm(form);
            context.setSessionBean(sessionBean);
            context.setRequest(request);
            context.setResponse(response);

            // ビジネスロジック実行
            // このメソッドを各サブクラスが Override する
            doExecute(context);

            if (response.isCommitted()) {
                return null;
            }

            // 画面出力用の各種情報を保存
            ActionMessages messages = context.getMessages();
            if (messages != null) {
                saveMessages(request, messages);
            }

            ActionMessages errors = context.getErrors();
            if (errors != null) {
                saveErrors(request, errors);
            }

            String viewHelperName = context.getViewHelperName();
            if (viewHelperName != null) {
                request.setAttribute(viewHelperName, context.getViewHelper());
            }

            // セッション情報を登録
            // コンテキストのセッションビーンが null の場合は、セッションを無効化する
            if (context.getSessionBean() != null) {
                SessionBeanManager.setSessionBean(request, context.getSessionBean());
            } else {
                SessionBeanManager.removeSessionBean(request);
            }

            // 遷移先の決定
            ActionForward actionForward = mapping.findForward(context.getForward());

            // リダイレクト判定
            if (context.isRedirect()) {
                ActionRedirect actionRedirect;

                if (StringUtils.isNotEmpty(context.getForwardUrl())) {
                    actionRedirect = new ActionRedirect(context.getForwardUrl());
                } else {
                    actionRedirect = new ActionRedirect(actionForward);
                }

                if (context.getForwardParameterMap() != null) {
                    Map<String, String> map = context.getForwardParameterMap();

                    for (Entry<String, String> entry : map.entrySet()) {
                        actionRedirect.addParameter(entry.getKey(), entry.getValue());
                    }
                }
                return actionRedirect;
            }
            return actionForward;

        } catch (ApplicationException e) {
            throw e;
        } catch (SystemException e) {
            SessionBeanManager.removeSessionBean(request);
            throw e;
        } catch (Exception e) {
            SessionBeanManager.removeSessionBean(request);
            throw new SystemException("FETAL.M.SYSTEM.0001", e);
        }
    }

    /**
     * ユーザの権限チェックを行い、チェック結果を戻します。<br>
     * このメソッドは下位クラスでのオーバーライドが必須です。<br>
     * 権限チェックが必要ない場合は、常に true を返すメソッドを<br>
     * 実装してください。
     * @param userId ユーザID
     * @return 実行権限がある場合 true, 実行権限がない場合 false
     */
    protected abstract boolean isAuthorized(String userId);

    /**
     * ビジネスロジックを実行します。<br>
     * このメソッドは下位クラスでのオーバーライドが必須です。
     * @param context ビジネスコンテキスト
     * @throws Exception
     */
    protected abstract void doExecute(BusinessContext context) throws Exception;
}

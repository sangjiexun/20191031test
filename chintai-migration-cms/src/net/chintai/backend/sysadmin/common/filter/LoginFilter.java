/*
 * $Id: LoginFilter.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者    内容
 * ---------------------------------------------------------
 * 2007/06/15   BGT)児島  新規作成
 * 2007/08/03   BGT)児島  コメント追加
 * 2007/09/27   BGT)児島  フィルタリングロジック修正
 * 2007/10/15   BGT)児島  広告管理機能からの遷移をフィルタするロジックを追加
 * 2007/10/25   BGT)児島  デバッグ用ロギング処理削除、リクエストパラメータのチェック処理追加
 * 2007/11/06   BGT)児島  メニュー取得リクエストのたびにセッションが作成されてしまうバグを修正
 */
package net.chintai.backend.sysadmin.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import net.chintai.backend.sysadmin.common.session.SessionBean;
import net.chintai.backend.sysadmin.common.session.SessionBeanManager;
import net.chintai.backend.sysadmin.common.util.CryptUtil;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.login.service.LoginService;
import net.chintai.backend.sysadmin.login.service.MngSessionService;
import net.chintai.backend.sysadmin.login.service.bean.LoginServiceBean;
import net.chintai.backend.sysadmin.login.service.bean.MngSessionInServiceBean;
import net.chintai.backend.sysadmin.login.service.bean.MngSessionOutServiceBean;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * ログイン認証フィルター。<br>
 * リクエスト元のユーザーが既にログイン済みかどうかチェックします。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class LoginFilter implements Filter {

    /** ユーザIDのリクエストパラメータ名 */
    private static final String C_USER_ID_PARAM = "u";

    /** 日付のリクエストパラメータ名 */
    private static final String C_DATE_PARAM = "t";

    /** ロギングオブジェクト */
    private static Log log = LogFactory.getLog(LoginFilter.class);

    /** コンフィグパラメータ */
    private FilterConfig config;

    /**
     * ログインチェックを行い、ログインしていない場合は強制的にフォワードします。<br>
     * フォワード先は web.xml にパラメータとして記述します。
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String url = httpRequest.getRequestURI();

        // ログインチェック実施有無フラグ
        boolean pass = isExcludeUrl(url);

        // 広告管理機能からの画面遷移であるかどうか確認
        if (!pass) {
            String encryptedUserId = (String) request.getParameter(C_USER_ID_PARAM);
            String encryptedPostDate = (String) request.getParameter(C_DATE_PARAM);

            if (StringUtils.isNotEmpty(encryptedUserId) && StringUtils.isNotEmpty(encryptedPostDate)) {

                // パラメータの復号化・検証
                String userId = CryptUtil.blowfishDecrypt(encryptedUserId);
                String postDate = CryptUtil.blowfishDecrypt(encryptedPostDate);

                if (StringUtils.isEmpty(userId) || DateUtil.isNotValidDate(postDate)) {
                    pass = false;
                }

                // セッション作成
                SessionBean sessionBean = createSession(userId, postDate, httpRequest);
                if (sessionBean == null) {
                    pass = false;
                } else {
                    SessionBeanManager.setSessionBean(httpRequest, sessionBean);
                    pass = true;
                }
            }
        }

        // ログインチェック
        if (!pass) {
            SessionBean sessionBean = SessionBeanManager.getSessionBean(httpRequest);
            if (sessionBean == null || sessionBean.getUserId() == null) {
                request.getRequestDispatcher(getForwardUrl()).forward(request, response);
                return;
            }
        }

        chain.doFilter(request, response);
    }

    /*
     * (非 Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
        if (log.isInfoEnabled()) {
            log.info("Initializing filter '" + config.getFilterName() + "'");
        }
    }

    /*
     * (非 Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
        this.config = null;
    }

    /**
     * リクエストURLがフィルタの対象外かどうかを判定します。
     * @param targetUrl リクエストURL
     * @return フィルタ適用対象外:true, フィルタ適用対象:false
     */
    public boolean isExcludeUrl(String targetUrl) {
        List<String> excludeUrls = getExcludeUrls();
        for (String exclude : excludeUrls) {
            if (targetUrl.contains(exclude)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 新規セッションビーンを作成します。
     * @param userId ユーザID
     * @param postDate 送信日付
     * @param request HTTPリクエストオブジェクト
     * @return ユーザ情報が取得できた場合は、取得したユーザ情報を使って生成した SessionBean を返します。<br>
     *         ユーザ情報が取得できなかった場合は null を返します。
     */
    private SessionBean createSession(String userId, String postDate, HttpServletRequest request) {
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        LoginService loginService = (LoginService) ac.getBean("loginService");
        MngSessionService mngSessionService = (MngSessionService) ac.getBean("mngSessionService");

        // ユーザ情報取得
        LoginServiceBean bean = loginService.getUserInfo(userId, postDate);
        if (bean == null) {
            return null;
        }
        MngSessionInServiceBean inBean = new MngSessionInServiceBean();
        inBean.setUserId(bean.getUserId());
        inBean.setOperUserId(bean.getUserId());
        inBean.setPgName( this.getClass().getName());

        // セッションテーブルに登録
        MngSessionOutServiceBean outBean = mngSessionService.insertMngSession(inBean);


        // 新規セッションを作成
        SessionBean sessionBean = SessionBeanManager.createSessionBean();
        sessionBean.init(userId, bean.getUserName(), request.getContextPath(),
                outBean.getSidId(),outBean.getLoginKey());
        return sessionBean;
    }

    /**
     * フォワード先を取得します。<br>
     * フォワード先は web.xml#init-param に記述します。
     * @return フォワード先
     */
    private String getForwardUrl() {
        return this.config.getInitParameter("forwardUrl");
    }

    /**
     * 除外URLリストを取得します。<br>
     * 除外URLは web.xml#init-param に記述します。<br>
     * 複数のURLを指定する場合は、カンマで区切ります。
     * @return 除外URLリスト
     */
    private List<String> getExcludeUrls() {
        String[] excludes = this.config.getInitParameter("exclude").split(",");
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < excludes.length; i++) {
            list.add(excludes[i].trim());
        }
        return list;
    }
}

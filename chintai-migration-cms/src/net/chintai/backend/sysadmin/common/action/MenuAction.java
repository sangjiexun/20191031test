/*
 * $Id: MenuAction.java 3821 2008-02-20 04:16:12Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/25   BGT)児島      新規作成
 * 2007/10/15   BGT)児島      統合<-->広告インターフェース仕様にて定められた呼び出し形式に対応
 * 2007/11/14   BGT)児島      Webログ機能への遷移時に付加するパラメータで暗号化していない
 *                            ものがあったので、暗号化する処理を追加
 * 2008/01/10   BGT)児島      ステージング環境での表示に対応
 */
package net.chintai.backend.sysadmin.common.action;

import static net.chintai.backend.sysadmin.common.properties.ServerProperties.getProperty;
import static net.chintai.backend.sysadmin.common.util.CryptUtil.blowfishDecrypt;
import static net.chintai.backend.sysadmin.common.util.CryptUtil.blowfishEncrypt;
import static net.chintai.backend.sysadmin.common.util.DateUtil.getToday;
import static net.chintai.backend.sysadmin.common.util.DateUtil.isNotValidDate;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.chintai.backend.sysadmin.common.properties.ServerProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionBean;
import net.chintai.backend.sysadmin.common.session.SessionBeanManager;
import net.chintai.backend.sysadmin.common.velocity.SideBarContext;
import net.chintai.backend.sysadmin.common.velocity.VelocityMerger;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;
import org.springframework.web.struts.ActionSupport;

/**
 * サイドメニュー表示用 JavaScript を生成するアクションです。<br>
 * このアクションは広告機能からも呼び出されますので、<br>
 * インターフェースの変更には十分注意して下さい。<br>
 * また、このアクションは JavaScript を返却する特殊な Action なので、<br>
 * 共通基底クラス BaseActionSupport を利用していません。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3821 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class MenuAction extends ActionSupport {

    /** JavaScript の出力エンコーディング */
    private static final String C_OUTPUT_ENCODING = "UTF-8";

    /** JavaScript のファイル名 */
    private static final String C_JS_FILE_NAME = "sidebar.js";

    /** Webログ関連機能にリンクする際に付加する固定パラメータ */
    private static final String C_WEBLOG_USER_FLAG = "1";

    /*
     * (非 Javadoc)
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
     *      org.apache.struts.action.ActionForm,
     *      javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @Override
    public final ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // パラメータ取得
        DynaValidatorForm dynaForm = (DynaValidatorForm) form;
        String encryptedUserId = dynaForm.getString("u");
        String encryptedPostDate = dynaForm.getString("t");
        String menuType = dynaForm.getString("type");

        if (!validateParameter(encryptedUserId, encryptedPostDate)) {
            return null;
        }

        // 権限情報取得
        ApplicationContext ac = getWebApplicationContext();
        AuthService service = (AuthService) ac.getBean("authService");

        String userId = blowfishDecrypt(encryptedUserId);
        List<String> authList = service.getAuthorityList(userId);
        String cjnAccountType = StringUtils.defaultString(service.getCjnAccountType(userId), "0");

        //セッションを取得
        SessionBean sessionBean = SessionBeanManager.getSessionBean(request);
        String loginKey = "";
        if (sessionBean != null) {
        	loginKey = sessionBean.getLoginKey();
        }

        // JavaScriptファイルへの出力内容を作成
        SideBarContext context = setContext(authList, request.getContextPath(), encryptedUserId, cjnAccountType, loginKey);
        String menuBody = createMenuBody(context, menuType);

        // レスポンスヘッダー設定
        response.setContentType("application/x-javascript; charset=" + C_OUTPUT_ENCODING);
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Content-disposition", "attachment; filename=" + C_JS_FILE_NAME);

        // JavaScript の書き出し
        PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), C_OUTPUT_ENCODING));
        out.print(menuBody);
        out.flush();
        out.close();

        return null;
    }

    /**
     * 入力パラメータの検証を行い結果を返します。
     * @param encryptedUserId 暗号化済ユーザID
     * @param encryptedPostDate 暗号化済日付
     * @return 問題なし:true, 問題あり:false
     */
    private boolean validateParameter(String encryptedUserId, String encryptedPostDate) {

        if (StringUtils.isEmpty(encryptedUserId) || StringUtils.isEmpty(encryptedPostDate)) {
            return false;
        }

        if (StringUtils.isEmpty(blowfishDecrypt(encryptedUserId))) {
            return false;
        }

        if (isNotValidDate(blowfishDecrypt(encryptedPostDate))) {
            return false;
        }

        return true;
    }

    /**
     * サイドバー用のコンテキストを設定します。
     * @param authList 権限リスト
     * @param contextPath アプリケーションのコンテキストパス
     * @param encryptedUserId 暗号化済ユーザID
     * @param cjnAccountType CHINTAI問い合せ管理アカウントタイプ
     * @return サイドバーコンテキスト
     * @throws UnsupportedEncodingException サポートされていないエンコーディングを指定した場合にスローされます。
     */
    private SideBarContext setContext(List<String> authList, String contextPath, String encryptedUserId,
            String cjnAccountType, String loginKey) throws UnsupportedEncodingException {
        SideBarContext context = new SideBarContext();

        // コンテキスト設定
        // 暗号化が必要なものは暗号化する
        context.setAuthList(authList);
        context.setContextPath(contextPath);
        context.setEncryptedUserId(URLEncoder.encode(encryptedUserId, C_OUTPUT_ENCODING));
        context.setEncryptedDate(URLEncoder.encode(blowfishEncrypt(getToday()), C_OUTPUT_ENCODING));
        context.setCjnAccountType(URLEncoder.encode(cjnAccountType, C_OUTPUT_ENCODING));
        context.setEncryptedWeblogUserFlag(URLEncoder.encode(blowfishEncrypt(C_WEBLOG_USER_FLAG), C_OUTPUT_ENCODING));
        context.setBaseUrl(URLEncoder.encode(getProperty("menu.baseUrl"), C_OUTPUT_ENCODING));
        context.setLogapUrl(getProperty("menu.logapUrl"));
        context.setWeblogUrl(ServerProperties.getProperty("weblogUrl"));
        context.setLoginKey(loginKey);

        return context;
    }

    /**
     * JavaScriptメニューのボディ部分を作成します。
     * @param context サイドバーコンテキスト
     * @param menuType メニュータイプ
     * @return メニューボディ文字列
     */
    private String createMenuBody(SideBarContext context, String menuType) {
        ApplicationContext ac = getWebApplicationContext();
        VelocityMerger merger = (VelocityMerger) ac.getBean("velocityMerger");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ctx", context);

        // メニュー選択
        // type = 1 のとき統合用メニュー、それ以外のとき広告用メニュー
        if (menuType.equals("1")) {
            return merger.mergeTemplateMenuForTogo(map);
        } else {
            return merger.mergeTemplateMenuForAd(map);
        }
    }

}

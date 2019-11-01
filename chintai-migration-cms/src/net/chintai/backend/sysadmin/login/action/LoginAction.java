/*
 * $Id: LoginAction.java 3977 2008-06-25 10:52:14Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/06/15   BGT)児島      新規作成
 * 2007/08/08   BGT)児島      グループIDをセットする処理を削除
 * 2007/09/14   BGT)児島      ログイン失敗時のエラーID通知方法を修正
 */
package net.chintai.backend.sysadmin.login.action;

import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.session.SessionBean;
import net.chintai.backend.sysadmin.common.session.SessionBeanManager;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.login.service.LoginService;
import net.chintai.backend.sysadmin.login.service.MngSessionService;
import net.chintai.backend.sysadmin.login.service.bean.LoginServiceBean;
import net.chintai.backend.sysadmin.login.service.bean.MngSessionInServiceBean;
import net.chintai.backend.sysadmin.login.service.bean.MngSessionOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * ログイン実行時に呼び出されるアクションクラスです。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3977 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class LoginAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized()
     */
    @Override
    protected boolean isAuthorized(String userId) {
        return true; // ログイン処理は権限チェック不要
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm loginForm = (DynaValidatorForm) context.getForm();
        LoginServiceBean loginServiceBean = new LoginServiceBean();
        BeanUtils.copyProperties(loginServiceBean, loginForm);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        LoginService loginService = (LoginService) ac.getBean("loginService");
        MngSessionService mngSessionService = (MngSessionService) ac.getBean("mngSessionService");

        // ログイン処理
        LoginServiceBean loginBean = loginService.login(loginServiceBean);

        if (loginBean != null) {

            MngSessionInServiceBean inBean = new MngSessionInServiceBean();
            inBean.setUserId(loginBean.getUserId());
            inBean.setOperUserId(loginBean.getUserId());
            inBean.setPgName( this.getClass().getName());

            // セッションテーブルに登録
            MngSessionOutServiceBean outBean = mngSessionService.insertMngSession(inBean);

            // セッションビーンの初期化
            SessionBean sessionBean = SessionBeanManager.createSessionBean();
            sessionBean.init(loginBean.getUserId(), loginBean.getUserName(), context.getRequest().getContextPath(),
                    outBean.getSidId(),outBean.getLoginKey());

            context.setSessionBean(sessionBean);

            // 操作ログ記録
            OperationLoggingService loggingService = (OperationLoggingService) ac.getBean("operationLoggingService");
            loggingService.write("00001", loginBean.getUserId(), SessionStatus.SUCCESS, "", this.getClass().getName());

            context.setForward("success");

        } else {
            // 操作ログ記録
            OperationLoggingService loggingService = (OperationLoggingService) ac.getBean("operationLoggingService");
            String failedUserId = loginForm.getString("userId");
            String failedUserIdShort = StringUtils.mid(failedUserId, 0, 12);

            // ログインIDにマルチバイト文字が入力された際に、DB挿入エラーにならないための対策
            // ユーザIDのバイト数が 12 バイト以下になるようにする
            while (failedUserIdShort.getBytes("MS932").length > 12) {
                failedUserIdShort = failedUserIdShort.substring(0, failedUserIdShort.length() - 1);
            }

            loggingService.write("00001", failedUserIdShort, SessionStatus.FAILURE, "ログインIDの入力内容 : " + StringUtils.mid(failedUserId, 0, 400), this.getClass().getName());

            context.setError("WARN.M.LOGIN.0005", ApplicationResources.getProperty("login.idAndPassword"));
            context.setForward("failure");
        }
    }
}

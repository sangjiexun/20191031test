/*
 * LogoutAction.java
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/06/22  BGT)児島   新規作成
 *
 */
package net.chintai.backend.sysadmin.login.action;

import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.login.service.MngSessionService;

/**
 * ログアウト実行時に呼び出されるアクションクラスです。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class LogoutAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized()
     */
    @Override
    protected boolean isAuthorized(String userId) {
        return true; // ログアウト処理は権限チェック不要
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) {

        if (context.getSessionBean() != null) {
            ApplicationContext ac = getWebApplicationContext();
            MngSessionService mngSessionService = (MngSessionService) ac.getBean("mngSessionService");
            mngSessionService.deleteMngSession(context.getSessionBean().getSidId());
        }

        context.setSessionBean(null);
        context.setForward("success");
    }
}

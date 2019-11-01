/*
 * $Id: DeleteSessionAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/12   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.external.ad.action;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.SystemException;
import net.chintai.backend.sysadmin.common.service.AuthService;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;

/**
 * 広告管理サーバへのリダイレクトを行うアクション。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class DeleteSessionAction extends BaseActionSupport {

    /** ユーザIDのリクエストパラメータ名 */
    private static final String C_TO_URL = "to_url";

    /**
     * URLを生成して、広告管理サーバにリダイレクトします。<br>
     * このとき、セッションを破棄します。
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void doExecute(BusinessContext context) throws Exception {
        String toUrl = context.getRequest().getParameter(C_TO_URL);

        if (StringUtils.isEmpty(toUrl)) {
            throw new SystemException("FETAL.M.SYSTEM.0001");
        }

        // リダイレクト先設定
        context.setRedirect(true);
        context.setForwardUrl(toUrl);

        // リクエストパラメータ設定(TO_URLは除く)
        Map<String, String[]> paramMap = context.getRequest().getParameterMap();
        Map<String, String> newParamMap = new HashMap<String, String>();

        if (paramMap != null) {
            for (Entry<String, String[]> entry : paramMap.entrySet()) {
                if (!StringUtils.equals(entry.getKey(), C_TO_URL)) {
                    newParamMap.put(entry.getKey(), entry.getValue()[0]);
                }
            }
        }
        context.setForwardParameterMap(newParamMap);

        // セッション破棄
        context.removeSessionBean();
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.AD);
    }
}

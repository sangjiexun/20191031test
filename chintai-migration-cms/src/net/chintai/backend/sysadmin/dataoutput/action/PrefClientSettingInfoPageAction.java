/*
 * $Id: PrefClientSettingInfoPageAction.java 4737 2013-11-05 08:38:02Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/23     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.action;

import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;


/**
 * 都道府県別データ元出力設定画面初期表示Action
 * @author KAMEDA Takuma
 * @version $Revision: 4737 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefClientSettingInfoPageAction extends BaseActionSupport {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.DATA_OUTPUT);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {
        context.setForward("success");
        }

}

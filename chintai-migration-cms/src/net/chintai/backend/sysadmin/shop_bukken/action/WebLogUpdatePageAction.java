/*
 * $Id: WebLogUpdatePageAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.WebLogUpdateView;
import net.chintai.backend.sysadmin.shop_bukken.service.WebLogUpdatePageService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.WebLogUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.WebLogUpdatePageOutServiceBean;

/**
 * Webログ利用可否画面に遷移アクション
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class WebLogUpdatePageAction extends BaseActionSupport {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm)context.getForm();
        WebLogUpdatePageInServiceBean inServiceBean =
            new WebLogUpdatePageInServiceBean();

        // 取得したデータをinServiceBeanに設定
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        WebLogUpdatePageService webLogUpdatePageService =
            (WebLogUpdatePageService)ac.getBean("WebLogUpdatePageService");

        // Webログ利用可否画面に遷移Serviceを行う
        WebLogUpdatePageOutServiceBean rs =
            webLogUpdatePageService.webLogUpdatePage(inServiceBean);

        // 取得したWebログ利用可否の情報をViewHelperに設定
        WebLogUpdateView view = new WebLogUpdateView();
        BeanUtils.copyProperties(view, rs);

        context.setForward("success", view);
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }
}
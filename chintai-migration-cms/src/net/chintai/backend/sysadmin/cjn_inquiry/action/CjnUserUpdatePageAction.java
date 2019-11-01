/*
 * $Id: CjnUserUpdatePageAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者          内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)楊恩美      新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnUserInfoView;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserUpdatePageService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserUpdatePageOutServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.DynaActionForm;
import org.springframework.context.ApplicationContext;

/**
 * 問い合せユーザ更新ページ表示アクション。
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserUpdatePageAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データをBeanにセット
        DynaActionForm form = (DynaActionForm) context.getForm();
        CjnUserUpdatePageInServiceBean inServiceBean = new CjnUserUpdatePageInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        CjnUserUpdatePageService service =
                (CjnUserUpdatePageService) ac.getBean("cjnUserUpdatePageService");

        // viewにセット
        CjnUserUpdatePageOutServiceBean outServiceBean = service.selectUpdateCjnUser(inServiceBean);
        CjnUserInfoView view = new CjnUserInfoView();
        BeanUtils.copyProperties(view, outServiceBean);

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
        return auth.authenticate(userId, AuthorityId.CJN_INQUIRY) && auth.isAdminCjnAccountType(userId);
    }

}

/*
 * $Id: UserPasswordChangePageAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)金東珍     新規作成
 * 2007/09/28  BGT)児島       フォーマッター適用
 */
package net.chintai.backend.sysadmin.user.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.user.action.view.UserPasswordChangePageView;
import net.chintai.backend.sysadmin.user.service.UserPasswordChangePageService;
import net.chintai.backend.sysadmin.user.service.bean.UserPasswordChangePageInServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.UserPasswordChangePageOutServiceBean;

/**
 * ユーザパスワード画面に遷移するアクション。
 * 
 * @author Kim Dong Jin
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserPasswordChangePageAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        DynaValidatorForm form = (DynaValidatorForm)context.getForm();
        UserPasswordChangePageInServiceBean inServiceBean =
            new UserPasswordChangePageInServiceBean();

        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        UserPasswordChangePageService userPasswordChangePageService =
            (UserPasswordChangePageService)ac.getBean("UserPasswordChangePageService");

        try {

            // 更新日時取得Serviceを行う
            UserPasswordChangePageOutServiceBean rs =
                userPasswordChangePageService.userPasswordChangePage(inServiceBean);

            UserPasswordChangePageView view = new UserPasswordChangePageView();

            // 取得した更新日時をViewHelperに設定
            BeanUtils.copyProperties(view, rs);

            // 選択したユーザIDをViewHelperに設定
            BeanUtils.copyProperties(view, form);

            // 二重更新防止トークンをセット
            saveToken(context.getRequest());
            context.setForward("success", view);

        } catch (ApplicationException ae) {

            context.setError("ERROR.M.USER.0006");
            context.setForward("fail");

        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        // 権限チェック
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.USER);
    }
}
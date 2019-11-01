/*
 * $Id: UserAddConfirmAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/20  BGT)金東珍     新規作成
 * 2007/09/28  BGT)児島       フォーマッター適用
 */
package net.chintai.backend.sysadmin.user.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.user.action.view.UserAddView;
import net.chintai.backend.sysadmin.user.service.GroupNameService;
import net.chintai.backend.sysadmin.user.service.UserAddConfirmService;
import net.chintai.backend.sysadmin.user.service.bean.GroupNameInServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.UserAddConfirmInServiceBean;

/**
 * ユーザ登録確認を行うアクション。
 * 
 * @author Kim Dong Jin
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserAddConfirmAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {
        
        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        UserAddConfirmInServiceBean userAddConfirmInServiceBean =
            new UserAddConfirmInServiceBean();
        BeanUtils.copyProperties(userAddConfirmInServiceBean, form);
        UserAddView view = new UserAddView();
        BeanUtils.copyProperties(view, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        UserAddConfirmService service =
            (UserAddConfirmService) ac.getBean("UserAddConfirmService");

        // ユーザID存在有無判断
        int rs = service.userAddConfirm(userAddConfirmInServiceBean);
        
        // ユーザがある場合
        if (rs != 0) {
            context.setError("WARN.M.USER.0012");
            context.setForward("fail", view);
        } else {
            GroupNameInServiceBean groupInServiceBean = new GroupNameInServiceBean();
            BeanUtils.copyProperties(groupInServiceBean, form);
            GroupNameService groupNameService =
                (GroupNameService) ac.getBean("GroupNameService");
            view.setGroupName(groupNameService.getGroupName(groupInServiceBean));

            // 二重更新防止トークンをセット
            saveToken(context.getRequest());
            context.setForward("success", view);
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
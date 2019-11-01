/*
 * $Id: UserDeleteConfirmAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)金東珍     新規作成
 * 2007/09/28  BGT)児島       フォーマッター適用
 */
package net.chintai.backend.sysadmin.user.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.user.action.view.UserDeleteView;
import net.chintai.backend.sysadmin.user.service.UserDeleteConfirmService;
import net.chintai.backend.sysadmin.user.service.bean.UserDeleteConfirmInServiceBean;

/**
 * ユーザ削除リスト取得アクション。
 * 
 * @author Kim Dong Jin
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserDeleteConfirmAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        UserDeleteConfirmInServiceBean inServiceBean = new UserDeleteConfirmInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        UserDeleteConfirmService userDeleteConfirmService =
                (UserDeleteConfirmService) ac.getBean("UserDeleteConfirmService");

        try {

            // 削除チェックされたリンク先の詳細を取得
            List rsList = userDeleteConfirmService.userDeleteConfirm(inServiceBean);

            UserDeleteView view = new UserDeleteView();

            List<UserDeleteView.UserDeleteDetailView> userDeleteList =
                    new ArrayList<UserDeleteView.UserDeleteDetailView>();

            for (int i = 0; i < rsList.size(); i++) {
                UserDeleteView.UserDeleteDetailView detailView = view.new UserDeleteDetailView();
                BeanUtils.copyProperties(detailView, rsList.get(i));
                userDeleteList.add(detailView);
            }
            view.setUserDeleteList(userDeleteList);

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
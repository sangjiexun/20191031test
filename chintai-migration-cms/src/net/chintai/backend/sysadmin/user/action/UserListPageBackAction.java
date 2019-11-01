/*
 * $Id: UserListPageBackAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/20  BGT)金東珍     新規作成
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
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.user.action.view.UserListView;
import net.chintai.backend.sysadmin.user.service.UserListService;
import net.chintai.backend.sysadmin.user.service.bean.UserListOutServiceBean;

/**
 * ユーザリスト画面に戻るアクション。
 * 
 * @author Kim Dong Jin
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserListPageBackAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        String[] userCheckId = (String[]) form.get("userCheckId");

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        UserListService userListService = (UserListService) ac.getBean("UserListService");

        // ユーザリスト作業を行う
        List rslist = userListService.userList();

        // 自身のＩＤを取得
        String userId = context.getSessionBean().getUserId();

        List<UserListView.UserListDetailView> userList =
                new ArrayList<UserListView.UserListDetailView>();

        UserListView view = new UserListView();

        for (int i = 0; i < rslist.size(); i++) {
            UserListOutServiceBean outServiceBean = (UserListOutServiceBean) rslist.get(i);
            UserListView.UserListDetailView userDetail = view.new UserListDetailView();
            BeanUtils.copyProperties(userDetail, outServiceBean);
            if (outServiceBean.getUserId().equals(userId) || outServiceBean.getGroupId().equals("0")) {
                userDetail.setDisabled("disabled");
            }
            // チェックボックス状態復元
            for (int j = 0; j < userCheckId.length; j++) {
                if (userCheckId[j].equals(userDetail.getUserId())) {
                    userDetail.setCheck("checked");
                }
            }

            userList.add(userDetail);
        }

        // ViewHelper設定
        view.setUserList(userList);

        context.setForward("success", view);
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
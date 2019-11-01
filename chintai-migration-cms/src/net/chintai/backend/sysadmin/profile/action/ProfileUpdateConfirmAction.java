/*
 * $Id: ProfileUpdateConfirmAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.action;

import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.profile.action.view.ProfileUpdateView;
import net.chintai.backend.sysadmin.user.service.GroupNameService;
import net.chintai.backend.sysadmin.user.service.bean.GroupNameInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 *  プロフィール更新確認アクション。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfileUpdateConfirmAction extends BaseActionSupport {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        GroupNameInServiceBean inServiceBean = new GroupNameInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        GroupNameService groupNameService = (GroupNameService) ac.getBean("GroupNameService");

        // 取得したデータをViewHelperに設定
        ProfileUpdateView view = new ProfileUpdateView();
        BeanUtils.copyProperties(view, form);

        view.setGroupName(groupNameService.getGroupName(inServiceBean));

        // 二重更新防止トークンをセット
        saveToken(context.getRequest());
        context.setForward("success", view);
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        return true; // 共通メニューのため権限チェック不要
    }
}
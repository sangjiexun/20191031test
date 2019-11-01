/*
 * $Id: ProfileUpdatePageAction.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.profile.service.ProfileUpdatePageService;
import net.chintai.backend.sysadmin.profile.service.bean.ProfileUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.profile.service.bean.ProfileUpdatePageOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

/**
 * プロフィール更新画面に遷移
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfileUpdatePageAction extends BaseActionSupport {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        ProfileUpdatePageInServiceBean inServiceBean =
            new ProfileUpdatePageInServiceBean();

        // ログインしたユーザＩＤをBeanから取得してProfileInfoInServiceBeanに設定
        inServiceBean.setUserId(context.getSessionBean().getUserId());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ProfileUpdatePageService profileUpdatePageService =
            (ProfileUpdatePageService)ac.getBean("ProfileUpdatePageService");
        
        // ユーザ詳細情報Serviceを行う
        ProfileUpdatePageOutServiceBean rs =
            profileUpdatePageService.profileUpdatePage(inServiceBean);
        
        // ユーザ詳細情報をViewHelperに設定
        ProfileUpdateView view = new ProfileUpdateView();
        BeanUtils.copyProperties(view, rs);

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
/*
 * $Id: ProfilePasswordChangePageAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.action;

import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.profile.action.view.ProfilePasswordChangePageView;
import net.chintai.backend.sysadmin.profile.service.ProfilePasswordChangePageService;
import net.chintai.backend.sysadmin.profile.service.bean.ProfilePasswordChangePageInServiceBean;
import net.chintai.backend.sysadmin.profile.service.bean.ProfilePasswordChangePageOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

/**
 * プロフィールパスワード変更画面に遷移アクション。
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfilePasswordChangePageAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        ProfilePasswordChangePageInServiceBean inServiceBean = new ProfilePasswordChangePageInServiceBean();

        // ログインしたユーザＩＤをBeanから取得してProfileInfoInServiceBeanに設定
        inServiceBean.setUserId(context.getSessionBean().getUserId());

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        ProfilePasswordChangePageService profilePasswordChangePageService =
                (ProfilePasswordChangePageService) ac.getBean("ProfilePasswordChangePageService");

        // 更新日時取得Serviceを行う
        ProfilePasswordChangePageOutServiceBean rs =
                profilePasswordChangePageService.profilePasswordChangePage(inServiceBean);

        // 更新日時取得をViewHelperに設定
        ProfilePasswordChangePageView view = new ProfilePasswordChangePageView();
        BeanUtils.copyProperties(view, rs);

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
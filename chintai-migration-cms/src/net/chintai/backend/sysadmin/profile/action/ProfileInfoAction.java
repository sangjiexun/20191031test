/*
 * $Id: ProfileInfoAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.action;

import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.profile.action.view.ProfileInfoView;
import net.chintai.backend.sysadmin.profile.service.ProfileInfoService;
import net.chintai.backend.sysadmin.profile.service.bean.ProfileInfoInServiceBean;
import net.chintai.backend.sysadmin.profile.service.bean.ProfileInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

/**
 * プロフィール詳細
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfileInfoAction extends BaseActionSupport {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        ProfileInfoInServiceBean inServiceBean = new ProfileInfoInServiceBean();

        // ログインしたユーザＩＤをBeanから取得してProfileInfoInServiceBeanに設定
        inServiceBean.setUserId(context.getSessionBean().getUserId());
        
        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ProfileInfoService profileInfoService = (ProfileInfoService)ac.getBean("ProfileInfoService");

        // ユーザ詳細情報Serviceを行う
        ProfileInfoOutServiceBean rs = profileInfoService.profileInfo(inServiceBean);

        // ユーザ詳細情報をViewHelperに設定
        ProfileInfoView view = new ProfileInfoView();
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
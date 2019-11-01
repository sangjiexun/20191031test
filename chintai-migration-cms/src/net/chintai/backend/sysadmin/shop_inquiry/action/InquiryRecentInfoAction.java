/*
 * $Id: InquiryRecentInfoAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_inquiry.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_inquiry.action.view.InquiryRecentInfoView;
import net.chintai.backend.sysadmin.shop_inquiry.service.InquiryRecentInfoService;
import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryRecentInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryRecentInfoOutServiceBean;

/**
 * 問い合せ履歴詳細アクション。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryRecentInfoAction extends BaseActionSupport {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        InquiryRecentInfoInServiceBean inServiceBean =
            new InquiryRecentInfoInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        InquiryRecentInfoService inquiryRecentInfoService =
            (InquiryRecentInfoService)ac.getBean("InquiryRecentInfoService");

        // 問い合せ履歴詳細Serviceを行う
        InquiryRecentInfoOutServiceBean rs =
            inquiryRecentInfoService.inquiryRecentInfo(inServiceBean);

        // 問い合せ履歴詳細情報をViewHelperに設定
        InquiryRecentInfoView view = new InquiryRecentInfoView();
        BeanUtils.copyProperties(view, rs);

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
        return auth.authenticate(userId, AuthorityId.SHOP_INQUIRY);
    }
}

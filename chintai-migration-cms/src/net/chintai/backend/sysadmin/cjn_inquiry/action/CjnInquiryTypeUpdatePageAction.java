/*
 * $Id: CjnInquiryTypeUpdatePageAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26   BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnInquiryTypeUpdateView;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeUpdatePageService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeUpdatePageOutServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 問い合せ種別の更新画面を表示するアクション。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeUpdatePageAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        CjnInquiryTypeUpdatePageInServiceBean inBean = new CjnInquiryTypeUpdatePageInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        CjnInquiryTypeUpdatePageService service =
                (CjnInquiryTypeUpdatePageService) ac.getBean("cjnInquiryTypeUpdatePageService");

        // 更新画面の情報を取得
        CjnInquiryTypeUpdatePageOutServiceBean outBean = service.selectTypeUpdatePage(inBean);

        // ViewHelper にセット
        CjnInquiryTypeUpdateView view = new CjnInquiryTypeUpdateView();
        BeanUtils.copyProperties(view, outBean);

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

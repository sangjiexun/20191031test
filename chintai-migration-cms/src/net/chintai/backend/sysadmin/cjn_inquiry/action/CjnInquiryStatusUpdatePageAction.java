/*
 * $Id: CjnInquiryStatusUpdatePageAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnInquiryStatusUpdateView;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryAccessControlService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryStatusUpdatePageService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryStatusUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryStatusUpdatePageOutServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 問い合せ処理状況更新ページ表示アクション
 *
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryStatusUpdatePageAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 検索条件取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        CjnInquiryStatusUpdatePageInServiceBean inServiceBean =
                new CjnInquiryStatusUpdatePageInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // アクセス権限チェック
        CjnInquiryAccessControlService acl =
                (CjnInquiryAccessControlService) ac.getBean("cjnInquiryAccessControlService");
        if (!acl.isAccessibleForInqId(context.getSessionBean().getUserId(), inServiceBean
                .getCjnInqId())) {
            throw new ApplicationException("ERROR.M.APP.0003");
        }

        // 問い合せ詳細情報取得
        CjnInquiryStatusUpdatePageService service =
                (CjnInquiryStatusUpdatePageService) ac.getBean("cjnInquiryStatusUpdatePageService");
        CjnInquiryStatusUpdatePageOutServiceBean outServiceBean =
                service.selectCjnInquiryStatusUpdate(inServiceBean);

        // ViewHelperにセット
        CjnInquiryStatusUpdateView view = new CjnInquiryStatusUpdateView();
        BeanUtils.copyProperties(view, outServiceBean);
/*
        // 問い合せ内容結合
        String inqContents =
                view.getInqContents1() + view.getInqContents2() + view.getInqContents3()
                        + view.getInqContents4() + view.getInqContents5() + view.getInqContents6()
                        + view.getInqContents7() + view.getInqContents8() + view.getInqContents9()
                        + view.getInqContents10();

        view.setInqContents(inqContents);
*/
        view.setCjnInqKindSeq((Integer) form.get("cjnInqKindSeq"));
        view.setOffSet((Integer) form.get("offSet"));

        context.setForward("success", view);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.CJN_INQUIRY);
    }

}

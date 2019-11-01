/*
 * $Id: CjnInquiryInfoAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/29   BGT)児島      新規作成
 * 2007/10/17   BGT)児島      リファクタリング
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnInquiryInfoView;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryAccessControlService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryInfoReadingLoggingService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryInfoService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryInfoInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryInfoOutServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 問い合せ詳細アクション
 *
 * @author KOJIMA Takanori
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryInfoAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 検索条件取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        CjnInquiryInfoInServiceBean inServiceBean = new CjnInquiryInfoInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // ユーザID取得
        String userId = context.getSessionBean().getUserId();
        inServiceBean.setUserId(userId);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // アクセス権限チェック
        CjnInquiryAccessControlService acl =
                (CjnInquiryAccessControlService) ac.getBean("cjnInquiryAccessControlService");
        if (!acl.isAccessibleForInqId(userId, inServiceBean.getCjnInqId())) {
            throw new ApplicationException("ERROR.M.APP.0003");
        }

        // 問い合せ詳細情報取得
        CjnInquiryInfoService service = (CjnInquiryInfoService) ac.getBean("cjnInquiryInfoService");
        CjnInquiryInfoOutServiceBean outBean = service.cjnInquiryInfo(inServiceBean);

        // 問い合せ詳細情報閲覧時のログ記録
        // logFlg(問い合せ一覧から詳細画面に：１ログ記録、その以外はログ記録しない)
        if (inServiceBean.getLogFlg().equals("1")) {
        	//CJN_SESSION_HISTORY に登録は廃止。MNG_SESSION_HISTORYに登録するように変更。
        	/*
            CjnInquiryInfoReadingLoggingService readingloggingService =
                    (CjnInquiryInfoReadingLoggingService) ac
                            .getBean("cjnInquiryInfoReadingLoggingService");
            readingloggingService.write(inServiceBean);
            */
        	// 操作ログ記録
            OperationLoggingService loggingService =
                    (OperationLoggingService) ac.getBean("operationLoggingService");

            // 操作ログ記録成功場合
            loggingService.write("07007", context.getSessionBean().getUserId(),
                    SessionStatus.SUCCESS, ApplicationResources.getProperty("user.userId")
                    + inServiceBean.getUserId(), this.getClass().getName());
        }

        // viewHelperにセット
        CjnInquiryInfoView view = new CjnInquiryInfoView();
        BeanUtils.copyProperties(view, outBean);
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
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.CJN_INQUIRY);
    }
}

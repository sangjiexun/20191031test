/*
 * $Id: CjnInquiryTypeInfoAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26   BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnInquiryTypeInfoView;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeInfoService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeInfoInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeInfoOutServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeInfoUsersOutServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 問い合せ詳細情報を表示するアクション。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeInfoAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データを Bean にセット
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        CjnInquiryTypeInfoInServiceBean inBean = new CjnInquiryTypeInfoInServiceBean();
        inBean.setCjnInqKindSeq((Integer) form.get("cjnInqKindSeq"));

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // 問い合せ詳細情報取得
        CjnInquiryTypeInfoService typeInfoService = (CjnInquiryTypeInfoService) ac.getBean("cjnInquiryTypeInfoService");
        CjnInquiryTypeInfoOutServiceBean typeInfoBean = typeInfoService.selectTypeInfo(inBean);

        // 閲覧可否付きユーザ一覧取得
        List<CjnInquiryTypeInfoUsersOutServiceBean> typeInfoUsersList = typeInfoService.selectTypeInfoUsers(inBean);

        // ViewHelper にセット
        CjnInquiryTypeInfoView view = new CjnInquiryTypeInfoView();
        List<CjnInquiryTypeInfoView.CjnInquiryTypeInfoDetailView> viewList =
                new ArrayList<CjnInquiryTypeInfoView.CjnInquiryTypeInfoDetailView>();

        if (typeInfoUsersList != null) {
            for (int i = 0; i < typeInfoUsersList.size(); i++) {
                CjnInquiryTypeInfoView.CjnInquiryTypeInfoDetailView viewDetail =
                        view.new CjnInquiryTypeInfoDetailView();

                viewDetail.setUserName(typeInfoUsersList.get(i).getUserName());
                viewDetail.setExists(typeInfoUsersList.get(i).getExists());
                viewList.add(viewDetail);
            }
            view.setReadableUserList(viewList);
        }
        BeanUtils.copyProperties(view, typeInfoBean);

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

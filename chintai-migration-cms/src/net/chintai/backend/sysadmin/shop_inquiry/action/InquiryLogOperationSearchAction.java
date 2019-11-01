/*
 * $Id: InquiryLogOperationSearchAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/12  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_inquiry.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.shop_inquiry.action.view.InquiryLogOperationListView;
import net.chintai.backend.sysadmin.shop_inquiry.service.InquiryLogOperationSearchService;
import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryLogOperationSearchInServiceBean;

/**
 * システム操作履歴検索アクション
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryLogOperationSearchAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // システム操作履歴検索条件取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        InquiryLogOperationSearchInServiceBean inServiceBean = new InquiryLogOperationSearchInServiceBean();

        // 検索条件をServiceBeanに設定
        BeanUtils.copyProperties(inServiceBean, form);

        // 検索条件をセッションに保存
        context.getSessionBean().getSearchConditionMap().put(SessionSearchKey.SHOP_INQUIRY_LOGOPERATION, inServiceBean);

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.valueOf(SystemProperties.getProperty("C_SHOP_INQUIRY_SEARCH_DISPLAY_LIMIT")));
        condition.setOffset(inServiceBean.getOffSet());

        // Injection(システム操作履歴検索リスト)
        ApplicationContext ac = getWebApplicationContext();
        InquiryLogOperationSearchService logOperationService =
                (InquiryLogOperationSearchService) ac.getBean("InquiryLogOperationSearchService");

        // システム操作履歴検索結果リスト取得
        List rsList = logOperationService.inquiryLogOperationSearch(inServiceBean, condition);

        List<InquiryLogOperationListView.InquiryLogOperationListDetailView> inquiryLogOperationList =
                new ArrayList<InquiryLogOperationListView.InquiryLogOperationListDetailView>();

        
        InquiryLogOperationListView view = new InquiryLogOperationListView(condition);

        // 画面に表示する検索条件をセット
        BeanUtils.copyProperties(view, inServiceBean);
        
        if (rsList.size() == 0) {
            context.setError("WARN.M.CJN_INQUIRY.0035");
            context.setForward("success", view);
            return;
        }

        // 検索結果をViewHelperに設定
        for (int i = 0; i < rsList.size(); i++) {
            InquiryLogOperationListView.InquiryLogOperationListDetailView viewDetail =
                    view.new InquiryLogOperationListDetailView();
            BeanUtils.copyProperties(viewDetail, rsList.get(i));

            inquiryLogOperationList.add(viewDetail);
        }
        view.setInquiryLogOperationList(inquiryLogOperationList);

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
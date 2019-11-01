/*
 * $Id: InquiryRecentSearchPagingAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/01  BGT)児島       新規作成
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
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.shop_inquiry.action.view.InquiryRecentListView;
import net.chintai.backend.sysadmin.shop_inquiry.service.InquiryRecentSearchService;
import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryRecentSearchInServiceBean;

/**
 * 問い合せ情報検索アクション(ページング用)
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryRecentSearchPagingAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // セッションから検索条件取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        InquiryRecentSearchInServiceBean inServiceBean =
                (InquiryRecentSearchInServiceBean) context.getSessionBean().getSearchConditionMap().get(
                        SessionSearchKey.SHOP_INQUIRY_RECENT);

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(inServiceBean.getCnt());
        condition.setOffset(((Integer) form.get("offSet")).intValue());

        // Injection(問い合せ情報検索リスト)
        ApplicationContext ac = getWebApplicationContext();
        InquiryRecentSearchService inquiryRecentSearchService =
                (InquiryRecentSearchService) ac.getBean("InquiryRecentSearchService");

        // 問い合せ情報検結果リストを取得
        List rsList = inquiryRecentSearchService.inquiryRecentSearch(inServiceBean, condition);

        List<InquiryRecentListView.InquiryRecentListDetailView> inquiryList =
                new ArrayList<InquiryRecentListView.InquiryRecentListDetailView>();

        // ViewHelperにセット
        InquiryRecentListView view = new InquiryRecentListView(condition);

        // 検索条件をViewHelperに設定
        BeanUtils.copyProperties(view, inServiceBean);
        
        // 検索結果件数が0件の場合
        if (rsList.size() == 0) {
            // メッセージ設定
            context.setError("WARN.M.CJN_INQUIRY.0034");
        }

        // 検索結果をViewHelperに設定
        for (int i = 0; i < rsList.size(); i++) {
            InquiryRecentListView.InquiryRecentListDetailView inquiryDetail = view.new InquiryRecentListDetailView();
            BeanUtils.copyProperties(inquiryDetail, rsList.get(i));
            inquiryList.add(inquiryDetail);
        }
        view.setInquiryList(inquiryList);

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
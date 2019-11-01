/*
 * $Id: CjnInquirySearchPagingAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/12/01   BGT)児島      新規作成
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnInquirySearchListView;
import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnInquirySearchListView.CjnInquirySearchListDetailView;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryAccessControlService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquirySearchDisposeCountService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquirySearchService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquirySearchDisposeCountOutServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquirySearchDisposeCountPageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquirySearchInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquirySearchOutServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 問い合せ検索アクション(ページング用)
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquirySearchPagingAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // セッションから検索条件を取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        CjnInquirySearchInServiceBean inServiceBean =
                (CjnInquirySearchInServiceBean) context.getSessionBean().getSearchConditionMap().get(
                        SessionSearchKey.CJN_INQUIRY_SEARCH);
        inServiceBean.setOffSet((Integer) form.get("offSet"));

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(inServiceBean.getDisplayNum());
        condition.setOffset(inServiceBean.getOffSet());

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // アクセス権限チェック
        CjnInquiryAccessControlService acl =
                (CjnInquiryAccessControlService) ac.getBean("cjnInquiryAccessControlService");
        if (!acl.isAccessibleForKindSeq(context.getSessionBean().getUserId(), inServiceBean.getCjnInqKindSeq())) {
            throw new ApplicationException("ERROR.M.APP.0003");
        }

        // 問い合せ閲覧権限取得
        String userId = context.getSessionBean().getUserId();
        inServiceBean.setUserId(userId);

        // 問い合せ件数取得サービス
        CjnInquirySearchDisposeCountService disposeCountService =
                (CjnInquirySearchDisposeCountService) ac.getBean("cjnInquirySearchDisposeCountService");

        CjnInquirySearchDisposeCountPageInServiceBean countBean = new CjnInquirySearchDisposeCountPageInServiceBean();
        countBean.setCjnInqKindSeq(inServiceBean.getCjnInqKindSeq());

        // ViewHelperにセット
        CjnInquirySearchDisposeCountOutServiceBean outServiceBean =
                disposeCountService.selectDisposeCountList(countBean);

        // 問い合せ検索Service
        CjnInquirySearchService searchService = (CjnInquirySearchService) ac.getBean("cjnInquirySearchService");

        // 問い合せ検索結果リスト取得
        List<CjnInquirySearchOutServiceBean> cjnList = searchService.cjnInquirySearch(inServiceBean, condition);

        // ViewHelperにセット
        List<CjnInquirySearchListDetailView> viewList = new ArrayList<CjnInquirySearchListDetailView>();
        CjnInquirySearchListView view = new CjnInquirySearchListView(condition);

        // 検索条件をViewHelperに設定
        BeanUtils.copyProperties(view, inServiceBean);

        // 件数をViewにセット
        view.setNoReadCount(outServiceBean.getNoReadCount());
        view.setNoShoriCount(outServiceBean.getNoShoriCount());
        view.setTotalCount(outServiceBean.getTotalCount());

        if (cjnList.size() > 0) {
            for (int i = 0; i < cjnList.size(); i++) {

                // 問い合せ検索結果リストの情報をインナークラスに設定する
                CjnInquirySearchListDetailView viewDetail = view.new CjnInquirySearchListDetailView();
                BeanUtils.copyProperties(viewDetail, cjnList.get(i));
                viewDetail.setOffSet(inServiceBean.getOffSet());
                viewList.add(viewDetail);
            }
        } else {
            context.setError("WARN.M.CJN_INQUIRY.0036");
        }

        view.setInquirySearchList(viewList);
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

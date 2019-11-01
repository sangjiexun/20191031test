/*
 * $Id: CjnLogOperationSearchAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/01  BGT)沈鍾沿     新規作成
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnLogOperationSearchView;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnLogOperationSearchService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnLogOperationSearchInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnLogOperationSearchOutServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * システム操作履歴を検索するアクション。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnLogOperationSearchAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        CjnLogOperationSearchInServiceBean inServiceBean = new CjnLogOperationSearchInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // セッションに検索条件を格納
        context.getSessionBean().getSearchConditionMap().put(SessionSearchKey.CJN_LOGOPERATION, inServiceBean);

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.valueOf(SystemProperties.getProperty("C_CJN_INQUIRY_SEARCH_DISPLAY_LIMIT")));
        condition.setOffset(inServiceBean.getOffSet());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        CjnLogOperationSearchService cjnLogOperationService =
                (CjnLogOperationSearchService) ac.getBean("cjnLogOperationSearchService");

        // システム操作履歴のリスト取得
        List rsLogList = cjnLogOperationService.getCjnLogList(inServiceBean, condition);

        // グループ一覧のviewHelper設定
        List<CjnLogOperationSearchView.CjnInquiryTypeListDetailView> cjnLogOperationList =
                new ArrayList<CjnLogOperationSearchView.CjnInquiryTypeListDetailView>();
        CjnLogOperationSearchView cjnLogOperationInfo = new CjnLogOperationSearchView(condition);

        CjnLogOperationSearchView view = new CjnLogOperationSearchView(condition);

        // 検索条件をViewに設定
        BeanUtils.copyProperties(view, inServiceBean);

        if (rsLogList == null || rsLogList.size() == 0) {
            context.setError("WARN.M.CJN_INQUIRY.0037");
        } else {
            for (int i = 0; i < rsLogList.size(); i++) {
                CjnLogOperationSearchOutServiceBean nlsLog = (CjnLogOperationSearchOutServiceBean) rsLogList.get(i);

                // リスト項目はinnerClassで処理
                CjnLogOperationSearchView.CjnInquiryTypeListDetailView cjnLogOperationDetail =
                        cjnLogOperationInfo.new CjnInquiryTypeListDetailView();
                BeanUtils.copyProperties(cjnLogOperationDetail, nlsLog);

                cjnLogOperationList.add(cjnLogOperationDetail);
            }

            // 検索結果をViewに設定
            view.setCjnLogOperationList(cjnLogOperationList);
        }

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

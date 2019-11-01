/*
 * $Id: LogOperationSearchPagingAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/01  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.user.action;

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
import net.chintai.backend.sysadmin.user.action.view.LogOperationListView;
import net.chintai.backend.sysadmin.user.service.LogOperationSearchService;
import net.chintai.backend.sysadmin.user.service.bean.LogOperationSearchInServiceBean;

/**
 * 操作ログ検索アクション(ページング用)。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class LogOperationSearchPagingAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // セッションから検索条件取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        LogOperationSearchInServiceBean inServiceBean =
                (LogOperationSearchInServiceBean) context.getSessionBean().getSearchConditionMap().get(
                        SessionSearchKey.USER_LOGOPERATION);
        inServiceBean.setOffSet((Integer) form.get("offSet"));

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(inServiceBean.getDisplayNum());
        condition.setOffset(inServiceBean.getOffSet());

        // Injection(操作ログ検索リスト)
        ApplicationContext ac = getWebApplicationContext();
        LogOperationSearchService logOperationService =
                (LogOperationSearchService) ac.getBean("LogOperationSearchService");

        // 操作ログ検結果リストを取得
        List rsList = logOperationService.logOperationSearch(inServiceBean, condition);

        List<LogOperationListView.LogOperationListDetailView> logOperationList =
                new ArrayList<LogOperationListView.LogOperationListDetailView>();

        // ViewHelperにセット
        LogOperationListView view = new LogOperationListView(condition);

        // 画面に表示する検索条件をセット
        BeanUtils.copyProperties(view, inServiceBean);

        // 検索結果件数が0件の場合
        if (rsList.size() == 0) {
            // メッセージ設定
            context.setError("WARN.M.USER.0033");
        } else {
            // 検索結果をViewHelperに設定
            for (int i = 0; i < rsList.size(); i++) {
                LogOperationListView.LogOperationListDetailView logOperationDetail =
                        view.new LogOperationListDetailView();
                BeanUtils.copyProperties(logOperationDetail, rsList.get(i));
                logOperationList.add(logOperationDetail);
            }
            view.setLogOperationList(logOperationList);
        }
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
        return auth.authenticate(userId, AuthorityId.USER);
    }
}
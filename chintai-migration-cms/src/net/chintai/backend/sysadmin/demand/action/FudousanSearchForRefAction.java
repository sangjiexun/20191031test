/*
 * $Id: FudousanSearchForRefAction.java 3676 2007-12-20 04:20:42Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/27  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

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
import net.chintai.backend.sysadmin.demand.action.view.FudousanSearchView;
import net.chintai.backend.sysadmin.demand.action.view.FudousanSearchView.FudousanSearchDetailView;
import net.chintai.backend.sysadmin.demand.service.FudousanSearchService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanSearchOutServiceBean;

/**
 * 不動産会社検索(取引先新規登録画面用)
 *
 * @author lee-hosup
 * @version $Revision: 3676 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanSearchForRefAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {
        // 画面からデータを取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        FudousanSearchInServiceBean inBean = new FudousanSearchInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 検索ボタンで実行される場合セッションに検索条件を格納
        context.getSessionBean().getSearchConditionMap().put(
                SessionSearchKey.DEMAND_FUDOUSAN_SEARCH_FOR_REF, inBean);

        // injection
        ApplicationContext ac = getWebApplicationContext();
        FudousanSearchService service = (FudousanSearchService) ac.getBean("fudousanSearchService");

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.parseInt(SystemProperties
                .getProperty("C_FUDOUSAN_SEARCH_DISPLAY_LIMIT")));
        condition.setOffset(inBean.getOffSet());

        // 検索開始
        List<FudousanSearchOutServiceBean> rsList = service.getFudousanList(inBean, condition);

        // ViewHelper設定
        FudousanSearchView view = new FudousanSearchView(condition);
        if (rsList.size() > 0) {
            List<FudousanSearchDetailView> detailList = new ArrayList<FudousanSearchDetailView>();
            for (int i = 0; i < rsList.size(); i++) {
                FudousanSearchDetailView detailView = view.new FudousanSearchDetailView();
                BeanUtils.copyProperties(detailView, rsList.get(i));
                detailList.add(detailView);
            }
            view.setDetailList(detailList);
        } else {
            context.setError("WARN.M.DEMAND.0021");
        }
        // 検索条件をViewに設定
        BeanUtils.copyProperties(view, form);
        context.setForward("success", view);
        return;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }

}
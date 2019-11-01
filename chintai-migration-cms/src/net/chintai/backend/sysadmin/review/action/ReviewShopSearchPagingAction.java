/*
 * $Id: ReviewShopSearchPagingAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/01  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.action;

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
import net.chintai.backend.sysadmin.review.action.view.ReviewShopSearchView;
import net.chintai.backend.sysadmin.review.action.view.ReviewShopSearchView.ReviewShopSearchDetailView;
import net.chintai.backend.sysadmin.review.service.ReviewShopSearchService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopSearchInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopSearchOutServiceBean;

/**
 * Web審査ページングアクション
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopSearchPagingAction extends BaseActionSupport {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.REVIEW);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // セッションから検索条件を取得
        ReviewShopSearchInServiceBean inBean =
                (ReviewShopSearchInServiceBean) context.getSessionBean().getSearchConditionMap()
                        .get(SessionSearchKey.REVIEW_SHOP_SEARCH);

        // 画面からページング情報を取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        inBean.setOffSet((Integer) form.get("offSet"));

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.parseInt(inBean.getDisplayNum()));
        condition.setOffset(inBean.getOffSet());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ReviewShopSearchService service =
                (ReviewShopSearchService) ac.getBean("reviewShopSearchService");

        List<ReviewShopSearchOutServiceBean> rsList = service.getShopSearchList(inBean, condition);
        ReviewShopSearchView view = new ReviewShopSearchView(condition);

        // 検索条件コピー
        BeanUtils.copyProperties(view, inBean);

        if (rsList.size() == 0) {
            context.setError("WARN.M.REVIEW.0004");
        } else {
            List<ReviewShopSearchDetailView> detailList =
                    new ArrayList<ReviewShopSearchDetailView>();

            for (int i = 0; i < rsList.size(); i++) {
                ReviewShopSearchDetailView detailView = view.new ReviewShopSearchDetailView();
                BeanUtils.copyProperties(detailView, rsList.get(i));
                detailList.add(detailView);
            }
            view.setShopList(detailList);
        }
        context.setForward("success", view);
    }
}

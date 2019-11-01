/*
 * $Id: ReviewShopBukkenSearchAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/29  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.review.action.view.ReviewBukkenSearchView;
import net.chintai.backend.sysadmin.review.action.view.ReviewBukkenSearchView.ReviewBukkenSearchDetailView;
import net.chintai.backend.sysadmin.review.service.ReviewBukkenSearchService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenSearchInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

/**
 * 店舗検索結果の一覧表示ボタン押下時のアクション
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopBukkenSearchAction extends BaseActionSupport {

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

        // 画面データの取得
        String shopCd = context.getRequest().getParameter("shopCd");
        ReviewBukkenSearchInServiceBean inBean = new ReviewBukkenSearchInServiceBean();
        inBean.setShopCd(shopCd);
        inBean.setWarningCd01statusKbn01("1");
        inBean.setWarningCd02statusKbn01("1");
        inBean.setWarningCd03statusKbn01("1");

        // 検索ボタンで実行される場合セッションに検索条件を格納
        context.getSessionBean().getSearchConditionMap()
                .put(SessionSearchKey.REVIEW_BUKKEN_SEARCH, inBean);

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.valueOf(SystemProperties
                .getProperty("C_SHINSA_BUKKEN_SEARCH_DISPLAY_LIMIT")));
        condition.setOffset(0);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ReviewBukkenSearchService service =
                (ReviewBukkenSearchService) ac.getBean("reviewBukkenSearchService");

        List<ReviewBukkenSearchOutServiceBean> rsList =
                service.getBukkenSearchList(inBean, condition);

        // ViewHelper設定
        ReviewBukkenSearchView view = new ReviewBukkenSearchView(condition);
        List<ReviewBukkenSearchDetailView> detailList =
                new ArrayList<ReviewBukkenSearchDetailView>();
        if (rsList.size() > 0) {
            for (int i = 0; i < rsList.size(); i++) {
                ReviewBukkenSearchDetailView detailView = view.new ReviewBukkenSearchDetailView();
                BeanUtils.copyProperties(detailView, rsList.get(i));
                if (detailView.getSyokaiSyoriKbn().length() > 2) {
                    detailView.setSyokaiSyoriKbn(rsList.get(i).getSyokaiSyoriKbn()
                            + ReviewBukkenSearchAction.C_APPEND_STR);
                }
                if (detailView.getTeikiSyoriKbn().length() > 2) {
                    detailView.setTeikiSyoriKbn(rsList.get(i).getTeikiSyoriKbn()
                            + ReviewBukkenSearchAction.C_APPEND_STR);
                }
                detailList.add(detailView);
            }
        } else {
            context.setError("WARN.M.REVIEW.0014");
        }
        view.setBukkenList(detailList);

        //検索条件をViewにコピー
        view.setShopCd(inBean.getShopCd());

        context.setForward("success", view);
    }
}

/*
 * $Id: ReviewShopMediaCountPagingAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/01  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.action;

import java.util.List;

import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.review.ReviewUtils;
import net.chintai.backend.sysadmin.review.action.view.ReviewShopMediaCountView;
import net.chintai.backend.sysadmin.review.action.view.ReviewShopMediaCountView.ReviewShopMediaCountDetailView;
import net.chintai.backend.sysadmin.review.service.ReviewShopMediaCountService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopMediaCountInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopMediaCountOutServiceBean;


/**
 * 店舗別出稿状況集計のページングアクション
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopMediaCountPagingAction extends BaseActionSupport {

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

        // セッションから検索条件情報を取得
        ReviewShopMediaCountInServiceBean inBean =
            (ReviewShopMediaCountInServiceBean) context.getSessionBean().getSearchConditionMap()
                .get(SessionSearchKey.REVIEW_SHOP_MEDIA_COUNT);

        // 画面からページング情報を取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        inBean.setOffSet((Integer) form.get("offSet"));

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.valueOf
                (SystemProperties.getProperty("C_SHINSA_SHOP_MEDIA_COUNT_DISPLAY_LIMIT")));
        condition.setOffset(inBean.getOffSet());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ReviewShopMediaCountService service =
                (ReviewShopMediaCountService) ac.getBean("reviewShopMediaCountService");

        // 検索開始
        List<ReviewShopMediaCountOutServiceBean> rsList =
                service.getShopMediaCount(inBean, condition);

        // ViewHelper設定
        ReviewShopMediaCountView view = new ReviewShopMediaCountView(condition);

        if (rsList.size() == 0) {

            context.setError("WARN.M.REVIEW.0046");

        } else {

            List<ReviewShopMediaCountDetailView> shopMediaCntList
                    = ReviewShopMediaCountAction.convertData(rsList);

            view.setShopMediaCntList(shopMediaCntList);
            view.setDateList(ReviewUtils.getDateList(inBean.getSumYmdFromYear(), inBean
                    .getSumYmdFromMonth()));
        }
        // 最終集計時間設定
        view.setCntTime(service.selectCntTime().getCntTime());
        context.setForward("success", view);
    }
}

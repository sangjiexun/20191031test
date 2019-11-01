/*
 * $Id: ReviewConfigCityAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/12  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.review.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.review.action.view.ReviewConfigCityView;
import net.chintai.backend.sysadmin.review.action.view.ReviewConfigCityView.ReviewConfigCityDetailVeiw;
import net.chintai.backend.sysadmin.review.service.ReviewConfigCityService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigCityInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigCityOutServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigCityOutServiceBean.ReviewConfigCityDetailBean;

/**
 * 市区町村別比較対象設定内容表示アクション
 * @author Lee Hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewConfigCityAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.REVIEW);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        String prefCd = context.getRequest().getParameter("prefCd");

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        ReviewConfigCityService service =
                (ReviewConfigCityService) ac.getBean("reviewConfigCityService");
        ReviewConfigCityInServiceBean inBean = new ReviewConfigCityInServiceBean();
        inBean.setPrefCd(prefCd);

        // DB検索
        ReviewConfigCityOutServiceBean outBean = service.getCityConfigInfo(inBean);

        // ViewHelper設定
        ReviewConfigCityView view = new ReviewConfigCityView();
        view.setAreaName(outBean.getAreaName());

        List<ReviewConfigCityDetailVeiw> prefInfoList = new ArrayList<ReviewConfigCityDetailVeiw>();

        for (int i = 0; i < outBean.getPrefInfoList().size(); i++) {
            ReviewConfigCityDetailVeiw detailView = view.new ReviewConfigCityDetailVeiw();
            ReviewConfigCityDetailBean detailBean = outBean.getPrefInfoList().get(i);

            detailView.setCityName(detailBean.getCityName());
            if (detailBean.getCompKbn().equals("1")) {
                detailView.setMoyorieki("○");
                detailView.setShikutyoson("");
            } else if (detailBean.getCompKbn().equals("0")) {
                detailView.setMoyorieki("");
                detailView.setShikutyoson("○");
            } else {
                detailView.setMoyorieki("");
                detailView.setShikutyoson("");
            }

            prefInfoList.add(detailView);
        }
        view.setPrefInfoList(prefInfoList);
        context.setForward("success", view);
    }

}

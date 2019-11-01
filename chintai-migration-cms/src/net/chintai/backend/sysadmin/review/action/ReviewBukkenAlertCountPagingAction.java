/*
 * $Id: ReviewBukkenAlertCountPagingAction.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.review.action.view.ReviewBukkenAlertCountView;
import net.chintai.backend.sysadmin.review.action.view.ReviewBukkenAlertCountView.ReviewBukkenAlertCountDetailView;
import net.chintai.backend.sysadmin.review.service.ReviewBukkenAlertCountService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenAlertCountInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenAlertCountOutServiceBean;

/**
 * 警告対象物件集計機能のページングアクション
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenAlertCountPagingAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.REVIEW);
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // セッションから検索条件を取得
        ReviewBukkenAlertCountInServiceBean inBean =
                (ReviewBukkenAlertCountInServiceBean) context.getSessionBean()
                        .getSearchConditionMap().get(SessionSearchKey.REVIEW_BUKKEN_ALERT_COUNT);

        // 画面からページング情報を取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        inBean.setOffSet((Integer) form.get("offSet"));

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.valueOf(
                SystemProperties.getProperty("C_SHINSA_BUKKEN_ALERT_COUNT_DISPLAY_LIMIT")));
        condition.setOffset(inBean.getOffSet());

//      Injection
        ApplicationContext ac = getWebApplicationContext();
        ReviewBukkenAlertCountService service =
                (ReviewBukkenAlertCountService) ac.getBean("reviewBukkenAlertCountService");

        List<ReviewBukkenAlertCountOutServiceBean> rsList =
                service.getBukkenAlertCount(inBean, condition);

        // ViewHelper設定
        ReviewBukkenAlertCountView view = new ReviewBukkenAlertCountView(condition);
        BeanUtils.copyProperties(view, form);

        if (rsList.size() != 0) {
            // 画面出力処理
            List<ReviewBukkenAlertCountDetailView> detailList =
                    new ArrayList<ReviewBukkenAlertCountDetailView>();
            for (int i = 0; i < rsList.size(); i++) {
                ReviewBukkenAlertCountDetailView detailView =
                        view.new ReviewBukkenAlertCountDetailView();
                BeanUtils.copyProperties(detailView, rsList.get(i));
                String sendDt = rsList.get(i).getSendDt().substring(0, 10).replaceAll("-", "/");
                detailView.setSendDt(sendDt);
                detailList.add(detailView);
            }
            view.setBukkenAlertList(detailList);

        } else {
          context.setError("WARN.M.REVIEW.0055");
        }

        // 検索条件コピー
        BeanUtils.copyProperties(view, inBean);

        context.setForward("success", view);
    }
}

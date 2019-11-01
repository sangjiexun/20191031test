/*
 * $Id: ReviewBukkenAlertCountPageAction.java 3593 2007-12-17 04:31:16Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/12  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.review.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.review.action.view.ReviewBukkenAlertCountView;

/**
 * 警告対象物件集計画面表示アクション
 * @author Lee Hosup
 * @version $Revision: 3593 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenAlertCountPageAction extends BaseActionSupport {

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

        context.getSessionBean().getSearchConditionMap().remove(
                SessionSearchKey.REVIEW_BUKKEN_ALERT_COUNT);


        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm)context.getForm();
        ReviewBukkenAlertCountView view = new ReviewBukkenAlertCountView(new BasePagerCondition());
        BeanUtils.copyProperties(view, form);

        // チェックボックス初期値設定
        view.setWarningCd0("0");
        view.setWarningCd1("1");
        view.setWarningCd2("2");

        context.setForward("success",view);

    }

}

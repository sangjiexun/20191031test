/*
 * $Id: ReviewShopStatusUpdatePageBackAction.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.review.action.view.ReviewShopStatusUpdateView;
import net.chintai.backend.sysadmin.review.service.ReviewShopStatusUpdateConfirmService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopStatusUpdateConfirmInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopStatusUpdateConfirmOutServiceBean;

/**
 * 店舗対象外設定画面に戻るアクション
 * @author Lee Hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopStatusUpdatePageBackAction extends BaseActionSupport {

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
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ReviewShopStatusUpdateConfirmInServiceBean inBean =
                new ReviewShopStatusUpdateConfirmInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();
        ReviewShopStatusUpdateConfirmService service =
                (ReviewShopStatusUpdateConfirmService) ac
                        .getBean("reviewShopStatusUpdateConfirmService");

        ReviewShopStatusUpdateConfirmOutServiceBean outBean = service.getShopInfo(inBean);

        // viewHelper 設定
        ReviewShopStatusUpdateView view = new ReviewShopStatusUpdateView();
        BeanUtils.copyProperties(view, form);
        BeanUtils.copyProperties(view, outBean);

        context.setForward("success", view);
    }
}

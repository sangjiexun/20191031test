/*
 * $Id: ReviewShopStatusUpdatePageAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/12  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.review.action;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.review.action.view.ReviewShopStatusUpdateView;
import net.chintai.backend.sysadmin.review.service.ReviewShopStatusUpdatePageService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopStatusUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopStatusUpdatePageOutServiceBean;

/**
 * 店舗対象外設定画面表示アクション
 * @author Lee Hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopStatusUpdatePageAction extends BaseActionSupport {

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
        String shopCd = context.getRequest().getParameter("shopCd");
        ReviewShopStatusUpdatePageInServiceBean inBean =
                new ReviewShopStatusUpdatePageInServiceBean();
        inBean.setShopCd(shopCd);

        // injection
        ApplicationContext ac = getWebApplicationContext();
        ReviewShopStatusUpdatePageService service =
                (ReviewShopStatusUpdatePageService) ac.getBean("reviewShopStatusUpdatePageService");

        // 店舗情報取得
        ReviewShopStatusUpdatePageOutServiceBean outBean = service.getShopStatusUpdateInfo(inBean);

        // viewHelper設定
        ReviewShopStatusUpdateView view = new ReviewShopStatusUpdateView();

        BeanUtils.copyProperties(view, outBean);

        context.setForward("success", view);
    }

}

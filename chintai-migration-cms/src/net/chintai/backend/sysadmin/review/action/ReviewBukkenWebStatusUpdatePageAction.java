/*
 * $Id: ReviewBukkenWebStatusUpdatePageAction.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.review.action.view.ReviewBukkenWebStatusUpdateView;
import net.chintai.backend.sysadmin.review.service.ReviewBukkenWebStatusUpdatePageService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenWebStatusUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenWebStatusUpdatePageOutServiceBean;

/**
 * CHINTAI NET掲載状態変更画面表示アクション
 * @author Lee Hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenWebStatusUpdatePageAction extends BaseActionSupport {

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
        //String kanriCd = context.getRequest().getParameter("kanriCd");
        ReviewBukkenWebStatusUpdatePageInServiceBean inBean =
                new ReviewBukkenWebStatusUpdatePageInServiceBean();
        //String[] codes = kanriCd.split("-");
        //inBean.setKanriCd(kanriCd);
        //inBean.setShopCd(codes[0]);
        //inBean.setBkCd(codes[1]);
        //inBean.setRoomNo(codes[2]);
        String roomKey = context.getRequest().getParameter("roomKey");
        inBean.setRoomKey(roomKey);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ReviewBukkenWebStatusUpdatePageService service =
                (ReviewBukkenWebStatusUpdatePageService) ac
                        .getBean("reviewBukkenWebStatusUpdatePageService");

        ReviewBukkenWebStatusUpdatePageOutServiceBean outBean =
                service.getBukkenWebStatusInfo(inBean);
        ReviewBukkenWebStatusUpdateView view = new ReviewBukkenWebStatusUpdateView();
        BeanUtils.copyProperties(view, outBean);

        context.setForward("success", view);
    }

}

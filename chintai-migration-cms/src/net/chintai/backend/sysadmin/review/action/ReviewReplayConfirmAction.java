/*
 * $Id: ReviewReplayConfirmAction.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.review.ReviewUtils;
import net.chintai.backend.sysadmin.review.action.view.ReviewReplayView;
import net.chintai.backend.sysadmin.review.service.ReviewReplayConfirmService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewReplayConfirmInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewReplayConfirmOutServiceBean;

/**
 * 返信入力確認アクション
 * @author Lee Hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewReplayConfirmAction extends BaseActionSupport {

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
        //String warningRirekiSeq = context.getRequest().getParameter("warningRirekiSeq");
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ReviewReplayConfirmInServiceBean inBean = new ReviewReplayConfirmInServiceBean();
        //String[] codes = kanriCd.split("-");
        //inBean.setShopCd(codes[0]);
        //inBean.setBkCd(codes[1]);
        //inBean.setRoomNo(codes[2]);
        //inBean.setWarningRirekiSeq(warningRirekiSeq);
        String roomKey = context.getRequest().getParameter("roomKey");
        inBean.setRoomKey(roomKey);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ReviewReplayConfirmService service =
                (ReviewReplayConfirmService) ac.getBean("reviewReplayConfirmService");

        ReviewReplayConfirmOutServiceBean outBean = service.getReturnMailConfirmInfo(inBean);
        ReviewReplayView view = new ReviewReplayView();
        BeanUtils.copyProperties(view, outBean);
        BeanUtils.copyProperties(view, form);
        view.setChikunen(ReviewUtils.convertChikunen(view.getChikunen()));

        // 二重更新防止トークンをセット
        saveToken(context.getRequest());


        context.setForward("success", view);

    }

}

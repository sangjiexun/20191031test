/*
 * $Id: ReviewBukkenWebStatusUpdateCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/12  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.review.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.review.ReviewUtils;
import net.chintai.backend.sysadmin.review.action.view.ReviewBukkenInfoView;
import net.chintai.backend.sysadmin.review.action.view.ReviewBukkenInfoView.ReviewBukkenInfoDetailView;
import net.chintai.backend.sysadmin.review.service.ReviewBukkenInfoService;
import net.chintai.backend.sysadmin.review.service.ReviewBukkenWebStatusUpdateCommitService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenInfoInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenInfoOutServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenWebStatusUpdateCommitInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenInfoOutServiceBean.ReviewBukkenInfoOutServiceDetailBean;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenInfoOutServiceBean;

/**
 * CHINTAI NET掲載状態変更更新アクション
 * @author Lee Hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenWebStatusUpdateCommitAction extends BaseActionSupport {

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

        // 画面データを取得
        String kanriCd = context.getRequest().getParameter("kanriCd");
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ReviewBukkenWebStatusUpdateCommitInServiceBean inBean =
                new ReviewBukkenWebStatusUpdateCommitInServiceBean();
        BeanUtils.copyProperties(inBean, form);
        //String[] codes = kanriCd.split("-");
        //inBean.setShopCd(codes[0]);
        //inBean.setBkCd(codes[1]);
        //inBean.setRoomNo(codes[2]);
        String roomKey = context.getRequest().getParameter("roomKey");
        inBean.setRoomKey(roomKey);

        inBean.setUpdId(context.getSessionBean().getUserId());

        // プログラムID設定
        inBean.setUpdPg(this.getClass().getName());

        // injection
        ApplicationContext ac = getWebApplicationContext();

        // 画面リロード対策
        if (isTokenValid(context.getRequest())) {
            resetToken(context.getRequest());

            ReviewBukkenWebStatusUpdateCommitService service =
                    (ReviewBukkenWebStatusUpdateCommitService) ac
                            .getBean("reviewBukkenWebStatusUpdateCommitService");

            // 操作ログ記録サービス
            OperationLoggingService loggingService =
                    (OperationLoggingService) ac.getBean("operationLoggingService");

            try {
                // 店舗管理テーブル更新
                service.updateBukkenWebStatus(inBean);

                // 更新成功ログ、メッセージ設定
                loggingService.write("05003", inBean.getUpdId(), SessionStatus.SUCCESS,
                        ApplicationResources.getProperty("review.kanriCd") + kanriCd, this.getClass().getName());
                context.setMessage("INFO.M.REVIEW.0032", ApplicationResources
                        .getProperty("review.bukkenWebStatus"));
            } catch (ApplicationException e) {
                // 更新失敗ログ
                loggingService.write("05003", inBean.getUpdId(), SessionStatus.FAILURE,
                        ApplicationResources.getProperty("review.kanriCd") + kanriCd, this.getClass().getName());
    //            throw e;
                context.setError(e.getErrorId());
            }

        }

        context.setForward("success");

        // ------------------------- 以下遷移先画面設定 -------------------------
/*
        // Injection(管理系サービスから物件情報を取得)
        ReviewBukkenInfoInServiceBean infoInBean = new ReviewBukkenInfoInServiceBean();
        BukkenInfoInServiceBean kanriInBean = new BukkenInfoInServiceBean();
        //infoInBean.setShopCd(codes[0]);
        //infoInBean.setBkCd(codes[1]);
        //infoInBean.setRoomNo(codes[2]);
        infoInBean.setRoomKey(roomKey);
        BeanUtils.copyProperties(kanriInBean, infoInBean);

        BeanUtils.copyProperties(kanriInBean, infoInBean);

        BukkenInfoService bukkenInfoService = (BukkenInfoService) ac.getBean("BukkenInfoService");

        // 物件詳細情報Serviceを行う
        BukkenInfoOutServiceBean rs = bukkenInfoService.bukkenInfo(kanriInBean);
        ReviewBukkenInfoView view = new ReviewBukkenInfoView();
        BeanUtils.copyProperties(view, rs);

        // Web審査情報を取得
        ReviewBukkenInfoService reviewInfoService =
                (ReviewBukkenInfoService) ac.getBean("reviewBukkenInfoService");

        ReviewBukkenInfoOutServiceBean outBean = reviewInfoService.getBukkenInfo(infoInBean);

        // ViewHelper設定
        BeanUtils.copyProperties(view, outBean);
        if (outBean.getRirekiList() != null && outBean.getRirekiList().size() > 0) {
            List<ReviewBukkenInfoOutServiceDetailBean> rirekiList = outBean.getRirekiList();
            List<ReviewBukkenInfoDetailView> detailList =
                    new ArrayList<ReviewBukkenInfoDetailView>();
            for (int i = 0; i < rirekiList.size(); i++) {
                ReviewBukkenInfoDetailView detailView = view.new ReviewBukkenInfoDetailView();
                detailView.setSendDt(ReviewUtils.convertDate(rirekiList.get(i).getSendDt()));
                detailView.setSyoriDt(ReviewUtils.convertDate(rirekiList.get(i).getSyoriDt()));
                detailView.setWarningName(rirekiList.get(i).getWarningName());
                detailView.setStatusKbn(rirekiList.get(i).getStatusKbn());
                detailView.setVacantYmd(ReviewUtils.convertDate(rirekiList.get(i).getVacantYmd()));
                detailView.setShinchikuFlg(rirekiList.get(i).getShinchikuFlg());
                detailView.setLastConfirmYmd(ReviewUtils.convertDate(rirekiList.get(i)
                        .getLastConfirmYmd()));
                detailView.setSyoriKbn(rirekiList.get(i).getSyoriKbn());
                detailView.setBikou(rirekiList.get(i).getBikou());
                detailList.add(detailView);
            }
            view.setDetailList(detailList);
        }

        context.setForward("success", view);
*/
    }

}

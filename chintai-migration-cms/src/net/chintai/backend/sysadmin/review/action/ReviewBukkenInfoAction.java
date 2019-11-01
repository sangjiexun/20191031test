/*
 * $Id: ReviewBukkenInfoAction.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.review.ReviewUtils;
import net.chintai.backend.sysadmin.review.action.view.ReviewBukkenInfoView;
import net.chintai.backend.sysadmin.review.action.view.ReviewBukkenInfoView.ReviewBukkenInfoDetailView;
import net.chintai.backend.sysadmin.review.service.ReviewBukkenInfoService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenInfoInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenInfoOutServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenInfoOutServiceBean.ReviewBukkenInfoOutServiceDetailBean;
import net.chintai.backend.sysadmin.shop_bukken.action.view.BukkenInfoView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.BukkenInfoView.TantouShopListDetailView;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenInfoOutServiceBean;

/**
 * 物件詳細情報画面表示アクション
 * @author Lee Hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenInfoAction extends BaseActionSupport {

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

        // パラメータから店舗コードを取得
        //String kanriCd = context.getRequest().getParameter("kanriCd");
        //String cdList[] = kanriCd.split("-");
        ReviewBukkenInfoInServiceBean inBean = new ReviewBukkenInfoInServiceBean();
        BukkenInfoInServiceBean kanriInBean = new BukkenInfoInServiceBean();
        //inBean.setShopCd(cdList[0]);
        //inBean.setBkCd(cdList[1]);
        //inBean.setRoomNo(cdList[2]);
        String roomKey = context.getRequest().getParameter("roomKey");
        inBean.setRoomKey(roomKey);

        BeanUtils.copyProperties(kanriInBean, inBean);

        // Injection(管理系サービスから物件情報を取得)
        ApplicationContext ac = getWebApplicationContext();
        BukkenInfoService bukkenInfoService = (BukkenInfoService) ac.getBean("BukkenInfoService");

        // 物件詳細情報Serviceを行う
        BukkenInfoOutServiceBean rs = bukkenInfoService.bukkenInfo(kanriInBean);
        ReviewBukkenInfoView view = new ReviewBukkenInfoView();
        BeanUtils.copyProperties(view, rs);

        // Web審査情報を取得
        ReviewBukkenInfoService reviewInfoService =
                (ReviewBukkenInfoService) ac.getBean("reviewBukkenInfoService");

        ReviewBukkenInfoOutServiceBean outBean = reviewInfoService.getBukkenInfo(inBean);
        BeanUtils.copyProperties(view, outBean);
        if (outBean.getRirekiList() != null && outBean.getRirekiList().size() > 0) {
            List<ReviewBukkenInfoOutServiceDetailBean> rirekiList = outBean.getRirekiList();
            List<ReviewBukkenInfoDetailView> detailList =
                    new ArrayList<ReviewBukkenInfoDetailView>();
            for (int i = 0; i < rirekiList.size(); i++) {
                ReviewBukkenInfoDetailView detailBean = view.new ReviewBukkenInfoDetailView();
                detailBean.setSendDt(ReviewUtils.convertDate(rirekiList.get(i).getSendDt()));
                detailBean.setSyoriDt(ReviewUtils.convertDate(rirekiList.get(i).getSyoriDt()));
                detailBean.setWarningName(rirekiList.get(i).getWarningName());
                detailBean.setStatusKbn(rirekiList.get(i).getStatusKbn());
                detailBean.setVacantYmd(ReviewUtils.convertDate(rirekiList.get(i).getVacantYmd()));
                detailBean.setShinchikuFlg(rirekiList.get(i).getShinchikuFlg());
                detailBean.setLastConfirmYmd(ReviewUtils.convertDate(rirekiList.get(i)
                        .getLastConfirmYmd()));
                detailBean.setSyoriKbn(rirekiList.get(i).getSyoriKbn());
                detailBean.setBikou(rirekiList.get(i).getBikou());
                detailBean.setWarningRirekiSeq(rirekiList.get(i).getWarningRirekiSeq());
                detailBean.setWarningDt(ReviewUtils.convertDate(rirekiList.get(i).getWarningDt()));
                detailList.add(detailBean);
            }
            view.setDetailList(detailList);
        }

        //店舗リスト（取扱店）を取得
        List rslist = bukkenInfoService.bukkenInfoTantouShop(kanriInBean);
        List<BukkenInfoView.TantouShopListDetailView> tantouShopList =
        		new ArrayList<BukkenInfoView.TantouShopListDetailView>();

        for (int i = 0; i < rslist.size(); i++) {
        	BukkenInfoView.TantouShopListDetailView tantouShopDetail = view.new TantouShopListDetailView();
            BeanUtils.copyProperties(tantouShopDetail, rslist.get(i));
            tantouShopList.add(tantouShopDetail);
        }
        view.setTantouShopList(tantouShopList);

        context.setForward("success", view);
    }
}

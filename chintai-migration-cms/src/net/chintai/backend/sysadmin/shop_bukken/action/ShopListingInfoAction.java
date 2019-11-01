/*
 * $Id: ShopListingInfoAction.java 3850 2008-03-10 05:40:33Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/26  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopListingInfoView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopListingInfoView.ShopListingInfoDetailView;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingDetailService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 店舗リスティング一覧
 *
 * @author
 * @version $Revision:
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingInfoAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ShopListingInfoInServiceBean inServiceBean = new ShopListingInfoInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();
        ShopListingInfoService service = (ShopListingInfoService) ac.getBean("shopListingInfoService");

        // 契約情報照会
        ShopListingInfoOutServiceBean outBean = null;
        outBean = service.getContractInfo(inServiceBean);

        // 店舗リスティング情報照会
        ShopListingInServiceBean shopListingParamBean = new ShopListingInServiceBean();
        BeanUtils.copyProperties(shopListingParamBean, form);

        ShopListingDetailService shopListingDetail =
                (ShopListingDetailService) ac.getBean("shopListingDetailService");
        List<ShopListingOutServiceBean> shopListingList =
                (List<ShopListingOutServiceBean>) shopListingDetail.getShopListingDetail(shopListingParamBean);

//        // 登録画面に遷移
//        if (shopListingList == null || shopListingList.size() == 0) {
//            //ActionFormの初期化
//            DynaValidatorForm actionForm = (DynaValidatorForm)context.getForm();
//            context.setForm(actionForm);
//
//            // ViewHelper設定
//            ShopListingAddView view = new ShopListingAddView();
//            BeanUtils.copyProperties(view, form);
//            BeanUtils.copyProperties(view, outBean);
//
//            // 適用月のValidationCheckのため現在日付をViewに設定
//            String nowDate = DateUtil.getTomorrow("yyyyMMdd") + "00";
//
//            view.setNowDate(nowDate);
//            view.setApplyYearList(DemandUtils.getYearList());
//            context.setForm(actionForm);
//            context.setForward("fail",view);
//            return;
//        }

        // viewHelper設定(店舗リスティング)
        ShopListingInfoView view = new ShopListingInfoView();
        BeanUtils.copyProperties(view, outBean);

        // viewHelper設定(店舗リスティング詳細)
        List<ShopListingInfoDetailView> detailList = new ArrayList<ShopListingInfoDetailView>();

        List delFlgList = Arrays.asList((String[]) form.get("delFlgList"));

        for (int i = 0; i < shopListingList.size(); i++) {
            ShopListingInfoDetailView detailView = view.new ShopListingInfoDetailView();
            BeanUtils.copyProperties(detailView, shopListingList.get(i));

            // 適用月(画面出力用)設定
            detailView.setKeiyakuStartYmForDisplay(DemandUtils.convertDateAll(detailView.getKeiyakuStartDt()));
            detailView.setKeiyakuEndYmForDisplay(DemandUtils.convertDateAll(detailView.getKeiyakuEndDt()));

            if (delFlgList.contains(detailView.getKeiyakuNo().toString())) {
                detailView.setCheckFlg("on");
            }

            detailList.add(detailView);
        }

        view.setLstShopListingDetail(detailList);

        view.setIsWakuDisp(service.isWakuDisp(view.getKeiyakuCd(), view.getKeiyakuSubCd()));

        context.setForward("success", view);
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }

}

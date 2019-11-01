package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.common.util.StringUtil;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ContractAmountUpdateView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopListingUpdateView;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingUpdagePageService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingUpdatePageOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 店舗リスティング設定情報更新
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingUpdatePageAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ShopListingUpdatePageInServiceBean inServiceBean = new ShopListingUpdatePageInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();

        ShopListingUpdagePageService shopListingService =
                (ShopListingUpdagePageService) ac
                        .getBean("shopListingUpdatePageService");

        // 契約番号から契約詳細を取得
        ShopListingUpdatePageOutServiceBean shopListingtBean =
                shopListingService.getShopListing(inServiceBean);

        ShopListingInfoService service =
                (ShopListingInfoService) ac.getBean("shopListingInfoService");

        // 契約情報照会取得条件の設定
        ShopListingInfoInServiceBean inServiceInfoBean = new ShopListingInfoInServiceBean();
        BeanUtils.copyProperties(inServiceInfoBean, shopListingtBean);

        // 契約情報照会
        ShopListingInfoOutServiceBean outBean;
        outBean = service.getContractInfo(inServiceInfoBean);

        // viewHelper設定(店舗リスティング)
        ShopListingUpdateView view = new ShopListingUpdateView();

        BeanUtils.copyProperties(view, shopListingtBean);
        BeanUtils.copyProperties(view, outBean);

        view.setApplyYearList(DemandUtils.getYearList());

        String maxNum = StringUtil.leftZeroPadding("0", view.getAmountLenth().intValue());
        maxNum = maxNum.replaceAll("0", "9");
        view.setMaxNum(maxNum);

        // 適用月のValidationCheckのため現在日付をViewに設定
        String nowDate = DateUtil.getToday("yyyyMMddHH") + "0000";
        //String nowDate = DateUtil.getToday("yyyyMMddHHmmss");
        view.setNowDate(nowDate);

        view.setIsWakuDisp(service.isWakuDisp(view.getKeiyakuCd(), view.getKeiyakuSubCd()));

        //チェックボックス初期表示のための処理
        this.checkCntValues(view,outBean.getListAmount());

        context.setForward("success", view);
    }

    /**
     * DBの物件枠、物件リスティングデータに基づいて<br>
     * 画面のチェックボックス状態を設定します。
     * @param view 画面出力情報
     * @param listAmount 画面チェックボックスリスト
     */
    private void checkCntValues(ShopListingUpdateView view,List<String> listAmount) {


        if (!(listAmount.contains(view.getWakuCnt()))) {
            view.setWakuCntNote(view.getWakuCnt());
            view.setWakuCnt("-1");
        }
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

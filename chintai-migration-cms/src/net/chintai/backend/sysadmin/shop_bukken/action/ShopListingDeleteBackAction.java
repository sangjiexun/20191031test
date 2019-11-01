package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
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


/**
 *
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingDeleteBackAction extends BaseActionSupport {

    /* (non-Javadoc)
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
        ShopListingInfoService service =
                (ShopListingInfoService) ac.getBean("shopListingInfoService");

        // 契約情報照会
        ShopListingInfoOutServiceBean outBean;
        outBean = service.getContractInfo(inServiceBean);

        // 店舗リスティング情報照会
        ShopListingInServiceBean wakuInBean = new ShopListingInServiceBean();
        BeanUtils.copyProperties(wakuInBean, form);

        ShopListingDetailService wakuInfoService =
                (ShopListingDetailService) ac.getBean("shopListingDetailService");
        List<ShopListingOutServiceBean> wakuList =
                (List<ShopListingOutServiceBean>) wakuInfoService
                        .getShopListingDetail(wakuInBean);

        // viewHelper設定(取引先詳細)
        ShopListingInfoView view = new ShopListingInfoView();
        BeanUtils.copyProperties(view, outBean);

        // viewHelper設定(物件枠詳細)
        List<ShopListingInfoDetailView> detailList = new ArrayList<ShopListingInfoDetailView>();
        List delFlgList = Arrays.asList((String[]) form.get("delFlgList"));

        for (int i=0; i < wakuList.size(); i++) {
            ShopListingInfoDetailView detailView = view.new ShopListingInfoDetailView();
            BeanUtils.copyProperties(detailView, wakuList.get(i));

            // 適用月(画面出力用)設定
            detailView.setKeiyakuStartYmForDisplay(DemandUtils.convertDateYMDH(detailView.getKeiyakuStartDt()));
            detailView.setKeiyakuEndYmForDisplay(DemandUtils.convertDateYMDH(detailView.getKeiyakuEndDt()));
             if (delFlgList.contains(detailView.getKeiyakuStartDt())) {
                detailView.setCheckFlg("on");
            }

            detailList.add(detailView);
        }

        view.setLstShopListingDetail(detailList);

        context.setForward("success", view);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }

}

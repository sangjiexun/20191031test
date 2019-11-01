package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopListingDeleteView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopListingDeleteView.ShopListingDeleteDetailView;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingDeleteConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingDeleteConfirmInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingDeleteConfirmOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 店舗リスティング設定情報削除確認
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingDeleteConfirmAction extends BaseActionSupport {

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
        ShopListingInfoService infoService =
                (ShopListingInfoService) ac.getBean("shopListingInfoService");

        // 契約情報照会
        ShopListingInfoOutServiceBean outBean = infoService.getContractInfo(inServiceBean);

        ShopListingDeleteConfirmInServiceBean inBean =
                new ShopListingDeleteConfirmInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // injection
        ShopListingDeleteConfirmService service =
                (ShopListingDeleteConfirmService) ac
                        .getBean("shopListingDeleteConfirmService");

        if (inBean.getDelFlgList().length ==0) {
            context.setForward("fail");
            String errorMessage = ApplicationResources.getProperty("shop_bukken.Del");

            context.setError("WARN.M.SHOP_BUKKEN.0262", errorMessage);
            return;
        }

        List<ShopListingDeleteConfirmOutServiceBean> rsList =
                service.getShopListingForDelete(inBean);

        ShopListingDeleteView view = new ShopListingDeleteView();
        BeanUtils.copyProperties(view, outBean);

        List<ShopListingDeleteDetailView> detailList =
                new ArrayList<ShopListingDeleteDetailView>();
        BeanUtils.copyProperties(inBean, outBean);

        for (int i = 0; i < rsList.size(); i++) {
            ShopListingDeleteDetailView detailView =
                    view.new ShopListingDeleteDetailView();
            BeanUtils.copyProperties(detailView, rsList.get(i));
            detailView.setKeiyakuStartYmForDisplay(DemandUtils.convertDateAll(detailView.getKeiyakuStartDt()));
            detailView.setKeiyakuEndYmForDisplay(DemandUtils.convertDateAll(detailView.getKeiyakuEndDt()));

            detailList.add(detailView);
        }
        view.setDetailList(detailList);

        if (inBean.getDelFlgList().length != rsList.size()) {
        	context.setForward("fail");
            String errorMessage = ApplicationResources.getProperty("shop_bukken.Del");

            context.setError("WARN.M.SHOP_BUKKEN.0262", errorMessage);
            return;
        }

        view.setIsWakuDisp(infoService.isWakuDisp(view.getKeiyakuCd(), view.getKeiyakuSubCd()));

        // 二重更新防止トークンをセット
        saveToken(context.getRequest());

        context.setForward("success",view);
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

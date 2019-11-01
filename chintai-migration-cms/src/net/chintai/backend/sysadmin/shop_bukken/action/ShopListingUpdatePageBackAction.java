package net.chintai.backend.sysadmin.shop_bukken.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopListingUpdateView;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 *
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingUpdatePageBackAction extends BaseActionSupport {

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

        // 店舗リスティング照会
        ShopListingInfoOutServiceBean outBean = service.getContractInfo(inServiceBean);

        ShopListingUpdateView view = new ShopListingUpdateView();

        view.setApplyYearList(DemandUtils.getYearList());
        BeanUtils.copyProperties(view, outBean);
        BeanUtils.copyProperties(view, form);

        // 適用月のValidationCheckのため現在日付をViewに設定
        String nowDate = DateUtil.getToday("yyyyMMddHH") + "0000";
        //String nowDate = DateUtil.getToday("yyyyMMddHHmmss");
        view.setNowDate(nowDate);

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

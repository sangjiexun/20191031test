package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.common.util.StringUtil;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopListingAddView;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountDetailService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 店舗リスティング情報を登録
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingAddPageAction extends BaseActionSupport {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ShopListingInfoInServiceBean inBean = new ShopListingInfoInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();
        ShopListingInfoService service =
                (ShopListingInfoService) ac.getBean("shopListingInfoService");

        //契約情報照会
        ShopListingInfoOutServiceBean outBean;
        outBean = service.getContractInfo(inBean);

        //契約枠情報照会
        ContractAmountInServiceBean wakuInBean = new ContractAmountInServiceBean();
        BeanUtils.copyProperties(wakuInBean, form);

        ContractAmountDetailService wakuInfoService =
                (ContractAmountDetailService) ac.getBean("contractAmountDetailService");
        List<ContractAmountOutServiceBean> wakuList =
                (List<ContractAmountOutServiceBean>) wakuInfoService.getContractAmountDetail(wakuInBean);

        // ViewHelper設定
        ShopListingAddView view = new ShopListingAddView();
        BeanUtils.copyProperties(view, form);
        BeanUtils.copyProperties(view, outBean);
        BeanUtils.copyProperties(view, wakuList);

        String maxNum = StringUtil.leftZeroPadding("0", view.getAmountLenth().intValue());
        maxNum = maxNum.replaceAll("0", "9");
        view.setMaxNum(maxNum);

        // 適用月のValidationCheckのため現在日付をViewに設定
        String nowDate = DateUtil.getToday("yyyyMMddHH") + "0000";
        //String nowDate = DateUtil.getToday("yyyyMMddHHmmss");
        view.setNowDate(nowDate);

        view.setApplyYearList(DemandUtils.getYearList());

        view.setIsWakuDisp(service.isWakuDisp(view.getKeiyakuCd(), view.getKeiyakuSubCd()));

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

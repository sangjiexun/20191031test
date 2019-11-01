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
import net.chintai.backend.sysadmin.shop_bukken.action.view.ContractAmountAddView;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountDetailService;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 物件枠情報を登録
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountAddPageAction extends BaseActionSupport {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ContractAmountInfoInServiceBean inBean = new ContractAmountInfoInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();
        ContractAmountInfoService service =
                (ContractAmountInfoService) ac.getBean("contractAmountInfoService");

        //契約情報照会
        ContractAmountInfoOutServiceBean outBean = null;
        try {
            outBean = service.getContractInfo(inBean);
        } catch (ApplicationException e) {
            context.setError(e.getErrorId(), e.getPlaceHolders());
            return;
        }

        // 契約枠情報照会
        ContractAmountInServiceBean wakuInBean = new ContractAmountInServiceBean();
        BeanUtils.copyProperties(wakuInBean, form);

        ContractAmountDetailService wakuInfoService =
                (ContractAmountDetailService) ac.getBean("contractAmountDetailService");
        List<ContractAmountOutServiceBean> wakuList =
                (List<ContractAmountOutServiceBean>) wakuInfoService.getContractAmountDetail(wakuInBean);

        // ViewHelper設定
        ContractAmountAddView view = new ContractAmountAddView();
        BeanUtils.copyProperties(view, form);
        BeanUtils.copyProperties(view, outBean);
        BeanUtils.copyProperties(view, wakuList);

        // 適用年月プルダウン生成に使うデータを設定
        view.setApplyYearList(DemandUtils.getYearList());
        view.setApplyMonthList(DemandUtils.getMonthsList());

        String maxNum = StringUtil.leftZeroPadding("0", view.getAmountLenth().intValue());
        maxNum = maxNum.replaceAll("0", "9");
        view.setMaxNum(maxNum);

        // 適用月のValidationCheckのため現在日付をViewに設定
        String nowDate = DateUtil.getToday("yyyyMMddHH") + "00";
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

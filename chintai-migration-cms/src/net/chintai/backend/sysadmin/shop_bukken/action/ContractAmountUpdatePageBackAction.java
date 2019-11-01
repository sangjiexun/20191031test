package net.chintai.backend.sysadmin.shop_bukken.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ContractAmountUpdateView;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountInfoOutServiceBean;

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
public class ContractAmountUpdatePageBackAction extends BaseActionSupport {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {


        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ContractAmountInfoInServiceBean inServiceBean = new ContractAmountInfoInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();
        ContractAmountInfoService service =
                (ContractAmountInfoService) ac.getBean("contractAmountInfoService");

        // 取引先詳細照会
        ContractAmountInfoOutServiceBean outBean = null;
        try {
            outBean = service.getContractInfo(inServiceBean);
        } catch (ApplicationException e) {
            context.setError(e.getErrorId(), e.getPlaceHolders());
            return;
        }

        ContractAmountUpdateView view = new ContractAmountUpdateView();
        BeanUtils.copyProperties(view, outBean);
        BeanUtils.copyProperties(view, form);
        view.setUpdateAppStartDt(DateUtil.getToday("yyyyMMddHHmm") + "00");

        // 排他用の店舗管理更新日付は、formを引き継ぐ
        view.setShopKanriUpdDt(form.getString("shopKanriUpdDt"));

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

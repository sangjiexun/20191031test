package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ContractAmountDeleteView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ContractAmountDeleteView.ContractAmountDeleteDetailView;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountDeleteConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountDeleteConfirmInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountDeleteConfirmOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 契約明細詳細(契約数量あり)設定情報削除確認
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountDeleteConfirmAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
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
        ContractAmountInfoService infoService =
                (ContractAmountInfoService) ac.getBean("contractAmountInfoService");

        // 契約情報照会
         ContractAmountInfoOutServiceBean outBean = null;
        try {
            outBean = infoService.getContractInfo(inServiceBean);
        } catch (ApplicationException e) {
            context.setError(e.getErrorId(), e.getPlaceHolders());
            return;
        }

        ContractAmountDeleteConfirmInServiceBean inBean =
                new ContractAmountDeleteConfirmInServiceBean();
        BeanUtils.copyProperties(inBean, form);
        if (inBean.getDelFlgList().length ==0) {
            context.setForward("fail");
            String errorMessage = ApplicationResources.getProperty("shop_bukken.Del");

            context.setError("WARN.M.SHOP_BUKKEN.0262", errorMessage);
            return;
        }

        // injection
        ContractAmountDeleteConfirmService service =
                (ContractAmountDeleteConfirmService) ac
                        .getBean("contractAmountDeleteConfirmService");

        List<ContractAmountDeleteConfirmOutServiceBean> rsList =
                service.getContractAmountForDelete(inBean);

        ContractAmountDeleteView view = new ContractAmountDeleteView();
        BeanUtils.copyProperties(view, form);
        BeanUtils.copyProperties(view, outBean);

        List<ContractAmountDeleteDetailView> detailList =
                new ArrayList<ContractAmountDeleteDetailView>();
        BeanUtils.copyProperties(inBean, outBean);

        for (int i = 0; i < rsList.size(); i++) {
            ContractAmountDeleteDetailView detailView =
                    view.new ContractAmountDeleteDetailView();
            BeanUtils.copyProperties(detailView, rsList.get(i));
            detailView.setStartYmdh(DemandUtils.convertDateYMDH(detailView.getAppStartDt()));
            detailList.add(detailView);
        }
        view.setDetailList(detailList);

        if (inBean.getDelFlgList().length != rsList.size()) {
            context.setError("ERROR.M.SHOP_BUKKEN.0015");
            context.setForward("fail");
        }

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

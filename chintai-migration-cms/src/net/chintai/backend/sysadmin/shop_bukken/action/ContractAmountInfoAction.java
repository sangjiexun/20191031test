/*
 * $Id: ContractAmountInfoAction.java 3850 2008-03-10 05:40:33Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/26  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ContractAmountInfoView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ContractAmountInfoView.ContractAmountInfoDetailView;
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
 * 取引先詳細
 *
 * @author lee-hosup
 * @version $Revision: 1.8
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountInfoAction extends BaseActionSupport {

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
        ContractAmountInfoService service = (ContractAmountInfoService) ac.getBean("contractAmountInfoService");

        // 契約情報照会
        ContractAmountInfoOutServiceBean outBean = null;
        try {
            outBean = service.getContractInfo(inServiceBean);
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

        // viewHelper設定(取引先詳細)
        ContractAmountInfoView view = new ContractAmountInfoView();
        BeanUtils.copyProperties(view, outBean);

        // viewHelper設定(物件枠詳細)
        List<ContractAmountInfoDetailView> detailList = new ArrayList<ContractAmountInfoDetailView>();

        for (int i = 0; i < wakuList.size(); i++) {
            ContractAmountInfoDetailView detailView = view.new ContractAmountInfoDetailView();
            BeanUtils.copyProperties(detailView, wakuList.get(i));

            // 適用月(画面出力用)設定
            detailView.setKeiyakuStartYmForDisplay(DemandUtils.convertDateYMDH(detailView.getKeiyakuStartDt()));
            detailView.setKeiyakuEndYmForDisplay(DemandUtils.convertDateYMDH(detailView.getKeiyakuEndDt()));
            detailList.add(detailView);
        }

        view.setWakuInfoList(detailList);

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

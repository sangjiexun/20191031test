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
import net.chintai.backend.sysadmin.shop_bukken.action.view.ContractAmountUpdateView;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountUpdagePageService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountUpdatePageOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 契約明細詳細(契約数量あり)設定情報更新
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountUpdatePageAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        String appStartDt = context.getRequest().getParameter("appStartDt");

        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ContractAmountInfoInServiceBean inServiceBean = new ContractAmountInfoInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();
        ContractAmountInfoService service =
                (ContractAmountInfoService) ac.getBean("contractAmountInfoService");

        // 契約情報照会
        ContractAmountInfoOutServiceBean outBean = null;
        try {
            outBean = service.getContractInfo(inServiceBean);
        } catch (ApplicationException e) {
            context.setError(e.getErrorId(), e.getPlaceHolders());
            return;
        }

        // 物件枠設定情報照会
        ContractAmountUpdatePageInServiceBean wakuInfoInBean =
                new ContractAmountUpdatePageInServiceBean();
        wakuInfoInBean.setShopCd(inServiceBean.getShopCd());
        wakuInfoInBean.setKeiyakuCd(inServiceBean.getKeiyakuCd());
        wakuInfoInBean.setKeiyakuSubCd(inServiceBean.getKeiyakuSubCd());
        wakuInfoInBean.setAppStartDt(appStartDt);

        ContractAmountUpdagePageService wakuInfoService =
                (ContractAmountUpdagePageService) ac
                        .getBean("contractAmountUpdatePageService");

        ContractAmountUpdatePageOutServiceBean wakuOutBean =
                wakuInfoService.getContractAmount(wakuInfoInBean);


        // viewHelper設定(取引先詳細)
        ContractAmountUpdateView view = new ContractAmountUpdateView();
        BeanUtils.copyProperties(view, outBean);
        BeanUtils.copyProperties(view, wakuOutBean);
        view.setStartYmdh(DemandUtils.convertDateYMDH(view.getAppStartDt()));
        view.setUpdateAppStartDt(DateUtil.getToday("yyyyMMddHHmm") + "00");

        String maxNum = StringUtil.leftZeroPadding("0", view.getAmountLenth().intValue());
        maxNum = maxNum.replaceAll("0", "9");
        view.setMaxNum(maxNum);

        // チェックボックス初期表示のための処理
        this.checkCntValues(view,outBean.getListAmount());

        context.setForward("success", view);
    }

    /**
     * DBの物件枠、物件リスティングデータに基づいて<br>
     * 画面のチェックボックス状態を設定します。
     * @param view 画面出力情報
     * @param listAmount 画面チェックボックスリスト
     */
    private void checkCntValues(ContractAmountUpdateView view,List<String> listAmount) {


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

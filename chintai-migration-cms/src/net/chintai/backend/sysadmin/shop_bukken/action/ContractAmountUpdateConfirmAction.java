package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
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
 * 契約明細詳細(契約数量あり)設定情報更新確認
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountUpdateConfirmAction extends BaseActionSupport {

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

        // 契約情報照会
        ContractAmountInfoOutServiceBean outBean = null;
       try {
           outBean = service.getContractInfo(inServiceBean);
       } catch (ApplicationException e) {
           context.setError(e.getErrorId(), e.getPlaceHolders());
           return;
       }

        // viewHelper設定(取引先詳細)
        ContractAmountUpdateView view = new ContractAmountUpdateView();

        BeanUtils.copyProperties(view, form);
        BeanUtils.copyProperties(view, outBean);
        view.setUpdateAppStartDt(DateUtil.getToday("yyyyMMddHHmm") + "00");

        // 排他用の店舗管理更新日付は、formを引き継ぐ
        view.setShopKanriUpdDt(form.getString("shopKanriUpdDt"));
        int maxCnt = Integer.valueOf(form.getString("maxNum").length());
        Pattern p = Pattern.compile("^[0-9]*$");

        String checkWaku = "";
        if ("-1".equals(form.getString("wakuCnt"))) {
        	checkWaku = form.getString("wakuCntNote");
        } else {
        	checkWaku = form.getString("wakuCnt");
        }

        Matcher m = p.matcher(checkWaku);
        if (!m.find()) {
            context.setForward("fail", view);
            context.setError("WARN.M.DEMAND.0001",
                    ApplicationResources.getProperty("shop_bukken.cnt"),
                    new Integer(maxCnt).toString());
            return;
       }

        int inputCntLength = new Integer(checkWaku.length());
        if (inputCntLength > maxCnt) {
            context.setForward("fail", view);
            context.setError("WARN.M.DEMAND.0001",
                    ApplicationResources.getProperty("shop_bukken.cnt"),
                    new Integer(maxCnt).toString());
            return;
        }

        // 二重更新防止トークンをセット
        saveToken(context.getRequest());
        context.setForward("success",view);
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

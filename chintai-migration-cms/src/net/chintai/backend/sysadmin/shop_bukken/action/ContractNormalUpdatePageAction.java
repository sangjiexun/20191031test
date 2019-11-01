package net.chintai.backend.sysadmin.shop_bukken.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ContractNormalUpdateView;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractNormalUpdatePageService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractNormalUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractNormalUpdatePageOutServiceBean;

/**
 * 契約明細設定（数量なし）画面に遷移アクション。
 *
 * @author m-kashiyama
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractNormalUpdatePageAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm)context.getForm();
        ContractNormalUpdatePageInServiceBean inServiceBean =
            new ContractNormalUpdatePageInServiceBean();

        // 取得したデータをinServiceBeanに設定
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        ContractNormalUpdatePageService contractNormalUpdatePageService =
            (ContractNormalUpdatePageService)ac.getBean("ContractNormalUpdatePageService");

        // アドパーク送信可否画面に遷移Serviceを行う
        ContractNormalUpdatePageOutServiceBean rs =
            contractNormalUpdatePageService.contractUpdatePage(inServiceBean);

        // 取得した物件掲載状態情報をViewHelperに設定
        ContractNormalUpdateView view = new ContractNormalUpdateView();
        BeanUtils.copyProperties(view, rs);

        context.setForward("success", view);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }
}
/*
 * $Id: TorihikisakiUpdateConfirmAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/05  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiUpdateView;
import net.chintai.backend.sysadmin.demand.service.PrefNameSearchService;
import net.chintai.backend.sysadmin.demand.service.ShisyaNameSearchService;
import net.chintai.backend.sysadmin.demand.service.bean.PrefNameSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.PrefNameSearchOutServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.ShisyaNameSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.ShisyaNameSearchOutServiceBean;

/**
 * 取引先更新確認
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiUpdateConfirmAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        TorihikisakiUpdateView view = new TorihikisakiUpdateView();
        BeanUtils.copyProperties(view, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();

        // 都道府県名称を取得
        PrefNameSearchService prefService =
                (PrefNameSearchService) ac.getBean("prefNameSearchService");
        PrefNameSearchInServiceBean prefInBean = new PrefNameSearchInServiceBean();
        prefInBean.setPrefCd(view.getPrefCd());
        PrefNameSearchOutServiceBean prefOutBean = prefService.getPrefName(prefInBean);
        view.setPrefName(prefOutBean.getPrefName());

        // 支社名を取得
        ShisyaNameSearchService shisyaService =
                (ShisyaNameSearchService) ac.getBean("shisyaNameSearchService");
        ShisyaNameSearchInServiceBean shisyaInBean = new ShisyaNameSearchInServiceBean();
        shisyaInBean.setShisyaCd(view.getShisyaCd());
        ShisyaNameSearchOutServiceBean shisyaOutBean = shisyaService.getShisyaName(shisyaInBean);
        view.setShisyaName(shisyaOutBean.getShisyaName());

        // 二重更新防止トークンをセット
        saveToken(context.getRequest());

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
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }

}

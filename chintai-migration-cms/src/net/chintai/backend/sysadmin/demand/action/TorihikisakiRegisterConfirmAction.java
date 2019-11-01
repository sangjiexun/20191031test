/*
 * $Id: TorihikisakiRegisterConfirmAction.java 3591 2007-12-17 04:09:45Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/28  BGT)李昊燮   新規作成
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
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiRegisterView;
import net.chintai.backend.sysadmin.demand.service.PrefNameSearchService;
import net.chintai.backend.sysadmin.demand.service.ShisyaNameSearchService;
import net.chintai.backend.sysadmin.demand.service.bean.PrefNameSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.PrefNameSearchOutServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.ShisyaNameSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.ShisyaNameSearchOutServiceBean;

/**
 * 取引先新規登録確認
 *
 * @author lee-hosup
 * @version $Revision: 3591 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiRegisterConfirmAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        TorihikisakiRegisterView view = new TorihikisakiRegisterView();
        BeanUtils.copyProperties(view, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();

        // 都道府県コードで都道府県名称を取得
        PrefNameSearchInServiceBean prefInBean = new PrefNameSearchInServiceBean();
        prefInBean.setPrefCd((String) form.get("prefCd"));
        PrefNameSearchService prefService =
                (PrefNameSearchService) ac.getBean("prefNameSearchService");
        PrefNameSearchOutServiceBean prefOutBean = prefService.getPrefName(prefInBean);
        view.setPrefName(prefOutBean.getPrefName());

        // 取引先担当支社名称を取得
        ShisyaNameSearchService shisyaService =
                (ShisyaNameSearchService) ac.getBean("shisyaNameSearchService");
        ShisyaNameSearchInServiceBean shisyaInBean = new ShisyaNameSearchInServiceBean();
        shisyaInBean.setShisyaCd((String) form.get("shisyaCd"));
        ShisyaNameSearchOutServiceBean shisyaOutBean = shisyaService.getShisyaName(shisyaInBean);
        view.setShisyaName(shisyaOutBean.getShisyaName());

        // 適用月のValidationCheckのため現在日付をViewに設定
        String nowDate = DateUtil.getToday("yyyyMM");
        view.setNowDate(nowDate);

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

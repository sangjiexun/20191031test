/*
 * $Id: ShopBindUpdatePageBackAction.java 3677 2007-12-20 04:40:32Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/16  BGT)李昊燮   新規作成
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
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.demand.action.view.ShopBindUpdateView;
import net.chintai.backend.sysadmin.demand.service.ShopBindUpdatePageService;
import net.chintai.backend.sysadmin.demand.service.bean.ShopBindUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.ShopBindUpdatePageOutServiceBean;


/**
 * 店舗情報詳細(確認画面)の戻るボタンアクション
 * @author lee-hosup
 * @version $Revision: 3677 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBindUpdatePageBackAction extends BaseActionSupport {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        String shopCd = context.getRequest().getParameter("shopCd");
        ShopBindUpdatePageInServiceBean inBean = new ShopBindUpdatePageInServiceBean();
        inBean.setShopCd(shopCd);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ShopBindUpdatePageService service =
                    (ShopBindUpdatePageService) ac.getBean("shopBindUpdatePageService");

        // 検索開始
        ShopBindUpdatePageOutServiceBean outBean = service.getShopInfoDetail(inBean);

        // ViewHelper設定
        ShopBindUpdateView view = new ShopBindUpdateView();
        BeanUtils.copyProperties(view, outBean);

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        view.setTorihikisakiCd(form.getString("torihikisakiCd"));
        view.setTorihikisakiName(form.getString("torihikisakiName"));
        view.setTorihikisakiSeq(form.getString("torihikisakiSeq"));
        view.setUpdDt(form.getString("updDt"));
        view.setZip(DemandUtils.convertZipCd(view.getZip()));

        context.setForward("success", view);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }

}

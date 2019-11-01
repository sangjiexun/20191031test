/*
 * $Id: ShopBasicInfoUpdateConfirmAction.java 4285 2009-07-07 02:52:30Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopBasicInfoUpdateView;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopBasicInfoUpdateConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopBasicInfoUpdateConfirmInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopBasicInfoUpdateConfirmOutServiceBean;

/**
 * 店舗基本情報更新確認アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4285 $ Copyright:
 * (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBasicInfoUpdateConfirmAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#
     * doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ShopBasicInfoUpdateConfirmInServiceBean inBean =
                new ShopBasicInfoUpdateConfirmInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();
        ShopBasicInfoUpdateConfirmService service =
                (ShopBasicInfoUpdateConfirmService) ac.getBean("shopBasicInfoUpdateConfirmService");

        ShopBasicInfoUpdateConfirmOutServiceBean outBean =
                new ShopBasicInfoUpdateConfirmOutServiceBean();
        outBean = service.getEnsenInfo(inBean);

        // viewHelper設定
        ShopBasicInfoUpdateView view = new ShopBasicInfoUpdateView();
        BeanUtils.copyProperties(view, form);
        BeanUtils.copyProperties(view, outBean);

        // 二重更新防止トークンをセット
        saveToken(context.getRequest());

        context.setForward("success", view);

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java
     * .lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }

}

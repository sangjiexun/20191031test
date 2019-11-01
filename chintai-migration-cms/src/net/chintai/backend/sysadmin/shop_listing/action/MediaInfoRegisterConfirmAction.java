/*
 * $Id: MediaInfoRegisterConfirmAction.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/18     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_listing.action.view.MediaInfoRegisterView;
import net.chintai.backend.sysadmin.shop_listing.service.MediaInfoConfirmService;
import net.chintai.backend.sysadmin.shop_listing.service.ShopBasicInfoService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoConfirmInServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoConfirmOutServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopBasicInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 出稿情報（仮保存）登録確認アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoRegisterConfirmAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#
     * doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        String shopCd = form.getString("shopCd");

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ShopBasicInfoService basicInfoService =
                (ShopBasicInfoService) ac.getBean("shopBasicInfoService");

        // 契約店舗詳細情報を取得
        ShopBasicInfoOutServiceBean basicInfoOutBean = basicInfoService.searchShopBasicInfo(shopCd);

        // viewHelper設定
        MediaInfoRegisterView view = new MediaInfoRegisterView();
        BeanUtils.copyProperties(view, basicInfoOutBean);

        // 出稿情報登録確認サービス
        MediaInfoConfirmService service =
                (MediaInfoConfirmService) ac.getBean("mediaInfoConfirmService");
        MediaInfoConfirmInServiceBean inBean = new MediaInfoConfirmInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        MediaInfoConfirmOutServiceBean outBean = service.searchConfirmInfo(inBean);
        BeanUtils.copyProperties(view, outBean);

        BeanUtils.copyProperties(view, form);

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
        return auth.authenticate(userId, AuthorityId.SHOP_LISTING);
    }

}

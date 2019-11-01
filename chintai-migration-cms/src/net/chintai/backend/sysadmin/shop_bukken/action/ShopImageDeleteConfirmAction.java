/*
 * $Id: ShopImageDeleteConfirmAction.java 4295 2009-07-07 12:59:59Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)沈鍾沿     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopImageDeleteConfirmView;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 店舗画像削除確認画面を表示するアクション
 *
 * @author Sim-JongYeon
 * @version $Revision: 4295 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopImageDeleteConfirmAction extends BaseActionSupport {

    /** 店舗画像フラグ : 画像ファイルの削除チェックフラグ */
    private static final String C_IMG_DEL_FLG_0 = "on";

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai
     * .backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        String shopMapPctFileDeleteCheck = (String) form.get("shopMapPctFileDeleteCheck");
        String shopPhoto1FileDeleteCheck = (String) form.get("shopPhoto1FileDeleteCheck");
        String shopPhoto2FileDeleteCheck = (String) form.get("shopPhoto2FileDeleteCheck");
        String shopPhoto3FileDeleteCheck = (String) form.get("shopPhoto3FileDeleteCheck");
        String shopPhoto4FileDeleteCheck = (String) form.get("shopPhoto4FileDeleteCheck");

        // 選択された削除する画像ファイルが１件以上かどうかをチェックする。
        if (!C_IMG_DEL_FLG_0.equals(shopMapPctFileDeleteCheck)
                && !C_IMG_DEL_FLG_0.equals(shopPhoto1FileDeleteCheck)
                && !C_IMG_DEL_FLG_0.equals(shopPhoto2FileDeleteCheck)
                && !C_IMG_DEL_FLG_0.equals(shopPhoto3FileDeleteCheck)
                && !C_IMG_DEL_FLG_0.equals(shopPhoto4FileDeleteCheck)) {

            context.setError("WARN.M.SHOP_BUKKEN.0034", ApplicationResources
                    .getProperty("shop.imgFile"));
            context.setForward("fail");
            return;
        }

        // 画面データの取得
        ShopImageDeleteConfirmView view = new ShopImageDeleteConfirmView();
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
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }

}

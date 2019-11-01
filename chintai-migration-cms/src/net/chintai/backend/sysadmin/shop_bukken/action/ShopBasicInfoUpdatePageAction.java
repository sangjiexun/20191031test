/*
 * $Id: ShopBasicInfoUpdatePageAction.java 4296 2009-07-09 06:21:13Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopBasicInfoUpdateView;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopDetailInfoSearchService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDetailInfoSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDetailInfoSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;

/**
 * 基本情報更新ページ表示アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4296 $ Copyright:
 * (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBasicInfoUpdatePageAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai
     * .backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // リクエストから店舗コードを取得
        String shopCd = context.getRequest().getParameter("shopCd");
        ShopDetailInfoSearchInServiceBean inServiceBean = new ShopDetailInfoSearchInServiceBean();
        inServiceBean.setShopCd(shopCd);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ShopDetailInfoSearchService shopDetailInfoSearchService =
                (ShopDetailInfoSearchService) ac.getBean("shopDetailInfoSearchService");

        // 店舗詳細取得
        ShopDetailInfoSearchOutServiceBean outBean =
                shopDetailInfoSearchService.shopSearchByShopCd(inServiceBean);

        // viewHelper設定
        ShopBasicInfoUpdateView view = new ShopBasicInfoUpdateView();
        BeanUtils.copyProperties(view, outBean);

        // 沿線コードがヌルーの場合、沿線プルダウン全てを未選択状態に設定する。
        if (StringUtils.isEmpty(view.getEnsenCd())) {
            view.setEnsenAreaCd(null);
            view.setEnsenType(null);
        }

        // 営業時間タイプを判別
        view.initBusinessHours(outBean.getBusinessHours());

        // 定休日タイプを判別
        view.initHolidayType(outBean.getHoliday());

        // 混雑時間帯コメントの値編集。
        if (StringUtils.isNotEmpty(outBean.getBusyComment())) {
            String suffix = SystemProperties.getProperty("BUSY_COMMEN_SUFFIXT");
            String comment = outBean.getBusyComment();

            if (comment.endsWith(suffix)) {
                comment = comment.substring(0,comment.length()-suffix.length());
                view.setBusyComment(comment);
            }
        }

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

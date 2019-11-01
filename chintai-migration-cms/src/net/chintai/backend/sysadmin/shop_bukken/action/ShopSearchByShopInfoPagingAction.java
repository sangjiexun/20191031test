/*
 * $Id: ShopSearchByShopInfoPagingAction.java 3856 2008-03-10 05:47:51Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/30  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopSearchView;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopSearchByShopInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 店舗情報から検索のページング専用アクション。 
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3856 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSearchByShopInfoPagingAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm)context.getForm();

        // Sessionから検索条件ServiceBeanを取得。
        ShopSearchInServiceBean inServiceBean =
                (ShopSearchInServiceBean) context.getSessionBean().getSearchConditionMap().get(SessionSearchKey.SHOP_BUKKEN_SEARCH_BY_SHOPINFO);

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.parseInt(((String) form.get("displayNum"))));
        condition.setOffset(((Integer) form.get("offSet")).intValue());

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        List<ShopSearchOutServiceBean> rsShopList = null;

        // 店舗情報から検索
        ShopSearchByShopInfoService shopSearchService = (ShopSearchByShopInfoService) ac.getBean("shopSearchByShopInfoService");
        rsShopList = shopSearchService.shopSearchByShopInfo(inServiceBean, condition);

        // グループ一覧のviewHelper設定
        List<ShopSearchView.ShopSearchDetailView> shopSearchList = new ArrayList<ShopSearchView.ShopSearchDetailView>();
        ShopSearchView shopSearchInfo = new ShopSearchView(condition);

        ShopSearchView view = new ShopSearchView(condition);

        if (rsShopList.size() == 0) {
            context.setError("WARN.M.SHOP_BUKKEN.0044");

        } else {
            for (int i = 0; i < rsShopList.size(); i++) {
                ShopSearchOutServiceBean shop = (ShopSearchOutServiceBean) rsShopList.get(i);

                // リスト項目はinnerClassで処理
                ShopSearchView.ShopSearchDetailView shopDetail = shopSearchInfo.new ShopSearchDetailView();
                BeanUtils.copyProperties(shopDetail, shop);

                shopSearchList.add(shopDetail);
            }

            // 検索結果及び検索条件をViewに設定
            BeanUtils.copyProperties(view, inServiceBean);
            view.setShopSearchList(shopSearchList);
        }

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
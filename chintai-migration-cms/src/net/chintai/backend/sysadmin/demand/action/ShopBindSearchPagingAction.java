/*
 * $Id: ShopBindSearchPagingAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.demand.action.view.ShopBindSearchView;
import net.chintai.backend.sysadmin.demand.action.view.ShopBindSearchView.ShopBindSearchDetailView;
import net.chintai.backend.sysadmin.demand.service.ShopBindSearchService;
import net.chintai.backend.sysadmin.demand.service.bean.ShopBindSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.ShopBindSearchOutServiceBean;

/**
 * 店舗コード紐付検索のページングアクション<br>
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBindSearchPagingAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // セッションから検索条件を取得
        ShopBindSearchInServiceBean inBean =
                (ShopBindSearchInServiceBean) context.getSessionBean().getSearchConditionMap().get(
                        SessionSearchKey.DEMAND_SHOP_BIND_SEARCH);

        // ページングで遷移してきた場合画面から選択ページング情報を取得
        // offsetがヌルではない=ページング / offsetがヌル = パンくずなど
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        if (form.get("offSet") != null) {
            inBean.setOffSet((Integer) form.get("offSet"));
        }

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ShopBindSearchService service = (ShopBindSearchService) ac.getBean("shopBindSearchService");

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.parseInt(SystemProperties
                .getProperty("C_SHOP_BIND_SEARCH_DISPLAY_LIMIT")));
        condition.setOffset(inBean.getOffSet());

        // 検索開始
        List<ShopBindSearchOutServiceBean> rsList = service.getShopInfo(inBean, condition);

        // viewHelper設定
        ShopBindSearchView view = new ShopBindSearchView(condition);
        if (rsList.size() > 0) {
            List<ShopBindSearchDetailView> detailList = new ArrayList<ShopBindSearchDetailView>();
            for (int i = 0; i < rsList.size(); i++) {
                ShopBindSearchDetailView detailView = view.new ShopBindSearchDetailView();
                BeanUtils.copyProperties(detailView, rsList.get(i));
                detailList.add(detailView);
            }
            view.setDetailList(detailList);
        } else {
            context.setError("WARN.M.DEMAND.0006");
        }

        // 検索条件をViewに設定
        BeanUtils.copyProperties(view, inBean);

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

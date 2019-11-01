/*
 * $Id: KeiyakuShopSearchPagingAction.java 4281 2009-07-06 12:10:17Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.shop_listing.action.view.KeiyakuShopSearchView;
import net.chintai.backend.sysadmin.shop_listing.action.view.KeiyakuShopSearchView.KeiyakuShopSearchDetailView;
import net.chintai.backend.sysadmin.shop_listing.service.KeiyakuShopSearchService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuShopSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuShopSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 契約店舗検索画面のページングアクション
 *
 * @author Lee Hosup
 * @version $Revision: 4281 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuShopSearchPagingAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai
     * .backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // セッションから検索条件を取得
        KeiyakuShopSearchInServiceBean inBean =
                (KeiyakuShopSearchInServiceBean) context.getSessionBean().getSearchConditionMap()
                        .get(SessionSearchKey.CONTRACT_SHOP_SEARCH);

        // 画面からページング情報を取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit((Integer) form.get("displayNum"));
        condition.setOffset((Integer) form.get("offSet"));

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        KeiyakuShopSearchService service =
                (KeiyakuShopSearchService) ac.getBean("keiyakuShopSearchService");

        // 契約店舗検索を行う。
        List<KeiyakuShopSearchOutServiceBean> rsList = service.searchShopList(inBean, condition);

        // ViewHelper設定
        KeiyakuShopSearchView view = new KeiyakuShopSearchView(condition);
        List<KeiyakuShopSearchDetailView> returnList = new ArrayList<KeiyakuShopSearchDetailView>();
        for (KeiyakuShopSearchOutServiceBean outBean : rsList) {
            KeiyakuShopSearchDetailView detailView = view.new KeiyakuShopSearchDetailView();
            BeanUtils.copyProperties(detailView, outBean);

            returnList.add(detailView);
        }
        view.setShopList(returnList);

        // 検索条件をViewHelperにコピー
        BeanUtils.copyProperties(view, inBean);

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

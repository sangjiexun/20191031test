/*
 * $Id: BukkenQueryIdSearchAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.BukkenListView;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenQueryIdSearchService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenQueryIdSearchInServiceBean;

/**
 * 問合せ番号で検索アクション
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenQueryIdSearchAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        // 取得したデータをInServiceBeanに設定
        BukkenQueryIdSearchInServiceBean inServiceBean = new BukkenQueryIdSearchInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // 検索処理Serviceを行う
        BukkenQueryIdSearchService bukkenQueryIdSearchService =
                (BukkenQueryIdSearchService) ac.getBean("BukkenQueryIdSearchService");
        List rslist = bukkenQueryIdSearchService.bukkenQueryIdSearch(inServiceBean);

        List<BukkenListView.BukkenListDetailView> bukkenList =
                new ArrayList<BukkenListView.BukkenListDetailView>();

        // 検索条件をViewHelperに設定
        BukkenListView view = new BukkenListView();
        BeanUtils.copyProperties(view, form);

        // 検索結果件数取得
        int cnt = rslist.size();
        view.setCount(cnt);

        // 検索結果件数が0件の場合
        if (cnt == 0) {
            // メッセージ設定
            context.setError("WARN.M.SHOP_BUKKEN.0046");
        }

        // 検索結果をViewHelperに設定
        for (int i = 0; i < cnt; i++) {
            BukkenListView.BukkenListDetailView bukkenDetail = view.new BukkenListDetailView();
            BeanUtils.copyProperties(bukkenDetail, rslist.get(i));
            bukkenList.add(bukkenDetail);
        }
        view.setBukkenList(bukkenList);

        context.setForward("success", view);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        // 権限チェック
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }
}
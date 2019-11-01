/*
 * $Id: BukkenInfoAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/01  BGT)金東珍     新規作成
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
import net.chintai.backend.sysadmin.shop_bukken.action.view.BukkenInfoView;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenInfoOutServiceBean;

/**
 * 物件詳細情報表示アクション。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenInfoAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        BukkenInfoInServiceBean inServiceBean = new BukkenInfoInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        BukkenInfoService bukkenInfoService =
            (BukkenInfoService)ac.getBean("BukkenInfoService");

        // 物件詳細情報Serviceを行う
        BukkenInfoOutServiceBean rs =
            bukkenInfoService.bukkenInfo(inServiceBean);

        // 物件詳細情報をViewHelperに設定
        BukkenInfoView view = new BukkenInfoView();
        BeanUtils.copyProperties(view, rs);

        List rslist = bukkenInfoService.bukkenInfoTantouShop(inServiceBean);
        List<BukkenInfoView.TantouShopListDetailView> tantouShopList =
        		new ArrayList<BukkenInfoView.TantouShopListDetailView>();

        for (int i = 0; i < rslist.size(); i++) {
        	BukkenInfoView.TantouShopListDetailView tantouShopDetail = view.new TantouShopListDetailView();
            BeanUtils.copyProperties(tantouShopDetail, rslist.get(i));
            tantouShopList.add(tantouShopDetail);
        }
        view.setTantouShopList(tantouShopList);

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
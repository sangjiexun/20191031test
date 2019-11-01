/*
 * $Id: LicenseExpiredShopListAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/06     BGT)劉俊秀       新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.LicenseExpiredShopView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.LicenseExpiredShopView.ShopInner;
import net.chintai.backend.sysadmin.shop_bukken.service.LicenseExpiredShopService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.LicenseExpiredShopOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;

/**
 * 免許有効期限切れ店舗一覧出力するアクションクラス
 * @author yoo-junsu
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class LicenseExpiredShopListAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        LicenseExpiredShopService licenseExpiredShopService =
                (LicenseExpiredShopService) ac.getBean("LicenseExpiredShopService");

        // 一覧取得
        List<LicenseExpiredShopOutServiceBean> outbeanList =
                licenseExpiredShopService.selectLicenseExpiredShop();
        // ViewHelper
        LicenseExpiredShopView view = new LicenseExpiredShopView();
        List<ShopInner> shopList = new ArrayList<ShopInner>();

        if (outbeanList != null) {
            for (LicenseExpiredShopOutServiceBean outbean : outbeanList) {
                ShopInner shop = view.new ShopInner();

                if(StringUtils.isNotEmpty(outbean.getEmail1())){
                	shop.setEmail(outbean.getEmail1());
                }else if(StringUtils.isNotEmpty(outbean.getEmail2())){
                	shop.setEmail(outbean.getEmail2());
                }else if(StringUtils.isNotEmpty(outbean.getEmail3())){
                	shop.setEmail(outbean.getEmail3());
                }else if(StringUtils.isNotEmpty(outbean.getEmail4())){
                	shop.setEmail(outbean.getEmail4());
                }else if(StringUtils.isNotEmpty(outbean.getEmail5())){
                	shop.setEmail(outbean.getEmail5());
                }

                BeanUtils.copyProperties(shop, outbean);
                shopList.add(shop);

            }
        }
        view.setCount(shopList.size());
        view.setShopList(shopList);
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

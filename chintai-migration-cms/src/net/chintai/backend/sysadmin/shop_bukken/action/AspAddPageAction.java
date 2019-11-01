/*
 * $Id: AspAddPageAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.AspAddPageView;
import net.chintai.backend.sysadmin.shop_bukken.service.AspAreaPrefInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.AspShopImageService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspAreaPrefInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoOutServiceBean;
import net.chintai.batch.common.domain.ShopRirekiImg;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * 不動産ASP設定情報登録画面へ遷移するアクション
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspAddPageAction extends BaseActionSupport {

    @Autowired
    private ShopService shopService;

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        AspShopInfoInServiceBean inServiceBean = new AspShopInfoInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ShopInfoService shopInfoService = (ShopInfoService) ac.getBean("shopInfoService");

        // 店舗基本情報を取得
        AspShopInfoOutServiceBean rsShopInfo =
                shopInfoService.aspShopInfoSearchByShopCd(inServiceBean);

        // Injection
        AspAreaPrefInfoService aspAreaPrefInfoService =
                (AspAreaPrefInfoService) ac.getBean("aspAreaPrefInfoService");

        // エリアと都道府県を取得
        List<AspAreaPrefInfoOutServiceBean> aspAreaPrefInfoList = aspAreaPrefInfoService.aspAreaPrefInfoSearch();

        // 不動産ASP設定情報をViewHelperに設定
        AspAddPageView view = new AspAddPageView();
        BeanUtils.copyProperties(view, rsShopInfo);

        // エリアと都道府県をViewHelperに設定
        List<AspAddPageView.AspAddPageDetailView> aspAddPageDetailViewList = new ArrayList<AspAddPageView.AspAddPageDetailView>();

        for(int i = 0; i < aspAreaPrefInfoList.size() ; i++){
            AspAreaPrefInfoOutServiceBean aspAreaPrefInfoOutServiceBean = aspAreaPrefInfoList.get(i);

            AspAddPageView.AspAddPageDetailView aspAddPageDetailView = view.new AspAddPageDetailView();
            BeanUtils.copyProperties(aspAddPageDetailView, aspAreaPrefInfoOutServiceBean);

            aspAddPageDetailViewList.add(aspAddPageDetailView);
        }
        view.setAspAreaPrefInfoList(aspAddPageDetailViewList);

        AspShopImageService aspShopImageService =
                (AspShopImageService) ac.getBean("aspShopImageService");

        ShopRirekiImg shopRirekiImg = aspShopImageService.getAspShopImage(inServiceBean.getShopCd());
        if (shopRirekiImg!=null) {
            view.setImgFileNm(shopRirekiImg.getImgFileNm());
            view.setImgUrlPath(shopRirekiImg.getImgUrlPath());
            view.setImgKbn(shopRirekiImg.getImgKbn());
        } else {
            view.setImgKbn(aspShopImageService.getImgKubun());
        }
        view.setImgId(shopService.getImgId(inServiceBean.getShopCd()));
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

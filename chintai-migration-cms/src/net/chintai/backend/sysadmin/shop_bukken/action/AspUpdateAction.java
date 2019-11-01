/*
 * $Id: AspUpdateAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)沈鍾沿     新規作成
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
import net.chintai.backend.sysadmin.shop_bukken.action.view.AspUpdateView;
import net.chintai.backend.sysadmin.shop_bukken.service.AspAreaPrefInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.AspShopImageService;
import net.chintai.backend.sysadmin.shop_bukken.service.AspUpdateForPrefService;
import net.chintai.backend.sysadmin.shop_bukken.service.AspUpdateService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspAreaPrefInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateOutServiceBean;
import net.chintai.batch.common.domain.ShopRirekiImg;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * 不動産ASP設定更新画面へ遷移するアクション。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspUpdateAction extends BaseActionSupport {

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
        AspUpdateInServiceBean inServiceBean = new AspUpdateInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        AspUpdateService aspUpdateService = (AspUpdateService) ac.getBean("aspUpdateService");

        // 不動産ASP設定情報を取得
        AspUpdateOutServiceBean rsShopInfo =
                aspUpdateService.aspShopInfoSearchByShopCd(inServiceBean);

        // Injection
        AspAreaPrefInfoService aspAreaPrefInfoService =
                (AspAreaPrefInfoService) ac.getBean("aspAreaPrefInfoService");

        // 画面用エリアと都道府県を取得
        List<AspAreaPrefInfoOutServiceBean> aspAreaPrefInfoList =
                aspAreaPrefInfoService.aspAreaPrefInfoSearch();

        // Injection
        AspUpdateForPrefService aspUpdateForPrefService =
                (AspUpdateForPrefService) ac.getBean("aspUpdateForPrefService");

        // 表示用エリア情報に登録されたエリア情報をセットする
        aspAreaPrefInfoList =
                aspUpdateForPrefService.aspAreaRegisteredInfoSearchByShopCd(aspAreaPrefInfoList,
                        inServiceBean);

        // エリアと都道府県をViewHelperに設定
        AspUpdateView view = new AspUpdateView();
        List<AspUpdateView.AspAddPageDetailView> aspAddPageDetailViewList =
                new ArrayList<AspUpdateView.AspAddPageDetailView>();

        for(int i = 0; i < aspAreaPrefInfoList.size(); i++){
            AspAreaPrefInfoOutServiceBean aspAreaPrefInfoOutServiceBean = aspAreaPrefInfoList.get(i);
            AspUpdateView.AspAddPageDetailView aspAddPageDetailView = view.new AspAddPageDetailView();
            BeanUtils.copyProperties(aspAddPageDetailView, aspAreaPrefInfoOutServiceBean);

            aspAddPageDetailViewList.add(aspAddPageDetailView);
        }
        view.setAspAreaPrefInfoList(aspAddPageDetailViewList);

        // 不動産ASP設定情報をViewHelperに設定
        BeanUtils.copyProperties(view, rsShopInfo);
        view.setImgFileType(rsShopInfo.getLogoImageType());

        // 画像マスタサーバーの画像パスを取得するInjectionを設定
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

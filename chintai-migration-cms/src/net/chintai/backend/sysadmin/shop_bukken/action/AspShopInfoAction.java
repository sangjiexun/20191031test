/*
 * $Id: AspShopInfoAction.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.shop_bukken.action.view.AspShopInfoView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.AspShopInfoView.AspGroupListDetailView;
import net.chintai.backend.sysadmin.shop_bukken.service.AspShopImageService;
import net.chintai.backend.sysadmin.shop_bukken.service.AspShopInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoAndAspInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoInServiceBean;
import net.chintai.batch.common.domain.ShopRirekiImg;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 不動産ASP設定情報画面へ遷移するアクション
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspShopInfoAction extends BaseActionSupport {

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
        AspShopInfoService aspShopInfoService =
                (AspShopInfoService) ac.getBean("aspShopInfoService");

        // 不動産ASP設定情報を取得
        AspShopInfoAndAspInfoOutServiceBean rsShopInfo =
                aspShopInfoService.aspShopInfoSearchByShopCd(inServiceBean);

        AspShopInfoView view = new AspShopInfoView();

        // 不動産ASPグループリスト情報取得
        List<AspGroupInfoOutServiceBean> outList = aspShopInfoService.aspGroupList(inServiceBean);
        List<AspGroupListDetailView> groupList = new ArrayList<AspGroupListDetailView>();

        if (outList != null) {
            for (int i = 0; i < outList.size(); i++) {
                AspShopInfoView.AspGroupListDetailView groupDetailView =
                        view.new AspGroupListDetailView();
                BeanUtils.copyProperties(groupDetailView, outList.get(i));
                groupList.add(groupDetailView);
            }
        }
        view.setAspGroupList(groupList);

        // 不動産ASP設定情報をViewHelperに設定
        BeanUtils.copyProperties(view, rsShopInfo);

        // 不動産ASP設定情報(エリア)を設定
        List prefList = rsShopInfo.getPrefList();
        if (prefList != null) {
            List<AspShopInfoView.PrefListDetailView> prefListDetailViewList = new ArrayList<AspShopInfoView.PrefListDetailView>();
            for (int i = 0; i < rsShopInfo.getPrefList().size(); i++) {
                AspShopInfoAndAspInfoOutServiceBean.PrefListDetailView pref = rsShopInfo.getPrefList().get(i);
                AspShopInfoView.PrefListDetailView prefListDetailView = view.new PrefListDetailView();
                BeanUtils.copyProperties(prefListDetailView, pref);
                prefListDetailViewList.add(prefListDetailView);
            }
            view.setPrefList(prefListDetailViewList);
        }

        // 画像マスタ上の画像URLパスを取得。
        if (!"0".equals(rsShopInfo.getLogoFlg())) {
            AspShopImageService aspShopImageService =
                    (AspShopImageService) ac.getBean("aspShopImageService");
            ShopRirekiImg shopRirekiImg = aspShopImageService.getAspShopImage(inServiceBean.getShopCd());
            if (shopRirekiImg != null) {
                view.setImgUrlPath(shopRirekiImg.getImgUrlPath());
                view.setImgFileNm(shopRirekiImg.getImgFileNm());
            }
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

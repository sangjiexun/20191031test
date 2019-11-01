/*
 * $Id: AspUpdateConfirmBackAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.AspUpdateView;
import net.chintai.backend.sysadmin.shop_bukken.service.AspAreaPrefInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.AspShopImageService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspAreaPrefInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.ImageUrlFromMasterServerService;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUrlFromMasterServerInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUrlFromMasterServerOutServiceBean;
import net.chintai.batch.common.domain.ShopRirekiImg;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 不動産ASP設定更新確認の戻るアクション
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspUpdateConfirmBackAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        // 不動産ASP設定情報をViewHelperに設定
        AspUpdateView view = new AspUpdateView();
        BeanUtils.copyProperties(view, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        AspAreaPrefInfoService aspAreaPrefInfoService =
                (AspAreaPrefInfoService) ac.getBean("aspAreaPrefInfoService");

        // エリアと都道府県を取得
        List<AspAreaPrefInfoOutServiceBean> aspAreaPrefInfoList =
                aspAreaPrefInfoService.aspAreaPrefInfoSearch();

        // requestから登録される不動産ASP設定情報を取得
        SortedMap<String, String[]> sortedMap =
                new TreeMap<String, String[]>(context.getRequest().getParameterMap());

        // 入力されたエリアのソートキーを設定。
        for (int i = 0; i < aspAreaPrefInfoList.size(); i++) {
            AspAreaPrefInfoOutServiceBean areaInfo =
                    (AspAreaPrefInfoOutServiceBean) aspAreaPrefInfoList.get(i);
            AspAreaPrefInfoOutServiceBean.AspAreaPrefInfoOutServiceDetailBean prefInfo = null;
            for (int k = 0; k < areaInfo.getPrefList().size(); k++) {
                prefInfo =
                        (AspAreaPrefInfoOutServiceBean.AspAreaPrefInfoOutServiceDetailBean) areaInfo
                                .getPrefList().get(k);
                String mapKey = prefInfo.getPrefCodeName();
                if (sortedMap.containsKey(mapKey)) {
                    String[] prefSortKey = sortedMap.get(mapKey);
                    prefInfo.setPrefSortKey(prefSortKey[0]);
                }
            }
        }

        List<AspUpdateView.AspAddPageDetailView> aspAddPageDetailViewList =
                new ArrayList<AspUpdateView.AspAddPageDetailView>();
        for (int i = 0; i < aspAreaPrefInfoList.size(); i++) {
            AspAreaPrefInfoOutServiceBean aspAreaPrefInfoOutServiceBean = aspAreaPrefInfoList.get(i);
            AspUpdateView.AspAddPageDetailView aspAddPageDetailView = view.new AspAddPageDetailView();
            BeanUtils.copyProperties(aspAddPageDetailView, aspAreaPrefInfoOutServiceBean);

            aspAddPageDetailViewList.add(aspAddPageDetailView);
        }
        view.setAspAreaPrefInfoList(aspAddPageDetailViewList);

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

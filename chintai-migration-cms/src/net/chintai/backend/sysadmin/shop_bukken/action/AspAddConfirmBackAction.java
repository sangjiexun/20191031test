/*
 * $Id: AspAddConfirmBackAction.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.AspAddPageView;
import net.chintai.backend.sysadmin.shop_bukken.service.AspAreaPrefInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspAreaPrefInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 不動産ASP設定情報登録確認の戻るアクション
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspAddConfirmBackAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        //AspAddConfirmInServiceBean inServiceBean = new AspAddConfirmInServiceBean();
        //BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        AspAreaPrefInfoService aspAreaPrefInfoService =
                (AspAreaPrefInfoService) ac.getBean("aspAreaPrefInfoService");

        // エリアと都道府県を取得
        List<AspAreaPrefInfoOutServiceBean> aspAreaPrefInfoList =
                aspAreaPrefInfoService.aspAreaPrefInfoSearch();

        // 登録画面で入力された値をViewHelperに設定
        // エリアと都道府県をViewHelperに設定
        AspAddPageView view = new AspAddPageView();
        BeanUtils.copyProperties(view, form);

        List<AspAddPageView.AspAddPageDetailView> aspAddPageDetailViewList = new ArrayList<AspAddPageView.AspAddPageDetailView>();

        for(int i = 0; i < aspAreaPrefInfoList.size() ; i++){
            AspAreaPrefInfoOutServiceBean aspAreaPrefInfoOutServiceBean = aspAreaPrefInfoList.get(i);

            AspAddPageView.AspAddPageDetailView aspAddPageDetailView = view.new AspAddPageDetailView();
            BeanUtils.copyProperties(aspAddPageDetailView, aspAreaPrefInfoOutServiceBean);

            aspAddPageDetailViewList.add(aspAddPageDetailView);
        }
        view.setAspAreaPrefInfoList(aspAddPageDetailViewList);

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

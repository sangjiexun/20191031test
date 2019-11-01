/*
 * $Id: ShikutyosonClientSettingUpdateAction.java 4786 2014-01-10 01:45:57Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/30     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.dataoutput.action.view.ShikutyosonClientSettingInfoView;
import net.chintai.backend.sysadmin.dataoutput.service.ShikutyosonClientSettingInfoService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstCityOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingInfoInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;


/**
 * 他社データ連携市区町村除外設定更新用Actionクラス
 * @author KAMEDA Takuma
 * @version $Revision: 4786 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonClientSettingUpdateAction extends BaseActionSupport {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.DATA_OUTPUT);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {
        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ShikutyosonClientSettingInfoInServiceBean inServiceBean =
                new ShikutyosonClientSettingInfoInServiceBean();

        BeanUtils.copyProperties(inServiceBean, form);

        // 市区町村検索Injection
        ApplicationContext ac = getWebApplicationContext();
        ShikutyosonClientSettingInfoService shikutyosonService =
                (ShikutyosonClientSettingInfoService) ac.getBean("shikutyosonClientSettingInfoService");

        // 市区町村を検索する。
        List<MstCityOutBean> mstCityList = shikutyosonService.getMstCityList(inServiceBean);

        // viewにセット
        ShikutyosonClientSettingInfoView view = new ShikutyosonClientSettingInfoView();
        BeanUtils.copyProperties(view, inServiceBean);

        // 市区町村検索結果がない場合エラーメッセージを出力する
        if (mstCityList.isEmpty()) {
            context.setError("WARN.M.DATAOUTPUT.0006");

        } else {
            // 他社データ連携データを検索する。
            List<ShikutyosonClientSettingInfoOutServiceBean> rsShikutyosonList =
                shikutyosonService.getShikutyosonClienSettingInfoList(inServiceBean);

            // マップにセット
            Map<String, List<String>> clientsystemTypeMap =
                    new LinkedHashMap<String, List<String>>();
            List<ShikutyosonClientSettingInfoView.ShikutyosonDetailView> ShikutyosonNameList =
                    new ArrayList<ShikutyosonClientSettingInfoView.ShikutyosonDetailView>();

            // 市区町村検索結果分繰り返す
            for (MstCityOutBean mstCity : mstCityList) {
                clientsystemTypeMap.put(mstCity.getCityCd(),
                        ShikutyosonClientSettingUtils.getShikutyosonClientList(rsShikutyosonList, mstCity.getCityCd()));
            }

            // 市区町村検索結果分繰り返す
            for (MstCityOutBean bean : mstCityList) {
                ShikutyosonClientSettingInfoView.ShikutyosonDetailView ShikutyosonDetail =
                        view.new ShikutyosonDetailView();
                BeanUtilsWrapper.copyProperties(ShikutyosonDetail, bean);
                ShikutyosonNameList.add(ShikutyosonDetail);
            }

            view.setShikutyosonSearchList(ShikutyosonNameList);

            view.setClientsystemTypeMap(clientsystemTypeMap);

            view.setPrefName(mstCityList.get(0).getPrefName());

            view.setDcoName(mstCityList.get(0).getDcoName());
        }
        context.setForward("success", view);
    }
}

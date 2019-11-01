/*
 * $Id: EkiClientSettingUpdateAction.java 4777 2014-01-09 08:46:00Z t-kameda $
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
import net.chintai.backend.sysadmin.dataoutput.action.view.EkiClientSettingInfoView;
import net.chintai.backend.sysadmin.dataoutput.service.EkiClientSettingInfoService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingInfoInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingInfoOutServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstEkiOutBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;


/**
 * 他社データ連携駅除外設定更新用Actionクラス
 * @author KAMEDA Takuma
 * @version $Revision: 4777 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class EkiClientSettingUpdateAction extends BaseActionSupport {

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
        EkiClientSettingInfoInServiceBean inServiceBean =
                new EkiClientSettingInfoInServiceBean();

        BeanUtils.copyProperties(inServiceBean, form);

        // 駅検索Injection
        ApplicationContext ac = getWebApplicationContext();
        EkiClientSettingInfoService ekiService =
                (EkiClientSettingInfoService) ac.getBean("ekiClientSettingInfoService");

        // 駅を検索する。
        List<MstEkiOutBean> mstEkiList = ekiService.getMstEkiList(inServiceBean);

        // viewにセット
        EkiClientSettingInfoView view = new EkiClientSettingInfoView();
        BeanUtils.copyProperties(view, inServiceBean);

        // 駅検索結果がない場合エラーメッセージを出力する
        if (mstEkiList.isEmpty()) {
            context.setError("WARN.M.DATAOUTPUT.0005");

        } else {
            // 他社データ連携データを検索する。
            List<EkiClientSettingInfoOutServiceBean> rsEkiList =
                    ekiService.getEkiClienSettingInfoList(inServiceBean);

            // マップにセット
            Map<String, List<String>> clientsystemTypeMap =
                    new LinkedHashMap<String, List<String>>();
            List<EkiClientSettingInfoView.EkiDetailView> ekiNameList =
                    new ArrayList<EkiClientSettingInfoView.EkiDetailView>();

            // 駅検索結果分繰り返す
            for (MstEkiOutBean mstEki : mstEkiList) {
                clientsystemTypeMap.put(mstEki.getEkiCd(),
                        EkiClientSettingUtils.getEkiClientList(rsEkiList, mstEki.getEkiCd()));
            }

            // 駅検索結果分繰り返す
            for (MstEkiOutBean bean : mstEkiList) {
                EkiClientSettingInfoView.EkiDetailView ekiDetail =
                        view.new EkiDetailView();
                BeanUtilsWrapper.copyProperties(ekiDetail, bean);
                ekiNameList.add(ekiDetail);
            }

            view.setEkiNameList(ekiNameList);

            view.setClientsystemTypeMap(clientsystemTypeMap);

        }
        context.setForward("success", view);

    }

}

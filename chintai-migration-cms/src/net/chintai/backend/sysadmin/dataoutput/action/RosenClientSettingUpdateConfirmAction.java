/*
 * $Id: RosenClientSettingUpdateConfirmAction.java 4782 2014-01-10 01:16:38Z t-kameda $
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

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.dataoutput.action.view.RosenClientSettingSearchView;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstEnsenOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSettingSearchInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSettingSearchOutServiceBean;


/**
 * 沿線別データ元除外設定更新確認画面用Action
 * @author KAMEDA Takuma
 * @version $Revision: 4782 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenClientSettingUpdateConfirmAction extends BaseActionSupport {

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
        RosenClientSettingSearchInServiceBean inServiceBean =
                new RosenClientSettingSearchInServiceBean();

        BeanUtils.copyProperties(inServiceBean, form);
        // viewにセット
        RosenClientSettingSearchView view = new RosenClientSettingSearchView();
        BeanUtils.copyProperties(view, inServiceBean);

        // 沿線情報の設定
        List<RosenClientSettingSearchView.RosenOutSettingInfoDetailView> ensenNameList =
            new ArrayList<RosenClientSettingSearchView.RosenOutSettingInfoDetailView>();

        List<MstEnsenOutBean> mstEnsenList = RosenClientSettingUtils.convertMstEnsenList(inServiceBean);

        for (MstEnsenOutBean ensenBean : mstEnsenList){
            RosenClientSettingSearchView.RosenOutSettingInfoDetailView ensenDetail = view.new RosenOutSettingInfoDetailView();
            BeanUtils.copyProperties(ensenDetail, ensenBean);
            ensenNameList.add(ensenDetail);
        }

        // クライアントシステムタイプ情報の設定
        String[] ensenClientList = inServiceBean.getClientsystemTypeArray();

        // 更新画面の情報を取得し、更新確認画面用のBeanに格納
        List<RosenClientSettingSearchOutServiceBean> clientsystemTypeList = RosenClientSettingUtils.convertEnsenClientSystemList(ensenClientList);

        // MAPにセット
        // キー：ensenCd
        // 値：systemclientTypeのリストは、必ず5件はいってる。
        // 1件目crsが出力対象(1)か、出力対象外(0)か,
        // 2件目ansが出力対象(2)か、出力対象外(0)か,
        // 3件目ableが出力対象(3)か、出力対象外(0)か,
        // 4件目magazineが出力対象(4)か、出力対象外(0)か,
        // 5件目campusが出力対象(5)か、出力対象外(0)か,
        Map<String, List<String>> clientsystemTypeMap = new LinkedHashMap<String, List<String>>();
        for (MstEnsenOutBean ensenBean : mstEnsenList){
            clientsystemTypeMap.put(ensenBean.getEnsenCd(), RosenClientSettingUtils.getEnsenClientReverseList(clientsystemTypeList, ensenBean.getEnsenCd()));
        }

        view.setClientsystemTypeMap(clientsystemTypeMap);

        view.setRosenSearchList(ensenNameList);

        context.setForward("success", view);

        // 二重更新防止トークンをセット
        saveToken(context.getRequest());

    }

}

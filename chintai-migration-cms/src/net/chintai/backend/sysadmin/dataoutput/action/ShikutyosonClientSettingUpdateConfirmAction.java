/*
 * $Id: ShikutyosonClientSettingUpdateConfirmAction.java 4787 2014-01-10 02:02:41Z t-kameda $
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
import net.chintai.backend.sysadmin.dataoutput.action.view.ShikutyosonClientSettingInfoView;
import net.chintai.backend.sysadmin.dataoutput.service.ShikutyosonClientSettingInfoService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstCityOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingInfoInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;


/**
 * 市区町村別データ元除外設定更新確認画面用Action
 * @author KAMEDA Takuma
 * @version $Revision: 4787 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonClientSettingUpdateConfirmAction extends BaseActionSupport {

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
        // viewにセット
        ShikutyosonClientSettingInfoView view = new ShikutyosonClientSettingInfoView();
        BeanUtils.copyProperties(view, inServiceBean);

        // 沿線情報の設定
        List<ShikutyosonClientSettingInfoView.ShikutyosonDetailView> shikutyosonNameList =
            new ArrayList<ShikutyosonClientSettingInfoView.ShikutyosonDetailView>();

        List<MstCityOutBean> mstCityList = ShikutyosonClientSettingUtils.convertMstCityList(inServiceBean);

        for (MstCityOutBean cityBean : mstCityList){
            ShikutyosonClientSettingInfoView.ShikutyosonDetailView shikutyosonDetail = view.new ShikutyosonDetailView();
            BeanUtils.copyProperties(shikutyosonDetail, cityBean);
            shikutyosonNameList.add(shikutyosonDetail);
        }

        // クライアントシステムタイプ情報の設定
        String[] shikutyosonClientList = inServiceBean.getClientsystemTypeArray();

        // 更新画面の情報を取得し、更新確認画面用のBeanに格納
        List<ShikutyosonClientSettingInfoOutServiceBean> clientsystemTypeList = ShikutyosonClientSettingUtils.convertShikutyosonClientSystemList(shikutyosonClientList);

        // MAPにセット
        // キー：cityCd
        // 値：systemclientTypeのリストは、必ず5件はいってる。
        // 1件目crsが出力対象(1)か、出力対象外(0)か,
        // 2件目ansが出力対象(2)か、出力対象外(0)か,
        // 3件目ableが出力対象(3)か、出力対象外(0)か,
        // 4件目magazineが出力対象(4)か、出力対象外(0)か,
        // 5件目campusが出力対象(5)か、出力対象外(0)か,
        Map<String, List<String>> clientsystemTypeMap = new LinkedHashMap<String, List<String>>();
        for (MstCityOutBean shikutyosonBean : mstCityList){
            clientsystemTypeMap.put(shikutyosonBean.getCityCd(), ShikutyosonClientSettingUtils.getShikutyosonClientReverseList(clientsystemTypeList, shikutyosonBean.getCityCd()));
        }

        // 親情報(都道府県)の情報を取得し、削除対象があるか判定する
        ApplicationContext ac = getWebApplicationContext();
        ShikutyosonClientSettingInfoService shikutyosonService =
            (ShikutyosonClientSettingInfoService) ac.getBean("shikutyosonClientSettingInfoService");

        List<String> prefClientType = shikutyosonService.getPrefClientTypeList(inServiceBean);

        List<String> parentalTypeList = ClientSettingUtils.getDeliteParentalList(clientsystemTypeMap, prefClientType);

        // 他社データ連携沿線除外設定に削除対象のデータがある場合
        if (!parentalTypeList.isEmpty()){
            String parentalDeleteMsg = ClientSettingUtils.getParentalDeleteMsg(parentalTypeList);
            context.setMessage("INFO.M.DATAOUTPUT.0005", inServiceBean.getPrefName(), parentalDeleteMsg);

            String parentalType = "";

            for (String type : parentalTypeList){
                parentalType = parentalType + type + ",";
            }
            parentalType = parentalType.substring(0, parentalType.length()-1);

            view.setParentalType(parentalType);

        }
        view.setClientsystemTypeMap(clientsystemTypeMap);

        view.setShikutyosonSearchList(shikutyosonNameList);

        context.setForward("success", view);

        // 二重更新防止トークンをセット
        saveToken(context.getRequest());
    }

}

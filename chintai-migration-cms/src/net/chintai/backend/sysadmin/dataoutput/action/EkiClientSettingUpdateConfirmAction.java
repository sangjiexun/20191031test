/*
 * $Id: EkiClientSettingUpdateConfirmAction.java 4779 2014-01-10 00:37:46Z t-kameda $
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
import net.chintai.backend.sysadmin.dataoutput.action.view.EkiClientSettingInfoView;
import net.chintai.backend.sysadmin.dataoutput.service.EkiClientSettingInfoService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingInfoInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingInfoOutServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstEkiOutBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;


/**
 * 他社データ連携駅除外設定更新確認用Actionクラス
 * @author KAMEDA Takuma
 * @version $Revision: 4779 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class EkiClientSettingUpdateConfirmAction extends BaseActionSupport {

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
        // viewにセット
        EkiClientSettingInfoView view = new EkiClientSettingInfoView();
        BeanUtils.copyProperties(view, inServiceBean);

        // 沿線情報の設定
        List<EkiClientSettingInfoView.EkiDetailView> ekiNameList =
            new ArrayList<EkiClientSettingInfoView.EkiDetailView>();

        List<MstEkiOutBean> mstEkiList = EkiClientSettingUtils.convertMstEkiList(inServiceBean);

        for (MstEkiOutBean ekiBean : mstEkiList){
            EkiClientSettingInfoView.EkiDetailView ekiDetail = view.new EkiDetailView();
            BeanUtils.copyProperties(ekiDetail, ekiBean);
            ekiNameList.add(ekiDetail);
        }

        // クライアントシステムタイプ情報の設定
        String[] ekiClientList = inServiceBean.getClientsystemTypeArray();

        // 更新画面の情報を取得し、更新確認画面用のBeanに格納
        List<EkiClientSettingInfoOutServiceBean> clientsystemTypeList = EkiClientSettingUtils.convertEkiClientSystemList(ekiClientList);

        // MAPにセット
        // キー：ekiCd
        // 値：systemclientTypeのリストは、必ず5件はいってる。
        // 1件目crsが出力対象(1)か、出力対象外(0)か,
        // 2件目ansが出力対象(2)か、出力対象外(0)か,
        // 3件目ableが出力対象(3)か、出力対象外(0)か,
        // 4件目magazineが出力対象(4)か、出力対象外(0)か,
        // 5件目campusが出力対象(5)か、出力対象外(0)か,
        Map<String, List<String>> clientsystemTypeMap = new LinkedHashMap<String, List<String>>();
        for (MstEkiOutBean ekiBean : mstEkiList){
            clientsystemTypeMap.put(ekiBean.getEkiCd(), EkiClientSettingUtils.getEkiClientReverseList(clientsystemTypeList, ekiBean.getEkiCd()));
        }

        // 親情報(沿線)の情報を取得し、削除対象があるか判定する
        ApplicationContext ac = getWebApplicationContext();
        EkiClientSettingInfoService ekiService =
            (EkiClientSettingInfoService) ac.getBean("ekiClientSettingInfoService");

        List<String> ensenClientType = ekiService.getEnsenClientTypeList(inServiceBean);

        List<String> parentalTypeList = ClientSettingUtils.getDeliteParentalList(clientsystemTypeMap, ensenClientType);

        // 他社データ連携沿線除外設定に削除対象のデータがある場合
        if (!parentalTypeList.isEmpty()){
            String typeMsg = ClientSettingUtils.getParentalDeleteMsg(parentalTypeList);
            context.setMessage("INFO.M.DATAOUTPUT.0005", inServiceBean.getEnsenName(), typeMsg);
            String parentalType = "";

            for (String type : parentalTypeList){
                parentalType = parentalType + type + ",";
            }
            parentalType = parentalType.substring(0, parentalType.length()-1);

            view.setParentalType(parentalType);

        }
        view.setClientsystemTypeMap(clientsystemTypeMap);

        view.setEkiNameList(ekiNameList);

        context.setForward("success", view);

        // 二重更新防止トークンをセット
        saveToken(context.getRequest());
    }

}

/*
 * $Id: ShikutyosonClientSettingUpdateCommitAction.java 4826 2014-01-15 01:53:16Z t-kameda $
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
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.dataoutput.service.ShikutyosonClientSettingCommitService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstCityOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingCommitInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingInfoInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingInfoOutServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSystemCommitListBean;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;


/**
 * 市区町村別データ元除外設定更新用Action
 * @author KAMEDA Takuma
 * @version $Revision: 4826 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonClientSettingUpdateCommitAction extends BaseActionSupport {

    /** クライアントシステムタイプ用定数("0") */
    private final String TYPECHECK = "0";

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
        // 画面リロード対策
        if (!isTokenValid(context.getRequest())) {
            context.setForward("success");
            return;
        }

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ShikutyosonClientSettingInfoInServiceBean inServiceBean =
                new ShikutyosonClientSettingInfoInServiceBean();

        BeanUtils.copyProperties(inServiceBean, form);

        // クライアントシステムタイプ情報の取得
        String[] shikutyosonClientList = inServiceBean.getClientsystemTypeArray();

        List<MstCityOutBean> mstCityList = ShikutyosonClientSettingUtils.convertMstCityList(inServiceBean);

        List<ShikutyosonClientSettingInfoOutServiceBean> clientsystemTypeList = ShikutyosonClientSettingUtils.convertShikutyosonClientSystemList(shikutyosonClientList);

        Map<String, List<String>> clientsystemTypeMap = new LinkedHashMap<String, List<String>>();
        for (MstCityOutBean cityBean : mstCityList){
            clientsystemTypeMap.put(cityBean.getCityCd(), ShikutyosonClientSettingUtils.getShikutyosonClientReverseList(clientsystemTypeList, cityBean.getCityCd()));
        }

        String userId = context.getSessionBean().getUserId();
        String dcoType = inServiceBean.getDcoType();
        String prefCd = inServiceBean.getPref();

        List<ShikutyosonClientSystemCommitListBean> commitList = setCommitList(clientsystemTypeMap,userId,dcoType,prefCd);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ShikutyosonClientSettingCommitService commitService = (ShikutyosonClientSettingCommitService) ac.getBean("shikutyosonClientSettingCommitService");

        OperationLoggingService loggingService =
            (OperationLoggingService) ac.getBean("operationLoggingService");

        // 登録、削除用のパラメータ用Beanを設定
        ShikutyosonClientSettingCommitInServiceBean commitInServiceBean = new ShikutyosonClientSettingCommitInServiceBean();
        commitInServiceBean.setCommitList(commitList);
        commitInServiceBean.setDcoType(dcoType);
        commitInServiceBean.setPrefCd(prefCd);
        commitInServiceBean.setCityCd(inServiceBean.getCity());

        // 他社データ連携沿線除外設定の削除が必要な場合、削除用パラメータを設定する
        if (StringUtils.isNotEmpty(inServiceBean.getParentalType())){
            commitInServiceBean.setParentalType(inServiceBean.getParentalType());
        }

        try {
            // 削除、登録処理
            commitService.cityClientSettingCommit(commitInServiceBean);

            // 操作ログ記録
            loggingService.write("19003", context.getSessionBean().getUserId(), SessionStatus.SUCCESS,"", this.getClass().getName());

            // メッセージ設定
            context.setMessage("INFO.M.DATAOUTPUT.0006", ApplicationResources.getProperty("dataoutput.ShikutyousonClientSetting"));

            context.setForward("success");

        } catch (Exception e) {
            // 操作ログ記録
            loggingService.write("19003", context.getSessionBean().getUserId(), SessionStatus.FAILURE, "", this.getClass().getName());

            throw e;
        }
        // 二重更新防止トークンをセット
        saveToken(context.getRequest());
    }

    /**
     * DB登録用にform情報をDB登録用beanに格納する処理
     * @param clientsystemTypeMap
     * @param userId
     * @param dcotype
     * @param prefCd
     * @return
     */
    private List<ShikutyosonClientSystemCommitListBean> setCommitList(Map<String, List<String>> clientsystemTypeMap, String userId, String dcoType, String prefCd) {

        String className = this.getClass().getName();

        List<ShikutyosonClientSystemCommitListBean> commitList = new ArrayList<ShikutyosonClientSystemCommitListBean>();

        for (String cityCd :clientsystemTypeMap.keySet()) {

            List<String> clientsystemTypeList = clientsystemTypeMap.get(cityCd);

            for (int i=0; i<clientsystemTypeList.size(); i++) {

                String clientsystemType = clientsystemTypeList.get(i);

                // insert対象データ（画面でチェックされていないもの = クライアントシステムタイプが0）
                if (clientsystemType.equals(TYPECHECK)) {
                    ShikutyosonClientSystemCommitListBean commitBean = new ShikutyosonClientSystemCommitListBean();
                    commitBean.setPrefCd(prefCd);
                    commitBean.setCityCd(cityCd);
                    commitBean.setClientsystemType(String.valueOf(i+1)); // クライアントシステムタイプは(1～5) なんでプラス1するかというと配列の添え字が0からなので
                    commitBean.setPgName(className);
                    commitBean.setUserId(userId);
                    commitBean.setDcoType(dcoType);

                    commitList.add(commitBean);
                }
            }
        }
        return commitList;
    }


}

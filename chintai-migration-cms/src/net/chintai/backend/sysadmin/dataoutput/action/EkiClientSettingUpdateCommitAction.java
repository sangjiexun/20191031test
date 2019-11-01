/*
 * $Id: EkiClientSettingUpdateCommitAction.java 4778 2014-01-09 08:51:21Z t-kameda $
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
import net.chintai.backend.sysadmin.dataoutput.service.EkiClientSettingCommitService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingCommitInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingInfoInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingInfoOutServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSystemCommitListBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstEkiOutBean;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;


/**
 * 他社データ連携駅除外設定更新処理用Actionクラス
 * @author KAMEDA Takuma
 * @version $Revision: 4778 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class EkiClientSettingUpdateCommitAction extends BaseActionSupport {

    /** クライアントシステムタイプが0 */
    private String typeCheck = "0";

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
        EkiClientSettingInfoInServiceBean inServiceBean =
                new EkiClientSettingInfoInServiceBean();

        BeanUtils.copyProperties(inServiceBean, form);

        // クライアントシステムタイプ情報の取得
        String[] ekiClientList = inServiceBean.getClientsystemTypeArray();

        List<MstEkiOutBean> mstEkiList = EkiClientSettingUtils.convertMstEkiList(inServiceBean);

        List<EkiClientSettingInfoOutServiceBean> clientsystemTypeList = EkiClientSettingUtils.convertEkiClientSystemList(ekiClientList);

        Map<String, List<String>> clientsystemTypeMap = new LinkedHashMap<String, List<String>>();
        for (MstEkiOutBean ekiBean : mstEkiList){
            clientsystemTypeMap.put(ekiBean.getEkiCd(), EkiClientSettingUtils.getEkiClientReverseList(clientsystemTypeList, ekiBean.getEkiCd()));
        }

        String userId = context.getSessionBean().getUserId();
        String dcoType = inServiceBean.getDcoType();
        String ensenCd = inServiceBean.getEnsenCd();

        List<EkiClientSystemCommitListBean> commitList = setCommitList(clientsystemTypeMap,userId,dcoType,ensenCd);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        EkiClientSettingCommitService commitService = (EkiClientSettingCommitService) ac.getBean("ekiClientSettingCommitService");

        OperationLoggingService loggingService =
            (OperationLoggingService) ac.getBean("operationLoggingService");

        // 登録、削除用のパラメータ用Beanを設定
        EkiClientSettingCommitInServiceBean commitInServiceBean = new EkiClientSettingCommitInServiceBean();
        commitInServiceBean.setCommitList(commitList);
        commitInServiceBean.setDcoType(dcoType);
        commitInServiceBean.setEnsenCd(ensenCd);

        // 他社データ連携沿線除外設定の削除が必要な場合、削除用パラメータを設定する
        if (StringUtils.isNotEmpty(inServiceBean.getParentalType())){
            commitInServiceBean.setParentalType(inServiceBean.getParentalType());
        }

        try {
            // 削除、登録処理
            commitService.ekiClientSettingCommit(commitInServiceBean);

            // 操作ログ記録
            loggingService.write("19005", context.getSessionBean().getUserId(), SessionStatus.SUCCESS,"", this.getClass().getName());

            // メッセージ設定
            context.setMessage("INFO.M.DATAOUTPUT.0004", ApplicationResources.getProperty("dataoutput.EkiClientSetting"));

            context.setForward("success");

        } catch (Exception e) {
            // 操作ログ記録
            loggingService.write("19005", context.getSessionBean().getUserId(), SessionStatus.FAILURE, "", this.getClass().getName());

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
     * @param ensenCd
     * @return commitList
     */
    private List<EkiClientSystemCommitListBean> setCommitList(Map<String, List<String>> clientsystemTypeMap, String userId, String dcoType, String ensenCd) {

        String className = this.getClass().getName();

        List<EkiClientSystemCommitListBean> commitList = new ArrayList<EkiClientSystemCommitListBean>();

        for (String ekiCd :clientsystemTypeMap.keySet()) {

            List<String> clientsystemTypeList = clientsystemTypeMap.get(ekiCd);

            for (int i=0; i<clientsystemTypeList.size(); i++) {

                String clientsystemType = clientsystemTypeList.get(i);

                // insert対象データ（画面でチェックされていないもの = クライアントシステムタイプが0）
                if (clientsystemType.equals(typeCheck)) {
                    EkiClientSystemCommitListBean commitBean = new EkiClientSystemCommitListBean();
                    commitBean.setEnsenCd(ensenCd);
                    commitBean.setEkiCd(ekiCd);
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

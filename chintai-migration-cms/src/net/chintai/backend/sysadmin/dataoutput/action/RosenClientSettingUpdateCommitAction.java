/*
 * $Id: RosenClientSettingUpdateCommitAction.java 4825 2014-01-15 01:51:11Z t-kameda $
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
import net.chintai.backend.sysadmin.dataoutput.service.RosenClientSettingCommitService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstEnsenOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSettingCommitInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSettingSearchInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSettingSearchOutServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSystemCommitListBean;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;


/**
 * 沿線別データ元除外設定更新用Action
 * @author KAMEDA Takuma
 * @version $Revision: 4825 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenClientSettingUpdateCommitAction extends BaseActionSupport {

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
        RosenClientSettingSearchInServiceBean inServiceBean =
                new RosenClientSettingSearchInServiceBean();

        BeanUtils.copyProperties(inServiceBean, form);

        // クライアントシステムタイプ情報の取得
        String[] ensenClientList = inServiceBean.getClientsystemTypeArray();

        List<MstEnsenOutBean> mstEnsenList = RosenClientSettingUtils.convertMstEnsenList(inServiceBean);

        List<RosenClientSettingSearchOutServiceBean> clientsystemTypeList = RosenClientSettingUtils.convertEnsenClientSystemList(ensenClientList);

        Map<String, List<String>> clientsystemTypeMap = new LinkedHashMap<String, List<String>>();
        for (MstEnsenOutBean ensenBean : mstEnsenList){
            clientsystemTypeMap.put(ensenBean.getEnsenCd(), RosenClientSettingUtils.getEnsenClientReverseList(clientsystemTypeList, ensenBean.getEnsenCd()));
        }

        String userId = context.getSessionBean().getUserId();
        String dcoType = inServiceBean.getDcoType();
        List<RosenClientSystemCommitListBean> commitList = setCommitList(clientsystemTypeMap,userId,dcoType);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        RosenClientSettingCommitService commitService = (RosenClientSettingCommitService) ac.getBean("rosenClientSettingCommitService");

        OperationLoggingService loggingService =
            (OperationLoggingService) ac.getBean("operationLoggingService");

        RosenClientSettingCommitInServiceBean commitInServiceBean = new RosenClientSettingCommitInServiceBean();
        commitInServiceBean.setCommitList(commitList);
        commitInServiceBean.setDcoType(dcoType);
        commitInServiceBean.setAreaCd(inServiceBean.getAreaCd());
        commitInServiceBean.setEnsenType(inServiceBean.getEnsenType());

        try {
            commitService.rosenClientSettingCommit(commitInServiceBean);

            // 操作ログ記録
            loggingService.write("19004", context.getSessionBean().getUserId(), SessionStatus.SUCCESS,"", this.getClass().getName());

            // メッセージ設定
            context.setMessage("INFO.M.DATAOUTPUT.0003", ApplicationResources.getProperty("dataoutput.EnsenClientSetting"));

            context.setForward("success");

        } catch (Exception e) {
            // 操作ログ記録
            loggingService.write("19004", context.getSessionBean().getUserId(), SessionStatus.FAILURE, "", this.getClass().getName());

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
     * @return
     */
    private List<RosenClientSystemCommitListBean> setCommitList(Map<String, List<String>> clientsystemTypeMap, String userId, String dcoType) {

        String className = this.getClass().getName();

        List<RosenClientSystemCommitListBean> commitList = new ArrayList<RosenClientSystemCommitListBean>();

        for (String ensenCd :clientsystemTypeMap.keySet()) {

            List<String> clientsystemTypeList = clientsystemTypeMap.get(ensenCd);

            for (int i=0; i<clientsystemTypeList.size(); i++) {

                String clientsystemType = clientsystemTypeList.get(i);

                // insert対象データ（画面でチェックされていないもの = クライアントシステムタイプが0）
                if (clientsystemType.equals(typeCheck)) {
                    RosenClientSystemCommitListBean commitBean = new RosenClientSystemCommitListBean();
                    commitBean.setEnsenCd(ensenCd);
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

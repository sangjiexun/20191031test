/*
 * $Id: PrefClientupdateCommitAction.java 4738 2013-11-05 08:42:25Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/23     BGT)亀田       E-0070 建物名表示に関する改修
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
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.dataoutput.action.view.PrefClientUpdateBean;
import net.chintai.backend.sysadmin.dataoutput.service.PrefClientUpdateCommitService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstPrefOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.PrefClientDataOutServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.PrefClientSettingInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.PrefClientSystemCommitInServiceBean;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

import org.apache.struts.action.DynaActionForm;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;


/**
 * 都道府県別データ元出力設定の更新Action
 *
 * @author e-ishii
 * @version $Revision: 4738 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefClientupdateCommitAction extends BaseActionSupport {

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
        resetToken(context.getRequest());

        DynaActionForm form = (DynaActionForm) context.getForm();

        PrefClientUpdateBean formBean = new PrefClientUpdateBean();
        BeanUtilsWrapper.copyProperties(formBean, form);

        // クライアントシステム情報取得
        String[] formPrefClientList = formBean.getClientsystemTypeArray();

        // hiddenでもってる都道府県情報取得
        List<MstPrefOutBean> mstPrefList = PrefClientUtils.convertMstPrefList(formBean);


        List<PrefClientDataOutServiceBean> formClientsystemTypeList = PrefClientUtils.convertClientSystemList(formPrefClientList);
        Map<String, List<String>> clientsystemTypeMap = new LinkedHashMap<String, List<String>>();
        // MAPにセット
        // キー：prefcd  値：systemclientTypeのリスト
        for (MstPrefOutBean mstPref : mstPrefList) {
            clientsystemTypeMap.put(mstPref.getPrefcd(),
                                   PrefClientUtils.getClientReverseList(formClientsystemTypeList, mstPref.getPrefcd()));
        }

        String userId = context.getSessionBean().getUserId();
        // 登録用リスト作成処理の引数にdcoTypeを追加 2013/10/24 追加
        String dcoType = formBean.getDcoType();
        List<PrefClientSystemCommitInServiceBean> commitList = setCommitList(clientsystemTypeMap,userId,dcoType );

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        PrefClientUpdateCommitService commitService = (PrefClientUpdateCommitService) ac.getBean("prefClientUpdateCommitService");

        OperationLoggingService loggingService =
            (OperationLoggingService) ac.getBean("operationLoggingService");

        // 登録処理の引数をinServiceBeanに変更 2013/10/24 追加
        PrefClientSettingInServiceBean inServiceBean = new PrefClientSettingInServiceBean();
        inServiceBean.setDcoType(formBean.getDcoType());
        inServiceBean.setCommitList(commitList);

        try{
            commitService.prefClientUpdateCommit(inServiceBean);

            // 操作ログ記録
            loggingService.write("19001", context.getSessionBean().getUserId(), SessionStatus.SUCCESS,"", this.getClass().getName());

            // メッセージ設定
            context.setMessage("INFO.M.DATAOUTPUT.0001", ApplicationResources.getProperty("dataoutput.PrefclientSetting"));

            context.setForward("success");

        } catch (DataAccessException e) {
            // 操作ログ記録
            loggingService.write("19001", context.getSessionBean().getUserId(), SessionStatus.FAILURE, "", this.getClass().getName());

            throw e;

        }
        // 二重更新防止トークンをセット
        saveToken(context.getRequest());

    }

    /**
     * DB登録用にform情報をDB登録用beanに格納する処理
     * 引数にdcotypeを追加 2013/10/24
     * @param clientsystemTypeMap
     * @param userId
     * @param dcotype
     * @return
     */
    private List<PrefClientSystemCommitInServiceBean> setCommitList(Map<String, List<String>> clientsystemTypeMap, String userId, String dcoType) {

        String className = this.getClass().getName();

        List<PrefClientSystemCommitInServiceBean> commitList = new ArrayList<PrefClientSystemCommitInServiceBean>();

        for (String prefcd :clientsystemTypeMap.keySet()) {

            List<String> clientsystemTypeList = clientsystemTypeMap.get(prefcd);

            for (int i=0; i<clientsystemTypeList.size(); i++) {

                String clientsystemType = clientsystemTypeList.get(i);

                // insert対象データ（画面でチェックされていないもの = クライアントシステムタイプが0）
                if (clientsystemType.equals(typeCheck)) {
                    PrefClientSystemCommitInServiceBean commitBean = new PrefClientSystemCommitInServiceBean();
                    commitBean.setPrefcd(prefcd);
                    commitBean.setClientsystemType(String.valueOf(i+1)); // クライアントシステムタイプは(1～5) なんでプラス1するかというと配列の添え字が0からなので
                    commitBean.setPgName(className);
                    commitBean.setUserId(userId);
                    // 登録用BeanにdcoTypeを追加 2013/10/24 追加
                    commitBean.setDcoType(dcoType);

                    commitList.add(commitBean);
                }
            }
        }
        return commitList;
    }
}

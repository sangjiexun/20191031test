/*
 * $Id: PrefClientUpdateConfirmAction.java 4780 2014-01-10 00:42:26Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/24     BGT)亀田       E-0070 建物名表示に関する改修
 *
 */
package net.chintai.backend.sysadmin.dataoutput.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.apache.struts.action.DynaActionForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.dataoutput.action.view.PrefClientSettingInfoView;
import net.chintai.backend.sysadmin.dataoutput.action.view.PrefClientUpdateBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstPrefOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.PrefClientDataOutServiceBean;



/**
 * 都道府県別データ元出力設定更新確認画面表示Action
 *
 * @author e-ishii
 * @version $Revision: 4780 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefClientUpdateConfirmAction extends BaseActionSupport {

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

        DynaActionForm form = (DynaActionForm) context.getForm();

        PrefClientUpdateBean formBean = new PrefClientUpdateBean();
        BeanUtilsWrapper.copyProperties(formBean, form);

        PrefClientSettingInfoView view = new PrefClientSettingInfoView();

        List<PrefClientSettingInfoView.PrefDetailView> prefNameList = new ArrayList<PrefClientSettingInfoView.PrefDetailView>();

        // *********************
        // 都道府県情報のセット
        // *********************
        List<MstPrefOutBean> mstPrefList = PrefClientUtils.convertMstPrefList(formBean);

        for (MstPrefOutBean bean :mstPrefList) {
            PrefClientSettingInfoView.PrefDetailView prefDetail = view.new PrefDetailView();
            BeanUtilsWrapper.copyProperties(prefDetail, bean);
            prefNameList.add(prefDetail);
        }
        view.setPrefNameList(prefNameList);


        // *********************
        // クライアントシステムタイプ情報のセット
        // *********************
        String[] formPrefClientList = formBean.getClientsystemTypeArray();

        // 更新画面の情報を取得し、更新確認画面用のBeanに格納
        List<PrefClientDataOutServiceBean> clientsystemTypeList = PrefClientUtils.convertClientSystemList(formPrefClientList);


        // MAPにセット
        // キー：prefcd
        // 値：systemclientTypeのリストは、必ず5件はいってる。
        // 1件目crsが出力対象(1)か、出力対象外(0)か,
        // 2件目ansが出力対象(2)か、出力対象外(0)か,
        // 3件目ableが出力対象(3)か、出力対象外(0)か,
        // 4件目magazineが出力対象(4)か、出力対象外(0)か,
        // 5件目campusが出力対象(5)か、出力対象外(0)か,
        Map<String, List<String>> clientsystemTypeMap = new LinkedHashMap<String, List<String>>();
        for (MstPrefOutBean mstPref : mstPrefList) {
            clientsystemTypeMap.put(mstPref.getPrefcd(),
                                   PrefClientUtils.getClientReverseList(clientsystemTypeList, mstPref.getPrefcd()));
        }

        view.setClientsystemTypeMap(clientsystemTypeMap);
        // viewにdcotypeを設定 2013/10/24 追加
        view.setDcoType(formBean.getDcoType());

        view.setDcoName(formBean.getDcoName());

        context.setForward("success",view);

        // 二重更新防止トークンをセット
        saveToken(context.getRequest());

    }

}

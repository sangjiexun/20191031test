/*
 * $Id: PrefClientUpdatePageAction.java 4780 2014-01-10 00:42:26Z t-kameda $
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
import net.chintai.backend.sysadmin.dataoutput.service.PrefClientSettingService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstPrefOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.PrefClientDataOutServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.PrefClientSettingInServiceBean;


/**
 * 都道府県別データ元出力設定更新画面表示Action
 * @author e-ishii
 * @version $Revision: 4780 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefClientUpdatePageAction extends BaseActionSupport {

    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.DATA_OUTPUT);
    }

    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 選択されたdcoTypeを保持するためformを取得 2013/10/24 追加
        DynaActionForm form = (DynaActionForm) context.getForm();

        PrefClientUpdateBean formBean = new PrefClientUpdateBean();
        BeanUtilsWrapper.copyProperties(formBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        PrefClientSettingService prefClientSettingService = (PrefClientSettingService) ac.getBean("prefClientSettingService");

        // DBから対象外のデータを抽出
        // 選択されたdcoTypeでDBから他社データ連携都道府県除外設定情報を取得 2013/10/24 修正 引数にformBeanを設定
        PrefClientSettingInServiceBean inServiceBean = new PrefClientSettingInServiceBean();
        inServiceBean.setDcoType(formBean.getDcoType());
        List<PrefClientDataOutServiceBean> clientSystemTypeDataList = prefClientSettingService.getPrefClientDataList(inServiceBean);

        // MstPrefから全件取得
        List<MstPrefOutBean> mstPrefList = prefClientSettingService.getMstPref(inServiceBean);

        PrefClientSettingInfoView view = new PrefClientSettingInfoView();
        Map<String, List<String>> clientsystemTypeMap = new LinkedHashMap<String, List<String>>();

        for (MstPrefOutBean mstPref : mstPrefList) {
            clientsystemTypeMap.put(mstPref.getPrefcd(), PrefClientUtils.getClientList(clientSystemTypeDataList, mstPref.getPrefcd()));
        }

        List<PrefClientSettingInfoView.PrefDetailView> prefNameList = new ArrayList<PrefClientSettingInfoView.PrefDetailView>();
        for (MstPrefOutBean bean :mstPrefList) {
            PrefClientSettingInfoView.PrefDetailView prefDetail = view.new PrefDetailView();
            BeanUtilsWrapper.copyProperties(prefDetail, bean);
            prefNameList.add(prefDetail);
        }

        view.setPrefNameList(prefNameList);
        view.setClientsystemTypeMap(clientsystemTypeMap);
        // viewにdcoTypeを設定 2013/10/24 追加
        view.setDcoType(formBean.getDcoType());

        view.setDcoName(mstPrefList.get(0).getDcoName());

        context.setForward("success",view);
    }

}

/*
 * $Id: RosenClientSettingSearchAction.java 4781 2014-01-10 00:59:33Z t-kameda $
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
import net.chintai.backend.sysadmin.dataoutput.action.view.RosenClientSettingSearchView;
import net.chintai.backend.sysadmin.dataoutput.service.RosenClientSettingSearchService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstEnsenOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSettingSearchInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSettingSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 他社データ連携、沿線検索Action
 * @author KAMEDA Takuma
 * @version $Revision: 4781 $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenClientSettingSearchAction extends BaseActionSupport {

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

        // 沿線検索Injection
        ApplicationContext ac = getWebApplicationContext();
        RosenClientSettingSearchService rosenService =
                (RosenClientSettingSearchService) ac.getBean("rosenClientSettingSearchService");

        // 沿線を検索する。
        List<MstEnsenOutBean> mstEnsenList = rosenService.getMstEnsen(inServiceBean);

        // viewにセット
        RosenClientSettingSearchView view = new RosenClientSettingSearchView();
        BeanUtils.copyProperties(view, inServiceBean);

        // 沿線検索結果がない場合エラーメッセージを出力する
        if (mstEnsenList.isEmpty()) {
            context.setError("WARN.M.DATAOUTPUT.0004");

        } else {
            // 他社データ連携データを検索する。
            List<RosenClientSettingSearchOutServiceBean> rsRosenList =
                    rosenService.getRosenOutSetingList(inServiceBean);

            // マップにセット
            Map<String, List<String>> clientsystemTypeMap =
                    new LinkedHashMap<String, List<String>>();
            List<RosenClientSettingSearchView.RosenOutSettingInfoDetailView> ensenNameList =
                    new ArrayList<RosenClientSettingSearchView.RosenOutSettingInfoDetailView>();

            // 沿線検索結果分繰り返す
            for (MstEnsenOutBean mstEnsen : mstEnsenList) {
                clientsystemTypeMap.put(mstEnsen.getEnsenCd(),
                        RosenClientSettingUtils.getEnsenClientList(rsRosenList, mstEnsen.getEnsenCd()));
            }

            // 沿線検索結果分繰り返す
            for (MstEnsenOutBean bean : mstEnsenList) {
                RosenClientSettingSearchView.RosenOutSettingInfoDetailView ensenDetail =
                        view.new RosenOutSettingInfoDetailView();
                BeanUtilsWrapper.copyProperties(ensenDetail, bean);
                ensenNameList.add(ensenDetail);
            }

            view.setRosenSearchList(ensenNameList);

            view.setClientsystemTypeMap(clientsystemTypeMap);

            view.setAreaName(mstEnsenList.get(0).getAreaName());

            view.setDcoName(mstEnsenList.get(0).getDcoName());
        }
        context.setForward("success", view);
    }
}

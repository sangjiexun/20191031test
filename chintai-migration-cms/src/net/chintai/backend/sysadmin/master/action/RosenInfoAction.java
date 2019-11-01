/*
 * $Id: RosenInfoAction.java 4027 2008-10-30 06:25:26Z m-ono $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/12  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.master.action.view.RosenInfoView;
import net.chintai.backend.sysadmin.master.service.RosenInfoSearchByEnsenCdService;
import net.chintai.backend.sysadmin.master.service.bean.RosenInfoInServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.RosenInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 沿線詳細画面に遷移するアクション。
 *
 * @author Sim-JongYeon
 * @version $Revision: 4027 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class RosenInfoAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        RosenInfoInServiceBean inServiceBean = new RosenInfoInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // 沿線詳細検索Injection
        ApplicationContext ac = getWebApplicationContext();
        RosenInfoSearchByEnsenCdService rosenInfoSearchByEnsenCdService =
                (RosenInfoSearchByEnsenCdService) ac.getBean("rosenInfoSearchByEnsenCdService");

        // 沿線詳細を検索する。
        List<RosenInfoOutServiceBean> rsRosenInfoList = null;
        rsRosenInfoList = rosenInfoSearchByEnsenCdService.rosenSearchByAreaCdRosenType(inServiceBean);

        // ViewHelper 設定用リストを生成。
        RosenInfoView rosenInfo = new RosenInfoView();
        List<RosenInfoView.RosenInfoDetailView> rosenDetailList = new ArrayList<RosenInfoView.RosenInfoDetailView>();

        // 検索された沿線詳細をviewHelper設定用リスト化する。
        for (int i = 0; i < rsRosenInfoList.size(); i++) {
            RosenInfoOutServiceBean rosenInfoOutServiceBean = (RosenInfoOutServiceBean) rsRosenInfoList.get(i);

            // リスト項目はinnerClassで処理
            RosenInfoView.RosenInfoDetailView rosenInfoDetail = rosenInfo.new RosenInfoDetailView();
            BeanUtils.copyProperties(rosenInfoDetail, rosenInfoOutServiceBean);

            rosenDetailList.add(rosenInfoDetail);
        }

        // ViewHelperを設定。
        RosenInfoView view = new RosenInfoView();
        view.setRosenInfoList(rosenDetailList);
        view.setEnsenType((String) form.get("ensenType"));
        view.setEnsenName((String) form.get("ensenName"));
        view.setAreaName((String) form.get("areaName"));
        view.setEnsenKana((String) form.get("ensenKana"));
        view.setEnsenSeq((String) form.get("ensenSeq"));
        view.setRailwaycoName((String) form.get("railwaycoName"));
        view.setAreaCd((String) form.get("areaCd"));
        view.setEnsennameShort((String) form.get("ensennameShort"));
        view.setEnsenkanaShort((String) form.get("ensenkanaShort"));

        context.setForward("success", view);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.MASTER);
    }

}

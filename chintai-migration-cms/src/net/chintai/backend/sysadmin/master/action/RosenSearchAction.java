/*
 * $Id: RosenSearchAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.master.action.view.RosenSearchView;
import net.chintai.backend.sysadmin.master.service.RosenSearchByAreaCdRosenTypeService;
import net.chintai.backend.sysadmin.master.service.bean.RosenSearchInServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.RosenSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 沿線・駅検索結果画面に遷移するアクション。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenSearchAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        RosenSearchInServiceBean inServiceBean = new RosenSearchInServiceBean();
        String searchFlg = form.getString("searchFlg");

        // 検索画面に戻るための検索条件格納
        if (searchFlg.equals("1")) {
            BeanUtils.copyProperties(inServiceBean, form);
            context.getSessionBean().getSearchConditionMap().put(SessionSearchKey.MASTER_ROSEN_SEARCH, inServiceBean);
        } else {
            inServiceBean =
                    (RosenSearchInServiceBean) context.getSessionBean().getSearchConditionMap().get(
                            SessionSearchKey.MASTER_ROSEN_SEARCH);
        }

        // 沿線検索Injection
        ApplicationContext ac = getWebApplicationContext();
        RosenSearchByAreaCdRosenTypeService rosenSearchService =
                (RosenSearchByAreaCdRosenTypeService) ac.getBean("rosenSearchByAreaCdRosenTypeService");

        // 沿線を検索する。
        List<RosenSearchOutServiceBean> rsRosenList = null;
        rsRosenList = rosenSearchService.rosenSearchByAreaCdRosenType(inServiceBean);

        // ViewHelper 設定用リストを生成。
        RosenSearchView rosenInfo = new RosenSearchView();
        List<RosenSearchView.RosenSearchDetailView> rosenDetailList =
                new ArrayList<RosenSearchView.RosenSearchDetailView>();

        if (rsRosenList == null || rsRosenList.size() == 0) {
            context.setError("WARN.M.MASTER.0013");
        } else {
            // 検索された沿線一覧をviewHelper設定用リスト化する。
            for (int i = 0; i < rsRosenList.size(); i++) {
                RosenSearchOutServiceBean rosenSearchOutServiceBean = (RosenSearchOutServiceBean) rsRosenList.get(i);

                // リスト項目はinnerClassで処理
                RosenSearchView.RosenSearchDetailView rosenDetail = rosenInfo.new RosenSearchDetailView();
                BeanUtils.copyProperties(rosenDetail, rosenSearchOutServiceBean);

                rosenDetailList.add(rosenDetail);
            }
        }

        // ViewHelperを設定。
        RosenSearchView view = new RosenSearchView();
        view.setRosenSearchList(rosenDetailList);
        view.setAreaCd((String) form.get("areaCd"));
        view.setEnsenType((String) form.get("ensenType"));

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

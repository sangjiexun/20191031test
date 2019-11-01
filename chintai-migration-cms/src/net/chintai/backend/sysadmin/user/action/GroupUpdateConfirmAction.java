/*
 * $Id: GroupUpdateConfirmAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/19  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.user.action.view.GroupUpdateConfirmPageView;
import net.chintai.backend.sysadmin.user.service.AuthorityListService;
import net.chintai.backend.sysadmin.user.service.bean.AuthorityListOutServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.GroupUpdateConfirmPageInService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * グループ設定変更確認を表示するアクションクラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupUpdateConfirmAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.USER);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        GroupUpdateConfirmPageInService inServiceBean = new GroupUpdateConfirmPageInService();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        AuthorityListService authorityList =
                (AuthorityListService) ac.getBean("authorityListService");
        
        // グループの権限一覧取得
        List rsAuthorityList = authorityList.getAuthorityList();

        GroupUpdateConfirmPageView authorityInfo = new GroupUpdateConfirmPageView();
        List<GroupUpdateConfirmPageView.GroupByAuthorityDetailView> groupByAuthorityList =
                new ArrayList<GroupUpdateConfirmPageView.GroupByAuthorityDetailView>();

        for (int j = 0; j < inServiceBean.getAuthorityId().length; j++) {
            String authorityId = (String) inServiceBean.getAuthorityId()[j];

            for (int i = 0; i < rsAuthorityList.size(); i++) {
                AuthorityListOutServiceBean nls =
                        (AuthorityListOutServiceBean) rsAuthorityList.get(i);

                // リスト項目はinnerClassで処理
                if (authorityId.equals(nls.getAuthorityId())) {
                    GroupUpdateConfirmPageView.GroupByAuthorityDetailView authorityDetail =
                            authorityInfo.new GroupByAuthorityDetailView();
                    BeanUtils.copyProperties(authorityDetail, nls);

                    groupByAuthorityList.add(authorityDetail);
                }
            }
        }

        GroupUpdateConfirmPageView view = new GroupUpdateConfirmPageView();
        view.setGroupId(inServiceBean.getGroupId());
        view.setGroupName(inServiceBean.getGroupName());
        view.setGroupUpdDt(inServiceBean.getGroupUpdDt());
        view.setGroupByAuthorityList(groupByAuthorityList);

        // 二重更新防止トークンをセット
        saveToken(context.getRequest());

        context.setForward("success", view);

    }

}

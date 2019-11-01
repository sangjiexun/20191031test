/*
 * $Id: GroupDeleteConfirmPageBackAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.user.action.view.GroupListView;
import net.chintai.backend.sysadmin.user.service.GroupListService;
import net.chintai.backend.sysadmin.user.service.bean.AuthorityListOutServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.GroupDeleteConfirmPageBackInServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.GroupListOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * グループ一覧を表示するアクションクラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupDeleteConfirmPageBackAction extends BaseActionSupport {

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

        GroupDeleteConfirmPageBackInServiceBean inServiceBean = new GroupDeleteConfirmPageBackInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        GroupListService groupListService = (GroupListService) ac.getBean("groupListService");

        // グループ一覧取得
        List rsGroupList = groupListService.getGroupList();

        // グループの権限一覧取得
        List rsAuthorityList = groupListService.getAuthorityList();

        // グループ一覧のviewHelper設定
        List<GroupListView.GroupDetailView> groupDetailList = new ArrayList<GroupListView.GroupDetailView>();

        GroupListView groupInfo = new GroupListView();
        GroupListView.GroupDetailView groupDetailInfo = null;
        GroupListView.GroupDetailView.GroupByAuthorityView groupByAuthority = null;
        String previousGroupId = "";

        for (int i = 0; i < rsGroupList.size(); i++) {
            GroupListOutServiceBean nlsGroupList = (GroupListOutServiceBean) rsGroupList.get(i);

            if (!previousGroupId.equals(nlsGroupList.getGroupId())) {
                groupDetailInfo = groupInfo.new GroupDetailView();
                groupDetailInfo.setGroupId(nlsGroupList.getGroupId());
                groupDetailInfo.setGroupName(nlsGroupList.getGroupName());
                groupDetailList.add(groupDetailInfo);
                previousGroupId = nlsGroupList.getGroupId();
            }
        }

        for (int i = 0; i < groupDetailList.size(); i++) {
            String groupId = groupDetailList.get(i).getGroupId();
            List<GroupListView.GroupDetailView.GroupByAuthorityView> groupByAuthorityList =
                    new ArrayList<GroupListView.GroupDetailView.GroupByAuthorityView>();

            for (int j = 0; j < rsAuthorityList.size(); j++) {
                AuthorityListOutServiceBean nlsAuthorityList = (AuthorityListOutServiceBean) rsAuthorityList.get(j);
                groupByAuthority = groupDetailInfo.new GroupByAuthorityView();
                groupByAuthority.setAuthorityId(nlsAuthorityList.getAuthorityId());
                groupByAuthorityList.add(groupByAuthority);
            }

            for (int k = 0; k < rsGroupList.size(); k++) {
                GroupListOutServiceBean nlsGroupList = (GroupListOutServiceBean) rsGroupList.get(k);
                if (groupId.equals(nlsGroupList.getGroupId())) {
                    String authorityIdChk = nlsGroupList.getAuthorityId();
                    for (int m = 0; m < groupByAuthorityList.size(); m++) {
                        String authorityIdOrg = groupByAuthorityList.get(m).getAuthorityId();
                        if (authorityIdChk.equals(authorityIdOrg)) {
                            groupByAuthorityList.get(m).setAuthorityExist("1");
                        }
                    }
                }
            }
            groupDetailList.get(i).setGroupByAuthorityList(groupByAuthorityList);
        }

        for (int i = 0; i < groupDetailList.size(); i++) {
            String groupId = groupDetailList.get(i).getGroupId();

            for (int j = 0; j < inServiceBean.getGroupId().length; j++) {
                if (groupId.equals(inServiceBean.getGroupId()[j])) {
                    groupDetailList.get(i).setGroupDeleteCheck("1");
                }
            }
        }

        GroupListView view = new GroupListView();
        view.setGroupList(groupDetailList);

        // グループの権限一覧のviewHelper設定
        List<GroupListView.AuthorityDetailView> viewAuthority = new ArrayList<GroupListView.AuthorityDetailView>();
        for (int i = 0; i < rsAuthorityList.size(); i++) {
            AuthorityListOutServiceBean nlsAuthorityList = (AuthorityListOutServiceBean) rsAuthorityList.get(i);

            // リスト項目はinnerClassで処理
            GroupListView.AuthorityDetailView authorityDetail = groupInfo.new AuthorityDetailView();
            BeanUtils.copyProperties(authorityDetail, nlsAuthorityList);

            viewAuthority.add(authorityDetail);
        }
        view.setAuthorityList(viewAuthority);

        context.setForward("success", view);

    }

}

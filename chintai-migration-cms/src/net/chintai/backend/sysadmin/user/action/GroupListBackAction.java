/*
 * $Id: GroupListBackAction.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.user.action.view.GroupListView;
import net.chintai.backend.sysadmin.user.service.GroupListService;
import net.chintai.backend.sysadmin.user.service.bean.AuthorityListOutServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.GroupListOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;


/**
 * グループ一覧を表示するアクションクラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupListBackAction extends BaseActionSupport {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.USER);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        GroupListService groupList = (GroupListService) ac
                .getBean("groupListService");
        
        // グループ一覧取得
        List rsGroupList = groupList.getGroupList();

        // グループの権限一覧取得
        List rsAuthorityList = groupList.getAuthorityList();

        // グループ一覧のviewHelper設定
        List<GroupListView.GroupDetailView> viewGroupList = new ArrayList<GroupListView.GroupDetailView>();
        GroupListView groupInfo = new GroupListView();
        for (int i = 0; i < rsGroupList.size(); i++) {
            GroupListOutServiceBean nls = (GroupListOutServiceBean) rsGroupList.get(i);

            // リスト項目はinnerClassで処理
            GroupListView.GroupDetailView groupDetail = groupInfo.new GroupDetailView();
            BeanUtils.copyProperties(groupDetail, nls);

            viewGroupList.add(groupDetail);
        }
        GroupListView view = new GroupListView();
        view.setGroupList(viewGroupList);

        // グループの権限一覧のviewHelper設定
        List<GroupListView.AuthorityDetailView> viewAuthority = new ArrayList<GroupListView.AuthorityDetailView>();
        for (int i = 0; i < rsAuthorityList.size(); i++) {
            AuthorityListOutServiceBean nls = (AuthorityListOutServiceBean) rsAuthorityList.get(i);

            // リスト項目はinnerClassで処理
            GroupListView.AuthorityDetailView authorityDetail = groupInfo.new AuthorityDetailView();
            BeanUtils.copyProperties(authorityDetail, nls);

            viewAuthority.add(authorityDetail);
        }
        view.setAuthorityList(viewAuthority);

        context.setForward("success", view);

    }

}

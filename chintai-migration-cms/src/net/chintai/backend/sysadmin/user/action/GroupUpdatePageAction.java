/*
 * $Id: GroupUpdatePageAction.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.user.action.view.GroupUpdatePageView;
import net.chintai.backend.sysadmin.user.service.GroupUpdatePageService;
import net.chintai.backend.sysadmin.user.service.bean.GroupUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.GroupUpdatePageOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * グループ設定変更を表示するアクションクラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupUpdatePageAction extends BaseActionSupport {

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
    protected void doExecute(BusinessContext context) throws Exception, ApplicationException {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        GroupUpdatePageInServiceBean inServiceBean = new GroupUpdatePageInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        GroupUpdatePageService groupUpdatePageService = 
                (GroupUpdatePageService) ac.getBean("groupUpdatePageService");

        // グループ一覧取得
        List rsGroupList = groupUpdatePageService.getGroupDetail(inServiceBean);

        // グループの権限一覧のviewHelper設定
        GroupUpdatePageView groupAuthorityInfo = new GroupUpdatePageView();
        List<GroupUpdatePageView.GroupAuthorityDetailView> viewGroupAuthority = new ArrayList<GroupUpdatePageView.GroupAuthorityDetailView>();
        String groupId = null;
        String groupName = null;
        String groupUpdDt = null;
        for (int i = 0; i < rsGroupList.size(); i++) {
            GroupUpdatePageOutServiceBean nlsGroup = (GroupUpdatePageOutServiceBean) rsGroupList.get(i);
            
            if(nlsGroup.getAuthorityExist() != null){
                if(nlsGroup.getAuthorityExist().equals("1") && groupId == null){
                    groupId = nlsGroup.getGroupId();
                    groupName = nlsGroup.getGroupName();
                    groupUpdDt = nlsGroup.getGroupUpdDt();
                }
            }
            
            // リスト項目はinnerClassで処理
            GroupUpdatePageView.GroupAuthorityDetailView groupAuthorityDetail = groupAuthorityInfo.new GroupAuthorityDetailView();
            BeanUtils.copyProperties(groupAuthorityDetail, nlsGroup);
            
            viewGroupAuthority.add(groupAuthorityDetail);
        }

        if (groupId != null) {

            GroupUpdatePageView view = new GroupUpdatePageView();
            view.setGroupAuthorityList(viewGroupAuthority);
            view.setGroupId(groupId);
            view.setGroupName(groupName);
            view.setGroupUpdDt(groupUpdDt);

            context.setForward("success", view);

        } else {
            // 他のユーザに削除されった場合。
            context.setError("ERROR.M.USER.0005");
            context.setForward("fail");
        }
    }
}
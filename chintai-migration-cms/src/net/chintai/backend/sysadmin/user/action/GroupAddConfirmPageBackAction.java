/*
 * $Id: GroupAddConfirmPageBackAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.user.action.view.GroupAddView;
import net.chintai.backend.sysadmin.user.service.AuthorityListService;
import net.chintai.backend.sysadmin.user.service.bean.AuthorityListOutServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.GroupAddConfirmPageBackInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;


/**
 * グループ登録を表示する戻るアクションクラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupAddConfirmPageBackAction extends BaseActionSupport {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        GroupAddConfirmPageBackInServiceBean inServiceBean = new GroupAddConfirmPageBackInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        AuthorityListService authorityList = (AuthorityListService) ac
                .getBean("authorityListService");

        // グループの権限一覧取得
        List rsAuthorityList = authorityList.getAuthorityList();

        // グループの権限一覧のviewHelper設定
        List<GroupAddView.AuthorityListDetailView> viewAuthorityList = new ArrayList<GroupAddView.AuthorityListDetailView>();
        GroupAddView authorityInfo = new GroupAddView();

        for (int i = 0; i < rsAuthorityList.size(); i++) {
            AuthorityListOutServiceBean nls = (AuthorityListOutServiceBean) rsAuthorityList.get(i);

            // リスト項目はinnerClassで処理
            GroupAddView.AuthorityListDetailView authorityDetail = authorityInfo.new AuthorityListDetailView();
            BeanUtils.copyProperties(authorityDetail, nls);

            for ( int j = 0; j < inServiceBean.getAuthorityId().length; j++){
                String authorityId = (String)inServiceBean.getAuthorityId()[j];
                
                if(authorityId.equals(nls.getAuthorityId())){
                    authorityDetail.setAuthorityExist("1");
                }
            }

            viewAuthorityList.add(authorityDetail);
        }
        GroupAddView view = new GroupAddView();
        view.setAuthorityList(viewAuthorityList);
        view.setGroupName(inServiceBean.getGroupName());

        context.setForward("success", view);

    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.USER);
    }

}

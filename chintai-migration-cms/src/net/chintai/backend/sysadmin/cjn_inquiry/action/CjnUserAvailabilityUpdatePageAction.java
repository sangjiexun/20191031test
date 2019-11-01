/*
 * $Id: CjnUserAvailabilityUpdatePageAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)児島       新規作成
 * 2007/09/28  BGT)児島       UserId を CjnAccountSeq に修正
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnUserAvailabilityUpdateView;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserAvailabilityUpdatePageService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAvailabilityUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAvailabilityUpdatePageOutServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAvailabilityUpdatePageOutServiceBean.ReadableUserBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 閲覧可能ユーザリスト取得アクション。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAvailabilityUpdatePageAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {
        
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        CjnUserAvailabilityUpdatePageInServiceBean inBean =
                new CjnUserAvailabilityUpdatePageInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        CjnUserAvailabilityUpdatePageService service =
                (CjnUserAvailabilityUpdatePageService) ac.getBean("cjnUserAvailabilityUpdatePageService");

        // 閲覧可否情報の取得
        CjnUserAvailabilityUpdatePageOutServiceBean outBean = service.selectTypeInfoUsers(inBean);

        // 最終更新日時の取得
        outBean.setLastUpdateTime(service.selectLastUpdateTime(inBean.getCjnInqKindSeq()));

        // ViewHelper の構築
        CjnUserAvailabilityUpdateView view = new CjnUserAvailabilityUpdateView();
        List<ReadableUserBean> readableUserList = outBean.getReadableUserList();
        List<CjnUserAvailabilityUpdateView.CjnUserAvailabilityUpdateDetailView> viewList =
                new ArrayList<CjnUserAvailabilityUpdateView.CjnUserAvailabilityUpdateDetailView>();

        if (readableUserList != null) {
            for (int i = 0; i < readableUserList.size(); i++) {
                CjnUserAvailabilityUpdateView.CjnUserAvailabilityUpdateDetailView detailView =
                        view.new CjnUserAvailabilityUpdateDetailView();

                BeanUtils.copyProperties(detailView, readableUserList.get(i));
                viewList.add(detailView);
            }
        }
        BeanUtils.copyProperties(view, outBean);
        view.setUserList(viewList);
        
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
        return auth.authenticate(userId, AuthorityId.CJN_INQUIRY) && auth.isAdminCjnAccountType(userId);
    }
}

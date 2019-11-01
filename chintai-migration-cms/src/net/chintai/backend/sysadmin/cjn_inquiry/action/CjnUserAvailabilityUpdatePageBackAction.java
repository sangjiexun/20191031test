/*
 * $Id: CjnUserAvailabilityUpdatePageBackAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/28   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnUserAvailabilityUpdateView;
import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnUserAvailabilityUpdateView.CjnUserAvailabilityUpdateDetailView;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;

import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 閲覧可能ユーザリスト画面に戻るアクション。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAvailabilityUpdatePageBackAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        
        // ViewHelper の構築
        CjnUserAvailabilityUpdateView view = new CjnUserAvailabilityUpdateView();
        view.setCjnInqKindSeq((Integer) form.get("cjnInqKindSeq"));
        view.setInqTitle(form.getString("inqTitle"));
        view.setInqComment(form.getString("inqComment"));
        view.setLastUpdateTime(form.getString("lastUpdateTime"));

        List<CjnUserAvailabilityUpdateDetailView> userList =
                new ArrayList<CjnUserAvailabilityUpdateDetailView>();
        Integer[] cjnAccountSeqArray = (Integer[]) form.get("cjnAccountSeq");
        String[] userNameArray = form.getStrings("userName");
        Boolean[] existsArray = (Boolean[]) form.get("exists");

        for (int i = 0; i < cjnAccountSeqArray.length; i++) {
            CjnUserAvailabilityUpdateView.CjnUserAvailabilityUpdateDetailView detailView =
                    view.new CjnUserAvailabilityUpdateDetailView();
            detailView.setCjnAccountSeq(cjnAccountSeqArray[i]);
            detailView.setUserName(userNameArray[i]);
            detailView.setExists(existsArray[i]);
            userList.add(detailView);
        }
        view.setUserList(userList);
        
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

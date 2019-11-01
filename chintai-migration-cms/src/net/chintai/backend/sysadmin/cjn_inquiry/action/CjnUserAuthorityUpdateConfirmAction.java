/*
 * $Id: CjnUserAuthorityUpdateConfirmAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnUserAuthorityUpdateView;
import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnUserAuthorityUpdateView.CjnUserAccountViewDetail;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;

import org.apache.struts.action.DynaActionForm;
import org.springframework.context.ApplicationContext;

/**
 * 閲覧可能問い合せ権限更新確認アクション
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAuthorityUpdateConfirmAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データを取得
        DynaActionForm form = (DynaActionForm) context.getForm();

        /*
         * 実装方式は CjnUserAvailabilityUpdateConfirmAction と同様。
         */
        
        // CheckBox のチェック可否取得
        Integer[] checkcjnInqKindSeq = (Integer[]) form.get("checkedCjnInqKindSeq");

        // Setにセット
        Set<Integer> inqKindSeqSet = new HashSet<Integer>();
        for (int i = 0; i < checkcjnInqKindSeq.length; i++) {
            inqKindSeqSet.add(checkcjnInqKindSeq[i]);
        }
        String[] inqTitle = form.getStrings("inqTitle");
        String[] inqComment = form.getStrings("inqComment");
        Integer[] cjnInqKindSeq = (Integer[]) form.get("cjnInqKindSeq");

        // ViewHelperにセット
        List<CjnUserAccountViewDetail> viewList = new ArrayList<CjnUserAccountViewDetail>();
        CjnUserAuthorityUpdateView view = new CjnUserAuthorityUpdateView();

        view.setCjnAccountSeq(form.getString("cjnAccountSeq")); // hidden
        view.setUserId(form.getString("userId"));               // hidden
        view.setUserName(form.getString("userName"));           // hidden
        view.setUpdDt(form.getString("updDt"));                 // hidden

        for (int i = 0; i < cjnInqKindSeq.length; i++) {
            CjnUserAuthorityUpdateView.CjnUserAccountViewDetail viewDetail =
                    view.new CjnUserAccountViewDetail();
            viewDetail.setCjnInqKindSeq(cjnInqKindSeq[i]);
            viewDetail.setInqTitle(inqTitle[i]);
            viewDetail.setInqComment(inqComment[i]);

            if (inqKindSeqSet.contains(cjnInqKindSeq[i])) {
                viewDetail.setCnt(1);
            } else {
                viewDetail.setCnt(0);
            }
            viewList.add(viewDetail);
        }
        view.setUserAccountList(viewList);

        //二重更新防止トークンをセット
        saveToken(context.getRequest());
        
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

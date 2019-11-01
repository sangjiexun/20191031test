/*
 * $Id: CjnUserAvailabilityUpdateConfirmAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnUserAvailabilityUpdateView;
import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnUserAvailabilityUpdateView.CjnUserAvailabilityUpdateDetailView;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;

import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 閲覧可能ユーザ更新画面を表示するアクション。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAvailabilityUpdateConfirmAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        // ViewHelper の構築
        CjnUserAvailabilityUpdateView view = new CjnUserAvailabilityUpdateView();
        {
            view.setCjnInqKindSeq((Integer) form.get("cjnInqKindSeq"));
            view.setInqTitle(form.getString("inqTitle"));
            view.setInqComment(form.getString("inqComment"));
            view.setLastUpdateTime(form.getString("lastUpdateTime"));

            /*
             * CheckBox でチェックされなかった値は form にセットされない。
             * チェックされなかった値も知る必要があるため、以下の 2 つの情報を
             * 画面から POST してもらう。
             *   - cjnAccountSeqArray  ... hidden (チェック有無に関係なく必ず form にセットされる)
             *   - checkedCjnAccountSeqArray ... checkbox (チェック有のみ form にセットされる)
             * 
             * そして、exists を以下のように設定する。
             *   - cjnAccountSeqArray, checkedCjnAccountSeqArray 両方にある値 → exists = true
             *   - cjnAccountSeqArray にあって checkedCjnAccountSeqArray にない値 → exists = false
             */
            Integer[] checkedCjnAccountSeqArray = (Integer[]) form.get("checkedCjnAccountSeq"); // checkbox

            // Array を Set に変換
            Set<Integer> checkedCjnAccountSeqSet = new HashSet<Integer>();
            for (int i = 0; i < checkedCjnAccountSeqArray.length; i++) {
                checkedCjnAccountSeqSet.add(checkedCjnAccountSeqArray[i]);
            }

            Integer[] cjnAccountSeqArray = (Integer[]) form.get("cjnAccountSeq");   // hidden field
            String[] userNameArray = form.getStrings("userName");                   // hidden field

            // 閲覧可能ユーザリストの構築
            List<CjnUserAvailabilityUpdateDetailView> userList =
                    new ArrayList<CjnUserAvailabilityUpdateDetailView>();
            for (int i = 0; i < cjnAccountSeqArray.length; i++) {
                CjnUserAvailabilityUpdateView.CjnUserAvailabilityUpdateDetailView detailView =
                        view.new CjnUserAvailabilityUpdateDetailView();
                detailView.setCjnAccountSeq(cjnAccountSeqArray[i]);
                detailView.setUserName(userNameArray[i]);

                // exists の設定
                if (checkedCjnAccountSeqSet.contains(cjnAccountSeqArray[i])) {
                    detailView.setExists(true);
                } else {
                    detailView.setExists(false);
                }
                userList.add(detailView);
            }
            view.setUserList(userList);
        }

        // 二重更新防止トークンをセット
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

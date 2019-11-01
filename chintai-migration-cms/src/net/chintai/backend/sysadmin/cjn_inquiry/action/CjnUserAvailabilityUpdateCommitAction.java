/*
 * $Id: CjnUserAvailabilityUpdateCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserAvailabilityUpdateCommitService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAvailabilityUpdateCommitInServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 閲覧可能ユーザ情報の変更を行うアクション。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAvailabilityUpdateCommitAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面リロード対策
        if (!isTokenValid(context.getRequest())) {
            context.setForward("success");
            return;
        }
        resetToken(context.getRequest());

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        CjnUserAvailabilityUpdateCommitInServiceBean bean =
                new CjnUserAvailabilityUpdateCommitInServiceBean();

        // ServiceBean の構築
        Integer[] cjnAccountSeqArray = (Integer[]) form.get("cjnAccountSeq");
        Boolean[] exists = (Boolean[]) form.get("exists");

        List<Integer> readableUsersNameList = new ArrayList<Integer>();
        for (int i = 0; i < cjnAccountSeqArray.length; i++) {
            // 閲覧可能ユーザのみをセット
            if (exists[i]) {
                readableUsersNameList.add(cjnAccountSeqArray[i]);
            }
        }
        bean.setReadableUsersSeqList(readableUsersNameList);
        bean.setCjnInqKindSeq((Integer) form.get("cjnInqKindSeq"));
        bean.setLastUpdateTime(form.getString("lastUpdateTime"));
        bean.setOperUserId(context.getSessionBean().getUserId());

        String className = this.getClass().getName();
        bean.setPgName(className);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        CjnUserAvailabilityUpdateCommitService service =
                (CjnUserAvailabilityUpdateCommitService) ac
                        .getBean("cjnUserAvailabilityUpdateCommitService");

        // 操作ログ記録
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        try {
            // 更新実行
            service.updateTypeInfoUsers(bean);

            // 更新した場合の操作ログ記録
            loggingService.write("07003", context.getSessionBean().getUserId(),
                    SessionStatus.SUCCESS, "問い合せ種別シーケンス" + String.valueOf(bean.getCjnInqKindSeq()), this.getClass().getName());

            // メッセージ設定
            context.setMessage("INFO.M.CJN_INQUIRY.0003", ApplicationResources
                    .getProperty("cjn_inquiry.readableUser"));

        } catch (ApplicationException e) {

            // 更新出来なかった場合の操作ログ記録
            loggingService.write("07003", context.getSessionBean().getUserId(),
                    SessionStatus.FAILURE, "問い合せ種別シーケンス" + String.valueOf(bean.getCjnInqKindSeq()), this.getClass().getName());

            // エラーメッセージ設定
            context.setError("ERROR.M.CJN_INQUIRY.0002");
        }

        // フォワードパラメータをセット
        Map<String, String> parameterMap = new HashMap<String, String>();
        parameterMap.put("cjnInqKindSeq", ((Integer) bean.getCjnInqKindSeq()).toString());
        context.setForwardParameterMap(parameterMap);
        context.setForward("success");
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.CJN_INQUIRY)
                && auth.isAdminCjnAccountType(userId);
    }
}

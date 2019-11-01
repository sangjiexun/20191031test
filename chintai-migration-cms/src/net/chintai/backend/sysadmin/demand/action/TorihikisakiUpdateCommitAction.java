/*
 * $Id: TorihikisakiUpdateCommitAction.java 3598 2007-12-17 06:00:37Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/06  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiUpdateCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiUpdateCommitInServiceBean;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

/**
 * 取引先情報更新
 *
 * @author lee-hosup
 * @version $Revision: 3598 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiUpdateCommitAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        TorihikisakiUpdateCommitInServiceBean inBean = new TorihikisakiUpdateCommitInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 更新者ID、更新プログラム設定
        inBean.setUpdId(context.getSessionBean().getUserId());
        inBean.setUpdPg(this.getClass().getName());

        // injection
        ApplicationContext ac = getWebApplicationContext();

        // 画面リロード対策
        if (isTokenValid(context.getRequest())) {
            // Token初期化
            resetToken(context.getRequest());

            TorihikisakiUpdateCommitService service =
                (TorihikisakiUpdateCommitService) ac.getBean("torihikisakiUpdateCommitService");

            // 操作ログ記録サービス
            OperationLoggingService loggingService =
                    (OperationLoggingService) ac.getBean("operationLoggingService");

            // 操作ログ記録為、更新取引先のシーケンス番号を設定
            String updTarget = inBean.getTorihikisakiSeq();

            try {

                service.updateTorihikisakiInfo(inBean);

            } catch (ApplicationException e) {

                // 更新失敗ログ、メッセージ設定
                loggingService.write("11006", inBean.getUpdId(), SessionStatus.FAILURE,
                        ApplicationResources.getProperty("demand.torihikisakiSeq") + updTarget, this.getClass().getName());

                if (e.getErrorId().equals("WARN.M.DEMAND.0087")) {
                    context.setError("WARN.M.DEMAND.0087", new String[] {
                            ApplicationResources.getProperty("demand.fudousan"),
                            ApplicationResources.getProperty("demand.choiceFudousan") });
                } else {
                    context.setError("ERROR.M.DEMAND.0102");
                }

                context.setForward("fail");
                return;
            }

            // 更新成功ログ、メッセージ設定
            loggingService.write("11006", inBean.getUpdId(), SessionStatus.SUCCESS,
                    ApplicationResources.getProperty("demand.torihikisakiSeq") + updTarget, this.getClass().getName());

            context.setMessage("INFO.M.DEMAND.0101", ApplicationResources
                    .getProperty("demand.torihikisaki"));
        }

        context.setForward("success");

    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }

}

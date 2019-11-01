/*
 * $Id: TorihikisakiWakuInfoAddCommitAction.java 3690 2007-12-21 05:23:35Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/09  BGT)李昊燮   新規作成
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
import net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoAddCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoAddCommitInServiceBean;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

/**
 * 取引先物件枠設定情報登録
 *
 * @author lee-hosup
 * @version $Revision: 3690 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoAddCommitAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        context.setForward("success");

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        TorihikisakiWakuInfoAddCommitInServiceBean inBean =
                new TorihikisakiWakuInfoAddCommitInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 更新者ID、更新プログラム設定
        inBean.setUserId(context.getSessionBean().getUserId());
        inBean.setPgName(this.getClass().getName());

        // injection
        ApplicationContext ac = getWebApplicationContext();
        TorihikisakiWakuInfoAddCommitService service =
                (TorihikisakiWakuInfoAddCommitService) ac
                        .getBean("torihikisakiWakuInfoAddCommitService");

        // 画面リロード対策
        if (isTokenValid(context.getRequest())) {

            // Token初期化
            resetToken(context.getRequest());

            // 操作ログ記録サービス
            OperationLoggingService loggingService =
                    (OperationLoggingService) ac.getBean("operationLoggingService");

            // 操作ログ記録為、更新取引先のシーケンス番号を設定
            String updTarget =
                    ApplicationResources.getProperty("demand.torihikisakiSeq")
                            + inBean.getTorihikisakiSeq()
                            + ApplicationResources.getProperty("demand.applyYm")
                            + inBean.getApplyYear() + inBean.getApplyMonth();
            try {
                service.insertTorihikisakiWakuInfo(inBean);
            } catch (ApplicationException e) {

                // 更新失敗ログ、メッセージ設定
                loggingService.write("11008", inBean.getUserId(), SessionStatus.FAILURE, updTarget, this.getClass().getName());
                context.setError("ERROR.M.DEMAND.0119");
                return;
            }

            // 更新成功ログ、メッセージ設定
            loggingService.write("11008", inBean.getUserId(), SessionStatus.SUCCESS, updTarget, this.getClass().getName());

            context.setMessage("INFO.M.DEMAND.0110", ApplicationResources
                    .getProperty("demand.wakuInfo"));
        }

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

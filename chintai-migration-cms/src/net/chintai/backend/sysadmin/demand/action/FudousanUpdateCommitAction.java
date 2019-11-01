/*
 * $Id: FudousanUpdateCommitAction.java 3630 2007-12-18 06:12:29Z y-takahashi $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/01     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.demand.service.FudousanUpdateCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanUpdateCommitInServiceBean;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 不動産会社を更新するアクション
 *
 * @author TAKAHASHI Yuki
 * @version $Revision: 3630 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class FudousanUpdateCommitAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        FudousanUpdateCommitInServiceBean inBean = new FudousanUpdateCommitInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 更新者情報を設定(更新プログラム、更新者ID)
        inBean.setUpdId(context.getSessionBean().getUserId());
        inBean.setUpdPg(this.getClass().getName());

        // injection
        ApplicationContext ac = getWebApplicationContext();

        // 画面リロード対策
        if (isTokenValid(context.getRequest())) {

            resetToken(context.getRequest());

            FudousanUpdateCommitService service =
                    (FudousanUpdateCommitService) ac.getBean("fudousanUpdateCommitService");

            // 操作ログ記録サービス
            OperationLoggingService loggingService =
                    (OperationLoggingService) ac.getBean("operationLoggingService");

            try {
                // 不動産会社情報更新
                service.updateFudousan(inBean);

            } catch (ApplicationException ae) {
                // 更新失敗ログ
                loggingService.write("11003", inBean.getUpdId(), SessionStatus.FAILURE,
                        ApplicationResources.getProperty("demand.fudousanCd")
                                + inBean.getFudousanCd(), this.getClass().getName());
                throw ae;
            }

            // 操作ログ記録成功場合
            loggingService.write("11003", context.getSessionBean().getUserId(),
                    SessionStatus.SUCCESS, ApplicationResources.getProperty("demand.fudousanCd")
                            + inBean.getFudousanCd(), this.getClass().getName());

            // メッセージ設定
            context.setMessage("INFO.M.DEMAND.0045", ApplicationResources
                    .getProperty("demand.fudousanInfo"));

        }

        context.setForward("success");
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        // 権限チェック
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }

}

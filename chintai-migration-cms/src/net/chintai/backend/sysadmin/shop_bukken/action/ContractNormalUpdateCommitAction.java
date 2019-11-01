package net.chintai.backend.sysadmin.shop_bukken.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractNormalUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractNormalUpdateCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 契約明細設定（数量なし）完了アクション。
 *
 * @author m-kashiyama
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractNormalUpdateCommitAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        context.setForward("success");

        // 画面リロード対策
        if (!isTokenValid(context.getRequest())) {
            return;
        }
        resetToken(context.getRequest());

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ContractNormalUpdateCommitInServiceBean inServiceBean = new ContractNormalUpdateCommitInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // 更新者をユーザＩＤで設定
        String operUserId = context.getSessionBean().getUserId();
        inServiceBean.setOperUserId(operUserId);

        // プログラムID設定
        inServiceBean.setUpdPg(this.getClass().getName());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ContractNormalUpdateCommitService contractNormalUpdateCommitService =
                (ContractNormalUpdateCommitService) ac.getBean("ContractNormalUpdateCommitService");

        // 操作ログ記録
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        try {
            // 更新作業を行う
            contractNormalUpdateCommitService.contractNormalkUpdateCommit(inServiceBean);


            loggingService.write("01016", context.getSessionBean().getUserId(), SessionStatus.SUCCESS,
                    " 店舗コード " + (String) form.get("shopCd") +
                    " 契約コード " + (String) form.get("keiyakuCd") +
                    " 契約サブコード " + (String) form.get("keiyakuSubCd")
                    , this.getClass().getName());

            // メッセージ設定
            context.setMessage("INFO.M.SHOP_BUKKEN.0009", (String)form.getString("keiyakuName"));

        } catch (ApplicationException e) {
            // 更新失敗ログ、メッセージ設定
            loggingService.write("01016", context.getSessionBean().getUserId(),
                    SessionStatus.FAILURE,
                    " 店舗コード " + (String) form.get("shopCd") +
                    " 契約コード " + (String) form.get("keiyakuCd") +
                    " 契約サブコード " + (String) form.get("keiyakuSubCd"), this.getClass().getName());

            context.setError(e.getErrorId());
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }
}
package net.chintai.backend.sysadmin.shop_bukken.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountUpdateCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 契約明細詳細(契約数量あり)設定情報更新
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountUpdateCommitAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
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

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ContractAmountUpdateCommitInServiceBean inBean =
                new ContractAmountUpdateCommitInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 更新者ID、更新プログラム設定
        inBean.setUpdId(context.getSessionBean().getUserId());
        inBean.setUpdPg(this.getClass().getName());

        // injection
        ApplicationContext ac = getWebApplicationContext();
        ContractAmountUpdateCommitService service =
                (ContractAmountUpdateCommitService) ac
                        .getBean("contractAmountUpdateCommitService");

        // 操作ログ記録サービス
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        // 操作ログ記録為、更新取引先のシーケンス番号を設定
        String updTarget =
                "店舗コード" +  inBean.getShopCd()  +
                " 契約コード" +  inBean.getKeiyakuCd() +
                " 契約サブコード" + inBean.getKeiyakuSubCd();

        // 更新開始
        try {
            service.updateContractAmount(inBean);
           // 更新成功ログ、メッセージ設定
            loggingService.write("01018", inBean.getUpdId(), SessionStatus.SUCCESS, updTarget, this.getClass().getName());

            context.setMessage("INFO.M.SHOP_BUKKEN.0018", form.getString("keiyakuName"));
        } catch (ApplicationException e) {
            // 更新失敗ログ、メッセージ設定
            loggingService.write("01018", inBean.getUpdId(), SessionStatus.FAILURE, updTarget, this.getClass().getName());
            context.setError(e.getErrorId());
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
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }

}

package net.chintai.backend.sysadmin.shop_bukken.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountAddCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountAddCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 契約明細詳細(契約数量あり)設定情報登録
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountAddCommitAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        context.setForward("success");

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ContractAmountAddCommitInServiceBean inBean =
                new ContractAmountAddCommitInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 更新者ID、更新プログラム設定
        inBean.setUserId(context.getSessionBean().getUserId());
        inBean.setPgName(this.getClass().getName());

        // injection
        ApplicationContext ac = getWebApplicationContext();
        ContractAmountAddCommitService service =
                (ContractAmountAddCommitService) ac
                        .getBean("contractAmountAddCommitService");

        // 画面リロード対策
        if (isTokenValid(context.getRequest())) {

            // Token初期化
            resetToken(context.getRequest());

            // 操作ログ記録サービス
            OperationLoggingService loggingService =
                    (OperationLoggingService) ac.getBean("operationLoggingService");

            // 操作ログ記録為、更新取引先のシーケンス番号を設定
            String updTarget =
                    "店舗コード" +  inBean.getShopCd()  +
                    " 契約コード" +  inBean.getKeiyakuCd() +
                    " 契約サブコード" + inBean.getKeiyakuSubCd();

            try {
                service.insertContractAmount(inBean);

                // 更新成功ログ、メッセージ設定
                loggingService.write("01017", inBean.getUserId(), SessionStatus.SUCCESS, updTarget, this.getClass().getName());

                context.setMessage("INFO.M.SHOP_BUKKEN.0017", form.getString("keiyakuName"));

            } catch (ApplicationException e) {
                // 更新失敗ログ、メッセージ設定
                loggingService.write("01017", inBean.getUserId(), SessionStatus.FAILURE, updTarget, this.getClass().getName());
                context.setError(e.getErrorId(),e.getPlaceHolders());
            }
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

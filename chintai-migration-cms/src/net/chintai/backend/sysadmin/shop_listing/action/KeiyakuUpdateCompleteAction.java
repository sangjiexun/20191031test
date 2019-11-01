/*
 * $Id: KeiyakuUpdateCompleteAction.java 4280 2009-07-06 12:03:54Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/18  BGT)李昊燮     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_listing.service.KeiyakuUpdateCompleteService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuUpdateCompleteInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.JdbcUpdateAffectedIncorrectNumberOfRowsException;

/**
 * 契約情報更新完了アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4280 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuUpdateCompleteAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#
     * doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
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
        KeiyakuUpdateCompleteInServiceBean inBean = new KeiyakuUpdateCompleteInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 更新者情報を設定(更新プログラム、更新者ID)
        inBean.setInsPg(this.getClass().getName());
        inBean.setInsId(context.getSessionBean().getUserId());
        inBean.setUpdPg(this.getClass().getName());
        inBean.setUpdId(context.getSessionBean().getUserId());

        // injection
        ApplicationContext ac = getWebApplicationContext();
        KeiyakuUpdateCompleteService service =
                (KeiyakuUpdateCompleteService) ac.getBean("keiyakuUpdateCompleteService");

        // 更新処理
        SessionStatus editResult = SessionStatus.SUCCESS;
        try {
            service.updateKeiyakuInfo(inBean);
            // 更新完了メッセージ設定
            context.setMessage("INFO.M.SHOP_LISTING.0002", ApplicationResources
                    .getProperty("shop_listing.keiyakuInfo"));
        } catch (JdbcUpdateAffectedIncorrectNumberOfRowsException e) {
            editResult = SessionStatus.FAILURE;
            context.setError("ERROR.M.SHOP_LISTING.0001");
        }

        // 操作ログ記録
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        loggingService.write(
                SystemProperties.getProperty("OP_ID_LISTING_KEIYAKU_INFO_UPDATE"), // 操作ID
                context.getSessionBean().getUserId(),
                editResult,
                ApplicationResources.getProperty("shop_listing.shopCd") + inBean.getShopCd(),
                this.getClass().getName());

        context.setForward("success");

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java
     * .lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_LISTING);
    }

}

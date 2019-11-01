/*
 * $Id: KeiyakuRegisterCompleteAction.java 4253 2009-03-24 09:31:02Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/24     BGT)李昊燮     新規作成
 *
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
import net.chintai.backend.sysadmin.shop_listing.service.KeiyakuRegisterCompleteService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuRegisterCompleteInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 契約情報登録完了アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4253 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuRegisterCompleteAction extends BaseActionSupport {

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
        KeiyakuRegisterCompleteInServiceBean inBean = new KeiyakuRegisterCompleteInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 登録者情報を設定(登録プログラム、登録者ID、更新プログラム、更新者ID)
        inBean.setInsPg(this.getClass().getName());
        inBean.setInsId(context.getSessionBean().getUserId());
        inBean.setUpdPg(this.getClass().getName());
        inBean.setUpdId(context.getSessionBean().getUserId());

        // injection
        ApplicationContext ac = getWebApplicationContext();
        KeiyakuRegisterCompleteService service =
                (KeiyakuRegisterCompleteService) ac.getBean("keiyakuRegisterCompleteService");
        OperationLoggingService loggingService =
            (OperationLoggingService) ac.getBean("operationLoggingService");

        // 登録処理 & 操作ログ記録
        try {
            service.registerKiyakuInfo(inBean);
        } catch (Exception e) {
            loggingService.write(
                    SystemProperties.getProperty("OP_ID_LISTING_KEIYAKU_INFO_REGISTER"), // 操作ID
                    context.getSessionBean().getUserId(),                                // 登録者ID
                    SessionStatus.FAILURE,                                               // 操作結果
                    ApplicationResources.getProperty("shop_listing.shopCd") + inBean.getShopCd(), //操作対象
                    this.getClass().getName()
            );
            throw e;
        }

        loggingService.write(
                SystemProperties.getProperty("OP_ID_LISTING_KEIYAKU_INFO_REGISTER"), // 操作ID
                context.getSessionBean().getUserId(),                                // 登録者ID
                SessionStatus.SUCCESS,                                               // 操作結果
                ApplicationResources.getProperty("shop_listing.shopCd") + inBean.getShopCd(), //操作対象
                this.getClass().getName()
        );

        // 登録完了メッセージ設定
        context.setMessage("INFO.M.SHOP_LISTING.0001", ApplicationResources
                .getProperty("shop_listing.keiyakuInfo"));

        // 契約店舗詳細画面へ遷移
        context.setForward("success");

    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#
     * isAuthorized(java .lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_LISTING);
    }

}

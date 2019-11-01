/*
 * $Id: ShopBasicInfoUpdateCommitAction.java 4301 2009-07-13 01:18:57Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopBasicInfoUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopBasicInfoUpdateCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 店舗基本情報更新アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4301 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBasicInfoUpdateCommitAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai
     * .backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面リロード対策
        if (!isTokenValid(context.getRequest())) {
            context.setForward("success");
            return;
        }
        resetToken(context.getRequest());

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ShopBasicInfoUpdateCommitInServiceBean inBean =
                new ShopBasicInfoUpdateCommitInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 更新者をユーザＩＤで設定
        String updId = context.getSessionBean().getUserId();
        inBean.setUpdId(updId);

        // プログラムID設定
        inBean.setUpdPg(this.getClass().getName());

        ApplicationContext ac = getWebApplicationContext();
        ShopBasicInfoUpdateCommitService service =
                (ShopBasicInfoUpdateCommitService) ac.getBean("shopBasicInfoUpdateCommitService");

        // 操作ログ記録
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        // 基本情報更新を行う
        try {
            service.doCommit(inBean);
        } catch (Exception e) {
            // 操作ログ － 基本情報更新失敗
            loggingService.write(SystemProperties.getProperty("OP_ID_SHOP_BASIC_INFO_UPDATE"), // 操作ID
                    updId, // 更新者ID
                    SessionStatus.FAILURE, // 操作結果
                    ApplicationResources.getProperty("shop.code") + inBean.getShopCd(), // 操作対象
                    this.getClass().getName()
            );
            context.setError("ERROR.M.SHOP_BUKKEN.0010");
            context.setForward("success");
            return;
        }

        // 操作ログ － 基本情報更新成功
        loggingService.write(SystemProperties.getProperty("OP_ID_SHOP_BASIC_INFO_UPDATE"), // 操作ID
                updId, // 更新者ID
                SessionStatus.SUCCESS, // 操作結果
                ApplicationResources.getProperty("shop.code") + inBean.getShopCd(), // 操作対象
                this.getClass().getName()
        );

        // 更新成功メッセージを設定
        context.setMessage("INFO.M.SHOP_BUKKEN.0016", ApplicationResources
                .getProperties("shop.basicInfo"));

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
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }

}

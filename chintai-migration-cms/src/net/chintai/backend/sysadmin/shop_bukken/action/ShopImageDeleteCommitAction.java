/*
 * $Id: ShopImageDeleteCommitAction.java 4311 2009-07-14 06:51:14Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)沈鍾沿     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopImageDeleteCommitDbService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopImageDeleteCommitDbInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.JdbcUpdateAffectedIncorrectNumberOfRowsException;

/**
 * 店舗画像削除完了して、店舗詳細画面を表示するアクション
 *
 * @author Sim-JongYeon
 * @version $Revision: 4311 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopImageDeleteCommitAction extends BaseActionSupport {

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
        ShopImageDeleteCommitDbInServiceBean inBean = new ShopImageDeleteCommitDbInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 更新者IDを設定
        String userId = context.getSessionBean().getUserId();
        inBean.setUpdId(userId);
        inBean.setUpdPg(this.getClass().getName());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ShopImageDeleteCommitDbService shopImageDeleteCommitDbService =
                (ShopImageDeleteCommitDbService) ac.getBean("shopImageDeleteCommitDbService");

        // 操作ログ記録サービス
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        try {
            // 取得した店舗画像フラグで、DBに反映。
            shopImageDeleteCommitDbService.shopImageUpdateCommitDb(inBean);

            // 更新成功ログ
            loggingService.write("01010", userId, SessionStatus.SUCCESS, "店舗コード "
                    + (String) form.get("shopCd"), this.getClass().getName());

            // メッセージ設定
            context.setMessage("INFO.M.SHOP_BUKKEN.0013", ApplicationResources
                    .getProperty("shop.imgFile"));
        } catch (JdbcUpdateAffectedIncorrectNumberOfRowsException e) {

            // 登録失敗ログ
            loggingService.write("01010", userId, SessionStatus.FAILURE, "店舗コード "
                    + (String) form.get("shopCd"), this.getClass().getName());

            context.setError("ERROR.M.SHOP_BUKKEN.0012");
            context.setForward("fail");
            return;
        }

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

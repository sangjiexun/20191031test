/*
 * $Id: MediaInfoUpdateCompleteAction.java 4262 2009-03-25 07:29:11Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/18     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.JdbcUpdateAffectedIncorrectNumberOfRowsException;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_listing.service.MediaInfoUpdateCompleteService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoUpdateCompleteInServiceBean;

/**
 * 出稿情報（仮保存）更新完了表示アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4262 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoUpdateCompleteAction extends BaseActionSupport {

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
        MediaInfoUpdateCompleteInServiceBean inBean = new MediaInfoUpdateCompleteInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 更新者情報を設定(更新プログラム、更新者ID)
        inBean.setInsPg(this.getClass().getName());
        inBean.setInsId(context.getSessionBean().getUserId());
        inBean.setUpdPg(this.getClass().getName());
        inBean.setUpdId(context.getSessionBean().getUserId());

        // injection
        ApplicationContext ac = getWebApplicationContext();
        MediaInfoUpdateCompleteService service =
                (MediaInfoUpdateCompleteService) ac.getBean("mediaInfoUpdateCompleteService");

        // 更新処理
        SessionStatus editResult = SessionStatus.SUCCESS;
        try {
            service.updateMediaInfo(inBean);
            // 更新完了メッセージ設定
            context.setMessage("INFO.M.SHOP_LISTING.0005", ApplicationResources
                    .getProperty("shop_listing.mediaInfo"));
            this.writeOperationLog(ac, inBean, editResult);
        } catch (JdbcUpdateAffectedIncorrectNumberOfRowsException e) {
            editResult = SessionStatus.FAILURE;
            context.setError("ERROR.M.SHOP_LISTING.0002");
            this.writeOperationLog(ac, inBean, editResult);
        } catch (ApplicationException ae) {
            editResult = SessionStatus.FAILURE;
            this.writeOperationLog(ac, inBean, editResult);
            throw ae;
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
        return auth.authenticate(userId, AuthorityId.SHOP_LISTING);
    }

    /**
     * 操作ログを記録します。
     *
     * @param ac アプリケーションコンテキスト。
     * @param inBean 更新内容。
     * @param editResult 操作結果
     */
    private void writeOperationLog(ApplicationContext ac,
            MediaInfoUpdateCompleteInServiceBean inBean, SessionStatus editResult) {
        // 操作ログ記録
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        loggingService.write(
                SystemProperties.getProperty("OP_ID_LISTING_MEDIA_INFO_UPDATE"), // 操作ID
                inBean.getUpdId(),
                editResult,
                ApplicationResources.getProperty("shop_listing.shopCd") + inBean.getShopCd(),
                this.getClass().getName());
    }
}

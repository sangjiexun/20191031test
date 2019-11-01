/*
 * $Id: AspGroupUpdateCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/24  BGT)楊恩美        新規作成
 *
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
import net.chintai.backend.sysadmin.shop_bukken.service.AspGroupUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupUpdateCommitInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.DynaActionForm;
import org.springframework.context.ApplicationContext;

/**
 * 不動産ASPグループ編集更新アクション
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupUpdateCommitAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面リロード対策
        if (!isTokenValid(context.getRequest())) {
            context.setForward("success");
            return;
        }
        resetToken(context.getRequest());

        // フォーム情報取得
        DynaActionForm form = (DynaActionForm) context.getForm();
        AspGroupUpdateCommitInServiceBean inServiceBean = new AspGroupUpdateCommitInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);
        inServiceBean.setInsId(context.getSessionBean().getUserId());
        inServiceBean.setInsPg(this.getClass().getName());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        AspGroupUpdateCommitService service =
                (AspGroupUpdateCommitService) ac.getBean("aspGroupUpdateCommitService");

        // 操作ログ記録
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");
        try {
            // グループ情報更新
            service.aspGroupUpdate(inServiceBean);

            // 更新した場合ログ登録
            loggingService.write("01005", context.getSessionBean().getUserId(),
                    SessionStatus.SUCCESS, "店舗コード"+inServiceBean.getGroupshopCd(), this.getClass().getName());

            // メッセジセット
            context.setMessage("INFO.M.SHOP_BUKKEN.0007", ApplicationResources
                    .getProperty("shop.aspGroupInfo"));
        } catch (ApplicationException e) {

            // 更新できなかった場合ログ登録
            loggingService.write("01005", context.getSessionBean().getUserId(),
                    SessionStatus.FAILURE, "店舗コード"+inServiceBean.getGroupshopCd(), this.getClass().getName());

            // メッセージセット
            context.setError("ERROR.M.USER.0004");
        }

        context.setForward("success");

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

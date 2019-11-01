/*
 * $Id: AspGroupDeleteCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/25  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_bukken.service.AspGroupDeleteCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupDeleteCommitInServiceBean;

import org.apache.struts.action.DynaActionForm;
import org.springframework.context.ApplicationContext;

/**
 * 不動産ASPグループから外す(削除)コミットアクション
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupDeleteCommitAction extends BaseActionSupport {

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
        AspGroupDeleteCommitInServiceBean inBean = new AspGroupDeleteCommitInServiceBean();
        String[] delShop = form.getStrings("groupshopCd");
        List<String> delshopList = new ArrayList<String>();
        for (int i = 0; i < delShop.length; i++) {
            delshopList.add(delShop[i]);
        }
        inBean.setDelShop(delshopList);
        inBean.setShopCd(form.getString("shopCd"));
        inBean.setAspShopSeq((Long)form.get("aspShopSeq"));
        inBean.setShopKanriUpdDt(form.getString("shopKanriUpdDt"));
        inBean.setUpdId(context.getSessionBean().getUserId());
        inBean.setUpdPg(this.getClass().getName());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        AspGroupDeleteCommitService deleteService =
                (AspGroupDeleteCommitService) ac.getBean("aspGroupDeleteCommitService");

        // 操作ログ記録
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        try {
            // グループ削除
            deleteService.aspGroupDelete(inBean);

            // 削除した場合ログ登録
            for (int i = 0; i < delShop.length; i++) {
                loggingService.write("01006", context.getSessionBean().getUserId(),
                        SessionStatus.SUCCESS, "店舗コード"+delShop[i], this.getClass().getName());
            }

            // メッセジセット
            context.setMessage("INFO.M.SHOP_BUKKEN.0008", ApplicationResources
                    .getProperty("shop.aspGroup"));
        } catch (ApplicationException ae) {

            // 削除できなかった場合ログ登録
            for (int i = 0; i < delShop.length; i++) {
                loggingService.write("01006", context.getSessionBean().getUserId(),
                        SessionStatus.FAILURE, "店舗コード"+delShop[i], this.getClass().getName());
            }
            // メッセジセット
            context.setError("ERROR.M.USER.0005");
        }

        // パラメータセット
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("shopCd", inBean.getShopCd());
        context.setForwardParameterMap(paramMap);
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

/*
 * $Id: ShopBindUpdateCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/16  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.demand.service.ShopBindUpdateCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.ShopBindUpdateCommitInServiceBean;

/**
 * 店舗の紐付先情報を更新します
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBindUpdateCommitAction extends BaseActionSupport {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面リロード対策
        if (!isTokenValid(context.getRequest())) {
            context.setForward("fail");
            return;
        }
        resetToken(context.getRequest());

        // 画面データ取得
        // String shopCd = context.getRequest().getParameter("shopCd");
        DynaValidatorForm form = (DynaValidatorForm)context.getForm();
        ShopBindUpdateCommitInServiceBean inBean = new ShopBindUpdateCommitInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 更新者設定
        inBean.setUpdId(context.getSessionBean().getUserId());

        // プログラムID設定
        inBean.setUpdPg(this.getClass().getName());

        // injection
        ApplicationContext ac = getWebApplicationContext();

        ShopBindUpdateCommitService service =
            (ShopBindUpdateCommitService) ac.getBean("shopBindUpdateCommitService");

        try {
            // 更新開始(戻り値なし、更新件数が1件以外の場合エラーを投げる)
            service.updateShopBindInfo(inBean);
        } catch (ApplicationException e) {
            context.setError("ERROR.M.DEMAND.0008");
            context.setForward("fail");
            return;
        }
        // 更新成功時、自動的にウィンドウを閉じる画面に遷移
        context.setForward("success");
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }

}

/*
 * $Id: AspGroupUpdatePageAction.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.AspGroupInfoView;
import net.chintai.backend.sysadmin.shop_bukken.service.AspGroupUpdatePageService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.DynaActionForm;
import org.springframework.context.ApplicationContext;

/**
 * 不動産ASP更新ページアクション
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupUpdatePageAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {
        // フォーム情報取得
        DynaActionForm form = (DynaActionForm) context.getForm();
        AspGroupInfoInServiceBean inBean = new AspGroupInfoInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        AspGroupUpdatePageService groupService =
                (AspGroupUpdatePageService) ac.getBean("aspGroupUpdatePageService");

        // クループ化する店舗情報取得
        AspGroupInfoOutServiceBean outBean = groupService.aspGroupUpdatePage(inBean);
        AspGroupInfoView view = new AspGroupInfoView();

        BeanUtils.copyProperties(view, outBean);
        view.setShopCd(form.getString("shopCd"));

        context.setForward("success", view);

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

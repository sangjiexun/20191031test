/*
 * $Id: AspGroupDeleteConfirmAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/25  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.AspGroupDeleteInfoView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.AspGroupDeleteInfoView.AspGroupDeleteInfoDetailView;
import net.chintai.backend.sysadmin.shop_bukken.service.AspGroupDeleteConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.DynaActionForm;
import org.springframework.context.ApplicationContext;

/**
 * 不動産ASPグループから外す確認アクション
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupDeleteConfirmAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {
        DynaActionForm form = (DynaActionForm) context.getForm();
        AspGroupInfoInServiceBean inBean = new AspGroupInfoInServiceBean();

        String[] groupshopCd = form.getStrings("groupshopCd");
        inBean.setShopCd(form.getString("shopCd"));

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        List<AspGroupInfoOutServiceBean> delList = new ArrayList<AspGroupInfoOutServiceBean>();
        List<AspGroupDeleteInfoDetailView> viewList = new ArrayList<AspGroupDeleteInfoDetailView>();

        AspGroupDeleteInfoView view = new AspGroupDeleteInfoView();

        boolean status = true;
        if (groupshopCd.length > 0) {
            for (int i = 0; i < groupshopCd.length; i++) {
                AspGroupDeleteInfoView.AspGroupDeleteInfoDetailView detailView =
                        view.new AspGroupDeleteInfoDetailView();

                inBean.setGroupshopCd(groupshopCd[i]);

                // グループする店舗情報Service呼び出し
                AspGroupDeleteConfirmService groupService =
                        (AspGroupDeleteConfirmService) ac.getBean("aspGroupDeleteConfirmService");

                // クループ化する店舗情報取得
                AspGroupInfoOutServiceBean outBean = groupService.selectGroupInfo(inBean);
                if (outBean != null) {
                    delList.add(outBean);
                    BeanUtils.copyProperties(detailView, delList.get(i));
                    detailView.setShopCd(form.getString("shopCd"));
                    viewList.add(detailView);
                    view.setShopKanriUpdDt(outBean.getShopKanriUpdDt());
                } else {
                    context.setError("ERROR.M.SHOP_BUKKEN.0004");
                    context.setForward("failure", view);
                    status = false;
                }
            }

            if (status) {
                view.setDeleteGroupList(viewList);
                // 二重更新防止トークンをセット
                saveToken(context.getRequest());
                context.setForward("success", view);
            }

        } else {

            context.setError("WARN.M.SHOP_BUKKEN.0030", ApplicationResources
                    .getProperty("shop.aspGroupDel"));
            context.setForward("failure", view);
        }

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

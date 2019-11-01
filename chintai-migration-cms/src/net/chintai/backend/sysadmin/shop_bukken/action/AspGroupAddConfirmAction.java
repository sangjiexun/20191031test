/*
 * $Id: AspGroupAddConfirmAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.AspShopInfoView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.AspShopInfoView.AspGroupListDetailView;
import net.chintai.backend.sysadmin.shop_bukken.service.AspGroupAddConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.DynaActionForm;
import org.springframework.context.ApplicationContext;

/**
 * 不動産ASPグループ設定確認アクション
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupAddConfirmAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // form情報取得
        DynaActionForm form = (DynaActionForm) context.getForm();
        AspShopInfoView view = new AspShopInfoView();
        // 親店舗の情報をまずviewにセット
        BeanUtils.copyProperties(view, form);

        AspGroupInfoInServiceBean inBean = new AspGroupInfoInServiceBean();
        inBean.setGroupshopCd(form.getString("groupshopCd"));
        inBean.setShopCd(form.getString("shopCd"));

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // グループする店舗情報Service呼び出し
        AspGroupAddConfirmService groupService = (AspGroupAddConfirmService) ac.getBean("aspGroupAddConfirmService");

        // 店舗がグループに登録されているかどうかを検索
        int cnt = groupService.selectAspGroupShopSearch(inBean);

        if (cnt > 0) {
            context.setError("WARN.M.SHOP_BUKKEN.0041");
            context.setForward("failure", view);
        } else {
            // グループ化する店舗情報取得
            List<AspGroupInfoOutServiceBean> outList = groupService.selectAspGroupAdd(inBean);
            List<AspGroupListDetailView> groupList = new ArrayList<AspGroupListDetailView>();

            if (outList.size() == 0) {
                context.setError("WARN.M.SHOP_BUKKEN.0029");
                context.setForward("failure", view);
            } else {
                for (int i = 0; i < outList.size(); i++) {
                    AspShopInfoView.AspGroupListDetailView groupDetailView = view.new AspGroupListDetailView();
                    BeanUtils.copyProperties(groupDetailView, outList.get(i));

                    groupList.add(groupDetailView);
                }
                view.setAspGroupList(groupList);

                context.setForward("success", view);
            }
        }
        // 二重更新防止トークンをセット
        saveToken(context.getRequest());

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

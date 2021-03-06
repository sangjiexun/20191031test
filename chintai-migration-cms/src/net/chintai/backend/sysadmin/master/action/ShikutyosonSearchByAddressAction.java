/*
 * $Id: ShikutyosonSearchByAddressAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.master.action.view.ShikutyosonSearchListView;
import net.chintai.backend.sysadmin.master.action.view.ShikutyosonSearchListView.ShikutyosonListDetailView;
import net.chintai.backend.sysadmin.master.service.ShikutyosonAddressSearchService;
import net.chintai.backend.sysadmin.master.service.bean.ShikutyosonAddressSearchInServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.ShikutyosonAddressSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.DynaActionForm;
import org.springframework.context.ApplicationContext;

/**
 * 市区町村検索(住所から検索)アクション
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonSearchByAddressAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面情報取得
        DynaActionForm form = (DynaActionForm) context.getForm();
        ShikutyosonAddressSearchInServiceBean inServiceBean =
                new ShikutyosonAddressSearchInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // Service呼び出し
        ShikutyosonAddressSearchService service =
                (ShikutyosonAddressSearchService) ac.getBean("shikutyosonAddressSearchService");

        // 検索結果リスト取得
        List<ShikutyosonAddressSearchOutServiceBean> outList =
                service.selectShikutyosonListByAddress(inServiceBean);

        // ViewHelper
        List<ShikutyosonListDetailView> detailViewList = new ArrayList<ShikutyosonListDetailView>();
        ShikutyosonSearchListView view = new ShikutyosonSearchListView();

        if (outList.size() > 0) {
            for (int i = 0; i < outList.size(); i++) {
                ShikutyosonSearchListView.ShikutyosonListDetailView detailView =
                        view.new ShikutyosonListDetailView();

                BeanUtils.copyProperties(detailView, outList.get(i));
                detailViewList.add(detailView);
            }
        } else {
            context.setError("WARN.M.MASTER.0014");
        }

        view.setShikutyosonList(detailViewList);

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
        return auth.authenticate(userId, AuthorityId.MASTER);
    }

}

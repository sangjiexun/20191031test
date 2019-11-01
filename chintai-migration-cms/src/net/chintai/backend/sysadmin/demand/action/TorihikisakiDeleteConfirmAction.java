/*
 * $Id: TorihikisakiDeleteConfirmAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/06  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiDeleteConfirmView;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiDeleteConfirmView.TorihikisakiDeleteConfirmDetailView;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiDeleteConfirmService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiDeleteConfirmInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiDeleteConfirmOutServiceBean;

/**
 * 取引先削除確認
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiDeleteConfirmAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        TorihikisakiDeleteConfirmInServiceBean inBean =
                new TorihikisakiDeleteConfirmInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();
        TorihikisakiDeleteConfirmService service =
                (TorihikisakiDeleteConfirmService) ac.getBean("torihikisakiDeleteConfirmService");

        List<TorihikisakiDeleteConfirmOutServiceBean> rsList =
                service.getTorihikisakiInfoForDel(inBean);

        TorihikisakiDeleteConfirmView view = new TorihikisakiDeleteConfirmView();
        List<TorihikisakiDeleteConfirmDetailView> detailList =
                new ArrayList<TorihikisakiDeleteConfirmDetailView>();
        for (int i = 0; i < rsList.size(); i++) {
            TorihikisakiDeleteConfirmOutServiceBean outBean = rsList.get(i);
            TorihikisakiDeleteConfirmDetailView detailVeiw =
                    view.new TorihikisakiDeleteConfirmDetailView();
            BeanUtils.copyProperties(detailVeiw, outBean);

            detailList.add(detailVeiw);
        }

        BeanUtils.copyProperties(view, form);
        view.setDelelteConfrimList(detailList);

        // 二重更新防止トークンをセット
        saveToken(context.getRequest());

        context.setForward("success", view);
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }

}

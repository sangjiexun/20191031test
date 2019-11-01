/*
 * $Id: TorihikisakiWakuInfoDeleteConfirmAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/09  BGT)李昊燮   新規作成
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
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiWakuInfoDeleteView;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiWakuInfoDeleteView.TorihikisakiWakuInfoDeleteDetailView;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoDeleteConfirmService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoDeleteConfirmInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoDeleteConfirmOutServiceBean;

/**
 * 取引先物件枠設定情報削除確認
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoDeleteConfirmAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        TorihikisakiWakuInfoDeleteConfirmInServiceBean inBean =
                new TorihikisakiWakuInfoDeleteConfirmInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();
        TorihikisakiWakuInfoDeleteConfirmService service =
                (TorihikisakiWakuInfoDeleteConfirmService) ac
                        .getBean("torihikisakiWakuInfoDeleteConfirmService");

        List<TorihikisakiWakuInfoDeleteConfirmOutServiceBean> rsList =
                service.getTorihikisakiWakuInfoForDelete(inBean);

        TorihikisakiWakuInfoDeleteView view = new TorihikisakiWakuInfoDeleteView();
        List<TorihikisakiWakuInfoDeleteDetailView> detailList =
                new ArrayList<TorihikisakiWakuInfoDeleteDetailView>();

        for (int i = 0; i < rsList.size(); i++) {
            TorihikisakiWakuInfoDeleteDetailView detailView =
                    view.new TorihikisakiWakuInfoDeleteDetailView();
            BeanUtils.copyProperties(detailView, rsList.get(i));
            detailView.setStartYmForDisplay(DemandUtils.convertDate(detailView.getStartYm()));
            detailList.add(detailView);
        }
        view.setDetailList(detailList);

        BeanUtils.copyProperties(view, form);

        if (inBean.getDelFlgList().length != rsList.size()) {
            context.setError("ERROR.M.DEMAND.0121");
            context.setForward("fail");
            return;
        }

        // 二重更新防止トークンをセット
        saveToken(context.getRequest());

        context.setForward("success",view);
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

/*
 * $Id: FudousanDeleteConfirmAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/04     BGT)高橋       新規作成
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
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.demand.action.view.FudousanDeleteView;
import net.chintai.backend.sysadmin.demand.action.view.FudousanDeleteView.FudousanDeleteDetailView;
import net.chintai.backend.sysadmin.demand.service.FudousanDeleteConfirmService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanDeleteConfirmInServiceBean;

/**
 * 不動産会社削除リスト取得アクション
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanDeleteConfirmAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        FudousanDeleteConfirmInServiceBean inServiceBean = new FudousanDeleteConfirmInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        FudousanDeleteConfirmService fudousanDeleteConfirmService =
                (FudousanDeleteConfirmService) ac.getBean("fudousanDeleteConfirmService");

        try {
            // 削除チェックされたリンク先の詳細を取得
            List rsList = fudousanDeleteConfirmService.fudousanDeleteConfirm(inServiceBean);

            FudousanDeleteView view = new FudousanDeleteView();

            List<FudousanDeleteView.FudousanDeleteDetailView> fudousanDeleteList =
                    new ArrayList<FudousanDeleteView.FudousanDeleteDetailView>();

            for (int i = 0; i < rsList.size(); i++) {
                FudousanDeleteDetailView detailView = view.new FudousanDeleteDetailView();
                BeanUtils.copyProperties(detailView, rsList.get(i));
                fudousanDeleteList.add(detailView);
            }
            view.setFudousanDeleteList(fudousanDeleteList);

            // 二重更新防止トークンをセット
            saveToken(context.getRequest());
            context.setForward("success", view);

        } catch (ApplicationException ae) {
            context.setError("ERROR.M.DEMAND.0080");
            context.setForward("fail");
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
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }

}

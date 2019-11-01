/*
 * $Id: TorihikisakiUpdatePageAction.java 3618 2007-12-17 12:08:24Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/05  BGT)李昊燮   新規作成
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
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiUpdateView;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiUpdatePageService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiUpdatePageOutServiceBean;

/**
 * 取引先更新ページに遷移します。
 *
 * @author lee-hosup
 * @version $Revision: 3618 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiUpdatePageAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面からデータを取得
        // 詳細画面と更新時不動産会社が変更されたか確認のためもとの検索条件を保持
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        TorihikisakiUpdatePageInServiceBean inBean = new TorihikisakiUpdatePageInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();
        TorihikisakiUpdatePageService service =
                (TorihikisakiUpdatePageService) ac.getBean("torihikisakiUpdatePageService");

        TorihikisakiUpdatePageOutServiceBean outBean;
        try {
            outBean = service.getTorihikisaki(inBean);
        } catch (ApplicationException e) {
            context.setForward("fail");
            context.setError("ERROR.M.DEMAND.0129");
            return;
        }

        TorihikisakiUpdateView view = new TorihikisakiUpdateView();
        BeanUtils.copyProperties(view, form);
        BeanUtils.copyProperties(view, outBean);

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

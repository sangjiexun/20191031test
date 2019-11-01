/*
 * $Id: FudousanSearchForRefPageAction.java 3593 2007-12-17 04:31:16Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/27  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.demand.action.view.FudousanSearchView;

/**
 * 不動産会社検索(取引先新規登録画面用)
 *
 * @author lee-hosup
 * @version $Revision: 3593 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanSearchForRefPageAction extends BaseActionSupport {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        context.getSessionBean().getSearchConditionMap().remove(
                SessionSearchKey.DEMAND_FUDOUSAN_SEARCH_FOR_REF );

        DynaValidatorForm form = (DynaValidatorForm)context.getForm();
        FudousanSearchView view = new FudousanSearchView(new BasePagerCondition());

        BeanUtils.copyProperties(view, form);

        context.setForward("success",view);
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

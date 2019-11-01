/*
 * $Id: FudousanRegisterCommitAction.java 3587 2007-12-17 02:24:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.demand.service.FudousanRegisterCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanRegisterCommitInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanSearchInServiceBean;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 不動産会社新規登録
 *
 * @author lee-hosup
 * @version $Revision: 3587 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanRegisterCommitAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面リロード対策
        if (!isTokenValid(context.getRequest())) {
            context.setForward("success");
            return;
        }
        resetToken(context.getRequest());

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        FudousanRegisterCommitInServiceBean inBean = new FudousanRegisterCommitInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 登録者情報を設定(登録プログラム、登録者ID、更新プログラム、更新者ID)
        inBean.setInsPg(this.getClass().getName());
        inBean.setUpdPg(this.getClass().getName());
        inBean.setInsId(context.getSessionBean().getUserId());
        inBean.setUpdId(context.getSessionBean().getUserId());

        // injection
        ApplicationContext ac = getWebApplicationContext();
        FudousanRegisterCommitService service =
                (FudousanRegisterCommitService) ac.getBean("fudousanRegisterCommitService");

        // 登録処理
        service.insertFudousanCompanyInfo(inBean);

        // 操作ログ記録
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        // 操作ログ記録成功場合
        loggingService.write("11002", context.getSessionBean().getUserId(), SessionStatus.SUCCESS,
                ApplicationResources.getProperty("demand.fudousanCd")
                        + (String) form.get("fudousanCd"), this.getClass().getName());

        // 登録完了メッセージ設定
        context.setMessage("INFO.M.DEMAND.0033", ApplicationResources
                .getProperty("demand.fudousanInfo"));

        // 全件検索結果に遷移
        FudousanSearchInServiceBean searchInBean = new FudousanSearchInServiceBean();
        searchInBean.setOffSet(0);
        context.getSessionBean().getSearchConditionMap().put(
                SessionSearchKey.DEMAND_FUDOUSAN_SEARCH, searchInBean);

        context.setForward("success");

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

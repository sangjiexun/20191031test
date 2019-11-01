/*
 * $Id: TorihikisakiRegisterCommitAction.java 3587 2007-12-17 02:24:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/04  BGT)李昊燮   新規作成
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
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiRegisterCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiRegisterCommitInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiSearchInServiceBean;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

/**
 * 取引先新規登録
 *
 * @author lee-hosup
 * @version $Revision: 3587 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiRegisterCommitAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        TorihikisakiRegisterCommitInServiceBean inBean =
                new TorihikisakiRegisterCommitInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 登録者ID、登録プログラム設定
        inBean.setUserId(context.getSessionBean().getUserId());
        inBean.setPgName(this.getClass().getName());

        // injection
        ApplicationContext ac = getWebApplicationContext();

        // 画面リロード対策
        if (isTokenValid(context.getRequest())) {
            resetToken(context.getRequest());

            TorihikisakiRegisterCommitService service =
                    (TorihikisakiRegisterCommitService) ac
                            .getBean("torihikisakiRegisterCommitService");

            // 操作ログ記録為、登録データPK格納用
            String insLog = "";

            // 操作ログ記録サービス
            OperationLoggingService loggingService =
                    (OperationLoggingService) ac.getBean("operationLoggingService");

            try {
                // 取引先テーブル更新
                insLog = service.insertTorihikisaki(inBean);
            } catch (ApplicationException e) {
                // 更新失敗ログ、メッセージ設定
                loggingService.write("11005", inBean.getUserId(), SessionStatus.FAILURE,
                        ApplicationResources.getProperty("demand.torihikisakiSeq") + insLog, this.getClass().getName());

                context.setError("WARN.M.DEMAND.0078", new String[] {
                    ApplicationResources.getProperty("demand.fudousan"),
                    ApplicationResources.getProperty("demand.choiceFudousan") });

                context.setForward("fail");
                return;
            }

            // 更新成功ログ、メッセージ設定
            loggingService.write("11005", inBean.getUserId(), SessionStatus.SUCCESS,
                    ApplicationResources.getProperty("demand.torihikisakiSeq") + insLog, this.getClass().getName());

            context.setMessage("INFO.M.DEMAND.0079", ApplicationResources
                    .getProperty("demand.torihikisaki"));

        }

        // 全件検索結果画面に遷移するためセッション全件検索条件を設定
        TorihikisakiSearchInServiceBean searchInBean = new TorihikisakiSearchInServiceBean();
        searchInBean.setOffSet(0);
        context.getSessionBean().getSearchConditionMap().put(
                SessionSearchKey.DEMAND_TORIHIKISAKI_SEARCH, searchInBean);


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

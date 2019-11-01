/*
 * $Id: TorihikisakiDeleteCommitAction.java 3587 2007-12-17 02:24:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/06  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import java.util.Arrays;

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
import net.chintai.backend.sysadmin.demand.service.TorihikisakiDeleteCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiDeleteCommitInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiSearchInServiceBean;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

/**
 * 取引先削除
 *
 * @author lee-hosup
 * @version $Revision: 3587 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiDeleteCommitAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        TorihikisakiDeleteCommitInServiceBean inBean = new TorihikisakiDeleteCommitInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        inBean.setUpdId(context.getSessionBean().getUserId());
        inBean.setUpdPg(this.getClass().getName());

        // injection
        ApplicationContext ac = getWebApplicationContext();

        // 操作履歴処理
        // 画面リロード対策
        if (isTokenValid(context.getRequest())) {
            resetToken(context.getRequest());

            TorihikisakiDeleteCommitService service =
                    (TorihikisakiDeleteCommitService) ac.getBean("torihikisakiDeleteCommitService");

            // 操作ログ記録為、削除IDを設定
            String delIdList = Arrays.asList(inBean.getDelFlgList()).toString();
            String delLog = delIdList.substring(1, delIdList.length() - 1);

            // 操作ログ記録サービス
            OperationLoggingService loggingService =
                    (OperationLoggingService) ac.getBean("operationLoggingService");

            try {
                // 店舗管理テーブル更新
                service.deleteTorihikisaki(inBean);
            } catch (ApplicationException e) {
                // 更新失敗ログ、メッセージ設定
                loggingService.write("11007", inBean.getUpdId(), SessionStatus.FAILURE,
                        ApplicationResources.getProperty("demand.torihikisakiSeq") + delLog, this.getClass().getName());

                context.setError("ERROR.M.DEMAND.0080", ApplicationResources
                        .getProperty("demand.torihikisaki"));
                context.setForward("fail");
                return;
            }

            // 更新成功ログ、メッセージ設定
            loggingService.write("11007", inBean.getUpdId(), SessionStatus.SUCCESS,
                    ApplicationResources.getProperty("demand.torihikisakiSeq") + delLog, this.getClass().getName());
            context.setMessage("INFO.M.DEMAND.0081", ApplicationResources
                    .getProperty("demand.torihikisaki"));

            // 全件検索結果画面に遷移するためセッション全件検索条件を設定
            TorihikisakiSearchInServiceBean searchInBean = new TorihikisakiSearchInServiceBean();
            searchInBean.setOffSet(0);
            context.getSessionBean().getSearchConditionMap().put(
                    SessionSearchKey.DEMAND_TORIHIKISAKI_SEARCH, searchInBean);

        }

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

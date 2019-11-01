/*
 * $Id: FudousanDeleteCommitAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/05     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import java.util.Arrays;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.demand.service.FudousanDeleteCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanDeleteCommitInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanSearchInServiceBean;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 不動産会社削除アクション
 *
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanDeleteCommitAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
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

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        FudousanDeleteCommitInServiceBean inServiceBean = new FudousanDeleteCommitInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // 不動産会社コード取得
        String[] fudousanCds = (String[]) form.get("fudousanCd");

        // 更新者情報を設定(更新プログラム、更新者ID)
        inServiceBean.setUpdId(context.getSessionBean().getUserId());
        inServiceBean.setUpdPg(this.getClass().getName());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        FudousanDeleteCommitService fudousanDeleteCommitService =
                (FudousanDeleteCommitService) ac.getBean("fudousanDelteCommitService");

        // 操作ログ記録
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        // 操作ログ記録為、削除IDを設定
        String delIdList = Arrays.asList(fudousanCds).toString();
        String delLog = delIdList.substring(1, delIdList.length() - 1);

        try {
            // 不動産会社削除
            fudousanDeleteCommitService.fudousanDeleteCommit(inServiceBean);
        } catch (ApplicationException ae) {

            // 操作ログ記録失敗の場合
            loggingService.write("11004", context.getSessionBean().getUserId(),
                    SessionStatus.FAILURE, ApplicationResources.getProperty("demand.fudousanInfo")
                            + delLog, this.getClass().getName());

            // メッセージ設定
            context.setError("ERROR.M.DEMAND.0047");
            context.setForward("fail");
            return;

        }

        // 操作ログ記録成功の場合
        loggingService.write("11004", context.getSessionBean().getUserId(), SessionStatus.SUCCESS,
                ApplicationResources.getProperty("demand.fudousanInfo") + delLog, this.getClass().getName());
        // メッセージ設定
        context.setMessage("INFO.M.DEMAND.0048", ApplicationResources
                .getProperty("demand.fudousanInfo"));

        // 全件検索結果に遷移
        FudousanSearchInServiceBean searchInBean = new FudousanSearchInServiceBean();
        searchInBean.setOffSet(0);
        context.getSessionBean().getSearchConditionMap().put(
                SessionSearchKey.DEMAND_FUDOUSAN_SEARCH, searchInBean);

        context.setForward("success");

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

/*
 * $Id: TorihikisakiWakuInfoDeleteCommitAction.java 3690 2007-12-21 05:23:35Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/10  BGT)李昊燮   新規作成
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
import net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoDeleteCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoDeleteCommitInServiceBean;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;

/**
 * 取引先物件枠設定情報削除
 *
 * @author lee-hosup
 * @version $Revision: 3690 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoDeleteCommitAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        context.setForward("success");

        // 画面リロード対策
        if (!isTokenValid(context.getRequest())) {
            return;
        }

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        TorihikisakiWakuInfoDeleteCommitInServiceBean inBean =
                new TorihikisakiWakuInfoDeleteCommitInServiceBean();
        BeanUtils.copyProperties(inBean, form);


        inBean.setUpdId(context.getSessionBean().getUserId());
        inBean.setUpdPg(this.getClass().getName());

        // injenction
        ApplicationContext ac = getWebApplicationContext();
        TorihikisakiWakuInfoDeleteCommitService service =
                (TorihikisakiWakuInfoDeleteCommitService) ac
                        .getBean("torihikisakiWakuInfoDeleteCommitService");

        // 操作ログ記録為、削除IDを設定
        String delIdList = Arrays.asList(inBean.getDelFlgList()).toString();
        String delLog = ApplicationResources.getProperty("demand.torihikisakiSeq")
                      + inBean.getTorihikisakiSeq()
                      + ApplicationResources.getProperty("demand.applyYm")
                      + delIdList.substring(1, delIdList.length() - 1);

        // 操作ログ記録サービス
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        try {
            // 店舗管理テーブル更新
            service.deleteWakuInfo(inBean);
        } catch (ApplicationException e) {
            // 更新失敗ログ、メッセージ設定
            loggingService.write("11007", inBean.getUpdId(), SessionStatus.FAILURE, delLog, this.getClass().getName());

            context.setError("ERROR.M.DEMAND.0080");
            return;
        }

        // 更新成功ログ、メッセージ設定
        loggingService.write("11007", inBean.getUpdId(), SessionStatus.SUCCESS, delLog, this.getClass().getName());
        context.setMessage("INFO.M.DEMAND.0081", ApplicationResources
                .getProperty("demand.wakuInfo"));

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

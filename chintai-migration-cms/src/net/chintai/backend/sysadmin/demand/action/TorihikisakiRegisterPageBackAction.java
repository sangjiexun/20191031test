/*
 * $Id: TorihikisakiRegisterPageBackAction.java 3591 2007-12-17 04:09:45Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/29  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiRegisterView;


/**
 * 取引先ページに戻るアクション。
 *
 * @author lee-hosup
 * @version $Revision: 3591 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiRegisterPageBackAction extends BaseActionSupport {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        TorihikisakiRegisterView view = new TorihikisakiRegisterView();

        if (form != null) {
            BeanUtils.copyProperties(view, form);
        }

        // 適用年月プルダウン生成に使うデータを設定
        view.setApplyYearList(DemandUtils.getYearList());
        view.setApplyMonthList(DemandUtils.getMonthsList());

        // 適用月のValidationCheckのため現在日付をViewに設定
        String nowDate = DateUtil.getToday("yyyyMM");
        view.setNowDate(nowDate);

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

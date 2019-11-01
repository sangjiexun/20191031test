/*
 * $Id: ContractAmountMaintenancePageAction.java 4652 2013-10-09 08:07:53Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
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
import net.chintai.backend.sysadmin.demand.action.view.ContractAmountMaintenanceView;
import net.chintai.backend.sysadmin.demand.service.bean.ContractAmountMaintenanceDownloadInServiceBean;


/**
 * 物件枠数・物件リスティング枠数のCSVダウンロード・アップロード画面表示アクション
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountMaintenancePageAction extends BaseActionSupport {


    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

    	// トークンの生成
        saveToken(context.getRequest());

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ContractAmountMaintenanceDownloadInServiceBean inServiceBean = new ContractAmountMaintenanceDownloadInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();

        // 取得した検索条件とページング状態をViewHelperにセットする。
        ContractAmountMaintenanceView view = new ContractAmountMaintenanceView(condition);
        BeanUtils.copyProperties(view, form);

        context.setForward("success", view);

    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }

}

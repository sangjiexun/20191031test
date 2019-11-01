/*
 * $Id: TorihikisakiWakuInfoUpdatePageBackAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/11  BGT)李昊燮   新規作成
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
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiWakuInfoUpdateView;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiInfoService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoOutServiceBean;

/**
 *
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoUpdatePageBackAction extends BaseActionSupport {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {


        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        TorihikisakiInfoInServiceBean inBean = new TorihikisakiInfoInServiceBean();
        inBean.setTorihikisakiSeq(context.getRequest().getParameter("torihikisakiSeq"));

        // injection
        ApplicationContext ac = getWebApplicationContext();
        TorihikisakiInfoService service =
                (TorihikisakiInfoService) ac.getBean("torihikisakiInfoService");

        // 取引先詳細照会
        TorihikisakiInfoOutServiceBean outBean = service.getTorihikisakiDetailInfo(inBean);

        TorihikisakiWakuInfoUpdateView view = new TorihikisakiWakuInfoUpdateView();
        BeanUtils.copyProperties(view, outBean);
        BeanUtils.copyProperties(view, form);

        // 郵便番号画面表示形式に編集
        view.setZipCd(DemandUtils.convertZipCd(view.getZipCd()));

        context.setForward("success", view);
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

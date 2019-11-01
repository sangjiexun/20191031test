/*
 * $Id: CjnUserInfoAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/12  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnUserInfoView;
import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnUserInfoView.CjnUserAccountViewDetail;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserInfoService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAccountOutServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserInfoInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserInfoOutServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 問い合せユーザ詳細アクション。
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserInfoAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データを Bean にセット
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        CjnUserInfoInServiceBean inServiceBean = new CjnUserInfoInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        CjnUserInfoService service = (CjnUserInfoService) ac.getBean("cjnUserInfoService");

        // 問い合せユーザ詳細情報取得
        CjnUserInfoOutServiceBean outServiceBean = service.selectCjnUser(inServiceBean);

        // 問い合せユーザ権限取得
        List<CjnUserAccountOutServiceBean> accountList = service.cjnAccountLevelList(inServiceBean);

        // ViewHelperにセット
        CjnUserInfoView view = new CjnUserInfoView();
        List<CjnUserAccountViewDetail> viewList = new ArrayList<CjnUserInfoView.CjnUserAccountViewDetail>();

        if (accountList != null) {
            for (int i = 0; i < accountList.size(); i++) {
                CjnUserAccountViewDetail accountViewDetail = view.new CjnUserAccountViewDetail();
                
                BeanUtils.copyProperties(accountViewDetail, accountList.get(i));
                viewList.add(accountViewDetail);
            }
            view.setUserAccountList(viewList);
        }
        BeanUtils.copyProperties(view, outServiceBean);
        
        context.setForward("success", view);

    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.CJN_INQUIRY) && auth.isAdminCjnAccountType(userId);
    }

}

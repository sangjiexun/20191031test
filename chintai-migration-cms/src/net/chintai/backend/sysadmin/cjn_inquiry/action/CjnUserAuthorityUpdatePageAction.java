/*
 * $Id: CjnUserAuthorityUpdatePageAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.DynaActionForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnUserAuthorityUpdateView;
import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnUserAuthorityUpdateView.CjnUserAccountViewDetail;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserAuthorityUpdatePageService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserInfoService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAuthorityUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAuthorityUpdatePageOutServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserInfoInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserInfoOutServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;

/**
 * 問い合わせ閲覧可能権限変更アクション
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAuthorityUpdatePageAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaActionForm form = (DynaActionForm) context.getForm();
        CjnUserAuthorityUpdatePageInServiceBean inBean =
                new CjnUserAuthorityUpdatePageInServiceBean();
        CjnUserInfoInServiceBean inServiceBean = new CjnUserInfoInServiceBean();
        inServiceBean.setCjnAccountSeq(form.getString("cjnAccountSeq"));
        inBean.setCjnAccountSeq(form.getString("cjnAccountSeq"));

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        CjnUserAuthorityUpdatePageService service =
                (CjnUserAuthorityUpdatePageService) ac.getBean("cjnUserAuthorityUpdatePageService");
        
        CjnUserInfoService userInfoService = (CjnUserInfoService) ac.getBean("cjnUserInfoService");

        // 問い合せユーザ詳細情報取得
        CjnUserInfoOutServiceBean outServiceBean = userInfoService.selectCjnUser(inServiceBean);
        
        //最終更新日時取得
        String lastDt = service.selectLastUpdateDt(inBean);
        
        // Listにセット
        List<CjnUserAuthorityUpdatePageOutServiceBean> outList =
                service.selectCjnAccountLevel(inBean);
        List<CjnUserAccountViewDetail> viewList = new ArrayList<CjnUserAccountViewDetail>();
        CjnUserAuthorityUpdateView view = new CjnUserAuthorityUpdateView();

        // viewHelperにセット
        if (outList != null) {
            for (int i = 0; i < outList.size(); i++) {
                CjnUserAccountViewDetail viewDetail = view.new CjnUserAccountViewDetail();
                BeanUtils.copyProperties(viewDetail, outList.get(i));
                viewList.add(viewDetail);
            }
        }
        view.setUserAccountList(viewList);
        
        view.setUserId(outServiceBean.getUserId());
        view.setUserName(outServiceBean.getUserName());
        view.setCjnAccountSeq(outServiceBean.getCjnAccountSeq());
        view.setUpdDt(lastDt);

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

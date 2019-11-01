/*
 * $Id: CjnUserAuthorityUpdatePageBackAction.java 3715 2007-12-26 07:44:21Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/18  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnUserAuthorityUpdateView;
import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnUserAuthorityUpdateView.CjnUserAccountViewDetail;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserAuthorityUpdatePageService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAuthorityUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAuthorityUpdatePageOutServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.DynaActionForm;
import org.springframework.context.ApplicationContext;

/**
 * 問い合わせ閲覧可能権限変更ページBackアクション
 * @author Yang-EunMi
 * @version $Revision: 3715 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAuthorityUpdatePageBackAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {
        
        // 画面データ取得
        DynaActionForm form = (DynaActionForm) context.getForm();
        CjnUserAuthorityUpdatePageInServiceBean inBean = new CjnUserAuthorityUpdatePageInServiceBean();
        inBean.setCjnAccountSeq(form.getString("cjnAccountSeq"));

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        CjnUserAuthorityUpdatePageService service =
                (CjnUserAuthorityUpdatePageService) ac.getBean("cjnUserAuthorityUpdatePageService");

        // Listにセット
        List<CjnUserAuthorityUpdatePageOutServiceBean> outList = service.selectCjnAccountLevel(inBean);
        List<CjnUserAccountViewDetail> viewList = new ArrayList<CjnUserAccountViewDetail>();


        // Setにセット
        Integer[] cjnInqKindSeq = (Integer[]) form.get("cjnInqKindSeq");
        Set<Integer> inqKindSeqSet = new HashSet<Integer>();
        for (int i = 0; i < cjnInqKindSeq.length; i++) {
            inqKindSeqSet.add(cjnInqKindSeq[i]);
        }

        // viewHelperにセット
        CjnUserAuthorityUpdateView view = new CjnUserAuthorityUpdateView();
        
        if (outList != null) {
            for (int i = 0; i < outList.size(); i++) {
                CjnUserAccountViewDetail viewDetail = view.new CjnUserAccountViewDetail();
                BeanUtils.copyProperties(viewDetail, outList.get(i));

                if (inqKindSeqSet.contains(viewDetail.getCjnInqKindSeq())) {
                    viewDetail.setCnt(1);
                } else {
                    viewDetail.setCnt(0);
                }

                viewList.add(viewDetail);
            }
        }
        view.setUserAccountList(viewList);
        view.setUserId(form.getString("userId"));
        view.setUserName(form.getString("userName"));
        view.setCjnAccountSeq(form.getString("cjnAccountSeq"));
        view.setUpdDt(form.getString("updDt"));

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
